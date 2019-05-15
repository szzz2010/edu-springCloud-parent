<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.haohao.cn" %>
<!DOCTYPE html>
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
    
	<link rel="icon" type="image/x-icon" href="${webPath}/static/ico/favicon.ico">
    <link href="${webPath}/static/css/content.css" rel="stylesheet" media="screen">
    <link href="${webPath}/static/css/tankuang.css" rel="stylesheet" media="screen">
    <link href="${webPath}/static/layui/css/layui.css" rel="stylesheet" media="screen">

    <script src="${webPath}/static/js/jquery-1.9.1.js"></script>
    <script src="${webPath}/static/js/jquery.serializejson.js"></script>
    <script src="${webPath}/static/js/jquery.form2json.js"></script>
    <script src="${webPath}/static/js/echarts.js"></script>
    <script src="${webPath}/static/layui/layui.js"></script>
    <script src="${webPath}/static/js/xs_util.js"></script>


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
                        where: $('#searchForm').serializeJSON()
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

        function openModel(title, content, area, renderFun) {
            layui.use(['layer'], function () {
                var layer = layui.layer;
                var modelIndex = layer.open({
                    type: 1,
                    anim:1,
                    title: title,
                    shadeClose: true,
                    shade: [0.3, '#000'],
                    maxMin: true,
                    area: area === undefined ? ['60%', '80%'] : area,
                    content: content
                });
                // 处理弹出框弹出后的函数回调，比如有的需要重新对文档流进行渲染
                if (renderFun) {
                    renderFun.call(this, {
                        'modelIndex': modelIndex
                    });
                }
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

        function renderFormSelect(){
            layui.use('form', function(){
                var form = layui.form;
                form.render('select');
            });
        }
        function outbound(mobile){
        	top.$("#callme").trigger("myclick", mobile);
        }
        
        function formatDate(time,format='YY-MM-DD hh:mm:ss'){
            var date = new Date(time);

            var year = date.getFullYear(),
                month = date.getMonth()+1,//月份是从0开始的
                day = date.getDate(),
                hour = date.getHours(),
                min = date.getMinutes(),
                sec = date.getSeconds();
            var preArr = Array.apply(null,Array(10)).map(function(elem, index) {
                return '0'+index;
            });////开个长度为10的数组 格式为 00 01 02 03

            var newTime = format.replace(/YY/g,year)
                                .replace(/MM/g,preArr[month]||month)
                                .replace(/DD/g,preArr[day]||day)
                                .replace(/hh/g,preArr[hour]||hour)
                                .replace(/mm/g,preArr[min]||min)
                                .replace(/ss/g,preArr[sec]||sec);

            return newTime;         
        }
    </script>
    <title>资产系统-好好借道</title>
</head>