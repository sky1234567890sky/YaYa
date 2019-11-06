package com.administrator.yaya.bean.my;

import java.util.List;

//我的收益  支出
public class TestExpend {
    /**
     * msg : 操作成功
     * code : 0
     * data : {"userInfo":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"userName":"钱浩龙","userNickName":"qhl","userHeadImg":"http://192.168.0.198:8080/profile/upload/2019/11/05/6988361266429a53278f92a2c44373ca.png","userPhone":"17631365666","userPwd":"1234","userProfit":8.0E-4,"userStatus":1,"userInvitationCode":"6666","userParentId":0,"userEarningsNow":370,"userEarningsTotal":493,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"parentUser":null,"juniorUsers":null,"junior":null},"userEarningsList":[],"commodityName":"游戏币"}
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
         * userInfo : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"userName":"钱浩龙","userNickName":"qhl","userHeadImg":"http://192.168.0.198:8080/profile/upload/2019/11/05/6988361266429a53278f92a2c44373ca.png","userPhone":"17631365666","userPwd":"1234","userProfit":8.0E-4,"userStatus":1,"userInvitationCode":"6666","userParentId":0,"userEarningsNow":370,"userEarningsTotal":493,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":2,"zfbButtonStatus":2,"parentUser":null,"juniorUsers":null,"junior":null}
         * userEarningsList : []
         * commodityName : 游戏币
         */

        private UserInfoBean userInfo;
        private String commodityName;
        private List<?> userEarningsList;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public List<?> getUserEarningsList() {
            return userEarningsList;
        }

        public void setUserEarningsList(List<?> userEarningsList) {
            this.userEarningsList = userEarningsList;
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
             * userId : 1
             * userName : 钱浩龙
             * userNickName : qhl
             * userHeadImg : http://192.168.0.198:8080/profile/upload/2019/11/05/6988361266429a53278f92a2c44373ca.png
             * userPhone : 17631365666
             * userPwd : 1234
             * userProfit : 8.0E-4
             * userStatus : 1
             * userInvitationCode : 6666
             * userParentId : 0
             * userEarningsNow : 370
             * userEarningsTotal : 493
             * userContributeTotal : 0
             * zfbEd : 0
             * wxEd : 0
             * vxButtonStatus : 2
             * zfbButtonStatus : 2
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
            private String userNickName;
            private String userHeadImg;
            private String userPhone;
            private String userPwd;
            private double userProfit;
            private int userStatus;
            private String userInvitationCode;
            private int userParentId;
            private int userEarningsNow;
            private int userEarningsTotal;
            private int userContributeTotal;
            private int zfbEd;
            private int wxEd;
            private int vxButtonStatus;
            private int zfbButtonStatus;
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

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
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

            public String getUserInvitationCode() {
                return userInvitationCode;
            }

            public void setUserInvitationCode(String userInvitationCode) {
                this.userInvitationCode = userInvitationCode;
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

            @Override
            public String toString() {
                return "UserInfoBean{" +
                        "searchValue=" + searchValue +
                        ", createBy=" + createBy +
                        ", createTime=" + createTime +
                        ", updateBy=" + updateBy +
                        ", updateTime=" + updateTime +
                        ", remark=" + remark +
                        ", params=" + params +
                        ", userId=" + userId +
                        ", userName='" + userName + '\'' +
                        ", userNickName='" + userNickName + '\'' +
                        ", userHeadImg='" + userHeadImg + '\'' +
                        ", userPhone='" + userPhone + '\'' +
                        ", userPwd='" + userPwd + '\'' +
                        ", userProfit=" + userProfit +
                        ", userStatus=" + userStatus +
                        ", userInvitationCode='" + userInvitationCode + '\'' +
                        ", userParentId=" + userParentId +
                        ", userEarningsNow=" + userEarningsNow +
                        ", userEarningsTotal=" + userEarningsTotal +
                        ", userContributeTotal=" + userContributeTotal +
                        ", zfbEd=" + zfbEd +
                        ", wxEd=" + wxEd +
                        ", vxButtonStatus=" + vxButtonStatus +
                        ", zfbButtonStatus=" + zfbButtonStatus +
                        ", parentUser=" + parentUser +
                        ", juniorUsers=" + juniorUsers +
                        ", junior=" + junior +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userInfo=" + userInfo +
                    ", commodityName='" + commodityName + '\'' +
                    ", userEarningsList=" + userEarningsList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestExpend{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
