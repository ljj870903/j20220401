package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.PhotoDao;

public class PhotoReUpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int free_num =Integer.parseInt(request.getParameter("free_num"));
		PhotoDao pd = PhotoDao.getInstance();
		try {
			Board board= pd.select(free_num);
			request.setAttribute("board", board);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return "photo/photoReUpdate.jsp";
	}

}
