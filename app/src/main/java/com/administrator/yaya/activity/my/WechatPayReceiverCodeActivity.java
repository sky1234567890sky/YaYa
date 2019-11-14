package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.WechatPayReceiverCodeAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.bean.TestUpLoadCodeIv;
import com.administrator.yaya.bean.TestUpLoadCodeIv2;
import com.administrator.yaya.bean.my.SwitchReceiveingQrCode;
import com.administrator.yaya.bean.my.TestWechatReceiverCode;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AlbumUtil;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class WechatPayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.wechatpay_receive_back_iv)
    ImageView wechatpayReceiveBackIv;

    @BindView(R.id.wechatpay_two_switch)
    Switch wechatpayTwoSwitch;

    @BindView(R.id.wechat_qr)
    RecyclerView mList;
    @BindView(R.id.wechat_refreshLayout)
    SmartRefreshLayout mSmartRefresh;

    private List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> list = new ArrayList<>();
    private TestWechatReceiverCode.DataBean data;
    private TakePhotoImpl mTakePhoto;
    private SlideFromBottomPopup mPop;
    private File cameraSavePath;
    private String userId;
    private WechatPayReceiverCodeAdapter adapter;
    double money = 0.0;
    private String imgUrl;
    private  int index = -1;

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

                    if (userId != null)
                        mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE, Integer.parseInt(userId), 1, 1);

                } else {
                    if (userId != null)
                        mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE, Integer.parseInt(userId), 1, 2);
                }
            }
        });
    }

    @Override
    protected void initView() {
        userId = SharedPrefrenceUtils.getString(WechatPayReceiverCodeActivity.this, NormalConfig.USER_ID);

        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");
        initRecycleView(mList,mSmartRefresh);
        mSmartRefresh.setEnableLoadMore(false);
        mList.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new WechatPayReceiverCodeAdapter(list);

        mList.setAdapter(adapter);
    }

    @Override
    protected void initData() {
//        参数:
//        用户id		userId
//        类型		type	1、微信 2、支付宝
        if (userId != null) {
            mPresenter.getData(ApiConfig.TEST_WECHAT_RECEIVER_CODE, Integer.parseInt(userId), 1);//1、微信 2、支付宝
        }

        adapter.setWechatPayReceiverCodesetOnclikListener(new WechatPayReceiverCodeAdapter.WechatPayReceiverCodesetOnclikListener() {
            @Override
            public void setonclik(int index, View view) {
                WechatPayReceiverCodeActivity.this.index = index;
                //打开相册
                if (index==1){
                    money=1000.0;
                }else if (index==2){
                    money=2000.0;
                }else if (index==3){
                    money=3000.0;
                }else if (index==4){
                    money=4000.0;
                }else if (index==5){
                    money=5000.0;
                }else{
                    money=0.0;
                }
                getPhotoAlbum();
//                ImageView iamgeViewHeadler = view.findViewById(R.id.ImageView_url_wechat);
//                switch (index) {
//                    case 1:
////                            AlbumUtil.getFilePath(this,cameraSavePath,);
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(finalPhotoPath).into(iamgeViewHeadler);
//                        break;
//                    case 2:
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(finalPhotoPath).into(iamgeViewHeadler);
//
//                        break;
//                    case 3:
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(finalPhotoPath).into(iamgeViewHeadler);
//
//                        break;
//                    case 4:
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(finalPhotoPath).into(iamgeViewHeadler);
//
//                        break;
//                    case 5:
//                        Glide.with(WechatPayReceiverCodeActivity.this).load(finalPhotoPath).into(iamgeViewHeadler);
//                        break;
//                }

            }
        });
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //列表
            case ApiConfig.TEST_WECHAT_RECEIVER_CODE:
                TestWechatReceiverCode testWechatReceiverCode = (TestWechatReceiverCode) t[0];
                if (testWechatReceiverCode.getCode() == 0) {
                    data = testWechatReceiverCode.getData();
                    List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> userCodeImgList = data.getUserCodeImgList();
                    list.addAll(userCodeImgList);
                    adapter.notifyDataSetChanged();
                    Log.i("tag", "微信: " + testWechatReceiverCode.toString());
                } else {
                    ToastUtil.showShort(testWechatReceiverCode.getMsg());
                }
                break;
            //打开开关
            case ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE:
                SwitchReceiveingQrCode switchReceiveingQrCode = (SwitchReceiveingQrCode) t[0];
                if (switchReceiveingQrCode.getCode() == 0) {
                    ToastUtil.showShort("打开" + switchReceiveingQrCode.getMsg());

                } else {

                    ToastUtil.showShort("" + switchReceiveingQrCode.getMsg());
                }
                break;
            //微信上传二维码
            case ApiConfig.TEST_UPLOAD_IMAGEVIE:
                TestUpLoadCodeIv2 testUpLoadCodeIvs = (TestUpLoadCodeIv2) t[0];
                if(testUpLoadCodeIvs.getCode()==0){
//                    TestUpLoadCodeIv.DataBean data = testUpLoadCodeIvs.getData();
//                    String imgUrl = data.getImgUrl();
                    //上传成功//展示图片
                    ToastUtil.showLong(testUpLoadCodeIvs.getMsg());

                }else {

                    //不成功  待审核
                    ToastUtil.showLong(testUpLoadCodeIvs.getMsg());
                }
                break;

        }
    }

    @OnClick({R.id.wechatpay_receive_back_iv})
