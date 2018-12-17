package cn.tarena.ht.result;

public class CommentsResult {
	private Integer  lcid;//留言id
	private String  nick_name;//学生名称
	private String  uname;//学生学号
	private String message;//留言
	private Integer status;//状态 （0 未读， 1已读）
	public Integer getLcid() {
		return lcid;
	}
	public void setLcid(Integer lcid) {
		this.lcid = lcid;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
