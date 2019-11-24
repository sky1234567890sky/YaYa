package com.administrator.yaya.bean.orderform;

import java.io.Serializable;
import java.util.List;

//已取消
public class TestCancel implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币1","comPrice":0.01,"comImg":"http://localhost:8082/profile/upload/2019/11/08/ec5f5e6db7d4c29b0f218f6a2ac915e2.jpg","comInventory":9939354,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"},"amount":null,"orderSalesList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":1,"userId":1,"orderNumber":"213213","commodityPrice":0.01,"salesAmount":19000000,"salesAmountMoney":190000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-07 13:24:16","salesUpdateTime":"2019-11-08 10:46:34","salesBuildTimeEnd":null,"userName":"钱浩龙","userPhone":"17631365666"}]}
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

    public static class DataBean implements Serializable{
        /**
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币1","comPrice":0.01,"comImg":"http://localhost:8082/profile/upload/2019/11/08/ec5f5e6db7d4c29b0f218f6a2ac915e2.jpg","comInventory":9939354,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"}
         * amount : null
         * orderSalesList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":1,"userId":1,"orderNumber":"213213","commodityPrice":0.01,"salesAmount":19000000,"salesAmountMoney":190000,"parentSalesId":0,"orderPayTpe":0,"salesStatus":3,"salesBuildTime":"2019-11-07 13:24:16","salesUpdateTime":"2019-11-08 10:46:34","salesBuildTimeEnd":null,"userName":"钱浩龙","userPhone":"17631365666"}]
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

        public static class CommodityBean implements Serializable{
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * comId : 1
             * comName : 游戏币1
             * comPrice : 0.01
             * comImg : http://localhost:8082/profile/upload/2019/11/08/ec5f5e6db7d4c29b0f218f6a2ac915e2.jpg
             * comInventory : 9939354
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

            public static class ParamsBean implements Serializable{
            }
        }

        public static class OrderSalesListBean implements Serializable{
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * salesId : 1
             * userId : 1
             * orderNumber : 213213
             * commodityPrice : 0.01
             * salesAmount : 19000000
             * salesAmountMoney : 190000
             * parentSalesId : 0
             * orderPayTpe : 0
             * salesStatus : 3
             * salesBuildTime : 2019-11-07 13:24:16
             * salesUpdateTime : 2019-11-08 10:46:34
             * salesBuildTimeEnd : null
             * userName : 钱浩龙
             * userPhone : 17631365666
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private int salesId;
            private int userId;
            private String orderNumber;
            private double commodityPrice;
            private int salesAmount;
            private double salesAmountMoney;
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

            public double getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(double commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(int salesAmount) {
                this.salesAmount = salesAmount;
            }

            public double getSalesAmountMoney() {
                return salesAmountMoney;
            }

            public void setSalesAmountMoney(double salesAmountMoney) {
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

            public static class ParamsBeanX implements Serializable{
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
