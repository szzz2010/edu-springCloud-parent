
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/header_content.jsp" %>
<body>
<form class="layui-form" style="margin-top: 20px;" method="post" action="" id="tableFrom">
    <input type="hidden" name="order_id" value="${params.order_id}">
    <input type="hidden" name="type" value="pass">
<div class="ensure">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">风控额度：</label>
            <div class="layui-form-mid">${params.userMachineCreditMoney}</div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">审批额度：</label>
            <div class="layui-input-inline">
                 <input name="actual_money" type="number" lay-verify="required" class="layui-input"   />
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">审核意见：</label>
            <div class="layui-input-inline">
                <textarea name="audit_message" lay-verify="required" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="btnSubmit" >确定</button>
                <button class="layui-btn layui-btn-primary" id="close">取消</button>
            </div>
        </div>
    </div>
</div>
</form>
</body>
<script>
    layui.use(['form','jquery'], function(){
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer; //弹层
        //点击按钮事件
        $('#close').on('click', function() {
            close();
        })
        //监听提交
        form.on('submit(btnSubmit)', function () {
            var index = layer.load(2);//开启进度条
            $.ajax({
            	url: '${params.jiezhongUrl}/api/v1/center/auditOrder',
                data :$('#tableFrom').serializeJSON(),
                type: 'get',//默认以get提交，以get提交如果是中文后台会出现乱码
                cache :false,
                jsonp: "callback",
                jsonpCallback:"success",
                dataType : 'jsonp',
                success: function (obj) {
                	console.info(obj);
                    layer.close(index);//关闭
                    if (obj.success) {
                        layer.msg(obj.msg);
                        parent.location.reload();
                    } else {
                        layer.msg(obj.msg);
                    }
                }
            });
            return false;
        });
        //关闭
        function close() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        }
    });
</script>
<%@ include file="../../common/footer_content.jsp" %>