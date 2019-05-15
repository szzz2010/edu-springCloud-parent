<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <input type="hidden" name="id" value="${resource.id}" class="layui-input" />
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">资源名称</label>
        <div class="layui-input-block">
            <input name="resourceName" value="${resource.resourceName}" lay-verify="required" placeholder="请输入资源名称" class="layui-input" type="text">
        </div>
    </div>
    <c:if test="${resource.type==1||resource.type==2}">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">资源编码</label>
            <div class="layui-input-block">
                <input name="resourceCode" value="${resource.resourceCode}" placeholder="请输入资源编码" class="layui-input" type="text">
            </div>
        </div>
    </c:if>
    <c:if test="${resource.type!=3}">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">资源地址</label>
            <div class="layui-input-block">
                <input name="resourceUrl" value="${resource.resourceUrl}" placeholder="请输入资源地址" class="layui-input" type="text">
            </div>
        </div>
    </c:if>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
            <c:if test="${resource.type==0}">
            <input disabled="disabled" value="菜单" class="layui-input" type="text">
            </c:if>
            <c:if test="${resource.type==1}">
            <input disabled="disabled" value="链接" class="layui-input" type="text">
            </c:if>
            <c:if test="${resource.type==2}">
            <input disabled="disabled" value="按钮" class="layui-input" type="text">
            </c:if>
            <c:if test="${resource.type==3}">
            <input disabled="disabled" value="系统" class="layui-input" type="text">
            </c:if>
        </div>
    </div>
    <c:if test="${resource.type==0}">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">排序号</label>
            <div class="layui-input-block">
                <input name="sortCode" lay-verify="number" placeholder="请输入排序号" class="layui-input" type="text" value="${resource.sortCode}">
            </div>
        </div>
    </c:if>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(92005)}">--%>
            <button class="layui-btn" lay-submit="" lay-filter="btnSubmit">保存</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    saveData('/resource/update');
</script>
<%@ include file="../common/footer_content.jsp" %>