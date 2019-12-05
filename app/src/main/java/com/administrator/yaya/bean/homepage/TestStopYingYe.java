package com.administrator.yaya.bean.homepage;
//停止营业
public class TestStopYingYe {


    /**
     * msg : 歇业成功
     * code : 0
     */

    private String msg;
    private int code;
    private  int data;

    public String getMsg() {
        return msg;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
}
