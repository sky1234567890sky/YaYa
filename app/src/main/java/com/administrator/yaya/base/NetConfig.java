package com.administrator.yaya.base;
//主机路经
public class NetConfig {
    //http://192.168.0.198:8080/yayaApp/appLogin

    public static String BaseUrl;

    public static int API_TYPE = 1;//1:正式服务器 2：外测服务器 3：内测服务器

    public static String DQD_BASE1 = "http://sport-data.dqdgame.com/";

    static {//http://103.251.91.21:8080/yaya/
        //http://103.251.91.21:8080/yaya/login

        if (API_TYPE == 1) BaseUrl = "http://103.251.91.21:8080/yaya/yayaApp/";

        else if (API_TYPE == 2) BaseUrl = "http://192.168.0.198:8082/yayaApp/";

        else BaseUrl = "";
    }
}
