package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.TestDianjiYingye;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestInventory;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_yingye;
    }
    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    protected void initData() {
        super.initData();
        //营业数量		userSalesCount
//        mPresenter.getData(ApiConfig.TEST_DIANJIYINGYE,mApplication.userid,mApplication.mToken,);
        //库存里面的

        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);

        mPresenter.getData(ApiConfig.TEST_INVENTORY,Integer.parseInt(userId),mApplication.mToken);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //确认营业
            case ApiConfig.TEST_DIANJIYINGYE:
                TestDianjiYingye testDianjiYingye = (TestDianjiYingye) t[0];

                if (testDianjiYingye.getMsg().equals(mApplication.SignOut)){
                    ToastUtil.showLong(R.string.username_login_hint+"");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    return;
                }
                //其他设备登陆  跳转 到登录界面
                if (testDianjiYingye.getCode()==0){
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("confirmyingye",10);
                    startActivity(intent);
                    finish();
                }
                break;

                //库存
            case ApiConfig.TEST_INVENTORY:

                TestInventory testInventory = (TestInventory) t[0];

                if (testInventory.getMsg()==mApplication.SignOut){

                    ToastUtil.showLong(R.string.username_login_hint+"");

                    Intent intent = new Intent(this, LoginActivity.class);

                    startActivity(intent);

                    return;

                    //提示
                }
                if (testInventory.getCode() == 0) {

                    //登录
                        userSalesCount = testInventory.getData().getUserSalesCount();

                        mInventory_number.setText(""+ userSalesCount);
                    }

                break;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();

        mConfirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etNumber = mEtCinfirmNumber.getText().toString().trim();
                if (etNumber.isEmpty()){
                    ToastUtil.showLong("请输入您的营业数量");
                    return;
                }
                if(Integer.parseInt(etNumber)==0){
                    ToastUtil.showLong("当前账户无库存");
                    return;
                }
                if (Integer.parseInt(etNumber)>userSalesCount){
                    ToastUtil.showLong("你输入的数量超过库存数量！");
                }else{
                    mPresenter.getData(ApiConfig.TEST_DIANJIYINGYE,mApplication.userid,mApplication.mToken,userSalesCount);
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
                if (TextUtils.isEmpty(mEtCinfirmNumber.getText())){
                    mConfirm_btn.setBackground(getResources().getDrawable(R.drawable.confirm_bg_shape));
                    mConfirm_btn.setTextColor(getResources().getColor(R.color.c_cccccc));
                    mConfirm_btn.setEnabled(Boolean.FALSE);//不启用按钮
                }else{
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
                finish();
                break;
            case R.id.confirm_btn:
                break;
        }
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        initData();
//
//    }
}