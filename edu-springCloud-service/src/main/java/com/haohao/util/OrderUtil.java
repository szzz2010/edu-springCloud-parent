package com.haohao.util;

import java.util.Date;

import com.haohao.util.springTools.springJdbc.helper.UuidHelper;

/**
 * 订单号生成
 *
 * @Author:rienchou
 * @Date: 2018/5/21 15:52
 */
public class OrderUtil {

    /**
     * FaceId 订单号
     *
     * @Author:rienchou
     * @Date: 2018/5/21 15:52
     */
    public static String getFaceIdOrderNo() {
        return "FaceId" + DateUtils.formatDate(new Date(), "yyyyMMddHHmmss") + OrderUtil.getRandom();
    }


    /**
     * 阿里支付订单号
     *
     * @Author:rienchou
     * @Date: 2018/5/21 15:53
     */
    public static String getAliPayOrderNo() {
        return "AliPay" + DateUtils.formatDate(new Date(), "yyyyMMdd") + OrderUtil.getRandom();
    }

    /**
     * 生成借款订单
     *
     * @Author:rienchou
     * @Date: 2018/5/21 15:55
     */
    public static String getBorrowOrderNo(int company_id) {
        return "JZ"+company_id+"QY" + DateUtils.formatDate(new Date(), "yyyyMMdd") + UuidHelper.get4UUID();
    }


    /**
     * 生成随机四位数
     *
     * @Author:rienchou
     * @Date: 2018/5/21 15:57
     */
    private static String getRandom() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }
}
