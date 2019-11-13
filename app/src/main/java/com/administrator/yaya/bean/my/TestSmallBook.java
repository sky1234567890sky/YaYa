package com.administrator.yaya.bean.my;
//我的小账本
public class TestSmallBook {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"userId":null,"moneyToday":69906.84,"moneyHistory":69906.84,"moneyWxToday":0,"moneyWxHistory":0,"moneyZfbToday":0,"moneyZfbHistory":0}
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
         * userId : null
         * moneyToday : 69906.84
         * moneyHistory : 69906.84
         * moneyWxToday : 0
         * moneyWxHistory : 0
         * moneyZfbToday : 0
         * moneyZfbHistory : 0
         */

        private Object userId;
        private double moneyToday;
        private double moneyHistory;
        private int moneyWxToday;
        private int moneyWxHistory;
        private int moneyZfbToday;
        private int moneyZfbHistory;

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public double getMoneyToday() {
            return moneyToday;
        }

        public void setMoneyToday(double moneyToday) {
            this.moneyToday = moneyToday;
        }

        public double getMoneyHistory() {
            return moneyHistory;
        }

        public void setMoneyHistory(double moneyHistory) {
            this.moneyHistory = moneyHistory;
        }

        public int getMoneyWxToday() {
            return moneyWxToday;
        }

        public void setMoneyWxToday(int moneyWxToday) {
            this.moneyWxToday = moneyWxToday;
        }

        public int getMoneyWxHistory() {
            return moneyWxHistory;
        }

        public void setMoneyWxHistory(int moneyWxHistory) {
            this.moneyWxHistory = moneyWxHistory;
        }

        public int getMoneyZfbToday() {
            return moneyZfbToday;
        }

        public void setMoneyZfbToday(int moneyZfbToday) {
            this.moneyZfbToday = moneyZfbToday;
        }

        public int getMoneyZfbHistory() {
            return moneyZfbHistory;
        }

        public void setMoneyZfbHistory(int moneyZfbHistory) {
            this.moneyZfbHistory = moneyZfbHistory;
        }
    }
}
