package service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Board;
import dao.BoardDao;

public class BoardUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		

		String filename = "";
		
		request.setCharacterEncoding("utf-8");
	
		int maxSize = 5 * 1024 * 1024;
		String fileSave = "/fileSave";// 폴더 미리 만들어두기
		// Meta Data
		String realPath = request.getServletContext().getRealPath(fileSave);// 어디로올린건지
		System.out.println("realPath -> " + realPath);
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		response.setContentType("text/html;charset=utf-8");
	
		while (en.hasMoreElements()) {
			String filename1 = (String) en.nextElement();
			filename = multi.getFilesystemName(filename1);

		}
		
		String pageNum = multi.getParameter("pageNum");
		int mem_num = (int) session.getAttribute("mem_num");
		int free_num = (Integer.parseInt(multi.getParameter("free_num")));
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
		String checkDel = multi.getParameter("checkDel");
		
		System.out.println("<<<<<<<<<<<checkDel---->>"+checkDel);
		


		try {
			//제목,내용,사진만 수정하니까 값 set free_num으로 뽑음
			Board board = new Board();
			board.setMem_num(mem_num);
			board.setFree_num(free_num);
			board.setB_title(b_title);
			board.setB_content(b_content);
			board.setB_photo(filename);

			int result = 0;
			BoardDao bd = BoardDao.getInstance();
			//사진수정 안 하고 수정하기 눌렀을때
			System.out.println("$$$$$$$$$$$$ checkDel="+checkDel);
			System.out.println("$$$$$$$$$$$$ n_photo="+filename);
			if(checkDel.equals("0")&&filename==null) {     // checkDel = "0", n_photo=null
				result = bd.update3(board);    // 사진 삭제하고 제목, 내용 수정
			}else if(checkDel.equals("0")&&filename!=null) {
				result = bd.update(board);
			}else if(checkDel.equals("1")&&filename==null) {	//checkDel = null, n_photo=null
				result = bd.update2(board);   // 제목, 내용만 수정
			}else if(checkDel.equals("1")&&filename!=null) {	//checkDel = null, n_photo="제목"
				result = bd.update(board);   // 제목, 사진, 내용 다 수정
			}
			request.setAttribute("result", result);
		

			request.setAttribute("free_num", board.getFree_num());
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
		} catch (SQLException e) {
			System.out.println("WriteProAction" + e.getMessage());
		}
		return "board/boardUpdatePro.jsp";
	}

}
