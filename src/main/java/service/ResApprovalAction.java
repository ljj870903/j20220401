package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReservationDao;

public class ResApprovalAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		int mem_num = (int)session.getAttribute("mem_num");
		int res_num = Integer.parseInt(request.getParameter("res_num"));
		
		
		try {
			ReservationDao red = ReservationDao.getinstance();
			int result=red.approval(mem_num, res_num);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main.jsp";
	}

}
