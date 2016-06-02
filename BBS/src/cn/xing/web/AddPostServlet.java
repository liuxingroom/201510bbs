package cn.xing.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.xing.domain.BbsForm;
import cn.xing.domain.BoardForm;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BbsService;
import cn.xing.service.BoardService;
import cn.xing.util.Change;

public class AddPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/listRootShow.jsp");
		
		try {
			BbsForm bbsForm=new BbsForm();
			BeanUtils.populate(bbsForm, request.getParameterMap());
			//封装数据
				//设置发帖人的名字
			bbsForm.setBbssender(((UserForm)request.getSession().getAttribute("user")).getUsername());
				//设置发帖时间
			bbsForm.setBbssendtime(Change.dateTimeChange(new Date()));
				//
			bbsForm.setBbsoptime(bbsForm.getBbssendtime());
				//设置是否为置顶帖子（默认不是置顶帖子）
			bbsForm.setBbsistop("0");
				//设置帖子置顶时间
			bbsForm.setBbstotoptime("");
				//设置精华帖子（默认不是精华帖子）
			bbsForm.setBbsisgood("0");
				//设置设置为精华帖子的时间
			bbsForm.setBbstogoodtime("");
				//设置该贴上次更新时间
			bbsForm.setBbsLastUpdateTime("");
				//设置该贴上次更新的人
			bbsForm.setBbsLastUpdateUser("");
			//项数据库添加数据
			bbsService.addBbsForm(bbsForm);
			
			//获取置顶帖子（包括精华帖子 包括既是置顶帖子也是精华帖子）
			List<BbsForm> topList=bbsService.getAllTopPost(bbsForm.getBbsboardid());
			//if(topList.size()<=0){
			//	request.getSession().setAttribute("topbbslist", null);
			//}else{
				request.getSession().setAttribute("topbbslist", topList);
			//}
			
			
			//获取其他帖子（不包括精华帖子， 不包括既是置顶帖子也是精华帖子）
			List<BbsForm> comList=bbsService.getAllComPost(bbsForm.getBbsboardid());
			//if(topList.size()<=0){
			//	request.getSession().setAttribute("otherbbslist", null);
			//}else{
			request.getSession().setAttribute("otherbbslist", comList);
			//}
			
			//根据tb_board表的id来获取该对象
			BoardForm cf=boardService.getBoardForm(bbsForm.getBbsboardid());
			session.setAttribute("cf", cf);
			
			//重定向回到主页
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
