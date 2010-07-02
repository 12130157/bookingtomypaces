package com.king.tools;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools
{

    public DateTools()
    {
    }

    public static String getdateStr()
    {
        Calendar cal = Calendar.getInstance();
        StringBuffer dateStr = new StringBuffer();
        String year = null;
        String month = null;
        String day = null;
        String hour = null;
        String min = null;
        String sec = null;
        year = Integer.toString(cal.get(1));
        dateStr.append(year).append("-");
        if(9 > cal.get(2))
            month = (new StringBuilder("0")).append(Integer.toString(cal.get(2) + 1)).toString();
        else
            month = Integer.toString(cal.get(2) + 1);
        dateStr.append(month).append("-");
        if(10 > cal.get(5))
            day = (new StringBuilder("0")).append(Integer.toString(cal.get(5))).toString();
        else
            day = Integer.toString(cal.get(5));
        dateStr.append(day).append(" ");
        if(10 > cal.get(11))
            hour = (new StringBuilder("0")).append(Integer.toString(cal.get(11))).toString();
        else
            hour = Integer.toString(cal.get(11));
        dateStr.append(hour).append(":");
        if(10 > cal.get(12))
            min = (new StringBuilder("0")).append(Integer.toString(cal.get(12))).toString();
        else
            min = Integer.toString(cal.get(12));
        dateStr.append(min).append(":");
        if(10 > cal.get(13))
            sec = (new StringBuilder("0")).append(Integer.toString(cal.get(13))).toString();
        else
            sec = Integer.toString(cal.get(13));
        dateStr.append(sec);
        return dateStr.toString();
    }

    public static String dateTodate(String old, String now)
        throws Exception
    {
        StringBuffer sb = new StringBuffer();
        Date t1 = null;
        Date t2 = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        t1 = format.parse(now);
        t2 = format.parse(old);
        long d = (t1.getTime() - t2.getTime()) / 0x5265c00L;
        long h = (t1.getTime() - t2.getTime()) / 0x36ee80L - d * 24L;
        long s = (t1.getTime() - t2.getTime()) / 60000L - d * 24L * 60L - h * 60L;
        sb.append((new StringBuilder(String.valueOf(Math.abs(d)))).append(" \u5929 ").append(Math.abs(h)).append(" \u5C0F\u65F6 ").append(Math.abs(s)).append(" \u5206").toString());
        return sb.toString();
    }

    public static void main(String args[])
        throws Exception
    {
        System.out.println(getdateStr());
    }
}
