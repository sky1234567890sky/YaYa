package com.administrator.yaya.activity.my;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.bean.TestUpLoadCodeIv2;
import com.administrator.yaya.bean.TestUpLoadGetQr;
import com.administrator.yaya.bean.my.TestLoadHeadlerIv;
import com.administrator.yaya.bean.my.TestUploadHeadler;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

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
public class PersonalDatActivity extends BaseMvpActivity<LoginModel> implements TakePhoto.TakeResultListener, SmsVerifyView.SmsVerifyCallback, SlideFromBottomPopup.BottomPopClick {
    @BindView(R.id.personal_back_iv)
    ImageView personalBackIv;
    @BindView(R.id.personal_nick_name_ll)
    RelativeLayout getPersionalLl;

    //personal_nick_name_ll
    @BindView(R.id.personal_header_iv)
    ImageView personalHeaderIv;

    @BindView(R.id.persional_ll)
    RelativeLayout persionalLl;

    @BindView(R.id.persional_name)
    TextView persionalName;

    @BindView(R.id.persional_phone_code)
    TextView persionalPhoneCode;

    private SlideFromBottomPopup mPop;
    private TakePhotoImpl mTakePhoto;
    private String userId;
    private String nickName;

    private long exittime;

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

        switch (whichApi) {
            //上传昵称   接口得调
            case ApiConfig.TEST_UPLOAD_NAME:
                TestUploadHeadler testUploadHeadler = (TestUploadHeadler) t[0];
                if (testUploadHeadler.getCode() == 0) {
                    ToastUtil.showLong(testUploadHeadler.getMsg());
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_NICK, nickName);
                    persionalName.setText(nickName);
                } else {
                    ToastUtil.showLong(testUploadHeadler.getMsg());
                }
                break;
                //上传头像
            case ApiConfig.TEST_CHANGE_HEADLER:

                TestUpLoadGetQr testUploadHeadler1 = (TestUpLoadGetQr) t[0];

                if (testUploadHeadler1.getCode()==0){

                    ToastUtil.showLong(testUploadHeadler1.getMsg());

                }else{

                    ToastUtil.showLong(testUploadHeadler1.getMsg());

                }
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
//        Intent intent = getIntent();
//        String headlerIv = intent.getStringExtra("headlerIv");
//        if (!headlerIv.isEmpty()){
//            persionalName.setText(nickName);
//        }
//        名字

        String nickNames = SharedPrefrenceUtils.getString(BaseApp.getApplication(), NormalConfig.USER_NICK);
        persionalName.setText(nickNames);

//        if (nickName != null) persionalName.setText(nickName);
        String phone_code = SharedPrefrenceUtils.getString(this, NormalConfig.USER_NAME);//手机号
        String headler_iamge = SharedPrefrenceUtils.getString(this, NormalConfig.HEADLER_IMAGEVIEW);//头像

        if (persionalPhoneCode != null && headler_iamge != null) {
            persionalPhoneCode.setText(phone_code);
            RequestOptions requestOptions = new RequestOptions().circleCrop();

            if (headler_iamge!=null){
                Glide.with(PersonalDatActivity.this)
                        .load(headler_iamge)
                        .apply(new RequestOptions().circleCrop())
                        .placeholder(R.mipmap.icon)
                        .into(personalHeaderIv);
            }
        }
    }

    @Override
    protected void initData() {
        super.initData();
    }
    //    "http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg"
    //弹出输入框
    @Override
    protected void initListener() {
        super.initListener();
    }
    @OnClick({R.id.personal_back_iv, R.id.personal_header_iv, R.id.personal_nick_name_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_back_iv:
                Intent intent = new Intent();
                intent.putExtra("sky",persionalName.getText().toString());
                setResult(12, intent);
                finish();
                break;
            case R.id.personal_header_iv:
                //获取权限工具类
//                MyPermission.getPermission(this,true,false);
                //初始化底部弹出拍照的pop
                mPop = new SlideFromBottomPopup(this);
                mPop.setLineText(getString(R.string.camera), getString(R.string.photo), getString(R.string.cancel));
                mPop.setBottomClickListener(this);
                mPop.showPopupWindow();
                break;

            case R.id.personal_nick_name_ll:
                updateNick();
                break;
        }
    }

    private void updateNick() {
        final EditText inputServer = new EditText(PersonalDatActivity.this);
        inputServer.setMaxLines(1);
        AlertDialog.Builder builder = new AlertDialog.Builder(PersonalDatActivity.this);
        builder.setTitle("请输入你要改的的昵称")
//                .setIcon(getResources().getDrawable(R.mipmap.icon))
                .setView(inputServer)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nickName = inputServer.getText().toString();
                if (nickName != null) {
                    upLoadHeadlerIv(nickName);//修改昵称
                }
            }
        });
        builder.show();
    }
    private void upLoadHeadlerIv(String nickName) {
        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);

        if (!nickName.isEmpty()) mPresenter.getData(ApiConfig.TEST_UPLOAD_NAME, Integer.parseInt(userId), nickName);
    }

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN){
            Intent intent = new Intent();
            intent.putExtra("sky",persionalName.getText().toString());
            setResult(12, intent);
            finish();
            return true;
        }
        return false;
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
        final String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), requestBody)
                .build();
        Request request = new Request.Builder()
                .url(NetConfig.BaseUrl + "uploadCodeImg")
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
                final TestUpLoadCodeIv2 testLoadHeadlerIv = gson.fromJson(url, TestUpLoadCodeIv2.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (testLoadHeadlerIv.getCode() == 0) {

                            String urlIv = testLoadHeadlerIv.getMsg();

                            Log.i("tag", "修改头像: "+urlIv);

                            //后台登录才能访问图片吧
//                          Glide.with(PersonalDatActivity.this).load(urlIv).placeholder(R.mipmap.icon).into(personalHeaderIv);
                            Glide.with( PersonalDatActivity.this)
                                    .load(urlIv)
                                    .apply(new RequestOptions().centerCrop())
                                    .placeholder(R.mipmap.icon)
                                    .into(personalHeaderIv);

                            //保存头像
                            SharedPrefrenceUtils.saveString(PersonalDatActivity.this, NormalConfig.HEADLER_IMAGEVIEW, urlIv);
//                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());
//                            上传头像
//                          updateHeadImg
//                            参数:
//                            userId 用户id
//                            userHeadImg 图片路径
                            mPresenter.getData(ApiConfig.TEST_CHANGE_HEADLER,Integer.parseInt(userId),urlIv);
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
