package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 联系客服
 */
public class CustomerServiceActivity extends BaseActivity {

    @BindView(R.id.custom_service_back_iv)
    ImageView customServiceBackIv;
    @BindView(R.id.phone_code)
    TextView phoneCode;
    private SpannableStringBuilder ssb;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_customer_service);
//        ButterKnife.bind(this);
//
//    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_service;
    }
    @Override
    protected void initView() {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }
    @OnClick({R.id.custom_service_back_iv,R.id.phone_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.custom_service_back_iv:
                CustomerServiceActivity.this.finish();
                break;
            case R.id.phone_code:
                String phoneNumber = "400-900-340";
                Intent myCallIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("如有需要，请拨打：" + phoneNumber));
                startActivity(myCallIntent);
                break;
        }
    }
}
