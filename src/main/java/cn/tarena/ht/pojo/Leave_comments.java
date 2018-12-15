package cn.tarena.ht.pojo;

import java.io.Serializable;

public class Leave_comments implements Serializable{
	
	private Integer  lcid;//留言id
	private Integer  sid;//学生id
	private Integer  tid;//老师id
	private String message;//留言
	private Integer status;//数量
	public Integer getLcid() {
		return lcid;
	}
	public void setLcid(Integer lcid) {
		this.lcid = lcid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
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


