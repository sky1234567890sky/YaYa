package com.administrator.yaya.bean.orderform;

import java.util.List;
//所有售賣訂單  售卖中
public class TestAllOrderStock {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":100,"comImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg","comInventory":9999876,"comPurchaseNumMin":100,"comPurchaseNumMax":10000,"comExplain":"这是个游戏币1"},"amount":"20000","orderSalesList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":31,"userId":1,"orderNumber":"191105150586311","commodityPrice":0,"salesAmount":null,"salesAmountMoney":0,"parentSalesId":0,"orderPayTpe":0,"salesStatus":1,"salesBuildTime":"2019-11-06 10:38:52","salesUpdateTime":null,"salesBuildTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":3,"userId":1,"orderNumber":"191104101381399","commodityPrice":0,"salesAmount":20000,"salesAmountMoney":0,"parentSalesId":0,"orderPayTpe":0,"salesStatus":1,"salesBuildTime":"2019-11-04 10:15:11","salesUpdateTime":null,"salesBuildTimeEnd":null,"userName":"钱浩龙"}]}
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
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":100,"comImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg","comInventory":9999876,"comPurchaseNumMin":100,"comPurchaseNumMax":10000,"comExplain":"这是个游戏币1"}
         * amount : 20000
         * orderSalesList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":31,"userId":1,"orderNumber":"191105150586311","commodityPrice":0,"salesAmount":null,"salesAmountMoney":0,"parentSalesId":0,"orderPayTpe":0,"salesStatus":1,"salesBuildTime":"2019-11-06 10:38:52","salesUpdateTime":null,"salesBuildTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"salesId":3,"userId":1,"orderNumber":"191104101381399","commodityPrice":0,"salesAmount":20000,"salesAmountMoney":0,"parentSalesId":0,"orderPayTpe":0,"salesStatus":1,"salesBuildTime":"2019-11-04 10:15:11","salesUpdateTime":null,"salesBuildTimeEnd":null,"userName":"钱浩龙"}]
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
             * comPrice : 100
             * comImg : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg
             * comInventory : 9999876
             * comPurchaseNumMin : 100
             * comPurchaseNumMax : 10000
             * comExplain : 这是个游戏币1
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
             * salesId : 31
             * userId : 1
             * orderNumber : 191105150586311
             * commodityPrice : 0
             * salesAmount : null
             * salesAmountMoney : 0
             * parentSalesId : 0
             * orderPayTpe : 0
             * salesStatus : 1
             * salesBuildTime : 2019-11-06 10:38:52
             * salesUpdateTime : null
             * salesBuildTimeEnd : null
             * userName : 钱浩龙
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
            private int commodityPrice;
            private Object salesAmount;
            private int salesAmountMoney;
            private int parentSalesId;
            private int orderPayTpe;
            private int salesStatus;
            private String salesBuildTime;
            private Object salesUpdateTime;
            private Object salesBuildTimeEnd;
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

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public Object getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(Object salesAmount) {
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

            public Object getSalesUpdateTime() {
                return salesUpdateTime;
            }

            public void setSalesUpdateTime(Object salesUpdateTime) {
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
                        ", userId=" + userId +
                        ", orderNumber='" + orderNumber + '\'' +
                        ", commodityPrice=" + commodityPrice +
                        ", salesAmount=" + salesAmount +
                        ", salesAmountMoney=" + salesAmountMoney +
                        ", parentSalesId=" + parentSalesId +
                        ", orderPayTpe=" + orderPayTpe +
                        ", salesStatus=" + salesStatus +
                        ", salesBuildTime='" + salesBuildTime + '\'' +
                        ", salesUpdateTime=" + salesUpdateTime +
                        ", salesBuildTimeEnd=" + salesBuildTimeEnd +
                        ", userName='" + userName + '\'' +
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
        return "TestAllOrderStock{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
