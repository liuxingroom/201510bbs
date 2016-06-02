package cn.xing.service;

import java.util.List;

import cn.xing.dao.AnswerDao;
import cn.xing.dao.BbsDao;
import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.BbsForm;
import cn.xing.domain.SearchFrom;
import cn.xing.factory.BasicFactory;

public class BbsServicImp implements BbsService {

	BbsDao bbsdao=BasicFactory.getFactory().getDao(BbsDao.class);
	AnswerDao answerDao=BasicFactory.getFactory().getDao(AnswerDao.class);
	
	@Override
	public List<BbsForm> findBbsListShow(SearchFrom searchfrom) {
		String subsql=searchfrom.getSubsql();//查找条件
		String sqlvalue=searchfrom.getSqlvalue();//查找关键字
	    String searchtype=searchfrom.getSearchtype();//查找类型
	    String param="";
	    String opname="";
	    if(searchtype.equals("all")){
	    	opname=" = ";
	    	param=sqlvalue;
	    }else{
	    	opname=" like ";
	    	param="%"+sqlvalue+"%";
	    }
	    //根据条件查找的根帖集合
		List<BbsForm> bf=bbsdao.findBbsListShow(subsql,param,opname);
		int bbsAnswerNum=0;//设置初始值位0    帖子的回复数
		String bbsLastUpdateUser="";//最后回复者
		String bbsLastUpdateTime="";//最后回复时间 
		for(BbsForm bsf:bf){
			int bbsid=bsf.getBbsid();
			//获取所有回复的帖子数
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//查询出该根帖的所有回复帖子(按回复时间升序排列),获取最后回复人、回复时间
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//设置回复帖子数、最后回复人、最后回复时间
				bsf.setBbsAnswerNum(bbsAnswerNum);
				bsf.setBbsLastUpdateUser(bbsLastUpdateUser);
				bsf.setBbsLastUpdateTime(bbsLastUpdateTime);
			}
		}
		return bf;
	}

	@Override
	public List<BbsForm> getAllTopPost(int boardid) {
		List<BbsForm> topPost=bbsdao.getAllTopPost(boardid);
		int bbsAnswerNum=0;//设置初始值位0    帖子的回复数
		String bbsLastUpdateUser="";//最后回复者
		String bbsLastUpdateTime="";//最后回复时间 
		for(BbsForm bsf:topPost){
			int bbsid=bsf.getBbsid();
			//获取所有回复的帖子数
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//查询出该根帖的所有回复帖子(按回复时间升序排列),获取最后回复人、回复时间
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){//如果存在回复的帖子
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				//设置回复帖子数、最后回复人、最后回复时间
				bsf.setBbsAnswerNum(bbsAnswerNum);
				bsf.setBbsLastUpdateUser(bbsLastUpdateUser);
				bsf.setBbsLastUpdateTime(bbsLastUpdateTime);
			}
			
			
			
		}
		return topPost;
	}

	@Override
	public List<BbsForm> getAllComPost(int boardid) {
		List<BbsForm> comPost=bbsdao.getAllComPost(boardid);
		int bbsAnswerNum=0;//设置初始值位0    帖子的回复数
		String bbsLastUpdateUser="";//最后回复者
		String bbsLastUpdateTime="";//最后回复时间 
		for(BbsForm bsf:comPost){
			int bbsid=bsf.getBbsid();
			//获取所有回复的帖子数
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//查询出该根帖的所有回复帖子(按回复时间升序排列),获取最后回复人、回复时间
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//设置回复帖子数、最后回复人、最后回复时间
				bsf.setBbsAnswerNum(bbsAnswerNum);
				bsf.setBbsLastUpdateUser(bbsLastUpdateUser);
				bsf.setBbsLastUpdateTime(bbsLastUpdateTime);
			}
			
		}
		return comPost;
	}

	@Override
	public List<BbsForm> getAllGoodPost() {
		List<BbsForm> goodPost=bbsdao.getAllGoodPost();
		int bbsAnswerNum=0;//设置初始值位0    帖子的回复数
		String bbsLastUpdateUser="";//最后回复者
		String bbsLastUpdateTime="";//最后回复时间 
		for(BbsForm gp:goodPost){
			int bbsid=gp.getBbsid();
			//获取所有回复的帖子数
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//查询出该根帖的所有回复帖子(按回复时间升序排列),获取最后回复人、回复时间
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//设置回复帖子数、最后回复人、最后回复时间
				gp.setBbsAnswerNum(bbsAnswerNum);
				gp.setBbsLastUpdateUser(bbsLastUpdateUser);
				gp.setBbsLastUpdateTime(bbsLastUpdateTime);
			}
			
		}
		return goodPost;
	}

	@Override
	public List<BbsForm> getAllMyPost(String username) {
		List<BbsForm> myPost=bbsdao.getAllMyPost(username);
		int bbsAnswerNum=0;//设置初始值位0    帖子的回复数
		String bbsLastUpdateUser="";//最后回复者
		String bbsLastUpdateTime="";//最后回复时间 
		for(BbsForm bsf:myPost){
			int bbsid=bsf.getBbsid();
			//获取所有回复的帖子数
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//查询出该根帖的所有回复帖子(按回复时间升序排列),获取最后回复人、回复时间
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//设置回复帖子数、最后回复人、最后回复时间
				bsf.setBbsAnswerNum(bbsAnswerNum);
				bsf.setBbsLastUpdateUser(bbsLastUpdateUser);
				bsf.setBbsLastUpdateTime(bbsLastUpdateTime);
			}
			
		}
		return myPost;
		
	}

	@Override
	public BbsForm getBFBuyId(int bbsid) {
		return bbsdao.getBFBuyId(bbsid);
	}

	@Override
	public int setGoodPost(int bbsid,String today) {
		return bbsdao.setGoodPost(bbsid,today);
		
		
	}

	@Override
	public int setTopPost(int bbsid,String today) {
		return bbsdao.setTopPost(bbsid,today);
	}

	@Override
	public void addBbsForm(BbsForm bbsForm) {
		bbsdao.addBbsForm(bbsForm);
		
	}

	@Override
	public void updateOpTime(String time, int bbsid) {
		bbsdao.updateOpTime(time,bbsid);
		
	}

	@Override
	public void deleteBbsForm(int bbsid) {
		bbsdao.deleteBbsPost(bbsid);
		
	}

}
