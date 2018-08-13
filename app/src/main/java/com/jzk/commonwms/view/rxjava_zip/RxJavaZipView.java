package com.jzk.commonwms.view.rxjava_zip;

import com.jzk.commonwms.data.zip.InjectMoldBean;
import com.jzk.commonwms.data.zip.StationBean;
import com.jzk.commonwms.data.zip.ZipResult;
import com.jzk.mvplibrary.view.iml.MvpBaseView;

/**
 * $dsc Rxjava zip  view
 * create at: 2018-08-13 14:04
 * @author jzk
 */
public interface RxJavaZipView extends MvpBaseView {
    void rxjavaZipRequest(ZipResult o);

}
