package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.BoardDao;


public class FreeReUpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		int free_num = Integer.parseInt(request.getParameter("free_num"));

		BoardDao bd = BoardDao.getInstance();
		try {
			Board board = bd.select(free_num);
			request.setAttribute("board", board);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "board/freeReUpdate.jsp";
	}
}
