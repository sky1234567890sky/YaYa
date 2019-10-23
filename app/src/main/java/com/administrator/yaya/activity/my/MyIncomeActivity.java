package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ChangTvSizeUtils;
import com.administrator.yaya.utils.FragmentUtils;

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_income;
    }

    @Override
    protected void initView() {

        SpannableString getInventory = ChangTvSizeUtils.changTVsize("800.00");
        SpannableString getInventory2 = ChangTvSizeUtils.changTVsize("2900.00");

        getGamemonyTv.setText(getInventory);
        allGamemoneyTopTv.setText(getInventory2);
//        tabLayout.addNewTab("收入记录");
//        tabLayout.addNewTab("支出记录");
//        tabLayout.addNewTab("返利记录");
        mTab.addTab(mTab.newTab().setText("收入记录"));
        mTab.addTab(mTab.newTab().setText("支出记录"));
        mTab.addTab(mTab.newTab().setText("返利记录"));

        mTab.setupWithViewPager(vp);
    }
    @Override
    protected void initListener() {
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

    }
}
