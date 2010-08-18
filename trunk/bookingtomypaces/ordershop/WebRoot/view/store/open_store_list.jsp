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
<script language="javascript" type="text/javascript">
			//選中的店铺信息
			var P = window.parent, D = P.loadinndlg();  
				
			function getStoreInfo(str_id,str_name,str_shortName){	
				D.return_StoreOpenselect(str_id,str_name,str_shortName);			
				P.reload('#','#'); 
			}		
	</script>
<body class="maintable">

<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">店鋪資料列表</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->
	<form action="" method="post">
	
	</div>	
	 <div class="dclass_container_content1">
	<table class="dclass_data" >
		<thead>
			<tr>
		
				<th >店鋪名稱</th>
				<th >英文簡稱</th>
				<th >店鋪地址</th>
				<th >店長姓名</th>
				<th >店長電話</th>
			
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
			
			<td align="center">
				<a href="#" onclick="getStoreInfo('<s:property value="id"/>','<s:property value="name"/>','<s:property value="shortName"/>');" class='linkorange'>確定</a>
			</td>
		</tr>
		</s:iterator>
		
		</tbody>
	</table>
	</form>
	
	<!--内容结束-->
</div>
</div>
</body>
</html>