<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>客戶資料管理</title>
</head>
<script type="text/javascript"  src="<%=request.getContextPath()%>/view/clientInfo/clientInfo.js"  ></script>

<body class="maintable">
<form action="list" method="post">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料列表</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">		
		<table>
			<tr>
				<td >
				    
					客戶編號:<input type="text" class="inputsearch" name="find_num" value="${find_num }"/>
					&nbsp;
					公司簡稱:<input type="text" class="inputsearch" name="find_comp" value="${find_comp }"/>
					&nbsp;
					公司電話:<input type="text" class="inputsearch" name="find_comphone" value="${find_comphone }"/>
					&nbsp;
					聯繫人:<input type="text" class="inputsearch" name="find_linkman" value="${find_linkman }"/>
					&nbsp;
					負責職員:<input type="text" class="inputsearch" name="find_functionary" value="${find_functionary }"/>
					&nbsp;
					<input name="sb" type="submit" class="btn1" value="查 詢" /></td>
			</tr>
		</table>	
	</div>
	
	
	</div>
</div>
<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料列表</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->
	<div class="actions">
		<input name="Submit" type="button" class="btn1" value="新 增" onClick="goURL3('<%=request.getContextPath()%>/client_info/key/addjsp');"/>
		<input name="delbt" type="button" class="btn1" value="刪 除" onClick="del();"/>		
	</div>	
	
	<table class="dclass_data" >
		<thead>
			<tr>
				<th align="center"><input type="checkbox"  name="selectButton" value="checkbox" onclick='return selectAll();'></th>
				<th >客戶編號</th>
				<th >公司簡稱</th>	
				<th >公司電話</th>	
				<th >聯繫人</th>
				<th >聯繫人電話</th>
				<th >地址</th>
				<th >狀態</th>
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="clientInfoList" status="flag" >
		<tr title="双击查看详细内容" onDblClick="view('<s:property value="id"/>');">			
			<td align="center"><input type="checkbox" name="checkbox"  value="<s:property value="id"/>"></td>
			<td><a href="#"><s:property value="clientNum"/></a></td>
			<td><s:property value="companyShortname"/></td>
			<td><s:property value="compPhone"/></td>
			<td><s:property value="linkmanOne"/></td>
			<td><s:property value="phoneOne"/></td>
			<td><s:property value="addressOne"/></td>	
			<td>
				<s:if test="0==state">啟用</s:if>
				<s:if test="1==state"><span class="fontred">禁用</span></s:if>
			</td>	
			<td >
				<a href="#" onclick="edit_jsp('<s:property value="id"/>')" class='linkorange'>编辑</a>
				<s:if test="0==state"><a href="#" onclick="update_down('<s:property value="id"/>','1')" class='linkorange'>禁用</a></s:if>
				<s:if test="1==state"><a href="#" onclick="update_up('<s:property value="id"/>','0')" class='linkorange'>啟用</a></s:if>										
			</td>
		</tr>
		</s:iterator>
		<tr>
              <td colspan="9" align="right" class="backwhite" height="30">
              <tools:pageUrl url="${url}" count="${page.count}" curPage="${page.curPage}" pageSize="${page.pageSize}" />			  
			  </td>
      </tr>	
		</tbody>
	</table>

	
	<!--内容结束-->
</div>
</div>
</form>
</body>
</html>