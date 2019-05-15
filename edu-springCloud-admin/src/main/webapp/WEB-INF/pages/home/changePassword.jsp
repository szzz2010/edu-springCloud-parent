<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">旧密码</label>
            <div class="layui-input-block">
                <input name="oldPassword" lay-verify="required" placeholder="请输入旧密码" class="layui-input" type="password">
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input name="newPassword" lay-verify="required" placeholder="请输入新密码" class="layui-input" type="password">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="btnSubmit">保存</button>
                <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
            </div>
        </div>
</form>
</body>
<script>
    saveData('/login/updatePassword');
</script>
<%@ include file="../common/footer_content.jsp" %>