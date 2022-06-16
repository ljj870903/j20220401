package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Board;
import dao.PhotoDao;

public class RecommendProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		String jsp = null;
		String isListPage = request.getParameter("isListPage");
		System.out.println("@@@@@isListPage -->" + isListPage);
		int mem_num = (int)session.getAttribute("mem_num");
		int free_num = Integer.parseInt(request.getParameter("free_num"));
		String pageNum = request.getParameter("pageNum");
		int result = 0;
		
		PhotoDao pd = PhotoDao.getInstance();
		try {
			int rcCount = pd.rcSelect(mem_num, free_num);
			System.out.println("@@@@@@@@@@@rcCount->"+rcCount);
			if(rcCount<3) {
				result = pd.rcInsert(mem_num, free_num);
			}
			if(result>0) {
				pd.rcUpdate(free_num);
			}
			Board board = pd.select(free_num);
			int b_category = board.getB_category();
			if(b_category==1) {
				jsp = "board/recommendPro2.jsp";
			}else if(b_category==2) {
				jsp = "photo/recommendPro.jsp";
			}
			
			request.setAttribute("result", result);
			request.setAttribute("rcCount", rcCount);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("free_num", free_num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("isListPage", isListPage);
		
		return jsp;
	}

}
