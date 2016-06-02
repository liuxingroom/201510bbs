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

public class DoTopServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		UserService userService=BasicFactory.getFactory().getService(UserService.class);
		AnswerService answerService=BasicFactory.getFactory().getService(AnswerService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/openRootShow.jsp" );
		//获取根贴表中的id
		int bbsid=Integer.parseInt(request.getParameter("bbsid"));
		//讲该表设置为精华帖子
		Date date=new Date();
		String today=Change.dateTimeChange(date);
		int bfs=bbsService.setTopPost(bbsid,today);
		if(bfs>0){
			BbsForm bf=bbsService.getBFBuyId(bbsid);
			session.setAttribute("bf", bf);
			//获取版主对象
			UserForm userForm=userService.getUserByName(bf.getBbssender());
			session.setAttribute("userForm", userForm);
			Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
			session.setAttribute("buMap", buMap);
			//重定向回到主页
			response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
		}else{
			response.getWriter().write("设置失败    请您重新操作");
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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
