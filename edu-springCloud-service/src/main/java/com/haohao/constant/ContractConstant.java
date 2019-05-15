package com.haohao.constant;

/**
 * @Desc 额度包状态
 * @Author xiekunliang
 * @Date 2018/5/16 17:01
 */
public interface ContractConstant {


    interface Enable {
        /**
         * 可用
         */
        Integer NORMAL = 0;

        /***
         * 禁用
         */
        Integer FORBIDDEN = 1;
    }

    interface Status {

        /**
         * 待推送（创建成功但未推送的额度包）
         */
        Integer CREATED = 0;

        /**
         * 使用中（已推送至资产机构且正在使用中的额度包）
         */
        Integer USEING = 1;

        /**
         * 已失效（已推送至资产机构但已过额度有效期）
         */
        Integer INVALID = 2;

        /**
         * 已结束（推送至资产机构，正常将额度包内额度使用完毕）
         */
        Integer NORMAL_END = 3;
    }

}
