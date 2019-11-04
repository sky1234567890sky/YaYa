package com.administrator.yaya.activity.my.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.RebateAdapter;
import com.administrator.yaya.activity.orderform.adapter.SellAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestRebate;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 返利
 */
public class RebateFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.rebate_lv)
    RecyclerView mList;
    private RebateAdapter adapter;
    private ArrayList<?> list;

    public RebateFragment() {
        // Required empty public constructor
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rebate;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new RebateAdapter(list);
        mList.setAdapter(adapter);
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
        switch (whichApi) {
            case ApiConfig.TEST_REBATE://返利
                TestRebate testRebate = (TestRebate) t[0];

                if (testRebate.getCode()==0 && testRebate.getData()!=null){

                    TestRebate.DataBean data = testRebate.getData();

                    TestRebate.DataBean.UserInfoBean userInfo = data.getUserInfo();

                    TestRebate.DataBean.UserInfoBean.ParamsBean params = userInfo.getParams();


                    Log.i("tag", "返利: " + testRebate.toString());
//                    用户信息:userInfo
//                    userName 用户姓名
//                    userNickName 昵称
//                    userEarningsTotal 总收益
//                    zfbEd 支付宝已使用额度
//                    wxEd 微信已使用额度
//                    userEarningsNow	当前可用收益
//                    userEarningsTotal	总收益
//                    收益记录集合:userEarningsList
//                    orderId	订单编号
//                    salesAmount	售卖数量
//                    earningsAmount	收益数量
//                    earningsType	收益类型--1收入-2支出-3返利
//                    earningsTime	收益日期
//                    userId			用户id
//                    userName		用户昵称
                }else{
                    ToastUtil.showShort(testRebate.getMsg());
                }
                break;
        }
    }
}
