package com.jzk.mvplibrary.view.iml;


import com.jzk.mvplibrary.view.MvpView;

/**
 * mvp 的base  实现类
 */

public interface MvpBaseView extends MvpView {
    void showProgressDialog();

    void dismisProgressDialog();
}
