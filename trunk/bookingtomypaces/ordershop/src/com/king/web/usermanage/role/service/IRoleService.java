package com.king.web.usermanage.role.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.role.data.RoleData;

public interface IRoleService {

	/**
	 * 1.添加角色信息
	 * @param u 角色信息
	 * @return 角色信息
	 * @throws KINGException
	 */
	public RoleData addRole(RoleData u) throws KINGException;
	
	/**
	 * 2.单个删除角色信息
	 * @param u 角色信息
	 * @throws KINGException
	 */
	public void deleteRole(RoleData u) throws KINGException;
	
	/**
	 * 3.批量删除角色信息
	 * @param ids 角色信息ID数组
	 * @throws KINGException
	 */
	public void deleteRole(String[] ids) throws KINGException;
	
	/**
	 * 4.修改角色信息
	 * @param u 角色信息
	 * @return 角色信息
	 * @throws KINGException
	 */
	public RoleData updateRole(RoleData u) throws KINGException;
	
	/**
	 * 5.查询单个角色信息
	 * @param id 角色信息ID
	 * @return 角色信息
	 * @throws KINGException
	 */
	public RoleData retrieveRole(String id) throws KINGException;
	
	/**
	 * 6.查询角色信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 角色信息集合
	 * @throws KINGException
	 */
	public List<RoleData> searchRoles(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 查询角色信息
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return 角色信息集合
	 * @throws KINGException
	 */
	public List<RoleData> searchRoles(PageRoll pageRoll,String withsql) throws KINGException;
}
