package com.king.web.clientmanage.clientInfo.service;

import java.util.List;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.clientmanage.clientInfo.dao.IClientInfoDAO;
import com.king.web.clientmanage.clientInfo.data.ClientInfoData;

public class ClientInfoService extends FrmService implements IClientInfoService{

	private IClientInfoDAO clientInfoDao;
	
	/**
	 * 1.添加客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public ClientInfoData addClientInfo(ClientInfoData u) throws KINGException{
		clientInfoDao.add(u);
		return u;
	}
	
	/**
	 * 2.单个删除客户 基本信息
	 * @param u 客户 基本信息
	 * @throws KINGException
	 */
	public void deleteClientInfo(ClientInfoData u) throws KINGException{
		clientInfoDao.delete(u);
	}
	
	/**
	 * 3.批量删除客户 基本信息
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void deleteClientInfo(String[] ids) throws KINGException{
		clientInfoDao.delete(ids);
	}
	
	/**
	 * 4.修改客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public ClientInfoData updateClientInfo(ClientInfoData u) throws KINGException{
		clientInfoDao.update(u);
		return u;
	}
	
	/**
	 * 5.查询单个客户 基本信息
	 * @param id 客户 基本信息ID
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public ClientInfoData retrieveClientInfo(String id) throws KINGException{
		String hql = "from ClientInfoData u where u.id = '" +id+ "'";
		return (ClientInfoData) clientInfoDao.search(hql).get(0);
	}
	
	/**
	 * 6.查询客户 基本信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 客户 基本信息集合
	 * @throws KINGException
	 */
	public List<ClientInfoData> searchClientInfoList(PageRoll pageRoll,String withhql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from ClientInfoData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = clientInfoDao.searchlist(pageRoll,withhql);
		System.out.println("-----list.size()="+list.size());
		return list;
	}

	/**
	 * 7.批量更新客户 基本信息
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateClientInfo(String[] ids) throws KINGException{
		for (int i = 0; i < ids.length; i++) {
			String withsql=" update ClientInfoData set state='2' where id='"+ids[i]+"'";
			int flag=clientInfoDao.executeSQL(withsql);
			
		}
	}
	
	/**
	 * 8.更新客户状态
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateClientInfoByid(String id,String state) throws KINGException{	
			String withsql=" update ClientInfoData set state='"+state+"' where id='"+id+"'";
			int flag=clientInfoDao.executeSQL(withsql);			
	}
	
	public IClientInfoDAO getClientInfoDao() {
		return clientInfoDao;
	}

	public void setClientInfoDao(IClientInfoDAO clientInfoDao) {
		this.clientInfoDao = clientInfoDao;
	}

}
