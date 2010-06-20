package com.king.web.usermanage.user.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.dao.IUserRoleDAO;
import com.king.web.usermanage.user.data.UserRoleData;

public class UserRoleService extends FrmService implements IUserRoleService{

	private IUserRoleDAO userRoleDao;
	
	/**
	 * 添加系统用户角色信息
	 * @param u 系统用户角色信息
	 * @return 系统用户角色信息
	 * @throws KINGException
	 */
	public UserRoleData addUserRole(UserRoleData u) throws KINGException{
		userRoleDao.add(u);
		return u;
	}
	
	/**
	 * 单个删除系统用户角色信息
	 * @param u 系统用户角色信息
	 * @throws KINGException
	 */
	public void deleteUserRole(UserRoleData u) throws KINGException{
		userRoleDao.delete(u);
	}
	
	/**
	 * 批量删除系统用户角色信息
	 * @param ids 系统用户角色信息ID数组
	 * @throws KINGException
	 */
	public void deleteUserRole(String[] ids) throws KINGException{
		userRoleDao.delete(ids);
	}
	
	/**
	 * 修改系统用户角色信息
	 * @param u 系统用户角色信息
	 * @return 系统用户角色信息
	 * @throws KINGException
	 */
	public UserRoleData updateUserRole(UserRoleData u) throws KINGException{
		userRoleDao.update(u);
		return u;
	}
	
	/**
	 * 查询单个系统用户角色信息
	 * @param id 系统用户角色信息ID
	 * @return 系统用户角色信息
	 * @throws KINGException
	 */
	public UserRoleData retrieveUserRole(String id) throws KINGException{
		String hql = "from UserRoleData u where u.id = '" +id+ "'";
		return (UserRoleData) userRoleDao.search(hql).get(0);
	}
	
	/**
	 * 查询系统用户角色信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统用户角色信息集合
	 * @throws KINGException
	 */
	public List<UserRoleData> searchUserRoles(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from UserRoleData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = userRoleDao.searchlist(pageRoll,"");
		return list;
	}

	public IUserRoleDAO getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(IUserRoleDAO userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

}
