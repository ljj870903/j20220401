package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ReservationDao {
	// 인스턴스
	private static ReservationDao instance;

	private ReservationDao() {
	}

	public static ReservationDao getinstance() {
		if (instance == null) {
			instance = new ReservationDao();
		}
		return instance;
	}

	// 겟getConnection
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

	// reslist 게시글 총합 구하기
	public int getTotalCnt() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int tot = 0;
		String sql = "select count(*) from reservation where res_status=1";

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return tot;
	}

	// 리스트 조회하기
	public List<Reservation> list(int startRow, int endRow) throws SQLException {
		List<Reservation> list = new ArrayList<Reservation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from"
				+ " (select rownum rn , tot.* from "
				+ " (select list.*, c.name res_st from ( select p.name ,p.address,r.* "
				+ " from "
				+ "        (select*from Reservation where res_status=1 ) r, profile p "
				+ "where  p.mem_num=r.mem_num ORDER by res_num desc ) list, (select * from code where bcd=300) c "
				+ "where list.res_status=c.mcd) tot)"
				+ "where rn between ? and ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reservation re = new Reservation();
				// address 두번째 주소 뽑기
				String bdaddress = rs.getString("address");
				String[] add = bdaddress.split(" ");
				// System.out.println(add[1]);
				re.setRes_num(rs.getInt("res_num"));
				re.setMem_num(rs.getInt("mem_num"));
				re.setPet_num(rs.getInt("pet_num"));
				re.setPs_num(rs.getInt("ps_num"));
				re.setRes_date(rs.getString("res_date"));
				re.setRes_status(rs.getString("res_status"));
				re.setSit_date(rs.getString("sit_date"));
				re.setSit_start(rs.getString("sit_start"));
				re.setSit_end(rs.getString("sit_end"));
				re.setRequest(rs.getString("request"));
				// 프로필 네임 뽑기
				re.setName(rs.getString("name"));
				// 주소 배열넣어서 뽑기
				re.setAddress(add[1]);
				re.setRes_st(rs.getString("res_st"));
				
				list.add(re);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return list;
	}
	//상세보기 조회하기 
	public Reservation select(int res_num,int mem_num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select list.*, c.name res_st"
				+ "                from ( select*from (select  p.name ,p.address,r.*,con.*"
				+ "                from (select*from Reservation) r, (select COUNT(*) count from petinfo where mem_num=(select mem_num from reservation where res_num=?)) con,"
				+ "                      profile p where  p.mem_num=r.mem_num order by res_num desc) a ) list, "
				+ "                     (select * from code where bcd=300) c where list.res_status=c.mcd and res_num=?";
		Reservation re = new Reservation();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, res_num);
			pstmt.setInt(2, res_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bdaddress = rs.getString("address");
				String[] add = bdaddress.split(" ");
				re.setRes_num(rs.getInt("res_num"));
				// 프로필 네임 뽑기
				re.setName(rs.getString("name"));
				re.setRes_date(rs.getString("res_date"));
				re.setSit_date(rs.getString("sit_date"));
				re.setSit_start(rs.getString("sit_start"));
				re.setSit_end(rs.getString("sit_end"));
				// 주소 배열넣어서 뽑기
				re.setAddress(add[1]);
				re.setRes_status(rs.getString("res_status"));
				re.setRequest(rs.getString("request"));
				re.setMem_num(rs.getInt("mem_num"));
				re.setPet_num(rs.getInt("pet_num"));
				re.setPs_num(rs.getInt("ps_num"));
				re.setRes_st(rs.getString("res_st"));
				re.setCount(rs.getInt("count"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}

		return re;
	}
	
	//예약하기 리스트 삽입
	public int insert(Reservation re) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "insert into reservation values ((select nvl(max(res_num),0) from reservation)+1,?,(select min(pet_num) from petinfo where mem_num=?),null, to_char(sysdate,'yyyy-mm-dd'),1,?,"
				+ "?,?,?)";
		String sql1 = "select nvl(max(res_num),0) from reservation where mem_num=?";
		int result = 0;
		int res_num = 0;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, re.getMem_num());
			pstmt.setInt(2, re.getMem_num());
			pstmt.setString(3, re.getSit_date());
			pstmt.setString(4, re.getSit_start());
			pstmt.setString(5, re.getSit_end());
			pstmt.setString(6, re.getRequest());
			result = pstmt.executeUpdate();
			pstmt.close();
			if(result>0) {
				pstmt=conn.prepareStatement(sql1);
				pstmt.setInt(1, re.getMem_num());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					res_num = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(conn !=null) conn.close();
			if(pstmt !=null) pstmt.close();
		}
		return res_num;
	}
	
	//펫시터 예약하기 승인
	public int approval(int mem_num, int res_num) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql ="update RESERVATION set ps_num=?,res_status=2 where res_num=?";
		int result =0;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, res_num);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(conn !=null) conn.close();
			if(pstmt !=null) pstmt.close();
		}
			return result;
	}

	//이용내역 게시글 총합 
	public int getuserTotalCnt(int mem_num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int tot = 0;
		String sql = "select count(*) from reservation where mem_num=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	//이용내역 게시글 리스트 조회
	public List<Reservation> userlist(int startRow, int endRow,int mem_num) throws SQLException {
		List<Reservation> list = new ArrayList<Reservation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "
				+ "(select rownum rn, list2.* from  "
				+ "(select list.*, c.name res_st from "
				+ "(select res.*, p.name, p.address from reservation res, profile p where res.mem_num=p.mem_num and res.mem_num=?) list, "
				+ "(select * from code where bcd=300) c "
				+ "where list.res_status=c.mcd order by list.res_num desc) list2) "
				+ "where rn between ? and ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reservation re = new Reservation();
				// address 두번째 주소 뽑기
				String bdaddress = rs.getString("address");
				String[] add = bdaddress.split(" ");
				// System.out.println(add[1]);
				re.setRes_num(rs.getInt("res_num"));
				re.setMem_num(rs.getInt("mem_num"));
				re.setPet_num(rs.getInt("pet_num"));
				re.setPs_num(rs.getInt("ps_num"));
				re.setRes_date(rs.getString("res_date"));
				re.setRes_status(rs.getString("res_status"));
				re.setSit_date(rs.getString("sit_date"));
				re.setSit_start(rs.getString("sit_start"));
				re.setSit_end(rs.getString("sit_end"));
				re.setRequest(rs.getString("request"));
				// 프로필 네임 뽑기
				re.setName(rs.getString("name"));
				// 주소 배열넣어서 뽑기
				re.setAddress(add[1]);
				re.setRes_st(rs.getString("res_st"));
				
				list.add(re);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return list;
	}
	//이용내역 게시글 수정
	public int update(Reservation re) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql ="update RESERVATION set sit_date=?,sit_start=?,sit_end=?,request=? where mem_num=? and res_num=?";
		int result =0;
		System.out.println("re.getSit_date() : "+re.getSit_date());
		System.out.println("re.getSit_start() : "+re.getSit_start());
		System.out.println("re.getSit_end() : "+re.getSit_end());
		System.out.println("re.getRequest() : "+re.getRequest());
		System.out.println("re.getMem_num() : "+re.getMem_num());
		System.out.println("re.getRes_num() : "+re.getRes_num());
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, re.getSit_date());
			pstmt.setString(2, re.getSit_start());
			pstmt.setString(3, re.getSit_end());
			pstmt.setString(4, re.getRequest());
			pstmt.setInt(5, re.getMem_num());
			pstmt.setInt(6, re.getRes_num());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(conn !=null) conn.close();
			if(pstmt !=null) pstmt.close();
		}
			return result;
	}
	//삭제
		public int delete(int res_num) throws SQLException {
			Connection conn=null;
			PreparedStatement pstmt = null;
			int result =0;
			String sql ="delete RESERVATION where res_num=?";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, res_num);
				result=pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("delete->>>"+e.getMessage());
			}finally {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
			}
			return result;
		}
		//펫 리스트 뽑아오기 돌봄예약에서 사진 리스트 받아올때 쓸거임
		public List<Petinfo> list(int mem_num,int startRow, int endRow) throws SQLException {
			List<Petinfo> list = new ArrayList<Petinfo>();
			Connection conn = null;	
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			System.out.println("mem_num list --> "+ mem_num);
			
			 String sql = "select * "
			 		+ "				from(select rownum rn ,a.* "
			 		+ "				from(select * from petinfo where mem_num=? order by petinfo.pet_num) a ) "
			 		+ "				where rn between ? and ? ";
					 
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					do {
						Petinfo petinfo = new Petinfo();
						petinfo.setMem_num(rs.getInt("mem_num"));
						petinfo.setPet_num(rs.getInt("pet_num"));
						petinfo.setPet_name(rs.getString("pet_name"));
						petinfo.setPet_gender(rs.getString("pet_gender"));
						petinfo.setPet_type(rs.getString("pet_type"));
						petinfo.setPet_age(rs.getInt("pet_age"));
						petinfo.setPet_neuter(rs.getString("pet_neuter"));
						petinfo.setPet_photo(rs.getString("pet_photo"));
						
						list.add(petinfo);
					} while (rs.next());
				}
			} catch(Exception e) {	
				System.out.println(e.getMessage()); 
			} finally {
				if (rs !=null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn !=null) conn.close();
			} 
			
			return list;
		}
		//펫 총 마리수
		public int getPetTotalCnt(int mem_num) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int tot = 0;
			String sql = "select count(*) from petinfo where mem_num=?";

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);;
				rs = pstmt.executeQuery();
				if(rs.next()) tot=rs.getInt(1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
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
		
		public Profile getSitter(int res_num) throws SQLException {
			Profile prf = null;
			Connection conn = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			String sql = "select p.* from profile p, reservation r where p.mem_num=r.ps_num and r.res_num=?";
			try{
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, res_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					prf = new Profile();
					prf.setName(rs.getString("name"));
					prf.setPhone(rs.getString("phone"));
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return prf;
		}
		//펫시터 나의예약 현황 예약완료 리스트 조회
		public List<Reservation> userlist2(int startRow, int endRow,int mem_num) throws SQLException {
			List<Reservation> list2 = new ArrayList<Reservation>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from "
					+ "(select rownum rn, list2.* from  "
					+ "(select list.*, c.name res_st from "
					+ "(select res.*, p.name, p.address from reservation res, profile p where res.mem_num=p.mem_num and res.ps_num=?) list, "
					+ "(select * from code where bcd=300) c "
					+ "where list.res_status=c.mcd order by list.res_num desc) list2) "
					+ "where rn between ? and ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Reservation re = new Reservation();
					// address 두번째 주소 뽑기
					String bdaddress = rs.getString("address");
					String[] add = bdaddress.split(" ");
					// System.out.println(add[1]);
					re.setRes_num(rs.getInt("res_num"));
					re.setMem_num(rs.getInt("mem_num"));
					re.setPet_num(rs.getInt("pet_num"));
					re.setPs_num(rs.getInt("ps_num"));
					re.setRes_date(rs.getString("res_date"));
					re.setRes_status(rs.getString("res_status"));
					re.setSit_date(rs.getString("sit_date"));
					re.setSit_start(rs.getString("sit_start"));
					re.setSit_end(rs.getString("sit_end"));
					re.setRequest(rs.getString("request"));
					// 프로필 네임 뽑기
					re.setName(rs.getString("name"));
					// 주소 배열넣어서 뽑기
					re.setAddress(add[1]);
					re.setRes_st(rs.getString("res_st"));
					
					list2.add(re);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			}
			return list2;
		}
}
