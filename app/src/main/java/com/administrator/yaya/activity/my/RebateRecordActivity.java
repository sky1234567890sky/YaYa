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
import com.administrator.yaya.activity.my.adapter.MyXiajiAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestMyInvite;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
//返利记录
public class RebateRecordActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.fanlijilu_back)
    ImageView mBack;
    @BindView(R.id.fanli_dengji_iv)
    ImageView mDengjiIv;
    @BindView(R.id.fanli_headler_iv)
    RoundedImageView mHeadlerIv;
    @BindView(R.id.fanli_name)
    TextView mName;
    @BindView(R.id.fanli_id)
    TextView nId;
    @BindView(R.id.fanli_bili)
    TextView mFanliBili;
    @BindView(R.id.fanli_jinri)
    TextView mFanliJinri;
    @BindView(R.id.fanli_brnyue)
    TextView mfanliBrnyue;
    @BindView(R.id.fanli_mlist)
    RecyclerView mList;
    @BindView(R.id.fanli_refresh)
    SmartRefreshLayout mRefresh;

//    private List<TestMyInvite.DataBean.UserInfoBean.ParentUserBean> juniorUsers = new ArrayList<>();//上级
//    juniorUsers			下级用户集合

    private List<TestMyInvite.DataBean.UserInfoBean.ParamsBean> myLowerList = new ArrayList<>();//下级
    //    parentUser			上级用户对象信息
    private List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> list =new ArrayList<>();
    private MyXiajiAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_rebate_record2;
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
    protected void initView() {
        super.initView();
        initRecycleView(mList,mRefresh);
        mList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyXiajiAdapter(list);
        mList.setAdapter(adapter);
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
        mRefresh.setEnableScrollContentWhenLoaded(true);
        mList.scrollToPosition(0);
//        mRefresh.autoRefresh();
        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();
        mRefresh.finishLoadMoreWithNoMoreData();
        mRefresh.setEnableScrollContentWhenLoaded(true);//设置是否在加载更多完成之后滚动内容显示新数据
    }

    @Override
    protected void initData() {
        super.initData();
        //        mySuperiorRl.setLayoutManager(new LinearLayoutManager(this));
//        myLowerRl.setLayoutManager(new LinearLayoutManager(this));
//        mySuperiorAdapter = new MySuperiorAdapter(myLowerList);//下级无数据
//        myLowerAdapter = new MyLowerAdapter(juniorUsers);//上级
//        myLowerRl.setAdapter(mySuperiorAdapter);
//        mySuperiorRl.setAdapter(myLowerAdapter);

        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        String token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);

        mPresenter.getData(ApiConfig.TEST_MY_INVITE,Integer.parseInt(userId),token);
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(R.string.error+"");
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
//            我的邀请 - 查看返利记录
            case ApiConfig.TEST_MY_INVITE:
                list.clear();

                TestMyInvite testMyInvite = (TestMyInvite) t[0];
                if (testMyInvite.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong("您的当前账户已在其他设备登陆，为安全起见，请及时修改密码或重新登陆!");
                    Intent intent = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid = 0;
                    mApplication.mToken = "";
                    startActivity(intent);
                    finish();
                }
                if (testMyInvite.getCode() == 0 && !testMyInvite.getMsg().equals(mApplication.SignOut)) {
                    TestMyInvite.DataBean data = testMyInvite.getData();
//                    allUserContributeTotal  累计返利
                    int allUserContributeTotal = data.getAllUserContributeTotal();
//                    userContributeTotalToday 今日返利
                    int userContributeTotalToday = data.getUserContributeTotalToday();
//                    profit      返利比例
//                    userInfo:用户基本信息
                    TestMyInvite.DataBean.UserInfoBean userInfo = data.getUserInfo();///用户基本信息
//                    TestMyInvite.DataBean.UserInfoBean.ParentUserBean parentUser = userInfo.getParentUser();
                    String userLevelName = userInfo.getUserLevelName();
//                    userId   用户id
                    int userId = userInfo.getUserId();
                    nId.setText("ID : "+userId);
//                    userLevelName 级别名称
//                    userHeadImg  头像
                    String userHeadImg = userInfo.getUserHeadImg();
//                    juniorUsers   下级用户集合
                    List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> juniorUsers = userInfo.getJuniorUsers();
//                    userName  用户姓名
                    String userName = userInfo.getUserName();
                    int userLevel = userInfo.getUserLevel();
//                    junior   今日贡献
                    String junior = userInfo.getJunior();
//                    userContributeTotal 总贡献
                    userInfo.getUserContributeTotal();

                    Glide.with(this).load(userHeadImg).placeholder(R.mipmap.icon).into(mHeadlerIv);
                    mName.setText(userName);
                    mFanliJinri.setText(userContributeTotalToday+"");//今日收益
                    mfanliBrnyue.setText(allUserContributeTotal+"");//本月收益
                    double userProfit = userInfo.getUserProfit();
                    mFanliBili.setText("返利比例："+userProfit);

//                    String [] jibie = {"黄金","铂金","钻石","王者","星耀"};
                    int [] iv = {R.mipmap.icon_huangjin,R.mipmap.icon_bojin,R.mipmap.icon_zuanshi,R.mipmap.icon_wangzhe,R.mipmap.icon_xingyao};

                    if (userLevel == 1){
                        Glide.with(this).load(iv[0]).placeholder(R.mipmap.icon).into(mDengjiIv);
                    }else  if (userLevel == 2){
                        Glide.with(this).load(iv[1]).placeholder(R.mipmap.icon).into(mDengjiIv);
                    }else  if (userLevel == 3){
                        Glide.with(this).load(iv[2]).placeholder(R.mipmap.icon).into(mDengjiIv);
                    }else  if (userLevel == 4){
                        Glide.with(this).load(iv[3]).placeholder(R.mipmap.icon).into(mDengjiIv);
                    }else  if (userLevel == 5){
                        Glide.with(this).load(iv[4]).placeholder(R.mipmap.icon).into(mDengjiIv);
                    }
                        list.addAll(juniorUsers);//下级
                        adapter.notifyDataSetChanged();
                }

                break;
        }
        mRefresh.finishRefresh();
        mRefresh.finishLoadMore();
    }
    @Override
    protected void initListener() {
        super.initListener();

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }
}
