<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>用戶資料管理</title>
</head>

<body class="maintable">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶資料搜索條件</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
		<form action="" method="post">
		<table>
			<tr>
				<td >
				    
					用戶名:<input type="text" class="inputsearch" name="textfield" />
					&nbsp;&nbsp;&nbsp;
					<input type="image" src="<%=request.getContextPath()%>/images/btn_search.gif"/></td>
			</tr>
		</table>	
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
		<input name="Submit" type="button" class="btn1" value="新 增" onClick="goURL3('<%=request.getContextPath()%>/user/key/addjsp');"/>		
	</div>	
	
	<table class="dclass_data" >
		<thead>
			<tr>
		
				<th >用戶名稱</th>
				<th >用戶帳號</th>
				<th >所屬部門</th>
				<th >所屬區域</th>
				<th >所屬店面</th>
				<th >手機</th>	
				<th >狀態</th>	
				<th >創建時間</th>
				<th >最後登陸時間</th>
				<th >最後登陸IP</th>
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="userList" status="flag" >
		<tr >	
			<td align="center"><s:property value="realName"/></td>		
			<td align="center"><s:property value="userName"/></td>
			<td align="center"><s:property value="deptId"/></td>
			<td align="center"><s:property value="areaMap.get(areaId)"/></td>
			<td align="center"><s:property value="shopId"/></td>
			<td align="center"><s:property value="mobile"/></td>
			<td align="center"><s:if test="status==0">使用中</s:if><s:else>禁用</s:else></td>
			<td align="center"><s:date name="creatTime" format="yyyy-MM-dd HH:mm:ss" /></td>
			<td align="center"><s:date name="lastTime" format="yyyy-MM-dd HH:mm:ss" /></td>
			<td align="center"><s:property value="lastIp"/></td>	
			<td align="center">
			    <a href="#" onclick="func_jsp('<s:property value="id"/>')" class='linkorange'>权限分配</a>
				<a href="#" onclick="edit_jsp('<s:property value="id"/>')" class='linkorange'>编辑</a>
				<s:if test="status==0"><a href="#" onclick="update('<s:property value="id"/>');" class='linkorange'>禁用</a></s:if>
				<s:else><a href="#" onclick="update('<s:property value="id"/>');" class='linkorange'>啟用</a></s:else>
			</td>
		</tr
		</s:iterator>
		<tr>
              <td colspan="7" align="right" class="backwhite" height="30">
              共${page.count}條記錄&nbsp;<tools:pageUrl url="${url}" count="${page.count}" curPage="${page.curPage}" pageSize="${page.pageSize}" />			  
			  </td>
      </tr>	
		</tbody>
	</table>
	</form>
	
	<!--内容结束-->
</div>
</div>
</body>
<script>
	function edit_jsp(id){
		var url_str="<%=request.getContextPath()%>/user/key/editjsp?id="+id;
		goURL3(url_str);
	}
	function func_jsp(id){
		var url_str="<%=request.getContextPath()%>/user/key/funcjsp?id="+id;
		goURL3(url_str);
	}
	function update(id){
		var url_str="<%=request.getContextPath()%>/user/key/updateUser?id="+id;
		operate(url_str,"您確定要禁用此用戶?");
	}
</script>
</html>