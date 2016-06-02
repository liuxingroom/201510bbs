package cn.xing.web;

import java.io.IOException;
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

public class OpenShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		AnswerService answerService=BasicFactory.getFactory().getService(AnswerService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/openRootShow.jsp" );
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
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
