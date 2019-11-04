package com.administrator.yaya.bean.orderform;

import java.util.List;

//订单  已完成
public class TestFinish {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":null,"amount":null,"orderStockList":[]}
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
         * amount : null
         * orderStockList : []
         */

        private Object commodity;
        private Object amount;
        private List<?> orderStockList;

        public Object getCommodity() {
            return commodity;
        }

        public void setCommodity(Object commodity) {
            this.commodity = commodity;
        }

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public List<?> getOrderStockList() {
            return orderStockList;
        }

        public void setOrderStockList(List<?> orderStockList) {
            this.orderStockList = orderStockList;
        }
    }
}
