package com.king.web.usermanage.role.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.role.data.RoleFunctionData;
import com.king.web.usermanage.role.data.RoleFunctionData1;

public interface IRoleFunctionService {

	/**
	 * 添加角色功能信息
	 * @param u 角色功能信息
	 * @return 角色功能信息
	 * @throws KINGException
	 */
	public RoleFunctionData addRoleFunction(RoleFunctionData u) throws KINGException;
	
	/**
	 * 单个删除角色功能信息
	 * @param u 角色功能信息
	 * @throws KINGException
	 */
	public void deleteRoleFunction(RoleFunctionData u) throws KINGException;
	
	/**
	 * 批量删除角色功能信息
	 * @param ids 角色功能信息ID数组
	 * @throws KINGException
	 */
	public void deleteRoleFunction(String[] ids) throws KINGException;
	
	/**
	 * 修改角色功能信息
	 * @param u 角色功能信息
	 * @return 角色功能信息
	 * @throws KINGException
	 */
	public RoleFunctionData updateRoleFunction(RoleFunctionData u) throws KINGException;
	
	/**
	 * 查询单个角色功能信息
	 * @param id 角色功能信息ID
	 * @return 角色功能信息
	 * @throws KINGException
	 */
	public RoleFunctionData retrieveRoleFunction(String id) throws KINGException;
	
	/**
	 * 查询角色功能信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 角色功能信息集合
	 * @throws KINGException
	 */
	public List<RoleFunctionData> searchRoleFunctions(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 查询角色功能信息
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return 角色功能信息集合
	 * @throws KINGException
	 */
	public List<RoleFunctionData> searchRoleFunctions(PageRoll pageRoll,String withsql) throws KINGException;
	
	/**
	 * 查询角色功能信息
	 * @param roleId
	 * @return 角色功能信息集合
	 * @throws KINGException
	 */
	public List<RoleFunctionData1> getUserRole(String roleId)throws KINGException;
	
	/**
	 * 批量删除某个角色所带功能信息
	 * @param roleId 角色ID
	 * @throws KINGException
	 */
	public void deleteRoleFunction(String roleId) throws KINGException;
}
