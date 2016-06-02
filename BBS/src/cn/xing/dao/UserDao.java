package cn.xing.dao;

import java.util.List;

import cn.xing.domain.UserForm;

public interface UserDao extends Dao{

	/**
	 * �����û�������������������
	 * @param username Ҫ���ҵ��û���
	 * @param userpassword Ҫ���ҵ�����
	 * @return �����ڸ��û��򷵻ظ��û��Ķ���  ���򷵻�null
	 */
	UserForm getUserByNameAndPsw(String username, String userpassword);

	/**
	 * ����û�
	 * @param user Ҫ��ӵ�Javabean
	 */
	void addUserFrom(UserForm user);

	/**
	 * ͨ���û����������û�
	 * @param username �û���
	 * @return ���ط�װ�û���Javabean
	 */
	UserForm getUserByName(String username);

	/**
	 * ͨ��Ȩ����������ȡ�û�
	 * @param able ��ʾȨ���� ��
	 * @return ���ط�װ�û���list����
	 */
	List<UserForm> getUserByAale(String able);

	/**
	 * ͨ���û�id����ȡ�û�����
	 * @param id �û�id
	 * @return �����û���Javabean����
	 */
	UserForm getUserById(int id);

	/**
	 * �����û���Ϣ
	 * @param userForm ��װ�µ��û���Ϣ��Javabean
 	 */
	void updateUser(UserForm userForm);

	/**
	 * �����û�id��ɾ���û���Ϣ
	 * @param id
	 */
	void deleteUser(int id);

	

}
