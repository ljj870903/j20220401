package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PhotoDao;

public class PhotoReUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		int free_num=Integer.parseInt(request.getParameter("free_num"));
		String b_content = request.getParameter("b_content");
		PhotoDao pd = PhotoDao.getInstance();
		try {
			pd.updatePhotoRe(free_num, b_content);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		request.setAttribute("b_content", b_content);
		
		return "photo/photoReUpdatePro.jsp";
	}

}
