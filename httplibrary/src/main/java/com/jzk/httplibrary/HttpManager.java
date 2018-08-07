package com.jzk.httplibrary;

import com.jzk.httplibrary.bean.CommonResult;
import com.jzk.httplibrary.callback.ApiServiceMethodCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 网络请求管理器的基类
 *
 * @author jzk
 * create at: 2018/8/1 10:02
 */
public abstract class HttpManager{
    /**
     * 初始化Okhttp
     * @return
     */
    protected abstract OkHttpClient initOkhttpClient();

    /**
     * 初始化Retrofit
     * @param baseUrl
     * @return
     */
    protected abstract Retrofit initRetrofit(String baseUrl);

    /**
     * 普通的网络请求注册
     *
     * @param o
     * @param s
     * @param <T>
     */
    protected abstract <T> void toSubscribe(Observable<CommonResult<T>> o, Observer<T> s);
    /**
     * 公共的外部调用请求的方法
     *
     * @param subscriber 观察者
     * @param callBack   回调
     * @param <T>
     */
    protected abstract <T,A> void httpManagerRequest(Observer<T> subscriber, ApiServiceMethodCallBack<T,A> callBack);
}
