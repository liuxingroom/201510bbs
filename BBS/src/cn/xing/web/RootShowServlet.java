package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.BbsForm;
import cn.xing.domain.BoardForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BbsService;
import cn.xing.service.BoardService;


public class RootShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
	    //设置session对象 将页面数据信息封装到 session域对象中 使其他页面也能获取该资源信息
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/listRootShow.jsp");
		
		int classid=Integer.parseInt(request.getParameter("classId"));
		int boardid=Integer.parseInt(request.getParameter("boardId"));
		
		//获取置顶帖子（包括精华帖子 包括既是置顶帖子也是精华帖子）
		List<BbsForm> topList=bbsService.getAllTopPost(boardid);
		//if(topList.size()<=0){
		//	request.getSession().setAttribute("topbbslist", null);
		//}else{
			request.getSession().setAttribute("topbbslist", topList);
		//}
		
		
		//获取其他帖子（不包括精华帖子， 不包括既是置顶帖子也是精华帖子）
		List<BbsForm> comList=bbsService.getAllComPost(boardid);
		//if(topList.size()<=0){
		//	request.getSession().setAttribute("otherbbslist", null);
		//}else{
		request.getSession().setAttribute("otherbbslist", comList);
		//}
		
		//根据tb_board表的id来获取该对象
		BoardForm cf=boardService.getBoardForm(boardid);
		session.setAttribute("cf", cf);
		//重定向回到主页
		response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
