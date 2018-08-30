package com.jzk.commonwms.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jzk.commonwms.R;
import com.jzk.commonwms.base.BaseImpNoMvpActivity;
import com.jzk.commonwms.view.autosize.AutoSizeActivity;
import com.jzk.commonwms.view.img.ImageLoadActivity;
import com.jzk.commonwms.view.login.HttpActivity;
import com.jzk.commonwms.view.spinner.SpinnerActivity;
import com.jzk.commonwms.view.version_update.VersionUpdateActivity;
import com.jzk.commonwms.view.zxing.ZxingActivity;

public class ListActivity extends BaseImpNoMvpActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_list;
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
        switch (view.getId()) {
            case R.id.tv_http:
                startActivity(new Intent(this, HttpActivity.class));
                break;
            case R.id.tv_rxbus:
                startActivity(new Intent(this, HttpActivity.class));
                break;
            case R.id.tv_update_version:
                startActivity(new Intent(this, VersionUpdateActivity.class));
                break;
            case R.id.tv_update_qrcode:
                startActivity(new Intent(this, ZxingActivity.class));
                break;
            case R.id.tv_update_spinner:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;
            case R.id.tv_img:
                startActivity(new Intent(this, ImageLoadActivity.class));
                break;
            case R.id.tv_rxjava:
                startActivity(new Intent(this, RxjavaActivity.class));
                break;
            case R.id.tv_autosize:
                startActivity(new Intent(this, AutoSizeActivity.class));
                break;
            default:
                break;
        }
    }
}
