package cn.xing.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.xing.dao.AnswerDao;
import cn.xing.dao.UserDao;
import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;

public class AnswerServiceImp implements AnswerService{

	AnswerDao answerDao=BasicFactory.getFactory().getDao(AnswerDao.class);
	UserDao userDao=BasicFactory.getFactory().getDao(UserDao.class);
	Map<BbsAnswerForm, UserForm> buMap=new LinkedHashMap<BbsAnswerForm, UserForm>();
	@Override
	public Map<BbsAnswerForm, UserForm> getAUByAsId(int bbsid) {
		List<BbsAnswerForm> bnfList=answerDao.getAllAnsForm(bbsid);
		for(BbsAnswerForm bnf:bnfList){
			String username=bnf.getBbsanswersender();
			UserForm userForm=userDao.getUserByName(username);
			buMap.put(bnf, userForm);
		}
		return buMap;
	}
	@Override
	public int deleteAnswerPost(int bbsanswerid) {
		return answerDao.deleteAnswerPost(bbsanswerid);
		
	}
	@Override
	public void addAnswerForm(BbsAnswerForm answerForm) {
		answerDao.addAnswerForm(answerForm);
		
	}

}
