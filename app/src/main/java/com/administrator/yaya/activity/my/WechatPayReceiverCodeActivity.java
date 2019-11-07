package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.TestUpLoadCodeIv;
import com.administrator.yaya.bean.my.SwitchReceiveingQrCode;
import com.administrator.yaya.bean.my.TestLoadHeadlerIv;
import com.administrator.yaya.bean.my.TestWechatReceiverCode;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.MultipleCrop;
import org.devio.takephoto.model.TException;
import org.devio.takephoto.model.TImage;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.uitl.TImageFiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
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
 * 微信收款码
 */
public class WechatPayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView, TakePhoto.TakeResultListener, SlideFromBottomPopup.BottomPopClick {
    @BindView(R.id.wechatpay_receive_back_iv)
    ImageView wechatpayReceiveBackIv;

    @BindView(R.id.wechatpay_two_switch)
    Switch wechatpayTwoSwitch;

    @BindView(R.id.pay_add1_iv)
    ImageView payAdd1Iv;
    @BindView(R.id.pay_add2_iv)
    ImageView payAdd2Iv;
    @BindView(R.id.two_ll)
    LinearLayout twoLl;

    @BindView(R.id.get_menry)
    TextView getMenry;

    @BindView(R.id.iv_money1)
    TextView mMoneyTv1;

    @BindView(R.id.iv_money2)
    TextView mMoneyTv2;

    @BindView(R.id.iv_money3)
    TextView mMoneyTv3;

    @BindView(R.id.pay_add3_iv)
    ImageView payAdd3Iv;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.pay_add4_iv)
    ImageView payAdd4Iv;

    private TestWechatReceiverCode.DataBean data;
    private TakePhotoImpl mTakePhoto;
    private SlideFromBottomPopup mPop;
    private File cameraSavePath;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wechat_pay_receiver_code;
    }

    @Override
    protected void initListener() {
        wechatpayTwoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SPUtils.getInstance().put(Constants.AUTO_PALY_IN_WIFI, isChecked);
                if (isChecked) {//开启
                    String userId = SharedPrefrenceUtils.getString(WechatPayReceiverCodeActivity.this, NormalConfig.USER_ID);
                    if (userId != null)
                        mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE, Integer.parseInt(userId), 1, 1);
//                    List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> userCodeImgList = data.getUserCodeImgList();
//                    if (userCodeImgList.size()>0) {
//                        String imgUrl1 = userCodeImgList.get(0).getImgUrl();
//                        String imgUrl2 = userCodeImgList.get(1).getImgUrl();
////                        String imgUrl3 = userCodeImgList.get(2).getImgUrl();
//
//                        int imgMoney1 = userCodeImgList.get(0).getImgMoney();
//                        int imgMoney2 = userCodeImgList.get(1).getImgMoney();
////                        int imgMoney3 = userCodeImgList.get(2).getImgMoney();
//
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(imgUrl1).into(payAdd1Iv);
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(imgUrl2).into(payAdd2Iv);
////                        Glide.with(WechatPayReceiverCodeActivity.this).load(imgUrl3).into(payAdd3Iv);
//                        mMoneyTv1.setText(imgMoney1+"元");
//                        mMoneyTv2.setText(imgMoney2+"元");
////                        mMoneyTv3.setText(imgMoney3+"元");
//                    }
                } else {
                    String userId = SharedPrefrenceUtils.getString(WechatPayReceiverCodeActivity.this, NormalConfig.USER_ID);
                    if (userId != null)
                        mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE, Integer.parseInt(userId), 1, 2);
