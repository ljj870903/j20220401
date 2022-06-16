package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Notice;
import dao.NoticeDao;

public class NtcWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/fileSave"), 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		String n_title = multi.getParameter("n_title");
		String n_content = multi.getParameter("n_content");
		String n_photo = multi.getFilesystemName((String)multi.getFileNames().nextElement());
		String pageNum = multi.getParameter("pageNum");
		Notice ntc = new Notice();
		ntc.setN_title(n_title);
		ntc.setN_content(n_content);
		ntc.setN_photo(n_photo);
		ntc.setMem_num((int)session.getAttribute("mem_num"));
		
		NoticeDao nd = NoticeDao.getInstance();
		try {
			int result = nd.insert(ntc);
			request.setAttribute("result", result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		
		return "notice/ntcWritePro.jsp";
	}

}
