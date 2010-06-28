<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<title>BannerShop Integration Platform</title>
</head>
<frameset rows="88,*,27" cols="*" frameborder="NO" border="0" framespacing="0">
		<frame src="<%=request.getContextPath()%>/top.html" name="topFrame" scrolling="NO" noresize>
		<frameset cols="200,7,*" frameborder="NO" border="0" framespacing="0"  id="contentFrameset">>
			<frame src="menu"  name="leftFrame" scrolling="no" noresize>
			<frame src="<%=request.getContextPath()%>/resize.html" name="resizeFrame" id="resizeFrame" scrolling="no" noresize="noresize"   />
			<frame src="<%=request.getContextPath()%>/welcome.html" name="mainFrame" scrolling="yes" noresize>
		</frameset>
		<frame src="<%=request.getContextPath()%>/foot.html" name="footFrame" scrolling="NO" noresize>
</frameset>
<noframes></noframes>
</html>
