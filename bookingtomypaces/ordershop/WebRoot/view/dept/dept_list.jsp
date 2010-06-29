<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>部門資料管理</title>
</head>

<body class="maintable">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">部門資料搜索條件</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
		<form action="<%=request.getContextPath()%>/dept/key/list" method="post">
		<table>
			<tr>
				<td >
				    
					部門名稱:<input type="text" class="inputsearch" name="name"  />
					&nbsp;&nbsp;&nbsp;
					部門狀態:<select name="status" >
                	<option value=0 >使用</option>
                	<option value=1 >禁用</option>
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
        <div class="dclass_container_title">部門資料列表</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->
	<form action="" method="post">
	<div class="actions">
		<input name="Submit" type="button" class="btn1" value="新 增" onClick="goURL3('<%=request.getContextPath()%>/dept/key/addjsp');"/>		
	</div>	
	
	<table class="dclass_data" >
		<thead>
			<tr>
		
				<th >部門名稱</th>
				<th >狀態</th>
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="deptList" status="flag" >
		<tr >			
			
			<td align="center"><s:property value="name"/></td>
			<td align="center"><s:if test="status==0">使用中</s:if><s:else>禁用</s:else></td>
			<td align="center">
				<a href="#" onclick="edit_jsp('<s:property value="id"/>');" class='linkorange'>编辑</a>
				<a href="#" onclick="delete_jsp('<s:property value="id"/>');" class='linkorange'>删除</a>
			</td>
		</tr>
		</s:iterator>
		<tr>
              <td colspan="3" align="right" class="backwhite" height="30">
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
		var url_str="<%=request.getContextPath()%>/dept/key/editjsp?id="+id;
		goURL3(url_str);
	}
function delete_jsp(id){
		var url_str="<%=request.getContextPath()%>/dept/key/deleteDept?id="+id;
		operate(url_str,"您確定要刪除此部門？");
	}
</script>
</html>