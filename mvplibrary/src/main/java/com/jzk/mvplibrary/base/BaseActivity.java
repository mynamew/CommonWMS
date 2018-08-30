package com.jzk.mvplibrary.base;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Selection;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzk.mvplibrary.R;
import com.jzk.mvplibrary.presenter.MvpPresenter;
import com.jzk.mvplibrary.utils.ToastUtils;
import com.jzk.mvplibrary.view.MvpView;
import com.jzk.mvplibrary.view.iml.MvpBaseView;


/**
 * Activity的基类
 * 1、如果有特定的要求可继承BaseActivity 写自己独特的方法
 * 2、BaseActivity 是匹配MVP而写
 * 3、不需要MVP请使用BaseNoMvpActivity或继承BaseNoMvpActivity实现自己的方法
 *
 * @author: timi
 * create at: 2018/7/30 11:01
 */
public abstract class BaseActivity extends AppCompatActivity implements MvpBaseView {


    public String TAG = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutResID = setLayoutId();
        setContentView(layoutResID);
        //初始化 ButterKnife
        initButterKnife();
        //tag
        TAG = getClass().getSimpleName() + "_";
        //初始化各种数据
        initBundle(savedInstanceState);
        initView();
        initData();
    }

    /**
     * 隐藏软键盘的方法
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                View view = getCurrentFocus();
                hideKeyboard(ev, view);
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 隐藏软键盘
     *
     * @param event
     * @param view
     */
    public void hideKeyboard(MotionEvent event, View view) {
        try {
            if (view != null && view instanceof EditText
                    ) {
                int[] location = {0, 0};
                view.getLocationInWindow(location);
                int left = location[0], top = location[1], right = left
                        + view.getWidth(), bootom = top + view.getHeight();
                // 判断焦点位置坐标是否在空间内，如果位置在控件外，则隐藏键盘
                if (event.getRawX() < left || event.getRawX() > right
                        || event.getY() < top || event.getRawY() > bootom) {
                    // 隐藏键盘
                    hidSoftInput(event, BaseActivity.this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismisProgressDialog() {

    }

    /**
     * 设置布局id
     * @return
     */
    public abstract int setLayoutId();

    /**
     * 初始化bundle
     * @param savedInstanceState
     */
    public abstract void initBundle(Bundle savedInstanceState);

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();





    /********
     * 页面跳转相关的方法
     **********************************************************************************************/
    public enum Interlude {

        DEFAULT,
        POP_FROM_BOTTOM
    }

    final private String keyInterlude = "keyInterlude";
    private Interlude curInterlude = Interlude.DEFAULT;

    @Override
    public void startActivity(Intent intent) {
        startActivity(intent, Interlude.DEFAULT);
    }

    public void startActivity(Intent intent, Interlude interlude) {
        intent.putExtra(keyInterlude, interlude.ordinal());
        super.startActivity(intent);

        if (interlude == Interlude.DEFAULT) {
            overridePendingTransition(R.transition.slide_in_right, R.anim.none);
        } else if (interlude == Interlude.POP_FROM_BOTTOM) {
            //从下方弹出
            overridePendingTransition(R.transition.pop_in_bottom, R.anim.none);
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (curInterlude == Interlude.DEFAULT) {
            //默认情况，什么都不做，已经在style文件中配置
            overridePendingTransition(R.anim.none, R.transition.slide_out_right);
        } else if (curInterlude == Interlude.POP_FROM_BOTTOM) {
            //从下方弹出
            overridePendingTransition(R.anim.none, R.transition.pop_out_bottom);
        }
    }

    /*************RecycleView和NesrollView滑动冲突解决*********************************************/
    /**
     * 设置recycleview  滑动更流畅
     *
     * @param rlv
     * @param layoutManager
     */
    public void setRecycleViewScrollSmooth(RecyclerView rlv, LinearLayoutManager layoutManager) {
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        rlv.setLayoutManager(layoutManager);
        rlv.setNestedScrollingEnabled(false);
        rlv.setHasFixedSize(true);
    }
    /**********设置某个Edittext选中****************************************************************/
    /**
     * 设置edittext 选中
     *
     * @param et
     */
    public void setEdittextSelected(EditText et) {
        et.setText(et.getText());
        et.setFocusable(true);
        et.setFocusableInTouchMode(true);
        et.requestFocus();
        et.findFocus();
        Selection.selectAll(et.getText());
    }
    /***************隐藏软键盘*********************************************************************/
    /**
     * 隐藏软键盘
     * @param ev
     * @param context
     */
    public void hidSoftInput(MotionEvent ev, Activity context) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = context.getCurrentFocus();
            if (isHideInput(view, ev)) {
                HideSoftInput(view.getWindowToken(), context);
            }
        }
    }

    /**
     * 隐藏软键盘
     *
     * @param token
     * @param context
     */
    private static void HideSoftInput(IBinder token, Context context) {
        if (token != null) {
            InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 判定是否需要隐藏
     */

    private boolean isHideInput(View v, MotionEvent ev) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top && ev.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 隐藏软键盘
     *
     * @param activity
     */
    public  void hide(Activity activity) {
        //隐藏软键盘
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        /**
         * 软键盘是否隐藏
         */
        if (isSoftShowing(activity)) {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 判断软键盘是否显示
     *
     * @param activity
     * @return
     */
    private  boolean isSoftShowing(Activity activity) {
        //获取当前屏幕内容的高度
        int screenHeight = activity.getWindow().getDecorView().getHeight();
        //获取View可见区域的bottom
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        return screenHeight - rect.bottom != 0;
    }

    /**
     * 初始化ButterKnife 可在子类中重写用于ButterKnife初始化
     */
    protected void  initButterKnife(){

     }
}
