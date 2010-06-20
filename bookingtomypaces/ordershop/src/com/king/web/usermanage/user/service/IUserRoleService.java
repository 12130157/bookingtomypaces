package com.king.web.usermanage.user.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.data.UserRoleData;

public interface IUserRoleService {
	
	/**
	 * 添加系统用户角色信息
	 * @param u 系统用户角色信息
	 * @return 系统用户角色信息
	 * @throws KINGException
	 */
	public UserRoleData addUserRole(UserRoleData u) throws KINGException;
	
	/**
	 * 单个删除系统用户角色信息
	 * @param u 系统用户角色信息
	 * @throws KINGException
	 */
	public void deleteUserRole(UserRoleData u) throws KINGException;
	
	/**
	 * 批量删除系统用户角色信息
	 * @param ids 系统用户角色信息ID数组
	 * @throws KINGException
	 */
	public void deleteUserRole(String[] ids) throws KINGException;
	
	/**
	 * 修改系统用户角色信息
	 * @param u 系统用户角色信息
	 * @return 系统用户角色信息
	 * @throws KINGException
	 */
	public UserRoleData updateUserRole(UserRoleData u) throws KINGException;
	
	/**
	 * 查询单个系统用户角色信息
	 * @param id 系统用户角色信息ID
	 * @return 系统用户角色信息
	 * @throws KINGException
	 */
	public UserRoleData retrieveUserRole(String id) throws KINGException;
	
	/**
	 * 查询系统用户角色信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统用户角色信息集合
	 * @throws KINGException
	 */
	public List<UserRoleData> searchUserRoles(PageRoll pageRoll,JSONObject jsonu) throws KINGException;

}
