package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.TestInventoryAdapter;
import com.administrator.yaya.activity.my.ranking.TodayRankingFragment;
import com.administrator.yaya.activity.my.ranking.TuiguangRankingFragment;
import com.administrator.yaya.activity.my.rankinga_dapter.RankingPagerAdapter;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 排行榜
 */
public class RankingListActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.rankinglist_back_iv)
    ImageView mBack;
    @BindView(R.id.rankinglist_tab)
    SlidingTabLayout mTab;
    @BindView(R.id.ranking_vp)
    ViewPager mVp;

    private TodayRankingFragment todayRanking;
    private TuiguangRankingFragment tuiguangRanking;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private RankingPagerAdapter adapter;

    @Override
    protected void initView() {
        super.initView();

        //沉浸式
        makeStatusBarTransparent(this);

        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        todayRanking = new TodayRankingFragment();
        tuiguangRanking = new TuiguangRankingFragment();
        fragments.add(todayRanking);
        fragments.add(tuiguangRanking);
        titles.add("今日排行");
        titles.add("推广排行");

        adapter = new RankingPagerAdapter(getSupportFragmentManager(),fragments,titles);
        mVp.setAdapter(adapter);
        mTab.setViewPager(mVp);
        mVp.setCurrentItem(0);
        if (mTab.getTabCount() > 0) mTab.setCurrentTab(0);//大于一是因为多个fragment
        adapter.notifyDataSetChanged();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ranking_list;
    }
    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong( getResources().getString(R.string.error));
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }


    @OnClick({R.id.rankinglist_back_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rankinglist_back_iv:
                this.finish();
                break;
        }
    }

}
