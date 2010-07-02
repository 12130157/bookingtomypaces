package com.king.web.clientmanage.clientInfo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;
import com.king.tools.DateTool;
import com.king.tools.PageRoll;
import com.king.web.clientmanage.clientInfo.data.ClientInfoData;
import com.king.web.clientmanage.clientInfo.service.IClientInfoService;
import com.tag.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="list", location="view/clientInfo/clientInfo_list.jsp"),
	@Result(name="edit", location="view/clientInfo/clientInfo_edit.jsp"),
	@Result(name="add", location="view/clientInfo/clientInfo_add.jsp"),
	@Result(name="view", location="view/clientInfo/clientInfo_view.jsp")
})

public class ClientInfoAction extends FrmAction{

	private IClientInfoService clientInfoService;
	private List<ClientInfoData> clientInfoList=new ArrayList<ClientInfoData>();
	private ClientInfoData clientinfodata;
	
	
	/**
	 * 1.客户列表
	 * @return
	 * @throws KINGException
	 */
	public String list() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}
		String withsql=" where 1=1 ";
		String find_str = request.getParameter("find_str")==null?"":request.getParameter("find_str").toString();
		if(!"".equals(find_str)){
			withsql+=" and (client_num like '%"+find_str+"%' or company_shortname like '%"+find_str+"%') ";
		}
		System.out.println("withsql: "+withsql);
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		clientInfoList =clientInfoService.searchClientInfoList(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/client_info/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		ServletActionContext.getRequest().setAttribute("find_str", find_str);
		return "list";
	}
	
	/**
	 * 2.无条件客户列表
	 * @return
	 * @throws KINGException
	 */
	public String staticlist() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}
		String withsql=" where 1=1 ";
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		clientInfoList =clientInfoService.searchClientInfoList(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/client_info/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
	}
	
	/**
	 * 进入新增页面
	 * @return
	 * @throws KINGException
	 */
	public String addjsp()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		return "add";
	}
	/**
	 * 新增操作
	 * @return
	 * @throws KINGException
	 */
	public String add()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
//		System.out.println("Client_id=="+clientinfodata.getId());
//		System.out.println("Client_num=="+clientinfodata.getClient_num());
//		System.out.println("userName=="+clientinfodata.getCompany_name());
		clientinfodata.setCreateTime(DateTool.getNowDate());
		//System.out.println("getCreate_time=="+clientinfodata.getCreate_time());
		clientInfoService.addClientInfo(clientinfodata);
		
		return this.staticlist();
	}
	
	/**
	 * 进入编辑
	 * @return
	 * @throws KINGException
	 */
	public String editjsp()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		System.out.println("id=="+request.getParameter("id"));
		clientinfodata=clientInfoService.retrieveClientInfo(request.getParameter("id"));
		return "edit";
	}
	/**
	 * 编辑操作
	 * @return
	 * @throws KINGException
	 */
	public String edit()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		System.out.println("Client_id=="+clientinfodata.getId());
		System.out.println("Client_num=="+clientinfodata.getClientNum());
		System.out.println("userName=="+clientinfodata.getCompanyName());
		clientInfoService.updateClientInfo(clientinfodata);
		
		return this.staticlist();
	}

	/**
	 * 查询客户编号是否重复
	 * @param name
	 * @return
	 * @throws KINGException
	 */
	public Integer findByProperty(String name)throws KINGException{
		//System.out.println("findByProperty.name=="+name);
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(1);
		clientInfoList =clientInfoService.searchClientInfoList(p, " where 1=1 and  client_num='"+name+"' ");
		System.out.println("findByProperty.count=="+p.getTotalRows()+":::"+clientInfoList.size());
		return p.getTotalRows();
	}
	
	/**
	 * 查看客户资料
	 * @return
	 * @throws KINGException
	 */
	public String view()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		System.out.println("id=="+request.getParameter("id"));
		clientinfodata=clientInfoService.retrieveClientInfo(request.getParameter("id"));
		return "view";
	}
	
	/**
	 * 批量刪除操作
	 * @return
	 * @throws KINGException
	 */
	public String del()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		//System.out.println("Client_num=="+clientinfodata.getClient_num());
		//System.out.println("userName=="+clientinfodata.getCompany_name());
		String[] ids=request.getParameterValues("checkbox");
		clientInfoService.updateClientInfo(ids);
		//clientInfoService.deleteClientInfo(ids);
		
		return this.staticlist();
	}
	
	public IClientInfoService getClientInfoService() {
		return clientInfoService;
	}


	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}


	public List<ClientInfoData> getClientInfoList() {
		return clientInfoList;
	}


	public void setClientInfoList(List<ClientInfoData> clientInfoList) {
		this.clientInfoList = clientInfoList;
	}

	public ClientInfoData getClientinfodata() {
		return clientinfodata;
	}

	public void setClientinfodata(ClientInfoData clientinfodata) {
		this.clientinfodata = clientinfodata;
	}


}
