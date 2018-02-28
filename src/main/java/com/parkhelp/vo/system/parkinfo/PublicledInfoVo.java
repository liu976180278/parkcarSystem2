package com.parkhelp.vo.system.parkinfo;

import com.parkhelp.po.system.parkinfo.PublicledInfo;

public class PublicledInfoVo {
	private String id;
	private String ledname;
	private String zone_id;
	private String ledbrand;
	private String cardaddress;
	private String ledip;
	private String numcount;
	private String actiontype;
	private String actionspeed;
	private String partWidth;
	private String partHeight;
	private String coordinateX;
	private String coordinateY;
	private String fontsize;
	private String isused;
	private String fontbold;
	private String holdtime;
	private String texttmp;
	
	public PublicledInfoVo() {
	}
	public PublicledInfoVo(PublicledInfo publicledInfo) {
		this.id=publicledInfo.getId();
		this.ledname=publicledInfo.getLedname();
		if(publicledInfo.getParkZoneInfo()!=null){
			this.zone_id=publicledInfo.getParkZoneInfo().getZonename();
		}
		this.ledbrand=publicledInfo.getLedbrand();
		this.ledip=publicledInfo.getLedip();
		this.cardaddress=publicledInfo.getCardaddress()+"";
		this.numcount=publicledInfo.getNumcount()+"";
		this.actionspeed=publicledInfo.getActionspeed()+"";
		this.partWidth=publicledInfo.getPartWidth()+"";
		this.partHeight=publicledInfo.getPartHeight()+"";
		this.coordinateX=publicledInfo.getCoordinateX()+"";
		this.coordinateY=publicledInfo.getCoordinateY()+"";
		this.fontsize=publicledInfo.getFontsize()+"";
		this.holdtime=publicledInfo.getHoldtime()+"";
		this.texttmp=publicledInfo.getTexttmp()+"";
		if(publicledInfo.getActiontype().equals("1")){
			this.actiontype="立即显示";
		}else{
			this.actiontype="连续左移";
		}
		if(publicledInfo.getFontbold()==0){
			this.fontbold="细";
		}else{
			this.fontbold="粗";
		}
		if(publicledInfo.getIsused()==0){
			this.isused="启用";
		}else{
			this.isused="未启用";
		}
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLedname() {
		return ledname;
	}
	public void setLedname(String ledname) {
		this.ledname = ledname;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getLedbrand() {
		return ledbrand;
	}
	public void setLedbrand(String ledbrand) {
		this.ledbrand = ledbrand;
	}
	public String getCardaddress() {
		return cardaddress;
	}
	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}
	public String getLedip() {
		return ledip;
	}
	public void setLedip(String ledip) {
		this.ledip = ledip;
	}
	public String getNumcount() {
		return numcount;
	}
	public void setNumcount(String numcount) {
		this.numcount = numcount;
	}
	public String getActiontype() {
		return actiontype;
	}
	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}
	public String getActionspeed() {
		return actionspeed;
	}
	public void setActionspeed(String actionspeed) {
		this.actionspeed = actionspeed;
	}
	public String getPartWidth() {
		return partWidth;
	}
	public void setPartWidth(String partWidth) {
		this.partWidth = partWidth;
	}
	public String getPartHeight() {
		return partHeight;
	}
	public void setPartHeight(String partHeight) {
		this.partHeight = partHeight;
	}
	public String getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}
	public String getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getFontsize() {
		return fontsize;
	}
	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}
	public String getIsused() {
		return isused;
	}
	public void setIsused(String isused) {
		this.isused = isused;
	}
	public String getFontbold() {
		return fontbold;
	}
	public void setFontbold(String fontbold) {
		this.fontbold = fontbold;
	}
	public String getHoldtime() {
		return holdtime;
	}
	public void setHoldtime(String holdtime) {
		this.holdtime = holdtime;
	}
	public String getTexttmp() {
		return texttmp;
	}
	public void setTexttmp(String texttmp) {
		this.texttmp = texttmp;
	}
	
}
