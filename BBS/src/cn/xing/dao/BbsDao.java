package cn.xing.dao;

import java.util.List;

import cn.xing.domain.BbsForm;

public interface BbsDao extends Dao {

	/**
	 * ����Board��id��ͳ�Ƹ�������
	 * @param boardid
	 * @return
	 */
	 int getGTNumByBId(int boardid);

	 /**
	  * ����Board��id��ͳ��δ�������������
	  * @param boardid 
	  * @return
	  */
	int getUnDoNumById(int boardid);

	/**
	 * ����Board��id��ͳ�ƾ����ĸ�����
	 * @param boardid
	 * @return
	 */
	int getGoodNumById(int boardid);

	/**
	 * ��������
	 * @param subsql ��������
	 * @param opname 
	 * @param param	
	 * @return ���ط�װ�����������ӵļ���
	 */
	List<BbsForm> findBbsListShow(String subsql, String param,
			String opname);

	/**
	 * ��ȡ�ö�����
	 * @param boardid
	 * @return ���ط�װ�ö����ӵļ���
	 */
	List<BbsForm> getAllTopPost(int boardid);

	/**
	 * ��ȡ��ͨ����
	 * @param boardid
	 * @return ��װ��ͨ���ӵļ���
	 */
	List<BbsForm> getAllComPost(int boardid);

	/**
	 * ��ȡ���еľ�������
	 * @return ���ط�װ�������ӵļ���
	 */
	List<BbsForm> getAllGoodPost();

	/**
	 * ��ȡ�û�����������
	 * @param username �û���
	 * @return ���ط�װ�û��������ӵļ���
	 */
	List<BbsForm> getAllMyPost(String username);

	/**
	 * ͨ��id����ȡtb_bbs  ����
	 * @param bbsid 
	 * @return ���� tb_bbs ��javabean����
	 */
	BbsForm getBFBuyId(int bbsid);

	/**
	 * ����Ϊ��������
	 * @param bbsid ������id
	 * @return ����޸ĳɹ� �򷵻ش��������  ���߷���С�ڵ��������
	 */
	int setGoodPost(int bbsid,String today);

	/**
	 * ����Ϊ�ö�
	 * @param bbsid ������id
	 * @return ����޸ĳɹ� �򷵻ش��������  ���߷���С�ڵ��������
	 */
	int setTopPost(int bbsid,String today);

	/**
	 * ���ݷ�����tb_board����id����ѯ������tb_bbs�����е�����
	 * @param boardid 
	 * @return ������ �򷵻ط�װ�������List����  
	 */
	List<BbsForm> getAllPost(int boardid);

	/**
	 * ����id��ɾ���������е���Ϣ
	 * @param bbsid ������id
	 * 
	 */
	void deleteBbsPost(int bbsid);

	/**
	 * �����ݿ�������µ����ӵļ�¼��Ϣ
	 * @param bbsForm ��װ�µ����ӵ���Ϣ
	 */
	void addBbsForm(BbsForm bbsForm);

	/**
	 * ��������ǰ���޸�tb_bbs���� bbsoptime�ֶ�����Ϣ��
	 * @param time  Ҫ�޸ĵ���Ϣ
 	 * @param bbsid �������id
	 */
	void updateOpTime(String time, int bbsid);

	

	
	

}
