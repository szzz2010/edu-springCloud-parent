<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <input type="hidden" name="id" value="${role.id}" class="layui-input" />
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input lay-verify="required" value="${role.roleName}" name="roleName" placeholder="请输入角色名称" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(91005)}">--%>
            <button class="layui-btn" lay-submit="" lay-filter="btnSubmit" >立即提交</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    saveData('/role/update');
</script>
<%@ include file="../common/footer_content.jsp" %>