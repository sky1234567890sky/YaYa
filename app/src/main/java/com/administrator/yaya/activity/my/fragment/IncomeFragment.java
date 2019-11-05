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
import com.administrator.yaya.bean.my.TestRebate;
import com.administrator.yaya.model.LoginModel;

import java.util.ArrayList;

import butterknife.BindView;
/**
 * A simple {@link Fragment} subclass.
 * 收入记录
 */
public class IncomeFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.income_lv)
    RecyclerView mList;
    private IncomeAdapter adapter;
    private ArrayList<Object> list;
    public IncomeFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new IncomeAdapter(list);
        mList.setAdapter(adapter);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_income;
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
            case ApiConfig.TEST_REBATE://收入
                TestIncome testIncome = (TestIncome) t[0];
                if (testIncome.getCode()==0 && testIncome.getData()!=null) {
                    Log.i("tag", "收入: " + testIncome.toString());

                }
          }
    }
}
