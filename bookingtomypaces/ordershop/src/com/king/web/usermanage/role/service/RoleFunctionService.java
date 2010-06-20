package com.king.web.usermanage.role.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.role.dao.IRoleFunctionDAO;
import com.king.web.usermanage.role.data.RoleFunctionData;

public class RoleFunctionService extends FrmService implements IRoleFunctionService{

	private IRoleFunctionDAO roleFunctionDao;
	

	/**
	 * 添加角色功能信息
	 * @param u 角色功能信息
	 * @return 角色功能信息
	 * @throws KINGException
	 */
	public RoleFunctionData addRoleFunction(RoleFunctionData u) throws KINGException{
		roleFunctionDao.add(u);
		return u;
	}
	
	/**
	 * 单个删除角色功能信息
	 * @param u 角色功能信息
	 * @throws KINGException
	 */
	public void deleteRoleFunction(RoleFunctionData u) throws KINGException{
		roleFunctionDao.delete(u);
	}
	
	/**
	 * 批量删除角色功能信息
	 * @param ids 角色功能信息ID数组
	 * @throws KINGException
	 */
	public void deleteRoleFunction(String[] ids) throws KINGException{
		roleFunctionDao.delete(ids);
	}
	
	/**
	 * 修改角色功能信息
	 * @param u 角色功能信息
	 * @return 角色功能信息
	 * @throws KINGException
	 */
	public RoleFunctionData updateRoleFunction(RoleFunctionData u) throws KINGException{
		roleFunctionDao.update(u);
		return u;
	}
	
	/**
	 * 查询单个角色功能信息
	 * @param id 角色功能信息ID
	 * @return 角色功能信息
	 * @throws KINGException
	 */
	public RoleFunctionData retrieveRoleFunction(String id) throws KINGException{
		String hql = "from RoleFunctionData u where u.id = '" +id+ "'";
		return (RoleFunctionData) roleFunctionDao.search(hql).get(0);
	}
	
	/**
	 * 查询角色功能信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 角色功能信息集合
	 * @throws KINGException
	 */
	public List<RoleFunctionData> searchRoleFunctions(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from RoleFunctionData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = roleFunctionDao.searchlist(pageRoll,"");
		return list;
	}

	public IRoleFunctionDAO getRoleFunctionDao() {
		return roleFunctionDao;
	}

	public void setRoleFunctionDao(IRoleFunctionDAO roleFunctionDao) {
		this.roleFunctionDao = roleFunctionDao;
	}


}
