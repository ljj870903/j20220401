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

public class PetinfoDao {

	private static PetinfoDao instance;
	private PetinfoDao() {}
	public static PetinfoDao getInstance() {
		if (instance == null) {
			instance = new PetinfoDao();
		}
		return instance;
	}
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
					ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());			
		}
		return conn;
	}
		
	public Petinfo select(int mem_num) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from petinfo where mem_num="+mem_num;
		Petinfo petinfo = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				petinfo = new Petinfo();
				petinfo.setMem_num(rs.getInt("mem_num"));
				petinfo.setPet_num(rs.getInt("pet_num"));
				petinfo.setPet_name(rs.getString("pet_name"));
				petinfo.setPet_gender(rs.getString("pet_gender"));
				petinfo.setPet_type(rs.getString("pet_type"));
				petinfo.setPet_age(rs.getInt("pet_age"));
				petinfo.setPet_weight(rs.getInt("pet_weight"));
				petinfo.setPet_neuter(rs.getString("pet_neuter"));
				petinfo.setPet_photo(rs.getString("pet_photo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
		

		return petinfo;
	}
	

	public Petinfo select(int mem_num, int pet_num) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * "+
					 "FROM petinfo "+
				     "WHERE mem_num="+mem_num+
				     " AND pet_num="+pet_num;
		
		System.out.println("Petinfo select(memNum, petNum) : " + sql );
			
		Petinfo petinfo = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				petinfo = new Petinfo();
				petinfo.setMem_num(rs.getInt("mem_num"));
				petinfo.setPet_num(rs.getInt("pet_num"));
				petinfo.setPet_name(rs.getString("pet_name"));
				petinfo.setPet_gender(rs.getString("pet_gender"));
				petinfo.setPet_type(rs.getString("pet_type"));
				petinfo.setPet_age(rs.getInt("pet_age"));
				petinfo.setPet_weight(rs.getInt("pet_weight"));
				petinfo.setPet_neuter(rs.getString("pet_neuter"));
				petinfo.setPet_photo(rs.getString("pet_photo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
		

		return petinfo;
	}
	
	
	public int selectMaxPetNum(int mem_num) throws SQLException {
		System.out.println("selectMaxPetNum start....");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int maxPetNum = 0;
		String sql = "select nvl(max(pet_num),0)+1 from petinfo where mem_num="+mem_num;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				maxPetNum = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
		
		return maxPetNum;
	}
	
	
	public int insert (Petinfo petinfo) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// max pet_num구하기
		int maxPetNum = 0;
		maxPetNum = selectMaxPetNum(petinfo.getMem_num());
		String sql = "insert into petinfo values(?,?,?,?,?,?,?,?,?)";
		String sql2 = "update profile set petno=petno+1 where mem_num=?";
						
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, petinfo.getMem_num());
			pstmt.setInt(2, maxPetNum);
			pstmt.setString(3, petinfo.getPet_name());
			pstmt.setString(4, petinfo.getPet_gender());
			pstmt.setString(5, petinfo.getPet_type());
			pstmt.setInt(6, petinfo.getPet_age());
			pstmt.setInt(7, petinfo.getPet_weight());
			pstmt.setString(8, petinfo.getPet_neuter());
			pstmt.setString(9, petinfo.getPet_photo());
			result = pstmt.executeUpdate();
			pstmt.close();
			
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, petinfo.getMem_num());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null)  pstmt.close();
		}
		
		
		
		return result;
	}
	public List<Petinfo> list(int mem_num) throws SQLException {
		List<Petinfo> list = new ArrayList<Petinfo>();
		Connection conn = null;	
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		 String sql = "select * from petinfo where mem_num=?";
				 
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
	public int update(Petinfo petinfo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE petinfo SET pet_name=?, pet_gender=?, pet_type=?, pet_age=?, pet_weight=?, pet_neuter=?, pet_photo=? WHERE mem_num=? AND pet_num=?";
	
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, petinfo.getPet_name());
			pstmt.setString(2, petinfo.getPet_gender());
			pstmt.setString(3, petinfo.getPet_type());
			pstmt.setInt(4, petinfo.getPet_age());
			pstmt.setInt(5, petinfo.getPet_weight());
			pstmt.setString(6, petinfo.getPet_neuter());
			pstmt.setString(7, petinfo.getPet_photo());
			pstmt.setInt(8, petinfo.getMem_num());
			pstmt.setInt(9, petinfo.getPet_num());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)	pstmt.close();
			if (conn != null)	conn.close();
		}
		
		
		return result;
	}
	
	public int delete(int mem_num, int pet_num) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM petinfo WHERE mem_num=? AND pet_num=?";
		String sql2 = "update profile set petno=petno-1 where mem_num=?"; 
		
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, pet_num);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, mem_num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (conn != null)   conn.close();
			if (pstmt != null)  pstmt.close();
		}
		
		return result;
		
		
	}
	
	
}
