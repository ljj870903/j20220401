package service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Board;
import dao.BoardDao;

//완전 미완성
public class BoardWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// int b_category = Integer.parseInt(request.getParameter("b_category"));
		// sSystem.out.println("b_category : "+b_category);

		String filename = "";
		String upLoadFilename = "";
		request.setCharacterEncoding("utf-8");
		// 5M
		int maxSize = 5 * 1024 * 1024;
		String fileSave = "/fileSave";// 폴더 미리 만들어두기
		// Meta Data
		String realPath = request.getServletContext().getRealPath(fileSave);// 어디로올린건지
		System.out.println("realPath -> " + realPath);
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		response.setContentType("text/html;charset=utf-8");
		// PrintWriter out = response.getWriter();
		while (en.hasMoreElements()) {
			// input태그의 속성이 file인 태그의 name 속성값 : 파라미터이름
			String filename1 = (String) en.nextElement();
			// 서버에 저장된 파일 이름
			filename = multi.getFilesystemName(filename1);
			// 전송전 원래의 파일 이름
			String original = multi.getOriginalFileName(filename1);
			// 전소된 파일의 내용 타입
			String type = multi.getContentType(filename1);
			// 전송된 파일속성이 file인 태그의 name 속성값을 이용해 파일객체 생성
			File file = multi.getFile(filename1);
			System.out.println("real Path : " + realPath);
			System.out.println("파라미터 이름 : " + filename1);
			System.out.println("실제 파일 이름: " + original);
			System.out.println("저장된 파일이름: " + filename);
			System.out.println("파일타입: " + type);
			if (file != null) {
				System.out.println("크기: " + file.length());
				// out.println("크기: "+file.length()+"<br>");
			}
		}
		String pageNum = multi.getParameter("pageNum");
		int mem_num = (int)session.getAttribute("mem_num");
		String free_num = multi.getParameter("free_num");
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
		String b_photo = multi.getParameter("b_photo");
		System.out.println("pageNum -> " + pageNum);
		System.out.println("mem_num -> " + mem_num);
		System.out.println("free_num -> " + free_num);
		System.out.println("b_title -> " + b_title);
		System.out.println("b_content -> " + b_content);
		System.out.println("b_photo -> " + filename);
		upLoadFilename = realPath + "\\" + filename;
		System.out.println("전달  upLoadFilename-> " + upLoadFilename);

		request.setAttribute("filename", "fileSave\\" + filename);
		request.setAttribute("upLoadFilename", upLoadFilename);

		try {
			Board board = new Board();
			board.setFree_num(Integer.parseInt(multi.getParameter("free_num")));
			board.setMem_num(mem_num);
			board.setB_category(Integer.parseInt(multi.getParameter("b_category")));
			board.setRef(Integer.parseInt(multi.getParameter("ref")));
			board.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
			board.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
			board.setB_title(multi.getParameter("b_title"));
			board.setB_content(multi.getParameter("b_content"));
			board.setB_photo(filename);
			
			BoardDao bd = BoardDao.getInstance();
			int result;
			result = bd.insert(board);
			System.out.println("BoardWriteProAction result --> " + result);

			request.setAttribute("free_num", board.getFree_num());
			request.setAttribute("b_category", board.getB_category());
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
		} catch (SQLException e) {
			System.out.println("WriteProAction" + e.getMessage());
		}

		return "board/boardWritePro.jsp";
	}

	

}
