package com.administrator.yaya.base.convert;

import android.os.Bundle;

import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.ICommonView;

/**
 * 懒加载工具类
 */
public abstract class BaseLazyLoadFragment<M> extends BaseMvpFragment implements ICommonView {

    protected boolean isViewInitiated;//判断视图是否初始化
    protected boolean isVisibleToUser;//用户是否可见
    protected boolean isDataInitiated;//数据是否初始化

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }
    //在所有生命周期函数之前调用，查看是否可见
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    //定义一个抽象函数，在子类中实现，作用就是加载初始化数据
    public abstract void fetchData();
    //准备加载数据，这里不是强制刷新
    public boolean prepareFetchData() {
        return prepareFetchData(true);//开启懒加载
    }
    //用户强制刷新的话，就应该是用户主动进行刷新了，当然也要去取数据了，用户第一嘛
    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
        isDataInitiated = true;
        return true;
    }
        return false;
    }
}