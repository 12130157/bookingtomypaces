<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>店鋪資料管理</title>
</head>

<body class="maintable">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">店鋪資料搜索條件</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
		<form action="<%=request.getContextPath()%>/store/key/list" method="post">
		<table>
			<tr>
				<td >
				    
					店鋪名稱:<input type="text" class="inputsearch" name="name" value="<s:property value="store.name" />" />
					&nbsp;&nbsp;&nbsp;
					店鋪狀態:<select name="status" >
					<option value=-1 >未選擇</option>
                	<option value=0 <s:if test="store.status==0">selected</s:if>>啟用</option>
                	<option value=1 <s:if test="store.status==1">selected</s:if>>禁用</option>
                	</select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" class="btn1" value="查 詢" /></td>
			</tr>
		</table>	
		</form>
	</div>
	
	
	</div>
</div>
<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">店鋪資料列表</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->
	<form action="" method="post">
	<div class="actions">
		<input name="Submit" type="button" class="btn1" value="新 增" onClick="goURL3('<%=request.getContextPath()%>/store/key/addjsp');"/>		
	</div>	
	
	<table class="dclass_data" >
		<thead>
			<tr>
		
				<th >店鋪名稱</th>
				<th >英文簡稱</th>
				<th >店鋪地址</th>
				<th >店長姓名</th>
				<th >店長電話</th>
				<th >狀態</th>
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="storeList" status="flag" >
		<tr >			
			
			<td align="center"><s:property value="name"/></td>
			<td align="center"><s:property value="shortName"/></td>
			<td align="center"><s:property value="address"/></td>
			<td align="center"><s:property value="managerName"/></td>
			<td align="center"><s:property value="managerMobile"/></td>
			<td align="center"><s:if test="status==0">啟用</s:if><s:else>禁用</s:else></td>
			<td align="center">
				<a href="#" onclick="edit_jsp('<s:property value="id"/>');" class='linkorange'>编辑</a>
				<a href="#" onclick="delete_jsp('<s:property value="id"/>');" class='linkorange'>删除</a>
			</td>
		</tr>
		</s:iterator>
		<tr>
              <td colspan="7" align="right" class="backwhite" height="30">
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
<script>
function edit_jsp(id){
		var url_str="<%=request.getContextPath()%>/store/key/editjsp?id="+id;
		goURL3(url_str);
	}
function delete_jsp(id){
		var url_str="<%=request.getContextPath()%>/store/key/deletestore?id="+id;
		operate(url_str,"您確定要刪除此店鋪？");
	}
</script>
</html>