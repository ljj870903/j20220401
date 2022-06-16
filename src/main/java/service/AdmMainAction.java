package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.Board;
import dao.Profile;


public class AdmMainAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		
		AdminDao ad = AdminDao.getInstance();
		
		try {
			int totCnt = ad.getTotalCnt();
			String pageNum = request.getParameter("pageNum");
			if (pageNum==null || pageNum.equals("")) {	pageNum = "1";}
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 10, blockSize = 10;
			int startRow = (currentPage -1) * pageSize + 1;
			int endRow = startRow + pageSize +1;
			int startNum = totCnt - startRow +1;
			
			// 회원 조회
			List<Profile> list = ad.userList(startRow, endRow);
			int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
			int startPage = (int)(currentPage-1)/blockSize*blockSize + 1;
			int endPage = startPage + blockSize -1;
			if (endPage > pageCnt) endPage = pageCnt;
			
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("list", list);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			//펫시터 지원현황
			int sitterCnt = ad.getSitterCnt();
			request.setAttribute("sitterCnt", sitterCnt);
			
			int requestCnt = ad.getRequestCnt();
			request.setAttribute("requestCnt", requestCnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return "admin/admMain.jsp";
	}

}
