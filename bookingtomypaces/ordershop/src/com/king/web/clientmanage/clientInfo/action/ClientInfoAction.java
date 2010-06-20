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
	@Result(name="login", location="view/login/login.jsp"),
	@Result(name="list", location="view/clientInfo/clientInfo_list.jsp"),
	@Result(name="edit", location="view/clientInfo/clientInfo_edit.jsp"),
	@Result(name="add", location="view/clientInfo/clientInfo_add.jsp")
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
			return "login";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		clientInfoList =clientInfoService.searchClientInfoList(p, " where 1=1  ");
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = "/ordershop/client_info/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
	}
	
	public String addjsp()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		return "add";
	}

	public String add()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		//System.out.println("unitId=="+request.getParameter("unitId"));
		//System.out.println("userName=="+request.getParameter("userName"));
		System.out.println("Client_num=="+clientinfodata.getClient_num());
		System.out.println("userName=="+clientinfodata.getCompany_name());
		clientinfodata.setCreate_time(DateTool.getNowDate());
		//System.out.println("getCreate_time=="+clientinfodata.getCreate_time());
		clientInfoService.addClientInfo(clientinfodata);
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		clientInfoList =clientInfoService.searchClientInfoList(p, " where 1=1  ");
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = "/ordershop/client_info/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
	}
	
	public String editjsp()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		System.out.println("id=="+request.getParameter("id"));
		return "edit";
	}

	public String edit()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		//System.out.println("unitId=="+request.getParameter("unitId"));
		//System.out.println("userName=="+request.getParameter("userName"));
		System.out.println("Client_num=="+clientinfodata.getClient_num());
		System.out.println("userName=="+clientinfodata.getCompany_name());
		clientInfoService.addClientInfo(clientinfodata);
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		clientInfoList =clientInfoService.searchClientInfoList(p, " where 1=1  ");
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = "/ordershop/client_info/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
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
