package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Notice;
import dao.NoticeDao;

public class NtcContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String context = request.getContextPath();
		String startNum = request.getParameter("startNum");
		int n_num = Integer.parseInt(request.getParameter("n_num"));
		String pageNum = request.getParameter("pageNum");
		
		NoticeDao nd = NoticeDao.getInstance();
		try {
			nd.viewCount(n_num);
			Notice ntc =  nd.select(n_num);
			request.setAttribute("ntc", ntc);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("n_num", n_num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startNum", startNum);
		request.setAttribute("context", context);
		
		
		return "notice/ntcContent.jsp";
	}

}
