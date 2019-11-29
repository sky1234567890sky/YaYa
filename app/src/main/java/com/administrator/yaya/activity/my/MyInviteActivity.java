package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.my.adapter.MyInviteAdapter;
import com.administrator.yaya.activity.my.adapter.MyLowerAdapter;
import com.administrator.yaya.activity.my.adapter.MySuperiorAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.my.TestMyInviteAll;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ChangTvSizeUtils;
import com.administrator.yaya.utils.MyQrCode;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.SaveBitmapToPhotoUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.administrator.yaya.utils.WxShareUtils;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.mm.opensdk.openapi.IWXAPI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
/**
 * 我的邀請
 */
public class MyInviteActivity extends BaseMvpActivity<LoginModel> implements View.OnClickListener {
    private PopupWindow popupWindow;
    private long exittime;
    private ImageView mMyinviteTwoDimentionCodeIv;
    private TextView mMyinviteTwoDimentionCodTv;
    private TextView mMyinviteShareWechatBtnTv;
    private ImageView mMyinviteCloneDissPopupIv;
    @BindView(R.id.myinvite_mlist)
    RecyclerView mList;
    @BindView(R.id.myinvite_refreshLayout)
    SmartRefreshLayout mRefresh;

    //需要像微信注册我们申请的应用，在前面我们申请的应用审核完后的APP_ID 和APP_SECRET 就填写在这里：
//    private static final String APP_ID = "";
//    private static final String APP_SECRET = "123456";
    private IWXAPI api;

    private MySuperiorAdapter mySuperiorAdapter;
    private MyLowerAdapter myLowerAdapter;

    //我的邀请
    private List<TestMyInviteAll.DataBean.ListBean> list = new ArrayList<>();
    private String userInvitationCode;
    private String userId;
    private String token;
    private TextView fuzhi_yanzhengma;
    private ImageView mMyinviteBack;
    private TextView mMyinviteFriend;
    private ImageView mMyinviteRightDengjiIv;
    private RoundedImageView mMyinviteNameIv;
    private TextView mMyinviteNameTv;
    private TextView mMyinviteIdTv;
    private TextView mFanlibiliTv;
    private TextView mFenpeiBaifen;
    private TextView mYaoqingItemBtn1;
    private LinearLayout mMyinviteLl;
    private TextView mInviteFriendTitle;
    private TextView mTodayAllGamemoneyTv;
    private RecyclerView mMyinviteList;

    private MyInviteAdapter adapter;
    private TextView myinvite_name;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_my_invite;
    }

    //    //向微信注册app
