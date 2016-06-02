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
	private String username;//�û���
	private String oldpassword;
	private String userpassword;//����
	private String aginpassword;
	private String userface;//ͷ��
	private String usersex;//�Ա�
	private String userphone;//�绰
	private String useremail;//����
	private String userfrom;//��ַ
	private String userable;//����Ȩ��
	
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
		//���û���¼ʱ�������û���bean����session�У���ʱ�Զ����б�������Լ�
		HttpSession session=event.getSession();
		ServletContext context=session.getServletContext();
		
		Map<UserForm,HttpSession> map=(Map<UserForm, HttpSession>) context.getAttribute("usermap");
		map.put(this, session);
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//���û�����ʱ���������ֶ�ע�����ǳ�ʱ���ߣ������û���bean�����Ƴ�session����ʱ�Զ����û��б����Ƴ��Լ�
		HttpSession session=event.getSession();
		ServletContext context=session.getServletContext();
		
		Map<UserForm,HttpSession> map=(Map<UserForm, HttpSession>) context.getAttribute("usermap");
		map.remove(this);
		
	}

}
