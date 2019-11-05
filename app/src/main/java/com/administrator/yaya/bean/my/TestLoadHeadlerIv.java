package com.administrator.yaya.bean.my;
//上传头像 个人资料
public class TestLoadHeadlerIv {
    /**
     * msg : 操作成功
     * code : 0
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":4,"userId":1,"imgMoney":null,"imgUrl":"http://192.168.0.198:8080/profile/upload/2019/11/05/e9545dfa6043011d952df9d7a9a7946d.png","imgType":null,"imgStatus":1,"userName":null,"zfbEd":0,"wxEd":0}
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
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * imgId : 4
         * userId : 1
         * imgMoney : null
         * imgUrl : http://192.168.0.198:8080/profile/upload/2019/11/05/e9545dfa6043011d952df9d7a9a7946d.png
         * imgType : null
         * imgStatus : 1
         * userName : null
         * zfbEd : 0
         * wxEd : 0
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int imgId;
        private int userId;
        private Object imgMoney;
        private String imgUrl;
        private Object imgType;
        private int imgStatus;
        private Object userName;
        private int zfbEd;
        private int wxEd;

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

        public Object getImgMoney() {
            return imgMoney;
        }

        public void setImgMoney(Object imgMoney) {
            this.imgMoney = imgMoney;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Object getImgType() {
            return imgType;
        }

        public void setImgType(Object imgType) {
            this.imgType = imgType;
        }

        public int getImgStatus() {
            return imgStatus;
        }

        public void setImgStatus(int imgStatus) {
            this.imgStatus = imgStatus;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
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

        public static class ParamsBean {
        }
    }
}
