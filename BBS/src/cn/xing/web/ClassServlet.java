package cn.xing.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.ClassForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.ClassService;

public class ClassServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage","../class/classSingle.jsp");
		ClassService classService=BasicFactory.getFactory().getService(ClassService.class);
		//获取classid
		int classid=Integer.parseInt(request.getParameter("classid"));
		//通过classid来获取论坛类别对象
		ClassForm classForm=classService.getClassFormById(classid);
		session.setAttribute("classForm", classForm);
		//重定向回到后台主页
		response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
