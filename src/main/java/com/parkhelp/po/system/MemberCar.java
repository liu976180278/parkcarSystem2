package com.parkhelp.po.system;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberCar {
	private String id;
	private Double balance;
	private int cargroupno;
	private String carno;
	private String carnocolor;
	private String carowner;
	private String cartype;
	private int cartypeno;
	private String code;
	private Date createdTime;
	private String creater;
	private int dbStatus;
	private String drivelicenseno;
	private Date endtime;
	private Date starttime;
	private String strendtime;
	private String strstarttime;
	private String telno;
	private Date updatedTime;
	private String updater;
	private String parkno_id;
	private String remark;
	private int verrecno;
	private String alarm_type;
	private String member_grade;
	private String zone_id;
	private String deptname;
	private String classname;
	private String workno;
	private SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd  HH:mm");
	
	public String getStrendtime() {
		return strendtime;
	}
	public void setStrendtime(String strendtime) {
		this.strendtime = strendtime;
	}
	public String getStrstarttime() {
		return strstarttime;
	}
	public void setStrstarttime(String strstarttime) {
		this.strstarttime = strstarttime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getCargroupno() {
		return cargroupno;
	}
	public void setCargroupno(int cargroupno) {
		this.cargroupno = cargroupno;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getCarnocolor() {
		return carnocolor;
	}
	public void setCarnocolor(String carnocolor) {
		this.carnocolor = carnocolor;
	}
	public String getCarowner() {
		return carowner;
	}
	public void setCarowner(String carowner) {
		this.carowner = carowner;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public int getCartypeno() {
		return cartypeno;
	}
	public void setCartypeno(int cartypeno) {
		this.cartypeno = cartypeno;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public int getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(int dbStatus) {
		this.dbStatus = dbStatus;
	}
	public String getDrivelicenseno() {
		return drivelicenseno;
	}
	public void setDrivelicenseno(String drivelicenseno) {
		this.drivelicenseno = drivelicenseno;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.strendtime=sdf.format(endtime);
		this.endtime = endtime;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.strstarttime=sdf.format(starttime);
		this.starttime = starttime;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getParkno_id() {
		return parkno_id;
	}
	public void setParkno_id(String parkno_id) {
		this.parkno_id = parkno_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getVerrecno() {
		return verrecno;
	}
	public void setVerrecno(int verrecno) {
		this.verrecno = verrecno;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public String getMember_grade() {
		return member_grade;
	}
	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getWorkno() {
		return workno;
	}
	public void setWorkno(String workno) {
		this.workno = workno;
	}
	
	public MemberCar() {
	}
	public MemberCar(Double balance, int cargroupno, String carno,
			String carnocolor, String carowner, String cartype, int cartypeno,
			String code, Date createdTime, String creater, int dbStatus,
			String drivelicenseno, Date endtime, Date starttime, String telno,
			Date updatedTime, String updater, String parkno_id, String remark,
			int verrecno, String alarm_type, String member_grade,
			String zone_id, String deptname, String classname, String workno) {
		super();
		this.balance = balance;
		this.cargroupno = cargroupno;
		this.carno = carno;
		this.carnocolor = carnocolor;
		this.carowner = carowner;
		this.cartype = cartype;
		this.cartypeno = cartypeno;
		this.code = code;
		this.createdTime = createdTime;
		this.creater = creater;
		this.dbStatus = dbStatus;
		this.drivelicenseno = drivelicenseno;
		this.endtime = endtime;
		this.starttime = starttime;
		this.telno = telno;
		this.updatedTime = updatedTime;
		this.updater = updater;
		this.parkno_id = parkno_id;
		this.remark = remark;
		this.verrecno = verrecno;
		this.alarm_type = alarm_type;
		this.member_grade = member_grade;
		this.zone_id = zone_id;
		this.deptname = deptname;
		this.classname = classname;
		this.workno = workno;
	}
	
}
