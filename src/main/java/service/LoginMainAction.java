package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.ProfileDao;

public class LoginMainAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("LoginmainAction start...");	
		try {
			ProfileDao prf   = ProfileDao.getInstance();
			String     id    = (String)session.getAttribute("id");
			String context = request.getContextPath();
			Profile    profile = prf.select(id);
//			if      (grade == "A" || grade.equals("A")) grade = "관리자";
//			else if (grade == "1" || grade.equals("1")) grade = "일반회원";
//			else if (grade == "2" || grade.equals("2")) grade = "펫시터";
			
			System.out.println("로그인시 session에 저장된 id --> "+id);
			System.out.println("로그인시 session에 저장된 grade --> "+profile.getGrade());
			System.out.println("로그인시 session에 저장된 mem_num --> "+profile.getMem_num());
			
			session.setAttribute("grade", profile.getGrade());
			session.setAttribute("mem_num", profile.getMem_num());
			request.setAttribute("name", profile.getName());
			request.setAttribute("email", profile.getEmail());
			request.setAttribute("context", context);
		} catch (Exception e) {
			System.out.println("LoginmainAction() ErrorMassage --> " + e.getMessage());
		}
		
		return "loginmain.jsp";
	}

}
