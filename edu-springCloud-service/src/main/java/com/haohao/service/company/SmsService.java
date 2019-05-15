package com.haohao.service.company;
//package com.haohao.service.company;
//
//import com.alibaba.fastjson.JSON;
//import com.haohao.config.redis.RedisClientTemplate;
//import com.haohao.config.redis.RedisKey;
//import com.haohao.pojo.vo.TianTianResVo;
//import com.haohao.pojo.vo.TianTianSmsVo;
//import com.haohao.util.tools.HttpClientUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SmsService {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    // 短信发送成功code
//    private static final String SMS_SEND_SUCCESS = "00000";
//
//    // 短信接口
//    @Value("${sms.url}")
//    private String url;
//
//    // 短信内容
//    private String sms_notice_content = "您的短信验证码为:%s,有效期为10分钟";
//
//    // 短信超时时间
//    private static final int VALID_TIME = 600;
//
//    @Autowired
//    private RedisClientTemplate redisClientTemplate;
//
//
//    /**
//     * 发送短信
//     *
//     * @Author:rienchou
//     * @Date: 2018/5/7 20:15
//     */
//    public Boolean sendSms(TianTianSmsVo smsVo) {
//        // 发送短信
//        String smsCode = getSmsCode();
//        smsVo.setContent(String.format(sms_notice_content, smsCode));
//        String doPostJson = HttpClientUtil.doPostJson(url, JSON.toJSONString(smsVo));
//        TianTianResVo parseObject = JSON.parseObject(doPostJson, TianTianResVo.class);
//        // 短信验证码缓存至redis
//        if (parseObject.getCode().equals(SMS_SEND_SUCCESS)) {
//            String key = RedisKey.formatter(RedisKey.TIANTIAN_SMS_KEY, smsVo.getMobiles());
//            redisClientTemplate.setex(key, VALID_TIME, smsCode);
//            return Boolean.TRUE;
//        } else {
//            logger.error("短信发送失败:mobiles{}", smsVo.getMobiles());
//            return Boolean.FALSE;
//        }
//    }
//
//    /**
//     * 校验短信验证码
//     *
//     * @param mobile
//     * @return
//     */
//    public Boolean validSms(String mobile, String smsCode) {
//        String keyVal = redisClientTemplate.get(RedisKey.formatter(RedisKey.TIANTIAN_SMS_KEY, mobile));
//        if (StringUtils.isBlank(keyVal) || !keyVal.equals(smsCode)) {
//            return Boolean.FALSE;
//        }
//        return Boolean.TRUE;
//    }
//
//
//    /**
//     * 校验短信验证码
//     *
//     * @param mobile
//     * @return
//     */
//    public String getSmsCode(String mobile) {
//        return redisClientTemplate.get(RedisKey.formatter(RedisKey.TIANTIAN_SMS_KEY, mobile));
//    }
//
//
//    /**
//     * 获取随机短信验证码
//     *
//     * @return
//     */
//    private final String getSmsCode() {
//        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
//    }
//
//}
