package com.xiye.common.util;

import java.lang.reflect.Field;

/**
 * @author hc
 * @version V1.0
 * @title ReflectHelper.java
 * @package com.xiye.common.util
 * @description 反射工具
 * @date 2019-05-19
 */
public final class ReflectHelper {

    private ReflectHelper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @Author hc
     * @Date 2019-05-19 16:31:58
     * @Description 获取obj对象fieldName的Field
     * @Param [obj, fieldName]
     * @Return java.lang.reflect.Field
     */
    public static Field getFieldByFieldName(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                LoggerUtil.info("");
            }
        }
        return null;
    }

    /**
     * @Author hc
     * @Date 2019-05-19 16:32:09
     * @Description 获取obj对象fieldName的属性值
     * @Param [obj, fieldName]
     * @Return java.lang.Object
     */
    public static Object getValueByFieldName(Object obj, String fieldName) throws IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            field.setAccessible(true);
            value = field.get(obj);
            field.setAccessible(false);
        }
        return value;
    }

    /**
     * @Author hc
     * @Date 2019-05-19 16:32:18
     * @Description 设置obj对象fieldName的属性值
     * @Param [obj, fieldName, value]
     * @Return void
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
        field.setAccessible(false);
    }
}
