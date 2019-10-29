package com.administrator.yaya.wxapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.utils.OkHttpUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.administrator.yaya.utils.WeChatInfo;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    private IWXAPI wxapi;
    private SendAuth.Resp resp;
    private int WX_LOGIN =1;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        wxapi.handleIntent(intent, this);
    }

    @Override
    protected int getLayoutId() {
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_wxentry;
    }

    @Override
    protected void initView() {
        super.initView();
        //TODO：你的AppID
        wxapi = WXAPIFactory.createWXAPI(this,BaseApp.AppId);
        wxapi.handleIntent(getIntent(), this);
    }
    /**
     * 微信发送请求到第三方应用时，会回调到该方法
     */
    @Override
    public void onReq(BaseReq baseReq) {
        // 这里不作深究
    }
    /**
     * 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
     * app发送消息给微信，处理返回消息的回调
     */
    @Override
    public void onResp(BaseResp baseResp) {
        //微信登录为getType为1，分享为0
        if (baseResp.getType() == WX_LOGIN) {
            //登录回调
//            System.out.println("------------登陆回调------------");
            resp = (SendAuth.Resp) baseResp;
//            System.out.println("------------登陆回调的结果------------：" +  new Gson().toJson(resp));
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    String code = String.valueOf(resp.code);
                    //获取用户信息
                    getAccessToken(code);
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                    ToastUtil.showShort("用户拒绝授权");
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                    ToastUtil.showShort("用户取消登录");
                    break;
                default:
                    break;
            }
        } else {
            //分享成功回调
            switch (baseResp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    //分享成功
                    Toast.makeText(WXEntryActivity.this, "分享成功", Toast.LENGTH_LONG).show();
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    //分享取消
                    Toast.makeText(WXEntryActivity.this, "分享取消", Toast.LENGTH_LONG).show();
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    //分享拒绝
                    Toast.makeText(WXEntryActivity.this, "分享拒绝", Toast.LENGTH_LONG).show();
                    break;
            }
        }
        finish();
    }

    private void getAccessToken(String code) {
        //获取授权
        String http = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + BaseApp.AppId + "&secret=" + BaseApp.APP_SERECET + "&code=" + code + "&grant_type=authorization_code";
        OkHttpUtils.ResultCallback<String> resultCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                String access = null;
                String openId = null;
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    access = jsonObject.getString("access_token");
                    openId = jsonObject.getString("openid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //获取个人信息
                String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access + "&openid=" + openId + "";
                OkHttpUtils.ResultCallback<WeChatInfo> resultCallback = new OkHttpUtils.ResultCallback<WeChatInfo>() {
                    @Override
                    public void onSuccess(WeChatInfo response) {
                        response.setErrCode(resp.errCode);
                        Log.i("TAG获取个人信息",new Gson().toJson(response));
//                        Toast.makeText(WXEntryActivity.this, new Gson().toJson(response), Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(WXEntryActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                };
                OkHttpUtils.get(getUserInfo, resultCallback);
            }
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(WXEntryActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        };
        OkHttpUtils.get(http, resultCallback);
    }
}
