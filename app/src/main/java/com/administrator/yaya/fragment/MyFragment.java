package com.administrator.yaya.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.PersonalDatActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.activity.my.SystemMessagesActivity;
import com.administrator.yaya.utils.ChangTvSizeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    @BindView(R.id.get_gamemoney_tv)
    TextView getGamemoneyTv;
    @BindView(R.id.all_gamemoney_tv)
    TextView allGamemoneyTv;
    Unbinder unbinder;
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

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        SpannableString getInventory = ChangTvSizeUtils.changTVsize("23.90");
        getGamemoneyTv.setText(getInventory);
        allGamemoneyTv.setText(getInventory);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.system_msg_iv, R.id.setting_iv,R.id.my_ll})
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
        }
    }
}
