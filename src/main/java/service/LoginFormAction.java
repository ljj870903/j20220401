package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("LoginFormAction start...");	
		String context = request.getContextPath();
		try {
			
		} catch (Exception e) {
			System.out.println("LoginFormAction() ErrorMassage --> " + e.getMessage());
		}
		request.setAttribute("context", context);
		
		return "profile/loginForm.jsp";
	}

}
