package com.administrator.yaya.bean.invite;

import java.util.List;

/**
 * 已付款
 */
public class TestAccountPaid {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币1","comPrice":0.01,"comImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg","comInventory":9941350,"comPurchaseNumMin":10000,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"},"amount":"2010000","orderStockList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":126,"orderNumber":"191107190485029","userId":1,"payeeName":"丫丫官方","payeeBankCard":"6217000110016543210","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"基金会","commodityAmount":10000,"commoditySurplusAmount":null,"commodityPrice":100,"orderStatus":2,"orderRemark":"XJLUEY","orderBuildTime":"2019-11-07 19:04:45","orderAuditTime":"2019-11-07 19:06:51","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":1,"orderNumber":"1231","userId":1,"payeeName":"我","payeeBankCard":"123","payeeBankName":"123","orderPayTpe":1213,"payerName":"123","commodityAmount":2000000,"commoditySurplusAmount":20000,"commodityPrice":20000,"orderStatus":2,"orderRemark":"213","orderBuildTime":"2019-11-07 13:25:03","orderAuditTime":"2019-11-07 18:54:58","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"}]}
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
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币1","comPrice":0.01,"comImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg","comInventory":9941350,"comPurchaseNumMin":10000,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"}
         * amount : 2010000
         * orderStockList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":126,"orderNumber":"191107190485029","userId":1,"payeeName":"丫丫官方","payeeBankCard":"6217000110016543210","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"基金会","commodityAmount":10000,"commoditySurplusAmount":null,"commodityPrice":100,"orderStatus":2,"orderRemark":"XJLUEY","orderBuildTime":"2019-11-07 19:04:45","orderAuditTime":"2019-11-07 19:06:51","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":1,"orderNumber":"1231","userId":1,"payeeName":"我","payeeBankCard":"123","payeeBankName":"123","orderPayTpe":1213,"payerName":"123","commodityAmount":2000000,"commoditySurplusAmount":20000,"commodityPrice":20000,"orderStatus":2,"orderRemark":"213","orderBuildTime":"2019-11-07 13:25:03","orderAuditTime":"2019-11-07 18:54:58","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"}]
         */

        private CommodityBean commodity;
        private String amount;
        private List<OrderStockListBean> orderStockList;

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

        public List<OrderStockListBean> getOrderStockList() {
            return orderStockList;
        }

        public void setOrderStockList(List<OrderStockListBean> orderStockList) {
            this.orderStockList = orderStockList;
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
             * comName : 游戏币1
             * comPrice : 0.01
             * comImg : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571734627769&di=e828da538ddc42ad82a247555f264e35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F72%2F75%2F58b43c2649ae4_610.jpg
             * comInventory : 9941350
             * comPurchaseNumMin : 10000
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

        public static class OrderStockListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * stockId : 126
             * orderNumber : 191107190485029
             * userId : 1
             * payeeName : 丫丫官方
             * payeeBankCard : 6217000110016543210
             * payeeBankName : 中国银行
             * orderPayTpe : 1
             * payerName : 基金会
             * commodityAmount : 10000
             * commoditySurplusAmount : null
             * commodityPrice : 100
             * orderStatus : 2
             * orderRemark : XJLUEY
             * orderBuildTime : 2019-11-07 19:04:45
             * orderAuditTime : 2019-11-07 19:06:51
             * orderBuildTimeEnd : null
             * orderAuditTimeEnd : null
             * userName : 钱浩龙
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private int stockId;
            private String orderNumber;
            private int userId;
            private String payeeName;
            private String payeeBankCard;
            private String payeeBankName;
            private int orderPayTpe;
            private String payerName;
            private int commodityAmount;
            private Object commoditySurplusAmount;
            private Double commodityPrice;
            private int orderStatus;
            private String orderRemark;
            private String orderBuildTime;
            private String orderAuditTime;
            private Object orderBuildTimeEnd;
            private Object orderAuditTimeEnd;
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

            public int getStockId() {
                return stockId;
            }

            public void setStockId(int stockId) {
                this.stockId = stockId;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getPayeeName() {
                return payeeName;
            }

            public void setPayeeName(String payeeName) {
                this.payeeName = payeeName;
            }

            public String getPayeeBankCard() {
                return payeeBankCard;
            }

            public void setPayeeBankCard(String payeeBankCard) {
                this.payeeBankCard = payeeBankCard;
            }

            public String getPayeeBankName() {
                return payeeBankName;
            }

            public void setPayeeBankName(String payeeBankName) {
                this.payeeBankName = payeeBankName;
            }

            public int getOrderPayTpe() {
                return orderPayTpe;
            }

            public void setOrderPayTpe(int orderPayTpe) {
                this.orderPayTpe = orderPayTpe;
            }

            public String getPayerName() {
                return payerName;
            }

            public void setPayerName(String payerName) {
                this.payerName = payerName;
            }

            public int getCommodityAmount() {
                return commodityAmount;
            }

            public void setCommodityAmount(int commodityAmount) {
                this.commodityAmount = commodityAmount;
            }

            public Object getCommoditySurplusAmount() {
                return commoditySurplusAmount;
            }

            public void setCommoditySurplusAmount(Object commoditySurplusAmount) {
                this.commoditySurplusAmount = commoditySurplusAmount;
            }

            public Double getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(Double commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getOrderRemark() {
                return orderRemark;
            }

            public void setOrderRemark(String orderRemark) {
                this.orderRemark = orderRemark;
            }

            public String getOrderBuildTime() {
                return orderBuildTime;
            }

            public void setOrderBuildTime(String orderBuildTime) {
                this.orderBuildTime = orderBuildTime;
            }

            public String getOrderAuditTime() {
                return orderAuditTime;
            }

            public void setOrderAuditTime(String orderAuditTime) {
                this.orderAuditTime = orderAuditTime;
            }

            public Object getOrderBuildTimeEnd() {
                return orderBuildTimeEnd;
            }

            public void setOrderBuildTimeEnd(Object orderBuildTimeEnd) {
                this.orderBuildTimeEnd = orderBuildTimeEnd;
            }

            public Object getOrderAuditTimeEnd() {
                return orderAuditTimeEnd;
            }

            public void setOrderAuditTimeEnd(Object orderAuditTimeEnd) {
                this.orderAuditTimeEnd = orderAuditTimeEnd;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public static class ParamsBeanX {
            }
        }
    }
}
