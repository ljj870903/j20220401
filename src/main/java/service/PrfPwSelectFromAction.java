package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrfPwSelectFromAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
				System.out.println("PrfPwSelectFromAction start...");	
				
				try {
					
				} catch (Exception e) {
					System.out.println("PrfPwSelectFromAction() ErrorMassage --> " + e.getMessage());
				}
		return "profile/prfPwSelectForm.jsp";
	}

}
