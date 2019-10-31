package com.administrator.yaya.bean.orderform;

/**
 * 提交订单(确认信息)
 */
public class TestToOrderStock {

    /**
     * msg : gathering
     * code : 0
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":"191031185863021","params":{},"gaId":2,"payeeName":"钱浩1","bankCard":"6217000110016543210","bankName":"中国银行","bankStatus":1,"comMoney":12300}
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
         * remark : 191031185863021
         * params : {}
         * gaId : 2
         * payeeName : 钱浩1
         * bankCard : 6217000110016543210
         * bankName : 中国银行
         * bankStatus : 1
         * comMoney : 12300
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private String remark;
        private ParamsBean params;
        private int gaId;
        private String payeeName;
        private String bankCard;
        private String bankName;
        private int bankStatus;
        private int comMoney;

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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getGaId() {
            return gaId;
        }

        public void setGaId(int gaId) {
            this.gaId = gaId;
        }

        public String getPayeeName() {
            return payeeName;
        }

        public void setPayeeName(String payeeName) {
            this.payeeName = payeeName;
        }

        public String getBankCard() {
            return bankCard;
        }

        public void setBankCard(String bankCard) {
            this.bankCard = bankCard;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public int getBankStatus() {
            return bankStatus;
        }

        public void setBankStatus(int bankStatus) {
            this.bankStatus = bankStatus;
        }

        public int getComMoney() {
            return comMoney;
        }

        public void setComMoney(int comMoney) {
            this.comMoney = comMoney;
        }

        public static class ParamsBean {
        }
    }
}
