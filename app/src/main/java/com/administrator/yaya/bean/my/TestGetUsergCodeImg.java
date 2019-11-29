package com.administrator.yaya.bean.my;

import java.util.List;

// 微信  支付宝  图片 展示 列表
public class TestGetUsergCodeImg {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"vxButtonStatus":1,"userCodeImgList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":78,"userId":1214,"imgMoney":1000,"imgUrl":"http://192.168.0.198:8082/profile/upload/2019/11/28/b9879818af0d157f7cdc15326d9963f7.jpg","imgType":1,"imgStatus":2,"imgButton":null,"userName":null,"userPhone":null,"zfbEd":0,"wxEd":0,"creditMin":null}],"zfbButtonStatus":1}
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
         * vxButtonStatus : 1
         * userCodeImgList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":78,"userId":1214,"imgMoney":1000,"imgUrl":"http://192.168.0.198:8082/profile/upload/2019/11/28/b9879818af0d157f7cdc15326d9963f7.jpg","imgType":1,"imgStatus":2,"imgButton":null,"userName":null,"userPhone":null,"zfbEd":0,"wxEd":0,"creditMin":null}]
         * zfbButtonStatus : 1
         */

        private int vxButtonStatus;
        private int zfbButtonStatus;
        private List<UserCodeImgListBean> userCodeImgList;

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

        public List<UserCodeImgListBean> getUserCodeImgList() {
            return userCodeImgList;
        }

        public void setUserCodeImgList(List<UserCodeImgListBean> userCodeImgList) {
            this.userCodeImgList = userCodeImgList;
        }

        public static class UserCodeImgListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * imgId : 78
             * userId : 1214
             * imgMoney : 1000
             * imgUrl : http://192.168.0.198:8082/profile/upload/2019/11/28/b9879818af0d157f7cdc15326d9963f7.jpg
             * imgType : 1
             * imgStatus : 2
             * imgButton : null
             * userName : null
             * userPhone : null
             * zfbEd : 0
             * wxEd : 0
             * creditMin : null
             */

//            private int imgConfigId;
//            private int imgConfigType;
//            private int imgConfigMoney;

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private int imgId;
            private int userId;
            private double imgMoney;
            private String imgUrl;
            private int imgType;
            private int imgStatus;
            private Object imgButton;
            private Object userName;
            private Object userPhone;
            private int zfbEd;
            private int wxEd;
            private Object creditMin;

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

            public int getImgId() {
                return imgId;
            }

            public void setImgId(int imgId) {
                this.imgId = imgId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public double getImgMoney() {
                return imgMoney;
            }

            public void setImgMoney(double imgMoney) {
                this.imgMoney = imgMoney;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public int getImgType() {
                return imgType;
            }

            public void setImgType(int imgType) {
                this.imgType = imgType;
            }

            public int getImgStatus() {
                return imgStatus;
            }

            public void setImgStatus(int imgStatus) {
                this.imgStatus = imgStatus;
            }

            public Object getImgButton() {
                return imgButton;
            }

            public void setImgButton(Object imgButton) {
                this.imgButton = imgButton;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(Object userPhone) {
                this.userPhone = userPhone;
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


            public Object getCreditMin() {
                return creditMin;
            }

            public void setCreditMin(Object creditMin) {
                this.creditMin = creditMin;
            }

            public static class ParamsBean {
            }
        }
    }
}
