package com.jzk.commonwms.view.rxjava_zip;

import com.jzk.commonwms.data.zip.InjectMoldBean;
import com.jzk.commonwms.data.zip.StationBean;
import com.jzk.commonwms.data.zip.StationRequest;
import com.jzk.commonwms.data.zip.ZipResult;
import com.jzk.commonwms.http.HttpManagerImp;
import com.jzk.commonwms.http.api.ApiService;
import com.jzk.httplibrary.bean.CommonResult;
import com.jzk.httplibrary.callback.ApiServiceMethodCallBack;
import com.jzk.httplibrary.subscriber.HttpSubscriber;
import com.jzk.mvplibrary.model.impl.MvpBaseModel;

import io.reactivex.Observable;

/**
 * $dsc Rxjava Zip 的model
 *
 * @author: timi
 * create at: 2018-08-13 14:05
 */
public class RxjavaZipModel extends MvpBaseModel {
    public void RxjavaZip(StationRequest request, HttpSubscriber<ZipResult> stationsHttpSubscriber) {
        HttpManagerImp.getInstance().toSubscribe(request, stationsHttpSubscriber);
    }
}
