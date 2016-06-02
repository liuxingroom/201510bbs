package cn.xing.domain;

import java.io.Serializable;

public class ClassForm implements Serializable{
	private int classid;//
	private String classname;//±ÍÃ‚
	private String classintro;//¬€Ã≥ΩÈ…‹
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getClassintro() {
		return classintro;
	}
	public void setClassintro(String classintro) {
		this.classintro = classintro;
	}
	
	
}
