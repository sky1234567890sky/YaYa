package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 系统消息
 */
public class SystemMessagesActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.system_msg_back_iv)
    ImageView systemMsgBackIv;
    @BindView(R.id.system_msg_recyclerView)
    RecyclerView systemMsgRecyclerView;
    @BindView(R.id.system_msg_refreshLayout)
    SmartRefreshLayout systemMsgRefreshLayout;

    //    recycleview
    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_messages;
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.system_msg_back_iv, R.id.system_msg_refreshLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.system_msg_back_iv:
                SystemMessagesActivity.this.finish();
                break;
            case R.id.system_msg_refreshLayout:
                break;
        }
    }
}