//    public void register(Context context) {
//        if(api==null){
//            api = WXAPIFactory.createWXAPI(context, APP_ID, true);
//            api.registerApp(APP_ID);
//        }
//    }
    @Override
    public void refresh() {
        super.refresh();
        mRefresh.setEnableScrollContentWhenLoaded(true);
        mList.scrollToPosition(0);
//        mRefresh.autoRefresh();
        initData();
    }

    @Override
    public void loadMore() {
        super.loadMore();

        mRefresh.finishLoadMoreWithNoMoreData();

        mRefresh.setEnableScrollContentWhenLoaded(true);
    }

    @Override
    protected void initView() {
        mMyinviteBack = findViewById(R.id.myinvite_back);
        mMyinviteFriend = findViewById(R.id.myinvite_fanli);
        mMyinviteRightDengjiIv = findViewById(R.id.myinvite_right_dengji_iv);
        mMyinviteNameIv = findViewById(R.id.myinvite_name_iv1);
        mMyinviteIdTv = findViewById(R.id.myinvite_id_tv1);
        mFanlibiliTv = findViewById(R.id.fanlibili_tv1);
        mInviteFriendTitle = findViewById(R.id.invite_friend_title);
        mTodayAllGamemoneyTv = findViewById(R.id.today_all_gamemoney_tv);
        myinvite_name = findViewById(R.id.myinvite_name);

//        mMyinviteList = findViewById(R.id.myinvite_list);
        SpannableString getInventory = ChangTvSizeUtils.changTVsize("25.00");
//        ------------------>

        mList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyInviteAdapter(list);
        mList.setAdapter(adapter);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //我的邀请
            case ApiConfig.TEST_MY_INVITEALL:
                list.clear();
                TestMyInviteAll testMyInviteAll = (TestMyInviteAll) t[0];
                if (testMyInviteAll.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong("您的账号正在其他设备登录！");
                    Intent intent = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid = 0;
                    mApplication.mToken = "";
                    startActivity(intent);
                    finish();
                }

                if (testMyInviteAll.getCode() == 0 && !testMyInviteAll.getMsg().equals(mApplication.SignOut)) {
                    TestMyInviteAll.DataBean data = testMyInviteAll.getData();
//                    profit    返利比例
                    double profit = data.getProfit();
                    mFanlibiliTv.setText("返利比例:" + profit);
//                    userInfo:    用户基本信息
                    TestMyInviteAll.DataBean.UserInfoBean userInfo = data.getUserInfo();
//                    userId   用户id
                    int userId = userInfo.getUserId();
                    mMyinviteIdTv.setText("ID:" + userId);
//                    userLevelName 级别名称

                    String[] jibie = {"黄金", "铂金", "钻石", "王者", "星耀"};
                    int[] iv = {R.mipmap.icon_huangjin, R.mipmap.icon_bojin, R.mipmap.icon_zuanshi, R.mipmap.icon_wangzhe, R.mipmap.icon_xingyao};
                    String userLevelName = userInfo.getUserLevelName();

                    if (jibie[0].equals(userLevelName)) {
                        Glide.with(this).load(iv[0]).placeholder(R.mipmap.icon).into(mMyinviteRightDengjiIv);
                    } else if (jibie[1].equals(userLevelName)) {
                        Glide.with(this).load(iv[1]).placeholder(R.mipmap.icon).into(mMyinviteRightDengjiIv);
                    } else if (jibie[2].equals(userLevelName)) {
                        Glide.with(this).load(iv[2]).placeholder(R.mipmap.icon).into(mMyinviteRightDengjiIv);
                    } else if (jibie[3].equals(userLevelName)) {
                        Glide.with(this).load(iv[3]).placeholder(R.mipmap.icon).into(mMyinviteRightDengjiIv);
                    } else if (jibie[4].equals(userLevelName)) {
                        Glide.with(this).load(iv[4]).placeholder(R.mipmap.icon).into(mMyinviteRightDengjiIv);
                    }

                    String userName = userInfo.getUserName();
                    myinvite_name.setText(userName);

//                    Glide.with(this).load(userLevelName).into(mMyinviteRightDengjiIv);

//                    userHeadImg  头像
                    String userHeadImg = userInfo.getUserHeadImg();
                    Glide.with(this).load(userHeadImg).into(mMyinviteNameIv);
//                    list    邀请码集合
                    List<TestMyInviteAll.DataBean.ListBean> listBeans = data.getList();
//                    lvName   级别名称
//                    codeName  邀请码
//                    lvProfit  返利比例（分配）
                    list.addAll(listBeans);
                    adapter.setData(profit);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        mRefresh.finishRefresh();
        mRefresh.finishLoadMore();
    }

    @Override
    protected void initData() {
        super.initData();
        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
        if (userId != null)
            mPresenter.getData(ApiConfig.TEST_MY_INVITEALL, Integer.parseInt(userId), token);
    }
    @Override
    protected void initListener() {
        super.initListener();
        adapter.setMyInviteOnClickListener(new MyInviteAdapter.MyInviteOnClickListener() {
            @Override
            public void nviteOnClickListeneri(int i) {
                String codeName = list.get(i).getCodeName();
                popupSelector(codeName);
            }
        });

        mMyinviteBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyInviteActivity.this.finish();
            }
        });

        mMyinviteFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInviteActivity.this, RebateRecordActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void popupSelector(final String codeName) {
        //分享二维码
        View inflate = LayoutInflater.from(this).inflate(R.layout.myinvite_popup, null);
        mMyinviteTwoDimentionCodeIv = inflate.findViewById(R.id.myinvite_two_dimention_code_iv);//二维码图片
        mMyinviteTwoDimentionCodTv = inflate.findViewById(R.id.myinvite_two_dimention_cod_tv);//邀请码
        mMyinviteShareWechatBtnTv = inflate.findViewById(R.id.myinvite_share_wechat_btn_tv);//微信分享按钮
        mMyinviteCloneDissPopupIv = inflate.findViewById(R.id.myinvite_clone_diss_popup_iv);//关闭弹窗
        //复制验证码
        fuzhi_yanzhengma = inflate.findViewById(R.id.fuzhi_yanzhengma);
        mMyinviteTwoDimentionCodTv.setText("邀请码:" + codeName);

        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.5f;
        this.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = MyInviteActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                MyInviteActivity.this.getWindow().setAttributes(lp);
            }
        });

        //二維碼
        //Bitmap bitmap = MyQrCode.QRCode.createQRCode("我是苏克阳", 500);//不需要logo，传入分享链接和二维码图片大小
        //需要logo，传入分享链接,二维码大小以及logo图片

        Bitmap bitmap = MyQrCode.QRCode.createQRCodeWithLogo(codeName, 1000, BitmapFactory.decodeResource(getResources(), R.mipmap.icon));
        mMyinviteTwoDimentionCodeIv.setImageBitmap(bitmap);


        //隐藏弹窗点击事件
        mMyinviteShareWechatBtnTv.setOnClickListener(this);
        mMyinviteCloneDissPopupIv.setOnClickListener(this);

        fuzhi_yanzhengma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(codeName)) {
                    //复制至粘贴栏
                    ClipboardManager name = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    // 将文本内容放到系统剪贴板里。
                    name.setText(codeName);

                    ToastUtil.showShort("已复制至粘贴栏");
                }

            }
        });//复制验证码
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myinvite_clone_diss_popup_iv:
                popupWindow.dismiss();
                break;
            case R.id.myinvite_share_wechat_btn_tv: //拉起微信去分享
                //跳转微信
