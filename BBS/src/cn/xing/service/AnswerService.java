package cn.xing.service;

import java.util.Map;

import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.UserForm;

public interface AnswerService extends Service{

	/**
	 * 通过Bbs的id来获取回帖的内容
	 * @param bbsid Bbsid
	 * @return 返回封装回帖 以及回帖人的信息
	 */
	Map<BbsAnswerForm, UserForm> getAUByAsId(int bbsid);

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
