package com.jzk.httplibrary.interceptor;

/**
 * author: timi
 * create at: 2017-08-21 16:17
 */

import android.text.TextUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp自定义的拦截器
 *
 * @author jzk
 * create at: 2018/8/1 10:56
 */
public abstract class CommonInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        /**
         * 请求中的Url
         */
        HttpUrl oldUrl = oldRequest.url();
        /**
         * 应用配置的服务器Url
         */
        String updateUrl = getUpdateUrl();
        /**
         * Request的url
         */
        HttpUrl parseUrl = oldUrl;
        /**
         * 对updateUrl进行判断
         * 1、如果更改的Url不为空，对其进行更改
         * 2、如果更改的Url为空，则直接赋值
         */
        if (!TextUtils.isEmpty(updateUrl)) {
            /**
             * 对url 进行处理 当本地sp 存储的是和Constants不同的url 的时候进行替换BaseUrl的操作
             */
            if (!updateUrl.equals(oldUrl.toString())) {
                try {
                    /**
                     * 修改请求的Url
                     * 1、对Constants设置的BaseUrl获取
                     * 2、UpdateUrl 替换oldUrl中BaseUrl的地址即：http://APIURL
                     * 例： http://szjuqent.imwork.net:83/替换http://szjuqent.imwork.net:91/
                     */
                    parseUrl = HttpUrl.parse(updateUrl + oldUrl.toString().replace(getBaseUrl(), ""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * Request 对象
         */
        Request newRequest = null;
        /**
         * 获取Request的Builder 为了设置参数
         */
        Request.Builder builder = oldRequest.newBuilder();
        /**
         * 获取header的集合
         * 通过对oldUrl是否含有登录的地址的比对 判断是否是登录请求
         * 例：
         * 登录接口是：http://[APIURL]/api/Account/ClientLogin
         * 可以直接通过getLoginUrl()方法返回ClientLogin进行比对
         */
        String loginUrl = getLoginUrl();
        Map<String, String> headers = oldUrl.toString().contains(loginUrl) ? beforeLoginHeader() : afterLoginHeader();
        /**
         * 当登录后的header map不为空的时候添加到请求中的header
         */
        if (null != headers && !headers.isEmpty()) {
            try {
                /**
                 * 循环遍历map
                 */
                for(String key:headers.keySet()){
                    builder.addHeader(key, headers.get(key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /**
         * 生成新的Request
         */
        assert parseUrl != null;
        newRequest = builder.method(oldRequest.method(), oldRequest.body())
                .url(parseUrl)
                .build();
        return chain.proceed(newRequest);
    }

    /**
     * 获取登录前的header
     *
     * @return
     */
    protected abstract Map<String, String> beforeLoginHeader();

    /**
     * 获取登录后的header
     *
     * @return
     */
    protected abstract Map<String, String> afterLoginHeader();

    /**
     * 获取APP更改的Url相对于Constants中配置的Url而言
     *
     * @return
     */
    protected abstract String getUpdateUrl();

    /**
     * 获取Constants中配置的Url
     *
     * @return
     */
    protected abstract String getBaseUrl();

    /**
     * 获取是否为登录Url比对的字符串
     *
     * @return
     */
    protected abstract String getLoginUrl();
}
