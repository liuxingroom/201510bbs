package cn.xing.dao;

import java.util.List;

import cn.xing.domain.BbsAnswerForm;

public interface AnswerDao extends Dao {

	/**
	 * ��ȡ�ظ�������
	 * @param bbsid tb_bbs�������� �� ��id
	 * @return ���ػظ���
	 */
	int getAllAnsNum(int bbsid);

	/**
	 * ��ȡ���������л�Ӧ��
	 * @param bbsid ������id
	 * @return ���ػ�Ӧ����ɵļ���
	 */
	List<BbsAnswerForm> getAllAnsForm(int bbsid);

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
