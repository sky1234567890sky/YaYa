package com.administrator.yaya.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer {

    private Disposable mDisposable;

    public abstract void onSuccess(Object value);

    public abstract void onFailed(Throwable e);


    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(Object o) {
        onSuccess(o);
        disPos();

    }

    private void disPos() {
        if (!mDisposable.isDisposed())mDisposable.dispose();
    }

    @Override
    public void onError(Throwable e) {
        onFailed(e);
        disPos();
    }

    @Override
    public void onComplete() {
        complete();
    }

    public void complete() {

    }

}
