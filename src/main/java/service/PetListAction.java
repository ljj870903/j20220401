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

public class PetListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		     // return 기본 Page
		     String retPage = "petinfo/petList.jsp";	// 페이지 이동 변수 선언 해줌
//			/** BEGIN 로그인에서 값을 저장했다고 가정 **/
//			// TODO .삭제해야함
//			session.setAttribute("mem_num", 20);
//			/** E N D로그인에서 값을 저장했다고 가정 **/
			
			int mem_num = (int)session.getAttribute("mem_num");
	
			System.out.println( "PetListAction_requestPro mem_num : " + mem_num );
	
			PetinfoDao pid = PetinfoDao.getInstance();
		    System.out.println("ListAction Service Start...");
		    
		    try {
		    	List<Petinfo> list = pid.list(mem_num);
	
		    	// if Pet List가 없다면 Pet Insert Page로 변경 
		    	if (list.size() == 0) retPage = "petinfo/petInsertForm.jsp";
				request.setAttribute("petinfoList", list);
				
				System.out.println("PetListAction list.size()  : "+ list.size() );
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		    return retPage;
		  }

}
