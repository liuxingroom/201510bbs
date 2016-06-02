package cn.xing.dao;

import java.util.List;

import cn.xing.domain.BoardForm;

public interface BoardDao extends Dao {

	/**
	 * 根据td_class的ID来查找td_board表中的所有数据
	 * @param classID td_class表的ID
	 * @return 返回封装BoardForm的list集合
	 */
	List<BoardForm> getBoardFormByClassID(int classID);

	/**
	 * 通过BoardForm 的id来获取BoardForm的对象
	 * @param boardid
	 * @return 封装BoardForm的javabean
	 */
	BoardForm getBoardForm(int boardid);

	/**
	 * 根据id来删除发帖表中的信息
	 * @param boardid 发帖表的id
	 */
	void deleteBoardPost(int boardid);

	/**
	 * 
	 * 通过版主名称信息来获取td_board表中的所有数据
	 * @param username 版主名称信息
	 * @return 返回封装BoardForm的list集合
	 */
	List<BoardForm> getBoardFormByMaster(String username);

	/**
	 * 更新数据库信息
	 * @param boardForm 封装最新信息的版面信息
	 */
	void updateBoardForm(BoardForm boardForm);

	/**
	 * 添加版面信息
	 * @param boardForm 封装最新的版面信息
	 */
	void addBoardForm(BoardForm boardForm);

	

}
