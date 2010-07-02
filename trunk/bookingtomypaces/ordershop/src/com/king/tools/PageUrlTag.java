package com.king.tools;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

// Referenced classes of package com.tag:
//            PageVo

public class PageUrlTag extends TagSupport
{

    public PageUrlTag()
    {
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Integer getCurPage()
    {
        return curPage;
    }

    public void setCurPage(Integer curPage)
    {
        this.curPage = curPage;
    }

    public Integer getViewNum()
    {
        return viewNum;
    }

    public void setViewNum(Integer viewNum)
    {
        this.viewNum = viewNum;
    }

    public int doStartTag()
    {
        JspWriter out = pageContext.getOut();
        try
        {
            if(count.intValue() > 0)
            {
                StringBuffer str = new StringBuffer();
                StringBuffer numStr = new StringBuffer();
                Integer loop = Integer.valueOf(0);
                Integer curSize = Integer.valueOf(0);
                Integer startSize = Integer.valueOf(0);
                if(pageSize == null)
                    pageSize = Integer.valueOf(10);
                PageVo page = new PageVo(count, curPage, pageSize);
                Integer allPage = page.getPageCount();
                if(viewNum == null)
                    viewNum = Integer.valueOf(5);
                if(curPage.intValue() % viewNum.intValue() == 0)
                    loop = Integer.valueOf(curPage.intValue() / viewNum.intValue());
                else
                    loop = Integer.valueOf(curPage.intValue() / viewNum.intValue() + 1);
                if(viewNum.intValue() * loop.intValue() > allPage.intValue())
                    curSize = allPage;
                else
                    curSize = Integer.valueOf(viewNum.intValue() * loop.intValue());
                startSize = Integer.valueOf(viewNum.intValue() * (loop.intValue() - 1) + 1);
                for(int i = startSize.intValue(); i <= curSize.intValue(); i++)
                    if(i != curPage.intValue())
                        numStr.append((new StringBuilder("<a href=\"")).append(url).append(i).append("\"><font color=\"black\">").append(i).append("</font></a>&nbsp;").toString());
                    else
                        numStr.append((new StringBuilder("<a href=\"")).append(url).append(curPage).append("\"><font color=\"red\">").append(i).append("</font></a>&nbsp;").toString());

                if(loop.intValue() * viewNum.intValue() < allPage.intValue())
                    numStr.append((new StringBuilder("<a href=\"")).append(url).append(viewNum.intValue() * loop.intValue() + 1).append("\"><font color=\"black\">...</font</a>&nbsp;").toString());
                out.print("\u5171"+count.intValue()+"\u689D\u8A18\u9304 ");
                str.append((new StringBuilder("<font color=\"red\">")).append(curPage).append("</font>/").append(allPage).append("&nbsp;&nbsp;").toString());
                str.append((new StringBuilder("<a href=\"")).append(url).append(page.getFirst()).append("\"><font color=\"black\">\u9996 \u9801</font></a>").toString());
                if(page.isHavePrevious())
                    str.append((new StringBuilder("&nbsp;&nbsp;<a href=\"")).append(url).append(page.getPrevious()).append("\"><font color=\"black\">\u4E0A\u4E00\u9801</font></a>&nbsp;&nbsp;").toString());
                str.append(numStr);
                if(page.isHaveNext())
                    str.append((new StringBuilder("&nbsp;&nbsp;<a href=\"")).append(url).append(page.getNext()).append("\"><font color=\"black\">\u4E0B\u4E00\u9801</font></a>").toString());
                str.append((new StringBuilder("&nbsp;&nbsp;<a href=\"")).append(url).append(page.getLast()).append("\"><font color=\"black\">\u672B \u9801</font></a>").toString());
                str.append("&nbsp;&nbsp;\u8DF3\u5230\u7B2C<input type=\"text\" id=\"pg\" name=\"pg\" size=\"1\" />\u9801<input type=\"button\" name=\"button\" value=\"\u78BA\u5B9A\" class=\"buttonshort\" onclick=\"change();\" />");
                str.append("<script>function isRe(regu, str) {var re = new RegExp(regu);if (re.test(str)) {return true;} else {return false;}}");
                str.append("function change(){var pg;var obj=document.getElementsByName(\"pg\");for(var i=0;i<obj.length;i++){var e=obj[i];if(e.value!=\"\"){pg=e.value;}}");
                str.append((new StringBuilder("var regu=/^([+]?)(\\d+)$/;var b=isRe(regu,pg);if(b==true&&pg>0){location.href=\"")).append(url).append("\"+pg;}else{alert(\"\u683C\u5F0F\u932F\u8AA4\uFF0C\u8ACB\u8F38\u5165\u5927\u65BC0\u7684\u6574\u6578\uFF01\");return false;}}</script>").toString());
                str.append("<script>function keyEventForPage(){if(13==event.keyCode){var pg;var obj=document.getElementsByName(\"pg\");for(var i=0;i<obj.length;i++){var e=obj[i];if(e.value!=\"\"){pg=e.value;}}");
                str.append((new StringBuilder("var regu=/^([+]?)(\\d+)$/;var b=isRe(regu,pg);if(b==true&&pg>0){location.href=\"")).append(url).append("\"+pg;}else{alert(\"\u683C\u5F0F\u932F\u8AA4\uFF0C\u8ACB\u8F38\u5165\u5927\u65BC0\u7684\u6574\u6578\uFF01\");event.returnValue=false;}}}</script>").toString());
                str.append("<script>document.getElementById('pg').focus();</script>");
                out.print(str.toString());
            } else
            {
            	//out.print("<div align='center'>\u6682\u65F6\u6CA1\u6709\u76F8\u5173\u8BB0\u5F55! <a href='javascript:history.back(-1);' style='FONT-SIZE: 14px; COLOR: #000099'>\u8FD4\u56DE</a></dive>");
                out.print("<div align='center'>\u66AB\u6642\u6C92\u6709\u76F8\u95DC\u8A18\u9304! </dive>");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("\u6807\u7B7E\u52A0\u8F7D\u9519\u8BEF", e);
        }
        return 6;
    }

    private String url;
    private Integer count;
    private Integer curPage;
    private Integer viewNum;
    private Integer pageSize;
}
