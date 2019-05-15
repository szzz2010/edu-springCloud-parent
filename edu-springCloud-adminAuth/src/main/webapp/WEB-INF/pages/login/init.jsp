<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<link rel="stylesheet" href="${webPath}/static/css/login.css"/>
<body onload="loadTopWindow();">
<div class="content">
    <form id="form" action="${webPath}/login/login" method="post">
            <div class="top">
                    <span class="title">
                        <%--<img src="${webPath}/static/images/logo.png" class="logo"/>--%>
                        <label>资产管理后台系统</label>
                    </span>
            </div>
            <div class="login-box">
                <div class="box">
                    <h4>账号密码登录</h4>
                    <div class="login-input">
                        <input type="text" name="userName" placeholder="请输入用户名"/>
                        <label></label>
                        <input type="password" name="password" placeholder="请输入密码"/>
                    </div>
                    <span class="errors">${loginError}</span>
                    <button class="login">登录</button>
                </div>
            </div>
    </form>
</div>
</body>
<script language="JavaScript">
    function loadTopWindow(){
        if (window.top!==null && window.top.document.URL!==document.URL){
            window.top.location= document.URL;
        }
    }
</script>
<%@ include file="../common/footer_content.jsp" %>

