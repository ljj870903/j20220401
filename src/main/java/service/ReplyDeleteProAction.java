package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;

public class ReplyDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//"replyDeletePro.do?reply_free_num="+reply_free_num+"&pageNum1="+pageNum1+"&b_category="+b_category+"&free_num="+free_num;
		// 댓글 번호
		int free_num =  Integer.parseInt(request.getParameter("free_num"));
		int reply_free_num = Integer.parseInt(request.getParameter("reply_free_num")); 	//댓글의 free_num
		int b_category = Integer.parseInt(request.getParameter("b_category"));			//board.category랑 동일하니
		System.out.println("ReplyDeleteProAction free_num : " + free_num);
		System.out.println("ReplyDeleteProAction replyfree_num : " + reply_free_num);
		System.out.println("ReplyDeleteProAction b_category : " + b_category);
		//삭제하려면 free_ num필요
		// 삭제 하면 다시 게시글의 댓글리스트로 이동하려면 pageNum1=2&b_category=1 필요
		// free_num=42&pageNum1=2&b_category=1 세 컬럼 필요 게시글 번호, 댓글페이지, 카테고리
		BoardDao bd = BoardDao.getInstance();
		try {
			int result = bd.delete2(reply_free_num);
			request.setAttribute("result", result);
			request.setAttribute("free_num", free_num);
			request.setAttribute("b_category", b_category);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board/replyDeletePro.jsp";
	}

}
