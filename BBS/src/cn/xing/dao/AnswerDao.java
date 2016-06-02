package cn.xing.dao;

import java.util.List;

import cn.xing.domain.BbsAnswerForm;

public interface AnswerDao extends Dao {

	/**
	 * 获取回复帖子数
	 * @param bbsid tb_bbs（根帖表 ） 的id
	 * @return 返回回复数
	 */
	int getAllAnsNum(int bbsid);

	/**
	 * 获取根帖的所有回应帖
	 * @param bbsid 根帖的id
	 * @return 返回回应贴组成的集合
	 */
	List<BbsAnswerForm> getAllAnsForm(int bbsid);

	/**
	 * 删除回帖信息
	 * @param bbsanswerid 回帖的id
	 * @return 如果修改成功 则返回大于零的数  否者返回小于等于零的数
	 */
	int deleteAnswerPost(int bbsanswerid);

	/**
	 * 向数据库中添加回复者的相关信息
	 * @param answerForm
	 */
	void addAnswerForm(BbsAnswerForm answerForm);

}
