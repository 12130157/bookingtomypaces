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
import com.king.tools.PageVo;
import com.king.web.clientmanage.clientInfo.data.ClientInfoData;
import com.king.web.clientmanage.clientInfo.service.IClientInfoService;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="list", location="view/clientInfo/clientInfo_list.jsp"),
	@Result(name="edit", location="view/clientInfo/clientInfo_edit.jsp"),
	@Result(name="add", location="view/clientInfo/clientInfo_add.jsp"),
//	@Result(name="add", location="view/clientInfo/viewlist.jsp"),
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
		String withsql=" where 1=1 and state!='2' ";
		String find_num = request.getParameter("find_num")==null?"":request.getParameter("find_num").toString();
		String find_comp = request.getParameter("find_comp")==null?"":request.getParameter("find_comp").toString();
		String find_comphone = request.getParameter("find_comphone")==null?"":request.getParameter("find_comphone").toString();
		String find_linkman = request.getParameter("find_linkman")==null?"":request.getParameter("find_linkman").toString();
		String find_functionary = request.getParameter("find_functionary")==null?"":request.getParameter("find_functionary").toString();
		if(!"".equals(find_num)){
			withsql+=" and clientNum like '%"+find_num+"%' ";
		}
		if(!"".equals(find_comp)){
			withsql+=" and company_shortname like '%"+find_comp+"%' ";
		}
		if(!"".equals(find_comphone)){
			withsql+=" and comp_phone like '%"+find_comphone+"%' ";
		}
		if(!"".equals(find_linkman)){
			withsql+=" and linkman_one like '%"+find_linkman+"%' ";
		}
		if(!"".equals(find_functionary)){
			withsql+=" and functionary like '%"+find_functionary+"%' ";
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
		ServletActionContext.getRequest().setAttribute("find_num", find_num);
		ServletActionContext.getRequest().setAttribute("find_comp", find_comp);
		ServletActionContext.getRequest().setAttribute("find_comphone", find_comphone);
		ServletActionContext.getRequest().setAttribute("find_linkman", find_linkman);
		ServletActionContext.getRequest().setAttribute("find_functionary", find_functionary);
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
		String withsql=" where 1=1 and state!='2'";
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
		
		System.out.println("getClientNum=="+this.clientinfodata.getClientNum());
		System.out.println("getCompanyName=="+clientinfodata.getCompanyName());
		System.out.println("getE_mail=="+clientinfodata.getE_mail());
		clientinfodata.setCreateTime(DateTool.getNowDate());
		System.out.println("getCreate_time=="+clientinfodata.getCreateTime());
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
		clientInfoList =clientInfoService.searchClientInfoList(p, " where 1=1 and  clientNum='"+name+"' ");
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
	
	public String updateClientInfoByid() throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		System.out.println("id=="+request.getParameter("id"));
		clientInfoService.updateClientInfoByid(request.getParameter("id"), request.getParameter("state"));
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
