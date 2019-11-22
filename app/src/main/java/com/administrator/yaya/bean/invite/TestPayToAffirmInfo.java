package com.administrator.yaya.bean.invite;

/**
 * //从库存付款信息跳到确认信息解析 实体类  (付款信息)
 * 对应的是 待付款里的 付款信息
 */
public class TestPayToAffirmInfo {
    /**
     * msg : gathering
     * code : 0
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":"191031103526146","params":{},"gaId":2,"payeeName":"钱浩1","bankCard":"6217000110016543210","bankName":"中国银行","bankStatus":1,"comMoney":10000}
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
         * remark : 191031103526146
         * params : {}
         * gaId : 2
         * payeeName : 钱浩1
         * bankCard : 6217000110016543210
         * bankName : 中国银行
         * bankStatus : 1
         * comMoney : 10000
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
        private double comMoney;

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

        public double getComMoney() {
            return comMoney;
        }

        public void setComMoney(int comMoney) {
            this.comMoney = comMoney;
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
                    ", remark='" + remark + '\'' +
                    ", params=" + params +
                    ", gaId=" + gaId +
                    ", payeeName='" + payeeName + '\'' +
                    ", bankCard='" + bankCard + '\'' +
                    ", bankName='" + bankName + '\'' +
                    ", bankStatus=" + bankStatus +
                    ", comMoney=" + comMoney +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestPayToAffirmInfo{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
