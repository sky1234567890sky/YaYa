package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.adapter.MyLowerAdapter;
import com.administrator.yaya.activity.my.adapter.MySuperiorAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.my.TestMyInvite;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ChangTvSizeUtils;
import com.administrator.yaya.utils.MyQrCode;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.SaveBitmapToPhotoUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.administrator.yaya.utils.WxShareUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的邀請
 */
public class MyInviteActivity extends BaseMvpActivity<LoginModel> implements View.OnClickListener {

    @BindView(R.id.myinvite_book_back_iv)
    ImageView smallBookBackIv;
    @BindView(R.id.myinvite_friend)
    TextView myinviteFriend;
    @BindView(R.id.my_name_tv)
    TextView myNameTv;
    @BindView(R.id.my_name_state_tv)
    TextView myNameStateTv;
    @BindView(R.id.tv3)
    TextView tv3;

    @BindView(R.id.today_get_gamemoney_tv)
    TextView getGamemoneyTv;
    @BindView(R.id.today_all_gamemoney_tv)
    TextView allGamemoneyTv;
    @BindView(R.id.my_superior_rl)
    RecyclerView mySuperiorRl;
    @BindView(R.id.my_lower_rl)
    RecyclerView myLowerRl;

    private PopupWindow popupWindow;
    private long exittime;
    private ImageView mMyinviteTwoDimentionCodeIv;
    private TextView mMyinviteTwoDimentionCodTv;
    private TextView mMyinviteShareWechatBtnTv;
    private ImageView mMyinviteCloneDissPopupIv;
    //TODO:注册你的wechatAppId
    //需要像微信注册我们申请的应用，在前面我们申请的应用审核完后的APP_ID 和APP_SECRET 就填写在这里：
//    private static final String APP_ID = "";
//    private static final String APP_SECRET = "123456";
    private IWXAPI api;
    private MySuperiorAdapter mySuperiorAdapter;
    private MyLowerAdapter myLowerAdapter;
    private List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> juniorUsers;
    private ArrayList<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> myLowerList;

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
    protected void initView() {
//        register(this);
        SpannableString getInventory = ChangTvSizeUtils.changTVsize("25.00");
//        getGamemoneyTv.setText(getInventory);
//        allGamemoneyTv.setText(getInventory);

        mySuperiorRl.setLayoutManager(new LinearLayoutManager(this));
        myLowerRl.setLayoutManager(new LinearLayoutManager(this));

        mySuperiorAdapter = new MySuperiorAdapter();//上级无数据
        myLowerList = new ArrayList<>();
        myLowerAdapter = new MyLowerAdapter(myLowerList);//下級
        mySuperiorRl.setAdapter(mySuperiorAdapter);
        myLowerRl.setAdapter(myLowerAdapter);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_MY_INVITE:
                TestMyInvite testMyInvite = (TestMyInvite) t[0];

            if (testMyInvite.getCode() == 0 && testMyInvite.getData()!=null){
//                Log.i("tag", "数据: "+testMyInvite.getData().toString());
                TestMyInvite.DataBean data = testMyInvite.getData();
                TestMyInvite.DataBean.UserInfoBean userInfo = data.getUserInfo();///用户基本信息

                int allUserContributeTotal = data.getAllUserContributeTotal();//縂返利
//                parentUser			上级用户对象信息
                Object parentUser = userInfo.getParentUser();
//                userId			用户id
//                userName		用户姓名
//                juniorUsers			下级用户集合
                juniorUsers = userInfo.getJuniorUsers();
                myLowerList.addAll(juniorUsers);
                myLowerAdapter.notifyDataSetChanged();
//                userId			用户id
//                userName		用户姓名
//                junior			今日贡献
//                userContributeTotal	总贡献
//                userId				用户id
                int userId = userInfo.getUserId();
//                userName 			用户姓名
                String userName = userInfo.getUserName();
//                userNickName 		昵称
                String userNickName = userInfo.getUserNickName();
//                userEarningsTotal 	总收益
                int userContributeTotal = userInfo.getUserContributeTotal();
//                zfbEd 				支付宝已使用额度
                int zfbEd = userInfo.getZfbEd();
//                wxEd 				微信已使用额度
                int wxEd = userInfo.getWxEd();

                myNameTv.setText(userName);
                myNameStateTv.setText("ID:"+userId);
                tv3.setText("返利比例："+allUserContributeTotal+"%");
//                getGamemoneyTv.setText();
                allGamemoneyTv.setText(userContributeTotal+"");
            }
                break;
        }
    }
    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        if (userId!=null)mPresenter.getData(ApiConfig.TEST_MY_INVITE,Integer.parseInt(userId));
    }
    @Override
    protected void initListener() {
    }
    @OnClick({R.id.myinvite_book_back_iv, R.id.myinvite_friend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myinvite_book_back_iv:
                MyInviteActivity.this.finish();
                break;
            case R.id.myinvite_friend://邀请好友
                popupSelector();
                break;
        }
    }
    private void popupSelector() {
        //分享二维码
        View inflate = LayoutInflater.from(this).inflate(R.layout.myinvite_popup, null);
        mMyinviteTwoDimentionCodeIv = inflate.findViewById(R.id.myinvite_two_dimention_code_iv);//二维码图片
        mMyinviteTwoDimentionCodTv = inflate.findViewById(R.id.myinvite_two_dimention_cod_tv);//邀请码
        mMyinviteShareWechatBtnTv = inflate.findViewById(R.id.myinvite_share_wechat_btn_tv);//微信分享按钮
        mMyinviteCloneDissPopupIv = inflate.findViewById(R.id.myinvite_clone_diss_popup_iv);//关闭弹窗

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
          Bitmap bitmap = MyQrCode.QRCode.createQRCodeWithLogo("苏克阳", 500, BitmapFactory.decodeResource(getResources(),R.mipmap.icon));
        mMyinviteTwoDimentionCodeIv.setImageBitmap(bitmap);

        //隐藏弹窗点击事件
        mMyinviteShareWechatBtnTv.setOnClickListener(this);
        mMyinviteCloneDissPopupIv.setOnClickListener(this);
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
                SaveBitmapToPhotoUtils.saveImageToGallery(this,headlerIvbitmap,getString(R.string.app_name) + "" + System.currentTimeMillis()+".png");
                break;
        }
    }
    private void initShareIv() {
        //登录
//        WxShareUtils.WxLogin(this);
        //分享textview
        WxShareUtils.WxTextShare(this,"微信分享",WxShareUtils.WECHAT_FRIEND);//分享好友
        //分享图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon);
        WxShareUtils.WxBitmapShare(this,bitmap,WxShareUtils.WECHAT_FRIEND);
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


}
