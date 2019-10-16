package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TODO:我的收益（累计收益）界面
 */
public class MyIncomeActivity extends AppCompatActivity {
    @BindView(R.id.myincome_back_iv)
    ImageView myincomeBackIv;

    @BindView(R.id.get_gamemoney_tv)
    TextView getGamemoneyTv;
    @BindView(R.id.all_gamemoney_tv)
    TextView allGamemoneyTv;

    @BindView(R.id.myincome_vp)
    ViewPager vp;
    @BindView(R.id.iNventory_tab)
    TabLayout mTab;

//    @BindView(R.id.tab_layout)
//    SlidingTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_income);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {
//        tabLayout.addNewTab("收入记录");
//        tabLayout.addNewTab("支出记录");
//        tabLayout.addNewTab("返利记录");
        mTab.addTab(mTab.newTab().setText("收入记录"));
        mTab.addTab(mTab.newTab().setText("支出记录"));
        mTab.addTab(mTab.newTab().setText("返利记录"));
    }

    private void initListener() {
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        vp.setCurrentItem(0);
                        break;
                    case 1:
                        vp.setCurrentItem(1);
                        break;
                    case 2:
                        vp.setCurrentItem(2);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
//        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                switch (position) {
//                    case 0:
//                    vp.setCurrentItem(0);
//                        break;
//                    case 1:
//                        vp.setCurrentItem(1);
//                        break;
//                    case 2:
//                        vp.setCurrentItem(2);
//                        break;
//                }
//            }
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });
////        vp.addOnPageChangeListener(new SlidingTabLayout(tabLayout));
//        tabLayout.setViewPager(vp);
    }
}
