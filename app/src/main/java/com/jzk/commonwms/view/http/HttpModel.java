package com.jzk.commonwms.view.http;

import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.commonwms.http.HttpManagerImp;
import com.jzk.commonwms.http.api.ApiService;
import com.jzk.httplibrary.callback.ApiServiceMethodCallBack;
import com.jzk.mvplibrary.model.impl.MvpBaseModel;

import io.reactivex.Observer;

/**
 * $dsc
 * author: timi
 * create at: 2018-08-07 17:36
 */
public class HttpModel extends MvpBaseModel {
    /**
     * 登录
     * @param observer
     * @param request
     */
    public void login(Observer<LoginBean> observer, LoginRequest request) {
        HttpManagerImp.getInstance().httpManagerRequest(observer,
                (ApiServiceMethodCallBack<LoginBean, ApiService>) apiService ->
                        apiService.login(request));
    }
}
