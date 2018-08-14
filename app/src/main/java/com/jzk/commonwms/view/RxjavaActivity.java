package com.jzk.commonwms.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jzk.commonwms.R;
import com.jzk.commonwms.base.BaseImpNoMvpActivity;
import com.jzk.commonwms.view.rxjava_zip.RxJavaZipActivity;

/**
  * Rxjava的界面
  * @author   jzk
  * create at: 2018/8/14 8:42
  */  
public class RxjavaActivity extends BaseImpNoMvpActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_rxjava;
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

    public void jumpActivity(View view) {
        switch (view.getId()){
            case R.id.btn_rxjava_zip:
                startActivity(new Intent(this, RxJavaZipActivity.class));
                break;
                default:
        }
    }
}
