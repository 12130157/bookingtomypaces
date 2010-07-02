package com.king.web.usermanage.user.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.data.UserFunctionData;

public interface IUserFunctionService {
	
	/**
	 * 添加系统用户功能信息
	 * @param u 系统用户功能信息
	 * @return 系统用户功能信息
	 * @throws KINGException
	 */
	public UserFunctionData addUserFunction(UserFunctionData u) throws KINGException;
	
	/**
	 * 单个删除系统用户功能信息
	 * @param u 系统用户功能信息
	 * @throws KINGException
	 */
	public void deleteUserFunction(UserFunctionData u) throws KINGException;
	
	/**
	 * 批量删除系统用户功能信息
	 * @param ids 系统用户功能信息ID数组
	 * @throws KINGException
	 */
	public void deleteUserFunction(String[] ids) throws KINGException;
	
	/**
	 * 修改系统用户功能信息
	 * @param u 系统用户功能信息
	 * @return 系统用户功能信息
	 * @throws KINGException
	 */
	public UserFunctionData updateUserFunction(UserFunctionData u) throws KINGException;
	
	/**
	 * 查询单个系统用户功能信息
	 * @param id 系统用户功能信息ID
	 * @return 系统用户功能信息
	 * @throws KINGException
	 */
	public UserFunctionData retrieveUserFunction(String id) throws KINGException;
	
	/**
	 * 查询系统用户功能信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统用户功能信息集合
	 * @throws KINGException
	 */
	public List<UserFunctionData> searchUserFunctions(PageRoll pageRoll,JSONObject jsonu) throws KINGException;

	/**
	 * 查询用戶功能信息
	 * @param userId
	 * @return 用戶功能信息集合
	 * @throws KINGException
	 */
	public List<UserFunctionData> getUserFunction(String userId)throws KINGException;
	
	/**
	 * 删除某个用戶所带功能信息
	 * @param userId 用戶ID
	 * @throws KINGException
	 */
	public void deleteUserFunction(String userId) throws KINGException;
}
