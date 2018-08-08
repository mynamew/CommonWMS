package com.jzk.versionlibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.TextView;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.CustomDownloadFailedListener;
import com.allenliu.versionchecklib.v2.callback.CustomDownloadingDialogListener;
import com.allenliu.versionchecklib.v2.callback.CustomVersionDialogListener;
import com.allenliu.versionchecklib.v2.callback.ForceUpdateListener;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;


/**
 * $dsc  下载更新的工具类用于封装CheckVersionLib
 * author: timi
 * create at: 2018-07-06 14:39
 */
public class UpdateDownLoadUtils implements RequestVersionListener {
    public UIData uiData;
    public DownloadBuilder builder;
    public Context context;

    /**
     * @param updateTitle
     * @param updateContent
     * @param updateUrl     使用请求版本功能，可以在这里设置updateUrl
     *                      这里可以构造UIData需要显示的数据
     *                      UIData 内部是一个Bundle
     */
    public UpdateDownLoadUtils(Context context, String updateTitle, String updateContent, String updateUrl) {

        this.context = context;
        uiData = UIData.create();
        uiData.setContent(updateContent);
        uiData.setDownloadUrl(updateUrl);
        uiData.setTitle(updateTitle);
    }

    /**
     * 初始化 DownloadBuilder
     *
     * @param requstUrl
     * @param isSilentDown
     * @param isShowDownFaulDialog
     * @param isShowDownloadingDialog
     * @param isforceRedownload
     * @return
     */
    public DownloadBuilder downloadBuilderInit(String requstUrl,
                                               String path,
                                               CustomVersionDialogListener versionDialogListener,
                                               boolean isSilentDown,
                                               boolean isShowDownFaulDialog,
                                               CustomDownloadFailedListener downloadFailedListener,
                                               boolean isShowDownloadingDialog,
                                               CustomDownloadingDialogListener downloadingDialogListener,
                                               boolean isforceRedownload,
                                               ForceUpdateListener forceUpdateListener
    ) {

        builder = AllenVersionChecker
                .getInstance()
                .requestVersion()
                .setRequestUrl(requstUrl)
                .request(this);

        builder.setSilentDownload(isSilentDown);
        builder.setShowDownloadFailDialog(isShowDownFaulDialog);
        builder.setForceRedownload(isforceRedownload);
        builder.setShowDownloadingDialog(isShowDownloadingDialog);
        //是否强制更新
        if (null != forceUpdateListener) {
            builder.setForceUpdateListener(forceUpdateListener);

        }
        //版本更新的弹出框
        if (null != versionDialogListener) {
            builder.setCustomVersionDialogListener(versionDialogListener);
        }
        /**
         * 下载失败的弹出框
         */
        if (null != downloadFailedListener && isShowDownFaulDialog) {
            builder.setCustomDownloadFailedListener(downloadFailedListener);
        }
        /**
         * 下载进度
         */
        if (null != downloadingDialogListener && isShowDownloadingDialog) {
            builder.setCustomDownloadingDialogListener(downloadingDialogListener);
        }
        builder.setDownloadAPKPath(path);
        updateVersionNow();
        return builder;
    }

    /**
     * 只需要一个url
     *
     * @param requstUrl
     * @return
     */
    public DownloadBuilder downloadBuilderInit(String requstUrl,String path,ForceUpdateListener forceUpdateListener) {
        return downloadBuilderInit(requstUrl,
                path,
                null,
                false,
                false,
                null,
                false,
                null,
                false,
                forceUpdateListener
        ).setDirectDownload(true);//由于是是都未设置则设置为直接下载
    }

    /***
     *
     * @param requstUrl
     * @param isSilentDown  静默下载
     * @param listener      自定义更新升级的布局
     * @return
     */
    public DownloadBuilder downloadBuilderInit(String requstUrl,
                                               String path,
                                               boolean isSilentDown,
                                               CustomVersionDialogListener listener,
                                               ForceUpdateListener forceUpdateListener) {
        return downloadBuilderInit(requstUrl,
                path,
                listener,
                isSilentDown,
                false,
                null,
                false,
                null,
                false,
                forceUpdateListener
        );//由于是是都未设置则设置为直接下载
    }

    /**
     * 带有进度条的下载更新
     *
     * @param requstUrl                 请求地址
     * @param versionDialogListener     版本更新Dialog
     * @param isSilentDown              是否静默安装
     * @param isShowDownloadDialog      是否显示下载进度
     * @param downloadingDialogListener 下载进度弹出框
     * @return
     */
    public DownloadBuilder downloadBuilderInit(String requstUrl,
                                               String path,
                                               boolean isSilentDown,
                                               CustomVersionDialogListener versionDialogListener,
                                               boolean isShowDownloadDialog,
                                               CustomDownloadingDialogListener downloadingDialogListener,
                                               ForceUpdateListener forceUpdateListener) {
        return downloadBuilderInit(requstUrl,
                path,
                versionDialogListener,
                isSilentDown,
                false,
                null,
                isShowDownloadDialog,
                downloadingDialogListener,
                false
                , forceUpdateListener
        );
    }

    @Nullable
    @Override
    public UIData onRequestVersionSuccess(String result) {
        return uiData;
    }

    @Override
    public void onRequestVersionFailure(String message) {

    }

    /**
     * 开始更新
     */
    public void updateVersionNow() {
        builder.excuteMission(context);
    }

    /**
     * 获取更新的dialog
     *
     * @return
     */
    public CustomVersionDialogListener createCustomDialogTwo(boolean isForceDown,ForceUpdateListener listener) {
        return (context, versionBundle) -> {
            BaseDialog baseDialog = new BaseDialog(context, R.style.Dialog, R.layout.dialog_update_version);
            TextView msg = baseDialog.findViewById(R.id.tv_msg);
            TextView title = baseDialog.findViewById(R.id.tv_title);
            msg.setText(versionBundle.getContent());
            title.setText(versionBundle.getTitle());
            /**
             * 是否是强制更新
             */
            if(isForceDown){
                //弹出加载框的时候不能被取消掉
                baseDialog.setOnKeyListener((dialog, keyCode, event) -> {
                    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                        if(null!=listener){
                            listener.onShouldForceUpdate();
                        }
                        return true;
                    } else {
                        return false;
                    }
                });
            }
            baseDialog.setCanceledOnTouchOutside(!isForceDown);
            baseDialog.setCancelable(!isForceDown);
            return baseDialog;
        };
    }
}
