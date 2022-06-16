package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.BoardDao;

public class BoardUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//게시글 수정
		//location.href='boardUpdateForm.do?free_num=${board.free_num}&pageNum=${pageNum}'이 주소로 받아옴

		// TODO Order
		// 1.  free_num, pageNum
		int free_num = Integer.parseInt(request.getParameter("free_num"));
	
		String pageNum = request.getParameter("pageNum");
		String context = request.getContextPath();
		System.out.println("context : " + context);
	
		
		try {
			// 2. BoardDao bd Instance
			BoardDao bd = BoardDao.getInstance();
			// 4. Board board = bd.select(num);free_num
			Board board = bd.select(free_num);
			
			// 5. request 객체에 free_num , pageNum , board
		
			request.setAttribute("free_num", free_num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
			request.setAttribute("context", context);
		} catch (SQLException e) {
			System.out.println("BoardUpdateFormAction : " + e.getMessage());
		}

		return "board/boardUpdateForm.jsp";
	}

}
