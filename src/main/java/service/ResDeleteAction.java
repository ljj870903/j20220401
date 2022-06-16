package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReservationDao;

public class ResDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int res_num =Integer.parseInt(request.getParameter("res_num"));
		int mem_num = (int)session.getAttribute("mem_num");
		String pageNum =request.getParameter("pageNum");
		try {
			ReservationDao rd=ReservationDao.getinstance();
			int result =rd.delete(res_num);
			request.setAttribute("res_num", res_num);
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "reservation/resUserDeletePro.jsp";
		
	}
		
		
}
