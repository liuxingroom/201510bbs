package cn.xing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.xing.domain.BbsAnswerForm;
import cn.xing.util.TransactionManager;

public class AnswerDaoImp implements AnswerDao {

	@Override
	public int getAllAnsNum(int bbsid) {
		String sql="select count(bbsanswerid) from tb_bbsanswer where bbsanswerrootid=? ";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return ((Long)runner.query(sql, new ScalarHandler(), bbsid)).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	
	
	@Override
	public List<BbsAnswerForm> getAllAnsForm(int bbsid) {
		String sql="select * from tb_bbsanswer where bbsanswerrootid=? order by bbsanswersendtime ";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<BbsAnswerForm>(BbsAnswerForm.class), bbsid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}



	@Override
	public int deleteAnswerPost(int bbsanswerid) {
		String sql="delete from tb_bbsanswer where bbsanswerid=?";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.update(sql, bbsanswerid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}



	@Override
	public void addAnswerForm(BbsAnswerForm answerForm) {
		String sql="insert into tb_bbsanswer values(null,?,?,?,?,?,?)";
		try {
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql, answerForm.getBbsanswerrootid(),answerForm.getBbsanswertitle(),answerForm.getBbsanswercontent(),answerForm.getBbsanswersender(),answerForm.getBbsanswersendtime(),answerForm.getBbsanswerface());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
