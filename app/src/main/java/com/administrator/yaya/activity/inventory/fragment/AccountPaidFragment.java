package com.administrator.yaya.activity.inventory.fragment;


import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 已付款
 */
public class AccountPaidFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.yifu_orderNumber)
    TextView mYifuOrderNumber;
    @BindView(R.id.yifu_comImg)
    ImageView mYifuComImg;
    @BindView(R.id.yifu_gamemoney)
    TextView mYifuGamemoney;
    @BindView(R.id.yifu_comPrice)
    TextView mYifuComPrice;
    @BindView(R.id.yifu_commodityAmount)
    TextView mYifuCommodityAmount;
    @BindView(R.id.yifu_commodityPrice)
    TextView mYifuCommodityPrice;
    @BindView(R.id.yifu_up_btn)
    TextView mYifuUpBtn;
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_BUY_COM:
//                TestAccountPaid testAccountPaid = (TestAccountPaid) t[0];
//                if (testAccountPaid.getCode() == 0 && testAccountPaid.getData() != null) {
////                    TestAccountPaid.DataBean data = testAccountPaid.getData();
////                    List<TestAccountPaid.DataBean.OrderStockListBean> orderStockList = data.getOrderStockList();
////                    mYifuOrderNumber.setText("订单编号:"+);
////                    Glide.with(this).load(comImg).into(nowBuGamemoneyIv);
//                } else {
//                    ToastUtil.showShort(testAccountPaid.getMsg());
//                }
                break;
        }
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_paid;
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
    public AccountPaidFragment() {
        // Required empty public constructor

    }
}
