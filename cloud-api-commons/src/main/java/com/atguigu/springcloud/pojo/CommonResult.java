package com.atguigu.springcloud.pojo;


/**
 * @ClassName CommonResult
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:07
 * @Version V1.0
 **/
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResult() {
    }

    public  CommonResult(Integer code, String msg){
        this(code,msg,null);
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
