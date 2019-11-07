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
import com.administrator.yaya.bean.my.TestMyEarnings;
import com.administrator.yaya.bean.my.TestRebate;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 返利
 */
public class RebateFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.rebate_lv)
    RecyclerView mList;
    @BindView(R.id.rebate_refreshLayout)
    SmartRefreshLayout rebateRefreshLayout;
    private RebateAdapter adapter;
    private ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;

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
    protected void initData() {
        String userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        if (userId!=null)mPresenter.getData(ApiConfig.TEST_MY_EARNINGS,Integer.parseInt(userId),1);//收益类型--1收入-2支出-3返利
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
            case ApiConfig.TEST_MY_EARNINGS://返利
                TestMyEarnings testMyEarnings = (TestMyEarnings) t[0];
                if (testMyEarnings.getCode()==0 && testMyEarnings.getData()!=null)  {
                    TestMyEarnings.DataBean data = testMyEarnings.getData();
                    List<TestMyEarnings.DataBean.UserEarningsListBean> userEarningsList = data.getUserEarningsList();
                    list.addAll(userEarningsList);
                    adapter.notifyDataSetChanged();
                    Log.i("tag", "返利: " + testMyEarnings.toString());
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
                    ToastUtil.showShort(testMyEarnings.getMsg());
                }
                break;
        }
    }
}
