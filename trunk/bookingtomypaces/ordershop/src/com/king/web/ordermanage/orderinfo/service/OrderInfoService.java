package com.king.web.ordermanage.orderinfo.service;

import java.util.List;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.ordermanage.orderinfo.dao.IOrderInfoDAO;
import com.king.web.ordermanage.orderinfo.data.OrderInfoData;

public class OrderInfoService extends FrmService implements IOrderInfoService{

	private IOrderInfoDAO orderInfoDao;
	
	/**
	 * 1.添加客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public OrderInfoData addOrderInfo(OrderInfoData u) throws KINGException{
		orderInfoDao.add(u);
		return u;
	}
	
	/**
	 * 2.单个删除客户 基本信息
	 * @param u 客户 基本信息
	 * @throws KINGException
	 */
	public void deleteOrderInfo(OrderInfoData u) throws KINGException{
		orderInfoDao.delete(u);
	}
	
	/**
	 * 3.批量删除客户 基本信息
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void deleteOrderInfo(String[] ids) throws KINGException{
		orderInfoDao.delete(ids);
	}
	
	/**
	 * 4.修改客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public OrderInfoData updateOrderInfo(OrderInfoData u) throws KINGException{
		orderInfoDao.update(u);
		return u;
	}
	
	/**
	 * 5.查询单个客户 基本信息
	 * @param id 客户 基本信息ID
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public OrderInfoData retrieveOrderInfo(String id) throws KINGException{
		String hql = "from OrderInfoData u where u.id = '" +id+ "'";
		return (OrderInfoData) orderInfoDao.search(hql).get(0);
	}
	
	/**
	 * 6.查询客户 基本信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 客户 基本信息集合
	 * @throws KINGException
	 */
	public List<OrderInfoData> searchOrderInfoList(PageRoll pageRoll,String withhql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from OrderInfoData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = orderInfoDao.searchlist(pageRoll,withhql);
		System.out.println("-----list.size()="+list.size());
		return list;
	}

	/**
	 * 7.批量更新客户 基本信息
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateOrderInfo(String[] ids) throws KINGException{
		for (int i = 0; i < ids.length; i++) {
			String withsql=" update orderinfo set state='2' where id='"+ids[i]+"'";
			int flag=orderInfoDao.executeSQL(withsql);
			
		}
	}
	
	/**
	 * 8.更新客户状态
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateOrderInfoByid(String id,String state) throws KINGException{	
			String withsql=" update orderinfo set state='"+state+"' where id='"+id+"'";
			int flag=orderInfoDao.executeSQL(withsql);			
	}

	public IOrderInfoDAO getOrderInfoDao() {
		return orderInfoDao;
	}

	public void setOrderInfoDao(IOrderInfoDAO orderInfoDao) {
		this.orderInfoDao = orderInfoDao;
	}


}
