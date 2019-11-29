package com.administrator.yaya.activity.my.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.my.adapter.RebateAdapter;
import com.administrator.yaya.base.ApiConfig;
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
 * 返利   3
 */
public class RebateFragment extends BaseLazyLoadFragment<LoginModel> implements ICommonView {
    @BindView(R.id.rebate_lv)
    RecyclerView mList;
    @BindView(R.id.rebate_refreshLayout)
    SmartRefreshLayout rebateRefreshLayout;
    private RebateAdapter adapter;
    private ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;
    private String userId;
    private String token;

    public RebateFragment() {
        // Required empty public constructor
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //不可见的时候关闭加载
//        if (!isVisibleToUser) {
//            if (rebateRefreshLayout != null) {
//                rebateRefreshLayout.finishRefresh();
//            }
//        } else {
//            super.setUserVisibleHint(isVisibleToUser);
//        }

        if (isVisibleToUser ==true){//当前处于可见状态
            if (rebateRefreshLayout!=null){
                refresh();
            }
        }
    }

    @Override
    public void fetchData() {
//        initData();
    }

    @Override
    public void refresh() {
        super.refresh();
        mList.scrollToPosition(0);
//        rebateRefreshLayout.autoRefresh();
        initData();
    }

    @Override
    public void loadMore() {
        super.loadMore();
        rebateRefreshLayout.finishLoadMoreWithNoMoreData();
        rebateRefreshLayout.setNoMoreData(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rebate;
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RebateAdapter(list);
        mList.setAdapter(adapter);
    }
    @Override
    protected void initData() {
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);
        if (userId !=null)mPresenter.getData(ApiConfig.TEST_MY_EARNINGS,Integer.parseInt(userId),token,3);//收益类型--1收入-2支出-3返利
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
                list.clear();

                TestMyEarnings testMyEarnings = (TestMyEarnings) t[0];
                if (testMyEarnings.getMsg().equals(SignOut)){

                    Toast.makeText(getActivity(), R.string.username_login_hint+"", Toast.LENGTH_SHORT).show();

                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();
                }else if (testMyEarnings.getCode()==0 && testMyEarnings.getData()!=null) {
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
                }
                break;
        }
        rebateRefreshLayout.finishRefresh();
        rebateRefreshLayout.finishLoadMore();
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
