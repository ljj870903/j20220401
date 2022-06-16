package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("MainAction start...");	
		String context = request.getContextPath();
		
		try {
				session.setAttribute("mem_num", 0);
				
		} catch (Exception e) {
			System.out.println("MainAction() ErrorMassage --> " + e.getMessage());
		}
		request.setAttribute("context", context);
		
		return "main.jsp";
	}

}
