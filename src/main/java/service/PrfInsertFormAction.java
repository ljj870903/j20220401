package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;

public class PrfInsertFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("PrfInsertFormAction start...");	
		
		try {
			
		} catch (Exception e) {
			System.out.println("PrfInsertFormAction() ErrorMassage --> " + e.getMessage());
		}
		
		return "profile/prfInsertForm.jsp";
	}

}
