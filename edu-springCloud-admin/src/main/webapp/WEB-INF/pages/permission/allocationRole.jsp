<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">权限</label>
        <input name="id" value="${param.id}"  type="hidden">
        <div class="layui-input-block">
            <c:forEach items="${roleList}" var="role" varStatus="index">
                <input type="checkbox"  name="roleIdList" lay-skin="primary" value="${role.id}" <c:if test="${roleIdList.contains(role.id)}">checked</c:if> title="${role.roleName}">
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(90007)}">--%>
            <button class="layui-btn" lay-submit="" lay-filter="btnSubmit">保存</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    saveData('/admin/saveRole');
</script>
<%@ include file="../common/footer_content.jsp" %>