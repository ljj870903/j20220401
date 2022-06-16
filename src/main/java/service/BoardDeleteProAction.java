package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;

public class BoardDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//로그인한 사람과 작성인의 회원번호가 같을때만 삭제하기 때문에 따로 조건 x
		int free_num = Integer.parseInt(request.getParameter("free_num"));
		System.out.println("free_num : " + free_num);
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum : " + pageNum);
		String b_category = request.getParameter("b_category");
		BoardDao bd = BoardDao.getInstance();
		try {
			int result = bd.delete(free_num);
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("free_num", free_num);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "boardList.do?pageNum="+pageNum+"&b_category="+b_category;
	}

}
