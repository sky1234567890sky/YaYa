package com.administrator.yaya.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.LoginInfo;
import com.administrator.yaya.bean.VerifyCodeInfo;
import com.administrator.yaya.bean.login_register_bean.TestInviteCode;
import com.administrator.yaya.bean.login_register_bean.TestRegister;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AppValidationMgr;
import com.administrator.yaya.utils.CountDownTimerUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;
import java.io.File;
import java.util.List;
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
    EditText registerEtUname;

    @BindView(R.id.et_register_verificationcode)
    EditText etRegisterVerificationcode;

    @BindView(R.id.btn_register_phonecode)
    TextView mInvitecode;

    @BindView(R.id.et_register_pw)
    EditText etRegisterPw;

    @BindView(R.id.et_getcode)
    EditText etGetcode;
    @BindView(R.id.register_register_btn)
    Button registerRegisterBtn;
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
        //倒计时工具类
        mDownTimerUtils = new CountDownTimerUtils(mInvitecode, 60000, 1000);
    }

    @Override
    public void onError(int whichApi, Throwable e) {
//        mView.reset();
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        //TODO:隐藏进度条
        switch (whichApi) {
            case ApiConfig.TEXT_REGISTER://注册
                TestRegister register = (TestRegister) t[0];
                if (register!=null){
                    ToastUtil.showShort("注册有数据");
                    //跳转只登陆界面登录
                }
                break;
            case ApiConfig.TEXT_InviteCode://验证码

                //获取验证码前判断手机号是否被注册
                TestInviteCode invitecode = (TestInviteCode) t[0];
                if (invitecode!=null){
                    ToastUtil.showShort("打死别给邀请码:");
                    //用短信推送验证码

                }
                break;

            case ApiConfig.GET_SMS_MJG://获取验证码

                VerifyCodeInfo verifyCodeInfos = (VerifyCodeInfo) t[0];
                if (verifyCodeInfos != null) ToastUtil.showShort("短信发送成功注意验收"+verifyCodeInfos.getVerify_token());
                break;
            case ApiConfig.GET_SMS:
                VerifyCodeInfo info = (VerifyCodeInfo) t[0];
//                mView.setVerifyCode(info.verify_token);
                break;

            case ApiConfig.LOGIN_ACC:
                //获取的是唯一用户ID，用来确认身份
                LoginInfo loginInfo = (LoginInfo) t[0];
//                ToastUtil.showShort(loginInfo.msg);
                //将这两个保存，并传给application
                mApplication.mToken = loginInfo.token;
//                mApplication.mUserPhoto  = loginInfo.nick;//传给Application用来给聊天界面
                //将token保存到本地
//                SharedPrefrenceUtils.saveString(this,NormalConfig.TOKEN,loginInfo.token);
//                SharedPrefrenceUtils.saveString(this,NormalConfig.USER_NICK,loginInfo.nick);
//                loginIm();//聊天登录
                break;
        }
    }
    private void loginIm() {
        //TODO:登录聊天逻辑处理
    }

    @Override
    protected void initData() {
        super.initData();
        //给权限
        getPermission();
    }

    @OnClick({R.id.register_back_iv, R.id.register_headleriv, R.id.btn_register_phonecode, R.id.register_register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_back_iv:
                finish();
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
                mDownTimerUtils.start();

//                mPresenter.getData(ApiConfig.TEXT_INVITECODE,0);
                ToastUtil.showShort("验证码已发送请注意查收");

                break;
            case R.id.register_register_btn://注册
                //MD5加密解密

                String number1 = registerEtUname.getText().toString().trim();
                String password1 = etRegisterPw.getText().toString().trim();
                if (number1.isEmpty() || number1 == null || password1.isEmpty() || password1 == null) {
                    ToastUtil.showShort("账号和密码不能为空");
                }else{
                    String regex = "[A-Za-z0-9]{4,12}";
                    if (AppValidationMgr.isPhone(number1) && password1.matches(regex) ){
                        mPresenter.getData(ApiConfig.TEXT_REGISTER,number1,password1);
                        ToastUtil.showShort("在请求数据...");
                    } else ToastUtil.showShort("请输入正确的手机号");
                }

                break;
        }
    }
    private void getPermission() {
        XXPermissions.with(this)
                .constantRequest()//可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                .constantRequest(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES)//支持请求 6.0 悬浮窗权限 8.0 请求安装权限
                .permission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }
                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (denied.size() != 0) ToastUtil.showLong("拒绝权限影响您正常使用");
                    }
                });
//                XXPermissions.gotoPermissionSettings(this);//跳转到权限设置页面
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
            ToastUtil.showShort("上传成功");

//            showLoadingDialog();
//            mPresenter.getData(ApiConfig.UPLOAD_IMAGE, path);
//            Glide.with(this).load(path).into(mImage);
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
