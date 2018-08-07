package com.jzk.commonwms;

import com.jzk.commonwms.data.LoginBean;
import com.jzk.mvplibrary.view.iml.MvpBaseView;

/** 
  * 登录的View
  * @author   jzk
  * create at: 2018/7/31 13:36
  */  
public interface MainView extends MvpBaseView {
    /**
     * 登录
     * @param bean
     */
     void  login(LoginBean bean);
}
