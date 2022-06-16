package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Reservation;
import dao.ReservationDao;

public class ResInsertListFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		ReservationDao bd = ReservationDao.getinstance();
		System.out.println("ListAction Service Start...");
		try {
			int mem_num = (int)session.getAttribute("mem_num");
			int res_num = Integer.parseInt(request.getParameter("res_num"));
			String pageNum = request.getParameter("pageNum");
			Reservation re = bd.select(res_num,mem_num);
			request.setAttribute("res_num", res_num); 
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("re", re);
		} catch (Exception e) {
			System.out.println("listaction ->" + e.getMessage());
		}

		return "reservation/resInsertListForm.jsp";
	}

}
