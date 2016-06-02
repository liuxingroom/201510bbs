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

import cn.xing.domain.BbsForm;
import cn.xing.domain.SearchFrom;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BbsService;
import cn.xing.service.UserService;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		HttpSession session=request.getSession();		
		session.setAttribute("mainPage","../pages/show/bbs/searchListShow.jsp");
		try {
			SearchFrom searchfrom=new SearchFrom();
			BeanUtils.populate(searchfrom, request.getParameterMap());
			List<BbsForm> bfList=bbsService.findBbsListShow(searchfrom);
			request.getSession().setAttribute("bfList",bfList);
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
