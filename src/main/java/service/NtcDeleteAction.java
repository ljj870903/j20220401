package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;

public class NtcDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String pageNum = request.getParameter("pageNum");
		int n_num = Integer.parseInt(request.getParameter("n_num"));
		String startNum = request.getParameter("startNum");
		
		NoticeDao nd = NoticeDao.getInstance();
		try {
			int result = nd.delete(n_num);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("n_num", n_num);
		request.setAttribute("startNum", startNum);
		
		return "notice/ntcDelete.jsp";
	}

}
