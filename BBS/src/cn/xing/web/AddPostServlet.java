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
			//��װ����
				//���÷����˵�����
			bbsForm.setBbssender(((UserForm)request.getSession().getAttribute("user")).getUsername());
				//���÷���ʱ��
			bbsForm.setBbssendtime(Change.dateTimeChange(new Date()));
				//
			bbsForm.setBbsoptime(bbsForm.getBbssendtime());
				//�����Ƿ�Ϊ�ö����ӣ�Ĭ�ϲ����ö����ӣ�
			bbsForm.setBbsistop("0");
				//���������ö�ʱ��
			bbsForm.setBbstotoptime("");
				//���þ������ӣ�Ĭ�ϲ��Ǿ������ӣ�
			bbsForm.setBbsisgood("0");
				//��������Ϊ�������ӵ�ʱ��
			bbsForm.setBbstogoodtime("");
				//���ø����ϴθ���ʱ��
			bbsForm.setBbsLastUpdateTime("");
				//���ø����ϴθ��µ���
			bbsForm.setBbsLastUpdateUser("");
			//�����ݿ��������
			bbsService.addBbsForm(bbsForm);
			
			//��ȡ�ö����ӣ������������� ���������ö�����Ҳ�Ǿ������ӣ�
			List<BbsForm> topList=bbsService.getAllTopPost(bbsForm.getBbsboardid());
			//if(topList.size()<=0){
			//	request.getSession().setAttribute("topbbslist", null);
			//}else{
				request.getSession().setAttribute("topbbslist", topList);
			//}
			
			
			//��ȡ�������ӣ��������������ӣ� �����������ö�����Ҳ�Ǿ������ӣ�
			List<BbsForm> comList=bbsService.getAllComPost(bbsForm.getBbsboardid());
			//if(topList.size()<=0){
			//	request.getSession().setAttribute("otherbbslist", null);
			//}else{
			request.getSession().setAttribute("otherbbslist", comList);
			//}
			
			//����tb_board���id����ȡ�ö���
			BoardForm cf=boardService.getBoardForm(bbsForm.getBbsboardid());
			session.setAttribute("cf", cf);
			
			//�ض���ص���ҳ
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
