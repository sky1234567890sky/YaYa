package com.administrator.yaya.base;

public interface ICommonModel<T> {
    void getData(ICommonView view, int whichApi, T... t);
}
