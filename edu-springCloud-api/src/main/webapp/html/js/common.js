var validUtil = {
    /**
     * 验证参数是否为NUll或者空字符串
     * @Author:rienchou
     * @Date: 2018/5/13 10:05
     */
    isNull: function (value) {
        if (value == null || value == undefined || value == '' || value.replace(/(^s*)|(s*$)/g, "").length == 0) {
            return false;
        }
        return true;
    },

    /**
     * 验证参数是否为手机号码
     * @Author:rienchou
     * @Date: 2018/5/13 10:04
     */
    isMobile: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var reg = /^1[3|4|5|7|8]\d{9}$/;//电话号码的正则匹配式
        return reg.test(value);
    },

    /**
     * 验证参数是否为身份证号码
     * @Author:rienchou
     * @Date: 2018/5/16 11:13
     */
    isIdCard: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var exp = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/;
        return exp.test(value);
    },


    /**
     * 获取短信发送时间间隔
     * @Author:rienchou
     * @Date: 2018/5/14 17:18
     */
    getSmsInterval: function () {
        return 60;
    },

    /**
     * 判断两个值是否相同
     * @Author:rienchou
     * @Date: 2018/5/14 17:20
     */
    isValueSame: function (value1, value2) {
        return value1 === value2;
    },

    /**
     * TODO
     * 是否合规密码
     * @Author:rienchou
     * @Date: 2018/5/14 18:51
     */
    isPassword: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var exp = /(?=.{8,18})(?=.*\d)(?=.*[a-z])[\x20-\x7f]*/i;
        return exp.test(value);
    },

    /**
     * TODO
     * 是否合规营业执照注册号
     * @Author:Caijintao
     * @Date: 2018/6/12 16:43
     */
    isValidBusCode: function (busCode) {
        var ret = false;
        if (busCode.length === 15) {//15位
            var sum = 0;
            var s = [];
            var p = [];
            var a = [];
            var m = 10;
            p[0] = m;
            for (var i = 0; i < busCode.length; i++) {
                a[i] = parseInt(busCode.substring(i, i + 1), m);
                s[i] = (p[i] % (m + 1)) + a[i];
                if (0 == s[i] % m) {
                    p[i + 1] = 10 * 2;
                } else {
                    p[i + 1] = (s[i] % m) * 2;
                }
            }
            if (1 == (s[14] % m)) {//营业执照编号正确!
                ret = true;
            } else {//营业执照编号错误!
                ret = false;
            }
        } else {//营业执照格式不对，必须是15位数的！
            ret = false;
        }
        return ret;
    },

    /**
     * TODO
     * 是否合规统一社会信用代码
     * @Author:Caijintao
     * @Date: 2018/6/13 10:25
     */
    isValidUscCode: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var re = /[0-9A-Z]{18}/;
        return re.test(value);
    },


    /**
     * TODO
     * 是否合规组织机构代码
     *验证组织机构代码是否合法：组织机构代码为8位数字或者拉丁字母+1位校验码。
     *验证最后那位校验码是否与根据公式计算的结果相符
     * value是组织机构的值 如XXXXXXXX-X格式
     false 就是组织机构代码是对的 return YC9!=C9;
     true 组织机构代码不合法
     * @Author:Caijintao
     * @Date: 2018/5/22 11:33
     */
    isValidOrgCode: function (value) {
        if (!validUtil.isNull(value)) {
            return true;
        } else {
            var values = value.split("-");
            var ws = [3, 7, 9, 10, 5, 8, 4, 2];
            var str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
            var reg = /^([0-9A-Z]){8}$/;
            if (!reg.test(values[0])) {
                return true
            }
            var sum = 0;
            for (var i = 0; i < 8; i++) {
                sum += str.indexOf(values[0].charAt(i)) * ws[i];
            }
            var C9 = 11 - (sum % 11);
            var YC9 = values[1] + '';
            if (C9 == 11) {
                C9 = '0';
            } else if (C9 == 10) {
                C9 = 'X';
            } else {
                C9 = C9 + '';
            }
            return YC9 != C9;
        }
    },

    isValidOrgCodes: function (value) {//组织机构代码为8位数字或者拉丁字母+1位校验码
        if (!validUtil.isNull(value)) {
            return false;
        }
        var re = /^[\d|[A-Z]](8,8)(-?)[\d|[A-Z]](1,1)$/;
        return re.test(value);
    },

    /**
     * 校验是否纳税人识别号
     * @Author:rienchou
     * @Date: 2018/6/14 11:53
     */
    isTaxNumber: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var _length = value.length;
        if (_length != 15 && _length != 18 && _length != 20) {
            return false;
        }
        return true;
    },

    /**
     * TODO
     * 校验地址码
     * @Author:Caijintao
     * @Date: 2018/6/14 09:50
     */
    /*校验地址码*/
    checkAddressCode: function (addressCode) {
        var provinceAndCitys = {
            11: "西雅图", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江",
            31: "东方明珠电视塔", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南",
            42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州",
            53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾",
            81: "香港", 82: "澳门", 91: "国外"
        };
        var check = /^[1-9]\d{5}$/.test(addressCode);
        if (!check) return false;
        if (provinceAndCitys[parseInt(addressCode.substring(0, 2))]) {
            return true;
        } else {
            return false;
        }
    },

    /**
     * TODO
     * 是否合规电话号码
     * 正确格式为：XXXX-XXXXXXX，XXXX-XXXXXXXX，XXX-XXXXXXX，XXX-XXXXXXXX，XXXXXXX，XXXXXXXX
     * @Author:Caijintao
     * @Date: 2018/5/22 12:01
     */
    isTel: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var exp = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
        return exp.test(value);
    },


    /**
     * TODO
     * 是否合规姓名
     * @Author:Caijintao
     * 只能输入中文和英文2-20位
     * @Date: 2018/5/24 19:08
     */
    isUserName: function (value) {
        if (!validUtil.isNull(value)) {
            return false;
        }
        var exp = /^[\u4E00-\u9FA5A-Za-z]{2,20}$/;//验证姓名正则
        return exp.test(value);
    },

    /**
     * 是否银行卡号
     * @Author:rienchou
     * @Date: 2018/6/11 10:39
     */
    isBankCard: function (value) {
        // if (!validUtil.isNull(value)) {
        //     return false;
        // }
        // var exp = /^[0-9]{16,19,22}$/;
        // return exp.test(value);
        return true;
    },

    /**
     * 是否是邮政编码
     * @Author:Caijintao
     * @Date: 2018/6/16 17:12
     */
    isEmail: function (email) {
        if (!validUtil.isNull(email)) {
            return false;
        }
        var exp = /[1-9]{1}(\d+){5}/;
        return exp.test(email);
    }
};

