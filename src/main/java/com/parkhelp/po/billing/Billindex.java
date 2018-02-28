/**
 * @Description: TODO
 * @date 2017年6月19日 上午10:09:30 	
 */
package com.parkhelp.po.billing;

import java.util.Date;

/**
 * @author lzc
 *
 */
public class Billindex {
	private String id;
	private int bill_cardoff;
	private int bill_cashoff;
	private int bill_gracetime;
	private int bill_memberoff;
	private String bill_name;
	private Date createdTime;
	private String creater;
	private int dbStatus;
	private int fi_agentid;
	private Date updatedTime;
	private String updater;
	private int  cycle;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBill_cardoff() {
		return bill_cardoff;
	}
	public void setBill_cardoff(int bill_cardoff) {
		this.bill_cardoff = bill_cardoff;
	}
	public int getBill_cashoff() {
		return bill_cashoff;
	}
	public void setBill_cashoff(int bill_cashoff) {
		this.bill_cashoff = bill_cashoff;
	}
	public int getBill_gracetime() {
		return bill_gracetime;
	}
	public void setBill_gracetime(int bill_gracetime) {
		this.bill_gracetime = bill_gracetime;
	}
	public int getBill_memberoff() {
		return bill_memberoff;
	}
	public void setBill_memberoff(int bill_memberoff) {
		this.bill_memberoff = bill_memberoff;
	}
	public String getBill_name() {
		return bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
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
	public int getFi_agentid() {
		return fi_agentid;
	}
	public void setFi_agentid(int fi_agentid) {
		this.fi_agentid = fi_agentid;
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
	public int getCycle() {
		return cycle;
	}
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	
	
}
