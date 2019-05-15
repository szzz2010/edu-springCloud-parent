package com.haohao.pojo.vo;

import com.haohao.util.tools.MD5Util;

/**
 * 好好借道短信Vo
 *
 * @author rienchou
 * @ClassName: SmsVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年4月30日
 */
public class TianTianSmsVo extends BaseVo {
    // 接口地址：http://sms.haohao.sanwenqian.cn/sms/send
    // 请求方式：post
    // 请求参数
    // 序号 字段名称 接口字段 数据类型 是否可空 说明
    // 1 手机号 mobiles String N 多个手机号以;隔开；发送验证码只能输入一个手机号
    // 2 短信前缀 sign Number N 固定值：1；代表【好好借道】放在短信内容前面
    // 3 短信类型 type Number N 取值1或者2；1：验证码 2：其他
    // 4 短信内容 content String N
    // 5 签名 signature String N md5签名，加密内容：mobiles.subString(0,11)+"sanwenqian"+type
    //
    // 返回参数
    // 序号 字段名称 接口字段 数据类型 是否可空 说明
    // 响应编码 code String N 00000：请求成功；10007：请求失败
    // 响应信息 msg String N code取值00000时返回请求成功，code取值10007时返回失败原因

    private static final long serialVersionUID = 1L;
    private String mobiles;
    private int sign;
    private int type;
    private String content;
    private String signature;

    public TianTianSmsVo() {
        super();
    }

    /**
     * 验证类型短信构造函数
     *
     * @Author:rienchou
     * @Date: 2018/5/8 10:52
     */
    public TianTianSmsVo(String mobiles, int type) {
        this.mobiles = mobiles;
        this.type = type;
        this.signature = MD5Util.digest(mobiles.substring(0, 11) + "sanwenqian" + type);
    }

    public TianTianSmsVo(String mobiles, int type, String content) {
        super();
        this.mobiles = mobiles;
        this.sign = 1;
        this.type = type;
        this.content = content;
        this.signature = MD5Util.digest(mobiles.substring(0, 11) + "sanwenqian" + type);
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "SmsVo [mobiles=" + mobiles + ", sign=" + sign + ", type=" + type + ", content=" + content + ", signature=" + signature + "]";
    }
}
