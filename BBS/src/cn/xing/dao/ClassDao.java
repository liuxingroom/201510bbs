package cn.xing.dao;

import java.util.List;

import cn.xing.domain.ClassForm;

public interface ClassDao extends Dao{

	/**
	 * ��ȡtb_bbs���е�����
	 * @return ��װClassForm�ļ���
	 */
	List<ClassForm> getAllClassForm();

	/**
	 * ͨ��classid ����ȡ��̳������
	 * @param classid 
	 * @return ���ط�װ��̳����Javabean
	 */
	ClassForm getClassFormById(int classid);

	/**
	 * �޸� ĳ����̳���
	 * @param classForm ��װ�µ������µĵ�Javabean����
	 * @return ����ɹ��򷵻�һ�����������   ���򷵻�һ��С�ڵ��������
	 */
	int updateClassFormById(ClassForm classForm);

	/**
	 * �����̳���
	 * @param classForm ��װ��̳����javabean
	 */
	void addSort(ClassForm classForm);

	/**
	 * //ɾ����̳���е���Ϣ
	 * @param classid ��̳���id
	 */
	void deleteClassPost(int classid);

	

	
}
