package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PetinfoDao;

public class PetDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		int mem_num = (int)session.getAttribute("mem_num");
		int pet_num = Integer.parseInt(request.getParameter("pet_num"));
		
		System.out.println("PetDeleteProAction requestPro mem_num = "+ mem_num);
		System.out.println("PetDeleteProAction requestPro pet_num = "+ pet_num);
		
		try {
			PetinfoDao pid = PetinfoDao.getInstance();
			
			int result = pid.delete(mem_num, pet_num); 
			
			request.setAttribute("result", result);
			request.setAttribute("pet_num", pet_num);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return "petinfo/petDeletePro.jsp";
	}

}
