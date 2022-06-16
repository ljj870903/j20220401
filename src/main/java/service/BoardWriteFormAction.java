package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.BoardDao;

//게시판, 갤러리 insert폼 
public class BoardWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		int b_category = Integer.parseInt(request.getParameter("b_category"));
		System.out.println("b_category : " + b_category);
		int mem_num = (int)session.getAttribute("mem_num");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) pageNum = "1";
		System.out.println("pageNum : " + pageNum);

		try {
			// 답변들 그룹 들여쓰기 그룹내 순서
			int free_num = 0, ref = 0, re_level = 0, re_step = 0;
			// 댓글일 경우
			if (request.getParameter("free_num") != null) {
				free_num = Integer.parseInt(request.getParameter("free_num"));
				System.out.println("WriteFormAction free_num->" + free_num);
				BoardDao bd = BoardDao.getInstance();
				Board board = bd.select(free_num);
				ref = board.getRef(); // 답변글끼리 그룹
				System.out.println("BoardWriteFormAction ref->" + ref);
				re_level = board.getRe_level(); // 들여쓰기
				System.out.println("BoardWriteFormAction re_level->" + re_level);
				re_step = board.getRe_step(); // ref내의 순서
				System.out.println("BoardWriteFormAction re_step->" + re_step);
			}
			request.setAttribute("free_num", free_num);
			System.out.println("free_num : " + free_num);
			request.setAttribute("ref", ref);
			request.setAttribute("re_level", re_level);
			request.setAttribute("re_step", re_step);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("b_category", b_category);

		} catch (Exception e) {
			System.out.println("BoardWriteFormAction : " + e.getMessage());
		}

		return "board/boardWriteForm.jsp";
	}

}
