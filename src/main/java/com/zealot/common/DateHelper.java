package com.zealot.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author lp
 *日期助手类
 */

public class DateHelper {
	/**
	 * 将日期格式为指定格式的字符串。“yyyy-MM-dd HH:mm:ss:SSS”
	 * 
	 * @param baseDate 
	 * @param strFormat 
	 * @return
	 */
	public static String formatDateTime(Date baseDate,String strFormat){
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(baseDate);
	}
	
	/**
	 * 将字符串型的日期格式化为指定格式的字符串.'yyyy-MM-dd HH:mm:ss:SSS'
	 * @param baseDate
	 * @param strFormat
	 * @return
	 */
	public static String formatDateTime(String baseDate,String strFormat){
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		Date tmpDate = null;
		try{
			tmpDate = df.parse(baseDate);
		}catch(Exception e){
			
		}
		return df.format(tmpDate);
	}
	
	/**
	 * 得到以"yyyy-MM-dd HH:mm:ss"格式的日期字符串
	 * @return
	 */
	public static String getCurrentDateTime(){
		Calendar curDate = Calendar.getInstance();
		return DateHelper.formatDateTime(curDate.getTime(),"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到自定义字符格式的日期字符串
	 * @param strFormat
	 * @return
	 */
	public static String getCurrentDateTime(String strFormat){
		Calendar curDate = Calendar.getInstance();
		return DateHelper.formatDateTime(curDate.getTime(),strFormat);
	}
	
	/**
	 * 得到当前日期
	 * @return
	 */
	public static Date getDateTime(){
		Calendar curDate = Calendar.getInstance();
		return curDate.getTime();
	}
	
	/**
	 * 得到当前日期加减n天后的日期，返回为String (yyyy-MM-dd)
	 * @param n   正表后几天，负表示前几天
	 * @return    以yyyy-MM-dd 格式的字符串
	 */
	public static String nDaysAfterStringDate(int n){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar curDate = Calendar.getInstance();
		curDate.add(Calendar.DAY_OF_MONTH,+n);
		return df.format(curDate.getTime());
	}
	/**
	 * 得到当前日期加减n天后的日期，返回Date
	 * @param n  正表后几天，负表示前几天
	 * @return   
	 */
	public static Date nDaysAfterDate(int n){
		Calendar curDate = Calendar.getInstance();
		curDate.add(Calendar.DAY_OF_MONTH,+n);
		return curDate.getTime();
	}
	
	/**
	 * 给定一个日期型字符串，返回加减n天后的日期型字符串
	 * @param baseDate  字符串型
	 * @param n   正表后几天，负表示前几天
	 * @return
	 */
	public static String nDaysAfterOneDateString(String baseDate,int n){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = null;
		try{
			tmpDate = df.parse(baseDate);
		}catch(Exception e){
			
		}
		long nDay = (tmpDate.getTime() / (24 * 60 * 60 * 1000) +1 + n)*(24*60*60*1000);
		tmpDate.setTime(nDay);
		return df.format(tmpDate);
	}
	
	/**
	 * 给定一个日期，返回加减n天后的日期，返回Date
	 * @param baseDate 日期型
	 * @param n  正表后几天，负表示前几天
	 * @return
	 */
	public static Date nDayAfterOneDate(Date baseDate,int n){
		long nDay = (baseDate.getTime() / (24 * 60 * 60 * 1000) + 1 +n) *(24*60*60*1000);
		baseDate.setTime(nDay);
		return baseDate;
	}
	
	/**
	 * 返回当前日期加减n个月后的日期，返回String(yyyy-MM-dd)
	 * @param n 正表后几月，负表示前几月
	 * @return
	 */
	public static String nMonthAfterDateString(int n){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.MONTH,+n);
		return df.format(rightNow.getTime());
	}
	
	/**
	 * 返回当期日期加减n个月后的日期，返回Date
	 * @param n 正表后几月，负表示前几月
	 * @return
	 */
	public static Date nMonthAfterDate(int n){
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.MONTH, +n);
		return rightNow.getTime();
	}
	
