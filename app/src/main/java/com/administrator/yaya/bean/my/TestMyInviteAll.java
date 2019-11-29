package com.administrator.yaya.bean.my;

import java.util.List;

//我的邀请
public class TestMyInviteAll {
    /**
     * msg : 操作成功
     * code : 0
     * data : {"userInfo":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1402,"userName":"陆铺甩","userHeadImg":null,"userPhone":"13723030666","userPwd":"1234","userProfit":0.005,"userStatus":1,"userParentId":1196,"userEarningsNow":0,"userEarningsTotal":0,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"userAllCount":0,"userSalesCount":0,"userDoneCount":0,"userSalesCountLock":0,"userNews":2,"userToken":"c7fb5011cf6a436e9597c5398c61ac43","userLevel":3,"userCredit":75,"creatTime":"2019-11-27 13:26:58","userLevelName":"钻石","parentUser":null,"juniorUsers":null,"junior":null},"list":[{"codeId":23,"codeUserId":1402,"codeLevel":4,"codeName":"43902817","lvName":"铂金","lvProfit":0.003},{"codeId":24,"codeUserId":1402,"codeLevel":5,"codeName":"94316280","lvName":"黄金","lvProfit":0.001}],"profit":0.005}
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
         * userInfo : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1402,"userName":"陆铺甩","userHeadImg":null,"userPhone":"13723030666","userPwd":"1234","userProfit":0.005,"userStatus":1,"userParentId":1196,"userEarningsNow":0,"userEarningsTotal":0,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"userAllCount":0,"userSalesCount":0,"userDoneCount":0,"userSalesCountLock":0,"userNews":2,"userToken":"c7fb5011cf6a436e9597c5398c61ac43","userLevel":3,"userCredit":75,"creatTime":"2019-11-27 13:26:58","userLevelName":"钻石","parentUser":null,"juniorUsers":null,"junior":null}
         * list : [{"codeId":23,"codeUserId":1402,"codeLevel":4,"codeName":"43902817","lvName":"铂金","lvProfit":0.003},{"codeId":24,"codeUserId":1402,"codeLevel":5,"codeName":"94316280","lvName":"黄金","lvProfit":0.001}]
         * profit : 0.005
         */

        private UserInfoBean userInfo;
        private double profit;
        private List<ListBean> list;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public double getProfit() {
            return profit;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
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
             * userId : 1402
             * userName : 陆铺甩
             * userHeadImg : null
             * userPhone : 13723030666
             * userPwd : 1234
             * userProfit : 0.005
             * userStatus : 1
             * userParentId : 1196
             * userEarningsNow : 0
             * userEarningsTotal : 0
             * userContributeTotal : 0
             * zfbEd : 0
             * wxEd : 0
             * vxButtonStatus : 2
             * zfbButtonStatus : 2
             * userAllCount : 0
             * userSalesCount : 0
             * userDoneCount : 0
             * userSalesCountLock : 0
             * userNews : 2
             * userToken : c7fb5011cf6a436e9597c5398c61ac43
             * userLevel : 3
             * userCredit : 75
             * creatTime : 2019-11-27 13:26:58
             * userLevelName : 钻石
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
            private double userEarningsNow;
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

            public double getUserEarningsNow() {
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

        public static class ListBean {
            /**
             * codeId : 23
             * codeUserId : 1402
             * codeLevel : 4
             * codeName : 43902817
             * lvName : 铂金
             * lvProfit : 0.003
             */

            private int codeId;
            private int codeUserId;
            private int codeLevel;
            private String codeName;
            private String lvName;
            private double lvProfit;

            public int getCodeId() {
                return codeId;
            }

            public void setCodeId(int codeId) {
                this.codeId = codeId;
            }

            public int getCodeUserId() {
                return codeUserId;
            }

            public void setCodeUserId(int codeUserId) {
                this.codeUserId = codeUserId;
            }

            public int getCodeLevel() {
                return codeLevel;
            }

            public void setCodeLevel(int codeLevel) {
                this.codeLevel = codeLevel;
            }

            public String getCodeName() {
                return codeName;
            }

            public void setCodeName(String codeName) {
                this.codeName = codeName;
            }

            public String getLvName() {
                return lvName;
            }

            public void setLvName(String lvName) {
                this.lvName = lvName;
            }

            public double getLvProfit() {
                return lvProfit;
            }

            public void setLvProfit(double lvProfit) {
                this.lvProfit = lvProfit;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "codeId=" + codeId +
                        ", codeUserId=" + codeUserId +
                        ", codeLevel=" + codeLevel +
                        ", codeName='" + codeName + '\'' +
                        ", lvName='" + lvName + '\'' +
                        ", lvProfit=" + lvProfit +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userInfo=" + userInfo +
                    ", profit=" + profit +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestMyInviteAll{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
    //    结果:
//    profit    返利比例
//    userInfo:    用户基本信息
//    userId   用户id
//    userLevelName 级别名称
//    userHeadImg  头像
//    list    邀请码集合
//    lvName   级别名称
//    codeName  邀请码
//    lvProfit  返利比例（分配）




}
