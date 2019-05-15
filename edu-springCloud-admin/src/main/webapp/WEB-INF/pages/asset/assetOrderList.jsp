<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<link rel="stylesheet" href="${webPath}/static/css/table.css" />
<div class="box">
    <div class="conten">
        <div class="right_content">
			<span class="top_title">
				<label>资产管理</label>
				<label>&nbsp;&gt;&nbsp;债权列表</label>
			</span>
			<!-- 表单开始 -->
			<div class="form_conten">
				<form class="layui-form" id="searchForm">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">债权编号</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" name="loanNumber" placeholder="请填写债权编号" />
							</div>
						</div>
						<button type="button" class="layui-btn" id="searchBtn">查询</button>
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

	layui.use(['laydate'], function () {
		var laydate = layui.laydate;
	    laydate.render({
	        elem: '#loan_apply_time',
	        range: '~',
	        type: 'date'
	    });
	});   

    var cols = [[
    	{field: 'id', title: 'id',  align:'center'}
    	,{field: 'loan_number', title: '债权编号',  align:'center'}
        ,{field: 'loan_name', title: '姓名',  align:'center'}
        ,{field: 'loan_id_card', title: '身份证',  align:'center'
        	, templet: function (d) {
                return tuomin(d.loan_id_card,6,4);
            }
        }
        ,{field: 'loan_mobile', title: '手机号',  align:'center'
        	, templet: function (d) {
        		 return tuomin(d.loan_mobile,3,4);
            }
        }
        ,{field: 'loan_contract_amt', title: '合同金额', align:'center' }
        ,{field: 'loan_apply_time', title: '借款时间', align:'center' }
        ,{
            fixed: 'right', title: '操作', align: "center"
            , templet: function (d) {
                return '<a href="javascript:void(0);"  onclick="toDetail('+d.source+','+d.id+')"  style="color:blue;">详情</a>';
            }
        }
    ]];
    var url = '/asset/Manage/showList';

    // 查询列表
    tableLoad(url, cols);

    function toDetail(source, id) {
    	window.open(webPath + "/asset/Manage/toOrderDetail?source="+source+"&id="+id);
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