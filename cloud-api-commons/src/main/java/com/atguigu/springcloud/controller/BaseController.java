package com.atguigu.springcloud.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;

/**
 * @author hc
 * @version V1.0
 * @title BaseController.java
 * @package com.xiye.common.controller
 * @description 父controller
 * @date 2019-05-11
 */
public class BaseController {



    /**
     * @Author hc
     * @Date 2019-05-11 09:52:21
     * @Description 得到request对象
     * @Param []
     * @Return javax.servlet.http.HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * @Author hc
     * @Date 2019-05-11 09:52:31
     * @Description 得到32位的uuid
     * @Param []
     * @Return java.lang.String
     */
    public String get32Uuid() {
        return UUID.randomUUID().toString().trim().replace("-", "");
    }
}
