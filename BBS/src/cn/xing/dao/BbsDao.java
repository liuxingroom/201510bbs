package cn.xing.dao;

import java.util.List;

import cn.xing.domain.BbsForm;

public interface BbsDao extends Dao {

	/**
	 * 根据Board的id来统计跟帖总数
	 * @param boardid
	 * @return
	 */
	 int getGTNumByBId(int boardid);

	 /**
	  * 根据Board的id来统计未处理的帖的总数
	  * @param boardid 
	  * @return
	  */
	int getUnDoNumById(int boardid);

	/**
	 * 根据Board的id来统计精华的跟帖数
	 * @param boardid
	 * @return
	 */
	int getGoodNumById(int boardid);

	/**
	 * 收索帖子
	 * @param subsql 查找条件
	 * @param opname 
	 * @param param	
	 * @return 返回封装收索到的帖子的集合
	 */
	List<BbsForm> findBbsListShow(String subsql, String param,
			String opname);

	/**
	 * 获取置顶帖子
	 * @param boardid
	 * @return 返回封装置顶帖子的集合
	 */
	List<BbsForm> getAllTopPost(int boardid);

	/**
	 * 获取普通帖子
	 * @param boardid
	 * @return 封装普通帖子的集合
	 */
	List<BbsForm> getAllComPost(int boardid);

	/**
	 * 获取所有的精华帖子
	 * @return 返回封装精华帖子的集合
	 */
	List<BbsForm> getAllGoodPost();

	/**
	 * 获取用户的所有帖子
	 * @param username 用户名
	 * @return 返回封装用户所有帖子的集合
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
	 * 根据发帖表（tb_board）的id来查询根帖表（tb_bbs）表中的数据
	 * @param boardid 
	 * @return 若存在 则返回封装根帖表的List集合  
	 */
	List<BbsForm> getAllPost(int boardid);

	/**
	 * 根据id来删除根帖表中的信息
	 * @param bbsid 根帖表id
	 * 
	 */
	void deleteBbsPost(int bbsid);

	/**
	 * 向数据库中添加新的帖子的记录信息
	 * @param bbsForm 封装新的帖子的信息
	 */
	void addBbsForm(BbsForm bbsForm);

	/**
	 * 将帖子提前（修改tb_bbs表中 bbsoptime字段是信息）
	 * @param time  要修改的信息
 	 * @param bbsid 根帖表的id
	 */
	void updateOpTime(String time, int bbsid);

	

	
	

}
