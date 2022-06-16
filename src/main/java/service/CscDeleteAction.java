package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CscenterDao;

public class CscDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String pageNum = request.getParameter("pageNum");
		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		String startNum = request.getParameter("startNum");
		
		CscenterDao cd = CscenterDao.getInstance();
		try {
			int result = cd.delete(cs_num);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cs_num", cs_num);
		request.setAttribute("startNum", startNum);
		
		
		return "cscenter/cscDelete.jsp";
	}

}
