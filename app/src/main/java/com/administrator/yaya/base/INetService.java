package com.administrator.yaya.base;

import com.administrator.yaya.TestDianjiYingye;
import com.administrator.yaya.bean.TestCancelOrderStock;
import com.administrator.yaya.bean.TestUpLoadCodeIv2;
import com.administrator.yaya.bean.TestUpLoadGetQr;
import com.administrator.yaya.bean.TestUpLoadGetQr2;
import com.administrator.yaya.bean.VerifyCodeInfo;
import com.administrator.yaya.bean.homepage.TestBuyCom;
import com.administrator.yaya.bean.homepage.TestHomePageData;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.bean.invite.TestInventory;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.bean.invite.TestPayToAffirmInfo;
import com.administrator.yaya.bean.invite.TestUpawayAllSingleGoods;
import com.administrator.yaya.bean.invite.TestUpawaySingleGoods;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.bean.login_register_bean.TestRegister;
import com.administrator.yaya.bean.my.SwitchReceiveingQrCode;
import com.administrator.yaya.bean.my.TestAlipayReceiverCode;
import com.administrator.yaya.bean.my.TestExpend;
import com.administrator.yaya.bean.my.TestGetEtVerificationCode;
import com.administrator.yaya.bean.my.TestGetUsergCodeImg;
import com.administrator.yaya.bean.my.TestIncome;
import com.administrator.yaya.bean.my.TestLoadHeadlerIv;
import com.administrator.yaya.bean.my.TestMyEarnings;
import com.administrator.yaya.bean.my.TestMyInvite;
import com.administrator.yaya.bean.my.TestMyInviteAll;
import com.administrator.yaya.bean.my.TestNotificationInfo;
import com.administrator.yaya.bean.my.TestPutawayAllOrderStock;
import com.administrator.yaya.bean.my.TestRebate;
import com.administrator.yaya.bean.my.TestSmallBook;
import com.administrator.yaya.bean.my.TestUpdateUserNew;
import com.administrator.yaya.bean.my.TestUploadHeadler;
import com.administrator.yaya.bean.my.TestUserNowMsg;
import com.administrator.yaya.bean.my.TestWechatReceiverCode;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestCancel;
import com.administrator.yaya.bean.orderform.TestConfirmReceipt;
import com.administrator.yaya.bean.orderform.TestFinish;
import com.administrator.yaya.bean.orderform.TestNoReceipt;
import com.administrator.yaya.bean.orderform.TestToOrderStock;
import com.administrator.yaya.bean.orderform.TestUpdatePwd;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
//    参数增加：
//
//    userPhone
//    userPwd
//    手机型号  appModel
//    设备号   appDeviceNumber
//    Android Mac地址 appMac
    @POST("appLogin")
    @FormUrlEncoded
    //@Headers({"Content-Type:application/x-www-form-urlencoded","Authorization:Basic ZG1kOjEyMzQ1Ng=="})
    Observable<TestLogin> getTestLogin(@Field("userPhone") String userPhone, @Field("userPwd") String userPwd,
                                       @Field("appModel") String appModel, @Field("appDeviceNumber") String appDeviceNumber, @Field("appMac") String appMac);

    //    注册
    @POST("appRegister")
    @FormUrlEncoded
    //userInvitationCodeName
    Observable<TestRegister> getTestRegister(@Field("userPhone") String userPhone, @Field("userPwd") String userPwd, @Field("userInvitationCodeName") String userInvitationCodeName, @Field("codeName") String codeName);

    //手机验证码(注册 和 修改)
    @POST("getPhoneCode")
    @FormUrlEncoded
    Observable<TestRegister> getTestInviteCode(@Field("phone") String phone);

    //首页
    @POST("index")
    @FormUrlEncoded
    Observable<TestHomePageData> getTestHomePageData(@Field("userId") int userId, @Field("token") String token);

    //    购买游戏币-立即购买（新）
///yayaApp/comBuy/toBuyCom
//    参数:
//    用户id		userId

    @POST("comBuy/toBuyCom")
    @FormUrlEncoded
    Observable<TestBuyCom> getTestBuyCom(@Field("userId") int userId, @Field("token") String token);

    //提交订单接口
    //参数新增
    //commodityPriceDeduction    抵扣金额
