package cn.xing.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.UserForm;

public class BackGroundServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "default.jsp");
		//首先判断用户时候登陆
		if(request.getSession().getAttribute("user")!=null){
			//如果用户已经登录
			UserForm userform=(UserForm) request.getSession().getAttribute("user");
			//判断该用户是游客（0）还是普通用户（1）还是管理员
			if(!userform.getUserable().equals("2")){//如果权限不够这提示权限不足
				request.setAttribute("msg", "对不起 ，您的权限不够");
				request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			}else{
				//如果权限够就进入后台界面
				response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
			}
			
		}else{
			response.getWriter().write("您还没登陆 请先登录！3秒后跳转到登陆界面");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/pages/login.jsp");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
