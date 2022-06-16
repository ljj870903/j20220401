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
public class ProfileDao {
    private static ProfileDao instance;
    private ProfileDao() {}
    
    public static ProfileDao getInstance() {
        if (instance == null) {
            instance = new ProfileDao();
        }
        
        return instance;
    }
    
    public Connection getConnection() {
        Connection conn = null;
        
        try {
            Context    ctx = new InitialContext();
            DataSource ds  = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
            conn = ds.getConnection();
        } catch (Exception e) {
            // TODO 자동 생성된 catch 블록
            System.out.println("getConnection() ErrorMessage --> " + e.getMessage());
        }
        return conn;
    }
    
    public int check(String id, String pw) { //로그인
        
        int     result = 0;
        String  sql    = "SELECT pw FROM PROFILE WHERE id = ?";
        
        Connection         conn  = null;
        PreparedStatement  pstmt = null;
        ResultSet          rs    = null;
        
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs    = pstmt.executeQuery();
            
            if (rs.next()) {
                result = 0;
                String dbPw = rs.getString(1);
                if (dbPw.equals(pw)) result = 1; //로그인 성공
                else                 result = 0; //비밀번호 오류
            }else {
                result = -1; //존재하지 않는 계정
            }
            
        } catch (Exception e) {
            System.out.println("check() ErrorMessage --> " + e.getMessage());
        }
        return result;
    }
    
    public int insert(Profile profile, String email) throws SQLException {//회원가입
        int    resutl = 0;
        String sql    = "INSERT INTO profile VALUES((SELECT nvl(max(mem_num),0)+1 FROM profile),?,?,?,?,?,?,?,1,?,'0',sysdate)";
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            
            System.out.println(profile.getId());
            System.out.println(profile.getPw());
            System.out.println(profile.getName());
            System.out.println(profile.getGender());
            System.out.println(profile.getEmail()+email);
            System.out.println(profile.getPhone());
            System.out.println(profile.getAddress());
            System.out.println(profile.getBirth());
            
            
            pstmt.setString(1, profile.getId());
            pstmt.setString(2, profile.getPw());
            pstmt.setString(3, profile.getName());
            pstmt.setString(4, profile.getGender());
            pstmt.setString(5, profile.getEmail() + "@" + email);
            pstmt.setString(6, profile.getPhone());
            pstmt.setString(7, profile.getAddress());
            pstmt.setString(8, profile.getBirth().substring(0,4) + "-" + profile.getBirth().substring(4,6) +"-" + profile.getBirth().substring(6));
            
            resutl = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("insert() ErrorMessage --> " + e.getMessage());
        }finally {
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        }
        
        return resutl;
    }
    
    public int idchk(String id) throws SQLException {
        
        int    reuslt = 0;
        String sql    = "SELECT id FROM PROFILE WHERE id = ?";
        
        Connection        conn = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;    
        
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs    = pstmt.executeQuery();
            
            if (rs.next()) reuslt = 1;
            else           reuslt = 0;
            
        } catch (Exception e) {
            // TODO 자동 생성된 catch 블록
            System.out.println("idchk() ErrorMessage --> " + e.getMessage());
        }finally {
            if(rs    != null) rs.close();
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        } 
        
        return reuslt;
        
    }
    
    public String grade(String id) {
        
        String grade = "1";
        
        String  sql    = "SELECT grade FROM PROFILE WHERE id = ?";
        
        Connection         conn  = null;
        PreparedStatement  pstmt = null;
        ResultSet          rs    = null;
        
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs    = pstmt.executeQuery();
            
            if (rs.next()) {
                grade = "1";
                String dbGrade = rs.getString(1);
                if     (dbGrade.equals("A")) grade = "A"; //관리자
                else if(dbGrade.equals("2")) grade = "2"; //펫시터
                else if(dbGrade.equals("1")) grade = "1"; //일반회원
            }
            
        } catch (Exception e) {
            System.out.println("grade() ErrorMessage --> " + e.getMessage());
        }
        
        return grade;
    }
    
    public Profile select(String id) throws SQLException {
        Profile profile = null;
        String  sql    =  "select * from profile where id = ?";
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
        
            conn  = getConnection(); //getConnection() 호출
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id); 
            rs    = pstmt.executeQuery();
            
            if (rs.next()) {
                    profile = new Profile();
                    profile.setMem_num(rs.getInt(1));
                    profile.setId(rs.getString(2));
                    profile.setPw(rs.getString(3));
                    profile.setName(rs.getString(4));
                    profile.setGender(rs.getString(5));
                    profile.setEmail(rs.getString(6));
                    profile.setPhone(rs.getString(7));
                    profile.setAddress(rs.getString(8));
                    profile.setGrade(rs.getString(9));
                    profile.setBirth(rs.getString(10));
                    profile.setPetno(rs.getInt(11));
                    profile.setJoin_date(rs.getDate(12));
            }
            
                        
        } catch (Exception e) {
            System.out.println("select() ErrorMessage --> " + e.getMessage());
        }finally {
            if(rs    != null) rs.close();
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        }
        
        return profile;
    }
        
    public int update(Profile profile, String email) throws SQLException{
        
        int result = 0;
        String sql    = "Update profile set pw=?, email=? ,phone=?, address=? where id=?";
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
        
                conn  = getConnection(); //getConnection() 호출
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, profile.getPw());
                pstmt.setString(2, profile.getEmail() + "@" + email );
                pstmt.setString(3, profile.getPhone());
                pstmt.setString(4, profile.getAddress());
                pstmt.setString(5, profile.getId());
                
                rs    = pstmt.executeQuery();
        
                if (rs.next()) {
                    result = 1;
                }else {
                    result = 0;
                }
            
            } catch (Exception e) {
                System.out.println("update() ErrorMessage --> " + e.getMessage());
            }finally {
                if(rs    != null) rs.close();
                if(conn  != null) conn.close();
                if(pstmt != null) pstmt.close();
            }
    
            return result;
    }
    
    public int delete(String id, String passwd) throws SQLException{
        
        int result = 0;
        result = check(id, passwd);//아이디 및 비밀번호 체크
        if (result != 1) return result;  // 반환된 result 값이 1이 아니라면 반환된 result값을 반환
        
        String sql    = "DELETE FROM profile WHERE ID = ?";
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
        
            conn   = getConnection(); //getConnection() 호출
            pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("delete() --> " + e.getMessage());
        }finally {
            if(rs    != null) rs.close();
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        }
        
        return result;
    }
    
    
    //회원명단
    public List<Profile> list() throws SQLException{
        
        String sql    = "select * from Profile order by mem_num";
        /* String sql = "select * from Profile order by grade desc ,mem_num"; */
        List<Profile> pf = new ArrayList<Profile>();
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
        
            conn  = getConnection(); //getConnection() 호출
            pstmt = conn.prepareStatement(sql);
            rs    = pstmt.executeQuery();
            
            if (rs.next()) {
                do {
                    Profile profile = new Profile();
                    profile.setMem_num(rs.getInt(1));
                    profile.setId(rs.getString(2));
                    profile.setPw(rs.getString(3));
                    profile.setName(rs.getString(4));
                    profile.setGender(rs.getString(5));
                    profile.setEmail(rs.getString(6));
                    profile.setPhone(rs.getString(7));
                    profile.setAddress(rs.getString(8));
                    profile.setGrade(rs.getString(9));
                    profile.setBirth(rs.getString(10));
                    profile.setPetno(rs.getInt(11));
                    profile.setJoin_date(rs.getDate(12));
                    pf.add(profile);
                } while (rs.next());
            }
            
        } catch (Exception e) {
            System.out.println("list() --> " + e.getMessage());
        }finally {
            if(rs    != null) rs.close();
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        }
        
        return pf;
    }
    
    
    //아이디 찾기
    public String selectId(String name, String phone, String email) throws SQLException {
        
        String id      = null;
        String sql1    = "SELECT id FROM profile WHERE name = ? AND phone = ?";
        String sql2    = "SELECT id FROM profile WHERE name = ? AND email = ?";
        System.out.println(phone);
        System.out.println(email);
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
        
            conn  = getConnection(); //getConnection() 호출
            
            if (phone != null) {
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                rs    = pstmt.executeQuery();
            }else if(email != null){
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                rs    = pstmt.executeQuery();
            }
            
            if (rs.next()) {
                id = rs.getString(1);
                System.out.println("id --> " + id);
                
            }
            
            
        
        } catch (Exception e) {
            System.out.println("selectId() --> " + e.getMessage());
        }finally {
            if(rs    != null) rs.close();
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        }
        
        return id;
    }
    
    
    //비밀번호 찾기
    public String selectPw(String id, String name, String phone, String email) throws SQLException {
        
    	String pw      = null;
        String sql1    = "SELECT pw FROM profile WHERE name = ? AND phone = ? AND id = ?";
        String sql2    = "SELECT pw FROM profile WHERE name = ? AND email = ? AND id = ?";
        
        System.out.println(id);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
        
            conn  = getConnection(); //getConnection() 호출
            
            if (phone != null) {
            	System.out.println(id);
                System.out.println(name);
                System.out.println(phone);
                System.out.println(email);
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, id);
                rs    = pstmt.executeQuery();
            }else if(email != null){
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, id);
                rs    = pstmt.executeQuery();
            }
            
            if (rs.next()) {
            	pw = rs.getString(1);
                System.out.println("pw --> " + pw);
            }
            
        } catch (Exception e) {
            System.out.println("selectPw() --> " + e.getMessage());
        }finally {
            if(rs    != null) rs.close();
            if(conn  != null) conn.close();
            if(pstmt != null) pstmt.close();
        }
        
        return pw;
    }
    public String idReturn(int mem_num) {
        String id  = null;
        String sql = "SELECT id FROM profile WHERE mem_num = ?";
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mem_num);
            rs    = pstmt.executeQuery();
            
            if (rs.next())  id = rs.getString(1);
            else            id = null;
                    
        } catch (Exception e) {
            System.out.println("selectId() --> " + e.getMessage());
        }
        
        return id;
    }
    public int mem_mum(String id) {
        int mem_mum = 0;
        
        String sql = "SELECT mem_mum FROM profile WHERE id = ?";
        
        Connection        conn  = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs    = pstmt.executeQuery();
            
            if (rs.next())  mem_mum = rs.getInt(1);
            else            mem_mum = 0;
                    
        } catch (Exception e) {
            System.out.println("selectId() --> " + e.getMessage());
        }
        
        return mem_mum;
    }
}