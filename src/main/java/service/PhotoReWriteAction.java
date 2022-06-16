package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.PhotoDao;

public class PhotoReWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int mem_num=(int)session.getAttribute("mem_num");
		int free_num=Integer.parseInt(request.getParameter("free_num"));
		String b_content = request.getParameter("b_content");
		
		Board board = new Board();
		board.setFree_num(free_num);
		board.setB_content(b_content);
		board.setMem_num(mem_num);
		
		PhotoDao pd = PhotoDao.getInstance();
		try {
			pd.replyInsert(board);
			List<Board> list= pd.getReply(free_num);
			response.setContentType("text/html; charset=UTF-8");
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		return "photo/photoReWrite.jsp";
	}

}
