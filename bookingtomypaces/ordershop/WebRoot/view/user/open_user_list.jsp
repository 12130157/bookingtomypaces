<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<script type='text/javascript' src='<%=request.getContextPath()%>/view/user/user.js'></script>
<title>用戶資料管理</title>
<script language="javascript" type="text/javascript">
//獲取選中的員工
var P = window.parent, D = P.loadinndlg();  
function getCheckBoxsValues(checkName){
	var adminID = "";
	obj = document.getElementsByName(checkName);
	var t = 0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].checked){
			if(t==0){
				adminID = obj[i].value;
			}else{
				alert("只能選擇一個員工");
				return false;
			}
			t++;
		}
	}
	if(adminID!=""){
	    var varArray = "";
			if(adminID.indexOf("&") != -1){
				varArray = adminID.split("&")
			}
			//alert(varArray[0]+"---"+varArray[1])			
			D.return_openselect(varArray[0],varArray[1]);			
			P.reload('#','#'); 
			
	}else{
		alert("請選擇一個員工");
		return false;
	}
}

</script>
</head>
<body class="maintable">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶資料搜索條件</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
		<form action="<%=request.getContextPath()%>/user/key/open_user_list" method="post">
					<span id="a"></span>
				    <div class="actions">
					<span>帳號:<input type="text" class="inputsearch" name="userName" value="<s:property value="userdata.userName" />"  /></span>
					&nbsp;
					<span>手機:<input type="text" class="inputsearch" name="mobile" value="<s:property value="userdata.mobile" />"  /></span>
					&nbsp;
					<span>狀態:<select name="status" >
						<option value=-1 >未選擇</option>
	                	<option value=0 <s:if test="userdata.status==0">selected</s:if>>啟用</option>
	                	<option value=1 <s:if test="userdata.status==1">selected</s:if>>禁用</option>
                	</select></span>
					&nbsp;
					<span>部門:<s:select list="deptMap" name="deptId"  value="%{userdata.deptId}" headerKey="0" headerValue="未選擇" emptyOption="false"  ></s:select></span>
					</div>
					<div class="actions">
					<span>區域:<s:select list="areaMap" name="areaId" value="%{userdata.areaId}"  headerKey="0" headerValue="未選擇" emptyOption="false" ></s:select></span>
						&nbsp;
					<span>店鋪:<s:select list="storeMap" name="shopId" value="%{userdata.shopId}"  headerKey="0" headerValue="未選擇" emptyOption="false"  ></s:select></span>					 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span><input type="submit" class="btn1" value="查 詢" /></span>
					</div>			
		</form>
	</div>
	</div>
</div>
<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">人員資料列表</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->
	<form action="" method="post">
	<div class="actions">
		<input name="Submit" id="bt" type="button" class="btn1" value="選 中" onclick="getCheckBoxsValues('checkbox')"/>		
	</div>	
	</div>	
	 <div class="dclass_container_content1">
	<table class="dclass_data" >
		<thead>
			<tr>		
				<th align="center"></th>
				<th >用戶名稱</th>
				<th >用戶帳號</th>
				<th >所屬部門</th>
				<th >所屬區域</th>
				<th >所屬店面</th>
				<th >手機</th>	
				<th >狀態</th>					
			</tr>
		</thead>
		<tdoby>
			<s:iterator  value="userList" status="flag" >
			<tr >	
				<td align="center"><input type="checkbox" name="checkbox"  value="<s:property value="id"/>&<s:property value="realName"/>"></td>
				<td align="center"><s:property value="realName"/></td>		
				<td align="center"><s:property value="userName"/></td>
				<td align="center"><s:property value="deptMap.get(deptId)"/></td>
				<td align="center"><s:property value="areaMap.get(areaId)"/></td>
				<td align="center"><s:property value="storeMap.get(shopId)"/></td>
				<td align="center"><s:property value="mobile"/></td>
				<td align="center"><s:if test="status==0">啟用</s:if><s:else><font color=red>禁用</font></s:else></td>			
			</tr>
			</s:iterator>
			<tr>
	              <td colspan="11" align="right" class="backwhite" height="30">
	              <tools:pageUrl url="${url}" count="${page.count}" curPage="${page.curPage}" pageSize="${page.pageSize}" />			  
				  </td>
	      	</tr>	
		</tbody>
	</table>
	</form>	
	<!--内容结束-->
</div>
</div>

</body>
</html>