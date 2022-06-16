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

public class ResUserUpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String pageNum=request.getParameter("pageNum");
		System.out.println("20"+pageNum);
		int res_num=Integer.parseInt(request.getParameter("res_num"));
		System.out.println("22"+res_num);
		int mem_num =Integer.parseInt(request.getParameter("mem_num"));
		
		  Reservation re =new Reservation();
		  re.setSit_date(request.getParameter("sit_date"));
		  re.setSit_start(request.getParameter("sit_start").substring(0,2));
		  re.setSit_end(request.getParameter("sit_end").substring(0,2));
		  re.setRequest(request.getParameter("request"));
		  re.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
		  re.setRes_num(Integer.parseInt(request.getParameter("res_num")));
		 
		try {
		
			ReservationDao bd = ReservationDao.getinstance();
			int result =bd.update(re);
			request.setAttribute("re", re);
			request.setAttribute("mem_num", mem_num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("result", result);
			request.setAttribute("res_num", res_num);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "reservation/resUserUpdatePro.jsp";
	}

}
