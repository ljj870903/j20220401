package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Board;
import dao.PhotoDao;

public class PhotoWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int mem_num = (int)session.getAttribute("mem_num");
		MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/fileSave"),10*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		String b_title = multi.getParameter("b_title");
		String b_photo = multi.getFilesystemName((String)multi.getFileNames().nextElement());
		String b_content = multi.getParameter("b_content");
		
		Board board = new Board();
		board.setMem_num(mem_num);
		board.setB_title(b_title);
		board.setB_photo(b_photo);
		board.setB_content(b_content);
		
		PhotoDao pd = PhotoDao.getInstance();
		try {
			int result = pd.photoInsert(board);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return "photo/photoWritePro.jsp";
	}

}
