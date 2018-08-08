package com.jzk.commonwms.view.http;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzk.commonwms.R;
import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.commonwms.base.Constants;
import com.jzk.commonwms.data.LoginBean;
import com.jzk.commonwms.data.LoginRequest;
import com.jzk.utilslibrary.PackageUtils;
import com.jzk.utilslibrary.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 网络请求示例
 *
 * @author jzk
 * create at: 2018/8/7 17:36
 */
public class HttpActivity extends BaseImpActivity<HttpView, HttpPresenter> implements HttpView {


    @BindView(R.id.tv_login)
    Button tvLogin;
    @BindView(R.id.tv_request)
    TextView tvRequest;
    @BindView(R.id.tv_response)
    TextView tvResponse;

    @Override
    public int setLayoutId() {
        return R.layout.activity_http;
    }

    @Override
    public void initBundle(Bundle savedInstanceState) {
        SpUtils.getInstance().putString(this, Constants.UPDATE_URL, "http://szjuqent.imwork.net:83/");
        SpUtils.getInstance().putString(this, Constants.LOCALE_LAUGUAGE, "zh-CN");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    public void login(View view) {
        LoginRequest request = new LoginRequest();
        request.setDeviceType(8);
        request.setMac(PackageUtils.getMac());
        request.setUsernameOrEmailAddress("admin");
        request.setPassword("123qwe");
        request.setTenancyName("Default");
        tvRequest.setText(request.toString());
        showProgressDialog();
        getPresenter().login(request);
    }

    @Override
    public void login(LoginBean bean) {
        Log.e("登录的返回---->", bean.toString());
        tvResponse.setText(bean.toString());
    }

    @Override
    public HttpPresenter createPresenter() {
        return new HttpPresenter(this);
    }

    @Override
    public HttpView createView() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
