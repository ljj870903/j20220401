package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.Petinfo;
import dao.PetinfoDao;

public class PetContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		int mem_num = (int)session.getAttribute("mem_num");
		int pet_num = Integer.parseInt(request.getParameter("pet_num")); 
//		int mem_num2 = (int) session.getAttribute("mem_num");
//		int pet_num = (int) request.getAttribute("pet_num");
		
		System.out.println("PetContentAction_requestPro mem_num : " + mem_num );
//		System.out.println("PetContentAction_requestPro pet_num : " + request.getQueryString());
		System.out.println("PetContentAction_requestPro pet_num : " + request.getParameter("pet_num") );
		
		
//		System.out.println( "PetListAction_requestPro mem_num2 : " + mem_num2 );
		PetinfoDao pid = PetinfoDao.getInstance();
		
		try {
			Petinfo petinfo = pid.select(mem_num, pet_num);
			System.out.println( "PetListAction_requestPro petinfo.toString() : " + petinfo.toString() );
			
			request.setAttribute("petinfo", petinfo);
			request.setAttribute("filename", "fileSave/"+petinfo.getPet_photo());
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 

		
		return "petinfo/petContent.jsp";
		
	}

}
