package com.haohao.constant;

/**
 * @Desc 机构相关常量
 * @Author xiekunliang
 * @Date 2018/5/16 17:36
 */
public interface AgencyConstant {

    /**
     * 机构是否可用
     */
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

    /**
     * 机构方法是否可用
     */
    interface MethodEnable {
        /**
         * 可用
         */
        Integer NORMAL = 0;

        /***
         * 禁用
         */
        Integer FORBIDDEN = 1;
    }

}
