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

public class BListShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../board/boardListShow.jsp");
		int classid=Integer.parseInt(request.getParameter("classid"));
		//����tb_class�� ��id����ȡtb_board���еĶ���
		List<BoardForm> bfList=boardService.getBoardFormByClassID(classid);
		session.setAttribute("bfList", bfList);
		//�ض���ص���̨��ҳ
	    response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
