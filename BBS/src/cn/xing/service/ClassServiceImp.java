package cn.xing.service;

import java.util.ArrayList;
import java.util.List;

import cn.xing.dao.AnswerDao;
import cn.xing.dao.BbsDao;
import cn.xing.dao.BoardDao;
import cn.xing.dao.ClassDao;
import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.BbsForm;
import cn.xing.domain.BoardForm;
import cn.xing.domain.ClassForm;
import cn.xing.factory.BasicFactory;



public class ClassServiceImp implements ClassService {

	ClassDao classDao=BasicFactory.getFactory().getDao(ClassDao.class);
	BoardDao boardDao=BasicFactory.getFactory().getDao(BoardDao.class);
	BbsDao bbsDao=BasicFactory.getFactory().getDao(BbsDao.class);
	AnswerDao answerDao=BasicFactory.getFactory().getDao(AnswerDao.class);
	@Override
	public List<ClassForm> getAllClassForm() {
		return classDao.getAllClassForm();
	}
	@Override
	public ClassForm getClassFormById(int classid) {
		return classDao.getClassFormById(classid);
	}
	@Override
	public int updateClassFormById(ClassForm classForm) {
		return classDao.updateClassFormById(classForm);
	}
	@Override
	public void addSort(ClassForm classForm) {
		classDao.addSort(classForm);
		
	}
	@Override
	public void deleteClass(int classid) {
		//������̳�б�id����ѯ��������tb_board���е�����
		List<BoardForm> boardList=boardDao.getBoardFormByClassID(classid);
		for(BoardForm bf:boardList){
			//���ݷ�����tb_board����id����ѯ������tb_bbs�����е�����
			List<BbsForm> bsfList=bbsDao.getAllPost(bf.getBoardid());
			for(BbsForm bsf:bsfList){
				//���ݸ�����tb_bbs������ȡ��Ӧ��tb_answer��������
				List<BbsAnswerForm> bafList=answerDao.getAllAnsForm(bsf.getBbsid());
				for(BbsAnswerForm baf:bafList){
					//ɾ����Ӧ��Ϣ
					answerDao.deleteAnswerPost(baf.getBbsanswerid());
				}
				//����id��ɾ���������е���Ϣ
				bbsDao.deleteBbsPost(bsf.getBbsid());
			}
			//����id��ɾ���������е���Ϣ
			boardDao.deleteBoardPost(bf.getBoardid());
		}
		//ɾ����̳���е���Ϣ
		classDao.deleteClassPost(classid);
		
	}
	
	
}
