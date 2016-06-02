package cn.xing.service;

import java.util.Map;

import cn.xing.domain.BbsAnswerForm;
import cn.xing.domain.UserForm;

public interface AnswerService extends Service{

	/**
	 * ͨ��Bbs��id����ȡ����������
	 * @param bbsid Bbsid
	 * @return ���ط�װ���� �Լ������˵���Ϣ
	 */
	Map<BbsAnswerForm, UserForm> getAUByAsId(int bbsid);

	/**
	 * ɾ��������Ϣ
	 * @param bbsanswerid ������id
	 * @return ����޸ĳɹ� �򷵻ش��������  ���߷���С�ڵ��������
	 */
	int deleteAnswerPost(int bbsanswerid);

	/**
	 * �����ݿ�����ӻظ��ߵ������Ϣ
	 * @param answerForm
	 */
	void addAnswerForm(BbsAnswerForm answerForm);

}
