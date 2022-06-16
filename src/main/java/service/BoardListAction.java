package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.BoardDao;

//자유게시판 플젝
public class BoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// 카테고리 값 받아오기
		//삭제필요
		int b_category = Integer.parseInt(request.getParameter("b_category"));
		System.out.println(b_category);

		try {
			System.out.println("BoardListAction Service Start...");
			BoardDao bd = BoardDao.getInstance(); // 싱글톤 선언

			// 아마 로그인하면 request로 받아올 예정...
			// int mem_num = Integer.parseInt(request.getParameter("mem_num"));

			// 자유게시판 원글 갯수
			int totCnt = bd.getTotalCnt(b_category); // 38
			// 아이디
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null || pageNum.equals("")) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum); // currentPage : 현재페이지 1 2
			int pageSize = 10, blockSize = 10; // pageSize : 한 페이지에 보여주느 개수 blockSize : [1]~[10] 페이지 개수
			int startRow = (currentPage - 1) * pageSize + 1; // 1 11
			int endRow = startRow + pageSize - 1; // 10 20
			int startNum = totCnt - startRow + 1; 
			
			// 자유게시판 원글 조회
			List<Board> list = bd.boardList(b_category, startRow, endRow);
			// 올림! 38 / 10
			int pageCnt = (int) Math.ceil((double) totCnt / pageSize); // 4
			int startPage = (int) (currentPage - 1) / blockSize * blockSize + 1; // 1
			int endPage = startPage + blockSize - 1; // 10
			if (endPage > pageCnt)
				endPage = pageCnt; // 공갈페이지 방지 4

			request.setAttribute("totCnt", totCnt);// request에 저장
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("list", list);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);

			System.out.println("totCnt : " + totCnt);
			System.out.println("pageNum : " + pageNum);
			System.out.println("currentPage : " + currentPage);
			System.out.println("startNum : " + startNum);
			System.out.println("blockSize : " + blockSize);
			System.out.println("pageCnt : " + pageCnt);
			System.out.println("startPage : " + startPage);
			System.out.println("endPage : " + endPage);

		} catch (SQLException e) {
			System.out.println("BoardListAction ->" + e.getMessage());
		}
		// view를 지정함 돌려준다

		return "board/freeList.jsp";
	}

}
