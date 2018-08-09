package com.jzk.commonwms.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jzk.commonwms.R;
import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.commonwms.base.BaseImpNoMvpActivity;
import com.jzk.commonwms.base.Constants;
import com.jzk.commonwms.view.http.HttpActivity;
import com.jzk.commonwms.view.spinner.SpinnerActivity;
import com.jzk.commonwms.view.version_update.VersionUpdateActivity;
import com.jzk.mvplibrary.utils.ToastUtils;

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
                scan(1001, new ScanQRCodeResultListener() {
                    @Override
                    public void scanSuccess(int requestCode, String result) {
                        ToastUtils.showShort(ListActivity.this,result);
                    }
                });
                break;
            case R.id.tv_update_spinner:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;
            default:
                break;
        }
    }
}
