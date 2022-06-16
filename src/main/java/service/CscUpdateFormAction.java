package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cscenter;
import dao.CscenterDao;

public class CscUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		String pageNum = request.getParameter("pageNum");
		String startNum = request.getParameter("startNum");
		
		CscenterDao cd = CscenterDao.getInstance();
		try {
			Cscenter cc = cd.select(cs_num);
			request.setAttribute("cscenter", cc);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("cs_num", cs_num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startNum", startNum);
		
		
		return "cscenter/cscUpdateForm.jsp";
	}

}
