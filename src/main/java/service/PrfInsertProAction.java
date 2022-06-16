package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Profile;
import dao.ProfileDao;

public class PrfInsertProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("PrfInsertProAction start...");	
		
		try {
			request.setCharacterEncoding("utf-8");
			String     email    = request.getParameter("emaillast");//선택한 이메일 포털사이트 주소 ex)naver.com
			ProfileDao prf      = ProfileDao.getInstance();
		
			//입력한 회원정보를 저장
			
			Profile    profile  = new Profile();
			profile.setId(request.getParameter("id"));            //아이디
			profile.setPw(request.getParameter("pw"));            //비밀번호
			profile.setName(request.getParameter("name"));        //이름
			profile.setGender(request.getParameter("gender"));    //성별
			profile.setEmail(request.getParameter("email"));      //이메일
			profile.setPhone(request.getParameter("phone"));      //전화번호
			profile.setAddress(request.getParameter("address"));  //주소
			profile.setBirth(request.getParameter("birth"));      //생년월일
			
			//회원가입 성공/실패 확인  1=성공 / 0=실패
			int        result   = prf.insert(profile,email);
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println("PrfInsertProAction() ErrorMassage  --> " + e.getMessage());
		}
		
		return "profile/prfInsertPro.jsp";
	}

}
