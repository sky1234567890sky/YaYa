package com.administrator.yaya.activity.my.fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.ExpendAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.convert.BaseLazyLoadFragment;
import com.administrator.yaya.bean.my.TestMyEarnings;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
/**
 * A simple {@link Fragment} subclass.
 * 支出    2
 */
public class ExpendFragment extends BaseLazyLoadFragment<LoginModel> implements ICommonView {
    @BindView(R.id.expend_lv)
    RecyclerView mList;
    @BindView(R.id.expend_refreshLayout)
    SmartRefreshLayout expendRefreshLayout;
    private ExpendAdapter adapter;
    private ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;
    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //不可见的时候关闭加载
//        if (!isVisibleToUser) {
//            if (expendRefreshLayout != null) {
//                expendRefreshLayout.finishRefresh();
//            }
//        } else {
//            super.setUserVisibleHint(isVisibleToUser);
//        }

        if (isVisibleToUser ==true){//当前处于可见状态
            if (expendRefreshLayout!=null){
                refresh();
            }
        }
    }
    @Override
    public void refresh() {
        super.refresh();
        //自动回弹
        expendRefreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                expendRefreshLayout.finishRefresh();

            }
        }, 200l);
        mList.scrollToPosition(0);
//        expendRefreshLayout.autoRefresh();
        initData();
    }

    @Override
    public void loadMore() {
        super.loadMore();
        expendRefreshLayout.finishLoadMoreWithNoMoreData();

        expendRefreshLayout.setNoMoreData(true);
    }

    @Override
    public void fetchData() {

    }

    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        String token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);
        if (userId!=null)mPresenter.getData(ApiConfig.TEST_MY_EARNINGS,Integer.parseInt(userId),token,2);//收益类型--1收入-2支出-3返利
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_MY_EARNINGS://支出
                if (!list.isEmpty() || list != null) {
                    list.clear();
                }
                TestMyEarnings testMyEarnings = (TestMyEarnings) t[0];
                if (testMyEarnings.getCode()==0 && testMyEarnings.getData()!=null)  {
                    Log.i("tag", "支出: " + testMyEarnings.toString());
                    TestMyEarnings.DataBean data = testMyEarnings.getData();
                    List<TestMyEarnings.DataBean.UserEarningsListBean> userEarningsList = data.getUserEarningsList();
                    list.addAll(userEarningsList);
                    adapter.notifyDataSetChanged();
                }
        }
        expendRefreshLayout.finishRefresh();
        expendRefreshLayout.finishLoadMore();
    }
    public ExpendFragment() {

    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_expend;
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);

        initRecycleView(mList,expendRefreshLayout);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
//        expendRefreshLayout.setEnableLoadMore(false);
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
        ToastUtil.showLong("服务器错误！");
    }
    //获取焦点时刷新
    @Override
    public void onResume() {
        super.onResume();
        if (isRefresh) {
            if (!list.isEmpty()){
                list.clear();
            }
            refresh();
            isRefresh = false;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if (!isRefresh) isRefresh = true;
    }
}
