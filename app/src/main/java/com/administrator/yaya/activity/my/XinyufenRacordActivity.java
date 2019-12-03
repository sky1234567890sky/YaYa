package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.ranking.TodayRankingFragment;
import com.administrator.yaya.activity.my.ranking.TuiguangRankingFragment;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.custom.CircularProgressView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * 信誉分记录
 */
public class XinyufenRacordActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.xinyufen_back_iv)
    ImageView mBack;
    @BindView(R.id.xinyufen_shuoming_btn)
    ImageView mShuomingBtn;

    @BindView(R.id.xinyufen_chegnji)
    TextView mTv1;
    @BindView(R.id.xinyufen_chegnji1)
    TextView mTv2;
    @BindView(R.id.myinvite_mlist)
    RecyclerView mList;
    @BindView(R.id.myinvite_refreshLayout)
    SmartRefreshLayout mRefresh;
    @BindView(R.id.progress_xinyufen)
    CircularProgressView progress_xinyufen;

    private int index = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_xinyufen_racord);
//        ButterKnife.bind(this);
//
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xinyufen_racord;
    }


    @Override
    protected void initView() {
        super.initView();

//        PieChartView pieChartView = findViewById(R.id.pie_chart_view);
//        pieChartView.setCell(5);            //设置环形图的间距
//        pieChartView.setInnerRadius(0.5f);  //设置环形图内环半径比例 0 - 1.0f
////        pieChartView.setBackGroundColor(R.color.bg_piechar_color);//环形 背景色

//        pieChartView.addItemType(new PieChartView.ItemType("", 50, R.color.blue));
//        pieChartView.addItemType(new PieChartView.ItemType("", 50, 0xff20B2AA));



    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(R.string.error+"");
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
    @OnClick({R.id.xinyufen_back_iv, R.id.xinyufen_shuoming_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinyufen_back_iv:
                this.finish();
                break;
            case R.id.xinyufen_shuoming_btn:
                Intent intent = new Intent(this,GameMoneyExplainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
