package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDao;

public class IdChkAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("IdchkAction start...");	
		try {
			request.setCharacterEncoding("utf-8");
			String     id      = request.getParameter("id");
			ProfileDao prf     = ProfileDao.getInstance();
			int 	   result  = prf.idchk(id); //아이디 존재 여부 확인
			
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println("IdchkAction() ErrorMassage --> " + e.getMessage());
		}

		return "idchk.jsp";
	}

}
