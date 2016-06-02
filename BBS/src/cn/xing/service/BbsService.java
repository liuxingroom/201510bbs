package cn.xing.service;

import java.util.List;

import cn.xing.domain.BbsForm;
import cn.xing.domain.SearchFrom;

public interface BbsService extends Service {

	/**
	 * ��������
	 * @param searchfrom ��װ����������Javabean
	 * @return ���ط�װ�����������ӵļ���
	 */
	List<BbsForm> findBbsListShow(SearchFrom searchfrom);

	/**
	 * ��ȡ���е��ö�����
	 * @param boardid 
 	 * @return ���ط�װ�ö����ӵļ���
	 */
	List<BbsForm> getAllTopPost(int boardid);

	/**
	 * ��ȡ��ͨ����
	 * @param boardid
	 * @return ���ط�װ��ͨ���ӵļ���
	 */
	List<BbsForm> getAllComPost(int boardid);

	/**
	 * ��ȡ��������
	 * @return ���ط�װ�������ӵļ���
	 */
	List<BbsForm> getAllGoodPost();

	/**
	 * ��ȡ�ҵ���������
	 * @param username �û���
	 * @return ���ط�װ�ҵ��������ӵļ���
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
	 * @today
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
	 * �������
	 * @param bbsForm ��װ�µ����ӵ���Ϣ
	 */
	void addBbsForm(BbsForm bbsForm);

	/**
	 * ��������ǰ���޸�tb_bbs���� bbsoptime�ֶ�����Ϣ��
	 * @param time  Ҫ�޸ĵ���Ϣ
 	 * @param bbsid �������id
	 */
	void updateOpTime(String time, int bbsid);

	/**
	 * ���ݸ���id ɾ������
	 * @param bbsid  ����id 
	 */
	void deleteBbsForm(int bbsid);

	

}
