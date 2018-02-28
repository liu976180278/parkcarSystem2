package com.parkhelp.po.system;

import java.util.Date;

public class UserInfo {
	private String id;
	private String creater;
	private String loginname;
	private String password;
	private String remark;
	private String telnum;
	private String updater;
	private String username;
	private String workNo;
	private String parkid_id;
	private String batchno;
	private int dbStatus;       //数据状态  为0则为正常记录
	private int work_status;
	private int role;
	private int sex;
	private Date updatedTime;
	private Date age;           //出生日期
	private Date  createdTime;
	private String sdbStatus;
	private String swork_status;
	private String srole;
	private String ssex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getParkid_id() {
		return parkid_id;
	}
	public void setParkid_id(String parkid_id) {
		this.parkid_id = parkid_id;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public int getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(int dbStatus) {
		this.dbStatus = dbStatus;
	}
	public int getWork_status() {
		return work_status;
	}
	public void setWork_status(int work_status) {
		this.work_status = work_status;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getSdbStatus() {
		return sdbStatus;
	}
	public void setSdbStatus(String sdbStatus) {
		this.sdbStatus = sdbStatus;
	}
	public String getSwork_status() {
		return swork_status;
	}
	public void setSwork_status(String swork_status) {
		this.swork_status = swork_status;
	}
	public String getSrole() {
		return srole;
	}
	public void setSrole(String srole) {
		this.srole = srole;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
}
