package com.parkhelp.po.system.parkinfo;

import java.util.Date;

public class ParkZoneInfo {
	private String id;
	private int dbStatus;
	private Date updatetime;
	private int zonecount;
	private int zonefreecount;
	private String zonename;
	private String parkno_id;
	private int vipcarcount;
	private int maxtempcar;
	private String billingindex_id;
	private ParkInfo parkinfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(int dbStatus) {
		this.dbStatus = dbStatus;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public int getZonecount() {
		return zonecount;
	}
	public void setZonecount(int zonecount) {
		this.zonecount = zonecount;
	}
	public int getZonefreecount() {
		return zonefreecount;
	}
	public void setZonefreecount(int zonefreecount) {
		this.zonefreecount = zonefreecount;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public String getParkno_id() {
		return parkno_id;
	}
	public void setParkno_id(String parkno_id) {
		this.parkno_id = parkno_id;
	}
	public int getVipcarcount() {
		return vipcarcount;
	}
	public void setVipcarcount(int vipcarcount) {
		this.vipcarcount = vipcarcount;
	}
	public int getMaxtempcar() {
		return maxtempcar;
	}
	public void setMaxtempcar(int maxtempcar) {
		this.maxtempcar = maxtempcar;
	}
	public String getBillingindex_id() {
		return billingindex_id;
	}
	public void setBillingindex_id(String billingindex_id) {
		this.billingindex_id = billingindex_id;
	}
	public ParkInfo getParkinfo() {
		return parkinfo;
	}
	public void setParkinfo(ParkInfo parkinfo) {
		this.parkinfo = parkinfo;
	}
	
}
