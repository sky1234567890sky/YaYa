package com.administrator.yaya.base;

import com.administrator.yaya.bean.VerifyCodeInfo;
import com.administrator.yaya.bean.homepage.TestBuyCom;
import com.administrator.yaya.bean.homepage.TestHomePageData;
import com.administrator.yaya.bean.login_register_bean.TestInviteCode;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.bean.login_register_bean.TestRegister;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestGathering;
import com.administrator.yaya.bean.orderform.TestToOrderStock;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface INetService {

    //获取验证码
    @POST("/v2/sms/send")
    @FormUrlEncoded
    Observable<VerifyCodeInfo> getVerify(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> maps);

    @POST("/v2/sms/send")
    @Headers("Content-Type:application/json")
    Observable<VerifyCodeInfo> getVerify2(@Body RequestBody pBody);

    //====================================?

//    登录
    @POST("appLogin")
    @FormUrlEncoded
    //@Headers({"Content-Type:application/x-www-form-urlencoded","Authorization:Basic ZG1kOjEyMzQ1Ng=="})
    Observable<TestLogin> getTestLogin(@Field("userPhone") String userPhone, @Field("userPwd") String userPwd);

    //    注册
    @POST("appRegister")
    @FormUrlEncoded
    Observable<TestRegister> getTestRegister(@Field("userPhone") String userPhone, @Field("userPwd") String userPwd, @Field("userInvitationCode") String userInvitationCode, @Field("codename") String codename);

    //验证码
    @POST("appInvite")
    @FormUrlEncoded
    Observable<TestInviteCode> getTestInviteCode(String s, String s1, String s2);

    //首页
    @POST("index")
    @FormUrlEncoded
    Observable<TestHomePageData> getTestHomePageData(@Field("userId") int userId);

    //立即购买
    //http://192.168.0.198:8080/yayaApp/comBuy/toBuyCom
    @POST("comBuy/toBuyCom")
    Observable<TestBuyCom> getTestBuyCom();

    //提交订单
//    http://192.168.0.198:8080/yayaApp/comBuy/toOrderStock
    @POST("comBuy/toOrderStock")
    @FormUrlEncoded
    Observable<TestToOrderStock> getTestOrderStock(@Field("userId") int userId, @Field("commodityPrice") String commodityPrice, @Field("payerName") String payerName, @Field("commodityAmount") String commodityAmount);

    //    查看进货状态-所有进货订单
//    http://192.168.0.198:8080/yayaApp/comBuy/allOrderStock
    @POST("comBuy/allOrderStock")
    @FormUrlEncoded
    Observable<TestAllOrderStock> getTestAllOrderStock(@Field("userId") int userId, @Field("orderStatus") int orderStatus);
    //    付款信息
//    http://192.168.0.198:8080/yayaApp/comBuy/getGathering
    @POST("comBuy/getGathering")
    @FormUrlEncoded
    Observable<TestGathering> getTestGathering(@Field("orderNumber") String orderNumber);//订单编




}