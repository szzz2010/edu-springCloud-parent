<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<div class="box">
    <%@ include file="../nav.jsp" %>
    <div class="conten">
        <div class="right_content">
					<span class="top_title">
						<label>系统管理</label>
						<label> > 管理员列表</label>
					</span>
            <div class="form_conten" hidden="hidden">
                <form class="layui-form" action="" id="searchFrom">
                    <div class="layui-form-item button_item">
                        <button type="button" class="layui-btn layui-btn-normal" data-type="reload" id="searchBtn">查询
                        </button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </form>
            </div>
            <div class="layui-btn-group">
                <a class="layui-btn" id="add" onclick="openView('添加管理员','/admin/add',['420px', '300px'])"><i class="layui-icon">&#xe608;</i>增加</a>
            </div>
            <div class="table_conten">
                <table class="layui-hide" id="table-list"></table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="toobar">
    <%--<c:if test="${t:hasPermission(90002)}">--%>
    <a onclick="openView('修改管理员','/admin/edit?id={{d.id}}',['410px', '250px'])" class="layui-btn layui-btn-xs">编辑</a>
    <%--</c:if>--%>
    <%--<c:if test="${t:hasPermission(90003)}">--%>
    <a onclick="openView('分配角色','/admin/allocationRole?id={{d.id}}',['480px', '350px'])" class="layui-btn layui-btn-normal layui-btn-xs">分配角色</a>
    <%--</c:if>--%>
    <%--<c:if test="${t:hasPermission(90004)}">--%>
    <a onclick="updateData('重置密码','/admin/resetPassword?id={{d.id}}&password=a123456')" class="layui-btn layui-btn-danger layui-btn-xs">重置密码</a>
    <%--</c:if>--%>
</script>
<script type="text/html" id="switchTpl">
    <%--<c:if test="${t:hasPermission(90008)}">--%>
        <input type="checkbox" name="enable" value="{{d.enable}}" lay-skin="switch" data-rowid="{{d.id}}" lay-text="启用|禁用" lay-filter="enable" {{d.enable==1?'checked':''}}>
    <%--</c:if>--%>
</script>
<script>
    tableLoad("/admin/getList", [[
        {type: 'numbers'}
        , {field: 'id', title: 'ID'}
        , {field: 'userName', title: '帐号'}
        , {field: 'realName', title: '真实姓名'}
        , {field: '', title: '状态', templet: '#switchTpl'}
        , {fixed: '', title: '操作', toolbar: '#toobar'}
    ]]);

    layui.use('form', function(){
        var form = layui.form;
        form.on('switch(enable)', function(data){
            updateData('修改状态','/admin/update?id='+$(this).data("rowid")+'&enable='+(data.value==1?0:1));
        });
    });
</script>
<%@ include file="../common/footer_content.jsp" %>