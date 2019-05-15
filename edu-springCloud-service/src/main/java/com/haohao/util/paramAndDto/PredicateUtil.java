package com.haohao.util.paramAndDto;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

/**
 * @Desc 表达式检查工具
 * @Author xiekunliang
 * @Date 2018/5/9 17:48
 */
public class PredicateUtil {

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
        if (object instanceof Number) {
            return;
        }
        if (object instanceof String) {
            String str = (String) object;
            if (StringUtils.isBlank(str.trim())) {
                throw new IllegalArgumentException(message);
            }
            return;
        }
        if (object instanceof Collection) {
            Collection c = (Collection) object;
            if (c.isEmpty()) {
                throw new IllegalArgumentException(message);
            }
            return;
        }
        if (object instanceof Map) {
            Map map = (Map) object;
            if (map.isEmpty()) {
                throw new IllegalArgumentException(message);
            }
            return;
        }
        if (object.getClass().isArray()) {
            if (Array.getLength(object) == 0) {
                throw new IllegalArgumentException(message);
            }
            return;
        }
    }

    public static void notNull(Object object) {
        notNull(object, "the object argument must not be null");
    }


    public static void argument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }
}
