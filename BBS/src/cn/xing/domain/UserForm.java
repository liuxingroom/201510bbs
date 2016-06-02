package cn.xing.domain;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


@SuppressWarnings("serial")
public class UserForm implements Serializable ,HttpSessionBindingListener{
	private int id;
	private String username;//用户名
	private String oldpassword;
	private String userpassword;//密码
	private String aginpassword;
	private String userface;//头像
	private String usersex;//性别
	private String userphone;//电话
	private String useremail;//邮箱
	private String userfrom;//地址
	private String userable;//访问权限
	
	public String getUserable() {
		return userable;
	}
	public void setUserable(String userable) {
		this.userable = userable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getAginpassword() {
		return aginpassword;
	}
	public void setAginpassword(String aginpassword) {
		this.aginpassword = aginpassword;
	}
	public String getUserface() {
		return userface;
	}
	public void setUserface(String userface) {
		this.userface = userface;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserfrom() {
		return userfrom;
	}
	public void setUserfrom(String userfrom) {
		this.userfrom = userfrom;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserForm other = (UserForm) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//当用户登录时，代表用户的bean存入session中，此时自动向列表中添加自己
		HttpSession session=event.getSession();
		ServletContext context=session.getServletContext();
		
		Map<UserForm,HttpSession> map=(Map<UserForm, HttpSession>) context.getAttribute("usermap");
		map.put(this, session);
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//当用户下线时，无论是手动注销还是超时下线，代表用户的bean都会移除session，此时自动从用户列表中移除自己
		HttpSession session=event.getSession();
		ServletContext context=session.getServletContext();
		
		Map<UserForm,HttpSession> map=(Map<UserForm, HttpSession>) context.getAttribute("usermap");
		map.remove(this);
		
	}

}
