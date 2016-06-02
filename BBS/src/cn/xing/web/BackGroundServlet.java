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
		//�����ж��û�ʱ���½
		if(request.getSession().getAttribute("user")!=null){
			//����û��Ѿ���¼
			UserForm userform=(UserForm) request.getSession().getAttribute("user");
			//�жϸ��û����οͣ�0��������ͨ�û���1�����ǹ���Ա
			if(!userform.getUserable().equals("2")){//���Ȩ�޲�������ʾȨ�޲���
				request.setAttribute("msg", "�Բ��� ������Ȩ�޲���");
				request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			}else{
				//���Ȩ�޹��ͽ����̨����
				response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
			}
			
		}else{
			response.getWriter().write("����û��½ ���ȵ�¼��3�����ת����½����");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/pages/login.jsp");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
