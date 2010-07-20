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
<title>店鋪資料增加</title>
</head>

<body class="maintable">
<s:form action="addstore"  method="post"  theme="simple" onsubmit="return checkf(this);">
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">店鋪资料增加</div>
    </div>
    <div class="dclass_container_content1">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         <tr>
              <td width="16%" class="formtitle">店鋪名稱:</td>
              <td  class="formtd">
                <input type="text" id="name" name="name" onBlur="javascript:isExistName();" /> 
                <div id="_name" ></div>          
                </td>
         </tr>
		 <tr>
              <td width="16%" class="formtitle">英文簡稱:</td>
              <td class="formtd">
                <input type="text" id="shortName" name="shortName"/>      
                </td>
         </tr>
		<tr>
              <td  class="formtitle">店鋪地址:</td>
              <td class="formtd">
                <input type="text" id="address" name="address"/>      
                </td>
         </tr>
         <tr>
              <td  class="formtitle">店長姓名:</td>
              <td class="formtd">
                <input type="text" id="managerName" name="managerName"/>      
                </td>
         </tr>
         <tr>
              <td  class="formtitle">店長電話:</td>
              <td class="formtd">
                <input type="text" id="managerMobile" name="managerMobile"/>      
                </td>
         </tr>
          <tr>
            <td class="formtitle" >状态:</td>
            <td class="formtd"> 
            	<select type="text" name="status" >
                	<option value=0 selected>啟用</option>
                	<option value=1 >禁用</option>
                </select>
            </td>
            
          </tr>
     </table>
    <div class="dclass_bt">
    	<input type="submit" class="btn1" value="保 存"  />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<!--<script language="javascript" type="text/javascript">
	
	function add(){
		
		if(document.getElementById("_isexist").value!="0"){
			document.getElementById("name").focus();
				return false;
		}else{
	 		document.forms[0].action="<%//=request.getContextPath()%>/store/key/addstore";
			document.forms[0].submit();
		}
	}
</script>
--></html>