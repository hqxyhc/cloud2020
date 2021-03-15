package com.atguigu.springcloud.pojo;



import java.io.Serializable;

/**
 * @author hc
 * @version V1.0
 * @title ReflectHelper.java
 * @package com.xiye.common.util
 * @description 数据返回实体
 * @date 2018-07-23
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态
     */
    private Boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据对象，transient序列化中忽略该字段
     */
    private transient Object resultData;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * @Author hc
     * @Date 2019-05-09 09:28:01
     * @Description 无参构造器
     * @Param []
     * @Return
     */
    public Result() {
        super();
    }

    /**
     * @Author hc
     * @Date 2019-05-09 09:28:29
     * @Description 只返回状态，状态码，数据对象
     * @Param [success, code, result]
     * @Return
     */
    public Result(Boolean success, Integer code, Object result) {
        super();
        this.success = success;
        this.code = code;
        this.resultData = result;
    }

    /**
     * @Author hc
     * @Date 2019-05-09 09:31:52
     * @Description 返回全部信息即状态，状态码，消息，数据对象
     * @Param [success, code, massege, result]
     * @Return
     */
    public Result(Boolean success, Integer code, String message, Object result) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
        this.resultData = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