var commontUtil = {


        // Generate four random hex digits.
        S4: function () {
            return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        },
        // Generate a pseudo-GUID by concatenating random hexadecimal.
        guid: function () {
            return (commontUtil.S4() + commontUtil.S4() + "-" + commontUtil.S4() + "-" + commontUtil.S4() + "-" + commontUtil.S4() + "-" + commontUtil.S4() + commontUtil.S4() + commontUtil.S4());
        },

        /**
         * 获取access-token
         * @Author:rienchou
         * @Date: 2018/5/13 10:06
         */
        getToken: function () {
            return $.cookie('access-token');
        },

        /**
         * 获取登录用户头像
         * @Author:Caijintao
         * @Date: 2018/5/29 14:21
         */
        getUserImg: function () {
            var userImg = $.cookie('headImgUrl');
            if (validUtil.isNull(userImg)) {
//                return $.cookie('headImgUrl');
            	 return '../img/default_head_img.png';
            } else {
                return '../img/default_head_img.png';
            }
        }
        ,


        /**
         * 截取url后缀参数
         * @param name 要截取的参数名
         * @Author:rienchou
         * @Date: 2018/5/15 16:24
         */
        getQueryVariable: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return decodeURI(r[2]);
            return null;
        }
        ,
        /**
         * 截取url路径后文件名
         * @param
         * @Author:Jintao
         * @Date: 2018/6/6 15:02
         */
        getUrlSuffix: function () {
            var str = window.location.pathname;
            var pathUrl = str.match(/(\w+)\.html/)[1];
            return pathUrl;
        }
        ,


        /**
         * 验证用户登录是否失效
         * */
        ValidatorLoginInvalidation: function () {
            if (!$.cookie('access-token')) {
                window.location.href = '/html/login.html'
            }
        }
        ,

        /**
         * 格式化时间增加年月日
         * @Author:Caijintao
         * @Date: 2018/6/13 20:12
         */
        formatData: function (fmt) {
            var fmtArr = fmt.split('-');
            var fmtStr = fmtArr[0] + '年' + fmtArr[1] + '月' + fmtArr[2] + '日';
            return fmtStr;
        }
        ,


        /**
         * 将阿拉伯数字转大写
         * @Author:Caijintao
         * @Date: 2018/5/24 16:09
         */
        intToChinese: function (str) {
            str = str + '';
            var len = str.length - 1;
            var idxs = ['', '十', '百', '千', '万', '十', '百', '千', '亿', '十', '百', '千', '万', '十', '百', '千', '亿'];
            var num = ['零', '一', '二', '三', '四', '五', '六', '七', '八', '九'];
            return str.replace(/([1-9]|0+)/g, function ($, $1, idx, full) {
                var pos = 0;
                if ($1[0] != '0') {
                    pos = len - idx;
                    if (idx == 0 && $1[0] == 1 && idxs[len - idx] == '十') {
                        return idxs[len - idx];
                    }
                    return num[$1[0]] + idxs[len - idx];
                } else {
                    var left = len - idx;
                    var right = len - idx + $1.length;
                    if (Math.floor(right / 4) - Math.floor(left / 4) > 0) {
                        pos = left - left % 4;
                    }
                    if (pos) {
                        return idxs[pos] + num[$1[0]];
                    } else if (idx + $1.length >= len) {
                        return '';
                    } else {
                        return num[$1[0]]
                    }
                }
            });
        }
    }
