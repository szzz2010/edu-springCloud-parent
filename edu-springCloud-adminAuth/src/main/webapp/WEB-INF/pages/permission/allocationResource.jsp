<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<script src="${webPath}/static/layui/lay/modules/layui-xtree.js"></script>
<body>
<form class="layui-form layui-form-pane" style="padding-top: 20px;" method="post" action="" id="saveFrom">
    <div id="xtree" ></div>
    <input name="id" value="${param.id}"  type="hidden">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<c:if test="${t:hasPermission(91003)}">--%>
                <button class="layui-btn" lay-submit="" lay-filter="btnSubmit">保存</button>
            <%--</c:if>--%>
            <button class="layui-btn layui-btn-primary" id="close" onclick="closeOpen();">关闭</button>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['form'], function () {
        var form = layui.form;
        var xtree = new layuiXtree({
            elem: 'xtree'
            , form: form
            , data: webPath+'/role/resourceList?roleId=${param.id}'
            , isopen: false
            , ckall: true
            , icon: {
                open: "&#xe7a0;"
                , close: "&#xe622;"
                , end: "&#xe621;"
            }
            , color: {
                open: "#EE9A00"
                , close: "#EEC591"
                , end: "#828282"
            }
        });
        form.on('submit(btnSubmit)', function () {
            var index = layui.layer.load(2);
            $.ajax({
                url: webPath + "/role/saveResource",
                data: $("#saveFrom").form2json({isArrayData:false}),
                type: 'POST',
                dataType: 'json',
                success: function (obj) {
                    layui.layer.close(index);
                    if (obj.success) {
                        layui.layer.msg(obj.msg);
                        closeOpen();
                        parent.$('#searchBtn').click();
                    } else {
                        layui.layer.msg(obj.msg);
                    }
                }
            });
            return false;
        });
    });
</script>
<%@ include file="../common/footer_content.jsp" %>