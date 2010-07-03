<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="<%=request.getContextPath()%>/js/should_be_excluded/css/style.css" rel="stylesheet" type="text/css"/>
<script src="<%=request.getContextPath()%>/js/should_be_excluded/js/jquery/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/should_be_excluded/js/dutil/DUtil.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
<script src="<%=request.getContextPath()%>/js/common.js" type="text/javascript"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/js/utiltools.js"></script>
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

<title>用戶權限分配</title>
</head>

<body class="maintable" >
<s:form  method="post"  theme="simple" onsubmit="return check(this);">
<input type="hidden" name="uId" value="<s:property value='uId' />" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶權限分配</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         <tr>
            <td class="formtitle" width="10%" align="center">權限組:</td>
            <td class="formtd" width="90%" > 
            	<s:select list="roleMap" name="rId"  headerKey="0" headerValue="未選擇" emptyOption="false" onchange="showfunc(this);" ></s:select>
            </td>
          
          </tr>
            <tr >
             <td id="fun1" valign="top"  class="formtitle" align="center">功能列表<div id="cdata" style="display:none"></div></td>
            
              
                  <td id="fun" class="formtd">
                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td  class="rankbottomline"><input type="checkbox" id="all" value="0" onclick="checkbox.select('all');setValue();"   /><b>全部功能</b></td>	               
	              </tr>
	               <s:iterator id="f" value="funList.{?#this.perfunc==0}">
				  <tr>
				  <td  class="ranktit"><input type="checkbox" id="<s:property value='id' />m" onclick="checkbox.selectAll('<s:property value='id' />s','<s:property value='id' />m');setValue();" value="<s:property value='id' />"  <s:if test="ht.containsValue(id)==true">checked</s:if>  /><s:property value="funcname" /></td>
				  </tr>
	              <tr>
	                <td class="rankbottomline">
	                	<s:iterator value="funList.{?#this.perfunc==#f.id}">
	                		 <s:if test="null!=url">
	                			<input type="checkbox" id="<s:property value='id' />c" name="<s:property value='perfunc' />s" onclick="checkbox.selectMax('<s:property value='perfunc' />s','<s:property value='#f.id' />m');setValue();" value="<s:property value='id' />" <s:if test="ht.containsValue(id)==true">checked</s:if>  /><s:property value="funcname" />
	                	 	</s:if>
	                	</s:iterator>
	                </td>							               
	              </tr>
	              </s:iterator>
	            </table>
               </td> 
               
          
            </tr>
           
     </table>
    <div style="padding:0.3em; text-align:center">
    	<input type="button" class="btn1" value="保 存" onclick="useradd();" />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<script language="javascript" type="text/javascript">
	
	function useradd(){
 		document.forms[0].action="<%=request.getContextPath()%>/user/key/editfunc";
		document.forms[0].submit();
	}
	function showfunc(obj){
		if(obj.options[obj.selectedIndex].value!=0){
			document.getElementById("fun").style.display="none";
			document.getElementById("fun1").style.display="none";
		}else{
			document.getElementById("fun").style.display="";
			document.getElementById("fun1").style.display="";
		}
	}
</script>
</html>