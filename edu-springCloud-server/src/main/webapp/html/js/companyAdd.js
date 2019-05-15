$(function () {
    /*地区三级联动*/
    $(".dix-i").distpicker({
        autoSelect: false,
        province: '&emsp;',
        city: '&emsp;'
    });

    /*图片上传*/
    $(document).on("click", '.file-ipt', function () {//事件委托
        $(this).next('.fileupload').trigger('click');
    });

    $('.fileupload').fileupload(//实例化详见common.js
        fileupload.$fileupload
    );

    $("#nextBtn").click(function () {
        companyUtil.saveOrUpdate();
    })

    companyUtil.getDetail();
});


var companyUtil = {
    // 获取表单信息
    getData: function () {
        var _data = {
            id: $("#id").val(),
            name: $("#name").val(),
            usccCode: $("#usccCode").val(),
            legalName: $("#legalName").val(),
            legalPhone: $("#legalPhone").val(),
            legalIdCard: $("#legalIdCard").val(),
            handlerName: $("#handlerName").val(),
            handlerIdCard: $("#handlerIdCard").val(),
            handlerPhone: $("#handlerPhone").val(),
            handlerDuty: $("#handlerDuty").val(),
            placeProvince: $("#placeProvince option:selected").val(),
            placeCity: $("#placeCity option:selected").val(),
            enterpriseAddress: $("#enterpriseAddress").val(),
            referProvince: $("#referProvince option:selected").val(),
            referCity: $("#referCity option:selected").val(),
            nature: $("#nature option:selected").val(),
            companySealName: $("#companySealName").val(),
            sealType: $("#sealType option:selected").val(),
            sealCode: $("#sealCode").val(),
            legalCardFace: $("#legalCardFace").val(),
            legalCardBack: $("#legalCardBack").val(),
            // 新增字段
            advanceRepayType: $("#advanceRepayType").val(),
            repaySource: $("#repaySource").val(),
            industry: $("#industry").val(),
            operatingState: $("#operatingState").val(),
            revenue: $("#revenue").val(),
            liabilities: $("#liabilities").val(),
            foundedDate: $("#foundedDate").val(),
            businessStartDate: $("#businessStartDate").val(),
            businessEndDate: $("#businessEndDate").val(),
            registerAmt: $("#registerAmt").val(),
            registerOrg: $("#registerOrg").val(),
            scope: $("#scope").val(),
            finance: $("#finance").val(),
            repayAbility: $("#repayAbility").val(),
            isInvolvedAppeal: $("#isInvolvedAppeal option:selected").val(),
            isAdministrationPunish: $("#isAdministrationPunish option:selected").val(),
            borrowCapitalUse: $("#borrowCapitalUse").val(),
            isOverdue: $("#isOverdue").val(),
            // 第二次新增的字段
            financeAttach: $("#financeAttach").val(),
            guaranteeAttach: $("#guaranteeAttach").val(),
            creditAttach: $("#creditAttach").val(),
        };
        return _data;
    },

    //保存或添加企业
    saveOrUpdate: function () {
        $.ajax({
            type: 'POST',
            url: '/company/saveOrUpdate',
            data: companyUtil.getData(),
            success: function (data) {
                if (null != data && data.code == 200) {
                	alert(data.message);
                    // setTimeout(function () {
                    //     window.location = '../login.html';
                    // }, 3000);
                } else if (null != data && data.code == 202) {
                    var msg = "";
                    for (var key in data.data) {
                        msg += data.data[key] + "</br>";
                        layer.msg(msg);
                        break;
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    },

    // 企业信息回显
    getDetail: function () {
        $.ajax({
            type: 'POST',
            url: '/company/getDetail',
            data: null,
            success: function (data) {
                if (null != data && data.code == 200) {
                    companyUtil.fillDetail(data.data);
                }
            },
            error: function (err) {
                layer.msg(err);
            }
        });
    },
    // 填充表单
    fillDetail: function (data) {
        $("#id").val(data.id);
        $("#name").val(data.name);
        $("#usccCode").val(data.usccCode);
        $("#legalName").val(data.legalName);
        $("#legalPhone").val(data.legalPhone);
        $("#legalIdCard").val(data.legalIdCard);
        $("#handlerName").val(data.handlerName);
        $("#handlerIdCard").val(data.handlerIdCard);
        $("#handlerPhone").val(data.handlerPhone);
        $("#handlerDuty").val(data.handlerDuty);
        //企业地址
        $("#placeProvince").val(data.placeProvince);
        $("#placeProvince").trigger("change");
        $("#placeCity").val(data.placeCity)
        $("#placeCity").trigger("change");
        $("#enterpriseAddress").val(data.enterpriseAddress);
        //贷款地址
        $("#referProvince").val(data.referProvince);
        $("#referProvince").trigger("change");
        $("#referCity").val(data.referCity);
        $("#referCity").trigger("change");
        $("#nature").val(data.nature);
        $("#companySealName").val(data.companySealName);

        $("#sealType").val(data.sealType);

        $("#sealCode").val(data.sealCode);
        $("#legalCardFace").val(data.legalCardFace);
        $("#legalCardBack").val(data.legalCardBack);
        $("#legalCardFace-img").attr("src", data.legalCardFace);
        $("#legalCardBack-img").attr("src", data.legalCardBack);
        // 新增字段
        $("#advanceRepayType").val(data.advanceRepayType);
        $("#repaySource").val(data.repaySource);
        $("#industry").val(data.industry);
        $("#operatingState").val(data.operatingState);
        $("#revenue").val(data.revenue);
        $("#liabilities").val(data.liabilities);
        $("#foundedDate").val(data.foundedDate);
        $("#businessStartDate").val(data.businessStartDate);
        $("#businessEndDate").val(data.businessEndDate);
        $("#registerAmt").val(data.registerAmt);
        $("#registerOrg").val(data.registerOrg);
        $("#scope").val(data.scope);
        $("#finance").val(data.finance);
        $("#repayAbility").val(data.repayAbility);
        $("#isInvolvedAppeal").val(data.isInvolvedAppeal);
        $("#isAdministrationPunish").val(data.isAdministrationPunish);
        $("#borrowCapitalUse").val(data.borrowCapitalUse);
        $("#isOverdue").val(data.isOverdue);

        //第二次新增的字段
        $("#financeAttach").val(data.financeAttach);
        $("#guaranteeAttach").val(data.guaranteeAttach);
        $("#creditAttach").val(data.creditAttach);

        $("#financeAttach-img").attr("src", data.financeAttach);
        $("#guaranteeAttach-img").attr("src", data.guaranteeAttach);
        $("#creditAttach-img").attr("src", data.creditAttach);
    },

}