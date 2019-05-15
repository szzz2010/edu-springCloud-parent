<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.haohao.cn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        request.setAttribute("webPath", request.getContextPath());
    %>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no, maximum-scale=1">

    <link href="${webPath}/static/css/content.css" rel="stylesheet" media="screen">
    <link href="${webPath}/static/layui/css/layui.css" rel="stylesheet" media="screen">

    <script src="${webPath}/static/js/jquery-1.9.1.js"></script>
    <script src="${webPath}/static/js/jquery.serializejson.js"></script>
    <script src="${webPath}/static/js/jquery.form2json.js"></script>
    <script src="${webPath}/static/layui/layui.js"></script>

    <script type="text/javascript">
        var webPath = "${webPath}";
        $(document).ajaxComplete(function (event, xhr, settings) {
            if (xhr.status === 401) {
                layui.use(['layer'], function () {
                    layui.layer.msg('请重新登录');
                });
                window.location.replace(webPath + "/login/init");
            } else if (xhr.status === 403) {
                layui.use(['layer'], function () {
                    layui.layer.msg('没有访问权限');
                });
            } else if (xhr.status === 404) {
                layui.use(['layer'], function () {
                    layui.layer.msg('程序异常');
                });
            }
        });

        function tableLoad(url, cols,page) {
            layui.use(['table'], function () {
                var table = layui.table;
                var index = layui.layer.load(2);
                table.render({
                    elem: '#table-list',
                    url: webPath + url,
                    cols: cols,
                    id: 'tableReload',
                    page: false !== page,
                    limits: [10, 20, 50],
                    even: true,
                    done: function () {
                        layui.layer.close(index);
                    }
                });

                $('#searchBtn').on('click', function () {
                    index = layer.load(2);
                    table.reload('tableReload', {
                        where: $('#searchFrom').serializeJSON()
                    });
                });

            });
        }

        function openView(title, url, area) {
            layui.use(['layer'], function () {
                var layer = layui.layer;
                layer.open({
                    type: 2,
                    anim:1,
                    title: title,
                    shadeClose: false,
                    shade: [0.3, '#000'],
                    maxMin: true,
                    area: area === undefined ? ['60%', '80%'] : area,
                    content: webPath + url
                });
            });
        }

        function closeOpen() {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        }

        function saveData(url) {
            layui.use(['form'], function () {
                var form = layui.form;
                form.on('submit(btnSubmit)', function () {
                    var index = layui.layer.load(2);
                    $.ajax({
                        url: webPath + url,
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
        }

        function updateData(text, url) {
            layui.use(['layer'], function () {
                var layer = layui.layer;
                layer.open({
                      title: text
                    , anim: 4
                    , closeBtn: false
                    , area: '300px;'
                    , shade: 0.5
                    , id: 'LAY_layuipro'
                    , btn: ['确定', '取消']
                    , content: '确认执行操作吗？'
                    , yes: function () {
                        var index = layui.layer.load(2);
                        $.ajax({
                            url: webPath + url,
                            type: 'POST',
                            dataType: 'json',
                            success: function (obj) {
                                layui.layer.close(index);
                                if (obj.success) {
                                    layui.layer.msg(obj.msg);
                                } else {
                                    layui.layer.msg(obj.msg);
                                }
                                $('#searchBtn').click();
                            }
                        });
                    }
                    ,btn2: function(){
                        layer.closeAll();
                        $('#searchBtn').click();
                    }
                });
            });
        }
    </script>
    <title>资产管理系统</title>
</head>