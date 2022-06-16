package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.ProfileDao;

public class PrfUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("PrfUpdateProAction start...");	
		
		try {
				request.setCharacterEncoding("utf-8");
				Profile    profile = new Profile();
				ProfileDao prf     = ProfileDao.getInstance();
				
				profile.setId(request.getParameter("id"));
				profile.setPw(request.getParameter("pw"));
				profile.setName(request.getParameter("name"));
				profile.setEmail(request.getParameter("email"));
				profile.setPhone(request.getParameter("phone"));
				profile.setAddress(request.getParameter("address"));
				
				String    email    = request.getParameter("emaillast");
				int       result   = prf.update(profile, email);
				
				request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println("PrfUpdateProAction() ErrorMassage --> " + e.getMessage());
		}
		return "profile/prfUpdatePro.jsp";
	}

}