	/**
	 * 给定义日期加减n个月后的日期，返回Date
	 * @param basicDate
	 * @param n 正表后几月，负表示前几月
	 * @return
	 */
	public static Date nMonthsAfterOneDate(Date basicDate, int n) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(basicDate);
		rightNow.add(Calendar.MONTH, +n);
		return rightNow.getTime();
	}
	/**
	 * 给定义日期加减n个月后的日期，返回String(yyyy-MM-dd)
	 * @param basicDate
	 * @param n 正表后几月，负表示前几月
	 * @return
	 */
	public static String nMonthsAfterOneDateString(Date basicDate, int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(basicDate);
		rightNow.add(Calendar.MONTH, +n);
		return df.format(rightNow.getTime());
	}
	
	/**
	 * 计算两个日期间隔天数（secondDate - firstDate）
	 * @param firstDate 为Date型
	 * @param secondDate  为Date型
	 * @return
	 */
	public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay =(int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}
	
	/**
	 * 计算两个日期间隔天数（secondDate - firstDate）
	 * @param firstDate 为String型
	 * @param secondDate  为String型
	 * @return
	 * @throws Exception 
	 */
	public static int nDaysBetweenTwoDate(String firstString, String secondString) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = null;
		Date secondDate = null;
		
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		} catch (Exception e) {
			throw new Exception("日期格式不正确！");
		}
		int nDay =(int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}
	/**
	 * 计算两个日期间隔天数（secondDate - firstDate）
	 * @param firstDate 为String型
	 * @param secondDate  为String型
	 * @return
	 * @throws Exception 
	 */
	public static int nTimeBetweenTwoDate(String firstString, String secondString) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date firstDate = null;
		Date secondDate = null;
		
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		} catch (Exception e) {
			throw new Exception("日期格式不正确！");
		}
		int nDay =(int) ((secondDate.getTime() - firstDate.getTime()) /1000);
		return nDay;
	}
	/**
	 * 得到指定日期是星期几
	 * @param baseDate 字串型的日期格式
	 * @return
	 */
	public static int getWeekDateString(String baseDate){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date rightNow = null;
		try {
			rightNow = df.parse(baseDate);
		} catch (ParseException e) {
		}
		c.setTime(rightNow);
		return c.get(Calendar.DAY_OF_WEEK) -1;
	}
	/**
	 * 得到指定日期是星期几
	 * @param baseDate 日期型日期格式
	 * @return
	 */
	public static int getWeekDate(Date baseDate){
		Calendar c = Calendar.getInstance();
		c.setTime(baseDate);
		return c.get(Calendar.DAY_OF_WEEK) -1;
	}
	
	
	/**
	 * setLocalDate方法慨述:修改本地时间
	 * 创 建  人：梁平
	 * 创建时间：2009-3-26 下午10:38:44
	 * 修 改  人：(修改了该文件，请填上修改人的名字)
	 * 修改日期：(请填上修改该文件时的日期)
	 * @param dateTime 字符型的时间格式 yyyy-MM-dd HH:mm:ss
	 * @throws  Exception
	 */
	public static void setLocalDate(Date newDate) throws Exception{
		String dateTime = DateHelper.formatDateTime(newDate, "yyyy-MM-dd HH:mm:ss");
		//判断传入的日期格式是否正确
		if(dateTime.length() != 19){
			throw new Exception("日期格式不正确!");
		}
		String osName = System.getProperty("os.name");   
		String cmd = "";   
		//如果系统为Windows
		if (osName.matches("^(?i)Windows.*$")){
			// 格式：yyyy-MM-dd  
			String date = dateTime.substring(0, 10); 
		    cmd = " cmd /c date "+date;   
		    Runtime.getRuntime().exec(cmd);  
		    // 格式 HH:mm:ss   
		    String time = dateTime.substring(11);
		    cmd = "  cmd /c time "+time;   
		    Runtime.getRuntime().exec(cmd);  
		}else{ // Linux 系统   
			dateTime = DateHelper.formatDateTime(dateTime, "yyyyMMdd HH:mm:ss");
			// 格式：yyyyMMdd
			String year = dateTime.substring(0,4);
			String month = dateTime.substring(5,7);
			String day = dateTime.substring(8,10);
			String date = year+month+day;
			cmd = "  date -s "+date;   
			Runtime.getRuntime().exec(cmd);   
			// 格式 HH:mm:ss
			String time = dateTime.substring(9);
			cmd = "  date -s "+time;
			Runtime.getRuntime().exec(cmd); 
		}
	}
	
	/**
	 * setLocalDate方法慨述:调用kernerl32.dll文件设置系统时间
	 * 创 建  人：梁平
	 * 创建时间：2011-8-3 上午10:15:24
	 * 修 改  人：(修改了该文件，请填上修改人的名字)
	 * 修改日期：(请填上修改该文件时的日期)
	 * @param date void 
	 * @throws
	 */
