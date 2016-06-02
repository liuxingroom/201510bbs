package cn.xing.dao;

import java.util.List;

import cn.xing.domain.UserForm;

public interface UserDao extends Dao{

	/**
	 * 根据用户名和密码来查找数据
	 * @param username 要查找的用户名
	 * @param userpassword 要查找的密码
	 * @return 若存在该用户则返回该用户的对象  否则返回null
	 */
	UserForm getUserByNameAndPsw(String username, String userpassword);

	/**
	 * 添加用户
	 * @param user 要添加的Javabean
	 */
	void addUserFrom(UserForm user);

	/**
	 * 通过用户名来查找用户
	 * @param username 用户名
	 * @return 返回封装用户的Javabean
	 */
	UserForm getUserByName(String username);

	/**
	 * 通过权限能力来获取用户
	 * @param able 表示权限能 力
	 * @return 返回封装用户的list集合
	 */
	List<UserForm> getUserByAale(String able);

	/**
	 * 通过用户id来获取用户对象
	 * @param id 用户id
	 * @return 返回用户的Javabean对象
	 */
	UserForm getUserById(int id);

	/**
	 * 更新用户信息
	 * @param userForm 封装新的用户信息的Javabean
 	 */
	void updateUser(UserForm userForm);

	/**
	 * 根据用户id来删除用户信息
	 * @param id
	 */
	void deleteUser(int id);

	

}
