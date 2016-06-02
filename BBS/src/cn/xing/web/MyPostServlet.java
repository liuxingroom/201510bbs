package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.BbsForm;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BbsService;

public class MyPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage", "../pages/show/bbs/myBbsShow.jsp");
		//获取登陆用户的对象
		UserForm userform=(UserForm) request.getSession().getAttribute("user");
		if(userform==null){
			response.getWriter().write("您还没登陆 请先登录！3秒后跳转到登陆界面");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/pages/login.jsp");

		}else{
			//获取去我的帖子
			List<BbsForm> myPost=bbsService.getAllMyPost(userform.getUsername());
			session.setAttribute("myPost", myPost);
			//重定向回到主页
			response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
