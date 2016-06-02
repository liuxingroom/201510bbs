package cn.xing.service;

import java.util.List;

import cn.xing.annotation.Tran;
import cn.xing.domain.UserForm;

public interface UserService extends Service {

	/**
	 * �����û�������������������
	 * @param username Ҫ���ҵ��û���
	 * @param userpassword Ҫ���ҵ�����
	 * @return �����ڸ��û��򷵻ظ��û��Ķ���  ���򷵻�null
	 */
	UserForm getUserByNameAndPsw(String username, String userpassword);

	/**
	 * �жϸ��û����Ƿ��Ѿ���ע���
	 * @param username Ҫ�����û���
	 * @return ����Ѿ���ע����򷵻�true ���û�б�ע����ͷ���false
	 */
	boolean hasName(String username);

	/**
	 * ����û�
	 * @param userfrom Ҫ��ӵ�Javabean
	 */
	void addUserFrom(UserForm userfrom);

	/**
	 * ͨ���û�������ȡ �û�����
	 * @param username �û���
	 * @return �����û���Javabean����
	 */
	UserForm getUserByName(String username);

	/**
	 * ͨ��Ȩ����������ȡ�û�
	 * @param able ��ʾȨ���� ��
	 * @return ���ط�װ�û���list����
	 */
	List<UserForm> getUserByAble(String able);

	/**
	 * ͨ���û�id����ȡ�û�
	 * @param id �û�id
	 * @return ��������򷵻��û���Javabean����    ���򷵻�null
	 */
	UserForm getUserById(int id);

	/**
	 * �����û���Ϣ
	 * @param userForm ��װ�µ��û���Ϣ��Javabean
 	 */
	void updateUser(UserForm userForm);

	/**
	 * ɾ��ָ���û���Ϣ
	 * @param id Ҫɾ�����û�id
	 * @param username  Ҫɾ�����û���
	 */
	@Tran
	void deleteUser(int id, String username);

}
