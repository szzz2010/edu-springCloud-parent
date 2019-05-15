package com.haohao.permission.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author rienniu
 * @date 2016年12月27日下午6:09:38
 * <p>
 * title: DateUtil
 * </p>
 * <p>
 * desc:
 * </p>
 * @since v1.0
 */
public class DateUtil {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYGMMGDD = "yyyy/MM/dd";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD_REPLACE = "yyyy.MM.dd";
	public static final String HH_MM_SS = "HH:mm:ss";

	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYYMMDD_FILE = "yyyy/MM/dd";
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String HHMMSS = "HHmmss";
	public static final String YYYYNMMYDDR = "yyyy年MM月dd日";
	public static final String MMYDDR = "MM月dd日";
	public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String M = "M";
	public static final int TIME_CONSTANTS = 1000 * 3600 * 24;

	/**
	 * <p>
	 * desc:获取当前时间的unix时间戳
	 * </p>
	 *
	 * @param
	 * @return int
	 * @author rienniu
	 * @date 2017年4月26日下午3:10:55
	 * @since v1.0
	 */
	public static int unixTimestamp() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	public static String getCurrentTimeMills() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(new Date());
	}

	public static String getCurrentTimeByFormat(String format) {
		SimpleDateFormat sdf;
		try {
			sdf = new SimpleDateFormat(format);
		} catch (Exception e) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return sdf.format(new Date());
	}

	/**
	 * 字符串日期转成时间戳 如果转换异常，则返回-1
	 */
	public static int getUnixTimeStamp(String dateStr, String format) {
		try {
			return (int) (new SimpleDateFormat(format).parse(dateStr).getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 判断date是否为符合format格式的日期
	 *
	 * @param date
	 * @param format
	 * @return
	 * @author rienniu
	 * @date 2016年12月22日下午6:46:49
	 * @since v1.0
	 */
	public static boolean isDate(String dateStr, String pattern) {
		DateFormat format = new SimpleDateFormat(pattern);
		try {
			format.parse(dateStr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 距离今天几天的时间
	 *
	 * @param date
	 * @param format
	 * @return
	 * @author Renqiang
	 * @date 2018年3月19日晚上7:49:35
	 * @since v1.0
	 */
	public static String after_befor_days(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DATE, days);
		String temp = sdf.format(cl.getTime());
		return temp;
	}

	public static String after_befor_days(int days, int timestr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long lt = Long.valueOf(timestr + "000");
		Date date = new Date(lt);
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DATE, days);
		String temp = sdf.format(cl.getTime());
		return temp;
	}

	/**
	 * 距离今天几月的时间
	 *
	 * @param date
	 * @param format
	 * @return
	 * @author Renqiang
	 * @date 2018年3月19日晚上7:49:35
	 * @since v1.0
	 */
	public static String after_befor_mouth(int mouths) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.MONTH, mouths);
		String temp = sdf.format(cl.getTime());
		return temp;
	}

	/**
	 * 时间加法
	 *
	 * @param date 日期
	 * @param incr 增加，也就是要增加的数量，可以为负值，负值表示减去
	 * @param c    y/Y年，M月，d日，H/h时，m分,s秒
	 * @return
	 * @author rienniu
	 * @date 2016年12月22日下午11:42:00
	 * @since v1.0
	 */
	public static long add(Date date, int incr, char c) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int type = -1;
		switch (c) {
			case 'y':
			case 'Y':
				type = Calendar.YEAR;
				break;
			case 'M':
				type = Calendar.MONTH;
				break;
			case 'd':
				type = Calendar.DAY_OF_YEAR;
				break;
			case 'h':
			case 'H':
				type = Calendar.HOUR_OF_DAY;
				break;
			case 'm':
				type = Calendar.MINUTE;
				break;
			case 's':
				type = Calendar.SECOND;
				break;
		}
		if (type == -1) {
			throw new RuntimeException("Illigal type");
		}
		cal.add(type, incr);
		return cal.getTimeInMillis();
	}

	/**
	 * long类型的时间转String
	 *
	 * @param longtime
	 * @return
	 */
	public static String longToDateStr(long time, String format) {
		return new SimpleDateFormat(format).format(new Date(time));
	}

	/**
	 * 当前日期加上天数后的日期，并转为long型
	 *
	 * @param num 为增加的天数
	 * @return
	 */
	public static Long plusDay(int num) {
		return add(new Date(), num, 'd');
	}

	/**
	 * 判断是否为今日
	 *
	 * @param time
	 * @return
	 * @author rienniu
	 * @date 2016年12月27日下午6:09:42
	 * @since v1.0
	 */
	public static boolean isToday(long time) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.setTimeInMillis(time);
		return year == c.get(Calendar.YEAR) && month == c.get(Calendar.MONTH) && day == c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 将日期对象转换为format格式的字符串
	 *
	 * @param date
	 * @param format
	 * @return
	 * @author rienniu
	 * @date 2017年1月11日下午2:43:23
	 * @since v1.0
	 */
	public static String dateToString(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 将字符串对象转换为日期对象
	 *
	 * @param date
	 * @param format
	 * @return
	 * @author rienniu
	 * @date 2017年1月11日下午2:43:23
	 * @since v1.0
	 */
	public static Date stringToDate(String source, String format) {
		try {
			return new SimpleDateFormat(format).parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Illegal fomat \" " + format + "\" for string:" + source);
		}
	}

	/**
	 * <p>
	 * Description：将Unix时间戳转为日期字符串
	 * </p>
	 *
	 * @param time
	 * @param format
	 * @return
	 * @date 2017年3月3日 下午5:48:50
	 * @author zhangqiang
	 */
	public static String unixTimestampToStr(int time, String format) {
		return longToDateStr(time * 1000L, format);
	}

	/**
	 * Description：将Unix时间戳转为日期字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param time
	 * @return
	 */
	public static String unixTimestampToStr(int time) {
		return longToDateStr(time * 1000L, YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 计算逾期天数
	 *
	 * @param start 起始时间（Unix时间）
	 * @param end   截止时间 （Unix时间）
	 * @return
	 */
	public static int diffDays(int start, int end) {
		return (int) ((getZeroTimestamp(end) - getZeroTimestamp(start)) * 1000L / TIME_CONSTANTS);
	}

	/**
	 * 计算逾期天数
	 *
	 * @param deadLine
	 * @return
	 */
	public static int diffDays(int deadLine) {
		return diffDays(deadLine, unixTimestamp());
	}

	/**
	 * 计算逾期天数
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static int diffDays(Date start, Date end) {
		return diffDays(getMilliesTime(start.getTime()), getMilliesTime(end.getTime()));
	}

	/**
	 * <p>
	 * desc： 获取当天0点时刻的Unix时间戳
	 * </p>
	 */
	public static int getZeroTimestamp() {
		return getZeroTimestamp(new Date());
	}

	/**
	 * <p>
	 * desc： 获取日期date当天的0时的时间戳
	 * </p>
	 */
	public static int getZeroTimestamp(Date date) {
		Calendar zero = Calendar.getInstance();
		zero.setTime(date);
		zero.set(zero.get(Calendar.YEAR), zero.get(Calendar.MONTH), zero.get(Calendar.DATE), 0, 0, 0);
		return (int) (zero.getTimeInMillis() / 1000);
	}

	/**
	 * <p>
	 * desc： 获取日期date(Unix时间戳)当天的0时的时间戳
	 * </p>
	 */
	public static int getZeroTimestamp(int date) {
		Calendar zero = Calendar.getInstance();
		zero.setTime(new Date(date * 1000L));
		zero.set(zero.get(Calendar.YEAR), zero.get(Calendar.MONTH), zero.get(Calendar.DATE), 0, 0, 0);
		return (int) (zero.getTimeInMillis() / 1000);
	}

	/**
	 * <p>
	 * desc： 获取日期date(Unix时间戳)当天结束23点59分的时间戳
	 * </p>
	 */
	public static int getEndTimestamp(int date) {
		Calendar zero = Calendar.getInstance();
		zero.setTime(new Date(date * 1000L));
		zero.set(zero.get(Calendar.YEAR), zero.get(Calendar.MONTH), zero.get(Calendar.DATE), 23, 59, 59);
		return (int) (zero.getTimeInMillis() / 1000);
	}

	/**
	 * 获得10位时间戳
	 *
	 * @return
	 */
	public static int getMilliesTime(long time) {
		return (int) (time / 1000);
	}

	/**
	 * 得到几天前
	 *
	 * @param d
	 * @param day
	 * @return
	 * @Author zhanghao 2017年9月11日上午9:54:56
	 */
	public static Date getDayBefore(Date d, int day) {
		return new Date(d.getTime() - day * 1000 * 24 * 3600);
	}

	/**
	 * 得到几天前
	 *
	 * @param d
	 * @param day
	 * @return
	 * @Author zhanghao 2017年9月11日上午9:54:56
	 */
	public static Integer getDayBefore(Integer d, int day) {
		return d - day * 24 * 3600;
	}

	/**
	 * 得到前几月
	 *
	 * @param d
	 * @param month
	 * @return
	 * @Author zhanghao 2017年9月11日上午11:57:30
	 */
	public static Date getMonthBefore(Date d, int month) {
		String date = dateToString(d, YYYY_MM);
		Date firstDayofDate = stringToDate(date, YYYY_MM);
		Calendar now = Calendar.getInstance();
		now.setTime(firstDayofDate);
		int currentMonth = now.get(Calendar.MONTH);
		now.set(Calendar.MONTH, currentMonth - month);
		return now.getTime();
	}

	/**
	 * 得到几月后
	 */
	public static Date getMonthAfter(Date d, int month) {
		String date = dateToString(d, YYYY_MM);
		Date firstDayofDate = stringToDate(date, YYYY_MM);
		Calendar now = Calendar.getInstance();
		now.setTime(firstDayofDate);
		int currentMonth = now.get(Calendar.MONTH);
		now.set(Calendar.MONTH, currentMonth + month);
		return now.getTime();
	}

	// 由出生日期获得年龄
	public static int getAge(String day) throws Exception {
		Date birthDay = DateUtil.stringToDate(day, "yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}

	/**
	 * 计算两个时间的所差的月份
	 *
	 * @param date1
	 * @param date2
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static int countMonths(String date1, String date2, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(sdf.parse(date1));
			c2.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		int year = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		return year * 12 + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
	}

	public static Date getDayAfter(Date date) {
		if (date == null) {
			return null;
		}
		return new Date(date.getTime() + TIME_CONSTANTS);
	}

	/**
	 * 根据时间的格式 返回时间的unix值
	 *
	 * @param startTime
	 * @return
	 */
	public static int getStandarStartTime(String startTime) {
		String format = DateUtil.YYYY_MM_DD_HH_MM_SS;
		//只处理format的特殊格式
		if (startTime.matches("^(20\\d\\d)/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])\\s(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
			//yyyy/MM/dd HH:mm:ss
			format = "yyyy/MM/dd HH:mm:ss";
		} else if (startTime.matches("^(20\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
			// yyyy-MM-dd-HH:mm:ss
			format = "yyyy-MM-dd-HH:mm:ss";
		} else if (startTime.matches("^(20\\d\\d)-(20\\d\\d)/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])\\s(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
			//yyyy-yyyy/MM/dd HH:mm:ss
			format = "yyyy/MM/dd HH:mm:ss";
			startTime = startTime.substring(5);
		} else if (startTime.matches("^(20\\d\\d)-(20\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])\\s(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
			//yyyy-yyyy-MM-dd HH:mm:ss
			format = "yyyy-MM-dd HH:mm:ss";
			startTime = startTime.substring(5);
		} else if (startTime.matches("^(20\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
			//yyyy-MM-dd
			format = "yyyy-MM-dd";
		}
		return getUnixTimeStamp(startTime, format);
	}

	/**
	 * 根据时间获取几天后的时间
	 *
	 * @author MaJinXu
	 */
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * 获得日期是当年的第几周
	 *
	 * @Title: getWeekOfYear
	 * @Description: 获得日期是当年的第几周
	 * @author: fengxiaowei
	 * @param: @param
	 * date 日期
	 * @param: @return
	 * @return: int 当年的第几周
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回当前时间的下一个整点unix时间戳; 例如:现在10:13,返回11:00的unix时间戳
	 *
	 * @Title: nextHourlyUnixTimestamp
	 * @Description: 返回当前时间的下一个整点unix时间戳
	 * @author: fengxiaowei
	 * @return: int unix时间戳
	 */
	public static int nextHourlyUnixTimestamp() {
		return unixTimestamp() / 3600 * 3600 + 3600;
	}


	/**
	 * Java获取指定月份的最后一天
	 * @param yearMonth
	 * @return
	 */
	public static String getLastDayOfMonth(String yearMonth) {
		int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
		int month = Integer.parseInt(yearMonth.split("-")[1]); //月
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

}
