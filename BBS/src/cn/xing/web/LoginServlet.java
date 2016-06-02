package cn.xing.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		//1.获取数据
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		
		//2.调用service中的方法校验数据
		UserForm userform=userService.getUserByNameAndPsw(username,userpassword);
		if(userform==null){
			request.setAttribute("msg", "用户名或密码不正确");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			return;
		}else{
			//3.登陆用户
			//当用户重复登录时 后者登录的人会把前者挤出来
			ServletContext context=this.getServletContext();
			Map<UserForm,HttpSession> map=(Map<UserForm,HttpSession>)context.getAttribute("usermap");
			HttpSession session=map.get(userform);
			//若该用户已经存在 则删除该用户的session  使该用户推出登录
			if(session!=null){
				session.invalidate();
			}
			request.getSession().setAttribute("user", userform);
			//4.重定向到主页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}	
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
