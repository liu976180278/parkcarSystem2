package com.parkhelp.vo.system;

import com.parkhelp.po.system.MemberCar;
import com.parkhelp.po.system.UserInfo;

public class MemberCarVo {
	private String id;
	private String carno;
	private String carnocolor;
	private String balance;
	private String starttime;
	private String endtime;
	private String cartype;
	private String zone_id;
	private String carowner;
	private String telno;
	public MemberCarVo(MemberCar memberCar) {
		
	}
	public MemberCarVo() {
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getCarowner() {
		return carowner;
	}
	public void setCarowner(String carowner) {
		this.carowner = carowner;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	

	
}
