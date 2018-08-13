package com.jzk.commonwms.view.rxjava_zip;

import android.content.Context;

import com.jzk.commonwms.data.zip.InjectMoldBean;
import com.jzk.commonwms.data.zip.StationBean;
import com.jzk.commonwms.data.zip.StationRequest;
import com.jzk.commonwms.data.zip.ZipResult;
import com.jzk.commonwms.http.subscriber.HttpSubscriberImp;
import com.jzk.httplibrary.callback.OnResultCallBack;
import com.jzk.mvplibrary.presenter.impl.MvpBasePresenter;
import com.jzk.mvplibrary.utils.ToastUtils;

/**
 * $dsc
 *
 * @author: timi
 * create at: 2018-08-13 14:06
 */
public class RxjavaZipPresenter extends MvpBasePresenter<RxJavaZipView> {
    private RxjavaZipModel model;
    private HttpSubscriberImp<ZipResult> subscriberImp;

    public RxjavaZipPresenter(Context context) {
        super(context);
    }

    @Override
    public void initModel() {
        model = new RxjavaZipModel();
    }

    public void rxjavaZipRequest(StationRequest request) {
        if (null == subscriberImp) {
            subscriberImp = new HttpSubscriberImp<>(new OnResultCallBack<ZipResult>() {
                @Override
                public void onSuccess(ZipResult o) {
                    getView().rxjavaZipRequest(o);
                }

                @Override
                public void onError(String errorMsg) {
                    ToastUtils.showShort(getContext(), errorMsg);
                }
            });
        }
        model.RxjavaZip(request, subscriberImp);
    }
}
