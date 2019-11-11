package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.ObligationAdapter;
import com.administrator.yaya.activity.my.adapter.AlipayReceiverCodeAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.SwitchReceiveingQrCode;
import com.administrator.yaya.bean.my.TestAlipayReceiverCode;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 支付宝收款
 */
public class AlipayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.pay_receive_back_iv)
    ImageView payReceiveBackIv;
    @BindView(R.id.two_switch)
    Switch twoSwitch;
    @BindView(R.id.alipay_qr)
    RecyclerView mList;
    @BindView(R.id.alipay_refreshLayout)
    SmartRefreshLayout smartRefreshLayout;


//    @BindView(R.id.add1)
//    ImageView add1;
//    @BindView(R.id.add2)
//    ImageView add2;
//    @BindView(R.id.two_ll)
//    LinearLayout twoLl;
//    @BindView(R.id.get_menry)
//    TextView getMenry;
//    @BindView(R.id.add3)
//    ImageView add3;
//    @BindView(R.id.ll3)
//    LinearLayout ll3;
//    @BindView(R.id.add4)
//    ImageView add4;
//    @BindView(R.id.receivable_tv2)
//    TextView mReceivableTv2;
//    @BindView(R.id.receivable_tv3)
//    TextView mReceivableTv3;
//    @BindView(R.id.receivable_tv4)
//    TextView mReceivableTv4;

    List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> list = new ArrayList<>();
    private int wechatCode;
    private TestAlipayReceiverCode testAlipayReceiverCode;
    private AlipayReceiverCodeAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payments_receive;
    }
    @Override
    protected void initData() {

        super.initData();
//        参数:
//        用户id		userId
//        类型		type	1、微信 2、支付宝

        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        if (userId != null) {
            mPresenter.getData(ApiConfig.TEST_ALIPAY_RECEIVER_CODE, Integer.parseInt(userId), 2);
        }

    }

    @Override
    protected void initView() {
        super.initView();

        list = new ArrayList<>();
//        initRecycleView(mList,abligationRefreshLayout);
//        abligationRefreshLayout.setEnableLoadMore(false);
        initRecycleView(mList,smartRefreshLayout);
        mList.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new AlipayReceiverCodeAdapter(list);
        mList.setAdapter(adapter);
//        new
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALIPAY_RECEIVER_CODE:
                testAlipayReceiverCode = (TestAlipayReceiverCode) t[0];

                if (testAlipayReceiverCode != null && testAlipayReceiverCode.getData() != null) {
                    TestAlipayReceiverCode.DataBean data = testAlipayReceiverCode.getData();
                    Log.i("tag", "支付宝: "+ testAlipayReceiverCode.toString());
                    List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> userCodeImgList = data.getUserCodeImgList();
                    int vxButtonStatus = data.getVxButtonStatus();
                    int zfbButtonStatus = data.getZfbButtonStatus();
                    wechatCode = vxButtonStatus;
                    list.addAll(userCodeImgList);
//                    Log.i("tag", "list支付宝: "+list.toString());
                    adapter.notifyDataSetChanged();

                } else {
                    ToastUtil.showShort(testAlipayReceiverCode.getMsg());
                }
                break;
            case ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE://二维码开关
                SwitchReceiveingQrCode switchReceiveingQrCode = (SwitchReceiveingQrCode) t[0];
                if (switchReceiveingQrCode.getCode()==0){
                    ToastUtil.showShort(switchReceiveingQrCode.getMsg());
                }else {
                    ToastUtil.showShort(switchReceiveingQrCode.getMsg());
                }
                break;
        }
    }
    @Override
    protected void initListener() {
        twoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SPUtils.getInstance().put(Constants.AUTO_PALY_IN_WIFI, isChecked);
                //微信按钮
//                TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean = userCodeImgList.get(data.getVxButtonStatus());
//                TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean = list.get(wechatCode);
//                if (userCodeImgListBean.getImgType() == 2) {
                    if (isChecked) {
                        String userId = SharedPrefrenceUtils.getString(AlipayReceiverCodeActivity.this, NormalConfig.USER_ID);
                        if (userId!=null)mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE,Integer.parseInt(userId),2,1);
//                        ToastUtil.showShort("onCheckedChanged: 开启" + isChecked);
//                        if (list.get(0).getImgUrl()!=null)Glide.with(getApplication()).load(list.get(0).getImgUrl()).into(add1);
//                        if (list.get(1).getImgUrl()!=null)Glide.with(getApplication()).load(list.get(1).getImgUrl()).into(add1);
//                        if (list.get(2).getImgUrl()!=null)Glide.with(getApplication()).load(list.get(2).getImgUrl()).into(add1);
//                        if (list.get(3).getImgUrl()!=null)Glide.with(getApplication()).load(list.get(3).getImgUrl()).into(add1);
//                        mReceivableTv2.setText(list.get(0).getImgMoney()+"元");
//                        mReceivableTv3.setText(list.get(1).getImgMoney()+"元");
//                        mReceivableTv4.setText(list.get(0).getImgMoney()+"元");
                    } else {
//                        ToastUtil.showShort( "onCheckedChanged: 关闭" + isChecked);
                        String userId = SharedPrefrenceUtils.getString(AlipayReceiverCodeActivity.this, NormalConfig.USER_ID);
                        if (userId!=null)mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE,Integer.parseInt(userId),2,2);
                    }
            }
        });
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
    @OnClick({R.id.pay_receive_back_iv, R.id.two_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pay_receive_back_iv:
                AlipayReceiverCodeActivity.this.finish();
                break;
            case R.id.two_switch:
                break;
        }
    }
}
