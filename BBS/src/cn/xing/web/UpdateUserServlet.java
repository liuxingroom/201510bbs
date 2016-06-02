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
			 //�����û���Ϣ
			UserService userService=BasicFactory.getFactory().getService(UserService.class);
			HttpSession session=request.getSession();
			session.setAttribute("backMainPage", "../user/userListShow.jsp");
			String able=request.getParameter("userable");
			//ͨ��Ȩ����������ȡ�û�(���û���Ϣ���º�  ��������ʾ��ҳ��)
			List<UserForm> ufList=userService.getUserByAble(able);
			session.setAttribute("ufList", ufList);
			//��װ�û��µ�������Ϣ
			UserForm userForm=new UserForm();
			BeanUtils.populate(userForm, request.getParameterMap());
			//��������
			userService.updateUser(userForm);
			//�ض���ص���̨��ҳ
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
