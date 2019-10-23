package com.administrator.yaya.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.MyIncomeActivity;
import com.administrator.yaya.activity.my.MyInviteActivity;
import com.administrator.yaya.activity.my.PersonalDatActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.activity.my.SystemMessagesActivity;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ChangTvSizeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.get_gamemoney_tv)
    TextView getGamemoneyTv;
    @BindView(R.id.all_gamemoney_tv)
    TextView allGamemoneyTv;
    @BindView(R.id.inventory_money)
    TextView inventoryMoney;

    @BindView(R.id.system_msg_iv)
    ImageView systemMsgIv;
    @BindView(R.id.setting_iv)
    ImageView settingIv;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.my_name_tv)
    TextView myNameTv;
    @BindView(R.id.my_name_state_tv)
    TextView myNameStateTv;
    @BindView(R.id.tv_use)
    TextView tvUse;
    @BindView(R.id.tv_sheng)
    TextView tvSheng;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_wechat_use)
    TextView tvWechatUse;
    @BindView(R.id.tv_wechat_sheng)
    TextView tvWechatSheng;
    @BindView(R.id.tv_wechat_day)
    TextView tvWechatDay;
    @BindView(R.id.my_ll)
    RelativeLayout myLl;
    @BindView(R.id.wire)
    View wire;
    @BindView(R.id.my_right_ll)
    LinearLayout myRightLl;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View inflate) {
        SpannableString getInventory = ChangTvSizeUtils.changTVsize("0.00");
        getGamemoneyTv.setText(getInventory);
        SpannableString getInventory2 = ChangTvSizeUtils.changTVsize("1900.00");
        allGamemoneyTv.setText(getInventory2);

    }

    @Override
    protected void initData() {


    }

    @OnClick({R.id.system_msg_iv, R.id.setting_iv, R.id.my_ll,R.id.my_right_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.system_msg_iv://系統消息
                Intent intent = new Intent(getActivity(), SystemMessagesActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_iv:
                Intent sa = new Intent(getActivity(), SettingActivity.class);
                startActivity(sa);
                break;
            case R.id.my_ll:
                Intent pd = new Intent(getActivity(), PersonalDatActivity.class);
                startActivity(pd);
                break;

                case R.id.my_right_ll:
                Intent myincome = new Intent(getActivity(), MyIncomeActivity.class);
                startActivity(myincome);
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

    @Override
    public void onError(int whichApi, Throwable e) {

    }
    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

}
