$(function () {
    orderUtil.getCompanyInfo();

    $(".btn-next").click(function () {
        orderUtil.add();
    });
});


var orderUtil = {
    getCompanyInfo: function () {
        $.ajax({
            type: 'POST',
            url: '/company/getDetail',
            async: false,
            data: null,
            success: function (data) {
                if (data && data.code == 200 && data.data != null) {
                    var _data = data.data;
                    $("#name").val(_data.name);
                    $("#usccCode").val(_data.usccCode);
                }
            }
        });
    },
    // 添加订单
    add: function () {
        var _data = {
            actualMoney: $("#actualMoney").val(),
        };
        $.ajax({
            type: 'POST',
            url: '/order/add',
            async: false,
            data: _data,
            success: function (data) {
                if (data && data.code == 200) {
                    var _data = data.data;
                    layer.msg("借款申请已提交");
                    setTimeout(function () {
                    	location.href='/html/page/companyInfo.html';
                    }, 2000);
                } else if (data && data.code == 304) {
                    layer.msg("企业尚未开户,即将跳转到开户画面");
                    setTimeout(function () {
                    	location.href='/html/page/openAnAccount_v1.html';
                    }, 2000);
                }else{
                	console.info(data)	;
                	 layer.msg(data.message);
                }
            }
        });
    }
}