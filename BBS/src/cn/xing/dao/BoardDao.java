package cn.xing.dao;

import java.util.List;

import cn.xing.domain.BoardForm;

public interface BoardDao extends Dao {

	/**
	 * ����td_class��ID������td_board���е���������
	 * @param classID td_class���ID
	 * @return ���ط�װBoardForm��list����
	 */
	List<BoardForm> getBoardFormByClassID(int classID);

	/**
	 * ͨ��BoardForm ��id����ȡBoardForm�Ķ���
	 * @param boardid
	 * @return ��װBoardForm��javabean
	 */
	BoardForm getBoardForm(int boardid);

	/**
	 * ����id��ɾ���������е���Ϣ
	 * @param boardid �������id
	 */
	void deleteBoardPost(int boardid);

	/**
	 * 
	 * ͨ������������Ϣ����ȡtd_board���е���������
	 * @param username ����������Ϣ
	 * @return ���ط�װBoardForm��list����
	 */
	List<BoardForm> getBoardFormByMaster(String username);

	/**
	 * �������ݿ���Ϣ
	 * @param boardForm ��װ������Ϣ�İ�����Ϣ
	 */
	void updateBoardForm(BoardForm boardForm);

	/**
	 * ��Ӱ�����Ϣ
	 * @param boardForm ��װ���µİ�����Ϣ
	 */
	void addBoardForm(BoardForm boardForm);

	

}
