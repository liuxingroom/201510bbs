package cn.xing.service;

import java.util.List;

import cn.xing.annotation.Tran;
import cn.xing.domain.BoardForm;

public interface BoardService extends Service {

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
	 * �������ݿ���Ϣ
	 * @param boardForm ��װ������Ϣ�İ�����Ϣ
	 */
	void updateBoardForm(BoardForm boardForm);

	/**
	 * ����ָ��boardid��ɾ������
	 * @param boardid ָ����boardid
	 */
	@Tran
	void deleteBoardForm(int boardid);

	/**
	 * ��Ӱ�����Ϣ
	 * @param boardForm ��װ���µİ�����Ϣ
	 */
	void addBoardForm(BoardForm boardForm);

}
