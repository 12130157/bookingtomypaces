package com.king.tools;

public class PageVo
{

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Integer getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(Integer pageCount)
    {
        this.pageCount = pageCount;
    }

    public PageVo(Integer count, Integer curPage, Integer pageSize)
    {
        init(count, curPage, pageSize);
    }

    public void init(Integer count, Integer curPage, Integer pageSize)
    {
        Integer allPage = Integer.valueOf(0);
        if(count.intValue() > 0)
        {
            if(count.intValue() % pageSize.intValue() == 0)
                allPage = Integer.valueOf(count.intValue() / pageSize.intValue());
            else
                allPage = Integer.valueOf(count.intValue() / pageSize.intValue() + 1);
            if(curPage.intValue() > allPage.intValue())
                curPage = allPage;
            this.count = count;
            first = Integer.valueOf(1);
            last = allPage;
            this.curPage = curPage;
            this.pageSize = pageSize;
            pageCount = allPage;
            if(1 < this.curPage.intValue())
            {
                havePrevious = true;
                previous = Integer.valueOf(curPage.intValue() - 1);
            } else
            {
                havePrevious = false;
            }
            if(pageCount.intValue() != this.curPage.intValue())
            {
                haveNext = true;
                next = Integer.valueOf(curPage.intValue() + 1);
            } else
            {
                haveNext = false;
            }
        } else
        {
            this.count = Integer.valueOf(0);
            first = Integer.valueOf(1);
            last = Integer.valueOf(1);
            this.curPage = Integer.valueOf(1);
            pageCount = Integer.valueOf(0);
            havePrevious = false;
            haveNext = false;
        }
    }

    public Integer getCurPage()
    {
        return curPage;
    }

    public void setCurPage(Integer curPage)
    {
        this.curPage = curPage;
    }

    public Integer getFirst()
    {
        return first;
    }

    public void setFirst(Integer first)
    {
        this.first = first;
    }

    public boolean isHaveNext()
    {
        return haveNext;
    }

    public void setHaveNext(boolean haveNext)
    {
        this.haveNext = haveNext;
    }

    public boolean isHavePrevious()
    {
        return havePrevious;
    }

    public void setHavePrevious(boolean havePrevious)
    {
        this.havePrevious = havePrevious;
    }

    public Integer getLast()
    {
        return last;
    }

    public void setLast(Integer last)
    {
        this.last = last;
    }

    public Integer getNext()
    {
        return next;
    }

    public void setNext(Integer next)
    {
        this.next = next;
    }

    public Integer getPrevious()
    {
        return previous;
    }

    public void setPrevious(Integer previous)
    {
        this.previous = previous;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    private Integer first;
    private Integer previous;
    private Integer next;
    private Integer last;
    private Integer curPage;
    private boolean havePrevious;
    private boolean haveNext;
    private Integer pageCount;
    private Integer pageSize;
    private Integer count;
}
