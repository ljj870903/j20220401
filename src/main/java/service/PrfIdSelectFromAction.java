package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrfIdSelectFromAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
				System.out.println("PrfIdSelectFromAction start...");	
				
				try {
					
				} catch (Exception e) {
					System.out.println("PrfIdSelectFromAction() ErrorMassage --> " + e.getMessage());
				}
		return "profile/prfIdSelectFrom.jsp";
	}

}
