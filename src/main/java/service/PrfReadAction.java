package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.ProfileDao;

public class PrfReadAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
				
			throws ServletException, IOException {
			System.out.println("PrfReadAction Service start....");
			try {
					ProfileDao  prf     = ProfileDao.getInstance();
					
					List<Profile>    list = prf.list();
					
					int num = 0;
					request.setAttribute("list", list);
					request.setAttribute("num", num);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		return "profile/prfRead.jsp";
	}

}
