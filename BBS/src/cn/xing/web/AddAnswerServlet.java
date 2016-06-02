package cn.xing.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.BbsForm;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.AnswerService;
import cn.xing.service.BbsService;
import cn.xing.service.UserService;
import cn.xing.util.Change;

public class AddAnswerServlet extends HttpServlet {

	/**
	 * ��ӻظ�������Ϣ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnswerService answerService=BasicFactory.getFactory().getService(AnswerService.class);
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/openRootShow.jsp");
		try {
			//��װ����
			BbsAnswerForm answerForm=new BbsAnswerForm();
			BeanUtils.populate(answerForm, request.getParameterMap());
				//���øû�����������
			answerForm.setBbsanswerrootid(Integer.parseInt(request.getParameter("bbsid")));
				//���û����˵���Ϣ
			answerForm.setBbsanswersender(((UserForm)request.getSession().getAttribute("user")).getUsername());
				//���û���ʱ��
			answerForm.setBbsanswersendtime(Change.dateTimeChange(new Date()));
			//�����ݿ����������
			answerService.addAnswerForm(answerForm);
			
			//��ȡtb_bbs���id ��ȡ�ñ����Ϣ(��ȡ���������)
			int bbsid=Integer.parseInt(request.getParameter("bbsid"));
			BbsForm bf=bbsService.getBFBuyId(bbsid);
			session.setAttribute("bf", bf);
			//��ȡ��������
			UserForm userForm=userService.getUserByName(bf.getBbssender());
			session.setAttribute("userForm", userForm);
			Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
			session.setAttribute("buMap", buMap);
			//�ض���ص���ҳ
			response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
			
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