//    http://192.168.0.198:8080/yayaApp/comBuy/toOrderStock
    @POST("comBuy/toOrderStock")
    @FormUrlEncoded
    Observable<TestToOrderStock> getTestOrderStock(@Field("userId") int userId, @Field("token") String token, @Field("commodityPrice") String commodityPrice, @Field("payerName") String payerName, @Field("commodityAmount") String commodityAmount, @Field("commodityPriceDeduction") double commodityPriceDeduction, @Field("flagType") int flagType);

    //    查看进货状态-所有进货订单
//    http://192.168.0.198:8080/yayaApp/comBuy/allOrderStock
//    @POST("comBuy/allOrderStock") //
//    @FormUrlEncoded
//    Observable<TestAllOrderStock> getTestAllOrderStock(@Field("userId") int userId, @Field("orderStatus") int orderStatus);

    //(不用)
    @POST("comBuy/allOrderStock") //待付款
    @FormUrlEncoded
    Observable<TestObligation> getTestObateligation(@Field("userId") int userId, @Field("orderStatus") int orderStatus);//1

    //(不用)
    @POST("comBuy/allOrderStock")
    @FormUrlEncoded
    //已付款
    Observable<TestAccountPaid> getTestAccountPaid(@Field("userId") int userId, @Field("orderStatus") int orderStatus);//2

    //库存(新)
    @POST("comBuy/allOrderStock")
    @FormUrlEncoded
    //已付款
    Observable<TestInventory> getTestInventory(@Field("userId") int userId, @Field("token") String token);//1


    //付款信息 http://192.168.0.198:8080/yayaApp/comBuy/getGathering
    @POST("comBuy/getGathering")
    @FormUrlEncoded
    Observable<TestPayToAffirmInfo> getTestPayToAffimInfo(@Field("orderNumber") String orderNumber, @Field("token") String token);

    //取消售货订单
    //http://192.168.0.198:8080/yayaApp/comBuy/cancelOrderStock
    @POST("comBuy/cancelOrderStock")
    @FormUrlEncoded
    Observable<TestCancelOrderStock> getTestCancelOrderStock(@Field("stockId") int stockId);

    //    通知信息
//    http://192.168.0.198:8080/yayaApp/getInfo
    @POST("getInfo")
    @FormUrlEncoded
    Observable<TestNotificationInfo> getTestNotificationInfo(@Field("userId") int userId, @Field("token") String token);


    //    我的邀请
    @POST("myInviteAll")
    @FormUrlEncoded
    Observable<TestMyInviteAll> getTestMyInviteAll(@Field("userId") int userId, @Field("token") String token);


    //我的邀请-查看返利记录
//    http://192.168.0.198:8080/yayaApp/getMyInvite
    @POST("getMyInvite")
    @FormUrlEncoded
    Observable<TestMyInvite> getTestMyInvite(@Field("userId") int userId, @Field("token") String token);

    //    小账本
//    http://192.168.0.198:8080/yayaApp/xiaoZhangBen
    @POST("xiaoZhangBen")
    @FormUrlEncoded
    Observable<TestSmallBook> getTestSmallBook(@Field("userId") int userId, @Field("token") String token);

    //上架单个货物http://192.168.0.198:8080/yayaApp/comBuy/putawayOneOrderStock
    @POST("comBuy/putawayOneOrderStock")
    @FormUrlEncoded
    Observable<TestUpawaySingleGoods> getTestUpawaySingleGoods(@Field("orderNumber") String orderNumber, @Field("token") String token);

    //    上架全部货物
//    http://192.168.0.198:8080/yayaApp/comBuy/putawayAllOrderStock
//    参数:
//    用户Id	userId
    @POST("comBuy/putawayAllOrderStock")
    @FormUrlEncoded
    Observable<TestUpawayAllSingleGoods> getTestUpawayAllSingleGoods(@Field("userId") int userId, @Field("token") String token);

    //    所有售货订单
