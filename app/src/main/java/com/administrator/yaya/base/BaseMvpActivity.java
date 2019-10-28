package com.administrator.yaya.base;

import android.widget.Toast;

import com.administrator.yaya.utils.ToastUtil;

public abstract class BaseMvpActivity<M> extends BaseActivity implements ICommonView {

    protected M mModel;
    protected CommonPresenter mPresenter;

    @Override
    protected void initMvp() {
        super.initMvp();
        mPresenter = getPresenter();
        mModel = getModel();
        if (mPresenter != null) mPresenter.attach(this, (ICommonModel) mModel);
    }

    protected abstract M getModel();

    protected abstract CommonPresenter getPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
    public void netErrorToast(Throwable e) {
        ToastUtil.showLong(e.getMessage());
    }
}
