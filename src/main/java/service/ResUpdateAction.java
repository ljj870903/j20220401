package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Reservation;
import dao.ReservationDao;


public class ResUpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pageNum=request.getParameter("pageNum");
		int res_num=Integer.parseInt(request.getParameter("res_num"));
		int mem_num =Integer.parseInt(request.getParameter("mem_num"));
		/*
		 * Reservation re =new Reservation();
		 * re.setSit_date(request.getParameter("sit_date"));
		 * re.setSit_start(request.getParameter("sit_start"));
		 * re.setSit_end(request.getParameter("sit_end"));
		 * re.setRequest(request.getParameter("request"));
		 */
		//현재 시간
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String sysdate = sim.format(date);
			request.setAttribute("sysdate", sysdate);
		try {
			ReservationDao bd = ReservationDao.getinstance(); 
			Reservation re =bd.select(res_num,mem_num); 
			request.setAttribute("re", re);
			request.setAttribute("mem_num", mem_num);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "reservation/resUserUpdate.jsp";
	}

}
