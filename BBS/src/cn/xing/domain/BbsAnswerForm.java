package cn.xing.domain;

import java.io.Serializable;

public class BbsAnswerForm implements Serializable {
	private int bbsanswerid;
	private int bbsanswerrootid;
	private String bbsanswertitle;
	private String bbsanswercontent;
	private String bbsanswersender;
	private String bbsanswerface;
	private String bbsanswersendtime;
	public int getBbsanswerid() {
		return bbsanswerid;
	}
	public void setBbsanswerid(int bbsanswerid) {
		this.bbsanswerid = bbsanswerid;
	}
	public int getBbsanswerrootid() {
		return bbsanswerrootid;
	}
	public void setBbsanswerrootid(int bbsanswerrootid) {
		this.bbsanswerrootid = bbsanswerrootid;
	}
	public String getBbsanswertitle() {
		return bbsanswertitle;
	}
	public void setBbsanswertitle(String bbsanswertitle) {
		this.bbsanswertitle = bbsanswertitle;
	}
	public String getBbsanswercontent() {
		return bbsanswercontent;
	}
	public void setBbsanswercontent(String bbsanswercontent) {
		this.bbsanswercontent = bbsanswercontent;
	}
	public String getBbsanswersender() {
		return bbsanswersender;
	}
	public void setBbsanswersender(String bbsanswersender) {
		this.bbsanswersender = bbsanswersender;
	}
	public String getBbsanswerface() {
		return bbsanswerface;
	}
	public void setBbsanswerface(String bbsanswerface) {
		this.bbsanswerface = bbsanswerface;
	}
	public String getBbsanswersendtime() {
		return bbsanswersendtime;
	}
	public void setBbsanswersendtime(String bbsanswersendtime) {
		this.bbsanswersendtime = bbsanswersendtime;
	}
}
