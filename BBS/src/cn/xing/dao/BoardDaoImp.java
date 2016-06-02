package cn.xing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.xing.domain.BoardForm;
import cn.xing.util.TransactionManager;

public class BoardDaoImp implements BoardDao {

	@Override
	public List<BoardForm> getBoardFormByClassID(int classID) {
		String sql="select * from tb_board where boardclassid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BoardForm>(BoardForm.class), classID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public BoardForm getBoardForm(int boardid) {
		String sql="select * from tb_board where boardid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			return runner.query(sql, new BeanHandler<BoardForm>(BoardForm.class), boardid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBoardPost(int boardid) {
		String sql="delete from tb_board where boardid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			runner.update(sql,boardid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BoardForm> getBoardFormByMaster(String username) {
		String sql="select * from tb_board where boardmaster=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BoardForm>(BoardForm.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateBoardForm(BoardForm boardForm) {
		String sql="update tb_board set boardclassid=?,boardname=?,boardmaster=?,boardpcard=? where boardid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			runner.update(sql,boardForm.getBoardclassid(),boardForm.getBoardname(),boardForm.getBoardmaster(),boardForm.getBoardpcard(),boardForm.getBoardid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void addBoardForm(BoardForm boardForm) {
		String sql="insert into tb_board values(null,?,?,?,?)";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, boardForm.getBoardclassid(),boardForm.getBoardname(),boardForm.getBoardmaster(),boardForm.getBoardpcard());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
