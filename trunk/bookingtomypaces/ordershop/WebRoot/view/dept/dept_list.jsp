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

<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">部門資料列表</div>
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
		
				<th >ID</th>
				<th >部門名稱</th>
				<th >狀態</th>
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="deptList" status="flag" >
		<tr >			
			<td><a href="#"><s:property value="id"/></a></td>
			<td><s:property value="name"/></td>
			<td><s:property value="status"/></td>
			<td >
				<a href="#" onclick="edit_jsp('<s:property value="id"/>')" class='linkorange'>编辑</a>
				<a href="#" onclick="update_up('<s:property value="id"/>');" class='linkorange'>删除</a>
			</td>
		</tr>
		</s:iterator>
		<tr>
              <td colspan="4" align="right" class="backwhite" height="30">
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
		var url_str="user/key/editjsp?id="+id;
		goURL3(url_str);
	}
function update_up(itemid){
	var url_str="cpinfo/update_order_item2.action?searchValue['id']="+itemid;
	//alert(url_str)
		operate(url_str,"您确定要列印制作此订单?");
	}
</script>
</html>