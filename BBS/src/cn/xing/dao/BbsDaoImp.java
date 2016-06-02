package cn.xing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.xing.domain.BbsForm;
import cn.xing.util.TransactionManager;

public class BbsDaoImp implements BbsDao {

	@Override
	public int getGTNumByBId(int boardid) {
		String sql="select count(*) from tb_bbs where bbsboardid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			return ((Long)runner.query(sql, new ScalarHandler(),boardid)).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	public int getUnDoNumById(int boardid) {
		String sql="select count(*) from tb_bbs where (bbsboardid=?) and (bbsid not in(select bbsanswerrootid from tb_bbsanswer))";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());

			return ((Long)runner.query(sql, new ScalarHandler(),boardid)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getGoodNumById(int boardid) {
		String sql="select count(*) from tb_bbs where bbsboardid=? and bbsisgood='1'";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return ((Long)runner.query(sql, new ScalarHandler(),boardid)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BbsForm> findBbsListShow(String subsql, String param,
			String opname) {
		String sql ="select * from tb_bbs where "+subsql+opname+"?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsForm>(BbsForm.class), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<BbsForm> getAllTopPost(int boardid) {
		String sql="select * from tb_bbs where bbsboardid=? and bbsistop='1' order by bbstotoptime desc";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsForm>(BbsForm.class), boardid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BbsForm> getAllComPost(int boardid) {
		String sql="select * from tb_bbs where bbsboardid=? and (bbsistop='0' or bbsisgood='1') order by bbstotoptime desc";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsForm>(BbsForm.class), boardid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BbsForm> getAllGoodPost() {
		String sql="select * from tb_bbs where bbsisgood='1'";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsForm>(BbsForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BbsForm> getAllMyPost(String username) {
		String sql="select * from tb_bbs where bbssender=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsForm>(BbsForm.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public BbsForm getBFBuyId(int bbsid) {
		String sql="select * from tb_bbs where bbsid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<BbsForm>(BbsForm.class), bbsid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int setGoodPost(int bbsid,String today) {
		String sql="update tb_bbs set bbsisgood='1',bbstotoptime=? where bbsid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			return runner.update(sql, today,bbsid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int setTopPost(int bbsid,String today) {
		String sql="update tb_bbs set bbsistop='1',bbstotoptime=? where bbsid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			return runner.update(sql,today ,bbsid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BbsForm> getAllPost(int boardid) {
		String sql="select * from tb_bbs where bbsboardid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsForm>(BbsForm.class), boardid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBbsPost(int bbsid) {
		String sql="delete from tb_bbs where bbsid=?";
		QueryRunner runner=new QueryRunner(TransactionManager.getSource());
		try {
			runner.update(sql,bbsid);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void addBbsForm(BbsForm bbsForm) {
		String sql="insert into tb_bbs values(null,?,?,?,?,?,?,?,?,null,?,null)";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, bbsForm.getBbsboardid(),bbsForm.getBbstitle(),bbsForm.getBbscontent(),bbsForm.getBbssender(),bbsForm.getBbssendtime(),bbsForm.getBbsface(),bbsForm.getBbsoptime(),bbsForm.getBbsistop(),bbsForm.getBbsisgood());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOpTime(String time, int bbsid) {
		String sql="update tb_bbs set bbsoptime=? where bbsid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, time,bbsid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
