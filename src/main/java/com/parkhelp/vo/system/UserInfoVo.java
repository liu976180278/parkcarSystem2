package com.parkhelp.vo.system;
import java.text.SimpleDateFormat;

import com.parkhelp.po.system.UserInfo;
public class UserInfoVo {
	private String id;
	private String workNo;
	private String userName;
	private String loginName;
	private String role;
	private String sex;
	private String telnum;
	private String age;
	private String remark;
	private String 	createdTime;
	private String updatedTime;
	private String dbStatus;
	private SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm");
	public UserInfoVo() {
	}
	public UserInfoVo(UserInfo userInfo) {
		this.id=userInfo.getId();
		this.workNo=userInfo.getWorkNo();
		this.userName=userInfo.getUsername();
		this.loginName=userInfo.getLoginname();
		if(userInfo.getRole()==1){
			this.role="普通员工";
		}else{
			this.role="分管员工";
		}
		if(userInfo.getSex()==0){
			this.sex="男";
		}else{
			this.sex="女";
		}
		if(userInfo.getDbStatus()==0){
			this.dbStatus="正常数据";
		}else{
			this.dbStatus="非正常数据";
		}
		this.telnum=userInfo.getTelnum();
		this.remark=userInfo.getRemark();
		if(userInfo.getCreatedTime()!=null){
			this.createdTime=sdf.format(userInfo.getCreatedTime());
		}
		if(userInfo.getUpdatedTime()!=null){
			this.updatedTime=sdf.format(userInfo.getUpdatedTime());
		}
		if(userInfo.getAge()!=null){
			this.age=sdf.format(userInfo.getAge());
		}
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}
	
}
