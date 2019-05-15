<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<div class="layui-layout layui-layout-admin">
    <%@ include file="../common/menu.jsp" %>
    <div class="layui-body" style="left: 0;">
        <div class="lps-iframe">
            <iframe id="iframe" scrolling="auto" frameborder="0" src=""></iframe>
        </div>
    </div>
</div>
<script src="${webPath}/static/js/home.js"></script>
</body>
<%@ include file="../common/footer_content.jsp" %>