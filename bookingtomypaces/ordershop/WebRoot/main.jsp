<%@ page language="java"  pageEncoding="utf-8"%>
<%@page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		var lastObj
		function showlinks(obj) {	
		  if(lastObj){
		    if (lastObj.style.display=="none") lastObj.style.display="";else lastObj.style.display="none"
		  }
		  obj=obj.parentElement.nextSibling
		  if (obj.style.display=="none") obj.style.display="";else obj.style.display="none"
		  lastObj=obj
		
		}
	</script>
	<script>
		$(function(){
			var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
					//alert('collapse');
				}
			});
			//setTimeout(function(){
			//	$('body').layout('collapse','east');
			//},0);
		});

		function addTab(title, href){  
			var tt = $('#main-center');   
			if (tt.tabs('exists', title)){   
				tt.tabs('select', title);   
				if (href){   
					var content = '<iframe scrolling="auto" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';   
				} else {   
					var content = '未实现';   
					}   
				var tab = $('#main-center').tabs('getSelected');
					$('#main-center').tabs('update', {
					tab: tab,
					options:{
						title:title,
						//iconCls:'icon-save',
						closable:true,
						content:content  
						}
				});
			
			} else {   
				if (href){   
					var content = '<iframe scrolling="auto" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';   
				} else {   
					var content = '未实现';   
				}   
				tt.tabs('add',{   
				title:title,   
				closable:true,   
				content:content   
				});   
			}   
		}  
	</script>
<title>BannerShop Integration Platform</title>
</head>

<body>

<body class="easyui-layout">
	<div region="north" border="false" style="overflow:hidden;height:70px;">
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
		              <td height="28" align="center" valign="bottom"><a href="####" onClick="addTab('修改密碼','<%=request.getContextPath()%>/user/key/resetpwd?s='+Math.random())" class="menu2"><img src="<%=request.getContextPath()%>/images/leftloginpwbtn.gif" width="56" height="20"></a>
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
								    <tr><td height="20">· <a href="####" onClick="addTab('<s:property value='funcname' />','<%=request.getContextPath()%>/<s:property value='url' />?s='+Math.random())" class="menu2"><font color=""><s:property value='funcname' /></font></a></td></tr>
								   </s:if>
		            			</s:iterator>
							</table>					
							</td>
						</tr>
						 </s:iterator>
		     			<!-- end -->				
						
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
	<div  region="center" >
		<div id="main-center" class="easyui-tabs" fit="true" border="false">
          <div title="首页" style="padding:20px;" cache="false" href="<%=request.getContextPath()%>/welcome.jsp"></div>
         </div>
	</div>
</body>
</body>
</html>