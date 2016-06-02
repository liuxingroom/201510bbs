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
	    //����session���� ��ҳ��������Ϣ��װ�� session������� ʹ����ҳ��Ҳ�ܻ�ȡ����Դ��Ϣ
		HttpSession session=request.getSession();
		session.setAttribute("mainPage","../pages/show/bbs/listRootShow.jsp");
		
		int classid=Integer.parseInt(request.getParameter("classId"));
		int boardid=Integer.parseInt(request.getParameter("boardId"));
		
		//��ȡ�ö����ӣ������������� ���������ö�����Ҳ�Ǿ������ӣ�
		List<BbsForm> topList=bbsService.getAllTopPost(boardid);
		//if(topList.size()<=0){
		//	request.getSession().setAttribute("topbbslist", null);
		//}else{
			request.getSession().setAttribute("topbbslist", topList);
		//}
		
		
		//��ȡ�������ӣ��������������ӣ� �����������ö�����Ҳ�Ǿ������ӣ�
		List<BbsForm> comList=bbsService.getAllComPost(boardid);
		//if(topList.size()<=0){
		//	request.getSession().setAttribute("otherbbslist", null);
		//}else{
		request.getSession().setAttribute("otherbbslist", comList);
		//}
		
		//����tb_board���id����ȡ�ö���
		BoardForm cf=boardService.getBoardForm(boardid);
		session.setAttribute("cf", cf);
		//�ض���ص���ҳ
		response.sendRedirect(request.getContextPath()+"/view/indexTemp.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
