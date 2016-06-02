package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.UserService;

public class DeleteUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//删除指定用户信息
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../user/userListShow.jsp");
		String able=request.getParameter("userable");
		
		//通过权限能力来获取用户(在删除指定用户信息更新后  桌面所显示的页面)
		List<UserForm> ufList=userService.getUserByAble(able);
		session.setAttribute("ufList", ufList);
		
		//删除指定用户
		int id=Integer.parseInt(request.getParameter("id"));
		String username=request.getParameter("username");
		userService.deleteUser(id,username);
		
		//重定向回到后台主页
		response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