//, R.id.wechatpay_two_switch, R.id.pay_add1_iv, R.id.pay_add2_iv, R.id.pay_add3_iv, R.id.pay_add4_iv
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wechatpay_receive_back_iv:
                WechatPayReceiverCodeActivity.this.finish();
                break;
        }
    }
    private void getPhotoAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.putExtra("1", type);
        intent.setType("image/*");
        startActivityForResult(intent, ApiConfig.request_open_album_code);
    }

    private void uploadFile(File file) {
//        Log.i("tag", "路经: "+file+"......."+userId);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

        MultipartBody body = new MultipartBody.Builder()

                .setType(MultipartBody.FORM)

                .addFormDataPart("file", file.getName(), requestBody)

                .addFormDataPart("userId", userId)

                .addFormDataPart("imgMoney", String.valueOf(list.get(index).getImgMoney()))

                .addFormDataPart("imgType", "1")//代表微信

                .build();

        Request request = new Request.Builder()

                .url(NetConfig.BaseUrl + "yayaApp/uploadCodeImg")

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
                        if (testLoadHeadlerIv.getCode() == 0) {
                            TestUpLoadCodeIv.DataBean data = testLoadHeadlerIv.getData();
                            imgUrl = data.getImgUrl();
//                            Glide.with(WechatPayReceiverCodeActivity.this).load(imgUrl).into();
                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());
                        } else {
                            ToastUtil.showShort(testLoadHeadlerIv.getMsg());
                        }
                    }
                });
            }
        });
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
            Uri uri = data.getData();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                photoPath = String.valueOf(cameraSavePath);
            }
            System.out.println("phone's path:"+uri.toString());
            String path = "" ;
                path = AlbumUtil.getFilePath(WechatPayReceiverCodeActivity.this, uri, data);
            if (path == null || "".equals(path))
                path = AlbumUtil.getImagePath(WechatPayReceiverCodeActivity.this, uri, data);


            File upladFile = new File(path);

            RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), upladFile);

            MultipartBody.Part filePart = MultipartBody.Part.createFormData("srcFile", "yaya.png", body);

            //微信
            ///上传图片
//            mPresenter.getData(ApiConfig.TEST_UPLOAD_IMAGEVIE,path,Integer.parseInt(userId),money,1);//1微信 2二维码
            mPresenter.getData(ApiConfig.TEST_UPLOAD_IMAGEVIE,filePart);//1微信 2二维码

        }
        super.onActivityResult(requestCode, resultCode, data);
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
}