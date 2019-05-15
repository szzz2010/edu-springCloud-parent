package com.haohao.util.springTools.redis;

public class RedisKey {

    public static final String TIANTIAN_SMS_KEY = "jz:haohao:qiye:sms:%1$s";

    public static String keyFormatter(String key, String element) {
        String regex = "(\\$\\{).*(\\})";
        return key.replaceAll(regex, element);
    }

    public static String formatter(String key, String... element) {
        if (0 != element.length && null != element) {
            return String.format(key, (Object[]) element);
        }
        return key;
    }

}
