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

public class PhotoDao {
	
private static PhotoDao instance;
	
	private PhotoDao() {
	}
	
	public static PhotoDao getInstance() {
		if(instance==null) {
			instance = new PhotoDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn=null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn=ds.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public int getTotalCnt() throws SQLException {
		int totCnt = 0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from board where b_category=2 and re_level=0";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) totCnt=rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return totCnt;
	}

	public List<Board> photoList(int startRow, int endRow) throws SQLException {
		List<Board> list = null;
		Board board = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "select * from (select rownum rn, list.* from (select b.*, p.id id from board b, profile p "
				+ "where b.mem_num=p.mem_num and b.b_category=2 and b.re_level=0 order by b.free_num desc, b.b_date desc) list)"
				+ "where rn between ? and ?";
		String sql2 = "select count(*) from board where ref=? and re_level>0";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Board>();
				do {
					board = new Board();
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
					
					pstmt2=conn.prepareStatement(sql2);
					pstmt2.setInt(1, rs.getInt("free_num"));
					rs2 = pstmt2.executeQuery();
					if(rs2.next()) board.setRe_count(rs2.getInt(1));
					rs2.close();
					pstmt2.close();
					list.add(board);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return list;
	}

	public Board select(int free_num) throws SQLException {
		Board board = null;
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select b.*, p.id from board b, profile p where b.mem_num = p.mem_num and b.free_num=?";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board();
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return board;
	}

	public List<Board> getReply(int free_num) throws SQLException {
		List<Board> list = null;
		Board board = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select b.*, p.id id from board b, profile p where ref=? and re_step>0 and b.mem_num=p.mem_num order by re_step";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Board>();
				do {
					board = new Board();
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
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return list;
	}

	public void viewUp(int free_num) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update board set b_view=b_view+1 where free_num=?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}

	public int updatePhoto(Board board) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update board set b_photo=?, b_title=?, b_content=? where free_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_photo());
			pstmt.setString(2, board.getB_title());
			pstmt.setString(3, board.getB_content());
			pstmt.setInt(4, board.getFree_num());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return result;
	}

	public int photodelete(int free_num) throws SQLException {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from board where ref=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return result;
	}

	public int photoInsert(Board board) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into board values((select nvl(max(free_num),0) from board)+1,?,2,?,to_char(sysdate,'yyyy-mm-dd')"
				+ ",0,?,?,0,(select nvl(max(free_num),0) from board)+1,0,0)";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, board.getMem_num());
			pstmt.setString(2, board.getB_title());
			pstmt.setString(3, board.getB_content());
			pstmt.setString(4, board.getB_photo());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return result;
	}

	public void replyInsert(Board board) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into board values((select nvl(max(free_num),0) from board)+1,?,2,'갤러리 답변',to_char(sysdate,'yyyy-mm-dd')"
				+ ",0,?,null,0,?,(select nvl(max(re_step),0) from board where ref=?)+1,1)";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, board.getMem_num());
			pstmt.setString(2, board.getB_content());
			pstmt.setInt(3, board.getFree_num());
			pstmt.setInt(4, board.getFree_num());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}

	public Board selectReply(int free_num) throws SQLException {
		Board board = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql = "select b.*, p.id id from board b, profile p where b.mem_num=p.mem_num and free_num=?";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board = new Board();
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return board;
	}

	public void updatePhotoRe(int free_num, String b_content) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update board set b_content=? where free_num=?";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b_content);
			pstmt.setInt(2, free_num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}

	public void photoReDelete(int free_num) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from board where free_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}

	public int rcSelect(int mem_num, int free_num) throws SQLException {
		int rcCount = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select count(*) from board where mem_num=? and ref=? and re_step=-1 and re_level=-1";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, free_num);
			rs=pstmt.executeQuery();
			if(rs.next()) rcCount=rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return rcCount;
	}

	public int rcInsert(int mem_num, int free_num) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt =null;
		String sql = "insert into board values((select nvl(max(free_num),0) from board)+1,"
				+ " ?,2,'rcCount',to_char(sysdate,'yyyy-mm-dd'),0,'rcCount',null,0,?,-1,-1)";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, free_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}

	public void rcUpdate(int free_num) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update board set b_rc_cnt = b_rc_cnt+1 where free_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			int result2 = pstmt.executeUpdate();
			System.out.println("@@@@업데이트 성공?실패?"+result2);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}
}
