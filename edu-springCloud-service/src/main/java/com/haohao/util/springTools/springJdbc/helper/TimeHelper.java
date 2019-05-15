package com.haohao.util.springTools.springJdbc.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
/**
 * powered by denshinyou
 */
public class TimeHelper extends org.apache.commons.lang3.time.DateUtils {

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
	public static final String YYYYNMMYDDR = "yyyy骞碝M鏈坉d鏃�";
	public static final String MMYDDR = "MM鏈坉d鏃�";
	public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String M = "M";
	public static final int TIME_CONSTANTS = 1000 * 3600 * 24;
	
	public final static String[] parsePatterns = {"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss", "yyyyMMdd","yyyy-MM-dd HH:mm","yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM","yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };

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
		SimpleDateFormat sdf ;
		try {
			sdf = new SimpleDateFormat(format);
		} catch (Exception e) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return sdf.format(new Date());
	}
	

	public static String transTimeByFormat(Date dateTime,String fomatTo) {
		String return_time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fomatTo);
			return_time = sdf.format(dateTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return return_time;
	}
	

	public static String transTimeByFormat(String dateTime,String fomatTo) {
		String return_time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(dateTime);
			SimpleDateFormat sdf2 = new SimpleDateFormat(fomatTo);
			return_time = sdf2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return return_time;
	}
	
	public static Date transTimeToDate(String dateTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(dateTime);
	}
	
	public static String transTimeByFormat(String dateTime,String formatFrom,String fomatTo) {
		String return_time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatFrom);
			Date date = sdf.parse(dateTime);
			SimpleDateFormat sdf2 = new SimpleDateFormat(fomatTo);
			return_time = sdf2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return return_time;
	}
	
	public static Date transTimeToDateByFormat(String dateTime,String formatFrom) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatFrom);
		return sdf.parse(dateTime);
	}
	
	  /** 
     * 鍙栧緱褰撳墠鏃堕棿鎴筹紙绮剧‘鍒扮锛� 
     * @return 
     */  
    public static int getCurrentTimestamp() {
		return (int) (System.currentTimeMillis() / 1000);
	}
	
    public static Date transTimeStampToDate(int seconds) {  
        return new Date(Long.valueOf(seconds*1000L));  
    }  
    
    public static int transDateToTimeStamp(Date date){  
    	  return (int) (date.getTime()/1000);
    }  
      
	/**
	 * 鑾峰彇涓や釜鏃ユ湡涔嬮棿鐨勫勾鏁�
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static float getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000f * 60 * 60 * 24 * 365);
	}

	/**
	 * 鑾峰彇涓や釜鏃ユ湡涔嬮棿鐨勫ぉ鏁�
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static float getDistanceOfTwoDateByDay(Date before, Date after) {
		int day = 0;
		try {
			long beforeTime = before.getTime();
			long afterTime = after.getTime();
			Float ff = (afterTime - beforeTime) / (1000f * 60 * 60 * 24);
			day = ff.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}
	
	public static boolean isDate(String dateStr, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			format.parse(dateStr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 鑾峰彇涓や釜鏃ユ湡涔嬮棿鐨勭鏁�
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static int fistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (int)(afterTime - beforeTime) / 1000;
	}

	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 鑾峰彇褰撳ぉ闆剁偣鏃ユ湡
	 *
	 * @return
	 */
	public static Date getCurrentDateZero() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println(calendar.getTime());
		return calendar.getTime();
	}

	//鑾峰彇鏃堕棿鍒颁粖澶╀箣闂寸殑骞存暟
	public static String getYearsToToday(String dateStr, String format){
		Float years = 0f;
		SimpleDateFormat sdf = null ;
		if(StringUtils.isNotEmpty(format)){
			sdf = new SimpleDateFormat(format);
		}else{
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		Date date = null;
		Date today = new Date();
		try {
			date = sdf.parse(dateStr);
			years = TimeHelper.getDistanceOfTwoDate(date, today);	
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return String.valueOf(years);
	}

	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡date鍓峝ates澶╃殑鏃堕棿
	 *
	 * @param date
	 * @param dates
	 * @return
	 */
	public static Date getFrontDate(Date date, int dates) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - dates);
		Date endDate = null;
		try {
			endDate = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endDate;
	}
	
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡date鍚巇ates澶╃殑鏃堕棿
	 *
	 * @param date
	 * @param dates
	 * @return
	 */
	public static Date getAfterDate(Date date, int dates) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + dates);
		Date endDate = null;
		try {
			endDate = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endDate;
	}
}
