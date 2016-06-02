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
import cn.xing.util.Change;

public class ModifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassService classService=BasicFactory.getFactory().getService(ClassService.class);
		HttpSession session=request.getSession();
		session.setAttribute("backMainPage", "../class/classListShow.jsp");
		//封装数据信息
		
		try {
			ClassForm classForm=new ClassForm();
			BeanUtils.populate(classForm, request.getParameterMap());
			//用来防止HTML注入
			classForm.setClassname(Change.HTMLChange(classForm.getClassname()));
    		classForm.setClassintro(Change.HTMLChange(classForm.getClassintro()));
			int num=classService.updateClassFormById(classForm);
			if(num>0){
				//获取论坛类别列表对象
				List<ClassForm> classList=classService.getAllClassForm();
				session.setAttribute("classList", classList);
				
			}else{
				response.getWriter().write("修改失败  请重新操作");
			}
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
