<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>客戶資料</title>
	<script language="javascript" type="text/javascript">
			//選中的客户信息
			var P = window.parent, D = P.loadinndlg();  
				
			function getClientInfo1(){
				var clientNum=document.getElementsByName("clientinfodata.clientNum")[0].value;
				var companyName=document.getElementsByName("clientinfodata.companyName")[0].value;
				var compPhone=document.getElementsByName("clientinfodata.compPhone")[0].value;
				var compFax=document.getElementsByName("clientinfodata.compFax")[0].value;
				var e_mail=document.getElementsByName("clientinfodata.e_mail")[0].value;
				var remark=document.getElementsByName("clientinfodata.remark")[0].value;
				var linkmanOne=document.getElementsByName("clientinfodata.linkmanOne")[0].value;
				var phoneOne=document.getElementsByName("clientinfodata.phoneOne")[0].value;
				var addressOne=document.getElementsByName("clientinfodata.addressOne")[0].value;
					
				D.return_ClientOpenselect(clientNum,companyName,compPhone,compFax,e_mail,remark,linkmanOne,phoneOne,addressOne);			
				P.reload('#','#'); 
			}		
			function getClientInfo2(){
				var clientNum=document.getElementsByName("clientinfodata.clientNum")[0].value;
				var companyName=document.getElementsByName("clientinfodata.companyName")[0].value;
				var compPhone=document.getElementsByName("clientinfodata.compPhone")[0].value;
				var compFax=document.getElementsByName("clientinfodata.compFax")[0].value;
				var e_mail=document.getElementsByName("clientinfodata.e_mail")[0].value;
				var remark=document.getElementsByName("clientinfodata.remark")[0].value;
				var linkmanTwo=document.getElementsByName("clientinfodata.linkmanTwo")[0].value;
				var phoneTwo=document.getElementsByName("clientinfodata.phoneTwo")[0].value;
				var addressTwo=document.getElementsByName("clientinfodata.addressTwo")[0].value;
					
				D.return_ClientOpenselect(clientNum,companyName,compPhone,compFax,e_mail,remark,linkmanTwo,phoneTwo,addressTwo);		
				P.reload('#','#'); 
			}		
	</script>
</head>
<script type="text/javascript"  src="<%=request.getContextPath()%>/view/clientInfo/clientInfo.js"  ></script>
<body class="maintable">
<s:form action="edit"  method="post"  theme="simple" >
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料</div>
    </div>
    <div class="dclass_container_content1">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
		  <tr>
            <td class="formtd" colspan="4"><span class="fontred">客戶</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">客戶編號:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.clientNum" type="text" class="inputform" value="${clientinfodata.clientNum }" ></td>
			<td class="formtitle" width="15%">地區:</td>
            <td class="formtd" width="35%"><input name="clientinfodata.areaName" type="text" class="inputform" value="${clientinfodata.areaName }"></td>			 
          </tr>
           <tr>
            <td class="formtitle">備註:</td>
            <td colspan="3" class="formtd"><textarea name="clientinfodata.remark" class="inputformtext" style="height:50%;">${clientinfodata.remark }</textarea></td>
          </tr>   
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">公司</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">公司名稱:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"><input name="clientinfodata.companyName" type="text" class="inputform" value="${clientinfodata.companyName }"></td>
			<td class="formtitle">公司簡稱:<span class="fontred">*</span></td>
            <td class="formtd"><input name="clientinfodata.companyShortname" type="text" class="inputform" value="${clientinfodata.companyShortname }"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">公司電話:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"><input name="clientinfodata.compPhone" type="text" class="inputform" value="${clientinfodata.compPhone }"></td>
			<td class="formtitle">公司傳真:</td>
            <td class="formtd"><input name="clientinfodata.compFax" type="text" class="inputform" value="${clientinfodata.compFax }"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">E-MAIL:</td>
            <td width="35%" class="formtd"><input name="clientinfodata.e_mail" type="text" class="inputform" value="${clientinfodata.e_mail }"></td>
			<td class="formtitle"></td>
            <td class="formtd"></td>			 
          </tr>
          <tr>
             <td class="formtd" colspan="2"><span class="fontred">聯繫方式[1]</span></td>
             <td class="formtd" colspan="2"><span class="fontred">聯繫方式[2]</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">聯繫人[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"><input name="clientinfodata.linkmanOne" type="text" class="inputform" value="${clientinfodata.linkmanOne }"></td>
			<td class="formtitle">聯繫人[2]:</td>
            <td class="formtd"><input name="clientinfodata.linkmanTwo" type="text" class="inputform" value="${clientinfodata.linkmanTwo }"> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人電話[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"><input name="clientinfodata.phoneOne" type="text" class="inputform" value="${clientinfodata.phoneOne }"></td>
			<td class="formtitle">聯繫人電話[2]:</td>
            <td class="formtd"><input name="clientinfodata.phoneTwo" type="text" class="inputform" value="${clientinfodata.phoneTwo }"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">職位[1]:</td>
            <td width="35%" class="formtd"><input name="clientinfodata.jobOne" type="text" class="inputform" value="${clientinfodata.jobOne }"></td>
			<td class="formtitle">職位[2]:</td>
            <td class="formtd"><input name="clientinfodata.jobTwo" type="text" class="inputform" value="${clientinfodata.jobTwo }"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">地址[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"><textarea name="clientinfodata.addressOne" class="inputformtext" style="width:100%;height:50%;">${clientinfodata.addressOne }</textarea></td>
			<td class="formtitle">地址[2]:</td>
            <td class="formtd"><textarea name="clientinfodata.addressTwo" class="inputformtext" style="width:100%;height:50%;">${clientinfodata.addressTwo }</textarea> </td>			 
          </tr>
         
          <tr>                      
            <td  class="formtd" colspan="2" align="center"><input type="button" class="btn1" value="確 定" onclick="javascript:getClientInfo1();" /></td>
            <td  class="formtd" colspan="2" align="center"><input type="button" class="btn1" value="確 定" onclick="javascript:getClientInfo2();" /></td>			 
          </tr>
     </table>
    <div class="dclass_bt">
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
</html>