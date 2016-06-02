package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.BoardForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BoardService;

public class DeleteBoardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../board/boardListShow.jsp");
		//根据boardid删除指定版面
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		boardService.deleteBoardForm(boardid);
		
		//获取指定类别的版面(在数据删除后要显示的界面)
		int boardclassid=Integer.parseInt(request.getParameter("boardclassid"));
		List<BoardForm> bfList=boardService.getBoardFormByClassID(boardclassid);
		session.setAttribute("bfList", bfList);
		
		//重定向回到后台主页
		response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
