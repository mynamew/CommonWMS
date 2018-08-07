package com.jzk.commonwms;

import android.content.Context;

import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.commonwms.http.subscriber.HttpSubscriberImp;
import com.jzk.httplibrary.callback.OnResultCallBack;
import com.jzk.mvplibrary.presenter.impl.MvpBasePresenter;

/**
 * $dsc
 * author: timi
 * create at: 2018-07-31 10:58
 */
public class MainPresenter extends MvpBasePresenter<MainView> {
    private MainModel mainModel;
    private HttpSubscriberImp<LoginBean> subscriberImp;

    public MainPresenter(Context context) {
        super(context);
    }

    @Override
    public void initModel() {
        mainModel = new MainModel();
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
        mainModel.login(subscriberImp, req);
    }
}
