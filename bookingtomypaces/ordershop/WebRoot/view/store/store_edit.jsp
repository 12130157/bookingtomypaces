<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/StoreData.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/view/store/store.js'></script>
<jsp:include page="../../head.jsp" />
<title>店鋪資料修改</title>
</head>

<body class="maintable">
<s:form action="addDept"  method="post"  theme="simple" onsubmit="return check(this);">
<input type="hidden" name="id" value="<s:property value='store.id' />" />
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">店鋪资料修改</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         <tr>
              <td align="right" class="formtitle">店鋪名稱:</td>
              <td class="formtd">
                <input type="text" id="name" name="name" onBlur="javascript:isExistName();" value="<s:property value='store.name' />" /> 
                <div id="_name" ></div>          
                </td>
         </tr>
		 <tr>
              <td align="right" class="formtitle">英文簡稱:</td>
              <td class="formtd">
                <input type="text" id="shortName" name="shortName" value="<s:property value='store.shortName' />"/>      
                </td>
         </tr>
		<tr>
              <td align="right" class="formtitle">店鋪地址:</td>
              <td class="formtd">
                <input type="text" id="address" name="address" value="<s:property value='store.address' />"/>      
                </td>
         </tr>
         <tr>
              <td align="right" class="formtitle">店長姓名:</td>
              <td class="formtd">
                <input type="text" id="managerName" name="managerName" value="<s:property value='store.managerName' />"/>      
                </td>
         </tr>
         <tr>
              <td align="right" class="formtitle">店長電話:</td>
              <td class="formtd">
                <input type="text" id="managerMobile" name="managerMobile" value="<s:property value='store.managerMobile' />" />      
                </td>
         </tr>
          <tr>
            <td class="formtitle" align="right">状态:</td>
            <td class="formtd"> 
            	<select type="text" name="status" >
                	<option value=0 <s:if test="store.status==0" >selected</s:if>>使用</option>
                	<option value=1 <s:if test="store.status==1" >selected</s:if>>禁用</option>
                </select>
            </td>
            
          </tr>
     </table>
    <div style="padding:0.3em; text-align:center">
    	<input type="button" class="btn1" value="保 存" onclick="add();" />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<script language="javascript" type="text/javascript">
	
	function add(){
		
		if(document.getElementById("_isexist").value!="0"){
			document.getElementById("name").focus();
				return false;
		}else{
	 		document.forms[0].action="<%=request.getContextPath()%>/store/key/editstore";
			document.forms[0].submit();
		}
	}
</script>
</html>