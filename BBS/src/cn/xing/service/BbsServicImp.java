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
		String subsql=searchfrom.getSubsql();//��������
		String sqlvalue=searchfrom.getSqlvalue();//���ҹؼ���
	    String searchtype=searchfrom.getSearchtype();//��������
	    String param="";
	    String opname="";
	    if(searchtype.equals("all")){
	    	opname=" = ";
	    	param=sqlvalue;
	    }else{
	    	opname=" like ";
	    	param="%"+sqlvalue+"%";
	    }
	    //�����������ҵĸ�������
		List<BbsForm> bf=bbsdao.findBbsListShow(subsql,param,opname);
		int bbsAnswerNum=0;//���ó�ʼֵλ0    ���ӵĻظ���
		String bbsLastUpdateUser="";//���ظ���
		String bbsLastUpdateTime="";//���ظ�ʱ�� 
		for(BbsForm bsf:bf){
			int bbsid=bsf.getBbsid();
			//��ȡ���лظ���������
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//��ѯ���ø��������лظ�����(���ظ�ʱ����������),��ȡ���ظ��ˡ��ظ�ʱ��
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//���ûظ������������ظ��ˡ����ظ�ʱ��
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
		int bbsAnswerNum=0;//���ó�ʼֵλ0    ���ӵĻظ���
		String bbsLastUpdateUser="";//���ظ���
		String bbsLastUpdateTime="";//���ظ�ʱ�� 
		for(BbsForm bsf:topPost){
			int bbsid=bsf.getBbsid();
			//��ȡ���лظ���������
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//��ѯ���ø��������лظ�����(���ظ�ʱ����������),��ȡ���ظ��ˡ��ظ�ʱ��
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){//������ڻظ�������
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				//���ûظ������������ظ��ˡ����ظ�ʱ��
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
		int bbsAnswerNum=0;//���ó�ʼֵλ0    ���ӵĻظ���
		String bbsLastUpdateUser="";//���ظ���
		String bbsLastUpdateTime="";//���ظ�ʱ�� 
		for(BbsForm bsf:comPost){
			int bbsid=bsf.getBbsid();
			//��ȡ���лظ���������
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//��ѯ���ø��������лظ�����(���ظ�ʱ����������),��ȡ���ظ��ˡ��ظ�ʱ��
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//���ûظ������������ظ��ˡ����ظ�ʱ��
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
		int bbsAnswerNum=0;//���ó�ʼֵλ0    ���ӵĻظ���
		String bbsLastUpdateUser="";//���ظ���
		String bbsLastUpdateTime="";//���ظ�ʱ�� 
		for(BbsForm gp:goodPost){
			int bbsid=gp.getBbsid();
			//��ȡ���лظ���������
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//��ѯ���ø��������лظ�����(���ظ�ʱ����������),��ȡ���ظ��ˡ��ظ�ʱ��
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//���ûظ������������ظ��ˡ����ظ�ʱ��
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
		int bbsAnswerNum=0;//���ó�ʼֵλ0    ���ӵĻظ���
		String bbsLastUpdateUser="";//���ظ���
		String bbsLastUpdateTime="";//���ظ�ʱ�� 
		for(BbsForm bsf:myPost){
			int bbsid=bsf.getBbsid();
			//��ȡ���лظ���������
			bbsAnswerNum=answerDao.getAllAnsNum(bbsid);
			
			//��ѯ���ø��������лظ�����(���ظ�ʱ����������),��ȡ���ظ��ˡ��ظ�ʱ��
			List<BbsAnswerForm> bsfList=answerDao.getAllAnsForm(bbsid);
			if(bsfList.size()>0){
				bbsLastUpdateUser=bsfList.get(bsfList.size()-1).getBbsanswersender();
				bbsLastUpdateTime=bsfList.get(bsfList.size()-1).getBbsanswersendtime();
				
				//���ûظ������������ظ��ˡ����ظ�ʱ��
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
