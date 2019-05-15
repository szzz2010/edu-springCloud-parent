<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<div class="box">
    <%@ include file="../nav.jsp" %>
    <div class="conten">
        <div class="right_content">
					<span class="top_title">
						<label>系统管理</label>
						<label> > 资源列表</label>
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
                <a class="layui-btn" id="add" onclick="openView('增加系统','/resource/add?type=3',['390px', '260px'])"><i class="layui-icon">&#xe608;</i>增加系统</a>
            </div>
            <div class="table_conten">
                <table class="layui-hide" id="table-list"></table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="toobar">
    <%--<c:if test="${t:hasPermission(92002)}">--%>
        <a onclick="openView('编辑','/resource/edit?id={{d.id}}',['560px', '350px'])" class="layui-btn layui-btn layui-btn-xs">编辑</a>
    <%--</c:if>--%>
    {{# if(d.type==0){ }}
    <%--<c:if test="${t:hasPermission(92001)}">--%>
        <a onclick="openView('增加菜单','/resource/add?id={{d.id}}&systemType={{d.systemType}}&type=0',['900px', '650px'])" class="layui-btn layui-btn-normal layui-btn-xs">增加菜单</a>
    <%--</c:if>--%>
    {{#  } }}
    {{# if(d.type==3){ }}
    <%--<c:if test="${t:hasPermission(92001)}">--%>
        <a onclick="openView('增加菜单','/resource/add?id={{d.id}}&systemType={{d.id}}&type=0',['900px', '650px'])" class="layui-btn layui-btn-normal layui-btn-xs">增加菜单</a>
    <%--</c:if>--%>
    {{#  } }}
    {{# if(d.type==0){ }}
    <%--<c:if test="${t:hasPermission(92003)}">--%>
        <a onclick="openView('增加资源','/resource/add?id={{d.id}}&systemType={{d.systemType}}&type=1',['800px', '450px'])" class="layui-btn layui-btn-normal layui-btn-xs">增加资源</a>
    <%--</c:if>--%>
    {{#  } }}
</script>
<script type="text/html" id="switchTpl">
    <%--<c:if test="${t:hasPermission(92006)}">--%>
    <input type="checkbox" name="enable" value="{{d.enable}}" lay-skin="switch" data-rowid="{{d.id}}" lay-text="启用|禁用" lay-filter="enable" {{d.enable==1?'checked':''}}>
    <%--</c:if>--%>
</script>
<script type="text/html" id="type">
    {{# if(d.type==0){ }}
        菜单
    {{#  } }}
    {{# if(d.type==1){ }}
        链接
    {{#  } }}
    {{# if(d.type==2){ }}
        按钮
    {{#  } }}
    {{# if(d.type==3){ }}
        系统
    {{#  } }}
</script>
<script>
    layui.use(['layer', 'form', 'treeGrid'], function () {
        var treeGrid = layui.treeGrid;
        var index = layui.layer.load(2);
        treeGrid.render({
            elem: '#table-list'
            , id: 'tableReload'
            , url: webPath + '/resource/getList'
            , cellMinWidth: 100
            , treeId: 'id'
            , treeUpId: 'parentId'
            , treeShowName: 'resourceName'
            , cols: [[
                {field: 'resourceName',  title: '资源名称'}
                , {field: 'id', title: 'id'}
                , {field: 'resourceUrl', title: '资源地址'}
                , {field: 'resourceCode', title: '资源编码'}
                , {field: 'sortCode', title: '资源序号'}
                , {field: '', title: '类型', templet: '#type'}
                , {field: '', title: '状态', templet: '#switchTpl'}
                , {fixed: '', title: '操作', toolbar: '#toobar'}
            ]]
            , page: false
            ,done: function () {
                layui.layer.close(index);
            }
        });

        $('#searchBtn').on('click', function () {
            index = layer.load(2);
            treeGrid.reload('tableReload', {
                where: $('#searchFrom').serializeJSON()
            });
        });
    });

    layui.use('form', function () {
        var form = layui.form;
        form.on('switch(enable)', function (data) {
            updateData('修改状态', '/resource/update?id=' + $(this).data("rowid") + '&enable=' + (data.value == 1 ? 0 : 1));
        });
    });
</script>
<%@ include file="../common/footer_content.jsp" %>