/*	public static void setLocalDate(String dateTime) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tmpDate = null;
		try{
			tmpDate = df.parse(dateTime);
			JNative jNative = NativeFactory.newNative();
			jNative.setLocalTime(tmpDate);
		}catch(Exception e){
			throw e;
		}
	}*/
	/**
	 * getMonthOfTheFirstDay方法慨述: 得到当前月的第一天
	 * 创 建  人：梁平
	 * 创建时间：2011-5-19 上午10:20:18
	 * 修 改  人：(修改了该文件，请填上修改人的名字)
	 * 修改日期：(请填上修改该文件时的日期) 
	 * @return String 当前月第一天 
	 * @throws
	 */
	public static String getMonthOfTheFirstDay(){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	   return df.format(calendar.getTime());  
	}
	
	/**
	 * getMonthOfTheFirstDay方法慨述: 得到当前月的第一天
	 * 创 建  人：梁平
	 * 创建时间：2011-5-22 下午05:05:54
	 * 修 改  人：(修改了该文件，请填上修改人的名字)
	 * 修改日期：(请填上修改该文件时的日期)
	 * @param format 时间格式
	 * @return String  时间
	 * @throws
	 */
	public static String getMonthOfTheFirstDay(String format){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format);
	   return df.format(calendar.getTime());
	}
	
	/**
	 * getMonthOfTheLastDay方法慨述: 得到当前月最后一天
	 * 创 建  人：梁平
	 * 创建时间：2011-5-19 上午10:31:56
	 * 修 改  人：(修改了该文件，请填上修改人的名字)
	 * 修改日期：(请填上修改该文件时的日期)
	 * @return String 当前月最后一天
	 * @throws
	 */
	public static String getMonthOfTheLastDay(){
		Calendar calendar = Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));   
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	   return df.format(calendar.getTime()); 
	}
	/**
	 * getDate方法慨述:判断年、月、天数
	 * 创 建  人：梁平
	 * 创建时间：2011-5-13 上午09:17:25
	 * 修 改  人：梁平
	 * 修改日期：2011-5-13 上午09:17:25
	 * @param date
	 * @return Integer 
	 * @throws
	 */
	public static Integer getDate(String date){
		String year = date.split("-")[0];
		String month = date.split("-")[1];
		int year1 = (Integer.valueOf(year) - 4) % 12;
		   //定义变量，存储该月多少天
		   int daysOfMonth = 0;
		   //计算该月多少天
		   switch (Integer.valueOf(month)) {
		   case 1:
		   case 3:
		   case 5:
		   case 7:
		   case 8:
		   case 10:
		   case 12:
			   daysOfMonth=31;
		    return daysOfMonth;
		   case 2:
		    if (year1 % 400 == 0 || (year1 % 4 == 0 && year1 % 100 != 0)) {
		     
		     daysOfMonth = 29;
		     return daysOfMonth;
		     
		    } else {
		     daysOfMonth = 28;
		     return daysOfMonth;
		    }
		   default:
		    daysOfMonth = 30;
		    return daysOfMonth;
		   }
	}
	/**
	 * zhdateKeyUp方法慨述:日期文本按上键执行方法
	 * 创 建  人：梁平
	 * 创建时间：2011-5-15 上午02:24:04
	 * 修 改  人：梁平
	 * 修改日期：2011-5-15 上午02:24:04 void 
	 * @throws
	 */
	public static String zhdateKeyUp(String date){
		String[] hzdate = date.split("-");
		Integer day = getDate(date);
		if(Integer.valueOf(hzdate[2])+1>day){
			hzdate[1]=(Integer.valueOf(hzdate[1])+1)+"";
			if(Integer.valueOf(hzdate[1])+1<=10){
				hzdate[1]="0"+hzdate[1];
			}
			if(Integer.valueOf(hzdate[1])>12){
				hzdate[0]=(Integer.valueOf(hzdate[0])+1)+"";
				hzdate[1]="01";
			}
			hzdate[2]="01";
		}else{
			if(Integer.valueOf(hzdate[2])+1<10){
				hzdate[2]="0"+(Integer.valueOf(hzdate[2])+1);
			}else{
				hzdate[2]=(Integer.valueOf(hzdate[2])+1)+"";
			}
			
		}
		return hzdate[0]+"-"+hzdate[1]+"-"+hzdate[2];
	}
	/**
	 * zhdateKeyDowm方法慨述:日期文本按下键执行方法
	 * 创 建  人：梁平
	 * 创建时间：2011-5-15 上午02:24:33
	 * 修 改  人：梁平
	 * 修改日期：2011-5-15 上午02:24:33 void 
	 * @throws
	 */
	public static String zhdateKeyDowm(String date,boolean isTure){
		String[] hzdate = date.split("-");
		Integer thisDay = Integer.valueOf(DateHelper.formatDateTime(new Date(),"dd"));
		if(isTure==true){
			if(Integer.valueOf(hzdate[2])-1>=thisDay){
				hzdate = getDay(hzdate);
			}
		}else{
			hzdate = getDay(hzdate);
		}
		return hzdate[0]+"-"+hzdate[1]+"-"+hzdate[2];
	}
	/**
	 * getDay方法慨述:计算日期
	 * 创 建  人：梁平
	 * 创建时间：2011-5-27 下午05:19:51
	 * 修 改  人：梁平
	 * 修改日期：2011-5-27 下午05:19:51
	 * @param hzdate
	 * @return String[] 
	 * @throws
	 */
	public static String[] getDay(String[] hzdate){
		if(Integer.valueOf(hzdate[2])-1<=0){
			hzdate[1]=(Integer.valueOf(hzdate[1])-1)+"";
			if(Integer.valueOf(hzdate[1])<10){
				hzdate[1]="0"+hzdate[1];
			}
			if(Integer.valueOf(hzdate[1])<=0){
				hzdate[0]=(Integer.valueOf(hzdate[0])-1)+"";
				hzdate[1]="12";
			}
			Integer day = getDate(hzdate[0]+"-"+hzdate[1]);
			hzdate[2]=day+"";
		}else{
			if(Integer.valueOf(hzdate[2])-1<10){
				hzdate[2]="0"+(Integer.valueOf(hzdate[2])-1);
			}else{
				hzdate[2]=(Integer.valueOf(hzdate[2])-1)+"";
			}
		}
		return hzdate;
	}
	
	/**
	 * minuteInterval方法慨述:得到指定格式两个时间的间隔分钟数(date2 - date1)
	 * 创 建  人：梁平
	 * 创建时间：2011-8-10 下午02:45:23
	 * 修 改  人：(修改了该文件，请填上修改人的名字)
	 * 修改日期：(请填上修改该文件时的日期)
	 * @param strFormat 格式"yyyy-MM-dd HH:mm:ss"
	 * @param date1  时间"HH:mm"
	 * @param date2 时间"HH:mm"
	 * @return long 返回间隔分钟数
	 * @throws
	 */
	public static long minuteInterval(String strFormat,String date1,String date2){
		SimpleDateFormat dfs = new SimpleDateFormat(strFormat);
		long between = 0;
		try {
			java.util.Date begin=dfs.parse(date1);
			java.util.Date end = dfs.parse(date2);
			between=(end.getTime()- begin.getTime())/1000/60; //除以1000是为了转换成秒,除以60转换为分
		} catch (ParseException e) {
		}
		return between;
	}
}
