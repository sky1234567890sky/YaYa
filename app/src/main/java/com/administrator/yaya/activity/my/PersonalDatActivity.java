package com.administrator.yaya.activity.my;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.my.TestLoadHeadlerIv;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
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
//        昵称
//        String nickName = getIntent().getStringExtra("NickName");
        String nickName = SharedPrefrenceUtils.getString(BaseApp.getApplication(), NormalConfig.USER_NICK);
        if (nickName!=null)persionalName.setText(nickName);

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
//    "http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg"
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
                //获取权限工具类
//                MyPermission.getPermission(this,true,false);
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
            //上传头像
            File file = new File(path);
            uploadFile(file);
            //上传成功保存
//            Glide.with(this).load(path).placeholder(R.mipmap.icon).into(personalHeaderIv);
        }
    }
    private void uploadFile(File file) {
        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
//        Log.i("tag", "路经: "+file+"......."+userId);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

        MultipartBody body = new MultipartBody.Builder()

                .setType(MultipartBody.FORM)

                .addFormDataPart("file", file.getName(), requestBody)

                .addFormDataPart("userId", userId)//用户头像

                .build();
        Request request = new Request.Builder()
                .url("http://192.168.0.198:8080/yayaApp/updateHeadImg")
                .post(body)

                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtil.showShort(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String url = response.body().string();
//                Log.i("tag", "路经: "+url);
                Gson gson = new Gson();
                final TestLoadHeadlerIv testLoadHeadlerIv = gson.fromJson(url, TestLoadHeadlerIv.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (testLoadHeadlerIv.getCode()==0 &&testLoadHeadlerIv.getData()!=null){
                            TestLoadHeadlerIv.DataBean data = testLoadHeadlerIv.getData();
                            String imgUrl = data.getImgUrl();
                            //后台登录才能访问图片吧
                            Glide.with(PersonalDatActivity.this).load(imgUrl).into(personalHeaderIv);
                            //保存头像
                            SharedPrefrenceUtils.saveString(PersonalDatActivity.this,NormalConfig.HEADLER_IMAGEVIEW,imgUrl);

                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());
                        }else{
                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());
                        }
                    }
                });

            }
        });
    }
    @Override
    public void takeFail(TResult result, String msg) {
//        ToastUtil.showShort(msg);
    }
    @Override
    public void takeCancel() {
//        ToastUtil.showShort("取消获取图片");
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
