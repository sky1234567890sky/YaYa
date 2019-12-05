package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 信誉分说明界面
 */
public class XinyufenShuomingActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.xinyujifen_iv)
    ImageView mBack;
    @BindView(R.id.xinyujifen_tv)
    TextView mJifenTv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xinyufen_shuoming;
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(getResources().getString(R.string.error) + "");
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.xinyujifen_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //返回
            case R.id.xinyujifen_iv:
                finish();
                break;
        }
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

}
