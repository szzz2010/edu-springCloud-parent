
var company_id = '' ;
var company = {};
$(document).ready(function () {

    // 获取企业id
    getAccountInfo();
    function getAccountInfo() {
        $.ajax({
            type: 'POST',
            url: '/company/getDetail',
            async: false,
            data: null,
            success: function (data) {
                if (data && data.code ==200 && data.data != null) {
                    console.info(data);
                    company = data.data;
                    company_id = company.id ;
                }
            },
            error: function (err) {
                layer.msg(err);
            }
        });

        if(company_id == null || company_id == ''){
            window.location.href = '/html/login.html';
        }
    }

    /*获取登录角色的头像*/
    var userImg = commontUtil.getUserImg();

    /*动态显示菜单*/
    isCertified();

    /*下拉菜单*/
    var menuHtml = '<div class="con clearfix">'+
        '<a class="logo-a" href="javascript:void(0)"><img src="../img/logo.png" alt="logo"></a>'+
        '<div class="fr pr">'+
        //                        '<a href="../page/messageList.html" class="pr">消息<b class="pa msg dis-n"></b></a>'+
        '<img class="user" src="" alt="头像">'+
        '<ul class="pa tc dis-n">'+
        '<li class="is-certified-li"><a href="../page/companyInfo.html">公司信息</a></li>'+
        //                            '<li class="is-certified-li"><a href="../page/personInfo.html">经办人信息</a></li>'+
        //                            '<li class="is-certified-li"><a href="../page/consigneeList.html">提货人信息</a></li>'+
        //                            '<li class="is-certified-li"><a href="../page/personCenter.html">个人中心</a></li>'+
        //                            '<li><a href="../page/modify.html">设置</a></li>'+
        '<li><a id="out-login" href="#">退出</a></li>'+
        '</ul>'+
        '</div>'+
        '</div>';
    $('.headers').append(menuHtml);

    /*hover人物头像显示隐藏下拉菜单*/
    var imgUser = $('.headers img.user');
    var ulMenu = $('.headers ul.pa');
    imgUser.attr('src', userImg);
    imgUser.on('click', function (e) {
        if($(ulMenu).is(':hidden')){
            $(ulMenu).show(200);
        }else{
            $(ulMenu).hide(200);
        }
        $(document).one('click', function () {//点击任意一个地方 隐藏下拉菜单
            $(ulMenu).hide(200);
        });

        e.stopPropagation();
    });
    $(ulMenu).on('click', function (e) {
        if(e.target.id != 'out-login'){
            e.stopPropagation();
        }else{
            $.ajax({
                type: 'POST',
                url: '/company/logOut',
                success: function (data) {
                    console.log(data);
                    if(data && 200 == data.code){
                        window.location = '../login.html';
                    }else{
                        layer.msg(data.message);
                        return;
                    }
                },
                error: function (err) {
                    layer.msg(err);
                }
            });
        }
    });

    /*退出登录*/
    function clearCookie() {//删除所有的cookie
        $.cookie('access-token', null, {expires: -1, path: '/html'});
        $.cookie('headImgUrl', null, {expires: -1, path: '/html'});
    }


    /*获取当前url的路径*/
    clickLogoUrlPrev();

    /*点击logo返回上一页*/
    /*$('.headers').on('click', '.logo-a', function () {
        var str = window.location.pathname;
        var pathUrl = str.math(/(\w+)\.html/)[1];
        alert(rex.exec(s));
        //window.history.back(-1);
    });*/

    /*3分钟间隔显示未读消息*/
    unreadMessage();
    function unreadMessage() {
        $.ajax({
            type: 'POST',
            url: '/user/getNoticeMessageByPage',
            headers: {
                'access-token': commontUtil.getToken()
            },
            data: {
                isRead: false,
                pageNo: 1,
                pageSize: 2
            },
            success: function (data) {
                console.log(data);
                if(data && 200 == data.code){
                    var listLen = data.data.list.length;
                    if(listLen > 0){
                        $('b.msg').show();
                    }else{
                        $('b.msg').hide();
                    }
                }
            },
            error: function (err) {
                layer.msg(err);
            }
        });
    }
    setInterval(unreadMessage, 1000*180);


    /*验证是否认证动态显示菜单*/
    function isCertified(){
        $.ajax({
            type: 'POST',
            url: '/company/isCompanyAndPersonAuth',
            headers: {
                'access-token': commontUtil.getToken()
            },
            success: function (data) {
                console.log(data);
                if(data && 200 == data.code){
                    var $data = data.data;
                    if(!$data.isCompanyAuth || ! $data.isPersonAuth){
                        //$('a.logo-a').attr('href', 'javascript:void(0)').css('cursor', 'default');
                        $('li.is-certified-li').hide();
                    }else{
                        //$('a.logo-a').attr('href', '../page/personCenter.html').css('cursor', 'pointer');
                        $('li.is-certified-li').show();
                    }
                }
            },
            error: function (err) {
                layer.msg(err);
            }
        });
    }

    /*动态点击logo返回上一页*/
    function clickLogoUrlPrev() {
        var url = commontUtil.getUrlSuffix();
        if(url == 'messageList' || url == 'modify'){
            $('.logo-a').attr('onclick', 'window.history.back(-1)');
        }else{
            $('.logo-a').css('cursor', 'default');
        }
    }
});