package com.parkhelp.vo.system.parkinfo;
import com.parkhelp.po.system.parkinfo.PostInfo;
public class PostInfoVo {
	private String id;
	private String parkname;
	private String post_name;
	private String post_type;
	private String remark;
	private String dbstatus;
	public PostInfoVo() {
	}
	public PostInfoVo(PostInfo PostInfo) {
		this.id= PostInfo.getId();
		this.parkname= PostInfo.getParkinfo().getParkname();
		this.post_name= PostInfo.getPost_name();
		if(PostInfo.getPost_type()==0){
			this.post_type= "单通道";
		}else{
			this.post_type= "双通道";
		}
		this.remark= PostInfo.getRemark();
		if(PostInfo.getDbstatus()==0){
			this.dbstatus= "正常记录";
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDbstatus() {
		return dbstatus;
	}
	public void setDbstatus(String dbstatus) {
		this.dbstatus = dbstatus;
	}
	
	
	
}
