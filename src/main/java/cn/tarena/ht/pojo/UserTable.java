package cn.tarena.ht.pojo;

import java.io.Serializable;



public class UserTable implements Serializable{
	
	
	private Integer  utid;//id
	private String uname;//用户名
	private String pwd;//密码
	private String nick_name;//自定义名称
	private String email;//邮箱
	private String phone;//电话
	private int gender;//性别 （0 女 1 男）
	private int type;//用户类型（0学生 1老师）
	private int status;//状态 （0 可用 1冻结）
	
	public Integer getUtid() {
		return utid;
	}
	public void setUtid(Integer utid) {
		this.utid = utid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
	



 
 
 
}
