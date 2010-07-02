package com.king.tools;

import java.text.DecimalFormat;

public class RmbTools
{

    public RmbTools()
    {
    }

    public static String ChineseNumber(String doubleStr)
    {
        float f = Float.parseFloat(doubleStr);
        if(f > 0.0F)
        {
            StringBuffer bf = new StringBuffer();
            StringBuffer bf1 = new StringBuffer();
            StringBuffer bf2 = new StringBuffer();
            StringBuffer bf3 = new StringBuffer();
            int len1 = doubleStr.length();
            int len2 = doubleStr.indexOf(".");
            String str1 = doubleStr.substring(0, len2);
            String str2 = doubleStr.substring(len2 + 1);
            int len7 = str1.length();
            if(len2 > 5)
            {
                int len8 = len7 - 5;
                int len10 = 0;
                if(len8 > 3)
                    len10 = 3;
                else
                    len10 = len8;
                String str6 = str1.substring(0, len10);
                for(int y = 0; y < len10; y++)
                {
                    Integer u = Integer.valueOf(Integer.parseInt(String.valueOf(str6.charAt(y))));
                    if(basicNum[0] != basicNum[u.intValue()])
                        bf3.append((new StringBuilder(String.valueOf(basicNum[u.intValue()]))).append(bigNum[len10 - y]).toString());
                    else
                        bf3.append(basicNum[u.intValue()]);
                }

            }
            String str7 = bf3.toString();
            int len6 = 0;
            if(len2 > 5)
                len6 = 5;
            else
                len6 = len2;
            String str11 = str1.substring(len7 - len6, len7);
            for(int i = 0; i < len6; i++)
            {
                Integer j = Integer.valueOf(Integer.parseInt(String.valueOf(str11.charAt(i))));
                if(basicNum[0] != basicNum[j.intValue()])
                    bf1.append((new StringBuilder(String.valueOf(basicNum[j.intValue()]))).append(bigNum[len6 - i - 1]).toString());
                else
                    bf1.append(basicNum[j.intValue()]);
            }

            String str3 = bf1.toString();
            int len4 = str3.length();
            int o = 0;
            for(int k = 0; k < len4; k++)
            {
                int sign1 = String.valueOf(str3.charAt(len4 - k - 1)).lastIndexOf("\u96F6");
                if(sign1 == -1)
                    break;
                o++;
            }

            String str4 = str3.substring(0, len4 - o);
            bf2.append("\u96F6");
            int len5 = len1 - len2 - 1;
            for(int l = 0; l < len5; l++)
            {
                Integer h = Integer.valueOf(Integer.parseInt(String.valueOf(str2.charAt(l))));
                bf2.append(basicNum[h.intValue()]);
            }

            String str5 = bf2.toString();
            bf.append(str7).append(str4).append(str5);
            String str13 = bf.toString();
            int len13 = str13.length();
            int b = 0;
            for(int t = 0; t < len13; t++)
            {
                int sign2 = String.valueOf(str13.charAt(len13 - t - 1)).lastIndexOf("\u96F6");
                if(sign2 == -1)
                    break;
                b++;
            }

            String str18 = str13.substring(0, len13 - b);
            return (new StringBuilder(String.valueOf(str18))).append("\u5143\u6574").toString();
        } else
        {
            return "\u96F6\u5143\u6574";
        }
    }

    public static String rmbFormat(String doubleStr)
    {
        Double d = Double.valueOf(Double.parseDouble(doubleStr));
        DecimalFormat fmt = new DecimalFormat("##,###,###,###,##0.00");
        return fmt.format(d);
    }

    public static void main(String args1[])
    {
    }

    private static final String basicNum[] = {
        "\u96F6", "\u58F9", "\u8D30", "\u53C1", "\u8086", "\u4F0D", "\u9646", "\u67D2", "\u62D0", "\u7396"
    };
    private static final String bigNum[] = {
        "", "\u62FE", "\u4F70", "\u4EDF", "\u842C"
    };

}
