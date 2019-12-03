package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.administrator.yaya.R;
import com.administrator.yaya.bean.homepage.TestDianjiYingye;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestUserCount;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import butterknife.BindView;
import butterknife.OnClick;
//确认营业
public class ConfirmYingyeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.confirm_back_iv)
    ImageView mBack;
    @BindView(R.id.inventory_number)
    TextView mInventory_number;
    @BindView(R.id.confirm_btn)
    TextView mConfirm_btn;
    @BindView(R.id.et_cinfirm_number)
    EditText mEtCinfirmNumber;
    private int userSalesCount;

    private String userId;
    private String token;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_yingye;
    }
    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong("服务器错误！");
    }
    @Override
    protected void initView() {
        super.initView();
        setEditTextInhibitInputSpaChat(mEtCinfirmNumber);
        //去除空格与限制字段长度会起冲突  此方法解决冲突
        setEditTextLengthLimit(mEtCinfirmNumber,20);//购买数量
    }

    @Override
    protected void initData() {
        super.initData();
        //营业数量		userSalesCount
//        mPresenter.getData(ApiConfig.TEST_DIANJIYINGYE,mApplication.userid,mApplication.mToken,);
        //库存里面的
        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
//        mPresenter.getData(ApiConfig.TEST_INVENTORY, Integer.parseInt(userId),token);
        mPresenter.getData(ApiConfig.TEST_USER_COUNT,Integer.parseInt(userId));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //确认营业
            case ApiConfig.TEST_DIANJIYINGYE:
                TestDianjiYingye testDianjiYingye = (TestDianjiYingye) t[0];
                if (testDianjiYingye.getMsg().equals(mApplication.SignOut)) {
                    Toast.makeText(this, R.string.username_login_hint+"", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid =0;
                    mApplication.mToken = "";
                    startActivity(login);
                    finish();
                }else//其他设备登陆  跳转 到登录界面
                    if (testDianjiYingye.getCode() == 0 && !testDianjiYingye.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong(""+testDianjiYingye.getMsg());
                    //让开始营业

                    Intent intent = new Intent(this, MainActivity.class);//到库存
                    intent.putExtra("confirmyingye", 10);
                    startActivity(intent);
                    finish();
                }
                break;
            //库存
            case ApiConfig.TEST_USER_COUNT:
                TestUserCount testUserCount = (TestUserCount) t[0];
                if (testUserCount.getCode()==0) {
                    TestUserCount.DataBean data = testUserCount.getData();
                    TestUserCount.DataBean.CommodityBean commodity = data.getCommodity();
                    int userAllCount = data.getUserAllCount();
                    if (userAllCount>0){
                        mInventory_number.setText(userAllCount+"");
                    }
                }
                break;
        }
    }
    @Override
    protected void initListener() {
        super.initListener();
//        SharedPrefrenceUtils.getString(this,NormalConfig.TOKEN);
        mConfirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etNumber = mEtCinfirmNumber.getText().toString().trim();
                if (etNumber.isEmpty()) {
                    ToastUtil.showLong("请输入您的营业数量");
                    return;
                }
                if (Integer.parseInt(etNumber) == 0) {
                    ToastUtil.showLong("当前账户无库存");
                    return;
                }
                if (Integer.parseInt(etNumber) > userSalesCount) {
                    ToastUtil.showLong("你输入的数量超过库存数量！");
                } else {
                    mPresenter.getData(ApiConfig.TEST_DIANJIYINGYE,Integer.parseInt(userId),token);
                }
            }
        });

        //监听输入框
        mEtCinfirmNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //输入框为空  不能点击按钮
                if (TextUtils.isEmpty(mEtCinfirmNumber.getText())) {
                    mConfirm_btn.setBackground(getResources().getDrawable(R.drawable.confirm_bg_shape));
                    mConfirm_btn.setTextColor(getResources().getColor(R.color.c_cccccc));
                    mConfirm_btn.setEnabled(Boolean.FALSE);//不启用按钮
                } else {
                    //非空
                    mConfirm_btn.setBackground(getResources().getDrawable(R.drawable.ripple_btn));
                    mConfirm_btn.setTextColor(getResources().getColor(R.color.c_ffffff));
                    mConfirm_btn.setEnabled(Boolean.TRUE);//启用按钮
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
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

    //

    @OnClick({R.id.confirm_back_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.confirm_back_iv:
                ConfirmYingyeActivity.this.finish();
                break;
            case R.id.confirm_btn:
                break;
        }
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        initData();
//
//    }
}