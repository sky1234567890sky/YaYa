package com.administrator.yaya.activity.my.ranking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.rankinga_dapter.TodayAdapter;
import com.administrator.yaya.activity.my.rankinga_dapter.TuiguangRankingAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.ranking.TestTodayRanking;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * 推广排行
 */
public class TuiguangRankingFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.tuiguang_hint_refresh_tv)
    TextView mHintRefreshTv;
    @BindView(R.id.tuiguang_di_ming)
    TextView mDiMing;
    @BindView(R.id.tuiguang_mlist)
    RecyclerView mlist;
    @BindView(R.id.tuiguang_refreshLayout)
    SmartRefreshLayout mRefresh;
    private ArrayList<TestTodayRanking.DataBean.ListBean> list = new ArrayList<>();
    private TuiguangRankingAdapter adapter;
    private String userId;

    public TuiguangRankingFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tuiguang_ranking;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        initRecycleView(mlist, mRefresh);
        mlist.setLayoutManager(new LinearLayoutManager(getContext()));

//        expendRefreshLayout.setEnableLoadMore(false);
        adapter = new TuiguangRankingAdapter(list);
        mlist.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        super.refresh();
        //自动回弹
        mRefresh.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefresh.finishRefresh();

            }
        }, 200l);
        mlist.scrollToPosition(0);
//        expendRefreshLayout.autoRefresh();
        initData();
    }

    @Override
    public void loadMore() {
        super.loadMore();
        mRefresh.finishLoadMoreWithNoMoreData();
        mRefresh.setNoMoreData(true);
    }

    @Override
    protected void initData() {
        super.initData();
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        //推广排行
        mPresenter.getData(ApiConfig.TEST_TUIGUANG_RANKING, Integer.parseInt(userId));
    }

    @Override
    protected void initListener() {
        super.initListener();

    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong( getResources().getString(R.string.error));

    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_TUIGUANG_RANKING:
                list.clear();

                TestTodayRanking testTodayRanking = (TestTodayRanking) t[0];
                if (testTodayRanking.getCode() == 0) {
                    TestTodayRanking.DataBean data = testTodayRanking.getData();
                    List<TestTodayRanking.DataBean.ListBean> list1 = data.getList();
                    list.addAll(list1);
                    TestTodayRanking.DataBean.UserInfoTopBean userInfoTop = data.getUserInfoTop();
                    String uname = userInfoTop.getUname();
                    int id = userInfoTop.getId();
                    int ucount = userInfoTop.getUcount();
                    int uid = userInfoTop.getUid();
//                    id   排名
//                    uname  名称
//                    ucount  成交单数
                    if (id == 0) {
                        mDiMing.setText("您今日未上榜");
                    } else {
                        mDiMing.setText("您的排名是第" + id + "名，成交" + ucount + "单");
                    }

//                    mHintTv.setText("");
                    adapter.setData(userInfoTop);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        mRefresh.finishRefresh();
        mRefresh.finishLoadMore();
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }
}
