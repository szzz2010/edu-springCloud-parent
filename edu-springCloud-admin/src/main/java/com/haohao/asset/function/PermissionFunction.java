package com.haohao.asset.function;

import org.springframework.stereotype.Component;

import com.haohao.asset.utils.SessionUtil;
import com.haohao.util.LogUtil;
@Component
public class PermissionFunction {

    /**
     * 判断按钮是否有权限
     * @author:abner
     * @param buttonCode 按钮编码
     * @return boolean
     */
    public static boolean hasPermission(String buttonCode) {
        try {
            if (SessionUtil.isButtonCode(buttonCode)) {
                return true;
            }
        } catch (Exception e) {
            LogUtil.pringExceptionLog("按钮权限判断失败",e);
        }
        return false;
    }
}
