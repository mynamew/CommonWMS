package com.jzk.commonwms.http.subscriber;

import com.jzk.httplibrary.subscriber.HttpSubscriber;
import com.jzk.httplibrary.callback.OnResultCallBack;

/** 
  *  http观察者的实现类
  * @author   jzk
  * create at: 2018/8/1 9:50
  */  
public class HttpSubscriberImp<T> extends HttpSubscriber {
    public HttpSubscriberImp(OnResultCallBack listener) {
        super(listener);
    }

    public HttpSubscriberImp(boolean isAutoDismiss, OnResultCallBack listener) {
        super(isAutoDismiss, listener);
    }

    @Override
    public void hideProgressDialog() {
        
    }

    @Override
    public void onErrorDeal(Throwable e) {

    }

}
