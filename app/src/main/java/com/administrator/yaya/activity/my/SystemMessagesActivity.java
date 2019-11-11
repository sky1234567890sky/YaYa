package com.administrator.yaya.activity.my;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.SystemMessagesAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestNotificationInfo;
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
 * 系统消息
 */
public class SystemMessagesActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.system_msg_back_iv)
    ImageView systemMsgBackIv;

    @BindView(R.id.system_msg_recyclerView)
    RecyclerView mList;
    @BindView(R.id.system_msg_refreshLayout)
    SmartRefreshLayout mRefresh;

//    @BindView(R.id.system_msg_refreshLayout)
//    SmartRefreshLayout systemMsgRefreshLayout;
    private List<TestNotificationInfo.DataBean> list;
    private SystemMessagesAdapter adapter;

    //    recycleview
    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_messages;
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
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        initRecycleView(mList,mRefresh);//
        mList.setLayoutManager(new LinearLayoutManager(this));
        //禁止加载
        mRefresh.setEnableLoadMore(false);
        adapter = new SystemMessagesAdapter(list);
        mList.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        super.refresh();
        //走一遍数据加载
        initData();
    }
    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        if (userId!=null)mPresenter.getData(ApiConfig.TEST_NOTIFICATION_INFO,Integer.parseInt(userId));
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_NOTIFICATION_INFO:

                if(!list.isEmpty() || list!=null){
                    list.clear();
                }


                TestNotificationInfo testNotificationInfos  = (TestNotificationInfo) t[0];
            if (testNotificationInfos.getCode()==0 && testNotificationInfos.getData()!=null){
//                Log.i("tag", "通知消息: "+testNotificationInfos.getData().toString());
                List<TestNotificationInfo.DataBean> data = testNotificationInfos.getData();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }else{
                ToastUtil.showShort(testNotificationInfos.getMsg());
            }
                break;
        }
        mRefresh.finishRefresh();

    }
    @OnClick({R.id.system_msg_back_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.system_msg_back_iv:
                SystemMessagesActivity.this.finish();
                break;
        }
    }
}
