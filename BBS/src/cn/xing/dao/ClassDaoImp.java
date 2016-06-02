package cn.xing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.xing.domain.ClassForm;
import cn.xing.util.TransactionManager;

public class ClassDaoImp implements ClassDao {

	@Override
	public List<ClassForm> getAllClassForm() {
		String sql="select * from tb_class";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<ClassForm>(ClassForm.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public ClassForm getClassFormById(int classid) {
		String sql="select * from tb_class where classid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			return runner.query(sql, new BeanHandler<ClassForm>(ClassForm.class), classid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int updateClassFormById(ClassForm classForm) {
		String sql="update tb_class set classname=?,classintro=? where classid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.update(sql, classForm.getClassname(),classForm.getClassintro(),classForm.getClassid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void addSort(ClassForm classForm) {
		String sql="insert into tb_class values(null,?,?)";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			runner.update(sql, classForm.getClassname(),classForm.getClassintro());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void deleteClassPost(int classid) {
		String sql="delete from tb_class where classid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,classid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	

}
