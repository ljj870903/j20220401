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

public class PhotoContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int free_num = Integer.parseInt(request.getParameter("free_num"));
		String pageNum = request.getParameter("pageNum");
		String context = request.getContextPath();
		
		PhotoDao pd = PhotoDao.getInstance();
		try {
			Board board = pd.select(free_num);
			List<Board> list = pd.getReply(free_num);
			pd.viewUp(free_num);
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("context", context);
		
		return "photo/photoContent.jsp";
	}

}
