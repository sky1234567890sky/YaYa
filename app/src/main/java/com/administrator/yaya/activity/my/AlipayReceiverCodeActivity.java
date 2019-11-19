package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.AlipayReceiverCodeAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.bean.TestUpLoadCodeIv2;
import com.administrator.yaya.bean.TestUpLoadGetQr;
import com.administrator.yaya.bean.my.TestAlipayReceiverCode;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AlbumUtil;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

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
//    @BindView(R.id.alipay_qr)
//    RecyclerView mList;
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
    @BindView(R.id.pay_add1_iv)
    ImageView payAdd1Iv;
    @BindView(R.id.wechat_ll1)
    LinearLayout mLl1;
    @BindView(R.id.wechat_ll2)
    LinearLayout mLl2;
    @BindView(R.id.iv_money1)
    TextView ivMoney1;
    @BindView(R.id.pay_add3_iv)
    ImageView payAdd3Iv;
    @BindView(R.id.wechat_ll3)
    LinearLayout mLl3;
    @BindView(R.id.pay_add4_iv)
    ImageView payAdd4Iv;
    @BindView(R.id.wechat_ll4)
    LinearLayout mLl4;
    @BindView(R.id.iv_money2)
    TextView ivMoney2;
    @BindView(R.id.iv_money3)
    TextView ivMoney3;
    @BindView(R.id.pay_add4_iv4)
    ImageView payAdd4Iv4;
    @BindView(R.id.wechat_ll5)
    LinearLayout mLl5;
    @BindView(R.id.pay_add_iv)
    ImageView payAddIv;
    @BindView(R.id.wechat_ll6)
    LinearLayout mLl6;
    @BindView(R.id.iv_money4)
    TextView ivMoney4;
    @BindView(R.id.iv_money5)
    TextView ivMoney5;


    @BindView(R.id.wechat_hint_unreviewed)
    TextView wechatHintUnreviewed;
    @BindView(R.id.wechat_no_shenhe)
    TextView wechatNoShenhe;
    @BindView(R.id.ImageView_url_wechat2)
    ImageView ImageViewUrlWechat2;
    @BindView(R.id.wechat_hint_unreviewed2)
    TextView wechatHintUnreviewed2;
    @BindView(R.id.wechat_no_shenhe2)
    TextView wechatNoShenhe2;

    @BindView(R.id.ImageView_url_wechat3)
    ImageView ImageViewUrlWechat3;
    @BindView(R.id.wechat_hint_unreviewed3)
    TextView wechatHintUnreviewed3;
    @BindView(R.id.wechat_no_shenhe3)
    TextView wechatNoShenhe3;
    @BindView(R.id.ImageView_url_wechat4)
    ImageView ImageViewUrlWechat4;
    @BindView(R.id.wechat_hint_unreviewed4)
    TextView wechatHintUnreviewed4;
    @BindView(R.id.wechat_no_shenhe4)
    TextView wechatNoShenhe4;
    @BindView(R.id.ImageView_url_wechat5)
    ImageView ImageViewUrlWechat5;
    @BindView(R.id.wechat_hint_unreviewed5)
    TextView wechatHintUnreviewed5;
    @BindView(R.id.wechat_no_shenhe5)
    TextView wechatNoShenhe5;

    @BindView(R.id.ImageView_url_wechat6)
    ImageView ImageViewUrlWechat6;
    @BindView(R.id.wechat_hint_unreviewed6)
    TextView wechatHintUnreviewed6;
    @BindView(R.id.wechat_no_shenhe6)
    TextView wechatNoShenhe6;
    @BindView(R.id.ImageView_url_wechat)
    ImageView ImageViewUrlWechat;
    @BindView(R.id.pay_add2_iv)
    ImageView payAdd2Iv;
    @BindView(R.id.get_menry)
    TextView getMenry;

    private int wechatCode;
    private TestAlipayReceiverCode testAlipayReceiverCode;
    private AlipayReceiverCodeAdapter adapter;
    private String userId;
    private File cameraSavePath;
    private int index = -1;
    private double money = 0.00;
    private String imgUrl;
    private View views;
    private int type = 0;
    private int newType=0;
    private List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> userCodeImgList;
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
//        mList.setLayoutManager(new GridLayoutManager(this, 2));
//        adapter = new AlipayReceiverCodeAdapter(list);
//        mList.setAdapter(adapter);
    }
    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData(ApiConfig.TEST_WECHAT_RECEIVER_CODE, Integer.parseInt(userId), 2);//1、微信 2、支付
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALIPAY_RECEIVER_CODE:
                testAlipayReceiverCode = (TestAlipayReceiverCode) t[0];
                if (testAlipayReceiverCode.getCode()==0) {
                    TestAlipayReceiverCode.DataBean data = testAlipayReceiverCode.getData();
//                    Log.i("tag", "支付宝: "+ testAlipayReceiverCode.toString());
                    userCodeImgList = data.getUserCodeImgList();
//                    list.addAll(userCodeImgList);
//                    adapter.notifyDataSetChanged();
                    getImageData(userCodeImgList);
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
            case ApiConfig.TEST_UPLOAD_GET_QR:
                TestUpLoadGetQr testUpLoadGetQr = (TestUpLoadGetQr) t[0];
                if (testUpLoadGetQr.getCode() == 0) {//返回图片路径
                    initData();
                    //二维码上传
//                    mPresenter.getData(ApiConfig.TEST_WECHAT_RECEIVER_CODE, Integer.parseInt(userId), 1);//1、微信 2、支付宝
                }
                break;
        }
    }
    private void getImageData(List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> userCodeImgList) {
        for (int i = 0; i < userCodeImgList.size(); i++) {
            TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean1 = userCodeImgList.get(i);

            String imgUrl = userCodeImgListBean1.getImgUrl();
            if (userCodeImgListBean1.getImgMoney() == 1000.0){
                type = 1;
                Glide.with(this).load(imgUrl).into(ImageViewUrlWechat2);
            } else if (userCodeImgListBean1.getImgMoney() == 2000.0) {
                type = 2;
                Glide.with(this).load(imgUrl).into(ImageViewUrlWechat3);
            } else if (userCodeImgListBean1.getImgMoney() == 3000.0) {
                Glide.with(this).load(imgUrl).into(ImageViewUrlWechat4);
                type = 3;
//                    getImageStatus2(userCodeImgListBean1,3);
            } else if (userCodeImgListBean1.getImgMoney() == 4000.0) {
                Glide.with(this).load(imgUrl).into(ImageViewUrlWechat5);
                type = 4;
//          getImageStatus2(userCodeImgListBean1,4);
            } else if (userCodeImgListBean1.getImgMoney() == 5000.0) {
                Glide.with(this).load(imgUrl).into(ImageViewUrlWechat6);
                type = 5;
//           getImageStatus2(userCodeImgListBean1,5);

            } else {
//                    getImageStatus2(userCodeImgListBean1,5);
                Glide.with(this).load(imgUrl).into(ImageViewUrlWechat);
                type = 0;

            }
            getImageStatus(userCodeImgListBean1, type);
        }
    }
    private void getImageStatus(TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean1, int type) {
        switch (type) {
            case 0://任意付款金额
                if (userCodeImgListBean1.getImgStatus() == 1) {
                    //待审核  不能点击
                    mLl1.setClickable(false);

                    ImageViewUrlWechat.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed.setVisibility(View.VISIBLE);
                    mLl1.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat);
                } else if (userCodeImgListBean1.getImgStatus() == 2) {
                    //审核通过
                    ImageViewUrlWechat.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed.setVisibility(View.GONE);
                    mLl1.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat);
                } else if (userCodeImgListBean1.getImgStatus() == 3) {
                    //待审核不通过
                    ImageViewUrlWechat.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed.setVisibility(View.VISIBLE);
                    mLl1.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat);
                }

                break;
            case 1:
                if (userCodeImgListBean1.getImgStatus() == 1) {
                    //待审核  不能点击
                    mLl2.setClickable(false);

                    ImageViewUrlWechat2.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed2.setVisibility(View.VISIBLE);
                    mLl2.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat2);
                } else if (userCodeImgListBean1.getImgStatus() == 2) {
                    //审核通过
                    ImageViewUrlWechat2.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed2.setVisibility(View.GONE);
                    mLl2.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat);
                } else if (userCodeImgListBean1.getImgStatus() == 3) {
                    //待审核不通过
                    ImageViewUrlWechat2.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed2.setVisibility(View.VISIBLE);
                    mLl2.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat);
                }
                break;
            case 2:
                if (userCodeImgListBean1.getImgStatus() == 1) {
                    //待审核  不能点击
                    mLl3.setClickable(false);

                    ImageViewUrlWechat3.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed3.setVisibility(View.VISIBLE);
                    mLl3.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat3);
                } else if (userCodeImgListBean1.getImgStatus() == 2) {
                    //审核通过
                    ImageViewUrlWechat3.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed3.setVisibility(View.GONE);
                    mLl3.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat3);
                } else if (userCodeImgListBean1.getImgStatus() == 3) {
                    //待审核不通过
                    ImageViewUrlWechat3.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed3.setVisibility(View.VISIBLE);
                    mLl3.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat3);
                }
                break;
            case 3:
                if (userCodeImgListBean1.getImgStatus() == 1) {
                    //待审核  不能点击
                    mLl4.setClickable(false);

                    ImageViewUrlWechat4.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed4.setVisibility(View.VISIBLE);
                   mLl4.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat4);
                } else if (userCodeImgListBean1.getImgStatus() == 2) {
                    //审核通过
                    ImageViewUrlWechat4.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed4.setVisibility(View.GONE);
                    mLl4.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat4);
                } else if (userCodeImgListBean1.getImgStatus() == 3) {
                    //待审核不通过
                    ImageViewUrlWechat4.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed4.setVisibility(View.VISIBLE);
                    mLl4.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat4);
                }
                break;
            case 4:
                if (userCodeImgListBean1.getImgStatus() == 1) {
                    //待审核  不能点击
                    mLl5.setClickable(false);

                    ImageViewUrlWechat5.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed5.setVisibility(View.VISIBLE);
                    mLl5.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat5);
                } else if (userCodeImgListBean1.getImgStatus() == 2) {
                    //审核通过
                    ImageViewUrlWechat5.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed5.setVisibility(View.GONE);
                    mLl5.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat5);
                } else if (userCodeImgListBean1.getImgStatus() == 3) {
                    //待审核不通过
                    ImageViewUrlWechat5.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed5.setVisibility(View.VISIBLE);
                    mLl5.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat5);
                }
                break;
            case 5:
                if (userCodeImgListBean1.getImgStatus() == 1) {
                    //待审核  不能点击
                    mLl6.setClickable(false);

                    ImageViewUrlWechat6.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed6.setVisibility(View.VISIBLE);
                    mLl6.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat6);
                } else if (userCodeImgListBean1.getImgStatus() == 2) {
                    //审核通过
                    ImageViewUrlWechat6.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed6.setVisibility(View.GONE);
                    mLl6.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat6);
                } else if (userCodeImgListBean1.getImgStatus() == 3) {
                    //待审核不通过
                    ImageViewUrlWechat6.setVisibility(View.VISIBLE);
                    wechatHintUnreviewed6.setVisibility(View.VISIBLE);
                    mLl6.setVisibility(View.INVISIBLE);
//                    Glide.with(this).load(userCodeImgListBean1.getImgUrl()).into(ImageViewUrlWechat6);
                }

                break;
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
        //        参数:
