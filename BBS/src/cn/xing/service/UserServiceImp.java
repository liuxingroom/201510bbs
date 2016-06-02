package cn.xing.service;

import java.util.List;

import cn.xing.dao.AnswerDao;
import cn.xing.dao.BbsDao;
import cn.xing.dao.BoardDao;
import cn.xing.dao.UserDao;
import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.BbsForm;
import cn.xing.domain.BoardForm;
import cn.xing.domain.UserForm;
import cn.xing.factory.BasicFactory;

public class UserServiceImp implements UserService {

	UserDao userdao=BasicFactory.getFactory().getDao(UserDao.class);
	BoardDao boardDao=BasicFactory.getFactory().getDao(BoardDao.class);
	BbsDao bbsDao=BasicFactory.getFactory().getDao(BbsDao.class);
	AnswerDao answerDao=BasicFactory.getFactory().getDao(AnswerDao.class);
	@Override
	public UserForm getUserByNameAndPsw(String username, String userpassword) {
		return userdao.getUserByNameAndPsw(username,userpassword);
	}
	@Override
	public boolean hasName(String username) {
		return userdao.getUserByName(username)!=null;
		
	}
	@Override
	public void addUserFrom(UserForm userfrom) {
		UserForm user=userfrom;
		//设置访问权限（是普通用户还是管理员）
		user.setUserable("1");
		userdao.addUserFrom(user);
	}
	@Override
	public UserForm getUserByName(String username) {
		return userdao.getUserByName(username);
	}
	@Override
	public List<UserForm> getUserByAble(String able) {
		
		return userdao.getUserByAale(able);
	}
	@Override
	public UserForm getUserById(int id) {
		
		return userdao.getUserById(id);
	}
	@Override
	public void updateUser(UserForm userForm) {
		userdao.updateUser(userForm);
		
	}
	@Override
	public void deleteUser(int id,String username) {
		//获取指定版主的BoardForm对象
		List<BoardForm> bfList=boardDao.getBoardFormByMaster(username);
		for(BoardForm bf:bfList){
			List<BbsForm> bsfList=bbsDao.getAllPost(bf.getBoardid());
			for(BbsForm bsf:bsfList){
				List<BbsAnswerForm> bafList=answerDao.getAllAnsForm(bsf.getBbsid());
				for(BbsAnswerForm baf:bafList){
					answerDao.deleteAnswerPost(baf.getBbsanswerid());
				}
				bbsDao.deleteBbsPost(bsf.getBbsid());
			}
			boardDao.deleteBoardPost(bf.getBoardid());
		}
		userdao.deleteUser(id);
		
	}

}
