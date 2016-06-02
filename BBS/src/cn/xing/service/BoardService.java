package cn.xing.service;

import java.util.List;

import cn.xing.annotation.Tran;
import cn.xing.domain.BoardForm;

public interface BoardService extends Service {

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
	 * 更新数据库信息
	 * @param boardForm 封装最新信息的版面信息
	 */
	void updateBoardForm(BoardForm boardForm);

	/**
	 * 根据指定boardid来删除版面
	 * @param boardid 指定的boardid
	 */
	@Tran
	void deleteBoardForm(int boardid);

	/**
	 * 添加版面信息
	 * @param boardForm 封装最新的版面信息
	 */
	void addBoardForm(BoardForm boardForm);

}
