package com.king.web.usermanage.dept.service;

import java.util.List;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.dept.data.DeptData;


public interface IDeptService {

	/**
	 * 添加用户部门信息
	 * @param u 用户部门信息
	 * @return 用户部门信息
	 * @throws KINGException
	 */
	public DeptData addDept(DeptData u) throws KINGException;
	
	/**
	 * 单个删除用户部门信息
	 * @param u 用户部门信息
	 * @throws KINGException
	 */
	public void deleteDept(DeptData u) throws KINGException;
	
	/**
	 * 批量删除用户部门信息
	 * @param ids 用户部门信息ID数组
	 * @throws KINGException
	 */
	public void deleteDept(String[] ids) throws KINGException;
	
	/**
	 * 修改用户部门信息
	 * @param u 用户部门信息
	 * @return 用户部门信息
	 * @throws KINGException
	 */
	public DeptData updateDept(DeptData u) throws KINGException;
	
	/**
	 * 查询单个用户部门信息
	 * @param id 用户部门信息ID
	 * @return 用户部门信息
	 * @throws KINGException
	 */
	public DeptData retrieveDept(String id) throws KINGException;
	
	/**
	 * 查询用户部门信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 用户部门信息集合
	 * @throws KINGException
	 */
	public List<DeptData> searchDept(PageRoll pageRoll,String withhql) throws KINGException;
}
