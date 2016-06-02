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

import cn.xing.domain.BoardForm;
import cn.xing.factory.BasicFactory;
import cn.xing.service.BoardService;
import cn.xing.service.ClassService;

public class UpdateBoardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			BoardService boardService=BasicFactory.getFactory().getService(BoardService.class);
			ClassService classService=BasicFactory.getFactory().getService(ClassService.class);
			HttpSession session=request.getSession();
			session.setAttribute("backMainPage", "../board/boardListShow.jsp");
			
			//��װ����
			BoardForm boardForm=new BoardForm();
			BeanUtils.populate(boardForm,request.getParameterMap());
			
			
			//���������ݿ��е����ݸ���
			boardService.updateBoardForm(boardForm);

			//��ȡָ�����İ���
			int boardclassid=Integer.parseInt(request.getParameter("boardclassid"));
			List<BoardForm> bfList=boardService.getBoardFormByClassID(boardclassid);
			session.setAttribute("bfList", bfList);
			
			//�ض���ص���̨��ҳ
			response.sendRedirect(request.getContextPath()+"/pages/admin/view/adminTemp.jsp");
			
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
