package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SitterinfoDao;

public class SitUpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		//받은 데이터 : mem_num, pageNum
		//보낸 데이터 : result, mem_num, pageNum
		
		int mem_num1 = Integer.parseInt(request.getParameter("mem_num1"));
		String pageNum = request.getParameter("pageNum");
		SitterinfoDao sd = SitterinfoDao.getInstance();
		try {
			int result = sd.approve(mem_num1);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("mem_num1", mem_num1);
		request.setAttribute("pageNum", pageNum);
		
		return "sitterinfo/sitUpdate.jsp";
	}

}
