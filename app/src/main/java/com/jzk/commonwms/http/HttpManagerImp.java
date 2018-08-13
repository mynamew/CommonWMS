package com.jzk.commonwms.http;

import android.annotation.SuppressLint;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jzk.commonwms.base.Constants;
import com.jzk.commonwms.data.zip.BaseReturnBean;
import com.jzk.commonwms.data.zip.NoneClass;
import com.jzk.commonwms.data.zip.StationRequest;
import com.jzk.commonwms.data.zip.ZipResult;
import com.jzk.commonwms.http.api.ApiService;
import com.jzk.commonwms.http.exp.ApiException;
import com.jzk.commonwms.http.interceptor.CommonInterceptorImp;
import com.jzk.httplibrary.HttpManager;
import com.jzk.httplibrary.bean.CommonResult;
import com.jzk.httplibrary.callback.ApiServiceMethodCallBack;
import com.jzk.utilslibrary.LogUitls;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jzk.commonwms.http.exp.ApiException.CODE_REQUEST_SUCCESS_EXCEPTION;

/**
 * httpmanager的实现类
 *
 * @author jzk
 * create at: 2018/8/1 17:19
 */
public class HttpManagerImp extends HttpManager {
    //实例
    private static volatile HttpManagerImp instancce = null;
    //api service
    private ApiService mApiService = null;

    /**
     * 获取实例的方法
     * author: timi
     * create at: 2017/8/15 10:05
     *
     * @return 返回当前实例
     */
    public static HttpManagerImp getInstance() {
        if (null == instancce) {
            synchronized (HttpManager.class) {
                if (null == instancce) {
                    instancce = new HttpManagerImp();
                }
            }
        }
        return instancce;
    }

    /**
     * 实例化 instance
     * author: timi
     * create at: 2017/8/15 10:06
     */
    public HttpManagerImp() {
        initRetrofit(Constants.BASE_URL);
    }

    @Override
    protected OkHttpClient initOkhttpClient() {
        /**
         * 初始化 okhttp
         */
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MINUTES)
                .writeTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MINUTES)
                .readTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MINUTES)
                .addInterceptor(new CommonInterceptorImp()).build();
        return okHttpClient;
    }

    @Override
    protected Retrofit initRetrofit(String baseUrl) {
        /**
         * 初始化 retrofit
         */
        Retrofit mRetrofit = new Retrofit.Builder()
                //base url
                .baseUrl(Constants.BASE_URL)
                //gosn 转换器
                .addConverterFactory(GsonConverterFactory.create())
                //rxjava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //OkHttpClient
                .client(initOkhttpClient())
                .build();
        mApiService = mRetrofit.create(ApiService.class);
        return mRetrofit;
    }

    @Override
    protected <T> void toSubscribe(Observable<CommonResult<T>> o, Observer<T> s) {
        o.subscribeOn(Schedulers.io())
                .map(t -> {
                    if (t.isSuccess()) {
                        //防止返回数据为null的情况
                        if (null == t.getResult()) {
                            throw new ApiException(CODE_REQUEST_SUCCESS_EXCEPTION);
                        }
                        return t.getResult();

                    } else {
                        throw new ApiException(t.getError().getMessage());
                    }
                })
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    public void toSubscribe(StationRequest request, Observer<ZipResult> s) {
        Observable.zip(mApiService.getMoCode(new NoneClass()), mApiService.getStations(request),
                (baseReturnBean, baseReturnBean2) ->
                        new ZipResult(baseReturnBean2.getResult().getStations(),
                                baseReturnBean.getResult().getMos()))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    @Override
    public <T, A> void httpManagerRequest(Observer<T> subscriber, ApiServiceMethodCallBack<T, A> callBack) {
        try {
            toSubscribe(callBack.createObservable((A) mApiService), subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
