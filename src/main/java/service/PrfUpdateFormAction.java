package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.ProfileDao;

public class PrfUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
			System.out.println("PrfUpdateProAction start...");	
		try {
				String     id      = (String)session.getAttribute("id");
				ProfileDao prf     = ProfileDao.getInstance();
				Profile    profile = prf.select(id);
				
				session.setAttribute("profile", profile);
			
				
		} catch (Exception e) {
			System.out.println("PrfUpdateProAction() ErrorMassage --> " + e.getMessage());
		}
		return "profile/prfUpdateForm.jsp";
	}

}