//                initShareIv();
//                popupWindow.dismiss();
                //修改了  将图片保存到本地
                Bitmap headlerIvbitmap = ((BitmapDrawable) mMyinviteTwoDimentionCodeIv.getDrawable()).getBitmap();
                SaveBitmapToPhotoUtils.saveImageToGallery(this, headlerIvbitmap, getString(R.string.app_name) + "" + System.currentTimeMillis() + ".png");
                ToastUtil.showLong("图片保存成功");
                break;
        }
    }

    private void initShareIv() {
        //登录
//        WxShareUtils.WxLogin(this);
        //分享textview
        WxShareUtils.WxTextShare(this, "微信分享", WxShareUtils.WECHAT_FRIEND);//分享好友
        //分享图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon);
        WxShareUtils.WxBitmapShare(this, bitmap, WxShareUtils.WECHAT_FRIEND);
        //方法一：
//        WXWebpageObject webpage = new WXWebpageObject();
//        webpage.webpageUrl = "网页链接";
//        final WXMediaMessage msg = new WXMediaMessage(webpage);
//        msg.title = "网页标题";
//        msg.description = "网页内容";
//        Bitmap thumb = BitmapFactory.decodeResource(BaseApp.getApplication().getResources(), R.mipmap.icon);
////        这个bitmap不能超过32kb
//        if(thumb != null) {
//            Bitmap mBp = Bitmap.createScaledBitmap(thumb, 120, 120, true);
//            thumb.recycle();
//            msg.thumbData = bmpToByteArray(thumb,true);
//        }
//        SendMessageToWX.Req req = new SendMessageToWX.Req();    //创建一个请求对象
//        req.message = msg;
//        //req.scene = SendMessageToWX.Req.WXSceneTimeline;    //设置发送到朋友圈
//        req.scene = SendMessageToWX.Req.WXSceneSession;   //设置发送给朋友
//        req.transaction = "设置一个tag";  //用于在回调中区分是哪个分享请求
//        boolean successed = api.sendReq(req);   //如果调用成功微信,会返回true
        //方法二
    }

    //    private byte[] bmpToByteArray(Bitmap thumb, boolean b) {
//        return new byte[0];
//    }
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
    protected void onResume() {
        super.onResume();
        refresh();
    }
}
