package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
			System.out.println("LogOutAction start...");
		try {
			session.invalidate(); //세션 끊기
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "main.do";
	}

}
