package com.administrator.yaya.bean.homepage;

import java.io.Serializable;
//我的
public class TestHomePageData implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"userInfo":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1103,"userName":"vVv","userHeadImg":"http://192.168.0.198:8082/yyWeb/profile/upload/2019/12/05/25a991c6df689aa67cc01517b6bf94ec.png","userPhone":"13311111111","userPwd":"1234","userProfit":0.009,"userStatus":1,"userParentId":1000,"userEarningsNow":0,"userEarningsTotal":0,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"userAllCount":1031105,"userSalesCount":288888,"userDoneCount":0,"userSalesCountLock":0,"userNews":2,"userToken":"6b89913518574991bb939b4099b56a95","userLevel":1,"userCredit":75,"creatTime":"2019-12-02 09:47:20","doBusineseStatus":1,"userLevelName":"王者","parentUser":null,"juniorUsers":null,"junior":null},"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":1,"comImg":"http://192.168.0.198:8082/yyWeb/profile/upload/2019/12/04/13d0e48cd558347124c51bce2a84532e.jpg","comInventory":696645240,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币","commodityPriceDeduction":0},"userEarningsToday":null,"userAllOrderCount":1,"creditName":"良好"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userInfo : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1103,"userName":"vVv","userHeadImg":"http://192.168.0.198:8082/yyWeb/profile/upload/2019/12/05/25a991c6df689aa67cc01517b6bf94ec.png","userPhone":"13311111111","userPwd":"1234","userProfit":0.009,"userStatus":1,"userParentId":1000,"userEarningsNow":0,"userEarningsTotal":0,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"userAllCount":1031105,"userSalesCount":288888,"userDoneCount":0,"userSalesCountLock":0,"userNews":2,"userToken":"6b89913518574991bb939b4099b56a95","userLevel":1,"userCredit":75,"creatTime":"2019-12-02 09:47:20","doBusineseStatus":1,"userLevelName":"王者","parentUser":null,"juniorUsers":null,"junior":null}
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":1,"comImg":"http://192.168.0.198:8082/yyWeb/profile/upload/2019/12/04/13d0e48cd558347124c51bce2a84532e.jpg","comInventory":696645240,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币","commodityPriceDeduction":0}
         * userEarningsToday : null
         * userAllOrderCount : 1
         * creditName : 良好
         */

        private UserInfoBean userInfo;
        private CommodityBean commodity;
        private String userEarningsToday;
        private int userAllOrderCount;
        private String creditName;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public CommodityBean getCommodity() {
            return commodity;
        }

        public void setCommodity(CommodityBean commodity) {
            this.commodity = commodity;
        }

        public String getUserEarningsToday() {
            return userEarningsToday;
        }

        public void setUserEarningsToday(String userEarningsToday) {
            this.userEarningsToday = userEarningsToday;
        }

        public int getUserAllOrderCount() {
            return userAllOrderCount;
        }

        public void setUserAllOrderCount(int userAllOrderCount) {
            this.userAllOrderCount = userAllOrderCount;
        }

        public String getCreditName() {
            return creditName;
        }

        public void setCreditName(String creditName) {
            this.creditName = creditName;
        }

        public static class UserInfoBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * userId : 1103
             * userName : vVv
             * userHeadImg : http://192.168.0.198:8082/yyWeb/profile/upload/2019/12/05/25a991c6df689aa67cc01517b6bf94ec.png
             * userPhone : 13311111111
             * userPwd : 1234
             * userProfit : 0.009
             * userStatus : 1
             * userParentId : 1000
             * userEarningsNow : 0
             * userEarningsTotal : 0
             * userContributeTotal : 0
             * zfbEd : 0
             * wxEd : 0
             * vxButtonStatus : 2
             * zfbButtonStatus : 2
             * userAllCount : 1031105
             * userSalesCount : 288888
             * userDoneCount : 0
             * userSalesCountLock : 0
             * userNews : 2
             * userToken : 6b89913518574991bb939b4099b56a95
             * userLevel : 1
             * userCredit : 75
             * creatTime : 2019-12-02 09:47:20
             * doBusineseStatus : 1
             * userLevelName : 王者
             * parentUser : null
             * juniorUsers : null
             * junior : null
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private int userId;
            private String userName;
            private String userHeadImg;
            private String userPhone;
            private String userPwd;
            private double userProfit;
            private int userStatus;
            private int userParentId;
            private int userEarningsNow;
            private int userEarningsTotal;
            private int userContributeTotal;
            private int zfbEd;
            private int wxEd;
            private int vxButtonStatus;
            private int zfbButtonStatus;
            private int userAllCount;
            private int userSalesCount;
            private int userDoneCount;
            private int userSalesCountLock;
            private int userNews;
            private String userToken;
            private int userLevel;
            private int userCredit;
            private String creatTime;
            private int doBusineseStatus;
            private String userLevelName;
            private Object parentUser;
            private Object juniorUsers;
            private Object junior;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserHeadImg() {
                return userHeadImg;
            }

            public void setUserHeadImg(String userHeadImg) {
                this.userHeadImg = userHeadImg;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserPwd() {
                return userPwd;
            }

            public void setUserPwd(String userPwd) {
                this.userPwd = userPwd;
            }

            public double getUserProfit() {
                return userProfit;
            }

            public void setUserProfit(double userProfit) {
                this.userProfit = userProfit;
            }

            public int getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(int userStatus) {
                this.userStatus = userStatus;
            }

            public int getUserParentId() {
                return userParentId;
            }

            public void setUserParentId(int userParentId) {
                this.userParentId = userParentId;
            }

            public int getUserEarningsNow() {
                return userEarningsNow;
            }

            public void setUserEarningsNow(int userEarningsNow) {
                this.userEarningsNow = userEarningsNow;
            }

            public int getUserEarningsTotal() {
                return userEarningsTotal;
            }

            public void setUserEarningsTotal(int userEarningsTotal) {
                this.userEarningsTotal = userEarningsTotal;
            }

            public int getUserContributeTotal() {
                return userContributeTotal;
            }

            public void setUserContributeTotal(int userContributeTotal) {
                this.userContributeTotal = userContributeTotal;
            }

            public int getZfbEd() {
                return zfbEd;
            }

            public void setZfbEd(int zfbEd) {
                this.zfbEd = zfbEd;
            }

            public int getWxEd() {
                return wxEd;
            }

            public void setWxEd(int wxEd) {
                this.wxEd = wxEd;
            }

            public int getVxButtonStatus() {
                return vxButtonStatus;
            }

            public void setVxButtonStatus(int vxButtonStatus) {
                this.vxButtonStatus = vxButtonStatus;
            }

            public int getZfbButtonStatus() {
                return zfbButtonStatus;
            }

            public void setZfbButtonStatus(int zfbButtonStatus) {
                this.zfbButtonStatus = zfbButtonStatus;
            }

            public int getUserAllCount() {
                return userAllCount;
            }

            public void setUserAllCount(int userAllCount) {
                this.userAllCount = userAllCount;
            }

            public int getUserSalesCount() {
                return userSalesCount;
            }

            public void setUserSalesCount(int userSalesCount) {
                this.userSalesCount = userSalesCount;
            }

            public int getUserDoneCount() {
                return userDoneCount;
            }

            public void setUserDoneCount(int userDoneCount) {
                this.userDoneCount = userDoneCount;
            }

            public int getUserSalesCountLock() {
                return userSalesCountLock;
            }

            public void setUserSalesCountLock(int userSalesCountLock) {
                this.userSalesCountLock = userSalesCountLock;
            }

            public int getUserNews() {
                return userNews;
            }

            public void setUserNews(int userNews) {
                this.userNews = userNews;
            }

            public String getUserToken() {
                return userToken;
            }

            public void setUserToken(String userToken) {
                this.userToken = userToken;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
            }

            public int getUserCredit() {
                return userCredit;
            }

            public void setUserCredit(int userCredit) {
                this.userCredit = userCredit;
            }

            public String getCreatTime() {
                return creatTime;
            }

            public void setCreatTime(String creatTime) {
                this.creatTime = creatTime;
            }

            public int getDoBusineseStatus() {
                return doBusineseStatus;
            }

            public void setDoBusineseStatus(int doBusineseStatus) {
                this.doBusineseStatus = doBusineseStatus;
            }

            public String getUserLevelName() {
                return userLevelName;
            }

            public void setUserLevelName(String userLevelName) {
                this.userLevelName = userLevelName;
            }

            public Object getParentUser() {
                return parentUser;
            }

            public void setParentUser(Object parentUser) {
                this.parentUser = parentUser;
            }

            public Object getJuniorUsers() {
                return juniorUsers;
            }

            public void setJuniorUsers(Object juniorUsers) {
                this.juniorUsers = juniorUsers;
            }

            public Object getJunior() {
                return junior;
            }

            public void setJunior(Object junior) {
                this.junior = junior;
            }

            public static class ParamsBean {
            }
        }

        public static class CommodityBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * comId : 1
             * comName : 游戏币
             * comPrice : 1
             * comImg : http://192.168.0.198:8082/yyWeb/profile/upload/2019/12/04/13d0e48cd558347124c51bce2a84532e.jpg
             * comInventory : 696645240
             * comPurchaseNumMin : 100
             * comPurchaseNumMax : 10000000
             * comExplain : 这是个游戏币
             * commodityPriceDeduction : 0
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private int comId;
            private String comName;
            private int comPrice;
            private String comImg;
            private int comInventory;
            private int comPurchaseNumMin;
            private int comPurchaseNumMax;
            private String comExplain;
            private int commodityPriceDeduction;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public ParamsBeanX getParams() {
                return params;
            }

            public void setParams(ParamsBeanX params) {
                this.params = params;
            }

            public int getComId() {
                return comId;
            }

            public void setComId(int comId) {
                this.comId = comId;
            }

            public String getComName() {
                return comName;
            }

            public void setComName(String comName) {
                this.comName = comName;
            }

            public int getComPrice() {
                return comPrice;
            }

            public void setComPrice(int comPrice) {
                this.comPrice = comPrice;
            }

            public String getComImg() {
                return comImg;
            }

            public void setComImg(String comImg) {
                this.comImg = comImg;
            }

            public int getComInventory() {
                return comInventory;
            }

            public void setComInventory(int comInventory) {
                this.comInventory = comInventory;
            }

            public int getComPurchaseNumMin() {
                return comPurchaseNumMin;
            }

            public void setComPurchaseNumMin(int comPurchaseNumMin) {
                this.comPurchaseNumMin = comPurchaseNumMin;
            }

            public int getComPurchaseNumMax() {
                return comPurchaseNumMax;
            }

            public void setComPurchaseNumMax(int comPurchaseNumMax) {
                this.comPurchaseNumMax = comPurchaseNumMax;
            }

            public String getComExplain() {
                return comExplain;
            }

            public void setComExplain(String comExplain) {
                this.comExplain = comExplain;
            }

            public int getCommodityPriceDeduction() {
                return commodityPriceDeduction;
            }

            public void setCommodityPriceDeduction(int commodityPriceDeduction) {
                this.commodityPriceDeduction = commodityPriceDeduction;
            }

            public static class ParamsBeanX {
            }
        }
    }
}
