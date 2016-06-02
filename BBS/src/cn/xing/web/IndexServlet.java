package cn.xing.web;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();		
		session.setAttribute("mainPage","default.jsp");
		session.setAttribute("backMainPage","default.jsp");
		//获取service
		ClassService classService=BasicFactory.getFactory().getService(ClassService.class);
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
		//1.获取tb_bbs表中的数据
		Map<ClassForm,List<BoardForm>> map=new LinkedHashMap<ClassForm,List<BoardForm>>();
		List<ClassForm> classForm=classService.getAllClassForm();
		for(ClassForm cf:classForm){
			int classID=cf.getClassid();
			List<BoardForm> bfList=boardService.getBoardFormByClassID(classID);
			map.put(cf, bfList);
		}
		//2.转到页面显示
		request.getSession().setAttribute("map", map);
		//request.setAttribute("map", map);
		response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
		//request.getRequestDispatcher("/view/indexTemp.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
