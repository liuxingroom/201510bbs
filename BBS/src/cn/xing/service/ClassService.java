package cn.xing.service;

import java.util.List;

import cn.xing.annotation.Tran;
import cn.xing.domain.BoardForm;
import cn.xing.domain.ClassForm;

public interface ClassService extends Service{

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
	 * ɾ��ָ������̳���
	 * @param classid ָ����̳����id
	 */
	@Tran
	void deleteClass(int classid);

	

	


}
