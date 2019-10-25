package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.design.SlideFromBottomPopup;

/**
 * 个人资料
 */
public class PersonalDatActivity extends BaseMvpActivity<LoginModel> implements TakePhoto.TakeResultListener, SmsVerifyView.SmsVerifyCallback,SlideFromBottomPopup.BottomPopClick {
    @BindView(R.id.personal_back_iv)
    ImageView personalBackIv;
    @BindView(R.id.personal_header_iv)
    RoundedImageView personalHeaderIv;
    @BindView(R.id.persional_ll)
    RelativeLayout persionalLl;
    @BindView(R.id.persional_name)
    TextView persionalName;
    @BindView(R.id.persional_phone_code)
    TextView persionalPhoneCode;

    private SlideFromBottomPopup mPop;
    private TakePhotoImpl mTakePhoto;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_dat;
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
        ToastUtil.showShort(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @Override
    protected void initView() {
        super.initView();

        String phone_code = SharedPrefrenceUtils.getString(this, NormalConfig.USER_NAME);//手机号
        String headler_iamge = SharedPrefrenceUtils.getString(this, NormalConfig.HEADLER_IMAGEVIEW);//头像

        if (persionalPhoneCode!=null && headler_iamge!=null){
            persionalPhoneCode.setText(phone_code);
            Glide.with(this).load(headler_iamge).placeholder(R.mipmap.icon).into(personalHeaderIv);
        }
    }
    @Override
    protected void initData() {
        super.initData();
    }
    @Override
    protected void initListener() {

    }
    @OnClick({R.id.personal_back_iv, R.id.personal_header_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_back_iv:
                PersonalDatActivity.this.finish();
                break;
            case R.id.personal_header_iv:
                //初始化底部弹出拍照的pop
                mPop = new SlideFromBottomPopup(this);
                mPop.setLineText(getString(R.string.camera),getString(R.string.photo), getString(R.string.cancel));
                mPop.setBottomClickListener(this);
                mPop.showPopupWindow();
                break;
        }
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
//        ToastUtil.showShort(event.getKeyCode()+"");
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//            ToastUtil.showShort("enter click");
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getCompressPath() != null ? result.getImage().getCompressPath() : result.getImage().getOriginalPath();//先设置到列表中
        if (!TextUtils.isEmpty(path)) {
//            ToastUtil.showShort("上传成功");
//            showLoadingDialog();
//            mPresenter.getData(ApiConfig.UPLOAD_IMAGE, path);
//            Glide.with(this).load(path).into(mImage);
            SharedPrefrenceUtils.saveString(this,NormalConfig.HEADLER_IMAGEVIEW,path);
            
            Glide.with(this).load(path).placeholder(R.mipmap.icon).into(personalHeaderIv);
        }
    }

    @Override
    public void takeFail(TResult result, String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void takeCancel() {
        ToastUtil.showShort("取消获取图片");
    }

    @Override
    public void clickTop() {
        mTakePhoto = new TakePhotoImpl(this, this);
        mTakePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        mTakePhoto.onPickFromGalleryWithCrop(getUri(), getOption());
//        mTakePhoto.onPickFromGallery();
        mPop.dismiss();
    }

    private CropOptions getOption() {
        return new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
    }

    private Uri getUri() {
        File file = new File(Environment.getExternalStorageDirectory(), "/YaYa/" + System.currentTimeMillis() + ".png");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        return imageUri;
    }

    @Override
    public void clickCenter() {
        mTakePhoto = new TakePhotoImpl(this, this);
        //压缩图片
        mTakePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        //从相册获取并裁剪
        mTakePhoto.onPickFromCaptureWithCrop(getUri(), getOption());
//        mTakePhoto.onPickFromCapture(getUri());
        mPop.dismiss();
    }

    @Override
    public void clickBottom() {
        mPop.dismiss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTakePhoto.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void smsCodeSend() {

    }

    @Override
    public void countryCodeOpen() {

    }
}
