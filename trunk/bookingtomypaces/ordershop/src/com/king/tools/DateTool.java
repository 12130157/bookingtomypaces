/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.tools;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.text.*;
import java.util.Calendar;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.king.common.exception.KINGException;

public class DateTool {

	private DateTool() {
	}

	//public static Date getNow() {
	//	return Calendar.getInstance().getTime();
	//}

	public static String getDate() {
		return getDateTime("yyyy-MM-dd");
	}

	public static String getYM() {
		return getDateTime("yyyy-MM");
	}

	public static String getDateTime() {
		return getDateTime("yyyy-MM-dd HH:mm:ss");
	}

	//获得当前月的上一月
	public static String getLastMonth(String str,String format) throws ParseException{
		SimpleDateFormat df  =  new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		Date date = df.parse(str);
		calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);   
        return df.format(calendar.getTime());
	}
    //	获得当前月的前两个月
	public static String getLastMonth1(String str,String format) throws ParseException{
		SimpleDateFormat df  =  new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(str));   
        calendar.add(Calendar.MONTH,-2);   
        return df.format(calendar.getTime());
	}
	 //	获得当前月的下一个月
	public static String getLastMonth2(String str,String format) throws ParseException{
		SimpleDateFormat df  =  new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(str));   
        calendar.add(Calendar.MONTH,+1);   
        return df.format(calendar.getTime());
	}
	
	// 获得当前日期前一天
	public static String getPreDate() {
		Date cur = Calendar.getInstance().getTime();
		Date pre = new Date(cur.getTime() - 24 * 60 * 60 * 1000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(pre);
	}

	// 获得当前月的第一天
	public static String getFirstDayOfMonth() {
		Calendar c = Calendar.getInstance();
		Calendar calfirst = Calendar.getInstance();
		int now = c.get(c.DAY_OF_MONTH);
		calfirst.add(calfirst.DATE, 1 - now);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(calfirst.getTime());
	}

	public static String getDateTime(String pattern) {
		Date datetime = Calendar.getInstance().getTime();
		return getDateTime(datetime, pattern);
	}

	public static String getDateTime(Date date, String pattern) {
		if (pattern == null || "".equals(pattern))
			pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(1);
	}

	public static int getCurrentMonth() {
		return Calendar.getInstance().get(2) + 1;
	}

	public static int getCurrentDay() {
		return Calendar.getInstance().get(5);
	}

	public static Date addDays(int days) {
		return add(getNow(), days, 5);
	}

	public static Date addDays(Date date, int days) {
		return add(date, days, 5);
	}

	public static Date addMonths(int months) {
		return add(getNow(), months, 2);
	}

	public static Date addMonths(Date date, int months) {
		return add(date, months, 2);
	}

	// 2007-11 to 2007
	public static int getYear(String date) {
		String[] str = date.split("-");
		return Integer.parseInt(str[0]);
	}

	// 2007-11 to 11
	public static String getMonth(String date) {
		String[] str = date.split("-");
		return str[1];
	}

	// 2007-11 to 2007-11-30
	public static String getDay(String date) {
		if (date == null || date.equals("")) {
			return null;
		}
		try {
			String[] str = date.split("-");
			int month = Integer.parseInt(str[1]);
			if (month == 2) {
				return "-28";
			} else if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				return "-31";
			} else {
				return "-30";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 2007-01-01 to 【>=2007-01-01 00:00:00 and <=2007-01-01 23:59:59】
	public static String getDayAll(String date, String flag) {
		if (flag == null || flag.equals(""))
			return null;

		try {
			if (flag.equals("start")) {
				return date + " 00:00:00";
			} else if (flag.equals("end")) {
				return date + " 23:59:59";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取前一年
	 * 
	 * @param curYear
	 * @return
	 */
	public static String getPreYear(String curYear) {
		int curY = Integer.parseInt(curYear);
		int preY = curY - 1;
		return preY + "";
	}

	private static Date add(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	public static long diffDays(Date one, Date two) {
		return (one.getTime() - two.getTime()) / 0x5265c00L;
	}

	public static int diffMonths(Date one, Date two) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(one);
		int yearOne = calendar.get(1);
		int monthOne = calendar.get(2);
		calendar.setTime(two);
		int yearTwo = calendar.get(1);
		int monthTwo = calendar.get(2);
		return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
	}

	public static Date parse(String datestr, String pattern) {
		if (datestr == null || "".equals(datestr))
			return null;
		Date date = null;
		String p = pattern;
		if (pattern == null || "".equals(pattern))
			p = "yyyy-MM-dd";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(p);
			date = dateFormat.parse(datestr);
		} catch (ParseException parseexception) {
		}
		return date;
	}

	public static String format(Date date, String pattern) {
		String p;
		p = pattern;
		if (pattern == null || "".equals(pattern))
			p = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(p);
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static Date getMonthLastDay() {
		return getMonthLastDay(getNow());
	}

	public static Date getMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(1), calendar.get(2) + 1, 1);
		calendar.add(5, -1);
		return calendar.getTime();
	}
	//add by txc for ext,未完成，适用于记录内所有日期字段统一格式
	public static void setDateFormatForData(Object object,String dateFormat){
		Field[] fields = object.getClass().getFields();
		for(int i=0;i<fields.length;i++){
			Field field = fields[i];
			Object o = field.getType();
			if(o instanceof java.util.Date){
				
			}
		}
	}
	//add by txc
	public static String getJSONString(Object object,String dateFormat) throws KINGException{  
        String jsonString = null;  
        //日期值处理器  
        JsonConfig jsonConfig = new JsonConfig();  
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat));  
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(dateFormat)); 
        if(object != null){  
            if(object instanceof Collection || object instanceof Object[]){  
                jsonString = JSONArray.fromObject(object, jsonConfig).toString();  
            }else{  
                jsonString = JSONObject.fromObject(object, jsonConfig).toString();  
                
            }  
        }  
        return jsonString == null ? "{}" : jsonString;  
    }  
	
	//add by txc
	public static JSONObject getJSONObj(Object object,String dateFormat)throws KINGException{
		  
        JSONObject jsonObj = null;  
        //日期值处理器  
        JsonConfig jsonConfig = new JsonConfig();  
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat));  
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(dateFormat)); 
        if(object != null){  
           
        	jsonObj = JSONObject.fromObject(object, jsonConfig);  
            
        }  
        return jsonObj == null ? null : jsonObj;  
    
	}
	//add by txc
	public static JSONArray getJSONArray(Object object,String dateFormat)throws KINGException{
		JSONArray jsonArray = null;
		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat)); 
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(dateFormat));
			if(object != null){
				if(object instanceof Collection || object instanceof Object[]){
					jsonArray = JSONArray.fromObject(object, jsonConfig);
				}
			}else{
				System.out.println("这不是一个列表或数组");
				return null;
			}
			
			return jsonArray;
	}
	//add by txc
	public static JSONObject getGridJSON(List list,int totalRows,String dateFormat)throws KINGException{
		JSONArray array = null;
		if(dateFormat != null && dateFormat.trim().length()>0){
			array = getJSONArray(list, dateFormat);
		}else{
			array = JSONArray.fromObject(list);
		}
		JSONObject obj = new JSONObject();
		obj.put("results", totalRows);
		obj.put("items", array);
		return obj;
	}
	
	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		//ParsePosition pos = new ParsePosition(8);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}
	
	/**
	 * 获取现在时间
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	/**
	 * 提取一个月中的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 3600000 * 34 * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return 字符串 yyyyMMdd HHmmss
	 */
	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return
	 */
	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 */
	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
					* 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006
	 * 
	 * @param str
	 * @return
	 */
	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	/**
	 * 获取一个月的最后一天
	 * 
	 * @param dat
	 * @return
	 */
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 判断二个时间是否在同一个周
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * @return
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 * 
	 * @param sdate
	 * @param num
	 * @return
	 */
	public static String getWeek(String sdate, String num) {
		// 再转换为时间
		Date dd = DateTool.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = DateTool.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = DateTool.getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 此函数返回该日历第一行星期日所在的日期
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getNowMonth(String sdate) {
		// 取该时间所在月的一号
		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几
		Date date = DateTool.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = DateTool.getNextDay(sdate, (1 - u) + "");
		return newday;
	}

	/**
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 * 
	 * @param k
	 *            表示是取几位随机数，可以自己定
	 */

	public static String getNo(int k) {

		return getUserDate("yyyyMMddhhmmss") + getRandom(k);
	}

	/**
	 * 返回一个随机数
	 * 
	 * @param i
	 * @return
	 */
	public static String getRandom(int i) {
		Random jjj = new Random();
		// int suiJiShu = jjj.nextInt(9);
		if (i == 0)
			return "";
		String jj = "";
		for (int k = 0; k < i; k++) {
			jj = jj + jjj.nextInt(9);
		}
		return jj;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			// System.out.print(Integer.valueOf(getTwoDay("2006-11-03 12:22:10",
			// "2006-11-02 11:22:09")));
			DateTool dt =new DateTool();
			System.out.println(dt.getStringDateShort());
			System.out.println(dt.getNextDay(dt.getStringDate(),"1"));
			System.out.println("::"+dt.getTwoDay("2009-08-26","2009-08-28"));
			Date a,b;
			a = new Date();
			String b1=dt.getNextDay(dt.getStringDate(),"1");
			b1=b1+" 00:00:00";
			System.out.println("::"+b1);
			b = strToDateLong(b1);
			System.out.println(b.getTime()/1000 - a.getTime()/1000); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String test = "2003-1-31";
		try {
			Date date = parse(test, "");
			System.out
					.println("\u5F97\u5230\u5F53\u524D\u65E5\u671F \uFF0D getDate():"
							+ getDate());
			System.out
					.println("\u5F97\u5230\u5F53\u524D\u65E5\u671F\u65F6\u95F4 \uFF0D getDateTime():"
							+ getDateTime());
			System.out
					.println("\u5F97\u5230\u5F53\u524D\u5E74\u4EFD \uFF0D getCurrentYear():"
							+ getCurrentYear());
			System.out
					.println("\u5F97\u5230\u5F53\u524D\u6708\u4EFD \uFF0D getCurrentMonth():"
							+ getCurrentMonth());
			System.out
					.println("\u5F97\u5230\u5F53\u524D\u65E5\u5B50 \uFF0D getCurrentDay():"
							+ getCurrentDay());
			System.out.println("\u89E3\u6790 \uFF0D parse(" + test + "):"
					+ getDateTime(date, "yyyy-MM-dd"));
			System.out.println("\u81EA\u589E\u6708\u4EFD \uFF0D addMonths(3):"
					+ getDateTime(addMonths(3), "yyyy-MM-dd"));
			System.out.println("\u589E\u52A0\u6708\u4EFD \uFF0D addMonths("
					+ test + ",3):"
					+ getDateTime(addMonths(date, 3), "yyyy-MM-dd"));
			System.out.println("\u589E\u52A0\u65E5\u671F \uFF0D addDays("
					+ test + ",3):"
					+ getDateTime(addDays(date, 3), "yyyy-MM-dd"));
			System.out.println("\u81EA\u589E\u65E5\u671F \uFF0D addDays(3):"
					+ getDateTime(addDays(3), "yyyy-MM-dd"));
			System.out.println("\u6BD4\u8F83\u65E5\u671F \uFF0D diffDays():"
					+ diffDays(getNow(), date));
			System.out.println("\u6BD4\u8F83\u6708\u4EFD \uFF0D diffMonths():"
					+ diffMonths(getNow(), date));
			System.out.println("\u5F97\u5230" + test
					+ "\u6240\u5728\u6708\u4EFD\u7684\u6700\u540E\u4E00\u5929:"
					+ getDateTime(getMonthLastDay(date), "yyyy-MM-dd"));
			System.out.println(getPreDate());

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final int MAXYEAR = 2030; // 下拉列表年度选项的最大值

	public static final int MINYEAR = 1980; // 下拉列表年度选项的最小值
}
