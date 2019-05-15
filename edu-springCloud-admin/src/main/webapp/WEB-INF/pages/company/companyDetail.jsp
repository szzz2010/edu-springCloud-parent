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
                        <span>企业名称：<label id="name"></label></span>
                        <span>统一社会信用代码：<label id="uscc_code"></label></span>
                        <span>手机号：<label id="mobile"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>法人姓名：<label id="legal_name"></label></span>
                        <span>法人身份证：<label id="legal_id_card"></label></span>
                        <span>法人手机号：<label id="legal_phone"></label></span>
                        
                    </div>
                    <!-- <div class="loan_list">
                    	<span>经办人姓名：<label id="handler_name"></label></span>
                        <span>经办人身份证：<label id="handler_id_card"></label></span>
                        <span>经办人手机号：<label id="handler_phone"></label></span>
                    </div> -->
                    <div class="loan_list">
                        <span>注册资本：<label id="register_amt"></label>元</span>
                        <span>营业期限(起)：<label id="business_start_date"></label></span>
                        <span>营业期限(止)：<label id="business_end_date"></label></span>
                    </div>
                    <div class="loan_list">
                    	<%--<span>申请注册时间：<label id="create_time"></label></span>--%>
                        <span>对公账户号：<label id="public_account"></label></span>
                        <span>登记机关：<label id="register_org"></label></span>
                        <span>企业借款资金运用情况：<label id="borrow_capital_use"></label></span>
                    </div>
                    <%--补充字段--%>
                    <div class="loan_list">
                        <span>企业性质：<label id="company_nature">民营企业</label></span>
                        <span>公司地址：<label id="company_address"></label></span>
                        <span>企业成立日期：<label id="founded_date"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>授信额度：<label id="loan_give_quota"></label>元</span>
                        <span>贷款提交地：<label id="company_refer_address"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>经营范围：<label id="company_operate_range"></label></span>
                    </div>
                    <div class="loan_list">
                        <span>企业经营财务情况：<label id="company_operate_finance_state"></label></span>
                        <span>企业是否逾期：<label id="company_overdue_status"></label></span>
                        <span>企业是否受行政处罚：<label id="company_is_administrative_penalty"></label></span>
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
            <div class="information">
                <label class="information_title">开户许可证</label>
                <a  id="permitsAccounts" src="" href="" target="_blank">点击下载</a>
            </div>
            <div class="information">
                <label class="information_title">营业执照</label>
                <a  id="businessLicense" src="" href="" target="_blank">点击下载</a>
            </div>
            <div class="information">
                <label class="information_title">法人正面照</label>
                <a  id="legalCardFace" src="" href="" target="_blank">点击下载</a>
            </div>
            <div class="information">
                <label class="information_title">法人反面照</label>
                <a  id="legalCardBack" src="" href="" target="_blank">点击下载</a>
            </div>


        </div>
        <div class="information_list">
            <div class="information">
                <label class="information_title">门店照片</label>
                <a  id="shop" src="" href="" target="_blank">点击下载</a>
            </div>
            <div class="information">
                <label class="information_title">征信报告</label>
                <a id="creditAttach" href="" target="_blank">点击下载</a>
            </div>
            <div class="information">
                <label class="information_title">财务流水</label>
                <a id="financeAttach" href="" target="_blank">点击下载 </a>
            </div>
            <%--<div class="information">
                <label class="information_title">担保信息</label>
                <a id="guaranteeAttach" href="">点击下载</a>
            </div>--%>
        </div>
        
        
        <div class="information_bottom "  id="ORDER_CHECKING" style="display:none" >
            <div class="bottom_limit">
                <span>风控额度：<label id="userMachineCreditMoney"></label>元</span>
            </div>
            <label class="bottom_prompt">额度仅供参考，请以实际情况填写授信额度</label>
            <span>
				<button id="ensure">通过</button>
				<button id="refuse">拒绝</button>
				<button id="cancel">取消</button>
            </span>
        </div>   
        <div class="information_bottom "   id="ORDER_CHECK_SUCCESS" style="display:none"  >
            <div class="bottom_limit">
                <span>审核通过</span>
            </div>
            <br/>
            <div class="bottom_limit">
                <span>最终借款额度：<label id="actual_money"></label>元</span>
            </div>
        </div>    
        
        <div class="information_bottom " id="ORDER_CHECK_FAILED" style="display:none" >
            <div class="bottom_limit">
                <span>审核拒绝</span>
            </div>
            <br/>
            <div class="bottom_limit">
                <span>拒绝原因：<label name="audit_message"></label></span>
            </div>
        </div>    
        <div class="information_bottom "  id="order_canceled" style="display:none" >
            <div class="bottom_limit">                        
                <span>订单取消</span>
            </div>
            <br/>
            <div class="bottom_limit">
                <span>取消原因：<label name="audit_message"></label></span>
            </div>
        </div>   
        
        
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        var id = getQueryString("id");
        $.ajax({
            url: webPath + "/jiezhong/companyDetail",
            type: "get",
            data: {
                id: '${order_id}'
            },
            async: false,
            cache: false,
            success: function (data) {
                console.log(data)
                if (data.code == 0 && data.data !=null){
                    var company = data.data.company;
                    var company_url = data.data.spCompanyVo;

                    $("#name").text(company.name);
                    $("#uscc_code").text(company.uscc_code);
                    $("#mobile").text(company.mobile);
                    $("#create_time").text(company.create_time);
                    $("#legal_name").text(company.legal_name);
                    $("#legal_id_card").text(company.legal_id_card);
                    $("#legal_phone").text(company.legal_phone);
                    $("#handler_name").text(company.handler_name);
                    $("#handler_id_card").text(company.handler_id_card);
                    $("#handler_phone").text(company.handler_phone);
                    $("#business_start_date").text(company.business_start_date);
                    $("#business_end_date").text(company.business_end_date);
                    $("#register_amt").text(company.register_amt);
                    $("#register_org").text(company.register_org);
                    $("#public_account").text(company.public_account);
                    $("#borrow_capital_use").text(company.borrow_capital_use);
                    $("#permitsAccounts").attr("href", company_url.permitsAccounts);
                    $("#businessLicense").attr("href", company_url.businessLicense);
                    $("#legalCardFace").attr("href", company_url.legalCardFace);
                    $("#legalCardBack").attr("href", company_url.legalCardBack);
                    $("#shop").attr("href", company_url.shop);
                    $("#creditAttach").attr("href", company_url.creditAttach);
                    $("#financeAttach").attr("href", company_url.financeAttach);
                    $("#guaranteeAttach").attr("href", company_url.guaranteeAttach);
                    
                    var order = data.data.order;
                    $("#userMachineCreditMoney").text(order.apply_money);
                    $("#actual_money").text(order.actual_money);
                    $("label[name='audit_message']").text(order.audit_message);
                    if("ORDER_CHECKING"==order.status2||"ORDER_CHECK_FAILED"==order.status2||"order_canceled"==order.status2){
                    	$("#"+order.status2).slideDown();
                    }else{
                    	$("#ORDER_CHECK_SUCCESS").slideDown();
                    }

                    $("#company_address").text(company.company_address);
                    $("#founded_date").text(company.founded_date);
                    $("#loan_give_quota").text(company.quota);
                    $("#company_refer_address").text(order.loan_submit_province+"-"+order.loan_submit_city);
                    $("#company_operate_range").text(company.scope);
                    $("#company_operate_finance_state").text(finance(company.finance));
                    $("#company_overdue_status").text(changeValue(company.is_overdue));
                    $("#company_is_administrative_penalty").text(changeValue(company.is_administration_punish));

                    $("#company_sign_name").text((company.company_seal_name== null || company.company_seal_name == "" || company.company_seal_name == '')?company.name:company.company_seal_name);
                    $("#company_sign_type").text(company.company_seal_type);
                    $("#company_sign_code").text(company.company_seal_code);
                    $("#company_year_income").text((company.company_year_income == null || company.company_year_income == 0 || company.company_year_income == "")?"5000万":company.company_year_income);
                    $("#company_operate_status").text((company.business_status == null || company.business_status == "" || company.business_status == '')?"存续":company.business_status);

                } else {
                    layer.msg(data.msg)
                }
            }
        });



        var closeDetail;
        layui.use('layer', function(){
            var $ = layui.jquery, layer = layui.layer;
            //关闭
            closeDetail=function close() {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
                parent.tableIns.reload();
            }
            /**
             * 弹出层
             * @param id   绑定click
             * @param id   弹框标题
             * @param area 弹框大小
             * @param url  参数地址
             */
            function openDetail(id, title, area, url) {
                $(id).on("click", function () {
                	console.info(url);
                    layer.open({
                        type: 2,
                        title: title,
                        shadeClose: true,
                        shade: [0.3, '#000'],
                        maxmin: true,//开启最大化最小化按钮
                        area: area,
                        content: url
                    });
                })
            }
            
          //通过按钮
            var order_id = "${order_id}";
            var userMachineCreditMoney = $("#userMachineCreditMoney").html().trim();
            openDetail("#ensure", "通过", ['30%', '70%'],"${webPath}/jiezhong/ensureInit?order_id=" + order_id +"&userMachineCreditMoney="+userMachineCreditMoney);
            //拒绝按钮
            openDetail("#refuse", "拒绝", ['30%', '70%'],
                "${webPath}/jiezhong/refuseInit?&order_id=" + order_id );
            //取消按钮
            openDetail("#cancel", "取消", ['30%', '70%'],
                "${webPath}/jiezhong/cancelInit?&order_id=" + order_id );
        });
        
        
        
    });
    function getQueryString(name) {
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }

    /**
     * 企业经营财务情况
     * @param finance
     * @returns {string}
     */
    function finance(finance) {
        if (finance == 1) {
            return "异常";
        } else {
            return "正常"
        }
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
</script>
<%@ include file="../common/footer_content.jsp" %>