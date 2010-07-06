<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ page import="com.opensymphony.xwork2.interceptor.ExceptionHolder" %>
<%
  //此页面要获取例外详细信息，可如何能够获取exception信息呢？
  com.opensymphony.xwork2.ognl.OgnlValueStack  stack = (com.opensymphony.xwork2.ognl.OgnlValueStack)request.getAttribute("struts.valueStack");
  ExceptionHolder holder= (ExceptionHolder)stack.pop();
  Exception ex = holder.getException();
  String exStack=holder.getExceptionStack();
  String errorName ="未知系统异常";
  String exMessage;
  
  if(ex instanceof com.king.common.exception.KINGException){
	  //系统已知的例外
	  com.king.common.exception.KINGException vwpEx =(com.king.common.exception.KINGException)ex;
	  //exMessage =vwpEx.getMessage(); 
	  //errorName = vwpEx.getErrorName();
  }else{
	  exMessage = ex.getMessage();
  }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Refresh" content="3;URL=exceptions" />
<title><%//=errorName%></title>
</head>
<body>
<center><b>頁面不存在！3秒後自動跳轉</b></center>
<center><%//=errorName%></center>
<%//=exMessage%>
<%//=exStack%>
</body>
</html>