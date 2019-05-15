$(function () {
    // 发送手机验证码
    $('#btnSMS').on("click", function () {
        if (!registerUtil.validMobile()) {
            layer.msg("请输入正确的手机号码");
            return false;
        }
        registerUtil.sendSmsCode();
    });

    // 点击立即注册按钮时
    $('.reg-btn').on('click', function () {
        if (!registerUtil.validMobile()) {
            layer.msg("请输入正确的手机号码");
            return false;
        }
        if (!registerUtil.validSmsCode()) {
            layer.msg("请输入正确的验证码");
            return false;
        }
        registerUtil.register();
    });
});

var timeleft = validUtil.getSmsInterval();//获取倒计时
$('#btnSMS').removeAttr("disabled").addClass('remove-dis');
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


var registerUtil = {
    //注册
    register: function () {
        $.ajax({
            type: 'POST',
            url: '/company/register',
            data: registerUtil.getFormData(),
            success: function (data) {
                if (null != data && data.code == 300) {
                	console.info(data);
                    layer.msg(data.message);
                    setTimeout(function () {
                    	location.href='/html/page/companyAdd.html';
                    }, 2000);
                } else {
                    layer.msg(data.message);
                }
            }
        });
    },
    //发送短信
    sendSmsCode: function () {
        $.ajax({
            type: 'POST',
            url: '/company/sendSms',
            data: {mobile: registerUtil.getFormData().mobile},
            success: function (data) {
                if (null != data && data.code == 200) {
                	timeCount();
                    layer.msg("6位数字验证码已发送,请注意查收!");
                } else {
                    layer.msg(data.message);
                }
            },
            error: function (err) {
                layer.msg(err);
            }
        });
    },
    // 手机校验
    validMobile: function () {
        var val = $("#phone").val();
        return validUtil.isMobile(val);

    },
    // 验证码校验
    validSmsCode: function () {
        var val = $("#smsCode").val();
        return validUtil.isNull(val);
    },
    // 获取表单数据
    getFormData: function () {
        var _data = {
            mobile: $("#phone").val(),
            smsCode: $("#smsCode").val(),
        };
        return _data;
    }
}