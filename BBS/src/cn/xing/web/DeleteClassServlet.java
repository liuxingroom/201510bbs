package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.ClassForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.ClassService;

public class DeleteClassServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassService classService=BasicFactory.getFactory().getService(ClassService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../class/classListShow.jsp");
		//删除论坛类别
		int classid=Integer.parseInt(request.getParameter("classid"));
		classService.deleteClass(classid);
		//获取论坛类别列表对象
		List<ClassForm> classList=classService.getAllClassForm();
		session.setAttribute("classList", classList);
		//重定向回到后台主页
		response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
