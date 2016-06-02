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
		//ɾ��ָ���û���Ϣ
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../user/userListShow.jsp");
		String able=request.getParameter("userable");
		
		//ͨ��Ȩ����������ȡ�û�(��ɾ��ָ���û���Ϣ���º�  ��������ʾ��ҳ��)
		List<UserForm> ufList=userService.getUserByAble(able);
		session.setAttribute("ufList", ufList);
		
		//ɾ��ָ���û�
		int id=Integer.parseInt(request.getParameter("id"));
		String username=request.getParameter("username");
		userService.deleteUser(id,username);
		
		//�ض���ص���̨��ҳ
		response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