//                    ToastUtil.showShort( "onCheckedChanged: 关闭" + isChecked);
                }
            }
        });
    }
    @Override
    protected void initView() {
        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");

    }

    @Override
    protected void initData() {
//        参数:
//        用户id		userId
//        类型		type	1、微信 2、支付宝
        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        if (userId != null) {
//            mPresenter.getData(ApiConfig.TEST_WECHAT_RECEIVER_CODE, Integer.parseInt(userId), 1);//1、微信 2、支付宝
        } else {
            ToastUtil.showShort(R.string.networkerr + "");
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_WECHAT_RECEIVER_CODE:
                TestWechatReceiverCode testWechatReceiverCode = (TestWechatReceiverCode) t[0];
                if (testWechatReceiverCode.getCode() == 0 && testWechatReceiverCode.getData() != null) {
                    data = testWechatReceiverCode.getData();
                    Log.i("tag", "微信: " + testWechatReceiverCode.toString());
                } else {
                    ToastUtil.showShort(testWechatReceiverCode.getMsg());
                }
                break;
            //打开开关
            case ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE:
                SwitchReceiveingQrCode switchReceiveingQrCode = (SwitchReceiveingQrCode) t[0];
                if (switchReceiveingQrCode.getCode() == 0) {
                    ToastUtil.showShort("打开"+switchReceiveingQrCode.getMsg());
                } else {
                    ToastUtil.showShort(""+switchReceiveingQrCode.getMsg());
                }
                break;
//                关闭开关
//            case ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE2:
//
//
//                break;
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

    }

    @OnClick({R.id.wechatpay_receive_back_iv, R.id.wechatpay_two_switch, R.id.pay_add1_iv, R.id.pay_add2_iv, R.id.pay_add3_iv, R.id.pay_add4_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wechatpay_receive_back_iv:
                WechatPayReceiverCodeActivity.this.finish();
                break;
            case R.id.wechatpay_two_switch:

                break;
            case R.id.pay_add1_iv:
//                //初始化底部弹出拍照的pop
//                showPopWIndow();
                getPhotoAlbum(1);
                break;
            case R.id.pay_add2_iv:
//初始化底部弹出拍照的pop
//               showPopWIndow();
                getPhotoAlbum(2);
                break;
            case R.id.pay_add3_iv:
//初始化底部弹出拍照的pop
//                showPopWIndow();
                getPhotoAlbum(3);
                break;
            case R.id.pay_add4_iv:
//初始化底部弹出拍照的pop
//                showPopWIndow();
                getPhotoAlbum(4);
                break;
        }
    }

    private void getPhotoAlbum(int type){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.putExtra("1",type);
        intent.setType("image/*");
        startActivityForResult(intent,ApiConfig.request_open_album_code);
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
     *
     * @param result
     */

    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getCompressPath() != null ? result.getImage().getCompressPath() : result.getImage().getOriginalPath();//先设置到列表中
        if (!TextUtils.isEmpty(path)) {
            //记住头像
//            SharedPrefrenceUtils.saveString(this,NormalConfig.HEADLER_IMAGEVIEW,path);
//            ToastUtil.showShort("上传成功");
//            showLoadingDialog();
//            mPresenter.getData(ApiConfig.UPLOAD_IMAGE, path);
//            Glide.with(this).load(path).into(registerHeadlerIv);
            File file = new File(path);
//            SwitchIv(path);
//            Log.i("tag", "takeSuccess:"+path);
            uploadFile(file);
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

                .addFormDataPart("userId", userId)

                .addFormDataPart("imgMoney", userId)

                .addFormDataPart("imgType", "1")//代表微信

                .build();

        Request request = new Request.Builder()

                .url("http://192.168.0.198:8080/yayaApp/uploadCodeImg")

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
                final TestUpLoadCodeIv testLoadHeadlerIv = gson.fromJson(url, TestUpLoadCodeIv.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (testLoadHeadlerIv.getCode()==0 &&testLoadHeadlerIv.getData()!=null){

                            TestUpLoadCodeIv.DataBean data = testLoadHeadlerIv.getData();

                            String imgUrl = data.getImgUrl();

                            Glide.with(WechatPayReceiverCodeActivity.this).load(imgUrl).into(payAdd1Iv);

                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());

                        }else{
                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());
                        }
                    }
                });

            }
        });

    }

    /**
     * 拍照或获取相册图片失败
     *
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
    public boolean dispatchKeyEvent(KeyEvent event) {
//        ToastUtil.showShort(event.getKeyCode()+"");
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//            ToastUtil.showShort("enter click");
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String photoPath = null;
        if (requestCode == ApiConfig.request_open_album_code && resultCode == RESULT_OK) {
            int intExtra = data.getIntExtra("1", -1);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                photoPath = String.valueOf(cameraSavePath);
            }
//            else {
//                photoPath = uri.getEncodedPath();
//            }
            switch (intExtra) {
                case 1:
                    Glide.with(WechatPayReceiverCodeActivity.this).load(photoPath).into(payAdd1Iv);

                    break;
                case 2:
                    Glide.with(WechatPayReceiverCodeActivity.this).load(photoPath).into(payAdd2Iv);

                    break;
                case 3:
                    Glide.with(WechatPayReceiverCodeActivity.this).load(photoPath).into(payAdd3Iv);

                    break;
                case 4:
                    Glide.with(WechatPayReceiverCodeActivity.this).load(photoPath).into(payAdd4Iv);

                    break;
                case 5:
                    Glide.with(WechatPayReceiverCodeActivity.this).load(photoPath).into(payAdd4Iv);

                    break;
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
