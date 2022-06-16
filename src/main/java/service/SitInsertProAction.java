package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.Sitterinfo;
import dao.SitterinfoDao;

public class SitInsertProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		/*
		 in -> mem_num, name, phone, gender, year, month, day, address, mail1, mail2, petno
		 ps_start, ps_end, ps_smoke, ps_rel_yn, ps_rel_job, ps_rel_period,
		 ps_ex_period, ps_ex_text, ps_agree
		
		 out -> result, mem_num
		 */
		int mem_num = (int)session.getAttribute("mem_num");
		
		Profile profile = new Profile();
		profile.setMem_num(mem_num);
		profile.setName(request.getParameter("name"));
		profile.setPhone(request.getParameter("phone"));
		profile.setGender(request.getParameter("gender"));
		StringBuffer str = new StringBuffer();  // 0000-00-00 붙이는작업
		str.append(request.getParameter("year"));
		str.append("-");
		str.append(request.getParameter("month"));
		str.append("-");
		str.append(request.getParameter("day"));
		profile.setBirth(str.toString());
		profile.setAddress(request.getParameter("address"));
		StringBuffer str2 = new StringBuffer();  // ddddd@naver.com  붙이는 작업
		str2.append(request.getParameter("mail1"));
		str2.append("@");
		str2.append(request.getParameter("mail2"));
		profile.setEmail(str2.toString());
		profile.setPetno(Integer.parseInt(request.getParameter("petno")));
		
		Sitterinfo sit = new Sitterinfo();
		sit.setPs_start(request.getParameter("ps_start"));
		sit.setPs_end(request.getParameter("ps_end"));
		sit.setPs_smoke(request.getParameter("ps_smoke"));
		sit.setPs_rel_yn(request.getParameter("ps_rel_yn"));
		sit.setPs_rel_job(request.getParameter("ps_rel_job"));
		sit.setPs_rel_period(request.getParameter("ps_rel_period"));
		sit.setPs_ex_period(request.getParameter("ps_ex_period"));
		sit.setPs_ex_text(request.getParameter("ps_ex_text"));
		sit.setPs_agree(request.getParameter("ps_agree"));
		
		SitterinfoDao dao=SitterinfoDao.getInstance();
		
		try {
			int result = dao.insert(profile, sit);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return "sitterinfo/sitInsertPro.jsp";
	}

}
