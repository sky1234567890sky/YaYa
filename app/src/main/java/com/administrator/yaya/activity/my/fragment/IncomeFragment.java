package com.administrator.yaya.activity.my.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.IncomeAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
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
 * 收入记录
 */
public class IncomeFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.income_lv)
    RecyclerView mList;
    @BindView(R.id.income_refreshLayout)
    SmartRefreshLayout incomeRefreshLayout;

    private IncomeAdapter adapter;
    private ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;
    public IncomeFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new IncomeAdapter(list);
        mList.setAdapter(adapter);

    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_income;
    }
    @Override
    protected void initData() {
        super.initData();
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
            case ApiConfig.TEST_MY_EARNINGS://收入
                TestMyEarnings testMyEarnings = (TestMyEarnings) t[0];
                if (testMyEarnings.getCode()==0 && testMyEarnings.getData()!=null)  {
//                    Log.i("tag", "收入: " + testMyEarnings.toString());
                    TestMyEarnings.DataBean data = testMyEarnings.getData();
                    List<TestMyEarnings.DataBean.UserEarningsListBean> userEarningsList = data.getUserEarningsList();
                    list.addAll(userEarningsList);
                    adapter.notifyDataSetChanged();
                }
          }
    }
}
