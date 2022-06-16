package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.PhotoDao;

public class PhotoListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		PhotoDao pd = PhotoDao.getInstance();
		String context = request.getContextPath();
		try {
			int totCnt = pd.getTotalCnt();
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null||pageNum.equals("")) {
				pageNum="1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 6, blockSize = 10;
			int startRow = (currentPage-1)*pageSize+1;
			int endRow = startRow+pageSize-1;
			int startNum = totCnt-startRow+1;
			
			List<Board> list = pd.photoList(startRow, endRow);
			request.setAttribute("list", list);
			int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
			int startPage = (int)(currentPage-1)/blockSize*blockSize+1;
			int endPage = startPage+blockSize-1;
			if(endPage>pageCnt) endPage=pageCnt;
			
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		request.setAttribute("context", context);
		
		return "photo/photoList.jsp";
	}

}
