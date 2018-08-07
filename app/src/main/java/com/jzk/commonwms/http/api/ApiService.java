package com.jzk.commonwms.http.api;


import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.httplibrary.bean.CommonResult;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
/**
 * retrofit 的网络请求api
 * author: timi
 * create at: 2017-08-15 09:58
 */

/**
 * 关于Api Servaice  注解的解释：
 * 1、@Field 单个表单数据提交
 * 2、@FieldMap 用map的形式提交一系列表单数据
 * 3、@Body     用于提交实体转换成的json 对象的提交（为了处理类似链表形式的提交,
 * 4、如果没有参数 则直接去除 @FormUrlEncoded 只加@Post注解即可
 * 链表形式的提交用@FieldMap是实现不了的"），
 */
public interface ApiService {
    /**
     * 登录
     *
     * @return
     */
    @POST("api/Account/ClientLogin")
    Observable<CommonResult<LoginBean>> login(@Body LoginRequest bean);
}