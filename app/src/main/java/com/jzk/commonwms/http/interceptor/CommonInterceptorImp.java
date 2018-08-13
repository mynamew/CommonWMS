package com.jzk.commonwms.http.interceptor;

import com.jzk.commonwms.base.BaseImpActivity;
import com.jzk.commonwms.base.BaseImpNoMvpActivity;
import com.jzk.commonwms.base.Constants;
import com.jzk.httplibrary.interceptor.CommonInterceptor;
import com.jzk.utilslibrary.SpUtils;

import java.util.HashMap;
import java.util.Map;

/**
  *  拦截器
 *  1、用于批量添加header
 *  2、用于更改请求的url
  * @author   jzk
  * create at: 2018/8/1 10:11
  */
public class CommonInterceptorImp extends CommonInterceptor {

    @Override
    protected Map<String, String> beforeLoginHeader() {
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Abp.Localization.CultureName","zh-CN");
        return headers;
    }

    @Override
    protected Map<String, String> afterLoginHeader() {
        String  tocken=SpUtils.getInstance().getString(BaseImpActivity.getCurrentActivty(),Constants.AUTHORIZATION);
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Abp.Localization.CultureName","zh-CN");
        headers.put("Authorization","Bearer "+tocken);
        return headers;
    }

    @Override
    protected String getUpdateUrl() {
        return SpUtils.getInstance().getString(BaseImpActivity.getCurrentActivty(),Constants.UPDATE_URL);
    }

    @Override
    protected String getBaseUrl() {
        return Constants.BASE_URL;
    }

    @Override
    protected String getLoginUrl() {
        return Constants.LOGIN_URL;
    }
}
