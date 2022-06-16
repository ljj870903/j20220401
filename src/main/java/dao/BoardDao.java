package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//프로젝트 통합본
public class BoardDao {
	private static BoardDao instance;

	public BoardDao() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 게시글 수 원글만 댓글은x
	public int getTotalCnt(int b_category) throws SQLException {
		int tot = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from  board where b_category = ? and re_step =0";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_category);
			rs = pstmt.executeQuery();
			System.out.println("sql : " + sql);

			if (rs.next())
				tot = rs.getInt(1);
			System.out.println("tot : " + tot);
		} catch (Exception e) {
			System.out.println("getTotalCnt(BoardDao)" + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return tot;
	}

	// 원글만 뿌려주는 list메소드
	// 카테고리는 임의로 설정 가능
	public List<Board> boardList(int b_category, int startRow, int endRow) throws SQLException {
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from("
				+ " select rownum rn, list.* from"
				+ "(select p.id, b.* from (select * from board where b_category=? and re_step=0) b,"
				+ " profile p where p.mem_num=b.mem_num order by b.b_date desc, ref desc) list)"
				+ "where rn between ? and ?";
		


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					Board board = new Board();
					board.setFree_num(rs.getInt("free_num"));
					board.setMem_num(rs.getInt("mem_num"));
					board.setB_category(rs.getInt("b_category"));
					board.setB_title(rs.getString("b_title"));
					board.setB_date(rs.getString("b_date"));
					board.setB_view(rs.getInt("b_view"));
					board.setB_content(rs.getString("b_content"));
					board.setB_photo(rs.getString("b_photo"));
					board.setB_rc_cnt(rs.getInt("b_rc_cnt"));
					board.setRef(rs.getInt("ref"));
					board.setRe_step(rs.getInt("re_step"));
					board.setRe_level(rs.getInt("re_level"));
					board.setId(rs.getString("id"));
					list.add(board);

				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("boardList(BoardDao) : " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}
	//조회수 올리는 메소드 b_view+1
	public void b_view(int free_num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set b_view = b_view+1 where free_num =?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("b_view(BoardDao) : " + e.getMessage());
		} finally {

			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}
	//게시글 하나만 select id도 가져옴
	public Board select(int free_num) throws SQLException {
		Board board = new Board();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select  p.id ,b.*\r\n"
				+ "        from board b, profile p\r\n"
				+ "                where  p.mem_num=b.mem_num\r\n"
				+ "                and free_num = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setFree_num(rs.getInt("free_num"));
				board.setMem_num(rs.getInt("mem_num"));
				board.setB_category(rs.getInt("b_category"));
				board.setB_title(rs.getString("b_title"));
				board.setB_date(rs.getString("b_date"));
				board.setB_view(rs.getInt("b_view"));
				board.setB_content(rs.getString("b_content"));
				board.setB_photo(rs.getString("b_photo"));
				board.setB_rc_cnt(rs.getInt("b_rc_cnt"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
				board.setId(rs.getString("id"));
				
			}
		} catch (Exception e) {
			System.out.println("select(BoardDao) : " + e.getMessage());
		}finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return board;
	}
	//게시글 추가하기
	public int insert(Board board) throws SQLException {
		int result = 0;
		int free_num = board.getFree_num();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql1 = "select nvl(max(free_num),0) from board";
		String sql = "insert into board values(?,?,?,?,to_char(sysdate, 'yyyy-mm-dd'),?,?,?,?,?,?,?)";
		String sql2 = "update board set re_step = re_step+1 where ref=? and re_step>?";
		try {
			conn = getConnection();
			// 댓글 일 경우
			if (free_num != 0) {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, board.getRef());
				pstmt.setInt(2, board.getRe_step());
				pstmt.executeUpdate();
				pstmt.close();
				board.setRe_step(board.getRe_step() + 1);
				board.setRe_level(board.getRe_level() + 1);
				System.out.println("DAO insert board.getRef()->" + board.getRef());
				System.out.println("DAO insert board.getRe_step()->" + board.getRe_step());
				System.out.println("DAO insert board.getRe_level()->" + board.getRe_level());
			}
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			// key인 num 1씩 증가 mysql auto_increment 또는 oracle sequence
			// sequence를 사용 : values(시퀀스명(board_seq).nextval,?,/...)
			int number = rs.getInt(1) + 1;
			rs.close();
			pstmt.close();

			// 원글이면...
			if (free_num == 0)
				board.setRef(number);
			// 댓글 / 원글이면...
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setInt(2, board.getMem_num());
			pstmt.setInt(3, board.getB_category());
			pstmt.setString(4, board.getB_title());
			pstmt.setInt(5, board.getB_view());
			pstmt.setString(6, board.getB_content());
			pstmt.setString(7, board.getB_photo());
			pstmt.setInt(8, board.getB_rc_cnt());
			pstmt.setInt(9, board.getRef());
			pstmt.setInt(10, board.getRe_step());
			pstmt.setInt(11, board.getRe_level());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insert(BoardDao)  : " + e.getMessage());
		} finally {

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return result;
	}

	//원글 삭제 시 같은그룹의 댓글까지 삭제하는 delete
	public int delete(int free_num) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where ref=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			result = pstmt.executeUpdate();
			System.out.println("result : "+result);
		} catch (SQLException e) {
			System.out.println("delete(BoardDao)" + e.getMessage());
		}finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		

		return result;
	}


	//댓글수 count
	public int getTotalCnt2(int free_num) throws SQLException {
		int totCnt1 = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) \r\n"
				+ "from board\r\n"
				+ "where ref=? \r\n"
				+ "and re_step>0";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs = pstmt.executeQuery();
			if(rs.next()) totCnt1 = rs.getInt(1);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return totCnt1;
	}
	//글 번호가 free_num인 게시글에 대한 댓글리스트
	public List<Board> select2(int free_num) throws SQLException {
		List<Board> replyList = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select  p.id ,b.*\r\n"
				+ "from   (select *\r\n"
				+ "        from  board \r\n"
				+ "        where b_category = 1\r\n"
				+ "        and   re_step > 0 and ref=? order by re_step ) b, \r\n"
				+ "    profile p\r\n"
				+ "where  p.mem_num=b.mem_num \r\n";
		
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					Board board = new Board();
					board.setFree_num(rs.getInt("free_num"));
					board.setMem_num(rs.getInt("mem_num"));
					board.setB_category(rs.getInt("b_category"));
					board.setB_title(rs.getString("b_title"));
					board.setB_date(rs.getString("b_date"));
					board.setB_view(rs.getInt("b_view"));
					board.setB_content(rs.getString("b_content"));
					board.setB_photo(rs.getString("b_photo"));
					board.setB_rc_cnt(rs.getInt("b_rc_cnt"));
					board.setRef(rs.getInt("ref"));
					board.setRe_step(rs.getInt("re_step"));
					board.setRe_level(rs.getInt("re_level"));
					board.setId(rs.getString("id"));
					replyList.add(board);
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return replyList;
	}
	//댓글만 삭제
	public int delete2(int reply_free_num) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where free_num=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply_free_num);
			result = pstmt.executeUpdate();
			System.out.println("result : "+result);
		} catch (SQLException e) {
			System.out.println("delete2(BoardDao)" + e.getMessage());
		}finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}


	//게시글 수정
	public int update(Board board) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set b_title=?, b_content=?, b_photo=? where free_num =?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, board.getB_photo());
			pstmt.setInt(4, board.getFree_num());

			result = pstmt.executeUpdate();
			System.out.println("update!!");

		} catch (Exception e) {
			System.out.println("update(BoardDao) : " + e.getMessage());
		} finally {

			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		
		return result;
	}
	//게시글 수정 2
	public int update2(Board board) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set b_title=?, b_content=? where free_num =?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setInt(3, board.getFree_num());

			result = pstmt.executeUpdate();
			System.out.println("update22!!");

		} catch (Exception e) {
			System.out.println("update2(BoardDao) : " + e.getMessage());
		} finally {

			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		
		return result;
	}
	//게시글 수정 3
	public int update3(Board board) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set b_title=?, b_content=? , b_photo=null where free_num =?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setInt(3, board.getFree_num());

			result = pstmt.executeUpdate();
			System.out.println("update3!!");

		} catch (Exception e) {
			System.out.println("update2(BoardDao) : " + e.getMessage());
		} finally {

			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		
		return result;
	}
	//댓글insert메소드 -->  제목을 '자유게시판 답변'으로 설정
	public int insert2(Board board) throws SQLException {
		int result = 0;
		int free_num = board.getFree_num();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql1 = "select nvl(max(free_num),0) from board";
		String sql = "insert into board values(?,?,1,'[자유게시판 댓글]',to_char(sysdate, 'yyyy-mm-dd'),?,?,null,?,?,?,?)";
		String sql2 = "update board set re_step = re_step+1 where ref=? and re_step>?";
		try {
			conn = getConnection();
			// 댓글 일 경우
			if (free_num != 0) {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, board.getRef());
				pstmt.setInt(2, board.getRe_step());
				pstmt.executeUpdate();
				pstmt.close();
				board.setRe_step(board.getRe_step() + 1);
				board.setRe_level(board.getRe_level() + 1);
				System.out.println("DAO insert2 board.getRef()->" + board.getRef());
				System.out.println("DAO insert2 board.getRe_step()->" + board.getRe_step());
				System.out.println("DAO insert2 board.getRe_level()->" + board.getRe_level());
			}
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			// key인 num 1씩 증가 mysql auto_increment 또는 oracle sequence
			// sequence를 사용 : values(시퀀스명(board_seq).nextval,?,/...)
			int number = rs.getInt(1) + 1;
			rs.close();
			pstmt.close();

			// 원글이면...
			if (free_num == 0)
				board.setRef(number);
			// 댓글 / 원글이면...
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setInt(2, board.getMem_num());
			pstmt.setInt(3, board.getB_view());
			pstmt.setString(4, board.getB_content());
			pstmt.setInt(5, board.getB_rc_cnt());
			pstmt.setInt(6, board.getRef());
			pstmt.setInt(7, board.getRe_step());
			pstmt.setInt(8, board.getRe_level());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insert2(BoardDao)  : " + e.getMessage());
		} finally {

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return result;
	}
	//ajax사용할때 update메소드 댓글내용 입력시에 내용만 update하기
	public void updateFreeRe(int free_num, String b_content) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update board set b_content=? where free_num = ?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b_content);
			pstmt.setInt(2, free_num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateFreeRe(BoardDao)  : " + e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}
}
