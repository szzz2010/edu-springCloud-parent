<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="${webPath}/static/admin/css/login.css">
    <link rel="stylesheet" href="${webPath}/static/css/cube.css" media="screen">
</head>
<body onload="loadTopWindow();">
<div class="wrap">
	<div class="content">
		<p class="logo"></p>
		<p class="tit">WELCOME</p>
		<p class="tips">好好借道资产管理系统</p>
		<div class="container">
	        <form id="form" action="${webPath}/login/login" method="post">
	            <input type="text" name="userName" placeholder="请输入用户名"/>
	            <input type="password" name="password" placeholder="请输入密码"/>
				<span class="errors" style="color:#CC0000;display:block;margin-top:-5px;">${loginError}</span>
	            <p class="change_link" align="center">
	                <span class="text errors"></span>
	            </p>
	            <input type="submit" value="登录"/>
	        </form>
	    </div>
	</div>
	<ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
</body>
<script type="text/javascript">
function loadTopWindow(){
    if (window.top!==null && window.top.document.URL!==document.URL){
        window.top.location= document.URL;
    }
}
</script>
</html>