package com.administrator.yaya.base;

interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
