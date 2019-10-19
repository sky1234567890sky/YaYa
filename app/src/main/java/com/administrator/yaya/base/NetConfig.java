package com.administrator.yaya.base;
//主机路经
public class NetConfig {
    //http://192.168.0.198:8080/yayaApp/appLogin
    public static String BaseUrl;
    public static int API_TYPE = 3;//1:正式服务器 2：外测服务器 3：内测服务器

    public static String DQD_BASE1 = "http://sport-data.dqdgame.com/";
    static {
        if (API_TYPE == 1) BaseUrl = "";
        else if (API_TYPE == 2) BaseUrl = "";
        else BaseUrl = "http://192.168.0.198:8080/";
    }
}
