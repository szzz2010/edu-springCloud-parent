<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("webPath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>404</title>
    <link href="${webPath}/static/css/error.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="container">
    <img class="png" src="${webPath}/static/images/error/404.png" />
    <img class="png msg" src="${webPath}/static/images/error/404_msg.png" />
</div>
<div id="cloud" class="png"></div>

</body>
</html>