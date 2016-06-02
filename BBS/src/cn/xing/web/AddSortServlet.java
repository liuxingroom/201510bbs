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

import cn.xing.domain.ClassForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.ClassService;

public class AddSortServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassService classService=BasicFactory.getFactory().getService(ClassService.class);		
		try {
			//��װ����
			ClassForm classForm=new ClassForm();
			BeanUtils.populate(classForm, request.getParameterMap());
			//���������Ϣ
			classService.addSort(classForm);
			HttpSession session=request.getSession();
			session.setAttribute("backMainPage", "../class/classListShow.jsp");
			//��ȡ��̳����б����
			List<ClassForm> classList=classService.getAllClassForm();
			session.setAttribute("classList", classList);
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
