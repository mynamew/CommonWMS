package com.jzk.commonwms.view.img;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jzk.commonwms.R;
import com.timi.imageloader.GlideImageLoader;
import com.timi.imageloader.GlideTransType;
import com.timi.imageloader.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 加载图片
 *
 * @author jzk
 * create at: 2018/8/13 11:13
 */
public class ImageLoadActivity extends AppCompatActivity {

    @BindView(R.id.iv_common)
    ImageView ivCommon;
    @BindView(R.id.iv_circle)
    ImageView ivCircle;
    @BindView(R.id.iv_corner)
    ImageView ivCorner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        ButterKnife.bind(this);
        String url="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2038250021,2741094129&fm=27&gp=0.jpg";
        new GlideImageLoader().displayImage(this,url,ivCommon, GlideTransType.NORMAL);
        new GlideImageLoader().displayImage(this,url,ivCircle, GlideTransType.CIRCLE);
        new GlideImageLoader().displayImage(this,url,ivCorner, GlideTransType.ROUND);
    }
}
