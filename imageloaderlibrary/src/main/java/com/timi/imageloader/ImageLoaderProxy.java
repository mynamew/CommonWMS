package com.timi.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * 图片加载代理类，所有的图片操作都通过该代理类去实现；
 * 如果要改变图片加载框架，只需要在该类里替换相应的图片加载框架即可，客户端所有引用的图片操作都不需要修改
 */
public class ImageLoaderProxy implements ImageLoader {
    private ImageLoader imageLoader;//代理对象
    private static ImageLoaderProxy imageLoaderProxy;

    public static ImageLoaderProxy getInstance() {
        if (imageLoaderProxy == null) {
            imageLoaderProxy = new ImageLoaderProxy();
        }
        return imageLoaderProxy;
    }

    private ImageLoaderProxy() {
        imageLoader = new GlideImageLoader();
    }


    @Override
    public void init(Context context) {
        imageLoader.init(context);
    }

    @Override
    public void displayImage(Context context, String url, ImageView imageView, GlideTransType transType, int defaultImage) {
        displayImage(context, url, imageView, transType, defaultImage, -1);
    }

    @Override
    public void displayImage(Context context, String url, ImageView imageView, GlideTransType transType) {
        displayImage(context, url, imageView, transType, -1, -1);
    }

    @Override
    public void displayLocalImage(Context context, String path, ImageView imageView, GlideTransType type) {
        imageLoader.displayLocalImage(context, path, imageView, type);
    }

    @Override
    public void displayImage(Context context, String url, ImageView imageView, GlideTransType transType, int defaultImage, int errorImage) {
        imageLoader.displayImage(context, url, imageView, transType, defaultImage, errorImage);
    }


    @Override
    public void onDestroy(Context context) {
        imageLoader.onDestroy(context);
    }
}