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
		//获取tb_bbs表的id 获取该表的信息(获取根帖表对象)
		int bbsid=Integer.parseInt(request.getParameter("bbsid"));
		BbsForm bf=bbsService.getBFBuyId(bbsid);
		session.setAttribute("bf", bf);
		//获取版主对象
		UserForm userForm=userService.getUserByName(bf.getBbssender());
		session.setAttribute("userForm", userForm);
		Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
		session.setAttribute("buMap", buMap);
		//重定向回到主页
		response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
