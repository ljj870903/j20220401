package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.Sitterinfo;
import dao.SitterinfoDao;

public class SitSelectAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//받은 데이터 : mem_num, pageNum
		//보낸 데이터 : profile, year, month, day,   sitter, mem_num, pageNum
		
		int mem_num1 = Integer.parseInt(request.getParameter("mem_num1"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			SitterinfoDao sd = SitterinfoDao.getInstance();
			Profile profile = sd.select(mem_num1);
			request.setAttribute("profile", profile);
			String birth = profile.getBirth();
			String year = birth.substring(0, 4);
			String month = birth.substring(5, 7);
			String day = birth.substring(8);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			
			Sitterinfo sitter =  sd.getSitterInfo(mem_num1);
			request.setAttribute("sitter", sitter);
			request.setAttribute("pageNum", pageNum);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return "sitterinfo/sitSelect.jsp";
		
		
	
	}

}
