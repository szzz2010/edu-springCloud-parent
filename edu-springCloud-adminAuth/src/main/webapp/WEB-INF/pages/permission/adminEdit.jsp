<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <input type="hidden" name="id" value="${admin.id}" class="layui-input" />
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">帐号</label>
        <div class="layui-input-block">
            <input disabled="disabled" lay-verify="required" value="${admin.userName}" placeholder="请输入帐号" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input name="realName" lay-verify="required" value="${admin.realName}" placeholder="请输入姓名" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(90006)}">--%>
            <button class="layui-btn" lay-submit="" lay-filter="btnSubmit" >立即提交</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    saveData('/admin/update');
</script>
<%@ include file="../common/footer_content.jsp" %>