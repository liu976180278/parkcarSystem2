package com.parkhelp.vo.system.parkinfo;

import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleStringProperty;

import com.parkhelp.po.system.parkinfo.ParkZoneInfo;
public class ParkZoneInfoVo {
	private String id;
	private String zonename;
	private String zonecount;
	private String vipcarcount;
	private String maxtempcar;
	private String zonefreecount;
	private String billingindex_id;
	private String updatetime;
	private String dbStatus;
	public ParkZoneInfoVo() {
	}
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd: HH:mm");
	public ParkZoneInfoVo(ParkZoneInfo parkZoneInfo) {
		this.id= parkZoneInfo.getId();
		this.zonename=parkZoneInfo.getZonename();
		this.zonecount=parkZoneInfo.getZonecount()+"";
		this.vipcarcount=parkZoneInfo.getVipcarcount()+"";
		this.maxtempcar=parkZoneInfo.getMaxtempcar()+"";
		this.zonefreecount=parkZoneInfo.getZonefreecount()+"";
		this.billingindex_id=parkZoneInfo.getBillingindex_id();
		this.updatetime=sdf.format(parkZoneInfo.getUpdatetime());
		if(parkZoneInfo.getDbStatus()==0){
			this.dbStatus="正常记录";
		}
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public String getZonecount() {
		return zonecount;
	}
	public void setZonecount(String zonecount) {
		this.zonecount = zonecount;
	}
	public String getVipcarcount() {
		return vipcarcount;
	}
	public void setVipcarcount(String vipcarcount) {
		this.vipcarcount = vipcarcount;
	}
	public String getMaxtempcar() {
		return maxtempcar;
	}
	public void setMaxtempcar(String maxtempcar) {
		this.maxtempcar = maxtempcar;
	}
	public String getZonefreecount() {
		return zonefreecount;
	}
	public void setZonefreecount(String zonefreecount) {
		this.zonefreecount = zonefreecount;
	}
	public String getBillingindex_id() {
		return billingindex_id;
	}
	public void setBillingindex_id(String billingindex_id) {
		this.billingindex_id = billingindex_id;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}
	
	
}
