package com.jzk.commonwms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.commonwms.base.Constants;
import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.httplibrary.rxbus.EventMsg;
import com.jzk.httplibrary.rxbus.RxBus;
import com.jzk.utilslibrary.PackageUtils;
import com.jzk.utilslibrary.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseImpActivity<MainView, MainPresenter> implements MainView {

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initBundle(Bundle savedInstanceState) {


    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public MainView createView() {
        return this;
    }


    @Override
    public void login(LoginBean bean) {

    }
}
