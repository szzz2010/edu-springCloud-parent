<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">帐号</label>
        <div class="layui-input-block">
            <input name="userName" lay-verify="required" placeholder="请输入帐号" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input name="realName" lay-verify="required" placeholder="请输入姓名" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input name="password" lay-verify="required" placeholder="请输入密码" class="layui-input" type="password">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(90005)}">--%>
                <button class="layui-btn" lay-submit="" lay-filter="btnSubmit">保存</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    saveData('/admin/save');
</script>
<%@ include file="../common/footer_content.jsp" %>