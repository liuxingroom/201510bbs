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
		//获取tb_bbs表中id
		int bbsid=Integer.parseInt(request.getParameter("bbsid"));
		BbsForm bbsForm=bbsService.getBFBuyId(bbsid);
		UserForm uf=(UserForm)request.getSession().getAttribute("user");
		if(uf==null){
			response.getWriter().write("您还没有登录请先登录  3秒后跳转到登录界面");
			response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
		}else{
			//如果当前登录的用户是帖子的发表者 ,管理员
			if(uf.getUserable().equals("2") || uf.getUsername().equals(bbsForm.getBbssender())){
				//将帖子提前（修改tb_bbs表中 bbsoptime字段是信息）
				String time=Change.dateTimeChange(new Date());
				bbsService.updateOpTime(time,bbsForm.getBbsid());
				
				//获取tb_bbs表的id 获取该表的信息(获取根帖表对象)
				
				BbsForm bf=bbsService.getBFBuyId(bbsid);
				session.setAttribute("bf", bf);
				
					//获取版主对象
					UserForm userForm=userService.getUserByName(bf.getBbssender());
					session.setAttribute("userForm", userForm);
					Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
					session.setAttribute("buMap", buMap);
					
					response.getWriter().write("操作成功");
					//3秒后重定向回到主页
					response.setHeader("Refresh", "3;url="+request.getContextPath()+"/view/indexTemp.jsp");
				
				
			}else{
				//获取tb_bbs表的id 获取该表的信息(获取根帖表对象)
				
				BbsForm bf=bbsService.getBFBuyId(bbsid);
				session.setAttribute("bf", bf);
				
					//获取版主对象
					UserForm userForm=userService.getUserByName(bf.getBbssender());
					session.setAttribute("userForm", userForm);
					Map<BbsAnswerForm,UserForm> buMap=answerService.getAUByAsId(bbsid);
					session.setAttribute("buMap", buMap);
					
					response.getWriter().write("操作失败！请重复操作");
					//3秒后重定向回到主页
					response.setHeader("Refresh", "3;url="+request.getContextPath()+"/view/indexTemp.jsp");
				
				
			}
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
