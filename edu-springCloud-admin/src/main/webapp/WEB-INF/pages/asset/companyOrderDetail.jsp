<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<body>
<link rel="stylesheet" href="${webPath}/static/css/table.css" />
<div class="box">
    <div class="details_content">
	    <span class="top_title">
			<label>资产管理</label>
			<label>&nbsp;&gt;&nbsp;企业资产详情页</label>
		</span>
		 
        <div class="information_list">
            <div class="information" style="width: 100%;">
                <label class="information_title">基本信息</label>
                <div class="information_content">
                    <div class="loan_list">
                        <span>资产编号：<label id="loan_number"></label></span>
                        <span>产品类型：<label id="loan_product_type"></label></span>
                        <span>企业名称：<label id="loan_company_name"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>企业性质：<label id="company_nature">民营企业</label></span>
                       <%-- <span>公司规模：<label id="company_scale"></label></span>--%>
                        <span>所属行业：<label id="company_industry"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>公司城市：<label id="company_place_city"></label></span>
                        <span>公司地址：<label id="company_address"></label></span>
                    </div>
                    <%--补充字段--%>
                    <div class="loan_list">
                        <span>企业用户类型：<label id="company_type">借款人</label></span>
                        <span>对公账户号：<label id="bank_num"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>登录手机号：<label id="loan_company_mobile"></label></span>
                        <span>统一社会信用代码：<label id="loan_company_id_card"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>授信额度：<label id="loan_give_quota"></label>元</span>
                        <span>贷款提交地：<label id="company_refer_address"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>营业期限(起)：<label id="company_operate_start_date"></label></span>
                        <span>营业期限（止）：<label id="company_operate_end_date"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>注册资本：<label id="company_register_amount"></label>万元</span>
                        <span>登记机关：<label id="company_register_organ"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>经营范围：<label id="company_operate_range"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>企业是否涉诉：<label id="company_is_involve"></label></span>
                        <span>企业是否受行政处罚：<label id="company_is_administrative_penalty"></label></span>
                        <span>企业成立日期：<label id="company_create_date"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>企业经营财务情况：<label id="company_operate_finance_state"></label></span>
                        <span>企业是否逾期：<label id="company_overdue_status"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>公司章名称：<label id="company_sign_name"></label></span>
                        <span>公司章类型：<label id="company_sign_type"></label></span>
                        <span>公司章编码：<label id="company_sign_code"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>企业年营业收入：<label id="company_year_income"></label>元</span>
                        <span>经营状态：<label id="company_operate_status"></label></span>
                    </div>

                </div>
            </div>
        </div>
       
        
        <div class="information_list">
            <div class="information" >
                <label class="information_title">法人信息</label>
                <div class="information_content" style="min-height: 80px;" >
                    <div class="loan_list">
                        <span>法人姓名：<label id="legal_name"></label></span>
                        <span>法人身份证号：<label id="legal_id_card"></label></span>
                        <span>法人电话：<label id="legal_mobile"></label></span>
                    </div>
                    <%--<div class="loan_list">
                       <span>经办人姓名：<label id="handle_name"></label></span>
                        <span>经办人身份证号：<label id="handle_id_card"></label></span>
                    </div>--%>
                   <div class="loan_list">
                        <!-- <span>法人电话：<label id="legal_mobile"></label></span> -->
                        <!-- <span>经办人电话：<label id="handle_mobile"></label></span> -->
                    </div>
                    <%--<div class="loan_list">
                        <span>经办人职业：<label id=""></label></span>
                        <span>经办人职务：<label id="handle_duty"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>参加工作时间：<label id=""></label></span>
                        <span>雇佣类型：<label id=""></label></span>
                    </div>--%>
                   
                </div>
            </div>
            <div class="information" >
                <label class="information_title">信用信息</label>
               <div class="information_content" style="min-height: 80px;" >
                    <div class="loan_list">
                        <span>信用等级：<label id="loan_risk_level"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>审核结果：<label id="loan_risk_advice"></label></span>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="message_list">
			<label class="information_title">风控核验项</label>
			<table class="layui-hide" id="risk-check-table-list"></table> 
		</div>
        <div class="message_list">
			<label class="information_title">借款信息</label>
			<table class="layui-hide" id="loan-table-list"></table>
		</div>
		<!-- 
		 <div class="message_list">
			<label class="information_title">借款资料</label>
			<table class="layui-hide" id="loan-file-table-list"></table>
		</div>
		 -->
		
		<div class="message_list">
			<label class="information_title">附件</label>
			<table class="layui-hide" id="loan-attach-table-list"></table>
		</div>
		
		<div class="message_list">
			<label class="information_title">合同</label>
			<table class="layui-hide" id="loan-contract-table-list"></table>
		</div>
		
		<!--  <div class="message_list">
			<label class="information_title">其他信息</label>
			<table class="layui-hide" id="loan-other-table-list"></table>
		</div>
		 -->
		
    </div>
    
    
