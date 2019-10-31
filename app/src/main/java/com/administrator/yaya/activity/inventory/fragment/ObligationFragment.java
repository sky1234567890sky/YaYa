package com.administrator.yaya.activity.inventory.fragment;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 待付款
 */
public class ObligationFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.daifu_orderNumber)
    TextView mDaifuOrderNumber;
    @BindView(R.id.daifu_comImg)
    ImageView mDaifuComImg;
    @BindView(R.id.daifu_gcomName)
    TextView mDaifuGcomName;
    @BindView(R.id.daifu_pirce)
    TextView mDaifuPirce;
    @BindView(R.id.daifu_commodityAmount)
    TextView mDaifuCommodityAmount;
    @BindView(R.id.daifu_commodityPrice)
    TextView mDaifuCommodityPrice;
    @BindView(R.id.daifu_orderBuildTime)
    TextView mDaifuOrderBuildTime;
    @BindView(R.id.daifu_getGathering_btn)
    TextView mDaifuGetGatheringBtn;
    @BindView(R.id.daifu_cancel_orderform)
    TextView mDaifuCancelOrderform;
    @SuppressLint("SetTextI18n")

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_BUY_COM:
                //待付款
                TestObligation testObligation = (TestObligation) t[0];
                if (testObligation.getCode() == 0 && testObligation.getData() != null) {
//                    TestObligation.DataBean data = testObligation.getData();

                } else {
                    ToastUtil.showShort(testObligation.getMsg());
                }
                break;
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
        return getModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return getPresenter();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }
}
