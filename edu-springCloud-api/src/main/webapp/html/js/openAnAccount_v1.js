// 刷新图形验证码
//var _validToken = null;

//function getValidImgCode() {
//    _validToken = commontUtil.guid();
//    $(".yzm").attr("src", '/imageCode/getValidateCode?code=' + Math.random() + "&validToken=" + _validToken);
//}

var timeleft = validUtil.getSmsInterval();//获取倒计时
$('#btnSMS').removeAttr("disabled").addClass('remove-dis');

$(document).ready(function () {
    // 首次加载验证码
//    getValidImgCode();
   
	//获取企业id
	$('#company_id').val(company_id);
    // 省市下拉框
    getAreasList();
    // 加载学习提供的银行列表
    getBankList();
    // 请求数据
    var _data = {
        company_id: null, // 企业id
        mobile: null,//预留手机号
        cardNum: null,//银行卡号
        bankName: null,//银行名称
        imageCode: null,//图形验证码
        bankProvince: null,//省
        bankCity: null,//市
        superBankCode: null, //超级网银号
        mobileCode: null, //短信验证码
    }
    // 发送短信验证码
    $('#btnSMS').click(function () {
        _data.company_id = $('#company_id').val();
        _data.mobile = $('#mobile').val();
        _data.cardNum = $('#cardNum').val();
        _data.bankName = $('#bankName').find("option:selected").attr("key");
        _data.imageCode = $('#validCode').val();
        _data.bankProvince = $('#province-s').find("option:selected").val();
        _data.bankCity = $('#city-s').find("option:selected").val();
        sendSmsCode(_data);
    });
    // 执行开户
    $('#btn-next').click(function () {
        _data.company_id = $('#company_id').val();
        _data.mobile = $('#mobile').val();
        _data.cardNum = $('#cardNum').val();
        _data.bankName = $('#bankName').find("option:selected").attr("key");
        _data.imageCode = $('#validCode').val();
        _data.bankProvince = $('#province-s').find("option:selected").val();
        _data.bankCity = $('#city-s').find("option:selected").val();
        _data.superBankCode = $('#bankName').find("option:selected").attr("value");
        _data.mobileCode = $('#smsCode').val();
        openAnAccount(_data);
    });
});


// 开户
function openAnAccount(_data) {
    if (!validForm(_data)) {
        return false;
    }
    $.ajax({
        type: 'GET',
        url: "/xs/account/createAccount?"
        + "company_id=" + _data.company_id
        + "&mobile=" + _data.mobile
        + "&bankCard=" + _data.cardNum
        + "&bankName=" + _data.bankName
        + "&bankProvince=" + _data.bankProvince
        + "&bankCity=" + _data.bankCity
        + "&superBankCode=" + _data.superBankCode
        + "&smsCode=" + _data.mobileCode + "",
        async: false,
        data: null,
        success: function (data) {
            if (data && data.code == 200) {
                var _data = data.data;
                layer.msg(_data.info);
                // 开户成功
                if (_data.infoCode == 12005  || _data.infoCode == 12001 ) {
                    setTimeout(function () {
                    	location.href='/html/page/companyInfo.html';
                    }, 2000);
                }
            }
        }
    });

}

// 发送平安银行开户短信验证码
function sendSmsCode(_data) {
    if (!validForm(_data)) {
        return false;
    }
    $.ajax({
        type: 'GET',
        url: "/xs/account/sendMobileCode?company_id=" + _data.company_id + "&mobile=" + _data.mobile + "&cardNum=" + _data.cardNum + "&bankName=" + _data.bankName + "",
        async: false,
        data: null,
        success: function (data) {
            console.log("==sendSmsCode" + JSON.stringify(data));
            if (data && data.code == 200) {
                var _data = data.data;
                layer.msg(_data.info)
                // 短信发送成功
                if (_data.infoCode == 12003) {
                    timeCount();
                }
                if(_data.infoCode == 12001){
                	location.href='/html/page/companyInfo.html';
                }
            }
        }
    });
}


// 省市下拉框
function getAreasList() {
    $(".dix-i").distpicker({
        autoSelect: false,
        province: '&emsp;',
        city: '&emsp;',
        district: '&emsp;'
    });
}

// 加载学习提供的银行列表
function getBankList() {
    $.getJSON("../js/bank.json", function (data) {
        //清空内容
        var _html = '';
        $.each(data, function (infoIndex, info) {
            _html += "<option key='" + info['key'] + "' value='" + info['value'] + "'>" + info['key'] + "</option>";
        })
        $('#bankName').html(_html);
        //显示处理后的数据
    })
}

//校验图形验证码是否正确
/*function validCodeAjax(val) {
    var _res = false;
    $.ajax({
        type: 'POST',
        url: '/user/verifyImageCode',
        data: {
            validCode: val,
            validToken: _validToken
        },
        async: false,
        success: function (data) {
            if (null != data && data.code == 200) {
                _res = true;
            } else {
                layer.msg(data.message);
            }
        }
    });
    return _res;
}*/


// 获取企业id
function getAccountInfo() {
    $.ajax({
        type: 'POST',
        url: '/company/getDetail',
        async: false,
        data: null,
        success: function (data) {
            if (data && data.code == 200) {
                var _data = data.data;
                console.info(_data);
                $('.company_id').val(_data.id);
            }
        },
        error: function (err) {
            layer.msg(err);
        }
    });
}

//计时函数
function timeCount() {
    timeleft -= 1;
    if (timeleft > 0) {
        $('#btnSMS').text(timeleft + " 秒后重发");
        $('#btnSMS').prop('disabled', true).removeClass('remove-dis');
        setTimeout(timeCount, 1000);
    } else {
        $('#btnSMS').text("重新发送");
        timeleft = validUtil.getSmsInterval();   //重置等待时间
//        getValidImgCode(); // 重置验证码
        $('#btnSMS').removeAttr("disabled").addClass('remove-dis');

    }
}

// 校验表单
function validForm(_data) {
    if (!validUtil.isMobile(_data.mobile)) {
        layer.msg("请输入正确的手机号码");
        return false;
    }
    if (!validUtil.isBankCard(_data.cardNum)) {
        layer.msg("请输入正确的银行卡号");
        return false;
    }
    if (!validUtil.isNull(_data.bankName)) {
        layer.msg("请选择开户行");
        return false;
    }
    if (!validUtil.isNull(_data.bankProvince)) {
        layer.msg("请选择开户行所以在省");
        return false;
    }
    if (!validUtil.isNull(_data.bankCity)) {
        layer.msg("请选择开户行所以在市");
        return false;
    }
//    // 验证码是否正确
//    if (!validCodeAjax(_data.imageCode)) {
//        return false;
//    }
    return true;
}

