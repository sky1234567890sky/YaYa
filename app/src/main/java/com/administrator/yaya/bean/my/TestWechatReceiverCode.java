package com.administrator.yaya.bean.my;

import java.util.List;

//微信二维码
public class TestWechatReceiverCode {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgConfigId":1,"imgConfigType":1,"imgConfigMoney":1000},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgConfigId":2,"imgConfigType":1,"imgConfigMoney":2000},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgConfigId":3,"imgConfigType":1,"imgConfigMoney":3000},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgConfigId":4,"imgConfigType":1,"imgConfigMoney":4000},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"imgConfigId":5,"imgConfigType":1,"imgConfigMoney":5000}]
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
         * imgConfigId : 1
         * imgConfigType : 1
         * imgConfigMoney : 1000
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;

        private ParamsBean params;
        private int imgConfigId;
        private int imgConfigType;
        private double imgConfigMoney;
        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

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

        public int getImgConfigId() {
            return imgConfigId;
        }

        public void setImgConfigId(int imgConfigId) {
            this.imgConfigId = imgConfigId;
        }

        public int getImgConfigType() {
            return imgConfigType;
        }

        public void setImgConfigType(int imgConfigType) {
            this.imgConfigType = imgConfigType;
        }

        public double getImgConfigMoney() {
            return imgConfigMoney;
        }

        public void setImgConfigMoney(int imgConfigMoney) {
            this.imgConfigMoney = imgConfigMoney;
        }

        public static class ParamsBean {
        }
    }
}
