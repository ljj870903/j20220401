package service;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Petinfo;
import dao.PetinfoDao;

public class PetInsertProAction implements CommandProcess {

	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		// TODO. 삭제
		System.out.println("=========================================111111");
		
		request.setCharacterEncoding("utf-8");
	    //      5M
		int maxSize = 10 * 1024 * 1024;
		String fileSave = "/fileSave";
		// Meta Data 
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath(fileSave);
		System.out.println("realPath->" + realPath);
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		// 서버에 저장된 파일 이름
		String filename = "";
		while (en.hasMoreElements()) {
			//input 태그의 속성이 file인 태그의 name 속성값 :파라미터이름
			String filename1 = (String)en.nextElement();
			//서버에 저장된 파일 이름 
			filename = multi.getFilesystemName(filename1);
			//전송전 원래의 파일 이름 
			String original = multi.getOriginalFileName(filename1);
			//전송된 파일의 내용 타입 
			String type = multi.getContentType(filename1);
			//전송된 파일속성이 file인 태그의 name 속성값을 이용해 파일객체생성 
			File file = multi.getFile(filename1);
			System.out.println("real Path : " + realPath );
			System.out.println("파라메터 이름 : " + filename1);
			System.out.println("실제 파일 이름 : " + original );
			System.out.println("저장된 파일 이름 : " + filename);
			System.out.println("파일 타입 : " + type );
			if (file != null) {
				System.out.println("크기 : " + file.length());
			}
			
			
		}
	
		
		System.out.println("PetInsertProAction requestPro() test code");		
		try {
			int mem = (int)session.getAttribute("mem_num");
			// mem_num은 세션에서 받는걸로 하는데 pet_num은 어떤식으로 넣어야하는지
			System.out.println("PetInsertProAction requestPro() mem : " + mem);
			
			request.setCharacterEncoding("utf-8");
			Petinfo petinfo = new Petinfo();
//			petinfo.setMem_num(Integer.parseInt(multi.getParameter("mem_num").toString()));
//			petinfo.setPet_num(Integer.parseInt(multi.getParameter("pet_num").toString()));
			petinfo.setMem_num(mem);
			petinfo.setPet_name(multi.getParameter("pet_name"));
			petinfo.setPet_gender(multi.getParameter("pet_gender"));
			petinfo.setPet_type(multi.getParameter("pet_type"));
			petinfo.setPet_age(Integer.parseInt(multi.getParameter("pet_age")) );
			petinfo.setPet_weight(Integer.parseInt(multi.getParameter("pet_weight")) );
			petinfo.setPet_neuter(multi.getParameter("pet_neuter"));
			petinfo.setPet_photo(filename);
			// pet_photo 에 값은 어떤식으로 넣어야하는지
			
			System.out.println("PetInsertProAction requestPro() petinfo.getMem_num() : " + petinfo.getMem_num() );
			System.out.println("PetInsertProAction requestPro() petinfo.getPet_photo() : " + petinfo.getPet_photo() );
			System.out.println("PetInsertProAction requestPro() petinfo : " + petinfo.toString() );
			
			PetinfoDao pid = PetinfoDao.getInstance();
			int result = pid.insert(petinfo);	
			
			System.out.println("==============================="+ multi.getParameter("pet_photo"));
			
			request.setAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return "petinfo/petInsertPro.jsp";
	}

}

