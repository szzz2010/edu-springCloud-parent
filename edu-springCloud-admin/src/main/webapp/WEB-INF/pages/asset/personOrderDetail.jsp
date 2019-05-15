<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/header_content.jsp" %>
<style type="text/css">
	.hide{display:none;}
	.box .details_content .loan-info .information_content span {
    min-width: 50%;
}
	.box .details_content .job-info .information_content span {
    min-width: 50%;
}
</style>

<body>
<link rel="stylesheet" href="${webPath}/static/css/table.css" />
<div class="box">
    <div class="details_content">
	    <span class="top_title">
			<label>资产管理</label>
			<label>&nbsp;&gt;&nbsp;个人资产详情页</label>
		</span>
		 
        <div class="information_list">
            <div class="information loan-info" style="width: 100%;">
                <label class="information_title">借款信息<span id="riskInfo" style="margin-left:400px;padding:5px;background: #F3DCC0;border:1px solid #E9E9E9"></span></label>
                <div class="information_content">
                    <div class="loan_list">
                        <span>资产编号：<label id="loan_number"></label></span>
                        <span>产品类型：<label id="loan_product_type"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>姓名：<label id="loan_user_name"></label></span>
                        <span>性别：<label id="person_gender"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>年龄：<label id="person_age"></label></span>
                        <span>手机号码：<label id="loan_user_mobile"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>身份证号码：<label id="loan_user_id_card"></label></span>
                        <span>出生日期：<label id="person_birth_date"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>身份证有效日期：<label id="person_id_period"></label></span>
                        <span>邮箱：<label id="person_email"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>教育程度：<label id="person_education"></label></span>
                        <span>婚姻状况：<label id="person_marriage"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>户籍地址：<label id="person_home_town_addr"></label></span>
                        <span>现居城市：<label id="person_app_city"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>现居地址：<label id="person_local_addr"></label></span>
                        <span>来本市年份：<label id="person_local_year"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>借款提交城市：<label id="person_submit_city"></label></span>
                        <span>家人是否知晓：<label id="person_is_family_know"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>借款期限：<label id="loan_terms"></label></span>
                        <span>月还款金额：<label id="repay_month_amount"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>月还本金：<label id="repay_month_principal"></label></span>
                        <span>银行编号：<label id="bank_num"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>放款银行：<label id="bank_name"></label></span>
                        <span>银行卡号：<label id="bank_card_no"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>银行卡预留手机号：<label id="bank_mobile"></label></span>
                        <span>开户行所在省：<label id="bank_province"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>开户行所在市：<label id="bank_city"></label></span>
                        <span>支行名称：<label id="bank_branch_name"></label></span>
                    </div>
                </div>
            </div>
        </div>
       
       <div class="information_list">
            <div class="information job-info" >
                <label class="information_title">工作信息</label>
                <div class="information_content" style="min-height: 150px;" >
                    <div class="loan_list">
                        <span>公司名称：<label id="job_company_name"></label></span>
                        <span>公司所在地：<label id="biz_register_addr"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>公司电话：<label id="job_company_phone_line"></label></span>
                        <span>公司详细地址：<label id=job_compnay_detail_addr></label></span>
                    </div>
                    <div class="loan_list">
                        <span>公司性质：<label id="job_company_property"></label></span>
                        <span>公司行业性质：<label id=job_company_business_info></label></span>
                    </div>
                    <div class="loan_list">
                        <span>公司规模：<label id="job_company_scale"></label></span>
                        <span>职业：<label id=job_profession></label></span>
                    </div>
                    <div class="loan_list">
                        <span>职务：<label id="job_duty"></label></span>
                        <span>参加工作时间：<label id=job_start_date></label></span>
                    </div>
                    <div class="loan_list">
                        <span>雇佣类型：<label id="job_hire_type"></label></span>
                        <span>月收入：<label id=job_monthly_income></label></span>
                    </div>
                </div>
            </div>
            <div class="information" >
                <label class="information_title">信用信息</label>
               <div class="information_content" style="min-height: 150px;" >
                    <div class="loan_list">
                        <span>信用等级：<label id="loan_risk_level"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>授信额度：<label id="loan_give_quota"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>审核结果：<label id="loan_risk_advice"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>信用卡张数：<label id="credit_card_num"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>信用卡最高额度：<label id="credit_max_limit"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>近六个月人行查询次数：<label id="credit_pbocin_querytimes"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>信用卡是否全额付款：<label id="credit_is_pay_entire"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>信贷征信报告是否空白：<label id="credit_is_app_pboc_blank"></label></span>
                    </div>
                </div>
            </div>
            
        </div>
       
        <div class="information_list">
       	<!-- <div class="information" >
                <label class="information_title">房产信息</label>
                <div class="information_content" style="min-height: 150px;" >
                    <div class="loan_list">
                        <span>房产类型：<label id="house_type"></label></span>
                        <span>房产所在地：<label id="house_addr"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>房产共有人：<label id="house_shared_people_num"></label></span>
                        <span>建筑面积：<label id="house_area"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>购买单价：<label id="house_price"></label></span>
                        <span>购买时间：<label id="house_buy_date"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>产权比例：<label id="house_pro_right_rate"></label></span>
                        <span>住房贷款年限：<label id="house_loan_year_limit"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>住房贷款月供：<label id="biz_register_addr"></label></span>
                        <span>住房贷款余额：<label id="house_loan_balance"></label></span>
                    </div>
                   
                </div>
            </div> -->
            <!-- 
            <div class="information" style="width: 100%;">
                <label class="information_title">联系人信息</label>
               <div class="information_content">
                    <div class="loan_list">
                        <span>第一联系人：<label id="person_relation_first"></label></span>
                        <span>联系人姓名：<label id="person_relation_first_name"></label></span>
                        <span>联系人电话：<label id="person_relation_first_mobile"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>第二联系人：<label id="person_relation_second"></label></span>
                        <span>联系人姓名：<label id="person_relation_second_name"></label></span>
                        <span>联系人电话：<label id="person_relation_second_mobile"></label></span>
                    </div>
                </div>
            </div> -->
        </div>
        <div class="message_list">
			<label class="information_title">风控核验项</label>
			<table class="layui-hide" id="risk-check-table-list"></table> 
		</div>
        <div class="message_list">
			<label class="information_title">借款信息</label>
			<table class="layui-hide" id="loan-table-list"></table>
		</div>
		
		<!-- <div class="message_list">
			<label class="information_title">借款资料</label>
			<table class="layui-hide" id="loan-file-table-list"></table>
		</div> -->
		
		<div class="message_list">
			<label class="information_title">附件</label>
			<table class="layui-hide" id="loan-attach-table-list"></table>
		</div>
		
		<div class="message_list">
			<label class="information_title">合同</label>
			<table class="layui-hide" id="loan-contract-table-list"></table>
		</div>
		
		 <!-- <div class="message_list">
			<label class="information_title">其他信息</label>
			<table class="layui-hide" id="loan-other-table-list"></table>
		</div> -->
		
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
		url: webPath + "/asset/Manage/getPersonOrderInfoById",
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
			if (data.loan_agency_code=="houben"||data.loan_agency_code=="youjinsuo") {
				$("#riskInfo").html('<a href="https://ttopen.haohaojiedao.com/haohao/loanBefore/toloanBefore?name='+data.loan_user_name+'&idNo='+data.loan_user_id_card+'&mobile='+data.loan_user_mobile+'&deviceType=ios&expireDays=30" target="view_window">风险提示信息</a>');
			}
			$("#id").text(data.id);
			$("#loan_number").text(data.loan_number);
			$("#loan_number_attach").text(data.loan_number_attach)
			$("#loan_product_type").text(data.loan_product_type==1?"信用贷":"信用贷");
			$("#loan_agency_code").text(data.loan_agency_code);
			$("#loan_agency_name").text(data.loan_agency_name);
			$("#loan_user_name").text(data.loan_user_name);
			$("#loan_user_id_card").text(tuomin(data.loan_user_id_card,6,4));
			$("#loan_user_mobile").text(tuomin(data.loan_user_mobile,3,4));
			$("#loan_apply_time").text(data.loan_apply_time);
			$("#loan_contract_amt").text(data.loan_contract_amt);
			$("#loan_risk_level").text(handleValueWithId("loan_risk_level",data.loan_risk_level));
			$("#loan_risk_advice").text("通过");
			$("#loan_give_quota").text(handleValueWithId("loan_give_quota",data.loan_give_quota));
			$("#loan_terms").text(handleValueWithId("loan_terms",data.loan_terms));
	
			$("#bank_card_no").text(tuomin(data.bank_card_no,4,4));
			$("#bank_num").text(handleValueWithId("bank_num",data.bank_num));
			$("#bank_name").text(handleValueWithId("bank_name",transBankName(data.bank_num)));
			$("#bank_mobile").text(handleValueWithId("bank_mobile",data.bank_mobile));
			$("#bank_province").text(handleValueWithId("bank_province",data.bank_province));
			$("#bank_city").text(handleValueWithId("bank_city",data.bank_city));
			$("#bank_branch_name").text(handleValueWithId("bank_branch_name",data.bank_branch_name));
	
			$("#repay_month_amount").text(handleValueWithId("repay_month_amount",data.repay_month_amount));
			$("#repay_month_principal").text(handleValueWithId("repay_month_principal",data.repay_month_principal));
	
			$("#person_gender").text(data.person_gender==1?"男":"女");
			$("#person_marriage").text(data.person_marriage==1?"未婚":"已婚");
			$("#person_education").text(transEdu(data.person_education));
			$("#person_local_addr").text(handleValueWithId("person_local_addr",data.person_local_addr));
			$("#person_app_city").text(handleValueWithId("person_app_city",data.person_app_city));
			$("#person_age").text(handleValueWithId("person_age",data.person_age));
			$("#person_birth_date").text(handleValueWithId("person_birth_date",data.person_birth_date));
			$("#person_id_period").text(handleValueWithId("person_id_period",data.person_id_period));
			$("#person_email").text(handleValueWithId("person_email",data.person_email));
			$("#person_home_town_addr").text(handleValueWithId("person_home_town_addr",data.person_home_town_addr));
			$("#person_local_year").text(handleValueWithId("person_local_year",data.person_local_year));
			$("#person_submit_city").text(handleValueWithId("person_submit_city",data.person_submit_city));
			$("#person_is_family_know").text(handleValueWithId("person_is_family_know",data.person_is_family_know));
			$("#person_relation_first").text(handleValueWithId("person_relation_first",transRelation(data.person_relation_first)));
			$("#person_relation_first_name").text(handleValueWithId("person_relation_first_name",data.person_relation_first_name));
			$("#person_relation_first_mobile").text(handleValueWithId("person_relation_first_mobile",data.person_relation_first_mobile));
			$("#person_relation_second").text(handleValueWithId("person_relation_second",transRelation(data.person_relation_second)));
			$("#person_relation_second_name").text(handleValueWithId("person_relation_second_name",data.person_relation_second_name));
			$("#person_relation_second_mobile").text(handleValueWithId("person_relation_second_mobile",data.person_relation_second_mobile));
	
			$("#file_category").text(handleValueWithId("file_category",data.file_category));
			$("#credit_card_num").text(handleValueWithId("credit_card_num",data.credit_card_num));
			$("#credit_max_limit").text(handleValueWithId("credit_max_limit",data.credit_max_limit));
			$("#credit_pbocin_querytimes").text(handleValueWithId("credit_pbocin_querytimes",data.credit_pbocin_querytimes));
			$("#credit_is_pay_entire").text(handleValueWithId("credit_is_pay_entire",data.credit_is_pay_entire==0?"否":"是"));
			$("#credit_is_app_pboc_blank").text(handleValueWithId("credit_is_app_pboc_blank",data.credit_is_app_pboc_blank==0?"否":"是"));
			$("#job_company_property").text(handleValueWithId("job_company_property",transCompanyProperty(data.job_company_property)));
			$("#job_company_business_info").text(handleValueWithId("job_company_business_info",data.job_company_business_info));
			$("#job_company_scale").text(handleValueWithId("job_company_scale",data.job_company_scale));
			$("#job_start_date").text(handleValueWithId("job_start_date",data.job_start_date));
			$("#job_hire_type").text(handleValueWithId("job_hire_type",data.job_hire_type==10?"自雇":"授薪"));
			$("#job_company_name").text(handleValueWithId("job_company_name",data.job_company_name));
			$("#job_company_phone_line").text(handleValueWithId("job_company_phone_line",data.job_company_phone_line));
			$("#job_profession").text(data.job_profession);
			$("#job_monthly_income").text(transIncome(data.job_monthly_income));
			$("#job_duty").text(handleValueWithId("job_duty",transDuty(data.job_duty)));
			$("#job_compnay_detail_addr").text(handleValueWithId("job_compnay_detail_addr",data.job_compnay_detail_addr));
	
			$("#biz_entity_name").text(data.biz_entity_name);
			$("#biz_register_addr").text(handleValueWithId("biz_register_addr",data.biz_register_addr));
	
			$("#house_type").text(data.house_type);
			$("#house_addr").text(data.house_addr);
			$("#house_shared_people_num").text(data.house_shared_people_num);
			$("#house_area").text(data.house_area);
			$("#house_price").text(data.house_price);
			$("#house_buy_date").text(data.house_buy_date);
			$("#house_pro_right_rate").text(data.house_pro_right_rate);
			$("#house_loan_year_limit").text(data.house_loan_year_limit);
			$("#house_loan_balance").text(data.house_loan_balance);
		}
		
		function handleValueWithId(id,value){
			if(value==""||value==null||value=="null"||value=="NULL"){
				$("#"+id).parent().addClass("hide");
			}else{
				$("#"+id).text(value);
			}
		}
	
		function transEdu(edu){
			//（1：硕士及以上；2：本科；3：专科；4：高中；5：初中及以下；）
			return   edu==1?"硕士及以上":edu==2?"本科":edu==3?"专科":edu==4?"高中":"初中及以下";
		}
		function transIncome(income){
			return   income==1?"2万以上":income==2?"1-2万":income==3?"约8000元":income==4?"约6000元":"约5000元";
		}
		//公司性质（1:机关及事业单位；2:国营；3:民营；4:三资企业；5:其他；6:上市企业；7:外资企业；8:合资企业；9:个体工商户；）'
		function transCompanyProperty(tag){
			return   tag==1?"机关及事业单位":tag==2?"国营":tag==3?"民营":tag==4?"三资企业":tag==5?"其他":tag==6?"上市企业":tag==7?"外资企业":tag==8?"合资企业":tag==9?"个体工商户":"";
		}
		//放款银行（04135810:广州银行；102:工商银行；103:农业银行；104:中国银行；105:建设银行；301:交通银行；302:中信银行；303:光大银行；304:华夏银行；305:民生银行；306:广发银行；307:深圳发展银行/平安银行；308:招商银行；309:兴业银行；310:浦发银行；403:邮政储蓄银行；）
		function transBankName(tag){
			return   tag==04135810?"广州银行":tag==102?"工商银行":tag==103?"农业银行":tag==104?"中国银行":tag==105?"建设银行":tag==301?"交通银行":tag==302?"中信银行":tag==303?"光大银行":tag==304?"华夏银行":tag==305?"民生银行":tag==306?"广发银行":tag==307?"深圳发展银行/平安银行":tag==308?"招商银行":tag==309?"兴业银行":tag==310?"浦发银行":tag==403?"邮政储蓄银行":"其他";
		}
		//与本人关系1（1父母；2配偶；3兄弟；4姐妹；0未选择）
		function transRelation(tag){
			return   tag==1?"父母":tag==2?"配偶":tag==3?"兄弟":tag==4?"姐妹":"无";
		}
		//职务（1:高层管理人员；2:次高层管理人员；3:中层管理人员；4:初级管理人员；5:普通员工；）
		function transDuty(tag){
			return   tag==1?"高层管理人员":tag==2?"次高层管理人员":tag==3?"中层管理人员":tag==4?"初级管理人员":tag==5?"普通员工":"";
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
	            		//RT01：等额本息；RT02：先息后本；RT03：到期本息
	            		var t = d.repay_type;
	                    return t=="RT01"?"等额本息":t=="RT02"?"先息后本":"到期本息";
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
	          /*   ,{field: 'repay_expiry_time', title: '还款到期日', minWidth:100, align:'center'} */
	            ,{field: 'repay_period', title: '总期数', minWidth:100, align:'center'}
	           /*  ,{field: 'repay_month_date', title: '月还款日', minWidth:100, align:'center'}
	            ,{field: 'repay_month_amount', title: '月还款额', minWidth:100, align:'center'} */
	            ,{field: 'bank_num', title: '放款银行', minWidth:100, align:'center'
	            	, templet: function (d) {
	            		var bank_num = d.bank_num;
	                    var str = "";
						if(bank_num==102){str="工商银行"};
						if(bank_num==103){str="农业银行"};
						if(bank_num==104){str="中国银行"};
						if(bank_num==105){str="建设银行"};
						if(bank_num==301){str="交通银行"};
						if(bank_num==302){str="中信银行"};
						if(bank_num==303){str="光大银行"};
						if(bank_num==304){str="华夏银行"};
						if(bank_num==305){str="民生银行"};
						if(bank_num==306){str="广发银行"};
						if(bank_num==307){str="平安银行"};
						if(bank_num==308){str="招商银行"};
						if(bank_num==309){str="兴业银行"};
						if(bank_num==310){str="浦发银行"};
						if(bank_num==403){str="邮政银行"};
						return str==""?d.bank_name:str;
	                }
	            }
	            ,{field: 'bank_card_no', title: '放款银行卡号', minWidth:100, align:'center'}
	           /*  ,{field: 'bank_province', title: '开户行所在省', minWidth:100, align:'center'}
	            ,{field: 'bank_city', title: '开户行所在市', minWidth:100, align:'center'} */
	            ,{field: 'bank_branch_name', title: '支行名称', minWidth:100, align:'center'}
	        ]]
	      
	    });
	 // 风控核验项
	    table.render({
	    	elem: '#risk-check-table-list',
	    	data: [
	            { id: 1, item:'身份证实名校验',status:'已核验'}
	            ,{ id: 2, item:'手机号三要素校验',status:'已核验'}
	            ,{ id: 3, item:'银行卡校验',status:'已核验'}
	            ,{ id: 4, item:'风控引擎黑名单校验',status:'已核验'}
	            ,{ id: 5, item:'反欺诈校验',status:'已核验'}
	            ,{ id: 6, item:'风控引擎校验',status:'已核验'}
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
	            {field: 'loan_number_attach', title: '文件名称', minWidth:180, align:'center',templet: function (d) {
                    return '授信资料.zip';
                }}
	            ,{field: '', title: '操作', minWidth:120, align:'center'
                    ,templet: function (d) {
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
	    table.render({
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
	    });
	});
	layui.use('layer', function(){
        var $ = layui.jquery, layer = layui.layer;
        
      //关闭
        closeDetail=function close() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
            parent.tableIns.reload();
        }

        var userId = $("#userId").val();
        var creditAuditOrderId = $("#creditAuditOrderId").val();
     	 //风险提示项按钮
        openDetail("#riskInfo","风险提示信息",['1103px', '541px'],
            "https://ttopen.haohaojiedao.com/haohao/riskInfo/toRuleCodeInfo?caseId=${riskCaseId}");

	})
	function downloadAttach(fileName, type ,loan_agency_code,filePath){
		console.info(fileName , type ,loan_agency_code,filePath)	;
        if("attach" == type){
            //下载附件
            window.open(webPath + "/attach/downloadAttach?fileName=" + fileName+"&loan_agency_code="+loan_agency_code+"&type=0");
        }else if("contract" == type){
            //下载合同
            window.open(webPath + "/attach/downloadElectronicSignature?fileName=" + fileName+"&loan_agency_code="+loan_agency_code+"&filePath="+filePath);
        }
    }
</script>
<%@ include file="../common/footer_content.jsp" %>