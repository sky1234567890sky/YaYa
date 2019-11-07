package com.administrator.yaya.bean.homepage;

public class TestBuyCom {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":0.01,"comImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg","comInventory":9983650,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"}
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
         * comId : 1
         * comName : 游戏币
         * comPrice : 0.01
         * comImg : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg
         * comInventory : 9983650
         * comPurchaseNumMin : 100
         * comPurchaseNumMax : 10000000
         * comExplain : 这是个游戏币
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int comId;
        private String comName;
        private double comPrice;
        private String comImg;
        private int comInventory;
        private int comPurchaseNumMin;
        private int comPurchaseNumMax;
        private String comExplain;

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

        public double getComPrice() {
            return comPrice;
        }

        public void setComPrice(double comPrice) {
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
                    ", comId=" + comId +
                    ", comName='" + comName + '\'' +
                    ", comPrice=" + comPrice +
                    ", comImg='" + comImg + '\'' +
                    ", comInventory=" + comInventory +
                    ", comPurchaseNumMin=" + comPurchaseNumMin +
                    ", comPurchaseNumMax=" + comPurchaseNumMax +
                    ", comExplain='" + comExplain + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestBuyCom{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
