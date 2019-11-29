package com.administrator.yaya.bean.my;

import java.util.List;
//我的邀请-查看返利记录
public class TestMyInvite {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"userInfo":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1165,"userName":"王优秀","userHeadImg":null,"userPhone":"13333333333","userPwd":"1111","userProfit":0.009,"userStatus":1,"userParentId":0,"userEarningsNow":8,"userEarningsTotal":16,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"userAllCount":0,"userSalesCount":0,"userDoneCount":0,"userSalesCountLock":0,"userNews":2,"userToken":"d2131a2154854c648d1e1822415730c5","userLevel":1,"userCredit":75,"creatTime":"2019-11-28 15:33:30","userLevelName":"王者","parentUser":null,"juniorUsers":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1214,"userName":"中国银行","userHeadImg":"http://192.168.0.198:8082/profile/upload/2019/11/28/80e8e576cb8f3f0b5ed89935fda7791a.png","userPhone":"18*******55","userPwd":"1234","userProfit":0.007,"userStatus":1,"userParentId":1165,"userEarningsNow":28,"userEarningsTotal":56,"userContributeTotal":16,"zfbEd":0,"wxEd":0,"vxButtonStatus":1,"zfbButtonStatus":1,"userAllCount":0,"userSalesCount":34000,"userDoneCount":8000,"userSalesCountLock":1000,"userNews":2,"userToken":"397aebe27b9f4f66912b3b7780b20249","userLevel":2,"userCredit":75,"creatTime":"2019-11-28 15:34:37","userLevelName":"星耀","parentUser":null,"juniorUsers":null,"junior":"16.0"}],"junior":null},"userContributeTotalToday":16,"profit":0.009,"allUserContributeTotal":16}
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
         * userInfo : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1165,"userName":"王优秀","userHeadImg":null,"userPhone":"13333333333","userPwd":"1111","userProfit":0.009,"userStatus":1,"userParentId":0,"userEarningsNow":8,"userEarningsTotal":16,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"userAllCount":0,"userSalesCount":0,"userDoneCount":0,"userSalesCountLock":0,"userNews":2,"userToken":"d2131a2154854c648d1e1822415730c5","userLevel":1,"userCredit":75,"creatTime":"2019-11-28 15:33:30","userLevelName":"王者","parentUser":null,"juniorUsers":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1214,"userName":"中国银行","userHeadImg":"http://192.168.0.198:8082/profile/upload/2019/11/28/80e8e576cb8f3f0b5ed89935fda7791a.png","userPhone":"18*******55","userPwd":"1234","userProfit":0.007,"userStatus":1,"userParentId":1165,"userEarningsNow":28,"userEarningsTotal":56,"userContributeTotal":16,"zfbEd":0,"wxEd":0,"vxButtonStatus":1,"zfbButtonStatus":1,"userAllCount":0,"userSalesCount":34000,"userDoneCount":8000,"userSalesCountLock":1000,"userNews":2,"userToken":"397aebe27b9f4f66912b3b7780b20249","userLevel":2,"userCredit":75,"creatTime":"2019-11-28 15:34:37","userLevelName":"星耀","parentUser":null,"juniorUsers":null,"junior":"16.0"}],"junior":null}
         * userContributeTotalToday : 16
         * profit : 0.009
         * allUserContributeTotal : 16
         */

        private UserInfoBean userInfo;
        private int userContributeTotalToday;
        private double profit;
        private int allUserContributeTotal;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public int getUserContributeTotalToday() {
            return userContributeTotalToday;
        }

        public void setUserContributeTotalToday(int userContributeTotalToday) {
            this.userContributeTotalToday = userContributeTotalToday;
        }

        public double getProfit() {
            return profit;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public int getAllUserContributeTotal() {
            return allUserContributeTotal;
        }

        public void setAllUserContributeTotal(int allUserContributeTotal) {
            this.allUserContributeTotal = allUserContributeTotal;
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
             * userId : 1165
             * userName : 王优秀
             * userHeadImg : null
             * userPhone : 13333333333
             * userPwd : 1111
             * userProfit : 0.009
             * userStatus : 1
             * userParentId : 0
             * userEarningsNow : 8
             * userEarningsTotal : 16
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
             * userToken : d2131a2154854c648d1e1822415730c5
             * userLevel : 1
             * userCredit : 75
             * creatTime : 2019-11-28 15:33:30
             * userLevelName : 王者
             * parentUser : null
             * juniorUsers : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1214,"userName":"中国银行","userHeadImg":"http://192.168.0.198:8082/profile/upload/2019/11/28/80e8e576cb8f3f0b5ed89935fda7791a.png","userPhone":"18*******55","userPwd":"1234","userProfit":0.007,"userStatus":1,"userParentId":1165,"userEarningsNow":28,"userEarningsTotal":56,"userContributeTotal":16,"zfbEd":0,"wxEd":0,"vxButtonStatus":1,"zfbButtonStatus":1,"userAllCount":0,"userSalesCount":34000,"userDoneCount":8000,"userSalesCountLock":1000,"userNews":2,"userToken":"397aebe27b9f4f66912b3b7780b20249","userLevel":2,"userCredit":75,"creatTime":"2019-11-28 15:34:37","userLevelName":"星耀","parentUser":null,"juniorUsers":null,"junior":"16.0"}]
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
            private String userLevelName;
            private Object parentUser;
            private String junior;
            private List<JuniorUsersBean> juniorUsers;

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

            public String getJunior() {
                return junior;
            }

            public void setJunior(String junior) {
                this.junior = junior;
            }

            public List<JuniorUsersBean> getJuniorUsers() {
                return juniorUsers;
            }

            public void setJuniorUsers(List<JuniorUsersBean> juniorUsers) {
                this.juniorUsers = juniorUsers;
            }

            public static class ParamsBean {
            }

            public static class JuniorUsersBean {
                /**
                 * searchValue : null
                 * createBy : null
                 * createTime : null
                 * updateBy : null
                 * updateTime : null
                 * remark : null
                 * params : {}
                 * userId : 1214
                 * userName : 中国银行
                 * userHeadImg : http://192.168.0.198:8082/profile/upload/2019/11/28/80e8e576cb8f3f0b5ed89935fda7791a.png
                 * userPhone : 18*******55
                 * userPwd : 1234
                 * userProfit : 0.007
                 * userStatus : 1
                 * userParentId : 1165
                 * userEarningsNow : 28
                 * userEarningsTotal : 56
                 * userContributeTotal : 16
                 * zfbEd : 0
                 * wxEd : 0
                 * vxButtonStatus : 1
                 * zfbButtonStatus : 1
                 * userAllCount : 0
                 * userSalesCount : 34000
                 * userDoneCount : 8000
                 * userSalesCountLock : 1000
                 * userNews : 2
                 * userToken : 397aebe27b9f4f66912b3b7780b20249
                 * userLevel : 2
                 * userCredit : 75
                 * creatTime : 2019-11-28 15:34:37
                 * userLevelName : 星耀
                 * parentUser : null
                 * juniorUsers : null
                 * junior : 16.0
                 */

                private Object searchValue;
                private Object createBy;
                private Object createTime;
                private Object updateBy;
                private Object updateTime;
                private Object remark;
                private ParamsBeanX params;
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
                private String userLevelName;
                private Object parentUser;
                private Object juniorUsers;
                private String junior;

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

                public String getJunior() {
                    return junior;
                }

                public void setJunior(String junior) {
                    this.junior = junior;
                }

                public static class ParamsBeanX {
                }
            }
        }
    }
}
