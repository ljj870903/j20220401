package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.Profile;

public class AdmUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		try {
			request.setCharacterEncoding("utf-8");
			Profile profile = new Profile();
			
			profile.setGrade(request.getParameter("grade"));
			profile.setId(request.getParameter("id"));
			
			AdminDao ad = AdminDao.getInstance();
			int result = ad.update(profile);
			
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("result", result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "admin/admUpdatePro.jsp";
	}

}
