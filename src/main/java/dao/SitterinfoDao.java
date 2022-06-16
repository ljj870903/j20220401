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

public class SitterinfoDao {
	
	private static SitterinfoDao instance;
	
	private SitterinfoDao() {
	}
	
	public static SitterinfoDao getInstance() {
		if(instance==null) {
			instance = new SitterinfoDao();
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

	public int insert(Profile profile, Sitterinfo sit) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql1="update profile set name=?, phone=?, gender=?,"
				+ "birth=?, address=?, email=?, petno=? where mem_num=?";
		String sql = "insert into sitterinfo values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1, profile.getName());
			pstmt.setString(2, profile.getPhone());
			pstmt.setString(3, profile.getGender());
			pstmt.setString(4, profile.getBirth());
			pstmt.setString(5, profile.getAddress());
			pstmt.setString(6, profile.getEmail());
			pstmt.setInt(7, profile.getPetno());
			pstmt.setInt(8, profile.getMem_num());
			result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("펫시터 지원자 프로필 수정 완료");
			}
			pstmt.close();
			result=0;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, profile.getMem_num());
			pstmt.setString(2, sit.getPs_start());
			pstmt.setString(3, sit.getPs_end());
			pstmt.setString(4, sit.getPs_smoke());
			pstmt.setString(5, sit.getPs_ex_period());
			pstmt.setString(6, sit.getPs_ex_text());
			pstmt.setString(7, sit.getPs_rel_yn());
			pstmt.setString(8, sit.getPs_rel_job());
			pstmt.setString(9, sit.getPs_rel_period());
			pstmt.setString(10, sit.getPs_agree());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return result;
	}

	public int getTotalCnt() throws SQLException {
		int totCnt = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select count(*) from sitterinfo";
		try {
			conn= getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) totCnt = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return totCnt;
	}
	
	
	public List<Profile> sitterList(int startRow, int endRow) throws SQLException {
		List<Profile> list = null;
		Profile pr = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql = "select*from (select rownum rn, a.* from"
				+ "(select mem_num, name, id, gender, address, grade, birth"
				+ " from profile join sitterinfo using(mem_num) order by grade) a)"
				+ "where rn between ? and ?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Profile>();
				do {
					pr=new Profile();
					pr.setMem_num(rs.getInt("mem_num"));
					pr.setName(rs.getString("name"));
					pr.setId(rs.getString("id"));
					pr.setGender(rs.getString("gender"));
					pr.setAddress(rs.getString("address"));
					pr.setGrade(rs.getString("grade"));
					pr.setBirth(rs.getString("birth"));
					list.add(pr);
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

	public Profile select(int mem_num) throws SQLException {
		Profile profile = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select*from profile where mem_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				profile = new Profile();
				profile.setMem_num(rs.getInt("mem_num"));
				profile.setId(rs.getString("id"));
				profile.setPw(rs.getString("pw"));
				profile.setName(rs.getString("name"));
				profile.setGender(rs.getString("gender"));
				profile.setEmail(rs.getString("email"));
				profile.setPhone(rs.getString("phone"));
				profile.setAddress(rs.getString("address"));
				profile.setGrade(rs.getString("grade"));
				profile.setBirth(rs.getString("birth"));
				profile.setPetno(rs.getInt("petno"));
				profile.setJoin_date(rs.getDate("join_date"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return profile;
	}

	public Sitterinfo getSitterInfo(int mem_num) throws SQLException {
		Sitterinfo sitter = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select * from sitterinfo where mem_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sitter=new Sitterinfo();
				sitter.setMem_num(rs.getInt("mem_num"));
				sitter.setPs_start(rs.getString("ps_start"));
				sitter.setPs_end(rs.getString("ps_end"));
				sitter.setPs_smoke(rs.getString("ps_smoke"));
				sitter.setPs_ex_period(rs.getString("ps_ex_period"));
				sitter.setPs_ex_text(rs.getString("ps_ex_text"));
				sitter.setPs_rel_yn(rs.getString("ps_rel_yn"));
				sitter.setPs_rel_job(rs.getString("ps_rel_job"));
				sitter.setPs_rel_period(rs.getString("ps_rel_period"));
				sitter.setPs_agree(rs.getString("ps_agree"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return sitter;
	}

	public int approve(int mem_num) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update profile set grade=2 where mem_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return result;
	}

	public int delete(int mem_num) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql = "delete from sitterinfo where mem_num = ?";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}
	
	
}
