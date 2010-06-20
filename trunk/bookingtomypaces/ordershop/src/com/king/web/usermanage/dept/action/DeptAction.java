package com.king.web.usermanage.dept.action;

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
import com.king.web.usermanage.dept.data.DeptData;
import com.king.web.usermanage.dept.service.IDeptService;
import com.tag.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="index", location="view/dept/dept_list.jsp"),
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="login", location="view/user/login.jsp")
})

public class DeptAction extends FrmAction{

	private IDeptService deptService;
	private List<DeptData> deptList= new ArrayList<DeptData>();
	
	public String list() throws KINGException{
		System.out.println("----UnitAction.list()----------"+getFrmUser().getUserName());
		if(null==getFrmUser()){
			return "login";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		//p.setTotalPage(list.size()/p.getPageSize());
		
		deptList =deptService.searchDept(p, " where 1=1 and status = 0 ");
		//for(DeptData a:DeptList){
		//	System.out.println(":::"+a.getName()+":list.size="+p.getTotalPage());
		//}
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = "/booking/dept/key/index?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		
		return "index";
		
	}

	public IDeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public List<DeptData> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DeptData> deptList) {
		this.deptList = deptList;
	}
}
