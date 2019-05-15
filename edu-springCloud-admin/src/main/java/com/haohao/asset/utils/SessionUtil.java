package com.haohao.asset.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haohao.permission.context.AdminMemberSession;
import com.haohao.permission.model.vo.AdminVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class SessionUtil {
    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);

    /**
     * 获取当前请求的URL地址域参数
     *
     * @return 参数
     * @author:abner
     */
    public static String getPrams() {
        Map<String, String[]> map = getRequest().getParameterMap();
        if (map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer("?");
            map.forEach((key, value) -> {
                if (!key.contains("password")) {
                    stringBuffer.append(key).append("=").append(StringUtils.join(value, ",")).append("&");
                }
            });
            String s = stringBuffer.toString();
            return s.substring(0, s.length() - 1);
        }
        return "";
    }

    /**
     * 获得客户端ip
     *
     * @return ip
     * @author:abner
     */
    public static String getRemoteAddr() {
        String ip = getRequest().getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getRemoteAddr();
        } else if (ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        return ip;
    }


    /**
     * 获取session
     *
     * @return session
     * @author abner
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 重定向
     *
     * @param url 跳转地址
     * @author abner
     */
    public static void sendRedirect(String url) {
        try {
            getResponse().sendRedirect(getContextPath() + url);
        } catch (Exception e) {
            logger.error("重定向异常", e);
        }
    }

    /**
     * 上下文
     *
     * @return String
     * @author:abner
     */
    public static String getContextPath() {
        return getRequest().getContextPath();
    }

    /**
     * 保存principal对象
     *
     * @param principal principal
     * @author:abner
     */
    public static void setPrincipal(AdminMemberSession principal) {
        setAttribute("adminMemberSession", principal);
    }

    /**
     * session保存值
     *
     * @param key   key
     * @param value Object
     * @author:abner
     */
    public static void setAttribute(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取当前登录人
     *
     * @return Principal
     * @author abner
     */
    public static AdminMemberSession getPrincipal() {
        return (AdminMemberSession) getAttribute("adminMemberSession");
    }

    /**
     * session获取值
     *
     * @param key key
     * @author:abner
     */
    public static Object getAttribute(String key) {
        return getSession().getAttribute(key);
    }

    /**
     * 退出系统
     *
     * @author:abner
     */
    public static void logout() {
        getSession().invalidate();
    }

    /**
     * 获取admin
     *
     * @return Admin
     * @author abner
     */
    public static AdminVO getAdmin() {
        return getPrincipal().getAdmin();
    }

    /**
     * 获取角色id
     *
     * @return List<Integer>
     * @author:abner
     */
    public static List<Integer> getRoleIdList() {
        return getPrincipal().getRoleIdList();
    }

    /**
     * 是否有roleId
     *
     * @param roleId 角色id
     * @return boolean
     * @author:abner
     */
    public static boolean isRoleId(Integer roleId) {
        return getRoleIdList().contains(roleId);
    }

    /**
     * 获取按钮编码
     *
     * @return List<String>
     * @author:abner
     */
    public static List<String> getButtonList() {
        return getPrincipal().getButtonList();
    }

    /**
     * 是否有buttonCode
     *
     * @param code 按钮编码
     * @return boolean
     * @author:abner
     */
    public static boolean isButtonCode(String code) {
        return getButtonList().contains(code);
    }

    /**
     * 获取url
     *
     * @return List<String>
     * @author:abner
     */
    public static List<String> getUrlList() {
        return getPrincipal().getUrlList();
    }

    /**
     * 是否登录
     *
     * @return Boolean
     * @author:abner
     */
    public static Boolean isLogin() {
        return null != getPrincipal();
    }

    /**
     * 是否有权限访问
     *
     * @return Boolean
     * @author:abner
     */
    public static Boolean isPermission(String servletPath) {
        return getUrlList().contains(servletPath);
    }

    /**
     * 获取当前登录人id
     *
     * @return user_id
     * @author abner
     */
    public static Integer getUserId() {
        return getAdmin().getId();
    }

    /**
     * 获取当前登录人帐号
     *
     * @return user_name
     * @author abner
     */
    public static String getUserName() {
        return getAdmin().getUserName();
    }

    /**
     * 获取当前登录人姓名
     *
     * @return getRealName
     * @author abner
     */
    public static String getRealName() {
        return getAdmin().getRealName();
    }

    /**
     * getRequest()URI
     *
     * @return uri
     * @author:abner
     */
    public static String getRequestURI() {
        return getRequest().getRequestURI();
    }

    /**
     * getRequestURL
     *
     * @return url
     * @author:abner
     */
    public static String getRequestURL() {
        return getRequest().getRequestURL().toString();
    }

    /**
     * 获取HttpServletRequest
     *
     * @return HttpServletRequest
     * @author abner
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取HttpServletResponse
     *
     * @return HttpServletResponse
     * @author abner
     */
    private static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * getServletPath
     *
     * @return ServletPath
     * @author:abner
     */
    public static String getServletPath() {
        return getRequest().getServletPath();
    }

    /**
     * 判断是否ajax请求
     *
     * @return boolean
     * @author:abner
     */
    public static boolean isAjax() {
        return getRequest().getHeader("X-Requested-With") != null && getRequest().getHeader("X-Requested-With").equals("XMLHttpRequest");
    }

}
