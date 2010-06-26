<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>用戶組權限管理</title>
</head>

<body class="maintable">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶組權限列表</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
		<form action="" method="post">
		<table>
			<tr>
				<td >
				    
					用戶組名稱:<input type="text" class="inputsearch" name="textfield" />
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
        <div class="dclass_container_title">用戶組權限列表</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->
	<form action="" method="post">
	<div class="actions">
		<input name="Submit" type="button" class="btn1" value="新 增" onClick="goURL3('<%=request.getContextPath()%>/role/key/addjsp');"/>		
	</div>	
	
	<table class="dclass_data" >
		<thead>
			<tr>
		
				<th >用戶組權限名稱</th>
				<th >備註</th>	
				
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="roleList" status="flag" >
		<tr >			
			<td><a href="#"><s:property value="name"/></a></td>
			<td><s:property value="memo"/></td>
			
			<td >
				<a href="#" onclick="edit_jsp('<s:property value="id"/>')" class='linkorange'>编辑</a>
				<a href="#" onclick="del_jsp('<s:property value="id"/>');" class='linkorange'>删除</a>
			</td>
		</tr>
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
		var url_str="<%=request.getContextPath()%>/role/key/editjsp?id="+id;
		goURL3(url_str);
	}
function del_jsp(id){
	var url_str="<%=request.getContextPath()%>/role/key/deljsp?id="+id;
		goURL3(url_str);
	}
</script>
</html>