package com.administrator.yaya.activity.my;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
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
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的邀請
 */
public class MyInviteActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.small_book_back_iv)
    ImageView smallBookBackIv;
    @BindView(R.id.myinvite_friend)
    TextView myinviteFriend;
    @BindView(R.id.my_name_tv)
    TextView myNameTv;
    @BindView(R.id.my_name_state_tv)
    TextView myNameStateTv;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.wire)
    View wire;
    @BindView(R.id.get_gamemoney_tv)
    TextView getGamemoneyTv;
    @BindView(R.id.all_gamemoney_tv)
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
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_invite;
    }
    @OnClick({R.id.small_book_back_iv, R.id.myinvite_friend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.small_book_back_iv:
                finish();
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

        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);

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
                popupWindow.dismiss();
                break;
        }

    }
}
