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

public class PhotoReDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		int free_num = Integer.parseInt(request.getParameter("free_num"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		PhotoDao pd = PhotoDao.getInstance();
		try {
			pd.photoReDelete(free_num);
			List<Board> list =  pd.getReply(ref);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return "photo/photoReWrite.jsp";
	}

}
