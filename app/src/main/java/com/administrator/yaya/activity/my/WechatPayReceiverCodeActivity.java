package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.my.adapter.WechatPayReceiverCodeAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.bean.TestUpLoadCodeIv2;
import com.administrator.yaya.bean.TestUpLoadGetQr;
import com.administrator.yaya.bean.my.SwitchReceiveingQrCode;
import com.administrator.yaya.bean.my.TestGetUsergCodeImg;
import com.administrator.yaya.bean.my.TestWechatReceiverCode;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AlbumUtil;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * 微信收款码
 */
public class WechatPayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    //    @BindView(R.id.wechatpay_receive_back_iv)
//    ImageView wechatpayReceiveBackIv;
    @BindView(R.id.wechatpay_two_switch)
    Switch wechatpayTwoSwitch;
//    @BindView(R.id.ImageView_url_wechat)
//    ImageView ImageViewUrlWechat;
//    @BindView(R.id.wechat_hint_unreviewed)
//    TextView wechatHintUnreviewed;
//    @BindView(R.id.wechat_no_shenhe)
//    TextView wechatNoShenhe;
//    @BindView(R.id.pay_add1_iv)
//    ImageView payAdd1Iv;
//    @BindView(R.id.wechat_ll1)
//    LinearLayout wechatLl1;
//    @BindView(R.id.ImageView_url_wechat2)
//    ImageView ImageViewUrlWechat2;
//    @BindView(R.id.wechat_hint_unreviewed2)
//    TextView wechatHintUnreviewed2;
//    @BindView(R.id.wechat_no_shenhe2)
//    TextView wechatNoShenhe2;
//    @BindView(R.id.pay_add2_iv)
//    ImageView payAdd2Iv;
//    @BindView(R.id.wechat_ll2)
//    LinearLayout wechatLl2;
//    @BindView(R.id.get_menry)
//    TextView getMenry;
//    @BindView(R.id.iv_money1)
//    TextView ivMoney1;
//    @BindView(R.id.ImageView_url_wechat3)
//    ImageView ImageViewUrlWechat3;
//    @BindView(R.id.wechat_hint_unreviewed3)
//    TextView wechatHintUnreviewed3;
//    @BindView(R.id.wechat_no_shenhe3)
//    TextView wechatNoShenhe3;
//    @BindView(R.id.pay_add3_iv)
//    ImageView payAdd3Iv;
//    @BindView(R.id.wechat_ll3)
//    LinearLayout wechatLl3;
//    @BindView(R.id.ImageView_url_wechat4)
//    ImageView ImageViewUrlWechat4;
//    @BindView(R.id.wechat_hint_unreviewed4)
//    TextView wechatHintUnreviewed4;
//    @BindView(R.id.wechat_no_shenhe4)
//    TextView wechatNoShenhe4;
//    @BindView(R.id.pay_add4_iv)
//    ImageView payAdd4Iv;
//    @BindView(R.id.wechat_ll4)
//    LinearLayout wechatLl4;
//    @BindView(R.id.iv_money2)
//    TextView ivMoney2;
//    @BindView(R.id.iv_money3)
//    TextView ivMoney3;
//    @BindView(R.id.ImageView_url_wechat5)
//    ImageView ImageViewUrlWechat5;
//    @BindView(R.id.wechat_hint_unreviewed5)
//    TextView wechatHintUnreviewed5;
//    @BindView(R.id.wechat_no_shenhe5)
//    TextView wechatNoShenhe5;
//    @BindView(R.id.pay_add4_iv4)
//    ImageView payAdd4Iv4;
//    @BindView(R.id.wechat_ll5)
//    LinearLayout wechatLl5;
//    @BindView(R.id.ImageView_url_wechat6)
//    ImageView ImageViewUrlWechat6;
//    @BindView(R.id.wechat_hint_unreviewed6)
//    TextView wechatHintUnreviewed6;
//    @BindView(R.id.wechat_no_shenhe6)
//    TextView wechatNoShenhe6;
//    @BindView(R.id.pay_add_iv)
//    ImageView payAddIv;
//    @BindView(R.id.wechat_ll6)
//    LinearLayout wechatLl6;
//    @BindView(R.id.iv_money4)
//    TextView ivMoney4;
//    @BindView(R.id.iv_money5)
//    TextView ivMoney5;

    @BindView(R.id.wechat_qr)
    RecyclerView mList;
    @BindView(R.id.wechat_refreshLayout)
    SmartRefreshLayout mSmartRefresh;

    private String imgUrl;
    private List<TestWechatReceiverCode.DataBean> list = new ArrayList<>();//二维码参数列表
    private List<TestGetUsergCodeImg.DataBean.UserCodeImgListBean> imgList = new ArrayList<>();//图片参数列表

    private TestWechatReceiverCode.DataBean data;
    private SlideFromBottomPopup mPop;
    private File cameraSavePath;
    private String userId;
    private String token;
    private WechatPayReceiverCodeAdapter adapter;
    double money = 0.00;
    private int index = -1;
    private String imgPath;
    private int type = 0;
    private View view;
    private Integer imgId;
    private List<TestGetUsergCodeImg.DataBean.UserCodeImgListBean> userCodeImgList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_wechat_pay_receiver_code;
    }
    @Override
    protected void initListener() {
        //        参数:
//        用户id		userId
//        类型		type	1、微信 2、支付宝
        adapter.setWechatPayReceiverCodesetOnclikListener(new WechatPayReceiverCodeAdapter.WechatPayReceiverCodesetOnclikListener() {
            @Override
            public void setonclik(int index, View views) {
                view = views;
                WechatPayReceiverCodeActivity.this.index = index;
                //不能点击|| list.get(index).getImgStatus()==3
//                二维码状态 1待审核 2审核完成  3审核不通过
                if (list.get(index).getImgStatus() != 1) {
                    money = list.get(index).getImgConfigMoney();
                    imgId = list.get(index).getImgId();
                    if (imgId==null){
                        imgId=0;
                    }
                    getPhotoAlbum();
                }
            }
        });

// else {
////            monesssy = 0.00;
////        }
        wechatpayTwoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {//开启
                    SharedPrefrenceUtils.saveBoolean(WechatPayReceiverCodeActivity.this, NormalConfig.WechatQr_isChecket, isChecked);
                    ToastUtil.showLong("开启");
                    if (userId != null)
                        mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE, Integer.parseInt(userId), 1, 1, token);
                } else {
                    ToastUtil.showLong("关闭");
                    SharedPrefrenceUtils.saveBoolean(WechatPayReceiverCodeActivity.this, NormalConfig.WechatQr_isChecket, isChecked);

                    mPresenter.getData(ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE, Integer.parseInt(userId), 1, 2, token);
                }
            }
        });
    }

    @Override
    protected void initView() {
        //开关按钮状态
        boolean aBoolean = SharedPrefrenceUtils.getBoolean(this, NormalConfig.WechatQr_isChecket);
        if (aBoolean == true) {
            wechatpayTwoSwitch.setChecked(aBoolean);
        } else {
            wechatpayTwoSwitch.setChecked(aBoolean);
        }
        userId = SharedPrefrenceUtils.getString(WechatPayReceiverCodeActivity.this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(WechatPayReceiverCodeActivity.this, NormalConfig.TOKEN);
//        Log.i("tag", "initView======: "+userId);
        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");

        initRecycleView(mList, mSmartRefresh);
        mList.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new WechatPayReceiverCodeAdapter(list);
        mList.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        super.refresh();
        mList.scrollToPosition(0);
        //下拉刷新，添加你刷新后的逻辑
        //加载完成时，隐藏控件下拉刷新的状态
//        mRefreshLayout.autoRefresh();
        initData();
    }

    @Override
    public void loadMore() {
        super.loadMore();

        mSmartRefresh.finishLoadMoreWithNoMoreData();

        mSmartRefresh.setNoMoreData(true);
    }

    @Override
    protected void initData() {
//        showLoadingDialog();
        //二维码上传
        //数据
        list.clear();

        userCodeImgList.clear();

        mPresenter.getData(ApiConfig.TEST_WECHAT_RECEIVER_CODE, 1);//1、微信 2、支付宝
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
//        hideLoadingDialog();
        switch (whichApi) {
            //收款码数列表
            case ApiConfig.TEST_WECHAT_RECEIVER_CODE:
                TestWechatReceiverCode testWechatReceiverCode = (TestWechatReceiverCode) t[0];
//                Log.i("tag", "收款码列表=======>" + testWechatReceiverCode.getData().toString());
//                if (testWechatReceiverCode.getMsg().equals(mApplication.SignOut)) {
//                    Toast.makeText(this, R.string.username_login_hint + "", Toast.LENGTH_SHORT).show();
//
//                    Intent login = new Intent(this, LoginActivity.class);
//                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
//
//                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
//
//                    mApplication.userid = 0;
//
//                    mApplication.mToken = "";
//
//                    startActivity(login);
//
//                    finish();
//
//                }else
                if (testWechatReceiverCode.getCode() == 0 && !testWechatReceiverCode.getMsg().equals(mApplication.SignOut)) {
                    List<TestWechatReceiverCode.DataBean> userCodeImgList1 = testWechatReceiverCode.getData();
                    list.addAll(userCodeImgList1);
                    //解析图片接口
                    mPresenter.getData(ApiConfig.TEST_USERCODE_IMG, Integer.parseInt(userId), token, 1);//微信图片列表

                }
                break;
            //打开开关
            case ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE:
                SwitchReceiveingQrCode switchReceiveingQrCode = (SwitchReceiveingQrCode) t[0];
                if (switchReceiveingQrCode.getMsg().equals(mApplication.SignOut)) {
                    Toast.makeText(this, R.string.username_login_hint + "", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(login);

                    finish();

                } else if (switchReceiveingQrCode.getCode() == 0) {
//                    ToastUtil.showShort(switchReceiveingQrCode.getMsg() + "");

                }
                break;
            //微信上传图片
//            case ApiConfig.TEST_UPLOAD_IMAGEVIE:
//                TestUpLoadCodeIv2 testUpLoadCodeIvs = (TestUpLoadCodeIv2) t[0];
//                if (testUpLoadCodeIvs.getCode() == 0) {
//                    String urlPath = testUpLoadCodeIvs.getMsg();
            //上传成功
//                    ToastUtil.showLong(testUpLoadCodeIvs.getMsg());
//                    imgId   添加时可无
//                    userId 用户id
//                    imgType 1、微信 2、支付宝
//                    imgUrl 图片路径
//                    imgMoney  码金额
            //上传收款码
//                    mPresenter.getData(ApiConfig.,Integer.parseInt(userId),1,urlPath,1000);
//                } else {
            //不成功  待审核
//                    ToastUtil.showLong(testUpLoadCodeIvs.getMsg());
//                }
//                break;


            //上传收款码
            case ApiConfig.TEST_UPLOAD_GET_QR:
                TestUpLoadGetQr testUpLoadGetQr = (TestUpLoadGetQr) t[0];
                if (testUpLoadGetQr.getCode() == 0) {
                    initData();
                }
                break;

            //图片参数列表
            case ApiConfig.TEST_USERCODE_IMG:
                TestGetUsergCodeImg testGetUsergCodeImg = (TestGetUsergCodeImg) t[0];
                if (testGetUsergCodeImg.getMsg().equals(mApplication.SignOut)) {
                    Toast.makeText(this, R.string.username_login_hint + "", Toast.LENGTH_SHORT).show();

                    Intent login = new Intent(this, LoginActivity.class);

                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(login);

                    finish();

                } else if (testGetUsergCodeImg.getCode() == 0) {

                    TestGetUsergCodeImg.DataBean data = testGetUsergCodeImg.getData();

                    userCodeImgList = data.getUserCodeImgList();//图片列表
                    //遍历参数
                    for (int i = 0; i < list.size(); i++) {

                        double img = list.get(i).getImgConfigMoney();
                        //遍历图片
                        for (int j = 0; j < userCodeImgList.size(); j++) {
                            TestGetUsergCodeImg.DataBean.UserCodeImgListBean userCodeImgListBean = userCodeImgList.get(j);
                            double imgMoney = userCodeImgListBean.getImgMoney();

                            if (img == imgMoney) {//用金额参数判断

                                list.get(i).setImage(userCodeImgList.get(j).getImgUrl());
                                list.get(i).setImgId(userCodeImgList.get(j).getImgId());
                                list.get(i).setImgStatus(userCodeImgList.get(j).getImgStatus());

                            }
                        }
                    }
//                    getImageData(imgList);
//
//                    adapter.notifyDataSetChanged();
//
//                    imgList.addAll(userCodeImgList);

                    adapter.notifyDataSetChanged();

                }
                break;
        }
        mSmartRefresh.finishLoadMore();
        mSmartRefresh.finishRefresh();
    }

    //    private void getImageData(List<TestGetUsergCodeImg.DataBean.UserCodeImgListBean> userCodeImgList) {
//        for (int i = 0; i < userCodeImgList.size(); i++) {
//            TestGetUsergCodeImg.DataBean.UserCodeImgListBean userCodeImgListBean1 = userCodeImgList.get(i);
//            //微信
////                if (userCodeImgListBean1.getImgType() == 1) {//微信
////            Log.i("刷新", "getImageData: "+userCodeImgListBean1.getImgMoney());
//                    if (userCodeImgListBean1.getImgMoney() == 1000.0) {
//                        type = 1;
//                        String imgUrl = userCodeImgListBean1.getImgUrl();
//                        Glide.with(this).load(imgUrl).into(ImageViewUrlWechat2);
//                    } else if (userCodeImgListBean1.getImgMoney() == 2000.0) {
//                        String imgUrl = userCodeImgListBean1.getImgUrl();
//
//                        Glide.with(this).load(imgUrl).into(ImageViewUrlWechat3);
//                        type = 2;
//                    } else if (userCodeImgListBean1.getImgMoney() == 3000.0) {
//                        String imgUrl = userCodeImgListBean1.getImgUrl();
//
//                        Glide.with(this).load(imgUrl).into(ImageViewUrlWechat4);
//                        type = 3;
//                    } else if (userCodeImgListBean1.getImgMoney() == 4000.0) {
//                        String imgUrl = userCodeImgListBean1.getImgUrl();
//
//                        Glide.with(this).load(imgUrl).into(ImageViewUrlWechat5);
//                        type = 4;
//                    } else if (userCodeImgListBean1.getImgMoney() == 5000.0) {
//                        String imgUrl = userCodeImgListBean1.getImgUrl();
//
//                        Glide.with(this).load(imgUrl).into(ImageViewUrlWechat6);
//                        type = 5;
//                    } else if(userCodeImgListBean1.getImgMoney()==0.0){
//                        String imgUrl = userCodeImgListBean1.getImgUrl();
//
////                        Log.i("刷新", "getImageData: 0000000000");
//                        Glide.with(this).load(imgUrl).into(ImageViewUrlWechat);
//                        type = 0;
//                    }
//                    getImageStatus(userCodeImgListBean1, type);
//                }
//            }
    //    private void getImageStatus(TestGetUsergCodeImg.DataBean.UserCodeImgListBean userCodeImgListBean1, int type) {
//        switch (type) {
//            case 0://任意付款金额
//                if (userCodeImgListBean1.getImgStatus() == 1) {
//                    //待审核  不能点击
//                    wechatLl1.setClickable(false);
//                    ImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed.setVisibility(View.VISIBLE);
//                    wechatLl1.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 2) {
//                    //审核通过
//                    ImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed.setVisibility(View.GONE);
//                    wechatLl1.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 3) {
//                    //待审核不通过
//                    ImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed.setVisibility(View.VISIBLE);
//                    wechatLl1.setVisibility(View.INVISIBLE);
//                }
//                break;
//            case 1:
//                if (userCodeImgListBean1.getImgStatus() == 1) {
//                    //待审核  不能点击
//                    wechatLl2.setClickable(false);
//
//                    ImageViewUrlWechat2.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed2.setVisibility(View.VISIBLE);
//                    wechatLl2.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 2) {
//                    //审核通过
//                    ImageViewUrlWechat2.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed2.setVisibility(View.GONE);
//                    wechatLl2.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 3) {
//                    //待审核不通过
//                    ImageViewUrlWechat2.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed2.setVisibility(View.VISIBLE);
//                    wechatLl2.setVisibility(View.INVISIBLE);
//                }
//                break;
//            case 2:
//                if (userCodeImgListBean1.getImgStatus() == 1) {
//                    //待审核  不能点击
//                    wechatLl3.setClickable(false);
//                    ImageViewUrlWechat3.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed3.setVisibility(View.VISIBLE);
//                    wechatLl3.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 2) {
//                    //审核通过
//                    ImageViewUrlWechat3.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed3.setVisibility(View.GONE);
//                    wechatLl3.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 3) {
//                    //待审核不通过
//                    ImageViewUrlWechat3.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed3.setVisibility(View.VISIBLE);
//                    wechatLl3.setVisibility(View.INVISIBLE);
//                }
//                break;
//            case 3:
//                if (userCodeImgListBean1.getImgStatus() == 1) {
//                    //待审核  不能点击
//                    wechatLl4.setClickable(false);
//
//                    ImageViewUrlWechat4.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed4.setVisibility(View.VISIBLE);
//                    wechatLl4.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 2) {
//                    //审核通过
//                    ImageViewUrlWechat4.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed4.setVisibility(View.GONE);
//                    wechatLl4.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 3) {
//                    //待审核不通过
//                    ImageViewUrlWechat4.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed4.setVisibility(View.VISIBLE);
//                    wechatLl4.setVisibility(View.INVISIBLE);
//                }
//                break;
//            case 4:
//                if (userCodeImgListBean1.getImgStatus() == 1) {
//                    //待审核  不能点击
//                    wechatLl5.setClickable(false);
//                    ImageViewUrlWechat5.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed5.setVisibility(View.VISIBLE);
//                    wechatLl5.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 2) {
//                    //审核通过
//                    ImageViewUrlWechat5.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed5.setVisibility(View.GONE);
//                    wechatLl5.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 3) {
//                    //待审核不通过
//                    ImageViewUrlWechat5.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed5.setVisibility(View.VISIBLE);
//                    wechatLl5.setVisibility(View.INVISIBLE);
//                }
//                break;
//            case 5:
//                if (userCodeImgListBean1.getImgStatus() == 1) {
//                    //待审核  不能点击
//                    wechatLl6.setClickable(false);
//                    ImageViewUrlWechat6.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed6.setVisibility(View.VISIBLE);
//                    wechatLl6.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 2) {
//                    //审核通过
//                    ImageViewUrlWechat6.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed6.setVisibility(View.GONE);
//                    wechatLl6.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean1.getImgStatus() == 3) {
//                    //待审核不通过
//                    ImageViewUrlWechat6.setVisibility(View.VISIBLE);
//                    wechatHintUnreviewed6.setVisibility(View.VISIBLE);
//                    wechatLl6.setVisibility(View.INVISIBLE);
//                }
//                break;
//        }
//    }

    //打开相册
    private void getPhotoAlbum() {
//        this.money = data;
        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.putExtra("1", type);
        intent.setType("image/*");
        startActivityForResult(intent, ApiConfig.request_open_album_code);
    }
    private void uploadFile(File file) {
//        showLoadingDialog();
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
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String url = response.body().string();
//                Log.i("onResponse", "路经: " + url);
                Gson gson = new Gson();
                final TestUpLoadCodeIv2 testUpLoadCodeIv2 = gson.fromJson(url, TestUpLoadCodeIv2.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (testUpLoadCodeIv2.getCode() == 0) {
                            imgPath = testUpLoadCodeIv2.getMsg();
                            //上传收款码
                            Log.i("WX====", "run: " + money);

                            mPresenter.getData(ApiConfig.TEST_UPLOAD_GET_QR, imgId, Integer.parseInt(userId), 1, imgPath, money);
                        }
                    }
                });
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
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
            System.out.println("phone's path:" + uri.toString());

            String path = "";
            path = AlbumUtil.getFilePath(WechatPayReceiverCodeActivity.this, uri, data);
            if (path == null || "".equals(path))
                path = AlbumUtil.getImagePath(WechatPayReceiverCodeActivity.this, uri, data);
            File upladFile = new File(path);
//            Log.i("FILEURL", "onActivityResult: " + upladFile);
//            RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), upladFile);
//            MultipartBody.Part filePart = MultipartBody.Part.createFormData("srcFile", "yaya.png", body);
            uploadFile(upladFile);
//            mPresenter.getData(ApiConfig.TEST_UPLOAD_IMAGEVIE,filePart);//1微信 2二维码
            //上传收款码    参数:
            // imgId   添加时可无
            // userId 用户id
            // imgType 1、微信 2、支付宝
            // imgUrl 图片路径
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
    //    @Override
//    protected void onPause() {
//        super.onPause();
//        initData();
////        Log.i("tag", "onPause:1111 ");//退出页面刷新
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
////        Log.i("tag", "onPause:2222");//进入页面刷新
//        initData();
//    }
// R.id.wechat_ll1, R.id.wechat_ll3, R.id.wechat_ll4,
//            R.id.wechat_ll5, R.id.wechat_ll6,
//            R.id.ImageView_url_wechat, R.id.wechat_hint_unreviewed, R.id.wechat_no_shenhe,
//            R.id.ImageView_url_wechat2, R.id.wechat_hint_unreviewed2,
//            R.id.wechat_no_shenhe2, R.id.wechat_ll2, R.id.iv_money1, R.id.ImageView_url_wechat3,
//            R.id.wechat_hint_unreviewed3, R.id.wechat_no_shenhe3,
//            R.id.ImageView_url_wechat4, R.id.wechat_hint_unreviewed4, R.id.wechat_no_shenhe4,
//            R.id.iv_money2, R.id.iv_money3, R.id.ImageView_url_wechat5,
//            R.id.wechat_hint_unreviewed5, R.id.wechat_no_shenhe5,
//            R.id.ImageView_url_wechat6, R.id.wechat_hint_unreviewed6, R.id.wechat_no_shenhe6,
//            R.id.iv_money4, R.id.iv_money5})
//
    @OnClick({R.id.wechatpay_receive_back_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wechatpay_receive_back_iv:
                WechatPayReceiverCodeActivity.this.finish();
                break;
//            case R.id.wechat_ll1:
//                getPhotoAlbum(0.0);
//                break;
//            case R.id.wechat_ll2:
//                getPhotoAlbum(1000.0);
//                break;
//            case R.id.wechat_ll3:
//                getPhotoAlbum(2000.0);
//                break;
//            case R.id.wechat_ll4:
//                getPhotoAlbum(3000.0);
//                break;
//            case R.id.wechat_ll5:
//                getPhotoAlbum(4000.0);
//                break;
//            case R.id.wechat_ll6:
//                getPhotoAlbum(5000.0);
//                break;
//            case R.id.ImageView_url_wechat://图片显示上传的二维码
//                getPhotoAlbum(0.0);
//                break;
//            case R.id.wechat_hint_unreviewed://提示未上传
//                break;
//            case R.id.wechat_no_shenhe://审核不通过
//                getPhotoAlbum(0.0);
//                break;
//            case R.id.ImageView_url_wechat2:
//                getPhotoAlbum(1000.0);
//                break;
//            case R.id.wechat_hint_unreviewed2:
//                break;
//            case R.id.wechat_no_shenhe2:
//                getPhotoAlbum(1000.0);
//                break;
//
//            case R.id.iv_money1:
//                break;
//            case R.id.ImageView_url_wechat3:
//                getPhotoAlbum(2000.0);
//                break;
//            case R.id.wechat_hint_unreviewed3:
//
//                break;
//            case R.id.wechat_no_shenhe3:
//                getPhotoAlbum(2000.0);
//                break;
//
//            case R.id.ImageView_url_wechat4:
//                getPhotoAlbum(3000.0);
//                break;
//            case R.id.wechat_hint_unreviewed4:
//                break;
//            case R.id.wechat_no_shenhe4:
//                getPhotoAlbum(3000.0);
//                break;
//            case R.id.iv_money2:
//                break;
//            case R.id.iv_money3:
//                break;
//            case R.id.ImageView_url_wechat5:
//                getPhotoAlbum(4000.0);
//                break;
//            case R.id.wechat_hint_unreviewed5:
//                break;
//            case R.id.wechat_no_shenhe5:
//                break;
//
//            case R.id.ImageView_url_wechat6:
//                getPhotoAlbum(5000.0);
//                break;
//            case R.id.wechat_hint_unreviewed6:
//                break;
//            case R.id.wechat_no_shenhe6:
//                getPhotoAlbum(5000.0);
//                break;
//            case R.id.iv_money4:
//                break;
//            case R.id.iv_money5:
//                break;
        }
    }
}