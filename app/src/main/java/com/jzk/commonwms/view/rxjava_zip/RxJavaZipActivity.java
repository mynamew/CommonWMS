package com.jzk.commonwms.view.rxjava_zip;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jzk.commonwms.R;
import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.commonwms.data.zip.StationRequest;
import com.jzk.commonwms.data.zip.ZipResult;
import com.jzk.utilslibrary.LogUitls;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Rxjava Zip
 *
 * @author jzk
 * create at: 2018/8/13 14:03
 */
public class RxJavaZipActivity extends BaseImpActivity<RxJavaZipView, RxjavaZipPresenter> implements RxJavaZipView {
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    public int setLayoutId() {
        return R.layout.activity_rx_java_zip;
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
    public RxjavaZipPresenter createPresenter() {
        return new RxjavaZipPresenter(this);
    }

    @Override
    public RxJavaZipView createView() {
        return this;
    }

    @Override
    public void rxjavaZipRequest(ZipResult o) {
        LogUitls.e("获取到的结果---->", o.toString());
        tvResult.setText("请求的返回:"+"\n第一个请求的返回---->"+o.getMos().toString()+"\n 第二次请求的返回----->"+o.getStations().toString());
    }


    public void postZipRequest(View view) {
        getPresenter().rxjavaZipRequest(
                new StationRequest(
                        "MD",
                        "",
                        ""));
    }


}
