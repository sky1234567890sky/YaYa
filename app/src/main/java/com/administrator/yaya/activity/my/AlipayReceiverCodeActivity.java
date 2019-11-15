package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.ObligationAdapter;
import com.administrator.yaya.activity.my.adapter.AlipayReceiverCodeAdapter;
import com.administrator.yaya.activity.my.adapter.WechatPayReceiverCodeAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.bean.TestUpLoadCodeIv2;
import com.administrator.yaya.bean.my.SwitchReceiveingQrCode;
import com.administrator.yaya.bean.my.TestAlipayReceiverCode;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AlbumUtil;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

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

/**
 * 支付宝收款
 */
public class AlipayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.pay_receive_back_iv)
    ImageView payReceiveBackIv;
    @BindView(R.id.two_switch)
    Switch twoSwitch;
    @BindView(R.id.alipay_qr)
    RecyclerView mList;
//    @BindView(R.id.alipay_refreshLayout)
//    SmartRefreshLayout smartRefreshLayout;

    //    @BindView(R.id.add1)
//    ImageView add1;
//    @BindView(R.id.add2)
//    ImageView add2;
//    @BindView(R.id.two_ll)
//    LinearLayout twoLl;
//    @BindView(R.id.get_menry)
//    TextView getMenry;
//    @BindView(R.id.add3)
//    ImageView add3;
//    @BindView(R.id.ll3)
//    LinearLayout ll3;
//    @BindView(R.id.add4)
//    ImageView add4;
//    @BindView(R.id.receivable_tv2)
//    TextView mReceivableTv2;
//    @BindView(R.id.receivable_tv3)
//    TextView mReceivableTv3;
//    @BindView(R.id.receivable_tv4)
//    TextView mReceivableTv4;
    List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> list = new ArrayList<>();
    private int wechatCode;
    private TestAlipayReceiverCode testAlipayReceiverCode;
    private AlipayReceiverCodeAdapter adapter;
    private String userId;
    private File cameraSavePath;
    private int index = -1;
    private double money=0.0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payments_receive;
    }


    @Override
    protected void initView() {
        super.initView();
        userId = SharedPrefrenceUtils.getString(AlipayReceiverCodeActivity.this, NormalConfig.USER_ID);
        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");

//        initRecycleView(mList,abligationRefreshLayout);
//        abligationRefreshLayout.setEnableLoadMore(false);
//        initRecycleView(mList,smartRefreshLayout);
        mList.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new AlipayReceiverCodeAdapter(list);
        mList.setAdapter(adapter);
    }



    @Override
    protected void initData() {
        super.initData();
//        参数:
//        用户id		userId
//        类型		type	1、微信 2、支付宝
        //收款码  支付宝
        adapter.setAlipayPayReceiverCodesetOnclikListener(new AlipayReceiverCodeAdapter.AlipayPayReceiverCodesetOnclikListener() {
            @Override
            public void setonclik(int index, View view) {
                AlipayReceiverCodeActivity.this.index = index;
                //打开相册
                if (index == 1) {
                    money = 1000.0;
                } else if (index == 2) {
                    money = 2000.0;
                } else if (index == 3) {
                    money = 3000.0;
                } else if (index == 4) {
                    money = 4000.0;
                } else if (index == 5) {
                    money = 5000.0;
                } else {
                    money = 0.0;
                }
                getPhotoAlbum();
            }
        });

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALIPAY_RECEIVER_CODE:
                testAlipayReceiverCode = (TestAlipayReceiverCode) t[0];
                if (testAlipayReceiverCode != null && testAlipayReceiverCode.getData() != null) {
                    TestAlipayReceiverCode.DataBean data = testAlipayReceiverCode.getData();
//                    Log.i("tag", "支付宝: "+ testAlipayReceiverCode.toString());
                    List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> userCodeImgList = data.getUserCodeImgList();
                    list.addAll(userCodeImgList);
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtil.showShort(testAlipayReceiverCode.getMsg());
                }
                break;
//            case ApiConfig.://提示图片
//                SwitchReceiveingQrCode switchReceiveingQrCode = (SwitchReceiveingQrCode) t[0];
//                if (switchReceiveingQrCode.getCode() == 0) {
//                    ToastUtil.showShort(switchReceiveingQrCode.getMsg());
//                    //二维码上传
//                    mPresenter.getData(ApiConfig.TEST_WECHAT_RECEIVER_CODE, Integer.parseInt(userId), 2);//1、微信 2、支付
//                }
//                break;
        }
    }
    @Override
    protected void initListener() {
        twoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //微信按钮
//                TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean = userCodeImgList.get(data.getVxButtonStatus());
//                TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean = list.get(wechatCode);
//                if (userCodeImgListBean.getImgType() == 2) {
                if (isChecked) {

                } else {
//                        ToastUtil.showShort( "onCheckedChanged: 关闭" + isChecked);
//                        if (userId!=null)mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE,Integer.parseInt(userId),2,2);
                }
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

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @OnClick({R.id.pay_receive_back_iv, R.id.two_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pay_receive_back_iv:
                AlipayReceiverCodeActivity.this.finish();
                break;
            case R.id.two_switch:
                break;
        }
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
            System.out.println("phone's path:" + uri.toString());
            String path = "";
            path = AlbumUtil.getFilePath(AlipayReceiverCodeActivity.this, uri, data);
            if (path == null || "".equals(path))
                path = AlbumUtil.getImagePath(AlipayReceiverCodeActivity.this, uri, data);

            File upladFile = new File(path);

            RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), upladFile);

            MultipartBody.Part filePart = MultipartBody.Part.createFormData("srcFile", "yaya.png", body);
            //微信 上传图片        参数：file
//            mPresenter.getData(ApiConfig.TEST_UPLOAD_IMAGEVIE,path,Integer.parseInt(userId),money,1);//1微信 2二维码

            uploadFile(upladFile);
//            mPresenter.getData(ApiConfig.TEST_UPLOAD_IMAGEVIE,filePart);//1微信 2二维码
            //上传收款码    参数:
            // imgId   添加时可无
            // userId 用户id
            // imgType 1、微信 2、支付宝
            // imgUrl 图片路径

        }
    }

    private void uploadFile(File file) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

        MultipartBody body = new MultipartBody.Builder()

                .setType(MultipartBody.FORM)

                .addFormDataPart("file",file.getName(), requestBody)
                .build();
        Request request = new Request.Builder()
                .url(NetConfig.BaseUrl + "uploadCodeImg")
                //上传图片
                //uploadCodeImg
                //参数：file
                //结果：url
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
                final TestUpLoadCodeIv2 testUpLoadCodeIv2 = gson.fromJson(url, TestUpLoadCodeIv2.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (testUpLoadCodeIv2.getCode() == 0) {
                            String imgUrl = testUpLoadCodeIv2.getMsg();
//                            Log.i("tag", "支付宝收款码ImageView: "+imgUrl);

                            //上传收款码
//                            参数:
//                            imgId   添加时可无
//                            userId 用户id
//                            imgType 1、微信 2、支付宝
//                            imgUrl 图片路径
//                            imgMoney  码金额
                            mPresenter.getData(ApiConfig.TEST_UPLOAD_GET_QR, Integer.parseInt(userId), 2, imgUrl, 1000 + "");
                        }
                    }
                });
            }
        });
    }

    //打开相册
    private void getPhotoAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.putExtra("1", type);
        intent.setType("image/*");
        startActivityForResult(intent, ApiConfig.request_open_album_code);
    }
}