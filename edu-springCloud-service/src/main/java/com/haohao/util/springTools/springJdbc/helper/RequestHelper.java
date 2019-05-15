package com.haohao.util.springTools.springJdbc.helper;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UrlPathHelper;

/**
 * HttpServletRequest甯姪绫�
 */
public class RequestHelper {

	public static final String COOKIE_VALIDATE_KEY = "VALIDATE_KEY";

	public static String getRemoteIPAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * HttpRequest 瑙ｆ瀽宸ュ叿
	 */
	public static Map<String, Object> getHeaders(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
        try{
            //实例化传进来的类型
            T t = beanClass.newInstance();
            //之前使用request.getParameter("name")根据表单中的name值获取value值
            //request.getParameterMap()方法不需要参数，返回结果为Map<String,String[]>，也是通过前台表单中的name值进行获取
            Map<String, String[]> parameterMap = request.getParameterMap();
            //将Map中的值设入bean中，其中Map中的key必须与目标对象中的属性名相同，否则不能实现拷贝
            BeanUtils.populate(t, parameterMap);
            return t;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	
	public static Map<String, Object> getParameters(HttpServletRequest request) {
		// 鍙傛暟Map
		Map<String, String[]> properties = request.getParameterMap();
		// 杩斿洖鍊糓ap
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator();
		Map.Entry<String, String[]> entry;
		// String name = "";
		while (entries.hasNext()) {
			String value = "";
			entry = entries.next();
			String name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value += values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	public static String getRequestPath(HttpServletRequest request) {
		try {
			if (request == null) {
				request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			}
			return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		} catch (Exception e) {
			return null;
		}
	}

	public static String getClientInfo(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 鑾峰彇璁块棶鑰匢P
	 * 
	 * 鍦ㄤ竴鑸儏鍐典笅浣跨敤Request.getRemoteAddr()鍗冲彲锛屼絾鏄粡杩噉ginx绛夊弽鍚戜唬鐞嗚蒋浠跺悗锛岃繖涓柟娉曚細澶辨晥銆�
	 * 
	 * 鏈柟娉曞厛浠嶩eader涓幏鍙朮-Real-IP锛屽鏋滀笉瀛樺湪鍐嶄粠X-Forwarded-For鑾峰緱绗竴涓狪P(鐢�,鍒嗗壊)锛�
	 * 濡傛灉杩樹笉瀛樺湪鍒欒皟鐢≧equest .getRemoteAddr()銆�
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		if (request == null) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		}
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 澶氭鍙嶅悜浠ｇ悊鍚庝細鏈夊涓狪P鍊硷紝绗竴涓负鐪熷疄IP銆�
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	/**
	 * 鑾峰彇IP鍦板潃锛屾棤娉曡幏鍙栧埌request瀵硅薄鏃讹紝浣跨敤姝ゆ柟娉�
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr() {
		try {
			return getIpAddr(null);
		} catch (Exception e) {
			return "127.0.0.1";
		}
	}

	/**
	 * 鑾峰緱褰撶殑璁块棶璺緞
	 * 
	 * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
	 * 
	 * @param request
	 * @return
	 */
	public static String getLocation(HttpServletRequest request) {
		UrlPathHelper helper = new UrlPathHelper();
		StringBuffer buff = request.getRequestURL();
		String uri = request.getRequestURI();
		String origUri = helper.getOriginatingRequestUri(request);
		buff.replace(buff.length() - uri.length(), buff.length(), origUri);
		String queryString = helper.getOriginatingQueryString(request);
		if (queryString != null) {
			buff.append("?").append(queryString);
		}
		return buff.toString();
	}

	/**
	 * 鑾峰彇鍩熷悕
	 * 
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		String domainUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
		return domainUrl;
	}

	/**
	 * 鑾峰彇鎿嶄綔绯荤粺
	 * 
	 * @param args
	 */
	public static String getOs(HttpServletRequest request) {
		String browserDetails = request.getHeader("User-Agent");
		// String[] browserDetails1 = browserDetails.split(" ");
		// System.out.println(browserDetails);
		String userAgent = browserDetails;
		String os = "";
		if (userAgent.toLowerCase().indexOf("nt 6.0") > 0) {
			os = "Windows Vista/Server 2008";
		} else if (userAgent.toLowerCase().indexOf("nt 5.2") > 0) {
			os = "Windows Server 2003";
		} else if (userAgent.toLowerCase().indexOf("nt 5.1") > 0) {
			os = "Windows XP";
		} else if (userAgent.toLowerCase().indexOf("nt 6.0") > 0) {
			os = "Windows Vista";
		} else if (userAgent.toLowerCase().indexOf("nt 6.1") > 0) {
			os = "Windows 7";
		} else if (userAgent.toLowerCase().indexOf("nt 6.2") > 0) {
			os = "Windows Slate";
		} else if (userAgent.toLowerCase().indexOf("nt 5") > 0) {
			os = "Windows 2000";
		} else if (userAgent.toLowerCase().indexOf("nt 4") > 0) {
			os = "Windows NT4";
		} else if (userAgent.toLowerCase().indexOf("98") > 0) {
			os = "Windows 98";
		} else if (userAgent.toLowerCase().indexOf("95") > 0) {
			os = "Windows 95";
		} else if (userAgent.toLowerCase().indexOf("nt 10") > 0) {
			os = "Windows 10";
		} else if (userAgent.toLowerCase().indexOf("sunos") > 0) {
			os = "SunOS";
		} else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
			os = "Mac";
		} else if (userAgent.toLowerCase().indexOf("unix") >= 0) {
			os = "Unix";
		} else if (userAgent.toLowerCase().indexOf("linux") >= 0) {
			os = "Linux";
		} else if (userAgent.toLowerCase().indexOf("android") >= 0) {
			os = "Android";
		} else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
			os = "IPhone";
		} else {
			os = "UnKnown, More-Info: " + userAgent;
		}

		return os;
	}

	/**
	 * 鑾峰彇娴忚鍣�
	 * 
	 * @param args
	 */
	public static String getBrowser(HttpServletRequest request) {
		String browserDetails = request.getHeader("User-Agent");
		String userAgent = browserDetails;
		String user = userAgent.toLowerCase();

		String browser = "";
		if (user.contains("msie")) {
			String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
			browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
		} else if (user.contains("safari") && user.contains("version")) {
			browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
		} else if (user.contains("opr") || user.contains("opera")) {
			if (user.contains("opera"))
				browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
			else if (user.contains("opr"))
				browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
		} else if (user.contains("chrome")) {
			browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
		} else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1) || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1)
				|| (user.indexOf("mozilla/3") != -1)) {
			// browser=(userAgent.substring(userAgent.indexOf("MSIE")).split("
			// ")[0]).replace("/", "-");
			browser = "Netscape-?";

		} else if (user.contains("firefox")) {
			browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
		} else if (user.contains("rv")) {
			browser = "IE";
		} else {
			browser = "UnKnown, More-Info: " + userAgent;
		}
		return browser;
	}

	

	/**
	 * <B>鏂规硶鍚嶇О锛�</B>鍒ゆ柇瀹㈡埛绔槸鍚︿负Firefox<BR>
	 * <B>姒傝璇存槑锛�</B><BR>
	 * 
	 * @param request
	 *            璇锋眰
	 * @return boolean 鏄惁涓篎irefox
	 */
	public static boolean isFirefox(HttpServletRequest request) {
		String agent = request.getHeader("USER-AGENT").toUpperCase();
		return (!StringUtils.isBlank(agent) && agent.indexOf("FIREFOX") > 0);
	}

	/**
	 * <B>鏂规硶鍚嶇О锛�</B>鑾峰彇涓婁紶鏂囦欢<BR>
	 * <B>姒傝璇存槑锛�</B><BR>
	 * 
	 * @param request
	 *            璇锋眰
	 * @return MultipartFile 涓婁紶鏂囦欢
	 */
	public static MultipartFile getUploadFile(HttpServletRequest request) {
		return getUploadFile(request, "file");
	}

	/**
	 * <B>鏂规硶鍚嶇О锛�</B>鑾峰彇涓婁紶鏂囦欢<BR>
	 * <B>姒傝璇存槑锛�</B><BR>
	 * 
	 * @param request
	 *            璇锋眰
	 * @param name
	 *            鏂囦欢鍚�
	 * @return MultipartFile 涓婁紶鏂囦欢
	 */
	public static MultipartFile getUploadFile(HttpServletRequest request, String name) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		return multipartRequest.getFile(name);
	}

	/**
	 * <B>鏂规硶鍚嶇О锛�</B>淇濆瓨涓婁紶鏂囦欢<BR>
	 * <B>姒傝璇存槑锛�</B><BR>
	 * 
	 * @param request
	 *            璇锋眰
	 * @param path
	 *            淇濆瓨璺緞
	 * @throws IOException
	 *             棰勬兂澶栧紓甯搁敊璇�
	 */
	public static void saveUploadFile(HttpServletRequest request, String path) throws IOException {
		MultipartFile file = getUploadFile(request);
		String sep = System.getProperty("file.separator");
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		String fullPath = path + sep + file.getOriginalFilename();
		File uploadedFile = new File(fullPath);
		file.transferTo(uploadedFile);
	}

}
