package com.jzk.utilslibrary;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * sharepreference 的工具类
 * author: timi
 * create at: 2017-08-15 18:12
 */
public class SpUtils {
    /**
     * shareperference
     */
    private SharedPreferences mPreference = null;
    /**
     * shareperference的名稱
     */
    private String sharePerfrenceName = "config";
    //editor
    private SharedPreferences.Editor editor = null;

    private SpUtils() {
    }

    private static class LazyHolder {
        private static final SpUtils INSTANCE = new SpUtils();
    }

    public static SpUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 获取shareperference实例
     *
     * @return
     */
    public SharedPreferences getSharedPreferences(Context context) {
        if (null == mPreference) {
            mPreference =context.getSharedPreferences(sharePerfrenceName, Context.MODE_PRIVATE);
            editor = mPreference.edit();
        }
        return mPreference;
    }

    /**
     * 存入 字符串
     *
     * @param key
     * @param value
     */
    public SpUtils putString(Context context,String key, String value) {
        getSharedPreferences(context);
        editor.putString(key, value).commit();
        return this;
    }

    /**
     * 获取字符串的value
     *
     * @param key
     * @return
     */
    public String getString(Context context,String key) {
        getSharedPreferences(context);
        return mPreference.getString(key, "");
    }

    /**
     * 存入 整形
     *
     * @param key
     * @param value
     */
    public SpUtils putInt(Context context,String key, int value) {
        getSharedPreferences(context);
        editor.putInt(key, value).commit();
        return this;
    }

    /**
     * 获取整形的value
     *
     * @param key
     * @return
     */
    public int getInt(Context context,String key) {
        getSharedPreferences(context);
        return mPreference.getInt(key, 0);
    }

    /**
     * 存储 float 类型
     *
     * @param key
     * @param value
     */
    public SpUtils putFloat(Context context,String key, float value) {
        getSharedPreferences(context);
        editor.putFloat(key, value).commit();
        return this;
    }

    /**
     * 获取 float 类型value
     *
     * @param key
     * @return
     */
    public float getFloat(Context context,String key) {
        getSharedPreferences(context);
        return mPreference.getFloat(key, 0);
    }

    /**
     * 存储布尔类型数据
     *
     * @param key
     * @param value
     */
    public SpUtils putBoolean(Context context,String key, boolean value) {
        getSharedPreferences(context);
        editor.putBoolean(key, value).commit();
        return this;
    }

    /**
     * 获取 布尔类型value
     *
     * @param key
     * @return
     */
    public boolean getBoolean(Context context,String key) {
        getSharedPreferences(context);
        return mPreference.getBoolean(key, false);
    }
}
