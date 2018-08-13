package com.timi.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;
import com.timi.imageloader.transform.GlideCircleTransform;
import com.timi.imageloader.transform.GlideRoundTransform;

import java.io.File;

/**
 * Glide 实现类
 * author: timi
 * create at: 2018/6/21 9:15
 */
public class GlideImageLoader implements ImageLoader {
    GlideRequests mGlideRequst;

    @Override
    public void init(Context context) {
        mGlideRequst = GlideApp.with(context);
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
    public void displayLocalImage(Context context, String path, final ImageView imageView, GlideTransType transType) {
        /**
         * 加载path
         */
        displayObjectImage(context, path, imageView, transType,-1,-1);
    }

    @Override
    public void displayImage(Context context, String url, ImageView imageView, GlideTransType transType, int defaultImage, int errorImage) {
        displayObjectImage(context, url, imageView, transType, defaultImage, errorImage);
    }

    /**
     * 加载
     * @param context
     * @param loadObject
     * @param imageView
     * @param transType
     * @param defaultImage
     * @param errorImage
     */
    private void displayObjectImage(Context context, Object loadObject, ImageView imageView, GlideTransType transType, int defaultImage, int errorImage) {
        if (context == null) {
            throw new RuntimeException("context is not null");
        }
        init(context);
        /**
         * 加载url
         */
        if (loadObject instanceof String) {
            mGlideRequst.load(loadObject.toString())
                    .apply(getGlideRequestOptions(context, transType, defaultImage, errorImage))
                    .into(imageView);
        }
        /**
         * 加载path
         */
        if (loadObject instanceof File) {
            mGlideRequst.load(new File(loadObject.toString()))
                    .apply(getGlideRequestOptions(context, transType, defaultImage, errorImage))
                    .into(imageView);
        }
    }

    @Override
    public void onDestroy(Context context) {
        if (context == null) {
            throw new RuntimeException("context is not null");
        }
        if (mGlideRequst != null) {
            mGlideRequst.pauseRequests();
        }
    }

    /**
     * 获取Glide 的RequestOption 为了实现圆形 圆角图片
     *
     * @param context
     * @param transType
     * @return
     */
    private RequestOptions getGlideRequestOptions(Context context, GlideTransType transType, int defaultImage, int errorImage) {
        RequestOptions options = new RequestOptions().centerCrop();
        switch (transType) {
            case ROUND:
                options.transform(new GlideRoundTransform(context));
                break;
            case NORMAL:
                break;
            case CIRCLE:
                options.transform(new GlideCircleTransform());
                break;
            default:
                break;
        }
        //占位
        if (defaultImage != -1) {
            options = options.placeholder(defaultImage);
        }
        //加载错误图
        if (errorImage != -1) {
            options = options.error(errorImage);
        }
        return options;
    }
}