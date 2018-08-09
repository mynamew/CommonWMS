package com.jzk.commonwms.base;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Selection;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jzk.mvplibrary.base.BaseActivity;
import com.jzk.mvplibrary.utils.ToastUtils;
import com.jzk.qrcodelibrary.CommonScanActivity;
import com.jzk.qrcodelibrary.utils.Constant;

import butterknife.ButterKnife;

/**
 * $dsc
 * author: timi
 * create at: 2018-08-09 14:21
 */
public abstract class BaseImpNoMvpActivity extends BaseActivity {
    private static BaseImpNoMvpActivity currentActivity = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * 调用父类的方法
         */
        super.onCreate(savedInstanceState);
        /**
         * 存储实例
         */
        currentActivity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismisProgressDialog();
    }

    @Override
    protected void onResume() {
        super.onResume();
        currentActivity = this;
    }
    /**
     * 获取当前Activity的实例
     *
     * @return
     */
    public static Activity getCurrentActivty() {
        return currentActivity;
    }
    /*********扫码相关*****************************************************************************/

    /**
     * 扫码的返回 监听器
     */
    private BaseImpNoMvpActivity.ScanQRCodeResultListener mListener = null;

    /**
     * zxing 扫码的回调接口
     */
    public interface ScanQRCodeResultListener {
        void scanSuccess(int requestCode, String result);
    }

    /**
     * 调用相机扫描二维码的方法
     *
     * @param requestCode
     */
    public void scan(int requestCode, BaseImpNoMvpActivity.ScanQRCodeResultListener listener) {
        if (null != listener) {
            mListener = listener;
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 60);
        } else {
            //权限已经被授予，在这里直接写要执行的相应方法即可
            Intent intent = new Intent(this, CommonScanActivity.class);

            String pointMsg = "扫描的数据为空，请重新扫描！";
            Bundle bundle = new Bundle();
            bundle.putString("pointMsg", pointMsg);
            intent.putExtras(bundle);

            intent.putExtra(Constant.REQUEST_SCAN_MODE, Constant.REQUEST_SCAN_MODE_ALL_MODE);
            startActivityForResult(intent, requestCode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                if (null != mListener) {
                    mListener.scanSuccess(requestCode, bundle.getString("result"));
                }
            }
        }
    }
    /*******输入框，PDA扫码************************************************************************/
    private SparseArray<EditText> edits = new SparseArray<>();

    /**
     * 设置 输入框  将输入框传进来
     *
     * @param editText
     * @param editCode         输入框标识的code
     * @param tipPleaseInputId 输入框输入内容为空 的提示
     * @param tipLengthId      输入位数小于4 的提示
     * @param listener         监听事件
     */
    public void setEdittextListener(final EditText editText, int editCode, @StringRes final int tipPleaseInputId, @StringRes final int tipLengthId, final BaseImpNoMvpActivity.EdittextInputListener listener) {
        //存储输入框
        edits.put(editCode, editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 6 || actionId == 0) {
                    hide(BaseImpNoMvpActivity.this);
                    String content = editText.getText().toString().trim();
                    if (TextUtils.isEmpty(content)) {
                        ToastUtils.showShort(BaseImpNoMvpActivity.this, getString(tipPleaseInputId));
                        Selection.selectAll(editText.getText());
                        return true;
                    }
                    /**
                     * 长度的判定
                     */
                    if (content.length() < 4 && tipLengthId != 0) {
                        ToastUtils.showShort(BaseImpNoMvpActivity.this, getString(tipLengthId));
                        Selection.selectAll(editText.getText());
                        return true;
                    }
                    /**
                     * 验证通过，进行下一步
                     */
                    if (null != listener) {
                        listener.verticalSuccess(content);
                    }

                }
                return false;
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    editText.findFocus();
                    editText.setSelectAllOnFocus(true);
                    Selection.selectAll(editText.getText());
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * 按下扫描件
         */
        if (keyCode == 0) {
            setEdittextSelect();
        }
        return super.onKeyDown(keyCode, event);
    }
    /**
     * 设置 输入框内容选中的方法
     */
    public void setEdittextSelect() {
        /**
         * 遍历sparsearray  找到正在获取焦点的edittext 设置全部选中
         */
        for (int i = 0; i < edits.size(); i++) {
            EditText et = edits.valueAt(i);
            if (et.isFocused()) {
                Selection.selectAll(et.getText());
                break;
            }
        }
    }

    /**
     * 所有的输入框的输入监听方法  验证全部通过则调用 verticalSuccess方法
     * 1、为了统一处理 输入错误设置内容选中
     * 2、为了监听回车键
     * 3、为了监听扫描键
     */
    public interface EdittextInputListener {
        void verticalSuccess(String result);
    }

    /**
     * 如果项目中用到 butterknife则可以在方法中直接返回绑定的方法
     * 否则在initView中调用View的方法时会报错
     */
    @Override
    protected void initButterKnife() {
        super.initButterKnife();
        ButterKnife.bind(this);
    }
}
