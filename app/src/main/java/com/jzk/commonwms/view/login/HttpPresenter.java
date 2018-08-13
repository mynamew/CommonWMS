package com.jzk.commonwms.view.login;

import android.content.Context;

import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.commonwms.http.subscriber.HttpSubscriberImp;
import com.jzk.httplibrary.callback.OnResultCallBack;
import com.jzk.mvplibrary.presenter.impl.MvpBasePresenter;

/**
 * $dsc
 * author: timi
 * create at: 2018-08-07 17:37
 */
public class HttpPresenter extends MvpBasePresenter<HttpView> {
    private HttpModel model;
    private HttpSubscriberImp<LoginBean> subscriberImp;

    public HttpPresenter(Context context) {
        super(context);
    }

    @Override
    public void initModel() {
        model = new HttpModel();
    }

    /**
     * 登录
     *
     * @param req
     */
    public void login(LoginRequest req) {
        if (null == subscriberImp) {
            subscriberImp = new HttpSubscriberImp<>(new OnResultCallBack<LoginBean>() {
                @Override
                public void onSuccess(LoginBean bean) {
                    getView().login(bean);
                }

                @Override
                public void onError(String errorMsg) {

                }
            });
        }
        model.login(subscriberImp, req);
    }

    @Override
    public void dettachView() {
        super.dettachView();
        if (null != subscriberImp) {
            subscriberImp.unSubscribe();
            subscriberImp = null;
        }
    }
}
