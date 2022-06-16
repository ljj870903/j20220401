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

public class NoticeDao {

private static NoticeDao instance;
	
	private NoticeDao() {
	}
	
	public static NoticeDao getInstance() {
		if(instance==null) {
			instance = new NoticeDao();
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

	public List<Notice> ntcList(int startRow, int endRow) throws SQLException {
		List<Notice> list = null;
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		Notice ntc = null;
		String sql = "select * from (select rownum rn, b.* from"
				+ "(select * from notice order by n_date desc, n_num desc) b)"
				+ "where rn between ? and ?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Notice>();
				do {
					ntc = new Notice();
					ntc.setN_num(rs.getInt("n_num"));
					ntc.setMem_num(rs.getInt("mem_num"));
					ntc.setN_title(rs.getString("n_title"));
					ntc.setN_date(rs.getString("n_date"));
					ntc.setN_view(rs.getInt("n_view"));
					ntc.setN_content(rs.getString("n_content"));
					ntc.setN_photo(rs.getString("n_photo"));
					list.add(ntc);
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

	public int getTotalCnt() throws SQLException {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select count(*) from notice";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return totCnt;
	}

	public Notice select(int n_num) throws SQLException {
		Notice ntc = null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from notice where n_num = ?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n_num);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				ntc = new Notice();
				ntc.setN_num(rs.getInt("n_num"));
				ntc.setMem_num(rs.getInt("mem_num"));
				ntc.setN_title(rs.getString("n_title"));
				ntc.setN_date(rs.getString("n_date"));
				ntc.setN_view(rs.getInt("n_view"));
				ntc.setN_content(rs.getString("n_content"));
				ntc.setN_photo(rs.getString("n_photo"));
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return ntc;
	}

	public void viewCount(int n_num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update notice set n_view=n_view+1 where n_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, n_num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
	}

	public int update(Notice ntc) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update notice set n_title=?, n_photo=?, n_content=? where n_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ntc.getN_title());
			pstmt.setString(2, ntc.getN_photo());
			pstmt.setString(3, ntc.getN_content());
			pstmt.setInt(4, ntc.getN_num());
			result = pstmt.executeUpdate();
			System.out.println("@@@@@@@@@@@@@@내가 작동한다 update1 @@@@@@@@@@@@@@@@@@@");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}
	
	public int update2(Notice ntc) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update notice set n_title=?, n_content=? where n_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ntc.getN_title());
			pstmt.setString(2, ntc.getN_content());
			pstmt.setInt(3, ntc.getN_num());
			result = pstmt.executeUpdate();
			System.out.println("@@@@@@@@@@@@@@내가 작동한다 update2 @@@@@@@@@@@@@@@@@@@");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}
	
	public int update3(Notice ntc) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update notice set n_title=?, n_content=?, n_photo=null where n_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ntc.getN_title());
			pstmt.setString(2, ntc.getN_content());
			pstmt.setInt(3, ntc.getN_num());
			result = pstmt.executeUpdate();
			System.out.println("@@@@@@@@@@@@@@내가 작동한다 update3 @@@@@@@@@@@@@@@@@@@");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}

	public int delete(int n_num) throws SQLException {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from notice where n_num=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, n_num);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}

	public int insert(Notice ntc) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt=null;
		String sql = "insert into notice values((select nvl(max(n_num),0) from notice)+1, "
				+ "?,?,to_char(sysdate,'yyyy-mm-dd'),0,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ntc.getMem_num());
			pstmt.setString(2, ntc.getN_title());
			pstmt.setString(3, ntc.getN_content());
			pstmt.setString(4, ntc.getN_photo());
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
