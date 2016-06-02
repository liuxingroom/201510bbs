package cn.xing.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.factory.BasicFactory;
import cn.xing.service.UserService;

public class ValiNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		//��ȡǰ̨�ύ������
		String username=request.getParameter("username");
		String msg=null;
		if(userService.hasName(username)){
			msg="{msg:'�û����Ѿ�����!',stat:1}";
		}else{
			msg="{msg:'�û�������ʹ��',stat:0}";
		}
		response.getWriter().write(msg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
