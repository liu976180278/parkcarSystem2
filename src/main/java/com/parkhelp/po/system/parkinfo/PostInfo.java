package com.parkhelp.po.system.parkinfo;

import com.parkhelp.po.system.parkinfo.ParkInfo;

public class PostInfo {
	private String id;
	private String post_name;
	private int post_type;
	private String remark;
	private int dbstatus;
	private String parkno_id;
	private ParkInfo parkinfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public int getPost_type() {
		return post_type;
	}
	public void setPost_type(int post_type) {
		this.post_type = post_type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDbstatus() {
		return dbstatus;
	}
	public void setDbstatus(int dbstatus) {
		this.dbstatus = dbstatus;
	}
	public ParkInfo getParkinfo() {
		return parkinfo;
	}
	public void setParkinfo(ParkInfo parkinfo) {
		this.parkinfo = parkinfo;
	}
	public String getParkno_id() {
		return parkno_id;
	}
	public void setParkno_id(String parkno_id) {
		this.parkno_id = parkno_id;
	}
	
	
}
