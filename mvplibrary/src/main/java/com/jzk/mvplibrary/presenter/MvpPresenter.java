package com.jzk.mvplibrary.presenter;


import com.jzk.mvplibrary.view.MvpView;

/**
 * 抽象为接口
 * 
 * @author Dream
 *
 */
public interface MvpPresenter<V extends MvpView> {

	/**
	 * 绑定视图
	 * 
	 * @param view
	 */
	public void attachView(V view);

	/**
	 * 解除绑定
	 */
	public void dettachView();
	
}
