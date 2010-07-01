
/**   
* 文件名：StoreAction.java   
*   
* 版本信息：   
* 日期：2010-7-1   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.usermanage.store.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;
import com.king.tools.PageRoll;
import com.king.web.usermanage.store.service.IStoreService;
import com.king.web.usermanage.store.data.StoreData;
import com.tag.PageVo;

/**   
 *    
 * 项目名称：ordershop   
 * 类名称：StoreAction   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-7-1 下午09:06:34   
 * 修改人：tim   
 * 修改时间：2010-7-1 下午09:06:34   
 * 修改备注：   
 * @version    
 *    
 */

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="index", location="view/store/store_list.jsp"),
	@Result(name="home", location="store/key/home",type="redirectAction"),
	@Result(name="login", location="view/store/login.jsp"),
	@Result(name="addview", location="view/store/store_add.jsp"),
	@Result(name="editview", location="view/store/store_edit.jsp")
})
public class StoreAction extends FrmAction{

	public IStoreService storeService;
	private List<StoreData> storeList=new ArrayList<StoreData>();
	private StoreData store= new StoreData();
	
	
	public String list() throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}

		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		String name = request.getParameter("name")==null?"":request.getParameter("name").toString();
		String shortName = request.getParameter("shortName")==null?"":request.getParameter("shortName").toString();
		String address = request.getParameter("address")==null?"":request.getParameter("address").toString();
		String managerName = request.getParameter("managerName")==null?"":request.getParameter("managerName").toString();
		String managerMobile = request.getParameter("managerMobile")==null?"":request.getParameter("managerMobile").toString();
		Integer status=request.getParameter("status")==null?-1:Integer.parseInt(request.getParameter("status").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		String withsql=" where 1=1 ";
		if(!"".equals(name)){
			withsql+=" and name like '%"+name+"%' ";
		}
		if(!"".equals(shortName)){
			withsql+=" and shortName like '%"+shortName+"%' ";
		}
		if(!"".equals(address)){
			withsql+=" and address like '%"+address+"%' ";
		}
		if(!"".equals(managerName)){
			withsql+=" and managerName like '%"+managerName+"%' ";
		}
		if(!"".equals(managerMobile)){
			withsql+=" and managerMobile like '%"+managerMobile+"%' ";
		}
		if(status>-1){
			withsql+=" and status = "+status;
		}
		storeList =storeService.searchStores(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/store/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		
		return "index";
		
	}
	
	public String staticlist() throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		String withsql=" where 1=1 ";
		
		storeList =storeService.searchStores(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/store/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		
		return "index";
		
	}
	/**
	 * 增加店鋪
	 * 
	 * @return
	 * @throws WebException
	 */
	public String addstore() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			StoreData s = new StoreData();
			s.setName(request.getParameter("name"));
			s.setShortName(request.getParameter("shortName"));
			s.setAddress(request.getParameter("address"));
			s.setManagerName(request.getParameter("managerName"));
			s.setManagerMobile(request.getParameter("managerMobile"));
			s.setStatus(request.getParameter("status")==null?0:Integer.parseInt(request.getParameter("status").toString()));
			storeService.addStore(s);
			return this.staticlist();
		}
	}
	
	/**
	 * 修改店鋪
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editstore() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			
			StoreData s =storeService.retrieveStore(request.getParameter("id"));
			if(null!=request.getParameter("name")){
				s.setName(request.getParameter("name"));
			}
			if(null!=request.getParameter("shortName")){
				s.setShortName(request.getParameter("shortName"));
			}
			if(null!=request.getParameter("address")){
				s.setAddress(request.getParameter("address"));
			}
			if(null!=request.getParameter("managerName")){
				s.setManagerName(request.getParameter("managerName"));
			}
			if(null!=request.getParameter("managerMobile")){
				s.setManagerMobile(request.getParameter("managerMobile"));
			}
			if(null!=request.getParameter("status")){
				s.setStatus(Integer.parseInt(request.getParameter("status").toString()));
			}
			storeService.updateStore(s);
			return this.staticlist();
		}
	}
	
	/**
	 * 增加店鋪JSP頁面
	 * 
	 * @return
	 * @throws WebException
	 */
	public String addjsp() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			return "addview";
		}
	}
	
	
	/**
	 * 修改店鋪JSP頁面
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editjsp() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			store =storeService.retrieveStore(request.getParameter("id"));	
			return "editview";
		}
	}
	
	
	/**
	 * 刪除店鋪
	 * 
	 * @return
	 * @throws WebException
	 */
	public String deletestore() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			store =storeService.retrieveStore(request.getParameter("id"));
			storeService.deleteStore(store);
			return this.staticlist();
		}
	}
	
	public Integer findByProperty(String name)throws KINGException{
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(1);
		
		storeList =storeService.searchStores(p, " where 1=1 and name = '"+name+"' " );
		return p.getTotalRows();
	}
	
	
	/**   
	 * storeService   
	 *   
	 * @return  the storeService   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public IStoreService getStoreService() {
		return storeService;
	}
	/**   
	 * @param storeService the storeService to set   
	 */
	
	public void setStoreService(IStoreService storeService) {
		this.storeService = storeService;
	}
	/**   
	 * storeList   
	 *   
	 * @return  the storeList   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public List<StoreData> getStoreList() {
		return storeList;
	}
	/**   
	 * @param storeList the storeList to set   
	 */
	
	public void setStoreList(List<StoreData> storeList) {
		this.storeList = storeList;
	}
	/**   
	 * store   
	 *   
	 * @return  the store   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public StoreData getStore() {
		return store;
	}
	/**   
	 * @param store the store to set   
	 */
	
	public void setStore(StoreData store) {
		this.store = store;
	}
	
}