//        用户id		userId
//        类型		type	1、微信 2、支付宝
        //收款码  支付宝
//        adapter.setAlipayPayReceiverCodesetOnclikListener(new AlipayReceiverCodeAdapter.AlipayPayReceiverCodesetOnclikListener() {
//            @Override
//            public void setonclik(int index, View view) {
//                AlipayReceiverCodeActivity.this.views = view;
//                AlipayReceiverCodeActivity.this.index = index;
//                //打开相册
//                if (index == 1) {
//                    money = 1000.00;
//                } else if (index == 2) {
//                    money = 2000.00;
//                } else if (index == 3) {
//                    money = 3000.00;
//                } else if (index == 4) {
//                    money = 4000.00;
//                } else if (index == 5) {
//                    money = 5000.00;
//                } else {
//                    money = 0.00;
//                }
//                getPhotoAlbum();
//            }
//        });

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

            uploadFile(upladFile,newType);

//            mPresenter.getData(ApiConfig.TEST_UPLOAD_IMAGEVIE,filePart);//1微信 2二维码
            //上传收款码    参数:
            // imgId   添加时可无
            // userId 用户id
            // imgType 1、微信 2、支付宝
            // imgUrl 图片路径
        }
    }
    private void uploadFile(File file,final  int t) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), requestBody)
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
                            imgUrl = testUpLoadCodeIv2.getMsg();
                            double money = 0.0;
                            if(t==1){
                                money=1000.0;
                            }else if(t==2){
                                money=2000.0;
                            }else if(t==3){
                                money=3000.0;
                            }else if(t==4){
                                money=4000.0;
                            }else if(t==5){
                                money=5000.0;
                            }else{
                                money=0.0;
                            }
                            mPresenter.getData(ApiConfig.TEST_UPLOAD_GET_QR, Integer.parseInt(userId), 2, imgUrl,money);