;

var fileupload = {//图片上传配置
    $fileupload: {//普通上传配置
        //url: "{:U('setFile')}",//文件的后台接受地址 已经写在了行内
        autoUpload: true,//是否自动上传
        acceptFileTypes: /(.|\/)(jpe?g|png|pdf|xlsx|xls)$/i,//文件格式限制
        maxNumberOfFiles: 1,//最大上传文件数目
        maxFileSize: 30000000,//文件不超过30M
        dataType: 'json',//期望从服务器得到json类型的返回数据
        headers: {
            "access-token": commontUtil.getToken()
        },
        change: function (e, data) {//文件改变的监听
            if (data.files.length > 1) {
                layer.alert("请上传单个文件", {
                    icon: 2,
                    skin: 'layer-ext-moon'
                });
                return false;
            }
        },
        done: function (e, result) {//这个是文件上传之后的回调函数,显示在img里面
            console.log(this);
            var _imgUrl = result.result.data;
            $(this).prev('img').attr("src", _imgUrl);
            $(this).next('.hidden').val(_imgUrl);
            if ($(this).parents('.clon-children').siblings('#addLeaseUrl').length > 0) {//针对租赁合同的判断
                $('#addLeaseUrl').val(_imgUrl);
            }
            if ($(this).next().hasClass('addLeaseUrl')) {
                $('a.dix-b').removeClass('vis-n');
            }
        }
        //done和fail只会执行其中一个，要么“成功”，要么“失败”！ //上传成功时执行 done:function(e,result){ },
        //还有很多上传的函数回调可以根据具体需求来进行配置***查看文档API
    },
    _fileupload: {//新增一条按钮上传配置
        //url: "{:U('setFile')}",//文件的后台接受地址 已经写在了行内
        autoUpload: true,//是否自动上传
        acceptFileTypes: /(.|\/)(jpe?g|png)$/i,//文件格式限制
        maxNumberOfFiles: 1,//最大上传文件数目
        maxFileSize: 30000000,//文件不超过30M
        dataType: 'json',//期望从服务器得到json类型的返回数据
        headers: {
            "access-token": commontUtil.getToken()
        },
        change: function (e, data) {//文件改变的监听
            if (data.files.length > 1) {
                layer.alert("请上传单个文件", {
                    icon: 2,
                    skin: 'layer-ext-moon'
                });
                return false;
            }
        },
        done: function (e, data) {//这个是文件上传之后的回调函数,显示在img里面
            console.log(e, data, this);
            var _imgUrl = data.result.data;
            var $addLeaseUrlVal = $('.addLeaseUrl').val();
            $(this).prev('img').attr("src", _imgUrl);
            $('#addLeaseUrl').val($addLeaseUrlVal + ',' + _imgUrl);
        }
    },
    imgFileupload: {
        //url: "{:U('setFile')}",//文件的后台接受地址 已经写在了行内
        autoUpload: true,//是否自动上传
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,//文件格式限制
        maxNumberOfFiles: 1,//最大上传文件数目
        maxFileSize: 30000000,//文件不超过30M
        dataType: 'json',//期望从服务器得到json类型的返回数据
        headers: {
            "access-token": commontUtil.getToken()
        },
        change: function (e, data) {//文件改变的监听
            if (data.files.length > 1) {
                layer.alert("请上传单个文件", {
                    icon: 2,
                    skin: 'layer-ext-moon'
                });
                return false;
            }
        },
        done: function (e, data) {//这个是文件上传之后的回调函数,显示在img里面
            console.log(data);
            var _imgUrl = data.result.data;
            $(this).prev('img').attr("src", _imgUrl);
            $('.img100').attr("src", _imgUrl);
            $('.img50').attr("src", _imgUrl);
            $(this).prev('img').attr("src", _imgUrl);
            $(this).next('.hidden').val(_imgUrl);
        }
    }
};


