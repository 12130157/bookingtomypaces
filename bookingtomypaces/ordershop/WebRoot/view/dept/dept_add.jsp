<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/DeptData.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/view/dept/dept.js'></script>
<jsp:include page="../../head.jsp" />
<title>部門資料增加</title>
</head>

<body class="maintable">
<s:form action="addDept"  method="post"  theme="simple" onsubmit="return check(this);">
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">部門资料增加</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         <tr>
              <td align="right" class="formtitle">部門名稱:</td>
              <td class="formtd">
                <input type="text" id="name" name="name" onBlur="javascript:isExistName();" /> 
                <div id="_name" ></div>          
                </td>
         </tr>
		 
		
          <tr>
            <td class="formtitle" align="right">状态:</td>
            <td class="formtd"> 
            	<select type="text" name="status" >
                	<option value=0 selected>使用</option>
                	<option value=1 >禁用</option>
                </select>
            </td>
            
          </tr>
     </table>
    <div style="padding:0.3em; text-align:center">
    	<input type="button" class="btn1" value="保 存" onclick="deptadd();" />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<script language="javascript" type="text/javascript">
	
	function deptadd(){
		
		if(document.getElementById("_isexist").value!="0"){
			document.getElementById("name").focus();
				return false;
		}else{
	 		document.forms[0].action="<%=request.getContextPath()%>/dept/key/addDept";
			document.forms[0].submit();
		}
	}
</script>
</html>