package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Petinfo;
import dao.PetinfoDao;

public class PetUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");
			
			MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/fileSave"), 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			Petinfo petinfo = new Petinfo();
			
			petinfo.setMem_num((int)session.getAttribute("mem_num"));
			petinfo.setPet_num(Integer.parseInt(multi.getParameter("pet_num")));
			petinfo.setPet_name(multi.getParameter("pet_name"));
			petinfo.setPet_gender(multi.getParameter("pet_gender"));
			petinfo.setPet_type(multi.getParameter("pet_type"));
			petinfo.setPet_age(Integer.parseInt(multi.getParameter("pet_age")));
			petinfo.setPet_weight(Integer.parseInt(multi.getParameter("pet_weight")));
			petinfo.setPet_neuter(multi.getParameter("pet_neuter"));
			petinfo.setPet_photo(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			PetinfoDao pid = PetinfoDao.getInstance();
			
			int result = pid.update(petinfo);
			
			System.out.println("PetUpdateProAction requestPro() result = " + result);
			request.setAttribute("result", result);
			request.setAttribute("pet_num", petinfo.getPet_num() );
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return "petinfo/petUpdatePro.jsp";
	}

}
