package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.activity.UpGameMoneyActivity;
import com.administrator.yaya.base.ApiConfig;
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

import static com.administrator.yaya.fragment.InventoryFragment.FORM_INVENTORY;
import static com.administrator.yaya.fragment.InventoryFragment.FORM_INVENTORY2;


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
    @BindView(R.id.import_hint)
    TextView import_hint;
    //    @BindView(R.id.remark)
//    TextView mRemark;
    private String orderNumber;
    private String orderNumbers;
    private String userId;
    private String token;
    private String payeeName;
    private String name2;
    private String comMoney;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_message;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        name2 = intent.getStringExtra("name2");

        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData() {


        //網絡請求  付款信息
//        orderNumber = getIntent().getStringExtra(FORM_INVENTORY2);//已付款
        String accountPaid = getIntent().getStringExtra("accountPaid");
//        orderNumbers = getIntent().getStringExtra(FORM_INVENTORY);//待付款
        String orderNumber = getIntent().getStringExtra("OrderNumber");

        //已付款
        if (!TextUtils.isEmpty(accountPaid) && accountPaid != null)//不为空则是 查看详情  为空则是 提交订单传过来的值
            mPresenter.getData(ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO, accountPaid, token);
            //待付款
        else if (!TextUtils.isEmpty(orderNumber) && orderNumber != null) {
            mPresenter.getData(ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO, orderNumber, token);
        } else {
            //提交订单传过来的数据
            //应付款金额
            payeeName = getIntent().getStringExtra("payeeName");
            String bankName = getIntent().getStringExtra("bankName");
            comMoney = getIntent().getStringExtra("comMoney");
            String bankCard = getIntent().getStringExtra("bankCard");
            String remark = getIntent().getStringExtra("remark");
            if (!TextUtils.isEmpty(payeeName) || !TextUtils.isEmpty(bankName) || !TextUtils.isEmpty(comMoney)
                    || !TextUtils.isEmpty(bankCard) || !TextUtils.isEmpty(remark)) {
                bankYinhang.setText(bankName + "");
                receiverName.setText(payeeName + "");
                bankCodeNumber.setText(bankCard + "");
                moneyTv.setText(comMoney + "");
                mRemarkTv.setText(remark + "");

            }
        }


        import_hint.setText("请务必使用姓名为"+name2+"的银行卡进行转账，转账金额为"+comMoney+"元，请填好备注信息，才能及时发货，谢谢!");

//        Log.i("tag", "data======》: " + commodityAmount + payerName + commodityPrice + userId);
//        int i = Integer.parseInt(userId);
        //用户第一次进入时  立即购买展示的数据
        //提交订单
//        if (TextUtils.isEmpty(orderNumber)){
//            mPresenter.getData(ApiConfig.TEXT_ORDER_STOCK, i, commodityPrice, payerName, commodityAmount);
//        } else{

        //库存的
        //查看详情
    }

    //}
    //待付款跳转此页面 时 的展示 数据
//}
    @OnClick({R.id.affirm_msg_back_iv, R.id.receiver_copy, R.id.bank_code_number_copy, R.id.bank_copy, R.id.bank_money, R.id.remark_btn_copy, R.id.affirm_msg_look_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.affirm_msg_back_iv:
                AffirmMessageActivity.this.finish();
                break;
            case R.id.receiver_copy:
                ClipboardManager name = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (receiverName != null) name.setText(receiverName.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.bank_code_number_copy:
                ClipboardManager number = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (bankCodeNumber != null) number.setText(bankCodeNumber.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.bank_copy:
                ClipboardManager bank = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (bankYinhang != null) bank.setText(bankYinhang.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;

            case R.id.bank_money:
                ClipboardManager bankQian = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (bankMoney != null) bankQian.setText(bankMoney.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.remark_btn_copy:
                ClipboardManager remark = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                if (mRemarkTv != null) remark.setText(mRemarkTv.getText());
                ToastUtil.showShort("已复制至粘贴栏");
                break;
            case R.id.affirm_msg_look_btn:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("affirm", 2);
                startActivity(intent);
                finish();

//              AffirmMessageActivity.this.finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
//            case ApiConfig.TEXT_ORDER_STOCK:
//                TestToOrderStock testToOrderStock = (TestToOrderStock) t[0];
//                Log.i("tag", "确认信息: " + testToOrderStock.toString());
//                if (testToOrderStock.getCode() == 0 && testToOrderStock.getData() != null) {
//                    TestToOrderStock.DataBean data = testToOrderStock.getData();
//                    String bankName = data.getBankName();
//                    String payeeName = data.getPayeeName();//收款人姓名
//                    int gaId = data.getGaId();
//                    String bankCard = data.getBankCard();//银行卡号
//                    String remark = data.getRemark();//备注信息
//                    bankYinhang.setText(bankName + "");
//                    receiverName.setText(payeeName + "");
//                    bankCodeNumber.setText(bankCard + "");
//                    moneyTv.setText(data.getComMoney());
//                    mRemarkTv.setText(remark + "");
//                }
//                break;
            //付款信息
            case ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO://从库存付款信息跳到确认信息解析
//                getTestPayToAffimInfo()
                TestPayToAffirmInfo testPayToAffirmInfo = (TestPayToAffirmInfo) t[0];
                Log.i("tag", "订单编号list: " + testPayToAffirmInfo.toString());

                if (testPayToAffirmInfo.getMsg().equals(mApplication.SignOut)) {

                    ToastUtil.showLong("您的账号正在其他设备登录！");

                    Intent login = new Intent(this, LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getApplicationContext(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getApplicationContext(), NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(login);

                    finish();
                }
                if (testPayToAffirmInfo.getCode() == 0 && !testPayToAffirmInfo.getMsg().equals(mApplication.SignOut)) {

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
                    Double comMoney = data.getComMoney();
                    moneyTv.setText(comMoney + "");
//                    备注信息	remark
                    String remark = data.getRemark();
                    mRemarkTv.setText(remark);
                    String userName = SharedPrefrenceUtils.getString(this, NormalConfig.USER_NICK);

                }
                break;
        }
    }
}