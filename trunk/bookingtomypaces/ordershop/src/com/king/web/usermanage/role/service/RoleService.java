package com.king.web.usermanage.role.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.role.dao.IRoleDAO;
import com.king.web.usermanage.role.data.RoleData;

public class RoleService extends FrmService implements IRoleService{

	private IRoleDAO roleDao;

	/**
	 * 添加角色信息
	 * @param u 角色信息
	 * @return 角色信息
	 * @throws KINGException
	 */
	public RoleData addRole(RoleData u) throws KINGException{
		roleDao.add(u);
		return u;
	}
	
	/**
	 * 单个删除角色信息
	 * @param u 角色信息
	 * @throws KINGException
	 */
	public void deleteRole(RoleData u) throws KINGException{
		roleDao.delete(u);
	}
	
	/**
	 * 批量删除角色信息
	 * @param ids 角色信息ID数组
	 * @throws KINGException
	 */
	public void deleteRole(String[] ids) throws KINGException{
		roleDao.delete(ids);
	}
	
	/**
	 * 修改角色信息
	 * @param u 角色信息
	 * @return 角色信息
	 * @throws KINGException
	 */
	public RoleData updateRole(RoleData u) throws KINGException{
		roleDao.update(u);
		return u;
	}
	
	/**
	 * 查询单个角色信息
	 * @param id 角色信息ID
	 * @return 角色信息
	 * @throws KINGException
	 */
	public RoleData retrieveRole(String id) throws KINGException{
		String hql = "from RoleData u where u.id = '" +id+ "'";
		return (RoleData) roleDao.search(hql).get(0);
	}
	
	/**
	 * 查询角色信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 角色信息集合
	 * @throws KINGException
	 */
	public List<RoleData> searchRoles(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from RoleData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = roleDao.searchlist(pageRoll,"");
		return list;
	}

	/**
	 * 查询角色信息
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return 角色信息集合
	 * @throws KINGException
	 */
	public List<RoleData> searchRoles(PageRoll pageRoll,String withsql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from RoleData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = roleDao.searchlist(pageRoll,withsql);
		return list;
	}
	
	public IRoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDAO roleDao) {
		this.roleDao = roleDao;
	}

}
