package cn.xing.domain;

import java.io.Serializable;

public class BoardForm implements Serializable {
	private int boardid;
	private int boardclassid;
	private String boardname;
	private String boardmaster;
	private String boardpcard;//���湫��
	private int boardBbsnum;//��������
	private int  boardBbsundonum;//δ����ĸ�����
	private int  boardBbsgoodnum;//����������
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getBoardclassid() {
		return boardclassid;
	}
	public void setBoardclassid(int boardclassid) {
		this.boardclassid = boardclassid;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public String getBoardmaster() {
		return boardmaster;
	}
	public void setBoardmaster(String boardmaster) {
		this.boardmaster = boardmaster;
	}
	public String getBoardpcard() {
		return boardpcard;
	}
	public void setBoardpcard(String boardpcard) {
		this.boardpcard = boardpcard;
	}
	public int getBoardBbsnum() {
		return boardBbsnum;
	}
	public void setBoardBbsnum(int boardBbsnum) {
		this.boardBbsnum = boardBbsnum;
	}
	public int getBoardBbsundonum() {
		return boardBbsundonum;
	}
	public void setBoardBbsundonum(int boardBbsundonum) {
		this.boardBbsundonum = boardBbsundonum;
	}
	public int getBoardBbsgoodnum() {
		return boardBbsgoodnum;
	}
	public void setBoardBbsgoodnum(int boardBbsgoodnum) {
		this.boardBbsgoodnum = boardBbsgoodnum;
	}

}
