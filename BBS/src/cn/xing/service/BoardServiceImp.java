package cn.xing.service;

import java.util.List;

import cn.xing.dao.AnswerDao;
import cn.xing.dao.BbsDao;
import cn.xing.dao.BoardDao;
import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.BbsForm;
import cn.xing.domain.BoardForm;
import cn.xing.factory.BasicFactory;

public class BoardServiceImp implements BoardService {

	BoardDao boardDao=BasicFactory.getFactory().getDao(BoardDao.class);
	BbsDao bbsDao=BasicFactory.getFactory().getDao(BbsDao.class);
	AnswerDao answerDao=BasicFactory.getFactory().getDao(AnswerDao.class);
	@Override
	public List<BoardForm> getBoardFormByClassID(int classID) {
		List<BoardForm> list=null;
		list=boardDao.getBoardFormByClassID(classID);
		for(BoardForm bf:list){
			int id=bf.getBoardid();
			//获取跟帖总数
			int gtNum=bbsDao.getGTNumByBId(id);
			//获取未处理的跟帖数
			int unDoNum=bbsDao.getUnDoNumById(id);
			//获取精华跟帖数
			int goodNum=bbsDao.getGoodNumById(id);
			bf.setBoardBbsnum(gtNum);
			bf.setBoardBbsundonum(unDoNum);
			bf.setBoardBbsgoodnum(goodNum);
		}
		
		System.out.println(list);
		return list;
	}
	@Override
	public BoardForm getBoardForm(int boardid) {
		return boardDao.getBoardForm(boardid);
	}
	@Override
	public void updateBoardForm(BoardForm boardForm) {
		boardDao.updateBoardForm(boardForm);
		
	}
	@Override
	public void deleteBoardForm(int boardid) {
		//获取根帖信息
		List<BbsForm> bsfList=bbsDao.getAllPost(boardid);
		for(BbsForm bsf:bsfList){
			//获取回帖信息
			List<BbsAnswerForm> bafList=answerDao.getAllAnsForm(bsf.getBbsid());
			for(BbsAnswerForm baf:bafList){
				//删除回帖信息
				answerDao.deleteAnswerPost(baf.getBbsanswerid());
			}
			//删除根帖信息
			bbsDao.deleteBbsPost(bsf.getBbsid());
		}
		//删除版面信息
		boardDao.deleteBoardPost(boardid);
		
	}
	@Override
	public void addBoardForm(BoardForm boardForm) {
		boardDao.addBoardForm(boardForm);
		
	}

}
