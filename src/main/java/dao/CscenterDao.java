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

public class CscenterDao {
	private static CscenterDao instance;
	private CscenterDao() {}
	public static CscenterDao getInstance() {
		if(instance == null) {
			instance = new CscenterDao();
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
		}catch(Exception e) { 
			System.out.println(e.getMessage());	
		}
		return conn;
	}
	
	// CscListAction 관리자가 보는 문의페이지에서 쓰임
	public int getTotalCnt() throws SQLException {
		Connection conn = null;	
		Statement stmt= null; 
		ResultSet rs = null;    
		int tot = 0;
		String sql = "select count(*) from cscenter where re_step=0";
		System.out.println("CscenterDao getTotalCnt sql-->"+sql);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) tot = rs.getInt(1);
			System.out.println("CscenterDao getTotalCnt tot-->"+tot);
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null) conn.close();
		}
		return tot;
	}
	
	// CscReadAction 해당 문의 조회(CscWriteFormAction)
	public Cscenter select(int cs_num) throws SQLException {
		Cscenter cscenter = new Cscenter();
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from cscenter where cs_num=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cs_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {				
				cscenter.setCs_num(rs.getInt("cs_num"));
				cscenter.setCs_category(rs.getString("cs_category"));
				cscenter.setMem_num(rs.getInt("mem_num"));
				cscenter.setCs_title(rs.getString("cs_title"));
				cscenter.setCs_date(rs.getString("cs_date"));
				cscenter.setCs_content(rs.getString("cs_content"));
				cscenter.setCs_status(rs.getString("cs_status")); 
				cscenter.setRef(rs.getInt("ref"));
				cscenter.setRe_level(rs.getInt("re_level"));
				cscenter.setRe_step(rs.getInt("re_step"));
			}
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return cscenter;
		
		
	}
	
	// CscListAction 관리자가 보는 문의페이지에서 쓰임(CscMyListAction
		public List<Cscenter> cscList(int mem_num, int startRow, int endRow) throws SQLException {
			List<Cscenter> list = new ArrayList<Cscenter>();
			Connection conn = null;	
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			 String sql = "select * from (select rownum rn ,a.* from (select * from cscenter where re_step=0 and mem_num=? order by ref desc) a ) where rn between ? and ?";
			 try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					
					Cscenter cscenter = new Cscenter();
					cscenter.setCs_num(rs.getInt("cs_num"));
					cscenter.setMem_num(rs.getInt("mem_num"));
					cscenter.setCs_category(rs.getString("cs_category"));
					cscenter.setCs_title(rs.getString("cs_title"));
					cscenter.setCs_content(rs.getString("cs_content"));
					cscenter.setCs_date(rs.getString("cs_date")); 
					cscenter.setCs_status(rs.getString("cs_status"));
					list.add(cscenter);
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
		
		
		// CscWriteProAction에서 댓글 쓸때
		
		// CscMyListAction에서 내가 한 문의수 확인할 때 쓰임
		public int getMyQCnt(int mem_num) throws SQLException {
			System.out.println("getMyQCnt 실행");
			Connection conn = null;	
			PreparedStatement pstmt = null;
			ResultSet rs = null;    
			int tot = 0;
			String sql = "select count(*) from cscenter where mem_num=? and re_step=0";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				rs = pstmt.executeQuery();
				System.out.println("if전까지작동");
				if (rs.next()) {
					tot = rs.getInt(1);
					System.out.println("나작동하는중"+tot);
				}
				
			} catch(Exception e) {	
				System.out.println(e.getMessage()); 
			} finally {
				if (rs !=null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn !=null) conn.close();
			}
			return tot;
		}
		public List<Cscenter> cscAList(int startRow, int endRow) throws SQLException {
			List<Cscenter> list = new ArrayList<Cscenter>();
			Connection conn = null;	
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			 String sql = "select * from (select rownum rn ,a.* from (select * from cscenter where re_step=0 order by cs_status, ref desc, cs_date desc) a ) where rn between ? and ?";
			 try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					
					Cscenter cscenter = new Cscenter();
					cscenter.setCs_num(rs.getInt("cs_num"));
					cscenter.setMem_num(rs.getInt("mem_num"));
					cscenter.setCs_category(rs.getString("cs_category"));
					cscenter.setCs_title(rs.getString("cs_title"));
					cscenter.setCs_content(rs.getString("cs_content"));
					cscenter.setCs_date(rs.getString("cs_date")); 
					cscenter.setCs_status(rs.getString("cs_status"));
					list.add(cscenter);
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
		public int cscInsert(Cscenter cs) throws SQLException {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt=null;
			String sql = "insert into cscenter values(?,(select nvl(max(cs_num),0) from cscenter)+1,?,?,"
					+ "to_char(sysdate,'yyyy-mm-dd'),?,'N',(select nvl(max(cs_num),0) from cscenter)+1,0,0)";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, cs.getCs_category());
				pstmt.setInt(2, cs.getMem_num());
				pstmt.setString(3, cs.getCs_title());
				pstmt.setString(4, cs.getCs_content());
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return result;
		}
		public Cscenter getReply(int cs_num) throws SQLException {
			Cscenter reply = null;
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			String sql = "select * from cscenter where ref=? and re_step>0";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, cs_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					reply = new Cscenter();
					reply.setCs_category(rs.getString("cs_category"));
					reply.setCs_num(rs.getInt("cs_num"));
					reply.setMem_num(rs.getInt("mem_num"));
					reply.setCs_title(rs.getString("cs_title"));
					reply.setCs_date(rs.getString("cs_date"));
					reply.setCs_content(rs.getString("cs_content"));
					reply.setCs_status(rs.getString("cs_status"));
					reply.setRef(rs.getInt("ref"));
					reply.setRe_step(rs.getInt("re_step"));
					reply.setRe_level(rs.getInt("re_level"));
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return reply;
		}
		public int updateC(Cscenter cs) throws SQLException {
			int result = 0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql = "update cscenter set cs_title=?, cs_content=? where cs_num=?";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, cs.getCs_title());
				pstmt.setString(2, cs.getCs_content());
				pstmt.setInt(3, cs.getCs_num());
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return result;
		}
		public int delete(int cs_num) throws SQLException {
			int result = 0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql = "delete from cscenter where cs_num=?";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, cs_num);
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return result;
		}
		public int writeReply(Cscenter cs) throws SQLException {
			int result = 0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql = "insert into cscenter values(?, (select nvl(max(cs_num),0) from cscenter)+1, ?,"
					+ " ?, to_char(sysdate, 'yyyy-mm-dd'), ?, 'Y', ?, 1, 1)";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, cs.getCs_category());
				pstmt.setInt(2, cs.getMem_num());
				pstmt.setString(3, cs.getCs_title());
				pstmt.setString(4, cs.getCs_content());
				pstmt.setInt(5, cs.getCs_num());
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return result;
		}
		public void changeStatus(int cs_num) throws SQLException {
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql = "update cscenter set cs_status='Y' where cs_num=?";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, cs_num);
				pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
		}
		public int updateR(Cscenter cs) throws SQLException {
			int result = 0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql = "update cscenter set cs_title=?, cs_content=? where ref=? and re_step>0";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, cs.getCs_title());
				pstmt.setString(2, cs.getCs_content());
				pstmt.setInt(3, cs.getCs_num());
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
