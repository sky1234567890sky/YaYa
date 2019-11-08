package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestPayToAffirmInfo;
import com.administrator.yaya.bean.orderform.TestToOrderStock;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认信息
 */
public class AffirmMessageActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.affirm_msg_back_iv)
    ImageView affirmMsgBackIv;
    @BindView(R.id.receiver_name)
    TextView receiverName;
    @BindView(R.id.receiver_copy)
    TextView receiverCopy;
    @BindView(R.id.bank_code_number)
    TextView bankCodeNumber;
    @BindView(R.id.bank_code_number_copy)
    TextView bankCodeNumberCopy;
    @BindView(R.id.bank_yinhang)
    TextView bankYinhang;
    @BindView(R.id.bank_copy)
    TextView bankCopy;
    @BindView(R.id.money_tv)
    TextView moneyTv;
    @BindView(R.id.remark_tv)
    TextView mRemarkTv;
    @BindView(R.id.remark_btn_copy)
    TextView remarkBtnCopy;
    @BindView(R.id.affirm_msg_look_btn)
    Button affirmMsgLookBtn;
    @BindView(R.id.bank_money)
    TextView bankMoney;
    @BindView(R.id.remark)
    TextView mRemark;
    private String commodityAmount;
    private String payerName;
    private String commodityPrice;
    private String userId;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_message;
    }
    @Override
    protected void initView() {
        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        commodityAmount = getIntent().getStringExtra("commodityAmount");
        payerName = getIntent().getStringExtra("bankName");
        //应付款金额
        commodityPrice = getIntent().getStringExtra("commodityPrice");
        }
    @Override
    protected void initData() {
        Log.i("tag", "data======》: "+commodityAmount+payerName+commodityPrice+userId);
        int i = Integer.parseInt(userId);
        mPresenter.getData(ApiConfig.TEXT_ORDER_STOCK, i, commodityPrice, payerName, commodityAmount);

        //網絡請求  付款信息
        String OrderNumber = getIntent().getStringExtra("OrderNumber");
        if (OrderNumber!=null){
            mPresenter.getData(ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO,OrderNumber);
        }
    }
    @OnClick({R.id.affirm_msg_back_iv, R.id.receiver_copy, R.id.bank_code_number_copy, R.id.bank_copy, R.id.bank_money, R.id.remark_btn_copy, R.id.affirm_msg_look_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.affirm_msg_back_iv:
                finish();
                break;
            case R.id.receiver_copy:
                ClipboardManager name = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (receiverName!=null)name.setText(receiverName.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.bank_code_number_copy:
                ClipboardManager number = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (bankCodeNumber!=null)number.setText(bankCodeNumber.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.bank_copy:
                ClipboardManager bank = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (bankYinhang!=null)bank.setText(bankYinhang.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.bank_money:
                ClipboardManager bankQian = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (bankMoney!=null)bankQian.setText(bankMoney.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;

            case R.id.remark_btn_copy:
                ClipboardManager remark = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (mRemarkTv!=null)remark.setText(mRemarkTv.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.affirm_msg_look_btn:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("affirm", 2);
                startActivity(intent);
                break;
        }
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
//        String message = e.getMessage();
//        Log.e("aaaaaa",message);
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_ORDER_STOCK:
                 TestToOrderStock testToOrderStock = (TestToOrderStock) t[0];

                Log.i("tag", "确认信息: "+testToOrderStock.toString());

                if (testToOrderStock.getCode()==0 && testToOrderStock.getData()!=null){

                    TestToOrderStock.DataBean data = testToOrderStock.getData();

                    String bankName = data.getBankName();
                    String payeeName = data.getPayeeName();//收款人姓名

                    int gaId = data.getGaId();
                    String bankCard = data.getBankCard();//银行卡号
                    String remark = data.getRemark();//备注信息

                    bankYinhang.setText(bankName+"");
                    receiverName.setText(payeeName+"");
                    bankCodeNumber.setText(bankCard+"");
                    moneyTv.setText(data.getComMoney());
                    mRemarkTv.setText(remark+"");
                }else{
//                    ToastUtil.showShort(testToOrderStock.getMsg());
                }
                break;
                //付款信息

            case ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO://从库存付款信息跳到确认信息解析
//                getTestPayToAffimInfo()
                TestPayToAffirmInfo testPayToAffirmInfo = (TestPayToAffirmInfo) t[0];
                if (testPayToAffirmInfo.getData()!=null && testPayToAffirmInfo.getCode()==0){
                    TestPayToAffirmInfo.DataBean data = testPayToAffirmInfo.getData();
//                    收款人姓名	payeeName
                    String payeeName = data.getPayeeName();
                    receiverName.setText(payeeName);
//                    银行卡号	bankCard
                    String bankCard = data.getBankCard();
                    bankCodeNumber.setText(bankCard);
//                    所属银行	bankName
                    String bankName = data.getBankName();
                    bankYinhang.setText(bankName);
//                    金额		comMoney
                    int comMoney = data.getComMoney();
                    moneyTv.setText(comMoney+"");
//                    备注信息	remark
                    String remark = data.getRemark();
                    mRemarkTv.setText(remark);
                }else{
//                    ToastUtil.showShort(testPayToAffirmInfo.getMsg());
                }
                break;
        }
    }
}