/**
 * @Description: TODO
 * @date 2017年6月19日 上午10:26:22 	
 */
package com.parkhelp.po.billing;

/**
 * @author lzc
 *
 */
public class ExtraBilling {
	private String id;
	private String cartype;
	private String rule;
	private String remark;
	private int free_time;
	private String billingindex_id;
	private Double day_cost_limit;
	private String supplement_type;
	private String charge_type;
	private Double cost_limit;
	private int is_naturalday;
	private int is_drools;
	private int day_part;
	private int night_part;
	private Billindex billindex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getFree_time() {
		return free_time;
	}
	public void setFree_time(int free_time) {
		this.free_time = free_time;
	}
	public String getBillingindex_id() {
		return billingindex_id;
	}
	public void setBillingindex_id(String billingindex_id) {
		this.billingindex_id = billingindex_id;
	}
	public Double getDay_cost_limit() {
		return day_cost_limit;
	}
	public void setDay_cost_limit(Double day_cost_limit) {
		this.day_cost_limit = day_cost_limit;
	}
	public String getSupplement_type() {
		return supplement_type;
	}
	public void setSupplement_type(String supplement_type) {
		this.supplement_type = supplement_type;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public Double getCost_limit() {
		return cost_limit;
	}
	public void setCost_limit(Double cost_limit) {
		this.cost_limit = cost_limit;
	}
	public int getIs_naturalday() {
		return is_naturalday;
	}
	public void setIs_naturalday(int is_naturalday) {
		this.is_naturalday = is_naturalday;
	}
	public int getIs_drools() {
		return is_drools;
	}
	public void setIs_drools(int is_drools) {
		this.is_drools = is_drools;
	}
	public int getDay_part() {
		return day_part;
	}
	public void setDay_part(int day_part) {
		this.day_part = day_part;
	}
	public int getNight_part() {
		return night_part;
	}
	public void setNight_part(int night_part) {
		this.night_part = night_part;
	}
	public Billindex getBillindex() {
		return billindex;
	}
	public void setBillindex(Billindex billindex) {
		this.billindex = billindex;
	}
	
}
