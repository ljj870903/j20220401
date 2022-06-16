package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Reservation;
import dao.ReservationDao;

public class ResListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		
		ReservationDao rd = ReservationDao.getinstance();
		System.out.println("ListAction Service Start...");
		int mem_num=0;
		if(session.getAttribute("mem_num") != null) {
			mem_num = (int)session.getAttribute("mem_num");
		}
		request.setAttribute("mem_num", mem_num);
		String grade="0";
		if(session.getAttribute("grade") != null){
			grade = (String)session.getAttribute("grade");
		}
		request.setAttribute("grade", grade);
		try {
			int totCnt =rd.getTotalCnt();
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null || pageNum.equals("")){pageNum="1";}
			int currentPage = Integer.parseInt(pageNum);	//1
			int pageSize =10,blockSize =10;
			int startRow = (currentPage -1)*pageSize+1 ;	//1
			int endRow=startRow+pageSize-1;					//10
			int startNum =totCnt - startRow +1;
			// Board 조회
			List<Reservation> list = rd.list(startRow,endRow);
			
			int pageCnt =(int)Math.ceil((double)totCnt/pageSize);	//4
			int startPage = (int)(currentPage-1)/blockSize*blockSize+1;
			int endPage = startPage+blockSize-1;
			if (endPage>pageCnt) endPage=pageCnt;		//안쓰면 1~10페이지까지 다나옴
			
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("list", list);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			//request.setAttribute("address", address);
			System.out.println("--------------och16 오류나는지 확인------------------");   
			System.out.println("startNum-->" + startNum);  // /och16/list.do
			System.out.println("totCnt-->" + totCnt);  // /och16/list.do
			System.out.println("pageNum-->" + pageNum);  // /och16/list.do
			System.out.println("currentPage-->" + currentPage);  // /och16/list.do
			System.out.println("blockSize-->" + blockSize);  // /och16/list.do
			System.out.println("pageSize-->" + pageSize);  // /och16/list.do
			System.out.println("pageCnt-->" + pageCnt);  // /och16/list.do
			System.out.println("startPage-->" + startPage);  // /och16/list.do
			System.out.println("endPage-->" + endPage);  // /och16/list.do
			System.out.println("startRow-->" + startRow);  // /och16/list.do
			System.out.println("endRow-->" + endRow);  // /och16/list.do
			//System.out.println("address-->" + address);  // /och16/list.do

			
		} catch (SQLException e) {
			System.out.println("ListAction SQLException->"+e.getMessage());
		}
		
		return "reservation/resList.jsp";
	}

}
