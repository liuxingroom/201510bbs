package cn.xing.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PublishPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/add/bbsAdd.jsp");
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		//为了发表帖子选择好版面
		session.setAttribute("boardid", boardid);
		//重定向回到主页
		response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
