package com.administrator.yaya.base;

public abstract class BaseMvpFragment<M> extends BaseFragment implements ICommonView{

    public CommonPresenter mPresenter;
    public M mModel;
    @Override
    protected void initMvp() {
        super.initMvp();
        mPresenter = getPresenter();
        mModel = getModel();
        if (mPresenter != null && mModel != null) mPresenter.attach(this, (ICommonModel) mModel);
    }
    protected abstract M getModel();

    protected abstract CommonPresenter getPresenter();

    protected int getLoadType(Object[] t){
        return  t != null && t.length>1 ? (int) t[1] : 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }


}
