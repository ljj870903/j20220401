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

public class FreeContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		// 아마 로그인하면 request로 받아올 예정...
		
		int mem_num = (int)session.getAttribute("mem_num");
		int free_num = Integer.parseInt(request.getParameter("free_num"));
		String context = request.getContextPath();
		System.out.println("context : " + context);
		String pageNum = request.getParameter("pageNum");

		try {
			// 조회수 올리기
			BoardDao bd = BoardDao.getInstance();
			bd.b_view(free_num);
			// 원글
			Board board = bd.select(free_num);
			//댓글리스트 불러오기
			List<Board> replyList = bd.select2(free_num);
			System.out.println("============="+replyList);
			//댓글 수 
			int re_totCnt  = bd.getTotalCnt2(free_num);
			
	
			request.setAttribute("context", context);
			request.setAttribute("mem_num", mem_num); 
			request.setAttribute("free_num", free_num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
			request.setAttribute("replyList", replyList);
			request.setAttribute("re_totCnt", re_totCnt);
			
			
		} catch (SQLException e) {
			System.out.println("FreeContentAction : " + e.getMessage());
		}

		return "board/freeContent.jsp";
	}

}
