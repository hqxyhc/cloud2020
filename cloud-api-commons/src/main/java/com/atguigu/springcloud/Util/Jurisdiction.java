//package com.xiye.common.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.util.TypeUtils;
//import com.xiye.common.entity.User;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.session.Session;
//
///**
// * @author hc
// * @version V1.0
// * @title Jurisdiction.java
// * @package com.xiye.common.util
// * @description 权限处理
// * @date 2018-07-11
// */
//public class Jurisdiction {
//
//    private Jurisdiction() {
//        throw new IllegalStateException("Utility class");
//    }
//
//    /**
//     * @Author hc
//     * @Date 2018-06-22 09:06:06
//     * @Description 获取当前登录的用户名
//     * @Param []
//     * @Return java.lang.String
//     */
//    public static String getUsername() {
//        return getSession().getAttribute(com.xiye.common.util.Const.SESSION_USERNAME).toString();
//    }
//
//    /**
//     * @Author hc
//     * @Date 2018-06-22 09:06:06
//     * @Description 获取当前登录的用户姓名
//     * @Param []
//     * @Return java.lang.String
//     */
//    public static String getuName() {
//        return getSession().getAttribute(com.xiye.common.util.Const.SESSION_U_NAME).toString();
//    }
//
//    /**
//     * @Author hc
//     * @Date 2018-06-22 09:06:06
//     * @Description shiro管理的session
//     * Subject currentUser = SecurityUtils.getSubject();
//     * @Param []
//     * @Return org.apache.shiro.session.Session
//     */
//    public static Session getSession() {
//        return SecurityUtils.getSubject().getSession();
//    }
//
//    /**
//     * @Author hc
//     * @Date 2018-06-22 16:57:22
//     * @Description 获取session中的用户信息
//     * @Param []
//     * @Return com.xiye.common.entity.User
//     */
//    public static User getUser(String sessionUser) {
//        TypeUtils.compatibleWithJavaBean = true;
//        return JSON.parseObject(JSON.toJSONString(Jurisdiction.getSession().getAttribute(sessionUser)), User.class);
//    }
//
//}
