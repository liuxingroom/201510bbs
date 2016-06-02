package cn.xing.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.BbsForm;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.AnswerService;
import cn.xing.service.BbsService;
import cn.xing.service.UserService;
import cn.xing.util.Change;

public class DoFristServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnswerService answerService=BasicFactory.getFactory().getService(AnswerService.class);
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/openRootShow.jsp");
		//��ȡtb_bbs����id
		int bbsid=Integer.parseInt(request.getParameter("bbsid"));
		BbsForm bbsForm=bbsService.getBFBuyId(bbsid);
		UserForm uf=(UserForm)request.getSession().getAttribute("user");
		if(uf==null){
			response.getWriter().write("����û�е�¼���ȵ�¼  3�����ת����¼����");
			response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
		}else{
			//�����ǰ��¼���û������ӵķ����� ,����Ա
			if(uf.getUserable().equals("2") || uf.getUsername().equals(bbsForm.getBbssender())){
				//��������ǰ���޸�tb_bbs���� bbsoptime�ֶ�����Ϣ��
				String time=Change.dateTimeChange(new Date());
				bbsService.updateOpTime(time,bbsForm.getBbsid());
				
				//��ȡtb_bbs���id ��ȡ�ñ����Ϣ(��ȡ���������)
				
				BbsForm bf=bbsService.getBFBuyId(bbsid);
				session.setAttribute("bf", bf);
				
					//��ȡ��������
					UserForm userForm=userService.getUserByName(bf.getBbssender());
					session.setAttribute("userForm", userForm);
					Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
					session.setAttribute("buMap", buMap);
					
					response.getWriter().write("�����ɹ�");
					//3����ض���ص���ҳ
					response.setHeader("Refresh", "3;url="+request.getContextPath()+"/view/indexTemp.jsp");
				
				
			}else{
				//��ȡtb_bbs���id ��ȡ�ñ����Ϣ(��ȡ���������)
				
				BbsForm bf=bbsService.getBFBuyId(bbsid);
				session.setAttribute("bf", bf);
				
					//��ȡ��������
					UserForm userForm=userService.getUserByName(bf.getBbssender());
					session.setAttribute("userForm", userForm);
					Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
					session.setAttribute("buMap", buMap);
					
					response.getWriter().write("����ʧ�ܣ����ظ�����");
					//3����ض���ص���ҳ
					response.setHeader("Refresh", "3;url="+request.getContextPath()+"/view/indexTemp.jsp");
				
				
			}
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
