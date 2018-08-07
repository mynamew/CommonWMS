package com.jzk.httplibrary.subscriber;

import com.jzk.httplibrary.callback.OnResultCallBack;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
public abstract class HttpSubscriber<T> implements Observer<T> {
    /**
     * 是否自动隐藏加载框
     */
    private boolean isAutoDismiss = true;
    private OnResultCallBack mOnResultListener;
    private Disposable mDisposable;

    public HttpSubscriber(OnResultCallBack listener) {
        this.mOnResultListener = listener;
    }

    public HttpSubscriber(boolean isAutoDismiss, OnResultCallBack listener) {
        this.isAutoDismiss = isAutoDismiss;
        this.mOnResultListener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(T t) {
        if (isAutoDismiss) {
            hideProgressDialog();
        }
        if (mOnResultListener != null) {
            mOnResultListener.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        mOnResultListener.onError(e.getMessage());

        if (isAutoDismiss) {
            hideProgressDialog();
        }

    }

    @Override
    public void onComplete() {
        //进度条消失
        if (isAutoDismiss) {
            hideProgressDialog();
        }
    }

    public void unSubscribe() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
            //进度条消失
            if (isAutoDismiss) {
                hideProgressDialog();
            }
        }
    }

    /**
     * 隐藏弹出框
     */
    public abstract void hideProgressDialog();

    /**
     * 网络请求 失败返回的处理方法
     * @param e Throwable
     */
    public abstract void onErrorDeal(Throwable e);
}
