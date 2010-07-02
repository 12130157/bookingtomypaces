package com.king.tools;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools
{

    public StringTools()
    {
    }

    public static String arrayToString(Object id[])
    {
        String idStr = "";
        if(id != null && id.length != 0)
        {
            for(int i = 0; i < id.length; i++)
                idStr = (new StringBuilder(String.valueOf(idStr))).append(id[i]).append(",").toString();

        }
        if(idStr.length() != 0)
            idStr = idStr.substring(0, idStr.length() - 1);
        else
            idStr = "0";
        return idStr;
    }

    public static String addZero(String source, Integer step)
    {
        int len1 = source.length();
        Integer i = Integer.valueOf(Integer.parseInt(source) + step.intValue());
        String j = Integer.toString(i.intValue());
        int len2 = j.length();
        StringBuffer zero = new StringBuffer("");
        for(int k = 0; k < len1 - len2; k++)
            zero.append("0");

        return (new StringBuilder(String.valueOf(zero.toString()))).append(i).toString();
    }

    public static String getSql(String tableName, String rows[], String values[])
    {
        int len1 = rows.length;
        int len2 = values.length;
        StringBuffer sql1 = new StringBuffer((new StringBuilder("insert into ")).append(tableName).append("(").toString());
        StringBuffer sql2 = new StringBuffer();
        if(len2 > 0)
        {
            String as[];
            int l = (as = rows).length;
            for(int j = 0; j < l; j++)
            {
                String s = as[j];
                sql1.append((new StringBuilder(String.valueOf(s))).append(",").toString());
            }

            String str1 = sql1.toString().substring(0, sql1.toString().length() - 1);
            str1 = str1.concat(")values(");
            for(int i = 0; i < len2; i += len1)
            {
                sql2.append(str1);
                for(int k = 0; k < len1; k++)
                    sql2.append((new StringBuilder(String.valueOf(values[i + k]))).append(",").toString());

                sql2.deleteCharAt(sql2.toString().length() - 1);
                sql2.append(");");
            }

        }
        return sql2.toString();
    }

    public static String toTureAsciiStr(String str)
    {
        StringBuffer sb = new StringBuffer();
        byte bt[] = str.getBytes();
        for(int i = 0; i < bt.length; i++)
            if(bt[i] < 0)
            {
                sb.append((char)(bt[i] & 0x7f));
            } else
            {
                sb.append('\0');
                sb.append((char)bt[i]);
            }

        return sb.toString();
    }

    public static String unToTrueAsciiStr(String str)
    {
        byte bt[] = str.getBytes();
        int l = 0;
        int length = bt.length;
        int j = 0;
        for(int i = 0; i < length; i++)
            if(bt[i] == 0)
                l++;

        byte bt2[] = new byte[length - l];
        for(int i = 0; i < length; i++)
        {
            if(bt[i] == 0)
            {
                i++;
                bt2[j] = bt[i];
            } else
            {
                bt2[j] = (byte)(bt[i] | 0x80);
            }
            j++;
        }

        String tt = new String(bt2);
        return tt;
    }

    public static String enCode(String data)
    {
        String newData = "";
        try
        {
            newData = new String(data.getBytes("ISO8859_1"), "UTF-8");
        }
        catch(Exception exception) { }
        return newData;
    }

    public static boolean isNumeric(String str)
    {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static String inHTML(String str)
    {
        String sTemp = str;
        if(sTemp.equals(""))
            System.exit(0);
        sTemp = sTemp.replaceAll("&", "&amp;");
        sTemp = sTemp.replaceAll("<", "&lt;");
        sTemp = sTemp.replaceAll(">", "&gt;");
        sTemp = sTemp.replaceAll("\"", "&quot;");
        return sTemp;
    }

    public static String outHTML(String str)
    {
        String sTemp = str;
        if(sTemp.equals(""))
            System.exit(0);
        sTemp = sTemp.replaceAll("&amp;", "&");
        sTemp = sTemp.replaceAll("&lt;", "<");
        sTemp = sTemp.replaceAll("&gt;", ">");
        sTemp = sTemp.replaceAll("&quot;", "\"");
        return sTemp;
    }

    public static boolean isSeason()
    {
        boolean b = false;
        HashMap map = new HashMap();
        map.put("1", "1");
        map.put("4", "4");
        map.put("7", "7");
        map.put("10", "10");
        Calendar cal = Calendar.getInstance();
        String month = Integer.toString(cal.get(2) + 1);
        if(map.containsValue(month))
            b = true;
        return b;
    }

    public static void main(String args[])
    {
        Calendar cal = Calendar.getInstance();
        String month = Integer.toString(cal.get(2) + 1);
        System.out.println(isSeason());
    }
}
