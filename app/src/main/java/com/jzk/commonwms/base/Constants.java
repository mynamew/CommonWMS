package com.jzk.commonwms.base;

/**
 * 需要的静态变量
 */

public class Constants {
    /**
     * base url
     */
    public static final String BASE_URL = "http://szjuqent.imwork.net:91/";
    /**
     * Okhttp比对是否为登录Url的字符串
     */
    public static final String LOGIN_URL = "ClientLogin";
    /***********
     * SharePerference存储用户选的baseurl
     *********************************************************************************************/
    public static final String UPDATE_URL = "UPDATE_URL";
    //超时时间   2分钟
    public static int DEFAULT_TIMEOUT = 2;
    /***********
     * SharePerference存储token   key /  value的前缀
     *********************************************************************************************/
    public static final String AUTHORIZATION = "Authorization";
    public static final String AUTHORIZATION_VALUE = "Bearer ";
    /***********
     *SharePerference　存储 应用语言设置 中文简体（zh-CN）、中文繁体（zh-TW）、English（en）
     *********************************************************************************************/
    public static final String LOCALE_LAUGUAGE = "Abp.Localization.CultureName";


    /**********
     * 状态栏颜色
     *********************************************************************************************/
    public static final String StatusColorStr = "#c6ae75";
}
