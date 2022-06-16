package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cscenter;
import dao.CscenterDao;

public class CscMyListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		CscenterDao csd = CscenterDao.getInstance();
		int mem_num = (int)session.getAttribute("mem_num");
		
		try {
			int myqCnt = csd.getMyQCnt(mem_num);
			String pageNum = request.getParameter("pageNum");
			if (pageNum==null || pageNum.equals("")) {	pageNum = "1";}
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 10, blockSize = 10;
			int startRow = (currentPage -1) * pageSize + 1;
			int endRow = startRow + pageSize -1;
			int startNum = myqCnt - startRow +1;
			
			List<Cscenter> list = csd.cscList(mem_num, startRow, endRow);
			for(Cscenter cc: list) {
				int ref = cc.getRef();
			}
			int pageCnt = (int)Math.ceil((double)myqCnt/pageSize);
			int startPage = (int)(currentPage-1)/blockSize*blockSize + 1;
			int endPage = startPage + blockSize -1;
			if (endPage > pageCnt) endPage = pageCnt;
			
			request.setAttribute("myqCnt", myqCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("list", list);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			System.out.println("myqCnt"+myqCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return "cscenter/cscMyList.jsp";
	}

}
