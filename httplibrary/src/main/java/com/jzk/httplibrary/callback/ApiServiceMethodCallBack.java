package com.jzk.httplibrary.callback;


import com.jzk.httplibrary.bean.CommonResult;

import io.reactivex.Observable;

/**
 * api setvice 的回调
 * @author: timi
 * create at: 2017-08-15 10:56
 */
public interface ApiServiceMethodCallBack<T,A> {
    Observable<CommonResult<T>> createObservable(A a);
}
