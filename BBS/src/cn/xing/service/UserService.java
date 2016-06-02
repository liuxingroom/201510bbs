package cn.xing.service;

import java.util.List;

import cn.xing.annotation.Tran;
import cn.xing.domain.UserForm;

public interface UserService extends Service {

	/**
	 * 根据用户名和密码来查找数据
	 * @param username 要查找的用户名
	 * @param userpassword 要查找的密码
	 * @return 若存在该用户则返回该用户的对象  否则返回null
	 */
	UserForm getUserByNameAndPsw(String username, String userpassword);

	/**
	 * 判断该用户名是否已经被注册过
	 * @param username 要检测的用户名
	 * @return 如果已经被注册过则返回true 如果没有被注册过就返回false
	 */
	boolean hasName(String username);

	/**
	 * 添加用户
	 * @param userfrom 要添加的Javabean
	 */
	void addUserFrom(UserForm userfrom);

	/**
	 * 通过用户名来获取 用户对象
	 * @param username 用户名
	 * @return 返回用户的Javabean对象
	 */
	UserForm getUserByName(String username);

	/**
	 * 通过权限能力来获取用户
	 * @param able 表示权限能 力
	 * @return 返回封装用户的list集合
	 */
	List<UserForm> getUserByAble(String able);

	/**
	 * 通过用户id来获取用户
	 * @param id 用户id
	 * @return 如果存在则返回用户的Javabean对象    否则返回null
	 */
	UserForm getUserById(int id);

	/**
	 * 更新用户信息
	 * @param userForm 封装新的用户信息的Javabean
 	 */
	void updateUser(UserForm userForm);

	/**
	 * 删除指定用户信息
	 * @param id 要删除的用户id
	 * @param username  要删除的用户名
	 */
	@Tran
	void deleteUser(int id, String username);

}
