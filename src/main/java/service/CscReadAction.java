package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cscenter;
import dao.CscenterDao;

public class CscReadAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		String pageNum = request.getParameter("pageNum");
		String startNum = request.getParameter("startNum");
		
		try {
			
			CscenterDao csd = CscenterDao.getInstance();
			
			Cscenter cscenter = csd.select(cs_num); 
			Cscenter reply = csd.getReply(cs_num);
			
			request.setAttribute("cs_num", cs_num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("cscenter", cscenter);
			request.setAttribute("startNum", startNum);
			request.setAttribute("reply", reply);
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}
		return "cscenter/cscRead.jsp";
	}

}
