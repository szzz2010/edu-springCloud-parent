package com.haohao.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.haohao.util.springTools.springJdbc.helper.MessageHelper;

/**
 * 日志服务类
 * @author wanglicheng
 *
 */
public class LogUtil {
	

	private static final Logger commonLog = LoggerFactory.getLogger("common"); //通用日志
	
	private static final Logger specialLog = LoggerFactory.getLogger("special"); //特殊日志
	
	private static final Logger systemLog = LoggerFactory.getLogger("system"); //系统日志 保留 90天
	
	private static final Logger exceptionLog = LoggerFactory.getLogger("exception"); //异常日志
	
	private static final Logger behaviorLog = LoggerFactory.getLogger("behavior"); //行為日志
	
	/**
	 * 打印普通日志
	 * @param msg
	 */
	public static void printLog(String msg){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg);
		commonLog.info(sb.toString());
	}
	
	/**
	 * 打印传参占位符日志
	 * printParamsLog("orderid={},userid={}",orderid,userid)
	 * @param msg
	 */
	public static void printParamsLog(String messagePattern,Object ...args){
		String msg = MessageHelper.format(messagePattern, args);
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg);
		commonLog.info(sb.toString());
	}
	
	/**
	 * 打印特殊日志
	 * @param msg
	 */
	public static void printSpecialLog(String msg){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg);
		specialLog.info(sb.toString());
	}
	/**
	 * 打印行爲日志
	 * @param msg
	 */
	public static void printBehaviorLog(String msg){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg);
		behaviorLog.info(sb.toString());
	}
	/**
	 * 打印行爲日志
	 * @param msg
	 */
	public static void printBehaviorLog(Object obj){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + JSONObject.toJSONString(obj));
		behaviorLog.info(sb.toString());
	}
	/**
	 * 打印行爲日志
	 * @param msg
	 */
	public static void printBehaviorLog(String msg, Object obj){
		StringBuffer sb =  defaultTag();
		sb.append("\t" + msg + "\n");
		sb.append( "\t" + JSONObject.toJSONString(obj));
		behaviorLog.info(sb.toString());
	}
	/**
	 * 打印系统日志
	 * @param msg
	 */
	public static void printSystemLog(String msg){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg);
		systemLog.info(sb.toString());
	}
	
	/**
	 * 打印错误日志
	 * @param msg
	 *
	 * @author wanglicheng
	 * @date 2018年8月8日
	 */
	public static void pringExceptionLog(String msg){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg);
		exceptionLog.info(sb.toString());
	}
	/**
	 * 打印错误日志
	 * @param msg
	 * @param ex
	 * @author wanglicheng
	 * @date 2018年8月8日
	 */
	public static void pringExceptionLog(String msg, Throwable ex){
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg); 
		sb.append("\n");
		sb.append(getTrace(ex));
		exceptionLog.info(sb.toString());
	}
	
	public static void printParamsExceptionLog(Throwable e,String messagePattern,Object ...args){
		String msg = MessageHelper.format(messagePattern, args);
		StringBuffer sb =  defaultTag();
		sb.append( "\t" + msg); 
		sb.append("\n");
		sb.append(getTrace(e));
		exceptionLog.info(sb.toString());
	}
	
	private static StringBuffer defaultTag() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement log = stackTrace[1];
        boolean flag = true;
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement e = stackTrace[i];
            if (!e.getClassName().equals(log.getClassName())) {
                sb.append("  ClassName=" + e.getClassName());
                sb.append(", MethodName=" +  e.getMethodName());
                sb.append(", LineNumber=" +  e.getLineNumber());
                flag = false;
                break;
            }
        }
        if (flag) {
        	sb.append("   ClassName=" + log.getClassName());
            sb.append(", MethodName=" +  log.getMethodName());
            sb.append(", LineNumber=" +  log.getLineNumber());
        }
        sb.append("  ]");
        return sb;
    }
	
	public static String getTrace(Throwable ex){
		StringWriter  result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        StringBuffer sb = result.getBuffer();
        return sb.toString();
	}
	
	
}
