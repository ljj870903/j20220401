package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PhotoDao;

public class PhotoDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String pageNum = request.getParameter("pageNum");
		int free_num = Integer.parseInt(request.getParameter("free_num"));
		
		PhotoDao pd = PhotoDao.getInstance();
		try {
			int result = pd.photodelete(free_num);
			System.out.println(result+"개 삭제됨");
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("free_num", free_num);

		return "photo/photoDelete.jsp";
	}

}
