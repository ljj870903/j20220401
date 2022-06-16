package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cscenter;
import dao.CscenterDao;

public class CscReUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		String pageNum = request.getParameter("pageNum");
		
		CscenterDao cd = CscenterDao.getInstance();
		try {
			Cscenter cs = cd.getReply(cs_num);
			request.setAttribute("cscenter", cs);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("cs_num", cs_num);
		request.setAttribute("pageNum", pageNum);
		
		return "cscenter/cscReUpdateForm.jsp";
	}

}
