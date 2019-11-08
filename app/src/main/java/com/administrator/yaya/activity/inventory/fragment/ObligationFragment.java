package com.administrator.yaya.activity.inventory.fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.AffirmMessageActivity;
import com.administrator.yaya.activity.inventory.adapter.AccountPaidAdapter;
import com.administrator.yaya.activity.inventory.adapter.ObligationAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.TestCancelOrderStock;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * A simple {@link Fragment} subclass.
 * 待付款
 */
public class ObligationFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.obligstion_list)
    RecyclerView mList;

    @BindView(R.id.abligation_refreshLayout)
    SmartRefreshLayout abligationRefreshLayout;
    List<TestObligation.DataBean.OrderStockListBean> list ;
    private ObligationAdapter adapter;
    private int num = 1;
    private int anInt;
    private BaseApp app;
    private TestObligation.DataBean data;

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ObligationAdapter(list, getActivity());
        mList.setAdapter(adapter);
//        mList.addItemDecoration(adapter);
//        货物名称	comName  爲空
//        mDaifuGcomName.setText(orderStockListBean.getPayerName());
//        货物单价	comPrice
//        货物图片	comImg
//        库存数量	comInvent  ory
//        最小购买数量comPurchaseNumMin
//                最大购买数量comPurchaseNumMax
//        库存合计数量	amount
    }

    @Override
    public void refresh() {
        super.refresh();
    }
    @Override
    protected void initListener() {
        super.initListener();
        adapter.setAccountpaidsetOnclikListener(new ObligationAdapter.AccountpaidsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                //取消订单
                mPresenter.getData(ApiConfig.TEST_CANCEL_ORDER_STOCK, list.get(postion).getStockId());
            }
        });
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_GATHERING:
                //待付款
                TestObligation testObligation = (TestObligation) t[0];

                if (testObligation.getCode() == 0 && testObligation.getData() != null) {

                    Log.i("tag", "待付款数据: "+testObligation.toString());

                    data = testObligation.getData();

                    String amount = data.getAmount();

                    List<TestObligation.DataBean.OrderStockListBean> orderStockList = data.getOrderStockList();

                    list.addAll(orderStockList);

                    adapter.notifyDataSetChanged();

                } else {
                    ToastUtil.showShort(testObligation.getMsg());
                }
                break;//
            //取消订单
                
        }
    }
    @Override
    protected void initData() {
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID,"");
        anInt = Integer.parseInt(userId);
        if (userId!=null) {
            mPresenter.getData(ApiConfig.TEXT_GATHERING, anInt, num);//待付款
        }
       }
    public ObligationFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_obligation;
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
}