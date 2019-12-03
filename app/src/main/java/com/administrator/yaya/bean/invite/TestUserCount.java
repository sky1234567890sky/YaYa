package com.administrator.yaya.bean.invite;

/**
 *库存总数bean
 */
public class TestUserCount {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":1,"comImg":"http://192.168.0.198:8082/profile/upload/2019/11/28/50cb427dbda4ad7efce363de67f6dc13.jpg","comInventory":707069485,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币","commodityPriceDeduction":0},"amount":null,"userAllCount":811105}
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
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":1,"comImg":"http://192.168.0.198:8082/profile/upload/2019/11/28/50cb427dbda4ad7efce363de67f6dc13.jpg","comInventory":707069485,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币","commodityPriceDeduction":0}
         * amount : null
         * userAllCount : 811105
         */

        private CommodityBean commodity;
        private int amount;
        private int userAllCount;

        public CommodityBean getCommodity() {
            return commodity;
        }

        public void setCommodity(CommodityBean commodity) {
            this.commodity = commodity;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getUserAllCount() {
            return userAllCount;
        }

        public void setUserAllCount(int userAllCount) {
            this.userAllCount = userAllCount;
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
             * comImg : http://192.168.0.198:8082/profile/upload/2019/11/28/50cb427dbda4ad7efce363de67f6dc13.jpg
             * comInventory : 707069485
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
            private ParamsBean params;
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

            public static class ParamsBean {
            }

            @Override
            public String toString() {
                return "CommodityBean{" +
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
                        ", commodityPriceDeduction=" + commodityPriceDeduction +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "commodity=" + commodity +
                    ", amount=" + amount +
                    ", userAllCount=" + userAllCount +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "TestUserCount{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
