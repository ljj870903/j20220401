package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.ProfileDao;

public class LoginProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response,HttpSession session)
			throws ServletException, IOException {
			
		System.out.println("LoginProAction start...");	
		
		try {
			
			String id = request.getParameter("id"); //로그인시 받아올 id 값
			String pw = request.getParameter("pw"); //로그인시 받아올 pw 값
			
			System.out.println("id ==> " + id + "\npw ==> " + pw); //id,pw 값 확인
			
			ProfileDao prf     = ProfileDao.getInstance();
			int        result  = prf.check(id, pw);
			System.out.println("result ==> " + result);
			
			request.setAttribute("result", result);
			if (result == 1) {
				session.setAttribute("id", id);
			}
			
			
		} catch (Exception e) {
			System.out.println("LoginProAction() ErrorMassage --> " + e.getMessage());
		}
			
		return "profile/loginPro.jsp";
	}

}
