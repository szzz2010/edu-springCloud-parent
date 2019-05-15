package com.haohao.util;

import com.github.pagehelper.Page;

import java.util.HashMap;


public class QMap extends HashMap<String, Object> {

    private static final long serialVersionUID = 8662412321501581279L;

    public static QMap success(Page page) {
        return success().put("total", page.getTotal()).put("rows", page.getResult());
    }

    public static QMap success(Object object) {
        return success().put("data", object);
    }

    public static QMap success() {
        return new QMap().put("success", true).put("message", "操作成功");
    }

    public static QMap error(String message) {
        return new QMap().put("success", false).put("message", message).put("error", message);
    }

    public static QMap error(Integer code, String message) {
        return error(message).put("code", code);
    }

    @Override
    public QMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
