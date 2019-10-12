package com.administrator.yaya.bean;

public class LoginInfo {
    public String headPath;
    public String token;
    public String msg;
    public String nick;

    public LoginInfo(String pHeadPath, String pToken, String pMsg,String nick) {
        headPath = pHeadPath;
        token = pToken;
        msg = pMsg;
        this.nick = nick;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
