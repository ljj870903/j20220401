package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Petinfo;
import dao.PetinfoDao;

public class PetUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String context = request.getContextPath();
		int mem_num = (int)session.getAttribute("mem_num");
		int pet_num = Integer.parseInt(request.getParameter("pet_num"));
		
		System.out.println("PetUpdateFormAction requestPro mem_num"+mem_num);
		System.out.println("PetUpdateFormAction requestPro pet_num"+pet_num);
		PetinfoDao pid = PetinfoDao.getInstance();
		
		try {
			Petinfo petinfo = pid.select(mem_num, pet_num);
			
			request.setAttribute("petinfo", petinfo);
			request.setAttribute("filename", "fileSave/"+petinfo.getPet_photo());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("context", context);
		
		return "petinfo/petUpdateForm.jsp";
	}

}
