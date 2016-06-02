package cn.xing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.xing.domain.UserForm;
import cn.xing.util.TransactionManager;

public class UserDaoImp implements UserDao {

	@Override
	public UserForm getUserByNameAndPsw(String username, String userpassword) {
		String sql="select * from tb_user where username=? and userpassword=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<UserForm>(UserForm.class), username,userpassword);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public UserForm getUserByName(String username) {
		String sql="select * from tb_user where username=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<UserForm>(UserForm.class), username);
		} catch (SQLException e){ 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void addUserFrom(UserForm user) {
		String sql="insert into tb_user values(null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, user.getUsername(),user.getUserpassword(),user.getUserface(),user.getUsersex(),user.getUserphone(),user.getUseremail(),user.getUserfrom(),user.getUserable());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserForm> getUserByAale(String able) {
		String sql="select * from tb_user where userable=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<UserForm>(UserForm.class), able);
		} catch (SQLException e){ 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public UserForm getUserById(int id) {
		String sql="select * from tb_user where id=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<UserForm>(UserForm.class), id);
		} catch (SQLException e){ 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateUser(UserForm userForm) {
		String sql="update tb_user set username=?,userpassword=?,userface=?,usersex=?,userphone=?,useremail=?,userfrom=?,userable=? where id=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, userForm.getUsername(),userForm.getUserpassword(),userForm.getUserface(),userForm.getUsersex(),userForm.getUserphone(),userForm.getUseremail(),userForm.getUserfrom(),userForm.getUserable(),userForm.getId());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {
		String sql="delete from tb_user where id=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	

	
}
