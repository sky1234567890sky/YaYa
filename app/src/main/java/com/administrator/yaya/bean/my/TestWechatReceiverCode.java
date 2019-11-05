package com.administrator.yaya.bean.my;

import java.util.List;

//微信二维码
public class TestWechatReceiverCode {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"vxButtonStatus":2,"userCodeImgList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":3,"userId":1,"imgMoney":1000,"imgUrl":"http://localhost:8080/profile/upload/2019/11/05/14ccb618048e8c66c7ca3d817a5bfd45.jpg","imgType":1,"imgStatus":2,"userName":"钱浩龙","zfbEd":0,"wxEd":0},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":2,"userId":1,"imgMoney":2000,"imgUrl":"http://localhost:8080/profile/upload/2019/11/05/59d439f34d89edcbcc4295053b6a3be1.png","imgType":1,"imgStatus":2,"userName":"钱浩龙","zfbEd":0,"wxEd":0}],"zfbButtonStatus":2}
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
         * vxButtonStatus : 2
         * userCodeImgList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":3,"userId":1,"imgMoney":1000,"imgUrl":"http://localhost:8080/profile/upload/2019/11/05/14ccb618048e8c66c7ca3d817a5bfd45.jpg","imgType":1,"imgStatus":2,"userName":"钱浩龙","zfbEd":0,"wxEd":0},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgId":2,"userId":1,"imgMoney":2000,"imgUrl":"http://localhost:8080/profile/upload/2019/11/05/59d439f34d89edcbcc4295053b6a3be1.png","imgType":1,"imgStatus":2,"userName":"钱浩龙","zfbEd":0,"wxEd":0}]
         * zfbButtonStatus : 2
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
             * imgId : 3
             * userId : 1
             * imgMoney : 1000
             * imgUrl : http://localhost:8080/profile/upload/2019/11/05/14ccb618048e8c66c7ca3d817a5bfd45.jpg
             * imgType : 1
             * imgStatus : 2
             * userName : 钱浩龙
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
            private int imgMoney;
            private String imgUrl;
            private int imgType;
            private int imgStatus;
            private String userName;
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

            public int getImgMoney() {
                return imgMoney;
            }

            public void setImgMoney(int imgMoney) {
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

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
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
}
