package com.xiye.common.util;

/**
 * @author hc
 * @version V1.0
 * @title Const.java
 * @package com.xiye.common.util
 * @description 静态参数
 * @date 2018-07-13
 */

public final class Const {

    private Const() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 系统错误
     */
    public static final int MAP_NUMBER = 10;

    public static final String FILEPATH_LEFT = "/";

    /**
     * 过滤条件文本框
     */
    public static final String KEYWORDS = "keywords";

    /**
     * session用的用户
     */
    public static final String SESSION_USER = "sessionUser";

    /**
     * 全部菜单
     */
    public static final String SESSION_ALLMENULIST = "allmenuList";

    /**
     * 主职角色权限
     */
    public static final String SESSION_QX = "QX";
    /**
     * 副职角色权限
     */
    public static final String SESSION_QX2 = "QX2";

    /**
     * 用户名
     */
    public static final String SESSION_USERNAME = "USERNAME";

    /**
     * 用户姓名
     */
    public static final String SESSION_U_NAME = "U_NAME";

    /**
     * 角色编码数组
     */
    public static final String SESSION_RNUMBERS = "RNUMBERS";

    /**
     * 当前用户拥有的最高部门权限集合
     */
    public static final String DEPARTMENT_IDS = "DEPARTMENT_IDS";
    /**
     * 当前用户拥有的最高部门权限
     */
    public static final String DEPARTMENT_ID = "DEPARTMENT_ID";

    /**
     * 分页条数
     */
    public static final String PAGE_COUNT = "10";

    /**
     * EXCEL存放路径
     */
    public static final String EXCELMODEL = "templates/excel/";

    /**
     * 代码生成器生成压缩包
     */
    public static final String ZIPNAME = "XIYE_CODE.zip";

    /**
     * 压缩Freemarker文件地址
     */
    public static final String INPUTNAME = "ftl";


    /**
     * 不对匹配该值的访问路径拦截（正则）
     */
    public static final String NO_INTERCEPTOR_PATH = ".*/((weapp)|(login)|(druid)|(uploadFiles/uploadFile)|(healthcheck)|(serverinfo)|(apps)|(asg)|(peerreplication)|(status)|(svips)|(vips)|(instances)|(monitor)|(hystrix)|(actuator)|(health)|(v2/api-docs)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)|(web)|(ueditor)|(index)|(uploadImgs)).*";


    /* ===================消息队列================== */

    /**
     * 角色数据队列
     */
    public static final String QUEUE_ROLE = "QUEUE_ROLE";

    /* ===================消息队列================== */


    /* ===================redis缓存key================== */

    /**
     * 角色数据LIST，用来展示下拉select等场景
     */
    public static final String REDIS_ROLE_LIST = "role:list";

    /**
     * 消息推送队列
     */
    public static final String REDIS_MENU_USER = "menu_user:";

    /**
     * 部门组织机构数据队列
     */
    public static final String REDIS_LOGSTASH = "logstash:redis";

    /**
     * 民族数据LIST，用来展示下拉select等场景
     */
    public static final String REDIS_DICTIONARIES_NATION_LIST = "dictionaries:nation:list";

    /**
     * 政治面貌数据LIST，用来展示下拉select等场景
     */
    public static final String REDIS_DICTIONARIES_POLITICAL_LIST = "dictionaries:political:list";

    /* ===================redis缓存key================== */

    /* ===================定时任务================== */

    /**
     * 正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 禁用状态
     */
    public static final String STATUS_DISABLE = "-1";

    /* ===================定时任务================== */

    /* ===================增删改查等按钮权限验证================== */

    /**
     * 超级管理员验证
     */
    public static final String ADMIN_RIGHT = "admin";

    /**
     * 邮件
     */
    public static final String EMAIL_RIGHT = "email";

    /**
     * 从excel导入数据库
     */
    public static final String FROMEXCEL_RIGHT = "FromExcel";

    /* ===================增删改查等按钮权限验证================== */

    /**
     * 数据字典缓存队列
     */
    public static final String QUEUE_DICTIONARIES = "QUEUE_DICTIONARIES";

    /**
     * 账户常量
     */
    public static final String USERNAME = "username";

    /**
     * 状态常量
     */
    public static final String STATUS = "status";

    /**
     * 上级ID常量
     */
    public static final String PARENTID = "parentId";

    /**
     * 字典项LIST，用来展示下拉select等场景
     */
    public static final String REDIS_DICTIONARIES_LIST = "dictionaries:list";

    /**
     * 编码格式
     */
    public static final String UTF8 = "UTF-8";
}

