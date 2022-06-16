package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDao;

public class PrfIdSelectProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("PrfIdSelectProAction start...");	
		
		System.out.println("PrfIdSelectProAction start...");	
		try {
			request.setCharacterEncoding("utf-8");
			//아이디 찾기
			String name  = request.getParameter("name");  //입력된 name  값(필수값O)
			String phone = request.getParameter("phone"); //입력된 phone 값(필수값X)
			String email = request.getParameter("email"); //입력된 email 값(필수값X)
			String emaillast = request.getParameter("emaillast");
			
			if (email != null) {
				email=email.concat("@").concat(emaillast);
			}
			
			System.out.println(email);
			
			System.out.println("name --> " + name);
			System.out.println("phone --> " + phone);
			System.out.println("email --> " + email);
			
			ProfileDao prf    = ProfileDao.getInstance();
			String id = prf.selectId(name, phone, email);
			
			System.out.println(id);
			
			request.setAttribute("id", id);
			
		} catch (Exception e) {
			System.out.println("PrfIdSelectProAction() ErrorMassage --> " + e.getMessage());
		}
		
		return "profile/prfIdSelectPro.jsp";
	}

}
