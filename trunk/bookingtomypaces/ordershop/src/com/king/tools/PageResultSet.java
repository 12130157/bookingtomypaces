package com.king.tools;

import java.util.*; 

public class PageResultSet { 
/** 
* 分页数据 
*/ 
private Collection data = null; 

/** 
* 当前页 
*/ 
private int curPage; 

/** 
* 每页显示的记录数 
*/ 
private int pageSize; 

/** 
* 记录行数 
*/ 
private int rowsCount; 

/** 
* 页数 
*/ 
private int pageCount; 

public PageResultSet(Collection data) { 
this.data = data; 
this.curPage = 1; 
this.pageSize = 10; 
this.rowsCount = data.size(); 
this.pageCount = (int) Math.ceil((double) rowsCount / pageSize); 
} 

public PageResultSet(Collection data, int curPage) { 
this.data = data; 
this.curPage = curPage; 
this.pageSize = 10; 
this.rowsCount = data.size(); 
this.pageCount = (int) Math.ceil((double) rowsCount / pageSize); 
} 

public PageResultSet(Collection data, int curPage, int pageSize) { 
this.data = data; 
this.curPage = curPage; 
this.pageSize = pageSize; 
this.rowsCount = data.size(); 
this.pageCount = (int) Math.ceil((double) rowsCount / pageSize); 
} 

/** 
* getCurPage:返回当前的页数 
* 
* @return int 
*/ 
public int getCurPage() { 
return curPage; 
} 

/** 
* getPageSize：返回分页大小 
* 
* @return int 
*/ 
public int getPageSize() { 
return pageSize; 
} 

/** 
* getRowsCount：返回总记录行数 
* 
* @return int 
*/ 
public int getRowsCount() { 
return rowsCount; 
} 

/** 
* getPageCount：返回总页数 
* 
* @return int 
*/ 
public int getPageCount() { 
return pageCount; 
} 

/** 
* 第一页 
* 
* @return int 
*/ 
public int first() { 
return 1; 
} 

/** 
* 最后一页 
* 
* @return int 
*/ 
public int last() { 
return pageCount; 
} 

/** 
* 上一页 
* 
* @return int 
*/ 
public int previous() { 
return (curPage - 1 < 1) ? 1 : curPage - 1; 
} 

/** 
* 下一页 
* 
* @return int 
*/ 
public int next() { 
return (curPage + 1 > pageCount) ? pageCount : curPage + 1; 
} 

/** 
* 第一页 
* 
* @return boolean 
*/ 
public boolean isFirst() { 
return (curPage == 1) ? true : false; 
} 

/** 
* 最后一页 
* 
* @return boolean 
*/ 
public boolean isLast() { 
return (curPage == pageCount) ? true : false; 
} 

/** 

* 获取当前页数据 
* 
* @return Collection 
*/ 
public Collection getData() { 
Collection curData = null; 
if (data != null) { 
int start = (curPage - 1) * pageSize; 
int end = 0; 
if (start + pageSize > rowsCount) 
end = rowsCount; 
else 
end = start + pageSize; 
ArrayList arrayCurData = new ArrayList(); 
ArrayList arrayData = null; 
Vector vectorCurData = new Vector(); 
Vector vectorData = null; 
boolean isArray = true; 
if (data instanceof ArrayList) { 
arrayData = (ArrayList) data; 
isArray = true; 
} else if (data instanceof Vector) { 
vectorData = (Vector) data; 
isArray = false; 
} 
for (int i = start; i < end; i++) { 
if (isArray) { 
arrayCurData.add(arrayData.get(i)); 
} else { 
vectorData.add(vectorData.elementAt(i)); 
} 
} 
if (isArray) { 
curData = (Collection) arrayCurData; 
} else { 
curData = (Collection) vectorCurData; 
} 
} 
return curData; 
} 

/** 
* 获取工具条 
* 
* @return String 
*/ 
public String getToolBar(String fileName) { 
String temp = ""; 
if (fileName.indexOf("?") == -1) { 
temp = "?"; 
} else { 
temp = "&"; 
} 
String str = "<form method='post' name='frmPage' action='" + fileName + "'>"; 
str += "<p align='center'>"; 
if (isFirst()) 
str += "首页 上一页 "; 
else { 
str += "<a href='" + fileName + temp + "cur_page=1'>首页</a> "; 
str += "<a href='" + fileName + temp + "cur_page=" + (curPage - 1) + "'>上一页</a> "; 
} 

if (isLast()) 
str += "下一页 尾页 "; 
else { 
str += "<a href='" + fileName + temp + "cur_page=" + (curPage + 1) + "'>下一页</a> "; 
str += "<a href='" + fileName + temp + "cur_page=" + pageCount + "'>尾页</a> "; 
} 
str += " 共<b>" + rowsCount + "</b>条记录 "; 
str += " 转到<select name='page' onChange=\"location='" + fileName 
+ temp + "cur_page='+this.options[this.selectedIndex].value\">"; 
for (int i = 1; i <= pageCount; i++) { 
if (i == curPage) 
str += "<option value='" + i + "' selected>第" + i + "页</option>"; 
else 
str += "<option value='" + i + "'>第" + i + "页</option>"; 
} 
str += "</select></p></form>"; 
return str; 
} 


} 

