package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.BR;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.activity.my.adapter.MyInviteFragmentAdapter;
import com.administrator.yaya.activity.my.fragment.ExpendFragment;
import com.administrator.yaya.activity.my.fragment.IncomeFragment;
import com.administrator.yaya.activity.my.fragment.RebateFragment;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestMyEarnings;
import com.administrator.yaya.bean.my.TestPutawayAllOrderStock;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ChangTvSizeUtils;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * TODO:我的收益（累计收益）界面
 */
public class MyIncomeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.myincome_back_iv)
    ImageView myincomeBackIv;
    @BindView(R.id.myincome_game_money_plain_iv)
    ImageView myincomeGameMoneyPlainIv;

    @BindView(R.id.get_gamemony_tv)
    TextView getGamemonyTv;

    @BindView(R.id.all_gamemoney_top_tv)
    TextView allGamemoneyTopTv;

    @BindView(R.id.get_gamemoney_down_tv)
    TextView getGamemoneyDownTv;

    @BindView(R.id.all_gamemoney_down_tv)
    TextView allGamemoneyDownTv;

    @BindView(R.id.iNventory_tab)
    TabLayout mTab;
    @BindView(R.id.myincome_vp)
    ViewPager vp;
    private PopupWindow popupWindow;
    private ArrayList<Fragment> fragments;
    private IncomeFragment incomeFragment;
    private ExpendFragment expendFragment;
    private RebateFragment rebateFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_income;
    }

    @Override
    protected void initView() {
        SpannableString getInventory = ChangTvSizeUtils.changTVsize("--");
        SpannableString getInventory2 = ChangTvSizeUtils.changTVsize("--");

        getGamemonyTv.setText(getInventory);
        allGamemoneyTopTv.setText(getInventory2);
//        tabLayout.addNewTab("收入记录");
//        tabLayout.addNewTab("支出记录");
//        tabLayout.addNewTab("返利记录");
        //收入Income
        //支出Expend
        //返利Rebate
        fragments = new ArrayList<>();
        incomeFragment = new IncomeFragment();//收入
        expendFragment = new ExpendFragment();//支出
        rebateFragment = new RebateFragment();//返利

        fragments.add(incomeFragment);
        fragments.add(expendFragment);
        fragments.add(rebateFragment);

        mTab.addTab(mTab.newTab().setText("收入记录"));
        mTab.addTab(mTab.newTab().setText("支出记录"));
        mTab.addTab(mTab.newTab().setText("返利记录"));
        ArrayList<String> titles = new ArrayList<>();
        titles.add("收入记录");
        titles.add("支出记录");
        titles.add("返利记录");
//        mTab.setupWithViewPager(vp);
        MyInviteFragmentAdapter myInviteFragmentAdapter = new MyInviteFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(myInviteFragmentAdapter);
        mTab.setupWithViewPager(vp);
    }

    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        if (userId!=null) {
            mPresenter.getData(ApiConfig.TEST_MY_EARNINGS, Integer.parseInt(userId), 1);
        }else{
            ToastUtil.showShort(R.string.networkerr+"");
        }
    }

    @Override
    protected void initListener() {
//        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0:
//                        vp.setCurrentItem(0);
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
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

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
//            }
//        });
////        vp.addOnPageChangeListener(new SlidingTabLayout(tabLayout));
    }

    @OnClick({R.id.myincome_back_iv, R.id.go_up,R.id.myincome_game_money_plain_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myincome_back_iv:
                MyIncomeActivity.this.finish();
                break;
            case R.id.go_up:
                popupPutaway();
                break;
            case R.id.myincome_game_money_plain_iv:
                startActivity(new Intent(this,GameMoneyExplainActivity.class));
                break;
        }
    }
    private void popupPutaway() {
        //上
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_putaway, null);
        //显示营业游戏币数量
        ImageView cancel_iv = inflate.findViewById(R.id.cancel_pop_close_iv);
        TextView mPopupTvNumber = inflate.findViewById(R.id.popup_tv_number);//上架数量
        TextView mPopupTvCancel = inflate.findViewById(R.id.popup_tv_cancel);
        TextView mPopupTvOk = inflate.findViewById(R.id.popup_tv_ok);

        mPopupTvNumber.setText("");

        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate, Gravity.CENTER , 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.5f;
        this.getWindow().setAttributes(lp);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = MyIncomeActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                MyIncomeActivity.this.getWindow().setAttributes(lp);
            }
        });
//        mCancelPopCloseIv.setOnClickListener(this);
//        mPopupTvCancel.setOnClickListener(this);
//        mPopupTvOk.setOnClickListener(this);

        cancel_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        mPopupTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        mPopupTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解析上架所有货物
//                mPresenter.getData(ApiConfig.TEST_PUTAWAY_ALL_ORDERSTOCK,);
                String userId = SharedPrefrenceUtils.getString(MyIncomeActivity.this, NormalConfig.USER_ID);
                if (userId!=null) {
                    mPresenter.getData(ApiConfig.TEST_PUTAWAY_ALL_ORDERSTOCK, Integer.parseInt(userId));
                }else{
                    ToastUtil.showShort(R.string.networkerr+"");
                }

                MainActivity mainActivity = new MainActivity();
                Intent intent = new Intent(MyIncomeActivity.this, MainActivity.class);
                intent.putExtra("upaway",3);
//                startActivity(new Intent(MainActivity.this,UpGameMoneyActivity.class));
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        popupWindow.setOutsideTouchable(false);
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
            //我的收益  收入
            case ApiConfig.TEST_MY_EARNINGS:
                TestMyEarnings testMyEarnings = (TestMyEarnings) t[0];
                if (testMyEarnings.getData()!=null &&testMyEarnings.getCode()==0){
                    TestMyEarnings.DataBean data = testMyEarnings.getData();
                    Log.i("tag", "我的收益: "+data.toString());
                }else{
                    ToastUtil.showShort(testMyEarnings.getMsg());
                }
                break;
                //上架所有货物
            case ApiConfig.TEST_PUTAWAY_ALL_ORDERSTOCK:
                TestPutawayAllOrderStock testPutawayAllOrderStock = (TestPutawayAllOrderStock) t[0];
                if (testPutawayAllOrderStock.getCode()==0){
                    ToastUtil.showShort(testPutawayAllOrderStock.getMsg());
                }else{
                    ToastUtil.showShort(testPutawayAllOrderStock.getMsg());
                }
                break;
        }

    }
}
