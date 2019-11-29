package com.administrator.yaya.bean.orderform;

import java.io.Serializable;
import java.util.List;

//未收货
public class TestCancel implements Serializable {
    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":0.01,"comImg":"http://192.168.0.198:8082/profile/upload/2019/11/15/9213039ec18ea51f22b4ec4a7c35b856.jpg","comInventory":730125231,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"},"amount":"200000","orderSalesList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":172,"salesApiId":22,"userId":41,"orderNumber":"191120105772412","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:57:25","salesUpdateTime":"2019-11-25 14:23:26","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":171,"salesApiId":21,"userId":41,"orderNumber":"191120105799585","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:57:24","salesUpdateTime":"2019-11-26 10:04:26","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":169,"salesApiId":19,"userId":41,"orderNumber":"191120104119823","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:32","salesUpdateTime":"2019-11-26 10:12:38","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":168,"salesApiId":18,"userId":41,"orderNumber":"191120104187914","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:24","salesUpdateTime":"2019-11-20 10:41:51","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":167,"salesApiId":17,"userId":41,"orderNumber":"191120104199209","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:23","salesUpdateTime":"2019-11-20 10:41:54","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":166,"salesApiId":16,"userId":41,"orderNumber":"191120104131981","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:23","salesUpdateTime":"2019-11-20 10:41:56","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":165,"salesApiId":15,"userId":41,"orderNumber":"191120104029751","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:40:43","salesUpdateTime":"2019-11-20 10:41:00","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":164,"salesApiId":14,"userId":41,"orderNumber":"191120104023910","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-20 10:40:36","salesUpdateTime":"2019-11-20 10:41:06","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":163,"salesApiId":13,"userId":41,"orderNumber":"191120103994683","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:39:55","salesUpdateTime":"2019-11-20 10:40:08","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":162,"salesApiId":12,"userId":41,"orderNumber":"191120103510185","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:35:28","salesUpdateTime":"2019-11-20 10:35:40","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":161,"salesApiId":11,"userId":41,"orderNumber":"191120103323875","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:33:52","salesUpdateTime":"2019-11-20 10:34:04","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":160,"salesApiId":10,"userId":41,"orderNumber":"191120103265487","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:32:26","salesUpdateTime":"2019-11-20 10:32:43","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":159,"salesApiId":9,"userId":41,"orderNumber":"191120102727204","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:27:25","salesUpdateTime":"2019-11-20 10:27:34","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":158,"salesApiId":8,"userId":41,"orderNumber":"191120102611272","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:26:36","salesUpdateTime":"2019-11-20 10:26:46","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":157,"salesApiId":7,"userId":41,"orderNumber":"191120102518484","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-20 10:25:25","salesUpdateTime":"2019-11-20 10:25:34","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":156,"salesApiId":6,"userId":41,"orderNumber":"191120102424978","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-20 10:24:18","salesUpdateTime":"2019-11-20 10:25:44","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"}]}
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
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":0.01,"comImg":"http://192.168.0.198:8082/profile/upload/2019/11/15/9213039ec18ea51f22b4ec4a7c35b856.jpg","comInventory":730125231,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"}
         * amount : 200000
         * orderSalesList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":172,"salesApiId":22,"userId":41,"orderNumber":"191120105772412","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:57:25","salesUpdateTime":"2019-11-25 14:23:26","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":171,"salesApiId":21,"userId":41,"orderNumber":"191120105799585","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:57:24","salesUpdateTime":"2019-11-26 10:04:26","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":169,"salesApiId":19,"userId":41,"orderNumber":"191120104119823","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:32","salesUpdateTime":"2019-11-26 10:12:38","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":168,"salesApiId":18,"userId":41,"orderNumber":"191120104187914","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:24","salesUpdateTime":"2019-11-20 10:41:51","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":167,"salesApiId":17,"userId":41,"orderNumber":"191120104199209","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:23","salesUpdateTime":"2019-11-20 10:41:54","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":166,"salesApiId":16,"userId":41,"orderNumber":"191120104131981","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:41:23","salesUpdateTime":"2019-11-20 10:41:56","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":165,"salesApiId":15,"userId":41,"orderNumber":"191120104029751","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:40:43","salesUpdateTime":"2019-11-20 10:41:00","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":164,"salesApiId":14,"userId":41,"orderNumber":"191120104023910","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-20 10:40:36","salesUpdateTime":"2019-11-20 10:41:06","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":163,"salesApiId":13,"userId":41,"orderNumber":"191120103994683","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:39:55","salesUpdateTime":"2019-11-20 10:40:08","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":162,"salesApiId":12,"userId":41,"orderNumber":"191120103510185","commodityPrice":0,"salesAmount":100000,"salesAmountMoney":1000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:35:28","salesUpdateTime":"2019-11-20 10:35:40","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":161,"salesApiId":11,"userId":41,"orderNumber":"191120103323875","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:33:52","salesUpdateTime":"2019-11-20 10:34:04","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":160,"salesApiId":10,"userId":41,"orderNumber":"191120103265487","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:32:26","salesUpdateTime":"2019-11-20 10:32:43","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":159,"salesApiId":9,"userId":41,"orderNumber":"191120102727204","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:27:25","salesUpdateTime":"2019-11-20 10:27:34","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":158,"salesApiId":8,"userId":41,"orderNumber":"191120102611272","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":2,"salesBuildTime":"2019-11-20 10:26:36","salesUpdateTime":"2019-11-20 10:26:46","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":157,"salesApiId":7,"userId":41,"orderNumber":"191120102518484","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-20 10:25:25","salesUpdateTime":"2019-11-20 10:25:34","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":156,"salesApiId":6,"userId":41,"orderNumber":"191120102424978","commodityPrice":0,"salesAmount":400000,"salesAmountMoney":4000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-20 10:24:18","salesUpdateTime":"2019-11-20 10:25:44","salesBuildTimeEnd":null,"userName":"南门屏","userPhone":"18898186027"}]
         */

