package com.haohao.util.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description：学习批次号</p>
 * @date 2018年5月17日 下午1:54:39
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class BatchNoUtil {
	
	private static AtomicInteger ORDER_SERIAL_NUM=new AtomicInteger(0);
    private static int getOrderSerialNum(){
        int serial=ORDER_SERIAL_NUM.getAndIncrement();
        if(serial>9){
            ORDER_SERIAL_NUM.set(0);
            serial=ORDER_SERIAL_NUM.getAndIncrement();
        }
        return serial;
    }

    public static String createApplyCode(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static String createDealCode() {
        return "B"+ new SimpleDateFormat(DateUtil.YYYYMMDDHHMMSSSSS).format(new Date()) + getOrderSerialNum();
    }

}
