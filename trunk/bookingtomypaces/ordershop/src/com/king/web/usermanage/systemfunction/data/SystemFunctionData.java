package com.king.web.usermanage.systemfunction.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;


@Entity()
@Table(name = "SystemFunction")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SystemFunctionData extends FrmData {

	private int perfunc;//上一级菜单的ID
	private int funclevel;//代表菜单级数1:为第一级菜单,即主菜单2:为第二级菜单
	private String funcname;//功能的名称
	private String url;//链接
	private int seq;//排序
	private int status;//状态
	
	/**
	 * @return the perfunc
	 */
	@Column(length = 4,name = "perfunc",nullable = true)
	public int getPerfunc() {
		return perfunc;
	}
	/**
	 * @param perfunc the perfunc to set
	 */
	public void setPerfunc(int perfunc) {
		this.perfunc = perfunc;
	}
	/**
	 * @return the funclevel
	 */
	@Column(length = 4,name = "funclevel",nullable = true)
	public int getFunclevel() {
		return funclevel;
	}
	/**
	 * @param funclevel the funclevel to set
	 */
	public void setFunclevel(int funclevel) {
		this.funclevel = funclevel;
	}
	/**
	 * @return the funcname
	 */
	@Column(length = 64,name = "funcname",nullable = true)
	public String getFuncname() {
		return funcname;
	}
	/**
	 * @param funcname the funcname to set
	 */
	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}
	/**
	 * @return the url
	 */
	@Column(length = 64,name = "url",nullable = true)
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the seq
	 */
	@Column(length = 4,name = "seq",nullable = true)
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return the status
	 */
	@Column(length = 4,name = "status",nullable = true)
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}