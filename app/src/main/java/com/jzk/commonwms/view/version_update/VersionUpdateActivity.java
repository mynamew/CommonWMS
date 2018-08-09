package com.jzk.commonwms.view.version_update;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.allenliu.versionchecklib.v2.callback.ForceUpdateListener;
import com.jzk.commonwms.R;
import com.jzk.commonwms.SDCardUtils;
import com.jzk.mvplibrary.utils.ToastUtils;
import com.jzk.versionlibrary.UpdateDownLoadUtils;

/**
 * 版本更新
 *
 * @author jzk
 * create at: 2018/8/9 9:23
 */
public class VersionUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_update);
    }

    /**
     * 版本更新
     *
     * @param view
     */
    public void updateClick(View view) {
        UpdateDownLoadUtils updateDownLoadUtils=new UpdateDownLoadUtils(
                this,
                "CommonWms 1.0.1版本更新",
                "1、增加更新的Module \n2、增加说明文的那个\n3、增加实例说明",
                "http://app-global.pgyer.com/2b56ea224fdcc2eba2755ab7df3bad70.apk?attname=hb_wms_1.0.0.apk&sign=38a79fa808da8f6cb6eb4993965339ad&t=5b6bae86");

        switch (view.getId()) {
            case R.id.btn_silent_down:
                updateDownLoadUtils.downloadBuilderInit(
                        "https://www.pgyer.com/FVKz",
                        SDCardUtils.getAPKPath(this),
                        true,
                        updateDownLoadUtils.createCustomDialogTwo(false,null),
                        null);
                    break;
            case R.id.btn_progress_down:
                updateDownLoadUtils.downloadBuilderInit(
                        "https://www.pgyer.com/FVKz",
                        SDCardUtils.getAPKPath(this),
                        updateDownLoadUtils.createCustomDialogTwo(false,null),
                        false,
                         false,
                        null,
                        true,
                        null,
                        false,
                        null);
                break;
            case R.id.btn_silent_down_forced:
                updateDownLoadUtils.downloadBuilderInit(
                        "https://www.pgyer.com/FVKz",
                        SDCardUtils.getAPKPath(this),
                        updateDownLoadUtils.createCustomDialogTwo(true, new ForceUpdateListener() {
                            @Override
                            public void onShouldForceUpdate() {
                                ToastUtils.showLong(VersionUpdateActivity.this,"当前为强制更新！");
                            }
                        }),
                        false,
                        false,
                        null,
                        true,
                        null,
                        true,
                        null);
                break;
            default:
                break;
        }
    }
}
