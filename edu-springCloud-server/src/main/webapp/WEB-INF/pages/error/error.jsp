<%@page contentType="text/html; charset=utf-8"%>
<%@page language="java" import="com.haohao.api.util.Code"%>
<%
	out.write("{\"message\":{\"code\":\"" + Code.request_failure.getCode() + "\",\"message\":\""
			+ Code.request_failure.getMsg() + "\"}}");
%>