package com.king.web.clientmanage.clientInfo.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "clientinfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ClientInfoData  extends FrmData{
	
	//private String id;
	private String client_num;
	private String company_name;
	private String company_shortname;
	private String comp_phone;
	private String comp_fax;
	private String e_mail;
	private String linkman_one;
	private String phone_one;
	private String job_one;
	
	private String address_one;
	private String linkman_two;
	private String phone_two;
	private String job_two;
	private String address_two;
	private String area_name;
	private String remark;
	private String prompt;
	private String rebate;
	private String functionary;
	
	private String state;
	private Date create_time;
	
//	@Column(name = "id",nullable = true)
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	@Column(name = "client_num",nullable = true)
	public String getClient_num() {
		return client_num;
	}
	public void setClient_num(String clientNum) {
		client_num = clientNum;
	}
	@Column(name = "company_name",nullable = true)
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String companyName) {
		company_name = companyName;
	}
	@Column(name = "company_shortname",nullable = true)
	public String getCompany_shortname() {
		return company_shortname;
	}
	public void setCompany_shortname(String companyShortname) {
		company_shortname = companyShortname;
	}
	@Column(name = "comp_phone",nullable = true)
	public String getComp_phone() {
		return comp_phone;
	}
	public void setComp_phone(String compPhone) {
		comp_phone = compPhone;
	}
	@Column(name = "comp_fax",nullable = true)
	public String getComp_fax() {
		return comp_fax;
	}
	public void setComp_fax(String compFax) {
		comp_fax = compFax;
	}
	@Column(name = "e_mail",nullable = true)
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String eMail) {
		e_mail = eMail;
	}
	@Column(name = "linkman_one",nullable = true)
	public String getLinkman_one() {
		return linkman_one;
	}
	public void setLinkman_one(String linkmanOne) {
		linkman_one = linkmanOne;
	}
	@Column(name = "phone_one",nullable = true)
	public String getPhone_one() {
		return phone_one;
	}
	public void setPhone_one(String phoneOne) {
		phone_one = phoneOne;
	}
	@Column(name = "job_one",nullable = true)
	public String getJob_one() {
		return job_one;
	}
	public void setJob_one(String jobOne) {
		job_one = jobOne;
	}
	@Column(name = "address_one",nullable = true)
	public String getAddress_one() {
		return address_one;
	}
	public void setAddress_one(String addressOne) {
		address_one = addressOne;
	}
	@Column(name = "linkman_two",nullable = true)
	public String getLinkman_two() {
		return linkman_two;
	}
	public void setLinkman_two(String linkmanTwo) {
		linkman_two = linkmanTwo;
	}
	@Column(name = "phone_two",nullable = true)
	public String getPhone_two() {
		return phone_two;
	}
	public void setPhone_two(String phoneTwo) {
		phone_two = phoneTwo;
	}
	@Column(name = "job_two",nullable = true)
	public String getJob_two() {
		return job_two;
	}
	public void setJob_two(String jobTwo) {
		job_two = jobTwo;
	}
	@Column(name = "address_two",nullable = true)
	public String getAddress_two() {
		return address_two;
	}
	public void setAddress_two(String addressTwo) {
		address_two = addressTwo;
	}
	@Column(name = "area_name",nullable = true)
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String areaName) {
		area_name = areaName;
	}
	@Column(name = "remark",nullable = true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "prompt",nullable = true)
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	@Column(name = "rebate",nullable = true)
	public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	@Column(name = "functionary",nullable = true)
	public String getFunctionary() {
		return functionary;
	}
	public void setFunctionary(String functionary) {
		this.functionary = functionary;
	}
	@Column(name = "state",nullable = true)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "create_time",nullable = true)
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date createTime) {
		create_time = createTime;
	}
	
	

}
