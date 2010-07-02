

package com.king.tools;

import java.io.PrintStream;
import java.util.*;

public class ArrayTools
{

    public ArrayTools()
    {
    }

    public static Map iteratorArray(List list)
    {
        Map map = new HashMap();
        Integer len = Integer.valueOf(list.size());
        System.out.println((new StringBuilder("--len ")).append(len).toString());
        Iterator it = list.iterator();
        String str = "";
        for(; it.hasNext(); map.put(str, str))
            str = it.next().toString();

        return map;
    }

    public static String getString()
    {
        return "here";
    }

    public static void main(String args[])
    {
        List l = new ArrayList();
        l.add(Integer.valueOf(1));
        l.add(Integer.valueOf(2));
        l.add(Integer.valueOf(1));
        l.add(Integer.valueOf(3));
        System.out.println(iteratorArray(l));
    }
}
