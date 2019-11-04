package com.administrator.yaya.bean.invite;

import java.util.List;

/**
 * 已付款
 */
public class TestAccountPaid {
    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":null,"amount":"3020","orderStockList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":1,"orderNumber":"123213123","userId":1,"payeeName":"钱","payeeBankCard":"123213213123123","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"小明","commodityAmount":1000,"commoditySurplusAmount":1000,"commodityPrice":10,"orderStatus":2,"orderRemark":"这是备注","orderBuildTime":"2019-10-24 00:00:00","orderAuditTime":"2019-10-30 10:47:49","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":2,"orderNumber":"123213124","userId":1,"payeeName":"qa","payeeBankCard":"123213213123123","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"明","commodityAmount":2000,"commoditySurplusAmount":2000,"commodityPrice":20,"orderStatus":2,"orderRemark":null,"orderBuildTime":"2019-10-23 13:33:40","orderAuditTime":"2019-10-30 15:08:19","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":3,"orderNumber":"191031103523194","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":2,"orderRemark":"191031103539359","orderBuildTime":"2019-10-31 10:35:30","orderAuditTime":"2019-10-31 17:48:52","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":4,"orderNumber":"191031103548723","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":1000,"orderStatus":2,"orderRemark":"191031103527832","orderBuildTime":"2019-10-31 10:35:43","orderAuditTime":"2019-11-01 13:32:28","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"}]}
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
         * commodity : null
         * amount : 3020
         * orderStockList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":1,"orderNumber":"123213123","userId":1,"payeeName":"钱","payeeBankCard":"123213213123123","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"小明","commodityAmount":1000,"commoditySurplusAmount":1000,"commodityPrice":10,"orderStatus":2,"orderRemark":"这是备注","orderBuildTime":"2019-10-24 00:00:00","orderAuditTime":"2019-10-30 10:47:49","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":2,"orderNumber":"123213124","userId":1,"payeeName":"qa","payeeBankCard":"123213213123123","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"明","commodityAmount":2000,"commoditySurplusAmount":2000,"commodityPrice":20,"orderStatus":2,"orderRemark":null,"orderBuildTime":"2019-10-23 13:33:40","orderAuditTime":"2019-10-30 15:08:19","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":3,"orderNumber":"191031103523194","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":2,"orderRemark":"191031103539359","orderBuildTime":"2019-10-31 10:35:30","orderAuditTime":"2019-10-31 17:48:52","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":4,"orderNumber":"191031103548723","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":1000,"orderStatus":2,"orderRemark":"191031103527832","orderBuildTime":"2019-10-31 10:35:43","orderAuditTime":"2019-11-01 13:32:28","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"}]
         */

        private Object commodity;
        private String amount;
        private List<OrderStockListBean> orderStockList;

        public Object getCommodity() {
            return commodity;
        }

        public void setCommodity(Object commodity) {
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

        public static class OrderStockListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * stockId : 1
             * orderNumber : 123213123
             * userId : 1
             * payeeName : 钱
             * payeeBankCard : 123213213123123
             * payeeBankName : 中国银行
             * orderPayTpe : 1
             * payerName : 小明
             * commodityAmount : 1000
             * commoditySurplusAmount : 1000
             * commodityPrice : 10
             * orderStatus : 2
             * orderRemark : 这是备注
             * orderBuildTime : 2019-10-24 00:00:00
             * orderAuditTime : 2019-10-30 10:47:49
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
            private ParamsBean params;
            private int stockId;
            private String orderNumber;
            private int userId;
            private String payeeName;
            private String payeeBankCard;
            private String payeeBankName;
            private int orderPayTpe;
            private String payerName;
            private int commodityAmount;
            private int commoditySurplusAmount;
            private int commodityPrice;
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

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
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

            public int getCommoditySurplusAmount() {
                return commoditySurplusAmount;
            }

            public void setCommoditySurplusAmount(int commoditySurplusAmount) {
                this.commoditySurplusAmount = commoditySurplusAmount;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
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

            public static class ParamsBean {
            }

            @Override
            public String toString() {
                return "OrderStockListBean{" +
                        "searchValue=" + searchValue +
                        ", createBy=" + createBy +
                        ", createTime=" + createTime +
                        ", updateBy=" + updateBy +
                        ", updateTime=" + updateTime +
                        ", remark=" + remark +
                        ", params=" + params +
                        ", stockId=" + stockId +
                        ", orderNumber='" + orderNumber + '\'' +
                        ", userId=" + userId +
                        ", payeeName='" + payeeName + '\'' +
                        ", payeeBankCard='" + payeeBankCard + '\'' +
                        ", payeeBankName='" + payeeBankName + '\'' +
                        ", orderPayTpe=" + orderPayTpe +
                        ", payerName='" + payerName + '\'' +
                        ", commodityAmount=" + commodityAmount +
                        ", commoditySurplusAmount=" + commoditySurplusAmount +
                        ", commodityPrice=" + commodityPrice +
                        ", orderStatus=" + orderStatus +
                        ", orderRemark='" + orderRemark + '\'' +
                        ", orderBuildTime='" + orderBuildTime + '\'' +
                        ", orderAuditTime='" + orderAuditTime + '\'' +
                        ", orderBuildTimeEnd=" + orderBuildTimeEnd +
                        ", orderAuditTimeEnd=" + orderAuditTimeEnd +
                        ", userName='" + userName + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "commodity=" + commodity +
                    ", amount='" + amount + '\'' +
                    ", orderStockList=" + orderStockList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestAccountPaid{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}