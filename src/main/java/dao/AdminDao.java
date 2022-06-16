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

public class AdminDao {
	private static AdminDao instance;
	private AdminDao() {}
	public static AdminDao getInstance() {
		if(instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	
	private Connection getConnection() { // DBCP
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
					ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public int getTotalCnt() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int tot = 0;
		String sql = "select count(*) from profile";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs !=null) rs.close();
			if (stmt !=null) stmt.close();
			if (conn !=null) conn.close();
		}
		return tot;	
	}
	
	public List<Profile> userList(int startRow, int endRow) throws SQLException {
		List<Profile> list = new ArrayList<Profile>();
		Connection conn = null;

		String sql = "select * "
					+"from (select rownum rn , a.*"
					+"from (select * from profile order by mem_num) a ) "
					+ "where rn between ? and ? " ;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					Profile profile = new Profile();
					profile.setId(rs.getString("id"));
					profile.setName(rs.getString("name"));
					profile.setPhone(rs.getString("phone"));
					profile.setGrade(rs.getString("grade"));
					list.add(profile);
				} while(rs.next()); 
			}
		} catch (Exception e) {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
	
	public int getSitterCnt() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		String sql = "select count(*) from profile p, sitterinfo s where p.mem_num = s.mem_num and p.grade='1'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) cnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs !=null) rs.close();
			if (stmt !=null) stmt.close();
			if (conn !=null) conn.close();
		}
		
		return cnt;
	}
	
	public Profile select(String id) throws SQLException {
		Profile profile = new Profile();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from profile where id=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				profile.setId(rs.getString("id"));
				profile.setName(rs.getString("name"));
				profile.setGender(rs.getString("gender"));
				profile.setEmail(rs.getString("email"));
				profile.setPhone(rs.getString("phone"));
				profile.setAddress(rs.getString("address"));
				profile.setBirth(rs.getString("birth"));
				profile.setJoin_date(rs.getDate("join_date"));
				profile.setGrade(rs.getString("grade"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return profile;
	}
	
	public int update(Profile profile) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Update profile set grade=? where id=?";
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, profile.getGrade());
			pstmt.setString(2, profile.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	
	public int getSearchCnt(String keyword) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int schtot = 0;
		String sql = "select count(*) from profile where name like '%"+keyword+"%' or id like '%"+keyword+"%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) schtot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs !=null) rs.close();
			if (pstmt !=null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return schtot;	
	}
	
	public List<Profile> searchList(String keyword, int startRow, int endRow) throws SQLException {
		List<Profile> searchList = new ArrayList<Profile>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from("
				+ "select rownum rn, list.* from"
				+ "(select * from profile where name like '%"+keyword+"%' or id like '%"+keyword+"%') list)"
				+ "where rn between ? and ?";
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					Profile profile = new Profile();
					profile.setId(rs.getString("id"));
					profile.setName(rs.getString("name"));
					profile.setPhone(rs.getString("phone"));
					profile.setGrade(rs.getString("grade"));
					searchList.add(profile);
				} while(rs.next());
			}
		} catch (Exception e) {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return searchList;
	}
	public int getRequestCnt() throws SQLException {
		int cnt = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select count(*) from cscenter where cs_status='N'";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) cnt=rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		
		return cnt;
	}
}