        private CommodityBean commodity;
        private String amount;
        private List<OrderSalesListBean> orderSalesList;

        public CommodityBean getCommodity() {
            return commodity;
        }

        public void setCommodity(CommodityBean commodity) {
            this.commodity = commodity;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public List<OrderSalesListBean> getOrderSalesList() {
            return orderSalesList;
        }

        public void setOrderSalesList(List<OrderSalesListBean> orderSalesList) {
            this.orderSalesList = orderSalesList;
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
             * comPrice : 0.01
             * comImg : http://192.168.0.198:8082/profile/upload/2019/11/15/9213039ec18ea51f22b4ec4a7c35b856.jpg
             * comInventory : 730125231
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
        }

        public static class OrderSalesListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * salesId : 172
             * salesApiId : 22
             * userId : 41
             * orderNumber : 191120105772412
             * commodityPrice : 0
             * salesAmount : 100000
             * salesAmountMoney : 1000
             * parentSalesId : 0
             * orderPayTpe : 0
             * salesStatus : 2
             * salesBuildTime : 2019-11-20 10:57:25
             * salesUpdateTime : 2019-11-25 14:23:26
             * salesBuildTimeEnd : null
             * userName : 南门屏
             * userPhone : 18898186027
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private int salesId;
            private int salesApiId;
            private int userId;
            private String orderNumber;
            private int commodityPrice;
            private int salesAmount;
            private int salesAmountMoney;
            private int parentSalesId;
            private int orderPayTpe;
            private int salesStatus;
            private String salesBuildTime;
            private String salesUpdateTime;
            private Object salesBuildTimeEnd;
            private String userName;
            private String userPhone;

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

            public int getSalesId() {
                return salesId;
            }

            public void setSalesId(int salesId) {
                this.salesId = salesId;
            }

            public int getSalesApiId() {
                return salesApiId;
            }

            public void setSalesApiId(int salesApiId) {
                this.salesApiId = salesApiId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(int salesAmount) {
                this.salesAmount = salesAmount;
            }

            public int getSalesAmountMoney() {
                return salesAmountMoney;
            }

            public void setSalesAmountMoney(int salesAmountMoney) {
                this.salesAmountMoney = salesAmountMoney;
            }

            public int getParentSalesId() {
                return parentSalesId;
            }

            public void setParentSalesId(int parentSalesId) {
                this.parentSalesId = parentSalesId;
            }

            public int getOrderPayTpe() {
                return orderPayTpe;
            }

            public void setOrderPayTpe(int orderPayTpe) {
                this.orderPayTpe = orderPayTpe;
            }

            public int getSalesStatus() {
                return salesStatus;
            }

            public void setSalesStatus(int salesStatus) {
                this.salesStatus = salesStatus;
            }

            public String getSalesBuildTime() {
                return salesBuildTime;
            }

            public void setSalesBuildTime(String salesBuildTime) {
                this.salesBuildTime = salesBuildTime;
            }

            public String getSalesUpdateTime() {
                return salesUpdateTime;
            }

            public void setSalesUpdateTime(String salesUpdateTime) {
                this.salesUpdateTime = salesUpdateTime;
            }

            public Object getSalesBuildTimeEnd() {
                return salesBuildTimeEnd;
            }

            public void setSalesBuildTimeEnd(Object salesBuildTimeEnd) {
                this.salesBuildTimeEnd = salesBuildTimeEnd;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public static class ParamsBeanX {
            }

            @Override
            public String toString() {
                return "OrderSalesListBean{" +
                        "searchValue=" + searchValue +
                        ", createBy=" + createBy +
                        ", createTime=" + createTime +
                        ", updateBy=" + updateBy +
                        ", updateTime=" + updateTime +
                        ", remark=" + remark +
                        ", params=" + params +
                        ", salesId=" + salesId +
                        ", salesApiId=" + salesApiId +
                        ", userId=" + userId +
                        ", orderNumber='" + orderNumber + '\'' +
                        ", commodityPrice=" + commodityPrice +
                        ", salesAmount=" + salesAmount +
                        ", salesAmountMoney=" + salesAmountMoney +
                        ", parentSalesId=" + parentSalesId +
                        ", orderPayTpe=" + orderPayTpe +
                        ", salesStatus=" + salesStatus +
                        ", salesBuildTime='" + salesBuildTime + '\'' +
                        ", salesUpdateTime='" + salesUpdateTime + '\'' +
                        ", salesBuildTimeEnd=" + salesBuildTimeEnd +
                        ", userName='" + userName + '\'' +
                        ", userPhone='" + userPhone + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "commodity=" + commodity +
                    ", amount='" + amount + '\'' +
                    ", orderSalesList=" + orderSalesList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestCancel{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
