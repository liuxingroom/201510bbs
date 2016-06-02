package cn.xing.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xing.domain.BbsForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BbsService;

public class GoodPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsService bbsService=BasicFactory.getFactory().getService(BbsService.class);
		HttpSession session=request.getSession();
		session.setAttribute("mainPage", "../pages/show/bbs/goodListShow.jsp");
		//��ȡ��������
		List<BbsForm> bfList=bbsService.getAllGoodPost();
		session.setAttribute("bfList", bfList);
		//�ض���ص���ҳ
		response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
