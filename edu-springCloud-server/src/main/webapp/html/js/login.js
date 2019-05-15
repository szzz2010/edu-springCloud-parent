/**
 * Created by zxy on 2018/5/10.
 */
/*登录验证*/
$(function () {

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
//	        getValidImgCode(); // 重置验证码
            $('#btnSMS').removeAttr("disabled").addClass('remove-dis');

        }
    }


    // 发送短信验证码
    $('#btnSMS').click(function () {
        if ($('#username').val().length != 11) {
            $('#username').next().show();
            return false;
        }
        $.ajax({
            type: 'POST',
            url: '/company/sendSms',
            data: {mobile: $('#username').val()},
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
    });


    var _data = {
        mobile: null,
        smsCode: null
    };

    // 登陆按钮点击登录
    $('#btn-sub').on('click', function () {
        if ($('#username').val().length != 11) {
            $('#username').next().show();
            return false;
        }
        if ($('#smsCode').val().length < 6) {
            $('#smsCode').next().next().show();
            return false;
        }
        _data.mobile = $('#username').val();
        _data.smsCode = $('#smsCode').val();

        $.ajax({
            type: 'POST',
            url: '../company/login',//请求地址
            data: _data,
            success: function (data) {
                if (data) {
                    // 企业信息已完善
                    if (data.code == 301) {
                        layer.msg('登陆成功,即将跳转个人中心页面');
                        setTimeout(function () {
                        	location.href='/html/page/companyInfo.html';
                        }, 2000);
                    }
                    // 企业信息未完善
                    else if (data.code == 300) {
                        setTimeout(function () {
                        	location.href='/html/page/companyAdd.html';
                        }, 2000);
                    }
                    // 企业不存在
                    else if (data.code == 302) {
                        layer.msg('用户不存在,即将跳转注册页面');
                        location.href='/html/page/register.html';
                    } else if (data.code == 202) {
                        layer.msg(data.message);
                    }
                }
            },
            error: function (err) {
                layer.msg(err);
            }
        });
    });
});