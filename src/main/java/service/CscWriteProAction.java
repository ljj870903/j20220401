package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cscenter;
import dao.CscenterDao;

public class CscWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int mem_num = (int)session.getAttribute("mem_num");
		String pageNum = request.getParameter("pageNum");
		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		String cs_title=request.getParameter("cs_title");
		String cs_category=request.getParameter("cs_category");
		String cs_content=request.getParameter("cs_content");
		
		Cscenter cs = new Cscenter();
		cs.setMem_num(mem_num);
		cs.setCs_num(cs_num);
		cs.setCs_title(cs_title);
		cs.setCs_category(cs_category);
		cs.setCs_content(cs_content);
		
		CscenterDao cd = CscenterDao.getInstance();
		try {
			int result = cd.writeReply(cs);
			if(result>0) {
				cd.changeStatus(cs_num);
			}
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cs_num", cs_num);
		
		
		return "cscenter/cscWritePro.jsp";
	}

}
