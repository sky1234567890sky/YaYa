package com.administrator.yaya.bean.invite;

import java.io.Serializable;
import java.util.List;

//库存（新）
public class TestInventory implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":0.01,"comImg":"http://192.168.0.198:8082/profile/upload/2019/11/15/9213039ec18ea51f22b4ec4a7c35b856.jpg","comInventory":731649290,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"},"userAllCount":0,"userSalesCount":2500000,"userDoneCount":0,"orderStockList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":369,"orderNumber":"191120103171370","userId":41,"payeeName":"丫丫官方","payeeBankCard":"6217000110016543210","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"摇一摇","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":1,"orderStatus":1,"orderRemark":"T47OZS","orderBuildTime":"2019-11-20 10:31:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":null,"userPhone":null}]}
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
         * commodity : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"comId":1,"comName":"游戏币","comPrice":0.01,"comImg":"http://192.168.0.198:8082/profile/upload/2019/11/15/9213039ec18ea51f22b4ec4a7c35b856.jpg","comInventory":731649290,"comPurchaseNumMin":100,"comPurchaseNumMax":10000000,"comExplain":"这是个游戏币"}
         * userAllCount : 0
         * userSalesCount : 2500000
         * userDoneCount : 0
         * orderStockList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":369,"orderNumber":"191120103171370","userId":41,"payeeName":"丫丫官方","payeeBankCard":"6217000110016543210","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"摇一摇","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":1,"orderStatus":1,"orderRemark":"T47OZS","orderBuildTime":"2019-11-20 10:31:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":null,"userPhone":null}]
         */

        private CommodityBean commodity;
        private int userAllCount;
        private int userSalesCount;
        private int userDoneCount;
        private List<OrderStockListBean> orderStockList;

        public CommodityBean getCommodity() {
            return commodity;
        }

        public void setCommodity(CommodityBean commodity) {
            this.commodity = commodity;
        }

        public int getUserAllCount() {
            return userAllCount;
        }

        public void setUserAllCount(int userAllCount) {
            this.userAllCount = userAllCount;
        }

        public int getUserSalesCount() {
            return userSalesCount;
        }

        public void setUserSalesCount(int userSalesCount) {
            this.userSalesCount = userSalesCount;
        }

        public int getUserDoneCount() {
            return userDoneCount;
        }

        public void setUserDoneCount(int userDoneCount) {
            this.userDoneCount = userDoneCount;
        }

        public List<OrderStockListBean> getOrderStockList() {
            return orderStockList;
        }

        public void setOrderStockList(List<OrderStockListBean> orderStockList) {
            this.orderStockList = orderStockList;
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
             * comName : 游戏币
             * comPrice : 0.01
             * comImg : http://192.168.0.198:8082/profile/upload/2019/11/15/9213039ec18ea51f22b4ec4a7c35b856.jpg
             * comInventory : 731649290
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

        public static class OrderStockListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * stockId : 369
             * orderNumber : 191120103171370
             * userId : 41
             * payeeName : 丫丫官方
             * payeeBankCard : 6217000110016543210
             * payeeBankName : 中国银行
             * orderPayTpe : 1
             * payerName : 摇一摇
             * commodityAmount : 100
             * commoditySurplusAmount : null
             * commodityPrice : 1
             * orderStatus : 1
             * orderRemark : T47OZS
             * orderBuildTime : 2019-11-20 10:31:48
             * orderAuditTime : null
             * orderBuildTimeEnd : null
             * orderAuditTimeEnd : null
             * userName : null
             * userPhone : null
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
            private double commodityPrice;
            private int orderStatus;
            private String orderRemark;
            private String orderBuildTime;
            private Object orderAuditTime;
            private Object orderBuildTimeEnd;
            private Object orderAuditTimeEnd;
            private Object userName;
            private Object userPhone;

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

            public double getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(double commodityPrice) {
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

            public Object getOrderAuditTime() {
                return orderAuditTime;
            }

            public void setOrderAuditTime(Object orderAuditTime) {
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

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(Object userPhone) {
                this.userPhone = userPhone;
            }

            public static class ParamsBeanX {
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
                        ", orderAuditTime=" + orderAuditTime +
                        ", orderBuildTimeEnd=" + orderBuildTimeEnd +
                        ", orderAuditTimeEnd=" + orderAuditTimeEnd +
                        ", userName=" + userName +
                        ", userPhone=" + userPhone +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "commodity=" + commodity +
                    ", userAllCount=" + userAllCount +
                    ", userSalesCount=" + userSalesCount +
                    ", userDoneCount=" + userDoneCount +
                    ", orderStockList=" + orderStockList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestInventory{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
