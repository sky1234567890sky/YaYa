package com.administrator.yaya.bean.my;

import java.util.List;

//通知消息
public class TestNotificationInfo {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":11,"userId":1,"infoType":3,"infoContent":"您的订单123213123已完成","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":8,"userId":1,"infoType":3,"infoContent":"您的订单123213124已完成","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":7,"userId":1,"infoType":3,"infoContent":"您的订单123213123已完成","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":6,"userId":1,"infoType":3,"infoContent":"您的订单123213124已完成","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":5,"userId":1,"infoType":3,"infoContent":"您的订单123213123已完成","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":4,"userId":1,"infoType":3,"infoContent":"您的订单123213124已完成","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":3,"userId":1,"infoType":2,"infoContent":"您的订单123213124已上架","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":2,"userId":1,"infoType":2,"infoContent":"您的订单123213123已上架","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"infoId":1,"userId":1,"infoType":1,"infoContent":"您的123123123订单已到账111","userName":"钱浩龙"}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * infoId : 11
         * userId : 1
         * infoType : 3
         * infoContent : 您的订单123213123已完成
         * userName : 钱浩龙
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int infoId;
        private int userId;
        private int infoType;
        private String infoContent;
        private String userName;

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

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getInfoType() {
            return infoType;
        }

        public void setInfoType(int infoType) {
            this.infoType = infoType;
        }

        public String getInfoContent() {
            return infoContent;
        }

        public void setInfoContent(String infoContent) {
            this.infoContent = infoContent;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public static class ParamsBean {
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "searchValue=" + searchValue +
                    ", createBy=" + createBy +
                    ", createTime=" + createTime +
                    ", updateBy=" + updateBy +
                    ", updateTime=" + updateTime +
                    ", remark=" + remark +
                    ", params=" + params +
                    ", infoId=" + infoId +
                    ", userId=" + userId +
                    ", infoType=" + infoType +
                    ", infoContent='" + infoContent + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestNotificationInfo{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
