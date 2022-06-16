package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDao;

public class PrfPwSelectProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
				System.out.println("PrfPwSelectProAction start...");	
					
				try {
					request.setCharacterEncoding("utf-8");
					String id    = request.getParameter("id");
					String name  = request.getParameter("name"); 
					String phone = request.getParameter("phone"); 
					String email = request.getParameter("email"); 
					String emaillast = request.getParameter("emaillast"); 
					
					System.out.println("id -->" + id);
					System.out.println("name -->"+name);
					System.out.println("phone -->"+phone);
					System.out.println("email -->"+email);
					
					if (email != null) {
						email=email.concat("@").concat(emaillast);
					}
					
					ProfileDao prf    = ProfileDao.getInstance();
					String pw = prf.selectPw(id,name, phone, email);
					
					System.out.println(pw);
					
					request.setAttribute("pw", pw);
				} catch (Exception e) {
					System.out.println("PrfPwSelectProAction() ErrorMassage --> " + e.getMessage());
				}
				return "profile/prfPwSelectPro.jsp";
	}

}
