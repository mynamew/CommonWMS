package com.jzk.commonwms;

import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.commonwms.http.HttpManagerImp;
import com.jzk.commonwms.http.api.ApiService;
import com.jzk.httplibrary.bean.CommonResult;
import com.jzk.httplibrary.callback.ApiServiceMethodCallBack;
import com.jzk.mvplibrary.model.impl.MvpBaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;

/** 
  * 主页的Model
  * @author   jzk
  * create at: 2018/7/31 13:34
  */  
public class MainModel extends MvpBaseModel {
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
