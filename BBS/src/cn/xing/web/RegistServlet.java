package cn.xing.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		try {
			//��װ����
			UserForm userfrom=new UserForm();
			BeanUtils.populate(userfrom, request.getParameterMap());
			//����û�
			userService.addUserFrom(userfrom);
			//�ض���ص���ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
