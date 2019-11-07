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
import com.administrator.yaya.activity.my.adapter.ExpendAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestExpend;
import com.administrator.yaya.bean.my.TestIncome;
import com.administrator.yaya.bean.my.TestMyEarnings;
import com.administrator.yaya.bean.my.TestRebate;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 支出
 */
public class ExpendFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.expend_lv)
    RecyclerView mList;
    @BindView(R.id.expend_refreshLayout)
    SmartRefreshLayout expendRefreshLayout;
    private ExpendAdapter adapter;
    private ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;

    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        if (userId!=null)mPresenter.getData(ApiConfig.TEST_MY_EARNINGS,Integer.parseInt(userId),1);//收益类型--1收入-2支出-3返利
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_MY_EARNINGS://支出
                TestMyEarnings testMyEarnings = (TestMyEarnings) t[0];
                if (testMyEarnings.getCode()==0 && testMyEarnings.getData()!=null)  {
                    Log.i("tag", "支出: " + testMyEarnings.toString());
                    TestMyEarnings.DataBean data = testMyEarnings.getData();
                    List<TestMyEarnings.DataBean.UserEarningsListBean> userEarningsList = data.getUserEarningsList();
                    list.addAll(userEarningsList);
                    adapter.notifyDataSetChanged();
                }
        }
    }
    public ExpendFragment() {
        // Required empty public constructor
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_expend;
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new ExpendAdapter(list);
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
}
