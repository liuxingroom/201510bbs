package cn.xing.service;

import java.util.List;

import cn.xing.domain.BbsForm;
import cn.xing.domain.SearchFrom;

public interface BbsService extends Service {

	/**
	 * 收索帖子
	 * @param searchfrom 封装收索条件的Javabean
	 * @return 返回封装收索到的帖子的集合
	 */
	List<BbsForm> findBbsListShow(SearchFrom searchfrom);

	/**
	 * 获取所有的置顶帖子
	 * @param boardid 
 	 * @return 返回封装置顶帖子的集合
	 */
	List<BbsForm> getAllTopPost(int boardid);

	/**
	 * 获取普通帖子
	 * @param boardid
	 * @return 返回封装普通帖子的集合
	 */
	List<BbsForm> getAllComPost(int boardid);

	/**
	 * 获取精华帖子
	 * @return 返回封装镜湖帖子的集合
	 */
	List<BbsForm> getAllGoodPost();

	/**
	 * 获取我的所有帖子
	 * @param username 用户名
	 * @return 返回封装我的所有帖子的集合
	 */
	List<BbsForm> getAllMyPost(String username);

	/**
	 * 通过id来获取tb_bbs  对象
	 * @param bbsid 
	 * @return 返回 tb_bbs 的javabean对象
	 */
	BbsForm getBFBuyId(int bbsid);

	/**
	 * 设置为精华帖子
	 * @param bbsid 根帖的id
	 * @today
	 * @return 如果修改成功 则返回大于零的数  否者返回小于等于零的数
	 */
	int setGoodPost(int bbsid,String today);

	/**
	 * 设置为置顶
	 * @param bbsid 根帖的id
	 * @return 如果修改成功 则返回大于零的数  否者返回小于等于零的数
	 */
	int setTopPost(int bbsid,String today);

	/**
	 * 添加帖子
	 * @param bbsForm 封装新的帖子的信息
	 */
	void addBbsForm(BbsForm bbsForm);

	/**
	 * 将帖子提前（修改tb_bbs表中 bbsoptime字段是信息）
	 * @param time  要修改的信息
 	 * @param bbsid 根帖表的id
	 */
	void updateOpTime(String time, int bbsid);

	/**
	 * 根据根帖id 删除根帖
	 * @param bbsid  根帖id 
	 */
	void deleteBbsForm(int bbsid);

	

}
