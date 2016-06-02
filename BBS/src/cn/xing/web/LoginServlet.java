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
		//1.��ȡ����
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		
		//2.����service�еķ���У������
		UserForm userform=userService.getUserByNameAndPsw(username,userpassword);
		if(userform==null){
			request.setAttribute("msg", "�û��������벻��ȷ");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			return;
		}else{
			//3.��½�û�
			//���û��ظ���¼ʱ ���ߵ�¼���˻��ǰ�߼�����
			ServletContext context=this.getServletContext();
			Map<UserForm,HttpSession> map=(Map<UserForm,HttpSession>)context.getAttribute("usermap");
			HttpSession session=map.get(userform);
			//�����û��Ѿ����� ��ɾ�����û���session  ʹ���û��Ƴ���¼
			if(session!=null){
				session.invalidate();
			}
			request.getSession().setAttribute("user", userform);
			//4.�ض�����ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}	
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
