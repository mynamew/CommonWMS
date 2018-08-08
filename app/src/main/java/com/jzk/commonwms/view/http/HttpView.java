package com.jzk.commonwms.view.http;

import com.jzk.commonwms.data.LoginBean;
import com.jzk.mvplibrary.view.iml.MvpBaseView;

/**
 * $dsc
 * author: timi
 * create at: 2018-08-07 17:36
 */
public interface HttpView extends MvpBaseView {
    /**
     * 登录
     * @param bean
     */
    void  login(LoginBean bean);
}
