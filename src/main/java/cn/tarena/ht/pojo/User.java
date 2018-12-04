package cn.tarena.ht.pojo;

public class User{
	private Integer  uid;//id
	private String name;//用户名
	private String pwd;//密码
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
	
	
	



 
 
 
}
