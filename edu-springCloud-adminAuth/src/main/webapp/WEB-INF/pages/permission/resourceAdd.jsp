<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">资源名称</label>
        <div class="layui-input-block">
            <input name="resourceName" lay-verify="required" placeholder="请输入资源名称" class="layui-input" type="text">
        </div>
    </div>
    <c:if test="${param.type==1}">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">资源编码</label>
            <div class="layui-input-block">
                <input name="resourceCode" placeholder="请输入资源编码" class="layui-input" type="text">
            </div>
        </div>
    </c:if>
    <c:if test="${param.type==0||param.type==1}">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">资源地址</label>
            <div class="layui-input-block">
                <input name="resourceUrl" placeholder="请输入资源地址" class="layui-input" type="text">
            </div>
        </div>
    </c:if>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
            <select name="type" lay-verify="required">
                <option value=''>请选择</option>
                <c:if test="${param.type==3}">
                    <option value='3' selected>系统</option>
                </c:if>
                <c:if test="${param.type==0}">
                <option value='0' selected>菜单</option>
                </c:if>
                <c:if test="${param.type==1}">
                    <option value='1'>链接</option>
                    <option value='2'>按钮</option>
                </c:if>
            </select>
        </div>
    </div>
    <c:if test="${param.type==1 || param.type==0}">
        <input name="parentId" value="${param.id}"  type="hidden">
    </c:if>
    <c:if test="${param.type!=3}">
        <input name="systemType" value="${param.systemType}"  type="hidden">
    </c:if>
    <c:if test="${param.type==0}">
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">排序号</label>
            <div class="layui-input-block">
                <input name="sortCode" lay-verify="number" placeholder="请输入排序号" class="layui-input" type="text" value="0">
            </div>
        </div>
    </c:if>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(92004)}">--%>
            <button class="layui-btn" lay-submit="" lay-filter="btnSubmit">保存</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    saveData('/resource/save');
</script>
<%@ include file="../common/footer_content.jsp" %>