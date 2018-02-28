package com.parkhelp.vo.system.parkinfo;

import javafx.scene.control.CheckBox;

import com.parkhelp.po.system.parkinfo.GateInfo;

public class GateInfoVo {
	private String id;
	private String ordernum;
	private String gategroup;
	private String zone_id;
	private String post_id;
	private String gatename;
	private String gateno;
	private String cameraIp;
	private String videoChannelNum;
	private String ledip;
	private String led_brand;
	private String remark;
	private String dbStatus;
	private CheckBox isUsed = new CheckBox();
	
	public GateInfoVo() {
	}
	public GateInfoVo(GateInfo gateInfo) {
		this.id=gateInfo.getId();
		this.ordernum=gateInfo.getOrdernum()+"";
		this.gategroup=gateInfo.getGategroup();
		if(!(null==gateInfo.getParkZoneInfo())){
			this.zone_id=gateInfo.getParkZoneInfo().getZonename();
		}
		if(!(null==gateInfo.getPostInfo())){
			this.post_id=gateInfo.getPostInfo().getPost_name(); 
		}
		this.gatename=gateInfo.getGatename();
		this.gateno=gateInfo.getGateno();
		this.cameraIp=gateInfo.getCameraIp();
		this.videoChannelNum=gateInfo.getVideoChannelNum();
		this.ledip=gateInfo.getLedip();
		this.led_brand=gateInfo.getLed_brand();
		this.remark=gateInfo.getRemark();
		if(gateInfo.getDbStatus()==0){
			this.dbStatus="正常记录";
		}else {
			this.dbStatus="非正常记录";
		}
	}
	public void setIsUsed(CheckBox isUsed) {
		this.isUsed = isUsed;
	}
	public CheckBox getIsUsed() {
		if(isUsed.isSelected()){
			setGategroup("1");
		}else{
			if(gategroup.equals("1")){
				isUsed.setSelected(true);
			}
			setGategroup("0");
		}
		
		return isUsed;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getGategroup() {
		return gategroup;
	}

	public void setGategroup(String gategroup) {
		this.gategroup = gategroup;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getGatename() {
		return gatename;
	}

	public void setGatename(String gatename) {
		this.gatename = gatename;
	}

	public String getGateno() {
		return gateno;
	}

	public void setGateno(String gateno) {
		this.gateno = gateno;
	}

	public String getCameraIp() {
		return cameraIp;
	}

	public void setCameraIp(String cameraIp) {
		this.cameraIp = cameraIp;
	}

	public String getVideoChannelNum() {
		return videoChannelNum;
	}

	public void setVideoChannelNum(String videoChannelNum) {
		this.videoChannelNum = videoChannelNum;
	}

	public String getLedip() {
		return ledip;
	}

	public void setLedip(String ledip) {
		this.ledip = ledip;
	}

	public String getLed_brand() {
		return led_brand;
	}

	public void setLed_brand(String led_brand) {
		this.led_brand = led_brand;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}

}
