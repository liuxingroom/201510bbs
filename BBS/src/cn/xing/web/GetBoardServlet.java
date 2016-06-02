package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.BoardForm;
import cn.xing.domain.ClassForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BoardService;
import cn.xing.service.ClassService;

public class GetBoardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../board/boardModify.jsp");
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
		ClassService classService=BasicFactory.getFactory().getService(ClassService.class);
		//获取所有类别
		List<ClassForm> cfList=classService.getAllClassForm();
		session.setAttribute("cfList", cfList);
		//获取boardid
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		//通过boardid来获取论坛类别对象
		BoardForm boardForm=boardService.getBoardForm(boardid);
		session.setAttribute("boardForm", boardForm);
		response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
