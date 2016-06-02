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

import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.UserService;

public class UpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			 //更新用户信息
			UserService userService=BasicFactory.getFactory().getService(UserService.class);
			HttpSession session=request.getSession();
			session.setAttribute("backMainPage", "../user/userListShow.jsp");
			String able=request.getParameter("userable");
			//通过权限能力来获取用户(在用户信息更新后  桌面所显示的页面)
			List<UserForm> ufList=userService.getUserByAble(able);
			session.setAttribute("ufList", ufList);
			//封装用户新的数据信息
			UserForm userForm=new UserForm();
			BeanUtils.populate(userForm, request.getParameterMap());
			//更新数据
			userService.updateUser(userForm);
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
