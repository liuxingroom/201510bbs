package cn.xing.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.dao.UserDao;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.UserService;

public class ModifyUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�޸��û�
		UserService userDao=BasicFactory.getFactory().getService(UserService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage","../user/userModify.jsp");
		//��ȡ�û�id
		int id=Integer.parseInt(request.getParameter("id"));
		UserForm userForm=userDao.getUserById(id);
		session.setAttribute("userForm", userForm);
		//�ض���ص���̨��ҳ
	    response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
