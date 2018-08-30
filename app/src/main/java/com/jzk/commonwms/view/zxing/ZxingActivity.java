package com.jzk.commonwms.view.zxing;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jzk.commonwms.R;
import com.jzk.commonwms.SDCardUtils;
import com.jzk.commonwms.base.BaseImpNoMvpActivity;
import com.jzk.qrcodelibrary.utils.QRCodeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Zxing的扫描和生成二维码
 *
 * @author jzk
 * create at: 2018/8/14 11:01
 */
public class ZxingActivity extends BaseImpNoMvpActivity {

    @BindView(R.id.btn_scan_qrcode)
    Button btnScanQrcode;
    @BindView(R.id.btn_create_qrcode)
    Button btnCreateQrcode;
    @BindView(R.id.et_qrcode)
    EditText etQrcode;
    @BindView(R.id.tv_scan_result)
    TextView tvScanResult;

    @Override
    public int setLayoutId() {
        return R.layout.activity_zxing;
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

    public void scanListerner(View view) {
        switch (view.getId()) {
            case R.id.btn_create_qrcode:
                 QRCodeUtil.createQRImage(etQrcode.getText().toString().trim(),
                        200,
                        200,
                        BitmapFactory.decodeResource(getResources(), R.mipmap.update_version_bg)
                        , SDCardUtils.getAPKPath(this));
                break;
            case R.id.btn_scan_qrcode:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