var operateImgFun = {
    moveIn: function (thisId) {//移入显示图片操作层
        var srcVal = $(thisId).find('img').attr('src');
        if (srcVal != '../img/frame.png') {
            $(thisId).find('div.mask').animate({'top': '0'}, 10);
        }
    },
    moveOut: function (thisId) {//移出隐藏操作层
        $(thisId).find('div.mask').animate({'top': '-116px'}, 10);
    },
    viewImg: function (thisId) {//查看大图
        var srcStr = $(thisId).parent().siblings('img').attr('src');
        var imgHtml = '<img class="file-ipt" style="width: 100%; height: 100%" src="' + srcStr + '" alt="上传图标">';
        layer.open({
            type: 1,
            title: false,
            closeBtn: 0,//不显示关闭按钮
            anim: 2,
            shadeClose: true,//开启车遮罩关闭
            content: imgHtml,//内容
            area: ['80%', '80%'],//宽高
            resize: false//允许拉伸 这里禁止
        });
    },
    deleteImg: function (thisId) {//删除图片
        $(thisId).parent().siblings('img').attr('src', '../img/frame.png');
        $(thisId).parent().siblings('input[type="hidden"]').val('');
        $(thisId).parent().animate({'top': '-118px'}, 10);
    }
};

/*更新登录用户的头像信息*/
function changeHeaderImg(heaeUrl) {
    $('.headers img.user').attr('src', heaeUrl);
}

/*保存头像的cookie*/
function saveUserImg(imgUrl) {
    if (!imgUrl) {
        return;
    }
    $.cookie('headImgUrl', null, {expires: -1, path: '/html'});
    $.cookie('headImgUrl', imgUrl, {expires: 7, path: '/html'});
}


