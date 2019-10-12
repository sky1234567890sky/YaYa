package com.administrator.yaya.base;

import com.administrator.yaya.bean.VerifyCodeInfo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
public interface INetService {
    //获取验证码
    @POST("/v2/sms/send")
    @FormUrlEncoded
    Observable<VerifyCodeInfo>getVerify(@FieldMap Map<String,String> params, @HeaderMap Map<String,String> maps);

    @POST("/v2/sms/send")
    @Headers("Content-Type:application/json")
    Observable<VerifyCodeInfo> getVerify2(@Body RequestBody pBody);

    @POST("send-sms")
    @FormUrlEncoded
    Observable<VerifyCodeInfo> getSMS(@Field("mobile")String phonNum);
}
