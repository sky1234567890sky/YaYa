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
import com.administrator.yaya.model.LoginModel;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 支出
 */
public class ExpendFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.expend_lv)
    RecyclerView mList;
    private ExpendAdapter adapter;
    private ArrayList<?> list;

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_EXPEND://支出
                TestExpend testExpend = (TestExpend) t[0];
                if (testExpend.getCode()==0 && testExpend.getData()!=null) {
                    Log.i("tag", "支出: " + testExpend.toString());

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
