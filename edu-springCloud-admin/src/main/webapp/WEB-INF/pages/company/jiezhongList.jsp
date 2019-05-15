<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<link rel="stylesheet" href="${webPath}/static/css/table.css" />
<div class="box">
    <div class="conten">
        <div class="right_content">
			<span class="top_title">
				<label>企业审核</label>
				<label>&nbsp;&gt;&nbsp;企业列表</label>
			</span>
			<!-- 表单开始 -->
			<div class="form_conten">
				<form class="layui-form" id="searchForm">
					<div class="layui-form-item">
						<div class="layui-inline">
							<select  class="layui-input"  id="select" name="select">
								<option value="">请选择</option>
								<option value="1">企业名称</option>
								<option value="2">统一社会信用代码</option>
								<option value="3">手机号</option>
							</select>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="usccCodeOrNameOrMobile" name="loan_agency_name" placeholder="请输入" />
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">借款申请时间</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="createStartTime" lay-verify="date" autocomplete="off"  name="createStartTime" placeholder="开始时间" />
								<input type="text" class="layui-input" id="createEndTime" lay-verify="date" autocomplete="off"  name="createEndTime" placeholder="结束时间" />
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">审核完成时间</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="checkStartTime" lay-verify="date" autocomplete="off"  name="checkStartTime" placeholder="开始时间" />
								<input type="text" class="layui-input" id="checkEndTime" lay-verify="date"autocomplete="off"  name="checkEndTime" placeholder="结束时间" />
							</div>
						</div>
						<div class="layui-inline">
                           <label class="layui-form-label">状态</label>
                           <div class="layui-input-inline">
							   <select id="status" name="status">
								   <option value="">请选择</option>
								   <option value="0">待审核</option>
								   <option value="1">审核成功</option>
							   </select>
                           </div>
                       </div>
						<button type="button" class="layui-btn" id="searchBtn" onclick="searchTable()">查询</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</form>
			</div>
            <div class="table_conten">
                <table class="layui-hide" id="table-list"></table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        layui.use([ 'laydate'], function () {
            var laydate = layui.laydate;
			laydate.render({
				elem: "#createStartTime"
				, format: 'yyyy-MM-dd'
				,type:'date'

			});
			laydate.render({
				elem: "#createEndTime"
				, format: 'yyyy-MM-dd'
				,type:'date'

			});

			laydate.render({
				elem: "#checkStartTime"
				, format: 'yyyy-MM-dd'
				,type:'date'

			});
			laydate.render({
				elem: "#checkEndTime"
				, format: 'yyyy-MM-dd'
				,type:'date'

			});
        });
        loadData("","","","","","","");
    });

    function loadData(select,usccCodeOrNameOrMobile,createStartTime,createEndTime,checkStartTime,checkEndTime,status) {
        // 查询列表
        layui.use('table', function () {
            var table = layui.table;
            table.render({
                elem: '#table-list',
                url: "data?select="+select+"&usccCodeOrNameOrMobile="+usccCodeOrNameOrMobile+"&createStartTime="+createStartTime
                +"&createEndTime="+createEndTime+"&checkStartTime="+checkStartTime+"&checkEndTime="+checkEndTime
                +"&status="+status,
                cellMinWidth: 120, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                page: true,//开启分页
                limits: [10, 20, 50],
                cols: [[
                    {field: 'order_id', title: 'id', align: 'center'}
                    , {field: 'name', title: '企业名称', align: 'center'}
                    , {field: 'uscc_code', title: '统一社会信用代码', align: 'center'}
                    , {
                        field: 'mobile', title: '手机号', align: 'center'
                        /*, templet: function (d) {
                            return tuomin(d.mobile,3,4);
                        }*/
                    }
                    , {field: 'o_status', title: '状态', align: 'center'
                    	 , templet: function (d) {
                    		 if(d.o_status==99 ||d.o_status==0 || d.o_status==2){
                    			 return d.o_status2;
                    		 }else{
                    			 return "借款审核成功";
                    		 }
                    	 }
                    }
                    , {field: 'create_time', title: '申请借款时间', align: 'center'}
                    , {field: 'check_time', title: '审核完成时间', align: 'center'}
                    , {
                        fixed: 'right', title: '操作', align: "center"
                        , templet: function (d) {
                            /* if (d.o_status2 == "借款待审核"){
                                return '<button  onclick="check(' + d.id + ',1)"  style="color:blue;">审核通过</button>&nbsp;&nbsp;&nbsp;&nbsp;'+
                                '<button onclick="check(' + d.id + ',2)"  style="color:blue;">驳回</button>'
								+'&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="toCompanyDetail(' + d.id + ')"  style="color:blue;">详情</a>';
							} */
                            return '<a href="javascript:void(0);"  onclick="toCompanyDetail(' + d.order_id + ')"  style="color:blue;">详情</a>';
                            /* return ''; */
                        }
                    }
                ]]
            });
        });
    }

    /**
	 * 审核操作
     */
    var lock = 0;
    function check(id,status) {
        var content = "";
        var title = "";
        if (status == 1){
            title = "审核通过";
            content = "是否确认通过？";
		} else if (status ==2){
            title = "驳回";
			content = "是否确认驳回？";
		}
        layer.confirm(content, {title:title},function(index){
            lock++;
            if (lock == 1){
                $.ajax({
                    type: 'get',
                    url: 'check',
                    data: {"id":id,"status":status},
                    success: function (data) {
                        if (null != data && data.code == 0) {
                            searchTable();
                            lock=0;
                        } else {
                            console.log(data.message)
                            layer.msg(data.message);
                        }
                    }
                });
			}
			layer.close(index);
        });
    }

    function searchTable() {
        var select = $("#select option:selected").val();
        var usccCodeOrNameOrMobile = $("#usccCodeOrNameOrMobile").val();
        var createStartTime = $("#createStartTime").val();
        var createEndTime = $("#createEndTime").val();
        var checkStartTime = $("#checkStartTime").val();
        var checkEndTime = $("#checkEndTime").val();
        var status = $("#status option:selected").val();
        loadData(select,usccCodeOrNameOrMobile,createStartTime,createEndTime,checkStartTime,checkEndTime,status);
    }

    function toCompanyDetail(id) {
    	window.open(webPath + "/jiezhong/companyDetailPage?id="+id);
    }

    function tuomin(str,start,end){
		var length = str.length;
		var star_len = length - start - end ;
		var star = "";
		for(i=0  ;i<star_len ;i++){
			star = star + "*";
		}
		var str1 = str.substring(0,start);
		var str2 = str.substring(length-end,length);
		return str1+star+str2;
	}
    
</script>
<%@ include file="../common/footer_content.jsp" %>