///yayaApp/comSell/allOrderSales
//    参数：
//    用户id userId
//    状态 salesStatus  全部数据不传  待确认1 已完成2  已取消3   未收款4
    //全部
    @POST("comSell/allOrderSales")
    @FormUrlEncoded
    Observable<TestAllOrderStock> getTestAllOrderStock(@Field("userId") int userId, @Field("token") String token);

    //其他
    @POST("comSell/allOrderSales")
    @FormUrlEncoded
    Observable<TestFinish> getTestFinish(@Field("userId") int userId, @Field("token") String token, @Field("salesStatus") int salesStatus);

    //未收货
    @POST("comSell/otherOrderSales")
    @FormUrlEncoded
    Observable<TestCancel> getTestCancel(@Field("userId") int userId, @Field("token") String token);//未收货


    //    确认收货（确认收款）
//    http://192.168.0.198:8080/yayaApp/comSell/confirmReceipt
//    参数:
//    订单id		salesId
    @POST("comSell/confirmReceipt")
    @FormUrlEncoded
    Observable<TestConfirmReceipt> getTestConfirmReceipt(@Field("salesId") int salesId, @Field("userId") int userId, @Field("token") String token);//传入售卖中的selaiD

    //未收款 未收货 comSell/noReceipt
    @POST("comSell/noReceipt")
    @FormUrlEncoded
    Observable<TestNoReceipt> getTestNoReceipt(@Field("salesId") int salesId, @Field("userId") int userId, @Field("token") String token);


    //    取消售卖订单
//    http://192.168.0.198:8080/yayaApp/comSell/cancelOrderSales
//    参数:
//    订单编号	saleId
    @POST("comSell/cancelOrderSales")
    @FormUrlEncoded
    Observable<TestCancelOrderStock> getTestCancelOrderSales(@Field("salesId") int salesId, @Field("token") String token);//传入取消售卖中的selaiD

    //我的收益
//    http://192.168.0.198:8080/yayaApp/myInfo
//    参数:
//    用户id		userId
//    收益类型	earningsType	收益类型--1收入-2支出-3返利
    @POST("myInfo")
    @FormUrlEncoded
    Observable<TestMyEarnings> getTestMyEarnings(@Field("userId") int userId, @Field("token") String token, @Field("earningsType") int earningsType);

    //返利
    @POST("myInfo")
    @FormUrlEncoded
    Observable<TestRebate> getTestRebate(@Field("userId") int userId, @Field("token") String token, @Field("earningsType") int earningsType);

    //支出
    @POST("myInfo")
    @FormUrlEncoded
    Observable<TestExpend> getTestExpend(@Field("userId") int userId, @Field("token") String token, @Field("earningsType") int earningsType);

    //收入
    @POST("myInfo")
    @FormUrlEncoded
    Observable<TestIncome> getTestIncome(@Field("userId") int userId, @Field("token") String token, @Field("earningsType") int earningsType);


    //上架全部货物
    //    上架全部货物
//    http://192.168.0.198:8080/yayaApp/comBuy/putawayAllOrderStock

    //    参数:
//    用户Id	userId
// 我的收益页面--上架所有货物
//http://192.168.0.198:8080/yayaApp/myInfoPutaway
//参数:
// 用户id  userId
// 收益数量 salesAmount
//结果：
// 上架成功
    @POST("myInfoPutaway")
    @FormUrlEncoded
    Observable<TestPutawayAllOrderStock> getPutawayAllOrderStock(@Field("userId") int userId, @Field("token") String token, @Field("salesAmount") int salesAmount);

    //    修改密码
//    http://192.168.0.198:8080/yayaApp/updatePwd
//    参数:
//    手机号 telephone
//    验证码 codename
//    密码 pwd

    @POST("updatePwd")
    @FormUrlEncoded
    Observable<TestUpdatePwd> getTestUpdatePwd(@Field("telephone") String telephone, @Field("codename") String codename, @Field("pwd") String pwd, @Field("userId") int userId, @Field("token") String token);

    //    修改密码--获取验证码
//    http://192.168.0.198:8080/yayaApp/getPhoneCode
//    参数：
//    手机号 phone
//    结果:
    @POST("getPhoneCode")
    @FormUrlEncoded
    Observable<TestGetEtVerificationCode> getTestVerficationCode(@Field("phone") String phone);

    //    开关收款码
//            openButton
//    参数：
//    用户id userId
//    类型 type 1微信  2支付宝
//    状态 status 1开    2关
    @POST("openButton")
    @FormUrlEncoded
    Observable<SwitchReceiveingQrCode> getTestSwitchReceiveingQrCode(@Field("userId") int userId, @Field("type") int type, @Field("status") int status, @Field("token") String token);

    //上传头像
