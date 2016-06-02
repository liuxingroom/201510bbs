package cn.xing.dao;

import java.util.List;

import cn.xing.domain.ClassForm;

public interface ClassDao extends Dao{

	/**
	 * 获取tb_bbs表中的数据
	 * @return 封装ClassForm的集合
	 */
	List<ClassForm> getAllClassForm();

	/**
	 * 通过classid 来获取论坛类别对象
	 * @param classid 
	 * @return 返回封装论坛类别的Javabean
	 */
	ClassForm getClassFormById(int classid);

	/**
	 * 修改 某个论坛类别
	 * @param classForm 封装新的数据新的的Javabean对象
	 * @return 如果成功则返回一个大于零的数   否则返回一个小于等于零的数
	 */
	int updateClassFormById(ClassForm classForm);

	/**
	 * 添加论坛类别
	 * @param classForm 封装论坛类别的javabean
	 */
	void addSort(ClassForm classForm);

	/**
	 * //删除论坛表中的信息
	 * @param classid 论坛表的id
	 */
	void deleteClassPost(int classid);

	

	
}
