//package com.xiye.common.util;
//
//import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
//
///**
// * @author hc
// * @version V1.0
// * @title JasyptUtil.java
// * @package com.xiye.common.util
// * @description Java配置文件加密解密
// * 加密
// * System.out.println("加密：" + encyptPwd("xiye", "wenwen"));
// * 解密
// * System.out.println("解密：" + decyptPwd("xiye", "1uy6gf6ZnZnjy8l/qEWWLQ=="));
// * @date 2018-07-17
// */
//@SuppressWarnings("ALL")
//public class JasyptUtil {
//
//    private JasyptUtil() {
//        throw new IllegalStateException("Utility class");
//    }
//
//    /**
//     * @Author hc
//     * @Date 2018-07-17 10:01:56
//     * @Description Jasypt生成加密结果;配置文件中设定的加密密码;value 待加密值
//     * @Return java.lang.String
//     */
//    public static String encyptPwd(String password, String value) {
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        encryptor.setConfig(cryptor(password));
//        return encryptor.encrypt(value);
//    }
//
//    /**
//     * @Author hc
//     * @Date 2018-07-17 10:02:30
//     * @Description 解密;配置文件中设定的加密密码;value 待解密密文
//     * @Return java.lang.String
//     */
//    public static String decyptPwd(String password, String value) {
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        encryptor.setConfig(cryptor(password));
//        return encryptor.decrypt(value);
//    }
//
//    public static SimpleStringPBEConfig cryptor(String password) {
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword(password);
//        config.setAlgorithm("PBEWithMD5AndDES");
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setProviderName("SunJCE");
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setStringOutputType("base64");
//        return config;
//    }
//}
