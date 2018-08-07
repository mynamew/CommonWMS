package com.jzk.commonwms;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.commonwms.base.Constants;
import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.utilslibrary.PackageUtils;
import com.jzk.utilslibrary.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseImpActivity<MainView, MainPresenter> implements MainView {
    @BindView(R.id.tv_login)
    Button tvLogin;
    @BindView(R.id.tv_request)
    TextView tvRequest;
    @BindView(R.id.tv_response)
    TextView tvResponse;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initBundle(Bundle savedInstanceState) {

        SpUtils.getInstance().putString(this, Constants.UPDATE_URL, "http://szjuqent.imwork.net:83/");
        SpUtils.getInstance().putString(this, Constants.LOCALE_LAUGUAGE, "zh-CN");
    }

    @Override
    public void initView() {
        tvRequest.setText("請求");
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

    public void login(View view) {
        LoginRequest request = new LoginRequest();
        request.setDeviceType(8);
        request.setMac(PackageUtils.getMac());
        request.setUsernameOrEmailAddress("admin");
        request.setPassword("123qwe");
        request.setTenancyName("Default");
        tvRequest.setText(request.toString());
        getPresenter().login(request);
    }

    @Override
    public void login(LoginBean bean) {
        Log.e("登录的返回---->", bean.toString());
        tvResponse.setText(bean.toString());
    }
}
