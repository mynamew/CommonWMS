package com.timi.imageloader;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * 图片加载器功能接口；
 * 添加或者替换新的图片加载器实现该接口即可
 */
public interface ImageLoader {
    /**
     * Init ImageLoader
     */
    void init(Context context);

    /**
     * Show Image
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultImage
     */
    void displayImage(Context context, String url, ImageView imageView, GlideTransType transType,  int defaultImage);

    /**
     * Show Image
     *
     * @param context
     * @param url
     * @param imageView
     */
    void displayImage(Context context, String url, ImageView imageView, GlideTransType transType);

    /**
     * 显示本地图片
     *
     * @param context
     * @param path
     * @param imageView
     * @param type
     */
    void displayLocalImage(Context context, String path, ImageView imageView, GlideTransType type);

    /**
     * Show Image
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultImage 默认图
     * @param errorImage   错误图
     */
    void displayImage(Context context, String url, ImageView imageView, GlideTransType transType,  int defaultImage, int errorImage);

    /**
     * 销毁内容
     *
     * @param context
     */
    void onDestroy(Context context);

}