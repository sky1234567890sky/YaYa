package com.administrator.yaya.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.login_register_bean.TestVersitionCode;
import com.administrator.yaya.bean.login_register_bean.TestRegister;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AppValidationMgr;
import com.administrator.yaya.utils.CountDownTimerUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import razerdp.design.SlideFromBottomPopup;
/**
 * 注册界面
 */
public class RegisterActivity extends BaseMvpActivity<LoginModel>implements TakePhoto.TakeResultListener, SmsVerifyView.SmsVerifyCallback, SlideFromBottomPopup.BottomPopClick{

    @BindView(R.id.register_back_iv)
    ImageView registerBackIv;

    @BindView(R.id.register_headleriv)
    ImageView registerHeadlerIv;

    @BindView(R.id.register_et_uname)
    EditText registerEtUname;//手机号

    @BindView(R.id.et_register_verificationcode)
    EditText etRegisterVerificationcode;//输入验证码     8888

    @BindView(R.id.btn_register_phonecode)//获取手机验证码
    TextView mInvitecode;

    @BindView(R.id.et_register_pw)
    EditText etRegisterPw;//输入密码

    @BindView(R.id.et_getcode)
    EditText etGetcode;//输入邀请码  6666

    @BindView(R.id.register_register_btn)
    TextView registerRegisterBtn;
//    @BindView(R.id.sms_verify_view)
//    SmsVerifyView mView;
    private SlideFromBottomPopup mPop;
    private TakePhotoImpl mTakePhoto;
    private CountDownTimerUtils mDownTimerUtils;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
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
    protected void initView() {
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //倒计时工具类
        mDownTimerUtils = new CountDownTimerUtils(mInvitecode, 60000, 1000);
    }
    @Override
    public void onError(int whichApi, Throwable e) {
//        mView.reset();
//        ToastUtil.showShort(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_REGISTER://注册
                TestRegister register = (TestRegister) t[0];
                int code = register.getCode();
                if (code==0){//为0注册成功
                    ToastUtil.showShort(register.getMsg());
//                    new Intent(this,)
                    finish();
                }else{
                    ToastUtil.showLong(register.getMsg());
                }
            case ApiConfig.TEXT_INVITECODE://注册获取验证码  验证码   666666
                //获取验证码前判断手机号是否被注册
                TestRegister testInviteCode = (TestRegister) t[0];
                if (testInviteCode.getCode() == 0){
                    ToastUtil.showLong(testInviteCode.getMsg());
                }else{
                    ToastUtil.showLong(testInviteCode.getMsg());
                }

                break;
//            case ApiConfig.GET_SMS_MJG://获取验证码
//                VerifyCodeInfo verifyCodeInfos = (VerifyCodeInfo) t[0];
//                if (verifyCodeInfos != null) ToastUtil.showShort("短信发送成功注意验收"+verifyCodeInfos.getVerify_token());
//                break;
//            case ApiConfig.GET_SMS:
//                VerifyCodeInfo info = (VerifyCodeInfo) t[0];
////                mView.setVerifyCode(info.verify_token);
//                break;
//            case ApiConfig.LOGIN_ACC:
//                //获取的是唯一用户ID，用来确认身份
//                LoginInfo loginInfo = (LoginInfo) t[0];
////                ToastUtil.showShort(loginInfo.msg);
//                //将这两个保存，并传给application
////                mApplication.mToken = loginInfo.token;
////                mApplication.mUserPhoto  = loginInfo.nick;//传给Application用来给聊天界面
//                //将token保存到本地
////                SharedPrefrenceUtils.saveString(this,NormalConfig.TOKEN,loginInfo.token);
////                SharedPrefrenceUtils.saveString(this,NormalConfig.USER_NICK,loginInfo.nick);
////                loginIm();//聊天登录
//                break;
        }
    }
    private void loginIm() {
        //TODO:登录聊天逻辑处理
    }

    @Override
    protected void initData() {
        super.initData();

        //给权限
//        getPermission();
    }
    @OnClick({R.id.register_back_iv, R.id.register_headleriv, R.id.btn_register_phonecode, R.id.register_register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_back_iv:
                RegisterActivity.this.finish();
                break;
            case R.id.register_headleriv://点击头像
//                mView.setSmsVerifyCallback(this);
                //初始化底部弹出拍照的pop
                mPop = new SlideFromBottomPopup(this);
                mPop.setLineText(getString(R.string.camera),getString(R.string.photo), getString(R.string.cancel));
                mPop.setBottomClickListener(this);
                mPop.showPopupWindow();
                break;
            case R.id.btn_register_phonecode://验证码
//              mPresenter.getData(ApiConfig.TEXT_INVITECODE,0);
//              ToastUtil.showShort("验证码已发送请注意查收");//验证码获取网络解析
                String phoneCode = registerEtUname.getText().toString().trim();
//&& AppValidationMgr.isPhone(phoneCode)
                if (!phoneCode.isEmpty()) {
                    mDownTimerUtils.start();
                    mPresenter.getData(ApiConfig.TEXT_INVITECODE, phoneCode);
                }else{
                    ToastUtil.showLong("请输入手机号");
                }
                break;
            case R.id.register_register_btn://注册
                //MD5加密解密
                register();
                break;
        }
    }

    @SuppressLint("NewApi")
    private void register() {

        String userPhone = registerEtUname.getText().toString().trim();
        String userPwd = etRegisterPw.getText().toString().trim();
        String codeName = etRegisterVerificationcode.getText().toString().trim();//验证码
        String userInvitationCode = etGetcode.getText().toString().trim();//邀请码

        if (userPhone.isEmpty() || userPwd.isEmpty()  || userInvitationCode.isEmpty() || codeName.isEmpty()) {
            ToastUtil.showShort("请输入完整信息");
        }else{
            String regex = "[A-Za-z0-9]{4,12}";
            if (AppValidationMgr.isPhone(userPhone) && userPwd.matches(regex) ){
                //邀请码与验证码验证   @Field("userPhone") String userPhone, @Field("userPwd") String userPwd, @Field("userInvitationCode") String userInvitationCode, @Field("codeName") String codeName
                mPresenter.getData(ApiConfig.TEXT_REGISTER,userPhone,userPwd,userInvitationCode,codeName);
                Intent intent = new Intent();
                intent.putExtra(NormalConfig.USER_NAME,registerEtUname.getText().toString());
                intent.putExtra(NormalConfig.PASS_WORD,etRegisterPw.getText().toString());
                setResult(100,intent);
                finish();
            } else ToastUtil.showShort("请输入正确的格式");
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
    /**
     * 点击相册选图
     */
    @Override
    public void clickTop() {
        mTakePhoto = new TakePhotoImpl(this, this);
        mTakePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        mTakePhoto.onPickFromGalleryWithCrop(getUri(), getOption());
//        mTakePhoto.onPickFromGallery();
        mPop.dismiss();
    }

    /**
     * 点击拍照
     */
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
    /**
     * 取消popupwindow
     */

    @Override
    public void clickBottom() {
        mPop.dismiss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTakePhoto.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
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
    /**
     * 获取拍照或相册处理过的图片路劲
     * @param result
     */
    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getCompressPath() != null ? result.getImage().getCompressPath() : result.getImage().getOriginalPath();//先设置到列表中
        if (!TextUtils.isEmpty(path)) {
            //记住头像
            SharedPrefrenceUtils.saveString(this,NormalConfig.HEADLER_IMAGEVIEW,path);
            ToastUtil.showShort("上传成功");
//            showLoadingDialog();
//            mPresenter.getData(ApiConfig.UPLOAD_IMAGE, path);
            Glide.with(this).load(path).into(registerHeadlerIv);
        }
    }
    /**
     * 拍照或获取相册图片失败
     * @param result
     * @param msg
     */
    @Override
    public void takeFail(TResult result, String msg) {
        ToastUtil.showShort(msg);
    }
    /**
     * 取消获取图片
     */
    @Override
    public void takeCancel() {
//        ToastUtil.showShort("cancel_get_image");
    }
    @Override
    public void smsCodeSend() {

    }

    @Override
    public void countryCodeOpen() {

    }
    /**
     * 获取短信验证
     */
//    @Override
//    public void smsCodeSend() {
////        mPresenter.getData(ApiConfig.GET_SMS);
////        if (TextUtils.isEmpty(mView.getPhone()))return;
////        mPresenter.getData(ApiConfig.GET_SMS_MJG,mView.getPhone());
//    }
//    @Override
//    public void countryCodeOpen() {
////        mView.setDefaultData("18898186027");
//    }
}
