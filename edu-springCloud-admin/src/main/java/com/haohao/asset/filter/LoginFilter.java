package com.haohao.asset.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.haohao.asset.utils.SessionUtil;

/**
 * @author:abner
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    private static List<String> excluded = 
    		new ArrayList<>(Arrays.asList(
    				"/login"
    				, "/logout"
    				, "/error"
    				, "/static"
    				, "/jz"
    		));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> enumeration = filterConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String element = enumeration.nextElement();
            if (element.contains("excluded")) {
                excluded.addAll(Arrays.asList(filterConfig.getInitParameter(element).split(";")));
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String servletPath = SessionUtil.getServletPath();
        boolean ajax = SessionUtil.isAjax();
        long count = excluded.stream().filter(servletPath::contains).count();
        if (count > 0) {
            chain.doFilter(request, response);
        } else if (!SessionUtil.isLogin()) {
            if (ajax) {
                httpResponse.setStatus(401);
            } else {
                httpResponse.sendError(401);
            }
            //TODO: 2018/3/5 abner 原码!SessionUtil.isPermission(servletPath)
        } else if (false) {
            if (ajax) {
                httpResponse.setStatus(403);
            } else {
                httpResponse.sendError(403);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
