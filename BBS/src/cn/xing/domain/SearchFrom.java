package cn.xing.domain;

import java.io.Serializable;

public class SearchFrom implements Serializable{
	private String subsql;//��������
	private String sqlvalue;//���ҹؼ���
	private String searchtype;//��������
	public String getSubsql() {
		return subsql;
	}
	public void setSubsql(String subsql) {
		this.subsql = subsql;
	}
	public String getSqlvalue() {
		return sqlvalue;
	}
	public void setSqlvalue(String sqlvalue) {
		this.sqlvalue = sqlvalue;
	}
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
}
