package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Reservation;
import dao.ReservationDao;

public class ResInsertProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			int mem_num=Integer.parseInt(request.getParameter("mem_num"));
			
			Reservation re = new Reservation();
			re.setMem_num(mem_num);
			re.setSit_date(request.getParameter("sit_date"));
			re.setSit_start(request.getParameter("sit_start").substring(0,2));
			re.setSit_end(request.getParameter("sit_end").substring(0,2));
			re.setRequest(request.getParameter("request"));
			ReservationDao dbpro=ReservationDao.getinstance();
			int res_num = dbpro.insert(re);
			request.setAttribute("res_num", res_num);
			request.setAttribute("mem_num", mem_num);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "reservation/resInsertPro.jsp";
	}

}
