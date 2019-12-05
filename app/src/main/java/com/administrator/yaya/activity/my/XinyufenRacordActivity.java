package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.my.adapter.XinyufenAdapter;
import com.administrator.yaya.activity.my.rankinga_dapter.TodayAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestXinyufenJilu;
import com.administrator.yaya.custom.CircularProgressView;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 信誉分记录
 */
public class XinyufenRacordActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.xinyufen_back_iv)//返回
            ImageView mBack;
    @BindView(R.id.xinyufen_shuoming_btn)//右上角说明
            ImageView mShuomingBtn;

    @BindView(R.id.xinyufen_chegnji)//信誉分数  进度条内的 数字
            TextView mTv1;
    @BindView(R.id.xinyufen_chegnji1)//良好
            TextView mTv2;
    @BindView(R.id.myinvite_mlist)
    RecyclerView mlist;
    @BindView(R.id.myinvite_refreshLayout)
    SmartRefreshLayout mRefresh;
    @BindView(R.id.progress_xinyufen)
    CircularProgressView progress_xinyufen;

    private int index = 0;
    private ArrayList<TestXinyufenJilu.DataBean.ListBean> list = new ArrayList<>();
    private XinyufenAdapter adapter;
    private String token;
    private String userId;

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
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
//        PieChartView pieChartView = findViewById(R.id.pie_chart_view);
//        pieChartView.setCell(5);            //设置环形图的间距
//        pieChartView.setInnerRadius(0.5f);  //设置环形图内环半径比例 0 - 1.0f
////        pieChartView.setBackGroundColor(R.color.bg_piechar_color);//环形 背景色

//        pieChartView.addItemType(new PieChartView.ItemType("", 50, R.color.blue));
//        pieChartView.addItemType(new PieChartView.ItemType("", 50, 0xff20B2AA));

        initRecycleView(mlist,mRefresh);
        mlist.setLayoutManager(new LinearLayoutManager(this));
//        expendRefreshLayout.setEnableLoadMore(false);
        adapter = new XinyufenAdapter(list);
        mlist.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        //信用分 记录
        mPresenter.getData(ApiConfig.TEST_XINYUFEN_JILU,Integer.parseInt(userId),token);
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong( getResources().getString(R.string.error));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {

        switch (whichApi) {
            //信誉分
            case ApiConfig.TEST_XINYUFEN_JILU:
                list.clear();

                TestXinyufenJilu testXinyufenJilu = (TestXinyufenJilu) t[0];
                if (testXinyufenJilu.getMsg().equals(mApplication)) {

                    ToastUtil.showLong(R.string.username_login_hint + "");

                    Intent login = new Intent(this, LoginActivity.class);

                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");

                    startActivity(login);

                    finish();
                }else if (testXinyufenJilu.getCode()==0){
                    TestXinyufenJilu.DataBean data1 = testXinyufenJilu.getData();
                    int userCredit = data1.getUserCredit();
                    String creditName = data1.getCreditName();
                    progress_xinyufen.setProgress(userCredit);
//                    progress_xinyufen.setAnimation();

                    mTv1.setText(userCredit+"");//信用分
                    mTv2.setText(creditName);

                    List<TestXinyufenJilu.DataBean.ListBean> list1 = data1.getList();
                    list.addAll(list1);
//                    adapter.setData(data1.getCreditName());
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        mRefresh.finishRefresh();
        mRefresh.finishLoadMore();
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
            case R.id.xinyufen_shuoming_btn://信誉分说明
//GameMoneyExplainActivity
                Intent intent = new Intent(this, XinyufenShuomingActivity.class);
                startActivity(intent);
                
                break;
        }
    }

    //刷新数据
    @Override
    protected void onResume() {//退出
        super.onResume();
        initData();
    }

    @Override
    protected void onPause() {//进入
        super.onPause();
        initData();
    }
}
