package com.king.web.usermanage.dept.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;
@Entity()
@Table(name = "Dept")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DeptData extends FrmData{

	private String name;//部门名称
	private int status;//状态

	@Column(length = 50,name = "name",nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 4,name = "status",nullable = true)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
		
}
