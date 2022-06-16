package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.Sitterinfo;
import dao.SitterinfoDao;

public class SitInsertFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String grade = "0";
		if(session.getAttribute("grade")!=null) 
			grade=(String)session.getAttribute("grade");
		int mem_num = 0;
		if(session.getAttribute("mem_num")!=null)
			mem_num = (int)session.getAttribute("mem_num");
		
		SitterinfoDao sd = SitterinfoDao.getInstance();
		try {
			Profile profile = sd.select(mem_num);
			request.setAttribute("profile", profile);
			String birth = profile.getBirth();
			String year = birth.substring(0, 4);
			String month = birth.substring(5, 7);
			String day = birth.substring(8);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			String email = profile.getEmail();
			String[] mail = email.split("@");
			request.setAttribute("mail", mail);
			
			Sitterinfo si = sd.getSitterInfo(mem_num);
			request.setAttribute("si", si);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("grade", grade);
		
		
		return "sitterinfo/sitInsertForm.jsp";
		
	}

}
