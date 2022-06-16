package service;

import java.io.File;
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

public class NtcUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		int n_num = Integer.parseInt(request.getParameter("n_num"));
		String startNum = request.getParameter("startNum");
		
		MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/fileSave"), 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		String n_title = multi.getParameter("n_title");
		String n_photo = multi.getFilesystemName((String)multi.getFileNames().nextElement());
		String n_content = multi.getParameter("n_content");
		
		String checkDel = multi.getParameter("checkDel");
		
		System.out.println("<<<<<<<<<<<checkDel---->>"+checkDel);
		
		Notice ntc = new Notice();
		ntc.setN_num(n_num);
		ntc.setN_title(n_title);
		ntc.setN_photo(n_photo);
		ntc.setN_content(n_content); 
		
		int result = 0;
		NoticeDao nd = NoticeDao.getInstance();
		try {
			System.out.println("$$$$$$$$$$$$ checkDel="+checkDel);
			System.out.println("$$$$$$$$$$$$ n_photo="+n_photo);
			if(checkDel.equals("0")&&n_photo==null) {     // checkDel = "0", n_photo=null
				result = nd.update3(ntc);    // 사진 삭제하고 제목, 내용 수정
			}else if(checkDel.equals("0")&&n_photo!=null) {
				result = nd.update(ntc);
			}else if(checkDel.equals("1")&&n_photo==null) {			//checkDel = null, n_photo=null
				result = nd.update2(ntc);   // 제목, 내용만 수정
			}else if(checkDel.equals("1")&&n_photo!=null) {								//checkDel = null, n_photo="제목"
				result = nd.update(ntc);   // 제목, 사진, 내용 다 수정
			}
			request.setAttribute("result", result);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("n_num", n_num);
		request.setAttribute("startNum", startNum);
		
		
		return "notice/ntcUpdatePro.jsp";
	}

}
