package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.BoardDao;

public class BoardReplyProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//테스트용 System.out
		try {
			request.setCharacterEncoding("utf-8");
			String pageNum = request.getParameter("pageNum");
			System.out.println("pageNum -> "+pageNum);
			Board board = new Board();			
			board.setFree_num(Integer.parseInt(request.getParameter("free_num")));
			System.out.println("free_num -> "+Integer.parseInt(request.getParameter("free_num")));
			board.setB_category(Integer.parseInt(request.getParameter("b_category")));
			System.out.println("b_category -> "+Integer.parseInt(request.getParameter("b_category")));
			board.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
			System.out.println("mem_num -> "+Integer.parseInt(request.getParameter("mem_num")));
			board.setRef(Integer.parseInt(request.getParameter("ref")));
			System.out.println("ref -> "+Integer.parseInt(request.getParameter("ref")));
			board.setRe_level(Integer.parseInt(request.getParameter("re_level")));
			System.out.println("re_level -> "+Integer.parseInt(request.getParameter("re_level")));
			board.setRe_step(Integer.parseInt(request.getParameter("re_step")));
			System.out.println("re_step -> "+Integer.parseInt(request.getParameter("re_step")));
			board.setB_content(request.getParameter("b_content"));
			
			
			//댓글을 쓴 게시글의 페이지를 가지고 있어야 함
			BoardDao db = BoardDao.getInstance();//DB
			int result = db.insert2(board);
			System.out.println("BoardReplyProAction result->"+result);
		
			request.setAttribute("free_num", board.getFree_num());
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
		} catch (Exception e) {
			System.out.println("BoardReplyProAction -> "+e.getMessage());
		}
	
		return  "board/boardReplyPro.jsp";
	}

}
