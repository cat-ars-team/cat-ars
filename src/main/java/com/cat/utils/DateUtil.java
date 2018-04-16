package com.cat.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * <p>zhucz</p>
 *	时间工具类
 */
public class DateUtil {

	
	private static Logger logger = Logger.getLogger(DateUtil.class);
	/** DEFAULT_DATE_FORMAT Stirng型日期默认格式 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/** DATE_FORMAT 以MM/dd/yyyy格式 格式化日期*/
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	/** DATE_FORMATY 以yyyy/MM/dd格式 格式化日期*/
	public static final String DATE_FORMATY = "yyyy/MM/dd";
	/** DATE_TIME_FORMAT 以MM/dd/yyyy HH:mm格式 格式化日期*/
	public static final String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm";
	/** ORA_DATE_FORMAT 以yyyyMMdd格式 格式化日期*/
	public static final String ORA_DATE_FORMAT = "yyyyMMdd";
	/** ORA_DATE_FORMAT_SIMPLE 以yyMMdd格式 格式化日期*/
	public static final String ORA_DATE_FORMAT_SIMPLE = "yyMMdd";
	/** ORA_DATE_TIME_FORMAT 以yyyyMMddHHmm格式 格式化日期*/
	public static final String ORA_DATE_TIME_FORMAT = "yyyyMMddHHmm";
	/** ORA_DATE_TIMES_FORMAT 以yyyy-MM-dd HH:mm:ss.SSS格式 格式化日期*/
	public static final String ORA_DATE_TIMES_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	/** TIMESTAMP_FORMAT 以yyyyMMddHHmmssSSS格式 格式化日期*/
	public static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmssSSS";
	/** ORA_DATES_FORMAT 以yyyy-MM-dd格式 格式化日期*/
	public static final String ORA_DATES_FORMAT = "yyyy-MM-dd";
	/** ORA_DATE_SIMPLE_TIMES_FORMAT 以yyyy-MM-dd HH:mm:ss格式 格式化日期*/
	public static final String ORA_DATE_SIMPLE_TIMES_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** dayArray 一年中每月的天数*/
	private static final int dayArray[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	private DateUtil(){
	}

	/**
	 * 返回时间字符串(yyyy-MM-dd)
	 * @param pattern 日期模版
	 */
	public static String getDateToString(String pattern) {
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("".equals(pattern) ? DateUtil.DEFAULT_DATE_FORMAT : pattern);
		String dateString = formatter.format(currentDate);
		return dateString;
	}
	
	public static Date StringToDate(String dateString){
		SimpleDateFormat df = new SimpleDateFormat();
		Date date = null;
		try{
			date = df.parse(dateString);
		}catch (Exception e){
			logger.error("DateUtils.StringToDate error!");
			e.printStackTrace();
			throw new RuntimeException("日期转换异常。");
		}
		return date;
	}
	
	/**
	 * 传入指定模板格式日期,转化为标准日期格式[yyyy-MM-dd]
	 * @param dateStr 日期字符串,如[14/06/2013]
	 * @param pattern 模板格式,如[dd/MM/yyyy]
	 * @return yyyy-MM-dd型字符串日期
	 */
	public static String getStrDateChange(String dateStr, String pattern){
		SimpleDateFormat in = new SimpleDateFormat("".equals(pattern) ? DateUtil.DEFAULT_DATE_FORMAT : pattern);
		SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "";
		try {
			dateString = out.format(in.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 类型转换日期
	 * @param dateString 日期格式
	 * @param partten 格式模板(如：yyyy-MM-dd)
	 * @return StringToDate 类型转换后的日期
	 */
	public static Date StringToDate(String dateString, String partten){
		SimpleDateFormat df = new SimpleDateFormat(partten);
		Date date = null;
		try{
			date = df.parse(dateString);
		}catch (Exception e){
			logger.error("DateUtils.StringToDate error!");
			e.printStackTrace();
			throw new RuntimeException("日期转换异常");
		}
		return date;
	}

	/**
	 * 日期类型转换成字符型
	 * @param date Date类型的给定日期
	 * @param partten 格式模板(如：yyyy-MM-dd)
	 * @return 类型转换后的字符型日期
	 */
	public static String toString(Date date, String partten){
		if(date == null){
			return "";
		}else{
			SimpleDateFormat df = new SimpleDateFormat(partten);
			return df.format(date);
		}
	}

	/**
	 * 给定字符串日期按模板转换成Calendar类型
	 * @param dateString 字符串形式的给定日期
	 * @param partten 格式模板(如：yyyy-MM-dd)
	 * @return 类型转换后的Calendar对象
	 */
	public static Calendar parseCalendarFormat(String dateString, String pattern){
		SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		Calendar cal = null;
		simpledateformat.applyPattern(pattern);
		try{
			simpledateformat.parse(dateString);
			cal = simpledateformat.getCalendar();
		}catch (Exception e){
			logger.error("DateUtils.parseCalendarFormat error!");
			e.printStackTrace();
		}
		return cal;
	}

	/**
	 * Calendar类型转换成字符型
	 * @param cal Calendar日期类型
	 * @param partten 格式模板(如：yyyy-MM-dd)
	 * @return 类型转换后的字符型日期
	 */
	public static String getDateMilliFormat(Calendar cal, String pattern){
		return toString(cal.getTime(), pattern);
	}

	/**
	 * 取得Calendar实例
	 * @return Calendar类型实例
	 */
	public static Calendar getCalendar(){
		return Calendar.getInstance();
	}

	/**
	 * 取得当前年的某一个月的最后一天
	 * @param month 数字类型的月份值
	 * @return 参数月份的最后一天
	 */
	public static int getLastDayOfMonth(int month){
		if(month < 1 || month > 12){
			return -1;
		}
		int retn = 0;
		if(month == 2){
			if(isLeapYear()){
				retn = 29;
			}else{
				retn = dayArray[month - 1];
			}
		}else{
			retn = dayArray[month - 1];
		}
		return retn;
	}

	/**
	 * 取得当某年的某一个月的最后一天
	 * @param year 数字类型的年份值
	 * @param month 数字类型的月份值
	 * @return 参数月份的最后一天
	 */
	public static int getLastDayOfMonth(int year, int month){
		if(month < 1 || month > 12){
			return -1;
		}
		int retn = 0;
		if(month == 2){
			if(isLeapYear(year)){
				retn = 29;
			}else{
				retn = dayArray[month - 1];
			}
		}else{
			retn = dayArray[month - 1];
		}
		return retn;
	}

	/**
	 * 取得某日期所在月的最后一天
	 * @param date Date类型的某日期
	 * @return 最后一天的日期型结果
	 */
	public static Date getLastDayOfMonth(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch(gc.get(2)){
			case 0: // '\0'
				gc.set(5, 31);
				break;
			case 1: // '\001'
				gc.set(5, 28);
				break;
			case 2: // '\002'
				gc.set(5, 31);
				break;
			case 3: // '\003'
				gc.set(5, 30);
				break;
			case 4: // '\004'
				gc.set(5, 31);
				break;
			case 5: // '\005'
				gc.set(5, 30);
				break;
			case 6: // '\006'
				gc.set(5, 31);
				break;
			case 7: // '\007'
				gc.set(5, 31);
				break;
			case 8: // '\b'
				gc.set(5, 30);
				break;
			case 9: // '\t'
				gc.set(5, 31);
				break;
			case 10: // '\n'
				gc.set(5, 30);
				break;
			case 11: // '\013'
				gc.set(5, 31);
				break;
		}
		if(gc.get(2) == 1 && isLeapYear(gc.get(1))){
			gc.set(5, 29);
		}
		return gc.getTime();
	}

	/**
	 * 取得某日期所在月的最后一天
	 * @param date Calendar类型的某日期
	 * @return 最后一天的日期型结果
	 */
	public static Calendar getLastDayOfMonth(Calendar gc){
		switch(gc.get(2)){
			case 0: // '\0'
				gc.set(5, 31);
				break;
			case 1: // '\001'
				gc.set(5, 28);
				break;
			case 2: // '\002'
				gc.set(5, 31);
				break;
			case 3: // '\003'
				gc.set(5, 30);
				break;
			case 4: // '\004'
				gc.set(5, 31);
				break;
			case 5: // '\005'
				gc.set(5, 30);
				break;
			case 6: // '\006'
				gc.set(5, 31);
				break;
			case 7: // '\007'
				gc.set(5, 31);
				break;
			case 8: // '\b'
				gc.set(5, 30);
				break;
			case 9: // '\t'
				gc.set(5, 31);
				break;
			case 10: // '\n'
				gc.set(5, 30);
				break;
			case 11: // '\013'
				gc.set(5, 31);
				break;
		}
		if(gc.get(2) == 1 && isLeapYear(gc.get(1))){
			gc.set(5, 29);
		}
		return gc;
	}

	/**
	 * 取得某日期所在周的最后一天
	 * @param date Date类型日期参数
	 * @return 所在周的最后一天日期
	 */
	public static Date getLastDayOfWeek(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch(gc.get(7)){
			case 1: // '\001'
				gc.add(5, 6);
				break;
			case 2: // '\002'
				gc.add(5, 5);
				break;
			case 3: // '\003'
				gc.add(5, 4);
				break;
			case 4: // '\004'
				gc.add(5, 3);
				break;
			case 5: // '\005'
				gc.add(5, 2);
				break;
			case 6: // '\006'
				gc.add(5, 1);
				break;
			case 7: // '\007'
				gc.add(5, 0);
				break;
		}
		return gc.getTime();
	}

	/**
	 * 取得某日期所在周的第一天
	 * @param date Date类型日期参数
	 * @return 当周的第一天日期
	 */
	public static Date getFirstDayOfWeek(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch(gc.get(7)){
			case 1: // '\001'
				gc.add(5, 0);
				break;
			case 2: // '\002'
				gc.add(5, -1);
				break;
			case 3: // '\003'
				gc.add(5, -2);
				break;
			case 4: // '\004'
				gc.add(5, -3);
				break;
			case 5: // '\005'
				gc.add(5, -4);
				break;
			case 6: // '\006'
				gc.add(5, -5);
				break;
			case 7: // '\007'
				gc.add(5, -6);
				break;
		}
		return gc.getTime();
	}

	/**
	 * 当前年是否闰年
	 * @return 返回true为润年，否则不是
	 */
	public static boolean isLeapYear(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(1);
		return isLeapYear(year);
	}

	/**
	 * 给定年是否闰年
	 * @param 整数类型的年份
	 * @return 返回true为润年，否则不是
	 */
	public static boolean isLeapYear(int year){
		if(year % 400 == 0){
			return true;
		}
		if(year % 4 == 0){
			return year % 100 != 0;
		}else{
			return false;
		}
	}

	/**
	 * 给定日期所在年是否闰年
	 * @param Date 类型的日期
	 * @return 返回true为润年，否则不是
	 */
	public static boolean isLeapYear(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		int year = gc.get(1);
		return isLeapYear(year);
	}

	/**
	 * 给定日期所在年是否闰年
	 * @param Calendar 类型的日期
	 * @return 返回true为润年，否则不是
	 */
	public static boolean isLeapYear(Calendar gc){
		int year = gc.get(1);
		return isLeapYear(year);
	}

	/**
	 * 取得当前日期简体汉字的星期
	 * @return 取得中文版本的星期,例如:星期三
	 */
	public static String getWeek(){
		SimpleDateFormat format = new SimpleDateFormat("E");
		Date date = new Date();
		String time = format.format(date);
		return time;
	}

	/**
	 * 取得给定日期简体汉字的星期
	 * @param date Date 类型的日期
	 * @return 取得中文版本的星期,例如:星期三
	 */
	public static String getWeek(Date date){
		SimpleDateFormat format = new SimpleDateFormat("E");
		String time = format.format(date);
		return time;
	}

	/**
	 * 取得给定日期年份
	 * @param date Date 类型的日期
	 * @return 整数类型的年(如:2008)
	 */
	public static int getYear(Date date){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(1);
	}

	/**
	 * 取得给定日期月份
	 * @param date Date 类型的日期
	 * @return 整数类型的月
	 */
	public static int getMonth(Date date){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(2) + 1;
	}

	/**
	 * 取得给定日期是日
	 * @param date Date 类型的日期
	 * @return 整数类型的日
	 */
	public static int getDay(Date date){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(5);
	}

	/**
	 * 取得给定日期是日
	 * @param date Date 类型的日期
	 * @return 整数类型的日
	 */
	public static int getHour(Date date){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(11);
	}

	/**
	 * 取得给定日期的分钟
	 * @param date Date 类型的日期
	 * @return 整数类型的分钟
	 */
	public static int getMinute(Date date){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(12);
	}

	/**
	 * 取得给定日期的秒
	 * @param date Date 类型的日期
	 * @return 整数类型的秒
	 */
	public static int getSecond(Date date){
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(13);
	}

	/**
	 * 取得给定日期的下一天日期
	 * @param date Date 类型的日期
	 * @return 下一天的日期
	 */
	public static Date getNextDay(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, 1);
		return gc.getTime();
	}

	/**
	 * 返回指定日期 date 前count天的日期对象。
	 * @param date 需要修改的基准日期
	 * @param count 调整的天数
	 * @return
	 */
	public static Date getPreData(Date date, int count){
		Date d = null;
		d = new Date(date.getTime() - count * 24 * 60 * 60 * 1000l);
		return d;
	}

	/**
	 * 返回指定日期 date 后count天的日期对象。
	 * @param date 需要修改的基准日期
	 * @param count 调整的天数
	 * @return
	 */
	public static Date getAfterData(Date date, int count){
		Date d = null;
		d = new Date(date.getTime() + count * 24 * 60 * 60 * 1000l);
		return d;
	}

	/**
	 * 取得给定日期的一个月后的日期
	 * @param date Date 类型的日期
	 * @return 给定日期的一个月后的日期
	 */
	public static Date getNextMonth(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(2, 1);
		return gc.getTime();
	}

	/**
	 * 取得给定日期的一个星期后的日期
	 * @param date Date 类型的日期
	 * @return 给定日期的一个星期后的日期
	 */
	public static Date getNextWeek(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, 7);
		return gc.getTime();
	}

	/**
	 * 取得给定日期的所在月的第一天
	 * @param date Date 类型的日期
	 * @return 给定日期的所在月的第一天
	 */
	public static Date getFirstDayOfMonth(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(5, 1);
		return gc.getTime();
	}

	/**
	 * 取得两个给定日期之差的天数
	 * @param lowerLimitDate Date 类型的前日期
	 * @param upperLimitDate Date 类型的后日期
	 * @return 整数类型的两个日期之差的天数
	 * @exception java.lang.IllegalArgumentException
	 *                如果前日期大于后日期，抛出java.lang.IllegalArgumentException异常
	 */
	public static int getDayInRange(Date lowerLimitDate, Date upperLimitDate){
		long upperTime, lowerTime;
		upperTime = upperLimitDate.getTime();
		lowerTime = lowerLimitDate.getTime();
		if(upperTime < lowerTime){
			logger.error("param is error!", new java.lang.IllegalArgumentException());
		}
		Long result = new Long((upperTime - lowerTime) / (1000 * 60 * 60 * 24));
		return result.intValue();
	}

	/**
	 * 比较两个日期
	 * @param lowerLimitDate 给定比较日期1
	 * @param upperLimitDate 给定比较日期2
	 * @return 如果 给定比较日期1大于给定比较日期2返回true，否则返回false
	 * @exception java.lang.IllegalArgumentException
	 *                如果给定参数为空，抛出java.lang.IllegalArgumentException异常
	 */
	public static boolean checkOverLimited(Date beginLimitDate, Date endLimitDate){
		if(beginLimitDate == null || endLimitDate == null)
			logger.error("param is error!", new java.lang.IllegalArgumentException());
		if(beginLimitDate.compareTo(endLimitDate) > 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 计算两个 calendar days 之间的天数
	 * @param begin 开始日期
	 * @param end 结束日期
	 * @return 使用SimpleDateFormat，规定好格式，parser出错即为非法
	 *         使用DateToStr或者StrToDate格式化，返回的永远是大于零的数字
	 */
	public static int getDaysBetween(Calendar begin, Calendar end){
		if(begin.after(end)){
			Calendar swap = begin;
			begin = end;
			end = swap;
		}
		int days = end.get(Calendar.DAY_OF_YEAR)
				- begin.get(Calendar.DAY_OF_YEAR);
		int y2 = end.get(Calendar.YEAR);
		if(begin.get(Calendar.YEAR) != y2){
			begin = (Calendar) begin.clone();
			do{
				days += begin.getActualMaximum(Calendar.DAY_OF_YEAR);
				begin.add(Calendar.YEAR, 1);
			}while(begin.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 计算给定日期与给定天数的计算结果（N天后，或N天前）
	 * @param date 给定的日期类型
	 * @param count 整数天，如果为负数；代表day天前。如果为正数：代表day天后
	 * @return Date型计算后的日期对象
	 */
	public static Date modDay(Date date, int day){
		try{
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.DATE, day);
			return cd.getTime();
		}catch (Exception e){
			return null;
		}
	}

	/**
	 * 计算给定日期与给定小时数的计算结果（N小时后，或N小时前）
	 * @param date 给定的日期类型
	 * @param count 整数小时，如果为负数；代表time小时前。如果为正数：代表time小时后
	 * @return Date型计算后的日期对象
	 */
	public static Date modHour(Date date, int time){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, time);
		return cal.getTime();
	}

	/**
	 * <p> 方法名称: serverCurrentDate|描述:获得服务器当天日期yyMMdd格式 </p>
	 * @return
	 */
	public static String serverCurrentDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(ORA_DATE_FORMAT_SIMPLE);
		String str = formatter.format(date);
		return str;
	}

	/**
	 * 获得服务器当前时点yyyy-MM-dd HH:mm:ss.SSS格式
	 * @return
	 */
	public static String serverCurrentDateTime(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(ORA_DATE_TIMES_FORMAT);
		String str = formatter.format(date);
		return str;
	}

	/**
	 * 获得服务器当前时点yyyyMMddHHmmssSSS格式
	 * @return
	 */
	public static String serverCurrentTimeStamp(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
		String str = formatter.format(date);
		return str;
	}

	/**
	 * 获得季度
	 * @param date
	 * @return
	 */
	public static int getQuarter(Date date){
		int d = getMonth(date);
		if(d >= 1 && d <= 3){
			return 1;
		}else if(d >= 4 && d <= 6){
			return 2;
		}else if(d >= 7 && d <= 9){
			return 3;
		}else{
			return 4;
		}
	}
}
