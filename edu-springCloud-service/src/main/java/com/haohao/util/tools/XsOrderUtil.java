package com.haohao.util.tools;

import java.math.BigDecimal;

import com.haohao.constant.InterestConfig;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;
import com.haohao.util.springTools.springJdbc.helper.UuidHelper;

public class XsOrderUtil {
	
	public static String createBusOrderId(Integer userId){
		return userId + "C" + TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS);
	}
	
	public static String createBusOrderIdDDD(Integer orderId){
		return orderId + "D" + TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS);
	}
	
	public static int getCompanyIdByBusOrderId(String busOrderId) {
		return Integer.valueOf(busOrderId.substring(0, busOrderId.indexOf("C")));
	}
	
	public static int getOrderIdByBusOrderId(String busOrderId) {
		return Integer.valueOf(busOrderId.substring(0, busOrderId.indexOf("D")));
	}
	
	public static String getSPADateUuidCode(){
		return "SPA"+TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)+UuidHelper.get8UUID();
	}
	
	public static String getSPBDateUuidCode(){
		return "SPB"+TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)+UuidHelper.get8UUID();
	}
	
	public static BigDecimal transXsRate(){
		return InterestConfig.loan_xs_year_rate.multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_UNNECESSARY);
	}
	
	public static String getHKDateUuidCode(){
		return "HK"+TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)+UuidHelper.get8UUID();
	}
	
	public static String getDZDateUuidCode(){
		return "DZ"+TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)+UuidHelper.get8UUID();
	}
	
}
