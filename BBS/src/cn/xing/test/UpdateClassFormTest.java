package cn.xing.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.xing.util.TransactionManager;

public class UpdateClassFormTest {
	@Test
	public void updateClassFormTest(){
		String sql="update tb_class set classname=?,classintro=? where classid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			 runner.update(sql, "WEB","��ӭ����WEB�������磬���ཻ��������ѧϰ��",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
