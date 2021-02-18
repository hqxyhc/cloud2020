package com.atguigu.springcloud.pojo;


import java.io.Serializable;

/**
 * @ClassName Payment
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:05
 * @Version V1.0
 **/


public class Payment implements Serializable {
    private long id;
    private String serial;

    public Payment() {
    }

    public Payment(long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
