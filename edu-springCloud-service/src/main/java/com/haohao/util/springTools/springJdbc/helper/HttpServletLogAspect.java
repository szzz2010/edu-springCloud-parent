package com.haohao.util.springTools.springJdbc.helper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.haohao.util.springTools.springJdbc.SpringJdbcDeployVersion;
/**
 * powered by denshinyou
 */
@Aspect
@Component(HttpServletLogAspect.beanName)
public class HttpServletLogAspect {
	
	public static final String beanName = "httpServletLogAspect"+SpringJdbcDeployVersion.deployVersion;
	
    private static final Logger log = LoggerFactory.getLogger(HttpServletLogAspect.class);
    
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PrintLog {}
    @Around("@annotation("+SpringJdbcDeployVersion.packageName+".helper.HttpServletLogAspect.PrintLog)")
    public Object doAround(ProceedingJoinPoint pjp){
        long start = System.currentTimeMillis();
        Object[] args = pjp.getArgs();
        Object result = null;
        LogContent content;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = request.getRequestURI();
        String ip = RequestHelper.getIpAddr(request);
        try {
            result = pjp.proceed();
            content = new LogContent(System.currentTimeMillis() - start,args, result, uri, ip);
            log.info(content.toString());
        } catch (Throwable throwable) {
            content=new LogContentWithException(System.currentTimeMillis()-start,args,result,uri,ip,throwable);
            log.error(content.toString(),throwable);
        }
        return result;
    }


    @SuppressWarnings("unused")
    private class LogContent{
		public long consumed;
        public Object params;
        public Object result;
        public String url;
        public String ip;

        public LogContent(long consumed, Object[] params, Object result, String url, String ip) {
            this.consumed = consumed;
            this.params = ignoreServletObjectInArgs(params);
            this.result = result;
            this.url = url;
            this.ip = ip;
        }

        private Object ignoreServletObjectInArgs(Object[] args){
            if(args == null || args.length == 0){
                return null;
            }
            List<Object> requetParams = Arrays.asList(args);
            List<Object> params = requetParams.stream().filter(arg -> !(arg instanceof ServletRequest || arg instanceof ServletResponse)).collect(Collectors.toList());
            if (params.isEmpty()) {
                return null;
            }
            return params.size() == 1 ? params.get(0) : params;
        }
        @Override
        public String toString(){
            return JSON.toJSONString(this);
        }
    }


    @SuppressWarnings("unused")
    private class LogContentWithException extends LogContent{
		public String throwable;

        public LogContentWithException(long consumed, Object[] params, Object result, String url, String ip, Throwable throwable) {
            super(consumed,params,result,url,ip);
            this.throwable = throwable.toString();
        }
    }
    
   
}

