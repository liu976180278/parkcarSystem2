package com.parkhelp.po.system.parkinfo;

public class GateInfo {
	private String id;
	private String cameraIp;
	private String camera_brand;
	private int dbStatus;
	private String gatename;
	private String gateno;
	private String gatetype;
	private String remark;
	private String videoChannelNum;
	private int ordernum;
	private String led_brand;
	private String ledip;
	private String gategroup;
	private String zone_id;
	private String parkno_id;
	private String post_id;
	private ParkZoneInfo parkZoneInfo;
	private ParkInfo parkinfo;
	private PostInfo postInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCameraIp() {
		return cameraIp;
	}
	public void setCameraIp(String cameraIp) {
		this.cameraIp = cameraIp;
	}
	public String getCamera_brand() {
		return camera_brand;
	}
	public void DH(String camera_brand) {
		this.camera_brand = camera_brand;
	}
	public int getDbStatus() {
		return dbStatus;
	}
	public void setCamera_brand(String camera_brand) {
		this.camera_brand = camera_brand;
	}
	public void setDbStatus(int dbStatus) {
		this.dbStatus = dbStatus;
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
	public String getGatetype() {
		return gatetype;
	}
	public void setGatetype(String gatetype) {
		this.gatetype = gatetype;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getVideoChannelNum() {
		return videoChannelNum;
	}
	public void setVideoChannelNum(String videoChannelNum) {
		this.videoChannelNum = videoChannelNum;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public String getLed_brand() {
		return led_brand;
	}
	public void setLed_brand(String led_brand) {
		this.led_brand = led_brand;
	}
	public String getLedip() {
		return ledip;
	}
	public void setLedip(String ledip) {
		this.ledip = ledip;
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
	public String getParkno_id() {
		return parkno_id;
	}
	public void setParkno_id(String parkno_id) {
		this.parkno_id = parkno_id;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public ParkZoneInfo getParkZoneInfo() {
		return parkZoneInfo;
	}
	public void setParkZoneInfo(ParkZoneInfo parkZoneInfo) {
		this.parkZoneInfo = parkZoneInfo;
	}
	public ParkInfo getParkinfo() {
		return parkinfo;
	}
	public void setParkinfo(ParkInfo parkinfo) {
		this.parkinfo = parkinfo;
	}
	public PostInfo getPostInfo() {
		return postInfo;
	}
	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}
	
	
	
}
