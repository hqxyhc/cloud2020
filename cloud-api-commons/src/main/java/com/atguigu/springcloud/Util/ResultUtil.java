package com.atguigu.springcloud.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.atguigu.springcloud.pojo.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.xiye.common.util
 * @Description 前后端交互数据标准
 * @Author hc
 * @Date 2018-08-07
 * @Version V1.0
 */
public final class ResultUtil {

    private ResultUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @Author hc
     * @Date 2019-05-11 14:44:34
     * @Description 返回json字符串
     * @Param [b, code, message, map]
     * @Return java.lang.Object
     */
    public static Object setrowbackresutJson(boolean b, Integer code, String message, Map<String, Object> map) {
        Result result = new Result();
        result.setSuccess(b);
        result.setMessage(message);
        result.setCode(code);
        result.setResultData(map);
        TypeUtils.compatibleWithJavaBean = true;
        return JSON.toJSONString(result, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * @Author hc
     * @Date 2019-05-11 14:44:37
     * @Description 返回实体，用以配合swagger2展示数据显示
     * @Param [b, code, message, map]
     * @Return com.xiye.common.entity.result.Result
     */
    public static Result setrowbackresutEntity(boolean b, Integer code, String message, Map<String, Object> map) {
        Result result = new Result();
        result.setSuccess(b);
        result.setMessage(message);
        result.setCode(code);
        result.setResultData(map);
        return result;
    }

    public static String build(Boolean flag, int code, String message) {
        Map<String, Object> map = new HashMap<>(com.xiye.common.util.Const.MAP_NUMBER);
        Result result = new Result();
        result.setSuccess(flag);
        result.setMessage(message);
        result.setCode(code);
        result.setResultData(map);
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }

    public static String build(Boolean flag, int code, String message, JSONArray map) {
        Result result = new Result();
        result.setSuccess(flag);
        result.setMessage(message);
        result.setCode(code);
        result.setResultData(map);
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }


    public static String build(Boolean flag, int code, String message, Map data) {
        Result result = new Result();
        result.setSuccess(flag);
        result.setMessage(message);
        result.setCode(code);
        result.setResultData(data);
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }
}
