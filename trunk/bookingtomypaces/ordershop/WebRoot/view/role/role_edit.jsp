<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link href="<%=request.getContextPath()%>/js/should_be_excluded/css/style.css" rel="stylesheet" type="text/css"/>
<script src="<%=request.getContextPath()%>/js/should_be_excluded/js/jquery/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/should_be_excluded/js/dutil/DUtil.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
<script src="<%=request.getContextPath()%>/js/common.js" type="text/javascript"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/js/utiltools.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/view/role/role.js'></script>
<script type="text/javascript">
function setValue(){
var obj = document.all;
var s="";
for (i = 0; i < obj.length; i++) {
if(obj[i].checked) s = s + obj[i].value + ",";
}
s = s.substring(0,s.length-1);
s = "<input type='hidden' name='funId' value='"+s+"' />";
document.getElementById("cdata").innerHTML = s;
//alert(s);
}
</script>

<title>用戶組權限修改</title>
</head>

<body class="maintable" >
<s:form action="editRole" method="post"  theme="simple" onsubmit="return checkf(this);">
<input type="hidden" name="id" value="<s:property value='role.id' />" />

     <div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶組權限修改</div>
    </div>
    <div class="dclass_container_content1">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">    
     
          <tr>
              <td width="10%" align="center" class="formtitle">角色名稱</td>
              <td width="90%"  class="formtd">
                <input type="text" name="name" value="<s:property value='role.name' />" /><div id="cdata" style="display:none"></div>               
                </td>
              </tr>
            <tr>
              <td  class="formtitle" align="center">角色說明</td>
              <td class="formtd"><label>
                <textarea name="memo" cols="30" rows="3"><s:property value='role.memo' /></textarea>
              </label></td>
              </tr>
            <tr>
              <td valign="top"  class="formtitle" align="center">功能列表</td>
            
              
                  <td  class="formtd">
                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td  class="rankbottomline"><input type="checkbox" id="all" value="0" onclick="checkbox.select('all');setValue();"   /><b>全部功能</b></td>	               
	              </tr>
	               <s:iterator id="f" value="funList.{?#this.perfunc==0}">
				  <tr>
				  <td  class="ranktit"><input type="checkbox" id="<s:property value='id' />m" onclick="checkbox.selectAll('s<s:property value='id' />','<s:property value='id' />m');setValue();" value="<s:property value='id' />"  <s:if test="ht.containsValue(id)==true">checked</s:if>  /><s:property value="funcname" /></td>
				  </tr>
	              <tr>
	                <td class="rankbottomline">
	                	<s:iterator value="funList.{?#this.perfunc==#f.id}">
	                		 <s:if test="null!=url">
	                			<input type="checkbox" id="<s:property value='id' />c" name="s<s:property value='perfunc' />" onclick="checkbox.selectMax('<s:property value='perfunc' />s','<s:property value='#f.id' />m');setValue();" value="<s:property value='id' />" <s:if test="ht.containsValue(id)==true">checked</s:if>  /><s:property value="funcname" />
	                	 	</s:if>
	                	</s:iterator>
	                </td>							               
	              </tr>
	              </s:iterator>
	            </table>
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
	
	function useradd(){
 		document.forms[0].action="<%//=request.getContextPath()%>/role/key/editRole";
		document.forms[0].submit();
	}
</script>
--></html>