//    参数:
//    userId 用户id
//    userHeadImg 图片路径
    @POST("updateHeadImg")
    @FormUrlEncoded
    Observable<TestUpLoadGetQr> getLoadHeadlerIv(@Field("userId") int userId, @Field("userHeadImg") String userHeadImg);

    //修改昵称
    @POST("updateName")
    @FormUrlEncoded
    Observable<TestUploadHeadler> getTestUploadHeadler(@Field("userId") int userId, @Field("userName") String userName, @Field("token") String token);

    //支付宝收款码
//    http://192.168.0.198:8080/yayaApp/getUserCodeImg
//    参数:
//    用户id		userId
//    类型		type	1、微信 2、支付宝
    //结果:
    //	vxButtonStatus	微信开关按钮
    //	zfbButtonStatus	支付宝开关按钮
    //
    //	userCodeImgList	收款码集合
    //		imgMoney	二维码金额
    //		imgUrl		二维码图片
    //		imgType		二维码类型 1、微信 2、支付宝
    //		imgStatus   二维码状态
    //
    //二维码状态 1待审核 2审核完成  3审核不通过


    @POST("getUserCodeImg")
    @FormUrlEncoded
    Observable<TestAlipayReceiverCode> getAlipayReceiverCode(@Field("userId") int userId, @Field("type") int type, @Field("token") String token);


//    @POST("updateHeadImg")
//    @Multipart
//    @FormUrlEncoded
//    Observable<TestWechatReceiverCode> getTestUploadImage(@Field("userId") int userId, @Field("type") int type);


    //参数列表展示
//    getUserCodeImg
//    参数:
//    用户id		userId
//    类型		type	1、微信 2、支付宝
    @POST("getUserCodeImgConfig")
    @FormUrlEncoded
    Observable<TestWechatReceiverCode> getWechatReceiverCode(@Field("type") int type);

    //图片列表展示
    @POST("getUserCodeImg")
    @FormUrlEncoded
    Observable<TestGetUsergCodeImg> getUserCodeImg(@Field("userId") int userId, @Field("token") String token, @Field("type") int type);


    //微信 上传 图片 二维码   imgId
//    appUploadCodeImg
//    参数:
//    imgId   添加时可无
//    userId 用户id
//    imgType 1、微信 2、支付宝
//    imgUrl 图片路径
    @POST("appUploadCodeImg")
    @FormUrlEncoded
    Observable<TestUpLoadGetQr> getTestUpLoadGetQr(@Field("imgId") int imgId, @Field("userId") int userId, @Field("imgType") int imgType, @Field("imgUrl") String imgUrl, @Field("imgMoney") double imgMoney);

    //第二次上传收款码
    @POST("appUploadCodeImg")
    @FormUrlEncoded
    Observable<TestUpLoadGetQr2> getTestUpLoadGetQrNo2(@Field("imgId") int imgId, @Field("userId") int userId, @Field("imgType") int imgType, @Field("imgUrl") String imgUrl, @Field("imgMoney") double imgMoney);

    //上传图片
    @POST("uploadCodeImg")
    @Multipart
    Observable<TestUpLoadCodeIv2> getUploadIv(@Part MultipartBody.Part file);

    //消息未读
    @POST("comSell/getUserNew")
    @FormUrlEncoded
    Observable<TestUserNowMsg> getTestUserNowMsg(@Field("userId") int userId, @Field("token") String token);

    //    读取信息
///yayaApp/comSell/updateUserNew
//    参数:用户id	userId
    @POST("comSell/updateUserNew")
    @FormUrlEncoded
    Observable<TestUpdateUserNew> getTestUpdateUserNew(@Field("userId") int userId, @Field("token") String token);

    //    点击营业
///yayaApp/comBuy/doBusinese
//    参数:
//    用户id			userId
//    营业数量		userSalesCount
//    结果:
//    营业成功/营业失败

    @POST("comBuy/doBusinese")
    @FormUrlEncoded
    Observable<TestDianjiYingye> getTestDianjiYingye(@Field("userId") int userId, @Field("token") String token, @Field("userSalesCount") int userSalesCount);


    //营业
}