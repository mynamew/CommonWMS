package com.jzk.commonwms.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.qrcodelibrary.CommonScanActivity;
import com.jzk.qrcodelibrary.utils.Constant;

/**
 * $dsc  扫描的工具类
 * author: timi
 * create at: 2018-08-09 11:33
 */
public class ScanUtils {
    /**
     * 扫码的返回 监听器
     */
    private BaseImpActivity.ScanQRCodeResultListener mListener = null;
    /**
     * 调用相机扫描二维码的方法
     *
     * @param requestCode
     */
    public void scan(Activity activity,int requestCode, BaseImpActivity.ScanQRCodeResultListener listener) {
        if (null != listener) {
            mListener = listener;
        }
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 60);
        } else {
            //权限已经被授予，在这里直接写要执行的相应方法即可
            Intent intent = new Intent(activity, CommonScanActivity.class);

            String pointMsg = "扫描的数据为空，请重新扫描！";
            Bundle bundle = new Bundle();
            bundle.putString("pointMsg", pointMsg);
            intent.putExtras(bundle);

            intent.putExtra(Constant.REQUEST_SCAN_MODE, Constant.REQUEST_SCAN_MODE_ALL_MODE);
            activity.startActivityForResult(intent, requestCode);
        }
    }
}
