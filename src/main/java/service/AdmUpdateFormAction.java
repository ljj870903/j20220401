package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.Profile;

public class AdmUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response ,HttpSession session)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		try {
			AdminDao ad = AdminDao.getInstance();
			Profile profile = ad.select(id);
			
			request.setAttribute("profile", profile);
			request.setAttribute("pageNum", pageNum);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "admin/admUpdateForm.jsp";
	}

}
