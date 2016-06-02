package cn.xing.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.xing.domain.BoardForm;
import cn.xing.domain.ClassForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BoardService;

public class AddPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../board/boardListShow.jsp");
		try {
			//封装数据
			BoardForm boardForm=new BoardForm();
			BeanUtils.populate(boardForm, request.getParameterMap());
			
			//添加数据信息
			boardService.addBoardForm(boardForm);
			
			//获取论坛版面列表对象
			int boardclassid=Integer.parseInt(request.getParameter("boardclassid"));
			List<BoardForm> bfList=boardService.getBoardFormByClassID(boardclassid);
			session.setAttribute("bfList", bfList);
			
			//重定向回到后台主页
			response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
