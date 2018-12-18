package cn.tarena.ht.pojo;

import java.io.Serializable;

public class Topic implements Serializable{
	private Integer  tid;//题目id
	private Integer  cid;//课程id
	private String tname;//题目名称
	private String claim;//要求
	private Integer sum;//数量
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getClaim() {
		return claim;
	}
	public void setClaim(String claim) {
		this.claim = claim;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}

	
}