//                            Log.i("tag", "支付宝收款码ImageView: "+imgUrl);
                            //上传收款码
//                            参数:
//                            imgId   添加时可无
//                            userId 用户id
//                            imgType 1、微信 2、支付宝
//                            imgUrl 图片路径
//                            imgMoney  码金额
                        }
                    }
                });
            }
        });
    }

    //打开相册
    private void getPhotoAlbum(int newType) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        if(newType!=-1){
            this.newType=newType;
        }
        startActivityForResult(intent, ApiConfig.request_open_album_code);
    }

    @OnClick({R.id.pay_receive_back_iv, R.id.wechat_ll1, R.id.wechat_ll2, R.id.wechat_ll3, R.id.wechat_ll4, R.id.wechat_ll5, R.id.wechat_ll6,

            R.id.ImageView_url_wechat, R.id.wechat_hint_unreviewed, R.id.wechat_no_shenhe,
            R.id.ImageView_url_wechat2, R.id.wechat_hint_unreviewed2,
            R.id.wechat_no_shenhe2, R.id.iv_money1, R.id.ImageView_url_wechat3,
            R.id.wechat_hint_unreviewed3, R.id.wechat_no_shenhe3,
            R.id.ImageView_url_wechat4, R.id.wechat_hint_unreviewed4, R.id.wechat_no_shenhe4,
            R.id.iv_money2, R.id.iv_money3, R.id.ImageView_url_wechat5,
            R.id.wechat_hint_unreviewed5, R.id.wechat_no_shenhe5,
            R.id.ImageView_url_wechat6, R.id.wechat_hint_unreviewed6, R.id.wechat_no_shenhe6,
            R.id.iv_money4, R.id.iv_money5
    })
    public void onViewClicked(View view) {
        int imgId=0;
        switch (view.getId()) {
            case R.id.pay_receive_back_iv:
                AlipayReceiverCodeActivity.this.finish();
                break;
            case R.id.wechat_ll1:
//                imgId = userCodeImgList.get(0).getImgId();
                getPhotoAlbum(0);
                break;
            case R.id.wechat_ll2:
//                imgId = userCodeImgList.get(1).getImgId();
                getPhotoAlbum(1);
                break;
            case R.id.wechat_ll3:
//                imgId = userCodeImgList.get(2).getImgId();
                getPhotoAlbum(2);
                break;
            case R.id.wechat_ll4:
//                imgId = userCodeImgList.get(2).getImgId();
                getPhotoAlbum(3);
                break;

            case R.id.wechat_ll5:
                imgId = userCodeImgList.get(2).getImgId();
                getPhotoAlbum(4);
                break;

            case R.id.wechat_ll6:
                imgId = userCodeImgList.get(2).getImgId();
                getPhotoAlbum(5);
                break;

            case R.id.ImageView_url_wechat://图片显示上传的二维码

                getPhotoAlbum(-1);

                break;
            case R.id.wechat_hint_unreviewed://提示未上传

                break;
            case R.id.wechat_no_shenhe://审核不通过

                break;


            case R.id.ImageView_url_wechat2:
                getPhotoAlbum(-1);
                break;
            case R.id.wechat_hint_unreviewed2:
                break;

            case R.id.wechat_no_shenhe2:
                break;

            case R.id.iv_money1:
                break;
            case R.id.ImageView_url_wechat3:
                getPhotoAlbum(-1);
                break;
            case R.id.wechat_hint_unreviewed3:
                break;
            case R.id.wechat_no_shenhe3:
                break;

            case R.id.ImageView_url_wechat4:
                getPhotoAlbum(-1);
                break;
            case R.id.wechat_hint_unreviewed4:
                break;
            case R.id.wechat_no_shenhe4:
                break;

            case R.id.iv_money2:
                break;
            case R.id.iv_money3:
                break;
            case R.id.ImageView_url_wechat5:
                getPhotoAlbum(-1);
                break;
            case R.id.wechat_hint_unreviewed5:
                break;
            case R.id.wechat_no_shenhe5:
                break;

            case R.id.ImageView_url_wechat6:
                getPhotoAlbum(-1);
                break;
            case R.id.wechat_hint_unreviewed6:
                break;
            case R.id.wechat_no_shenhe6:
                break;
            case R.id.iv_money4:
                break;
            case R.id.iv_money5:
                break;
        }
    }
}