</div>
</body>
<script type="text/javascript">

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

	var data_array_info = new Array();
	var data_array_electronic_info = new Array();
	
	$.ajax({
		url: webPath + "/asset/Manage/getCompanyOrderInfoById",
		type: "POST",
		data: {
 			id: '${id}'
		},
		async: true,	
		cache: false,
		success: function (data) {
			data_array_info.push(data)	;
		 	writeInfo(data);
		}
	})
	
	function writeInfo(data){
		$("#id").text(data.id);
		$("#loan_number").text(data.loan_number);
		$("#loan_agency_code").text(data.loan_agency_code);
		$("#loan_agency_name").text(data.loan_agency_name);
		$("#loan_company_name").text(data.loan_company_name);
		$("#loan_product_type").text(data.loan_product_type==1?"信用贷":"信用贷");
		$("#company_industry").text(data.company_industry);
		$("#company_place_city").text(data.company_place_city);
		$("#company_address").text(data.company_address);
		
		$("#loan_company_id_card").text(tuomin(data.loan_company_id_card,6,4));
		$("#loan_company_mobile").text(tuomin(data.loan_company_mobile,3,4));
		$("#bank_card_no").text(tuomin(data.bank_card_no,4,4));
		$("#loan_apply_time").text(data.loan_apply_time);
		$("#loan_contract_amt").text(data.loan_contract_amt);
		$("#loan_risk_level").text(data.loan_risk_level);
		$("#loan_risk_advice").text("通过");
		$("#person_local_addr").text(data.person_local_addr);
		$("#job_company_name").text(data.job_company_name);
		$("#job_profession").text(data.job_profession);
		$("#job_duty").text(data.job_duty);
		$("#biz_entity_name").text(data.biz_entity_name);
		
		$("#legal_name").text(data.legal_name);
		$("#legal_id_card").text(data.legal_id_card);
		$("#legal_mobile").text(data.legal_mobile);

		$("#bank_num").text(data.bank_card_no);
		$("#loan_company_mobile").text(data.loan_company_mobile);
		$("#loan_company_id_card").text(data.loan_company_id_card);
		$("#loan_give_quota").text(data.loan_give_quota);
		$("#company_refer_address").text(data.company_refer_province+"-"+data.company_refer_city);
		$("#company_operate_start_date").text(data.company_operate_start_date);
		$("#company_operate_end_date").text(data.company_operate_end_date);
		$("#company_register_amount").text(data.company_register_amount);
		$("#company_register_organ").text(data.company_register_organ);
		$("#company_operate_range").text(data.company_operate_range);
		$("#company_is_involve").text(changeValue(data.company_is_involve));
		$("#company_is_administrative_penalty").text(changeValue(data.company_is_administrative_penalty));
		$("#company_create_date").text(data.company_create_date);
		$("#company_operate_finance_state").text(data.company_operate_finance_state);
		$("#company_overdue_status").text(changeValue(data.company_overdue_status));
		$("#company_sign_name").text((data.company_sign_name== null || data.company_sign_name == "" || data.company_sign_name == '')?data.loan_company_name:data.company_sign_name);
		$("#company_sign_type").text(companySignType(data.company_sign_type));
		$("#company_sign_code").text(data.company_sign_code);
		$("#company_year_income").text((data.company_year_income == null || data.company_year_income == 0 || data.company_year_income == "")?"5000万以上":data.company_year_income);
		$("#company_operate_status").text((data.company_operate_status == null || data.company_operate_status == "" || data.company_operate_status == '')?"存续":data.company_operate_status);

		
		// $("#handle_name").text(data.handle_name);
		// $("#handle_id_card").text(data.handle_id_card);
		// $("#handle_duty").text(data.handle_duty);
		
		
	}

    /**
     * 是否涉诉/逾期等
     * @param value
     * @returns {string}
     */
	function changeValue(value) {
        if (value == 1) {
            return "是";
        } else {
            return "否"
        }
    }

    /**
     * 公司章类型
     * @param value
     * @returns {string}
     */
    function companySignType(value) {
        if (value == 1) {
            return "公章";
        } else {
            return "其他"
        }
    }

    function handleValueWithId(id,value){
        if(value==""||value==null||value=="null"||value=="NULL"){
            $("#"+id).parent().addClass("hide");
        }else{
            $("#"+id).text(value);
        }
    }


    var layer;
	layui.use(['table', 'layer', 'carousel'], function () {
	    var table = layui.table;
	    layer = layui.layer;
	    var carousel = layui.carousel;
		console.info(data_array_info);
		// 借款信息
	    table.render({
	    	elem: '#loan-table-list',
	    	data: data_array_info,
	        cols: [[
	            {field: 'loan_number', title: '借款编号', minWidth:180, align:'center'}
	            ,{field: 'loan_agency_name', title: '渠道', minWidth:100, align:'center'}
	            ,{field: 'loan_contract_amt', title: '合同金额', minWidth:100, align:'center'}
	            ,{field: 'repay_type', title: '还款方式', minWidth:120, align:'center'
                    , templet: function (d) {
                        var repay_type = d.repay_type;
                        var str = "";
                        if(repay_type=='RT04'){str="等额本息"
                        }else {
                            str = "到期本息";
                        }
                        return str;
                     }
                    }
	            ,{field: 'loan_year_interest_rate', title: '借款利率', minWidth:100, align:'center'}
	            ,{field: 'loan_product_type', title: '产品类型', minWidth:100, align:'center'
	            	, templet: function (d) {
	                    return "信用贷";
	                }
	            }
	            ,{field: 'loan_purpose', title: '借款用途', minWidth:100, align:'center'
	            	, templet: function (d) {
	            		//1：资金周转 2：购生活品 3：教育支出 4：旅游 5：购原材料 6：装修家居 7：其他\r\n',
	                    return "资金周转";
	                }
	            }
	            ,{field: 'loan_terms', title: '借款期限', minWidth:100, align:'center'}
	            ,{field: 'loan_success_time', title: '放款日期', minWidth:100, align:'center'}
	            /* ,{field: 'repay_expiry_time', title: '还款到期日', minWidth:100, align:'center'}
	            ,{field: 'repay_period', title: '总期数', minWidth:100, align:'center'}
	            ,{field: 'repay_month_date', title: '月还款日', minWidth:100, align:'center'}
	            ,{field: 'repay_month_amount', title: '月还款额', minWidth:100, align:'center'}
	            ,{field: 'bank_num', title: '放款银行', minWidth:100, align:'center'
	            	, templet: function (d) {
	            		var bank_num = d.bank_num;
	                    var str = "";
						if(bank_num==102){str="工商银行"};
						if(bank_num==103){str="农业银行"};
						if(bank_num==104){str="中国银行"};
						if(bank_num==105){str="建设银行"};
						if(bank_num==301){str="交通银行"};
						if(bank_num==301){str="中信银行"};
						if(bank_num==302){str="光大银行"};
						if(bank_num==303){str="华夏银行"};
						if(bank_num==304){str="民生银行"};
						if(bank_num==305){str="广发银行"};
						if(bank_num==306){str="平安银行"};
						if(bank_num==307){str="招商银行"};
						if(bank_num==308){str="兴业银行"};
						if(bank_num==309){str="浦发银行"};
						if(bank_num==310){str="邮政银行"};
						return str;
	                }
	            } */
	            ,{field: 'bank_card_no', title: '放款银行卡号', minWidth:100, align:'center'}
	     /*       ,{field: 'bank_province', title: '开户行所在省', minWidth:100, align:'center'}
	            ,{field: 'bank_city', title: '开户行所在市', minWidth:100, align:'center'}*/
	            ,{field: 'bank_branch_name', title: '支行名称', minWidth:100, align:'center'}
	        ]]
	      
	    });
	    // 风控核验项
	    table.render({
	    	elem: '#risk-check-table-list',
	    	data: [
	            { id: 1, item:'企业信息一致性',status:'已核验'}
	            ,{ id: 2, item:'企业法人黑名单检查',status:'已核验'}
	            ,{ id: 3, item:'企业黑名单检查',status:'已核验'}
	            ,{ id: 4, item:'企业反欺诈检查',status:'已核验'}
	            ,{ id: 5, item:'企业信用分检查',status:'已核验'}
	            ],
	        cols: [[
	            {field: 'id', title: '序号', minWidth:180, align:'center'}
	            ,{field: 'item', title: '检验项目', minWidth:100, align:'center'}
	            ,{field: 'status', title: '状态', minWidth:100, align:'center'}
	        ]]
	    });
		 // 借款资料
	    table.render({
	    	elem: '#loan-file-table-list',
	    	data: data_array_info,
	        cols: [[
	            {field: 'id', title: '序号', minWidth:180, align:'center'}
	            ,{field: '', title: '资料项', minWidth:100, align:'center'}
	            ,{field: '', title: '是否提交', minWidth:100, align:'center'}
	            ,{field: '', title: '状态', minWidth:100, align:'center'}
	        ]]
	    });
		
	    // 附件信息
	    table.render({
	    	elem: '#loan-attach-table-list',
	    	data: data_array_info,
	        cols: [[
	            {field: 'loan_number_attach', title: '文件名称', minWidth:180, align:'center', templet: function (d) {
                    return '授信资料.zip';
                }}
	            ,{field: '', title: '操作', minWidth:120, align:'center',templet: function (d) {
                        return '<a href="javascript:void(0);"  onclick="downloadAttach(\'' + d.loan_number + '.zip\', \'attach\' ,\''+'${loan_agency_code}'+'\')"  style="color:blue;">下载</a>';
                    }}
	        ]]
	    }); 
	   
	    // 合同信息
	    table.render({
	    	elem: '#loan-contract-table-list',
	    	url: webPath + "/attach/getElectronicSignatureList",
	    	where: {
	 			loan_agency_code: '${loan_agency_code}',
	 			loan_number: '${loan_number}'
			},
	    	page: false, //开启分页
	    	limit:1000,
	    	 cols: [[
		            {field: 'contractName', title: '合同名称', minWidth:180, align:'center'}
		            ,{field: 'contractType', title: '合同类型', minWidth:180, align:'center'}
		            ,{field: 'fileName', title: '文件名称', minWidth:180, align:'center'}
		            ,{field: '', title: '操作', minWidth:120, align:'center',templet: function (d) {
		            	//return '<a href="javascript:void(0);"  style="color:blue;">下载</a>';
		            	return '<a href="javascript:void(0);"  onclick="downloadAttach(\'' + d.fileName + '\', \'contract\' ,\''+'${loan_agency_code}'+'\' , \''+d.filePath+'\')"  style="color:blue;">下载</a>';
                     }}
		        ]]
	    });
		
	 	// 其他信息
	    /* table.render({
	    	elem: '#loan-other-table-list',
	    	data: data_array_info,
	    	 cols: [[
	            {field: 'loan_contract_amt', title: '借款金额', minWidth:180, align:'center'}
	            ,{field: 'loan_amt', title: '放款金额', minWidth:120, align:'center'}
	            ,{field: 'loan_consult_amt', title: '借款服务费', minWidth:120, align:'center'}
	            ,{field: 'loan_risk_amt', title: '风险金金额', minWidth:120, align:'center'}
	            ,{field: '', title: '信用保证金', minWidth:120, align:'center'}
	            ,{field: '', title: '保险费', minWidth:120, align:'center'}
	            ,{field: '', title: '第三方服务费', minWidth:120, align:'center'}
	            ,{field: '', title: '超额费用', minWidth:120, align:'center'}
	            ,{field: '', title: '综合利率', minWidth:120, align:'center'}
	            ,{field: '', title: '贴息利率', minWidth:120, align:'center'}
	            ,{field: '', title: '交割日', minWidth:120, align:'center'}
	            ,{field: '', title: '导入方式', minWidth:120, align:'center'}
	            ,{field: '', title: '审批人', minWidth:120, align:'center'}
	            ,{field: '', title: '状态', minWidth:120, align:'center'}
		      ]]
	    }); */
	});

    function downloadAttach(fileName, type ,loan_agency_code,filePath){
    	console.info(fileName , type ,loan_agency_code,filePath)	;
        if("attach" == type){
            //下载附件
            window.open(webPath + "/attach/downloadAttach?fileName=" + fileName+"&loan_agency_code="+loan_agency_code);
        }else if("contract" == type){
            //下载合同
            window.open(webPath + "/attach/downloadElectronicSignature?fileName=" + fileName+"&loan_agency_code="+loan_agency_code+"&filePath="+filePath);
        }
    }
</script>
<%@ include file="../common/footer_content.jsp" %>