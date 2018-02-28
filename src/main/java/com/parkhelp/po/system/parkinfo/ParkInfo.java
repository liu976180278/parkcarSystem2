package com.parkhelp.po.system.parkinfo;

public class ParkInfo {
	private String id;
	private int PARK_BAYNUM; 				//停车场地磁数量
	private String PARK_FEEINDEX;			//计费规则索引
	private String PARK_FEEDESC;			//计费规则描述
	private int PARK_FEELEVEL;				//计费分类
	private String PARK_REGIONID;			//停车场所属行政区域
	private int dbStatus;					//停车场状态
	private int enableVideoDiskRecorder;
	private int freecount;
	private double latitude;				//经度
	private double longitude;				//维度
	private String park_agentid;			//运营商id
	private int park_freetime;				//免费时长
	private String park_logon;				//停车场上班状态
	private int park_subtype;				//免费时长
	private int park_type;
	private String parkaddress;
	private String parkname;
	private String parkno;
	private String parkphoto;
	private String remark;
	private int spacecount;					
	private int membercount;
	private int temporarycount;
	private String videoDiskRecorderIp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPARK_BAYNUM() {
		return PARK_BAYNUM;
	}
	public void setPARK_BAYNUM(int pARK_BAYNUM) {
		PARK_BAYNUM = pARK_BAYNUM;
	}
	public String getPARK_FEEINDEX() {
		return PARK_FEEINDEX;
	}
	public void setPARK_FEEINDEX(String pARK_FEEINDEX) {
		PARK_FEEINDEX = pARK_FEEINDEX;
	}
	public String getPARK_FEEDESC() {
		return PARK_FEEDESC;
	}
	public void setPARK_FEEDESC(String pARK_FEEDESC) {
		PARK_FEEDESC = pARK_FEEDESC;
	}
	public int getPARK_FEELEVEL() {
		return PARK_FEELEVEL;
	}
	public void setPARK_FEELEVEL(int pARK_FEELEVEL) {
		PARK_FEELEVEL = pARK_FEELEVEL;
	}
	public String getPARK_REGIONID() {
		return PARK_REGIONID;
	}
	public void setPARK_REGIONID(String pARK_REGIONID) {
		PARK_REGIONID = pARK_REGIONID;
	}
	public int getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(int dbStatus) {
		this.dbStatus = dbStatus;
	}
	public int getEnableVideoDiskRecorder() {
		return enableVideoDiskRecorder;
	}
	public void setEnableVideoDiskRecorder(int enableVideoDiskRecorder) {
		this.enableVideoDiskRecorder = enableVideoDiskRecorder;
	}
	public int getFreecount() {
		return freecount;
	}
	public void setFreecount(int freecount) {
		this.freecount = freecount;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getPark_agentid() {
		return park_agentid;
	}
	public void setPark_agentid(String park_agentid) {
		this.park_agentid = park_agentid;
	}
	public int getPark_freetime() {
		return park_freetime;
	}
	public void setPark_freetime(int park_freetime) {
		this.park_freetime = park_freetime;
	}
	public String getPark_logon() {
		return park_logon;
	}
	public void setPark_logon(String park_logon) {
		this.park_logon = park_logon;
	}
	public int getPark_subtype() {
		return park_subtype;
	}
	public void setPark_subtype(int park_subtype) {
		this.park_subtype = park_subtype;
	}
	public int getPark_type() {
		return park_type;
	}
	public void setPark_type(int park_type) {
		this.park_type = park_type;
	}
	public String getParkaddress() {
		return parkaddress;
	}
	public void setParkaddress(String parkaddress) {
		this.parkaddress = parkaddress;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getParkno() {
		return parkno;
	}
	public void setParkno(String parkno) {
		this.parkno = parkno;
	}
	public String getParkphoto() {
		return parkphoto;
	}
	public void setParkphoto(String parkphoto) {
		this.parkphoto = parkphoto;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSpacecount() {
		return spacecount;
	}
	public void setSpacecount(int spacecount) {
		this.spacecount = spacecount;
	}
	public int getMembercount() {
		return membercount;
	}
	public void setMembercount(int membercount) {
		this.membercount = membercount;
	}
	public int getTemporarycount() {
		return temporarycount;
	}
	public void setTemporarycount(int temporarycount) {
		this.temporarycount = temporarycount;
	}
	public String getVideoDiskRecorderIp() {
		return videoDiskRecorderIp;
	}
	public void setVideoDiskRecorderIp(String videoDiskRecorderIp) {
		this.videoDiskRecorderIp = videoDiskRecorderIp;
	}
}
