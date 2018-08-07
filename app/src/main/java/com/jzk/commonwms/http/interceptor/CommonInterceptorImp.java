package com.jzk.commonwms.http.interceptor;

import com.jzk.commonwms.base.BaseImpActivity;
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
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Abp.Localization.CultureName","zh-CN");
        headers.put("Authorization","Bearer "+"xpJIcvKvsRU742u4gEnRxDFXZgG2NRBQ861epTwfG8CeInR_GnDygq8cD9EruSTNKfQhz68hnb00CcRziv-ZpbAIO7TtAgZpMlnCKgEMf6T9bDhggqbXqVWz8_FIsYR9bzkn7jmUgvKTYT2Qjp73UGJZbTOsV1dCguG8e1k8h4uosHch86SHNjSYIlxfFg6jlXFNvu-xuT8yBfcOtsZsVjUurY_t33XIzMqxniEJFCglVJbtX5TXGJOeKxKxieAilE2YMffJH67PX74pUziSVl4G8Ky9BjhhSBHDeoq__Bb76DDnAhiLU9JIqPwTssrzmejYUyM9DQta_GGc1OIlrFXjNq_g5UGspmo7Io8VMraZNVFueGfC5unJdFp5NpabpfsNT9fSN-4uNwbRBq9gR8hjTZT0IfgrwI90rXGrLeO7mmdSCDMY-gnpaik73uF95tJ75C-F_U1SUlhAXJARjnH-TcFxiCqQzVybc_8-OJf7JtaCcYa5zHtvhmanoWX-CfxsQklXnKfxYQbmW1gd14cwm4De5mg0G-u2RZA8tHSKZ0E88cDgPGWW7t-dkqiXumTFCDPahnHM0LPqgYHjQQ");
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
