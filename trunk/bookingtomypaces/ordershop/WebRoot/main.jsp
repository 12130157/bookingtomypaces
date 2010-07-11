<%@ page language="java"  pageEncoding="utf-8"%>
<%@page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/common.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/core.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/TabPanel.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/Toolbar.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/WindowPanel.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Fader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/TabPanel.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Math.uuid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Toolbar.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/WindowPanel.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Drag.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript">

		
var lastObj;
var tabpanel;
$(document).ready(function(){
//
 var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
					//alert('collapse');
				}
			});
	//setTimeout(function(){
	//			$('body').layout('collapse','east');
	//		},0);
//
 tabpanel = new TabPanel({
		renderTo:'tab',
		autoResizable:true,
		width: '100%',
		height: '100%',
	
		border:'none',
		active : 0,
		maxLength : 10,
		items : [{
			id:'toolbarPlugin',
			title:'歡迎頁',
			//icon:'<%=request.getContextPath()%>/image/read-n.gif',
			html:'<iframe id="callIframe" src="<%=request.getContextPath()%>/welcome.html" width="100%" height="100%" frameborder="0"></iframe>',
			closable: true
		}]
	});
});
function showlinks(obj) {

  if(lastObj){
    if (lastObj.style.display=="none") lastObj.style.display="";else lastObj.style.display="none"
  }
  obj=obj.parentElement.nextSibling
  if (obj.style.display=="none") obj.style.display="";else obj.style.display="none"
  lastObj=obj

}

function addt(name,url){
  tabpanel.addTab({title:name, html:"<iframe src='"+url+"' width='100%' height='100%' frameborder='0'></iframe>"})
}
</script>

	<script>
		
	</script>
<title>BannerShop Integration Platform</title>
</head>

<body>

<body class="easyui-layout">
	<div region="north" border="false" style="overflow:hidden;height:70px;background:#fff;">
			<br/>
			<br/>
			<h2>BannerShop Integration Platform</h2>
		</div>
	<div region="west" split="true" title="菜單" style="width:220px;padding:3px;">
			<table width="200" height="100%" border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td valign="top" class="lefttable"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		        <tr>
		          <td class="leftloginmsgtalbe"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td height="30" class="fontblue"><img src="<%=request.getContextPath()%>/images/leftloginmsgicon.gif" border="0" align="absbottom"> 歡迎您:<span class="fontred"><strong><s:property value="#session.KING_SYSTEM_USER.realName"/></strong></span></td>
		            </tr>
		            <tr>
		              <td height="25" class="fontblue">登錄時間:<s:date name="#session.KING_SYSTEM_USER.lastTime" format="yyyy-MM-dd HH:mm:ss" /> </td>
		            </tr>
		            <tr>
		              <td height="1" background="<%=request.getContextPath()%>/images/leftloginmsgline.gif"></td>
		            </tr>
		            <tr>
		              <td height="28" align="center" valign="bottom"><a href="####" onClick="addt('修改密碼','<%=request.getContextPath()%>/user/key/resetpwd?s='+Math.random())" class="menu2"><img src="<%=request.getContextPath()%>/images/leftloginpwbtn.gif" width="56" height="20"></a>
					  <a href="#" onclick="goURL3('<%=request.getContextPath()%>/logout/key/index')"><img src="<%=request.getContextPath()%>/images/leftloginoutbtn.gif" width="56" height="20"></a></td>
		            </tr>
		          </table></td>
		        </tr>
		      </table></td>
		    </tr>
		    <tr>
		      <td height="100%" valign="top" class="lefttable">
				  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenutable">
					<tr>			
					  <td valign="top">
					  <div style="overflow:auto;width:100%;height:100%;">
					  <table width="100%" border="0" cellspacing="0" cellpadding="0">
					
						
						 <!-- start -->
		      			<s:iterator id="f" value="funList.{?#this.perfunc==0&&#this.id!=45&&#this.id!=52}">
						 <tr>
		                  <td class="leftmenutd" onclick="showlinks(this);"><img src="<%=request.getContextPath()%>/images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;<s:property value='funcname' /></td>
		                </tr>
						<tr style="DISPLAY:none;">
							<td class="leftsubmenutable">
								<table width="150" border="0" cellpadding="0" cellspacing="0">
								 <s:iterator value="funList.{?#this.perfunc==#f.id}">
		           				 <s:if test="url.length()>2">
								    <tr><td height="20">· <a href="####" onClick="addt('<s:property value='funcname' />','<%=request.getContextPath()%>/<s:property value='url' />?s='+Math.random())" class="menu2"><font color=""><s:property value='funcname' /></font></a></td></tr>
								   </s:if>
		            			</s:iterator>
							</table>					
							</td>
						</tr>
						 </s:iterator>
		     			<!-- end -->
		     			<!--
		     			 <tr>
		                  <td class="leftmenutd" onclick="showlinks(this);"><img src="<%=request.getContextPath()%>/images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;订单管理</td>
		                </tr>
						<tr style="DISPLAY:none;">
							<td class="leftsubmenutable">
								<table width="150" border="0" cellpadding="0" cellspacing="0">
							
								  <tr>
									<td height="20">· <a href="order/serviceList.jsp" class="linkblue" target="mainFrame"> 我要下单</a></td>
								  </tr>
								 
								 <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/checkfile_list.action" class="linkblue" target="mainFrame"> 待审订单</a></td>
								  </tr>
								
								   <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/order_item_list1.action?searchValue['orderlist_state']=1" class="linkblue" target="mainFrame"> 制作订单</a></td>
								  </tr>
								 
								   <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/order_item_list2.action?searchValue['orderlist_state']=2" class="linkblue" target="mainFrame"> 工场订单</a></td>
								  </tr>
								
								   <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/order_item_list3.action?searchValue['orderlist_state']=3" class="linkblue" target="mainFrame"> 地下订单</a></td>
								  </tr>
								
								   <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/order_item_list4.action?searchValue['orderlist_state']=4" class="linkblue" target="mainFrame"> 运输订单</a></td>
								  </tr>
						
								    <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/accounts_list.action" class="linkblue" target="mainFrame"> 订单结账</a></td>
								  </tr>
										
								    <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/order_list.action" class="linkblue" target="mainFrame"> 订单查询</a></td>
								  </tr>
								 
								   <tr>
									<td height="20">· <a href="<%=request.getContextPath()%>/cpinfo/del_order.action" class="linkblue" target="mainFrame"> 清除所以测试数据</a></td>
								  </tr>
				
							</table>					
							</td>
						</tr>
						
						-->
						
						
		              </table>
		              </div>
		              </td>              
					</tr>
					
			    </table>
			  </td>
		    </tr>
		  </table>
	</div>
	<div region="south" split="true" style="height:35px;background:#efefef;">
	<div align="center" style="padding-top:5px;">BannerShop 版權所有 @2010</div>
		</div>
	<!--<div region="east" split="true" title="East" style="width:100px;padding:10px;">east region</div>
	-->
	<div  region="center" title="內容">
	<div id="tab" ></div>
	</div>
</body>
</body>
</html>