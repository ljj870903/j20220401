package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Notice;
import dao.NoticeDao;

public class NtcUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String context = request.getContextPath();
		String startNum = request.getParameter("startNum");
		String pageNum = request.getParameter("pageNum");
		int n_num = Integer.parseInt(request.getParameter("n_num"));
		
		NoticeDao nd = NoticeDao.getInstance();
		try {
			Notice ntc= nd.select(n_num);
			request.setAttribute("ntc", ntc);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("n_num", n_num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startNum", startNum);
		request.setAttribute("context", context);
		
		return "notice/ntcUpdateForm.jsp";
	}

}
