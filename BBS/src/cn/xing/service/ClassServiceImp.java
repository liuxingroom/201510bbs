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
		//根据论坛列表id来查询（发帖表）tb_board表中的数据
		List<BoardForm> boardList=boardDao.getBoardFormByClassID(classid);
		for(BoardForm bf:boardList){
			//根据发帖表（tb_board）的id来查询根帖表（tb_bbs）表中的数据
			List<BbsForm> bsfList=bbsDao.getAllPost(bf.getBoardid());
			for(BbsForm bsf:bsfList){
				//根据根帖表（tb_bbs）来获取回应表（tb_answer）的数据
				List<BbsAnswerForm> bafList=answerDao.getAllAnsForm(bsf.getBbsid());
				for(BbsAnswerForm baf:bafList){
					//删除回应信息
					answerDao.deleteAnswerPost(baf.getBbsanswerid());
				}
				//根据id来删除根帖表中的信息
				bbsDao.deleteBbsPost(bsf.getBbsid());
			}
			//根据id来删除发帖表中的信息
			boardDao.deleteBoardPost(bf.getBoardid());
		}
		//删除论坛表中的信息
		classDao.deleteClassPost(classid);
		
	}
	
	
}
