package com.administrator.yaya.bean.my;
//我的收益 页面
import java.util.List;
public class TestMyEarnings {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"userInfo":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"userName":"钱浩龙","userNickName":"qhl","userHeadImg":"http://192.168.0.198:8080/profile/upload/2019/11/05/6988361266429a53278f92a2c44373ca.png","userPhone":"17631365666","userPwd":"1234","userProfit":8.0E-4,"userStatus":1,"userInvitationCode":"6666","userParentId":0,"userEarningsNow":2659,"userEarningsTotal":2782,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":1,"zfbButtonStatus":2,"parentUser":null,"juniorUsers":null,"junior":null},"userEarningsList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":1,"userId":1,"orderId":"123213124","salesAmount":2000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-10-30 10:29:37","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":2,"userId":1,"orderId":"123213123","salesAmount":1000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-10-30 10:31:39","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":3,"userId":1,"orderId":"123213124","salesAmount":2000,"earningsAmount":1,"earningsType":1,"earningsTime":"2019-10-30 10:33:33","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":4,"userId":1,"orderId":"123213123","salesAmount":10000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-10-30 10:37:13","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":5,"userId":1,"orderId":"123213124","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-10-30 10:38:12","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":6,"userId":1,"orderId":"123213123","salesAmount":10000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-01 13:42:12","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":7,"userId":1,"orderId":"191031103536063","salesAmount":10,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:00:53","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":8,"userId":1,"orderId":"191031103523194","salesAmount":2000000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:32:20","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":9,"userId":1,"orderId":"191031103548723","salesAmount":10,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:48:09","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":10,"userId":1,"orderId":"191101155555923","salesAmount":123,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:49:48","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":11,"userId":1,"orderId":"191104104825434","salesAmount":200,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:50:52","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":12,"userId":1,"orderId":"191104104825434","salesAmount":200000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:52:05","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":13,"userId":1,"orderId":"191104104825434","salesAmount":200000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:53:53","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":14,"userId":1,"orderId":"191104104825434","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-04 14:56:54","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":15,"userId":1,"orderId":"191104104825434","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-04 14:58:26","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":16,"userId":1,"orderId":"191104104823123","salesAmount":0,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-05 14:45:29","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":17,"userId":1,"orderId":"191105150248403","salesAmount":100000,"earningsAmount":80,"earningsType":1,"earningsTime":"2019-11-05 15:03:26","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":18,"userId":1,"orderId":"191105144684486","salesAmount":100000,"earningsAmount":80,"earningsType":1,"earningsTime":"2019-11-05 15:04:16","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":19,"userId":1,"orderId":"191104155371064","salesAmount":0,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-05 15:11:38","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":20,"userId":1,"orderId":"123213123","salesAmount":1000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-05 15:12:56","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":21,"userId":1,"orderId":"123213124","salesAmount":2000,"earningsAmount":1,"earningsType":1,"earningsTime":"2019-11-05 15:13:01","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":22,"userId":1,"orderId":"191104104823432","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 09:35:46","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":23,"userId":1,"orderId":"191104101381399","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 13:34:48","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":24,"userId":1,"orderId":"191104101381399","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 13:34:52","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":25,"userId":1,"orderId":"191104104823234","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 17:06:53","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":26,"userId":1,"orderId":"191107104156912","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 10:43:44","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":27,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:21:55","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":28,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:21:58","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":29,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:21:59","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":30,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:01","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":31,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:02","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":32,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:03","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":33,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:04","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":34,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:04","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":35,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:09","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":36,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:10","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":37,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:11","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":38,"userId":1,"orderId":"191107104538110","salesAmount":0,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-07 11:22:24","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":39,"userId":1,"orderId":"213213","salesAmount":2000,"earningsAmount":1,"earningsType":1,"earningsTime":"2019-11-07 18:46:55","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":40,"userId":1,"orderId":"123213","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 18:56:01","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":41,"userId":1,"orderId":"191107193344087","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-08 17:55:33","userName":"钱浩龙"}],"commodityName":"游戏币1"}
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
         * userInfo : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"userName":"钱浩龙","userNickName":"qhl","userHeadImg":"http://192.168.0.198:8080/profile/upload/2019/11/05/6988361266429a53278f92a2c44373ca.png","userPhone":"17631365666","userPwd":"1234","userProfit":8.0E-4,"userStatus":1,"userInvitationCode":"6666","userParentId":0,"userEarningsNow":2659,"userEarningsTotal":2782,"userContributeTotal":0,"zfbEd":0,"wxEd":0,"vxButtonStatus":1,"zfbButtonStatus":2,"parentUser":null,"juniorUsers":null,"junior":null}
         * userEarningsList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":1,"userId":1,"orderId":"123213124","salesAmount":2000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-10-30 10:29:37","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":2,"userId":1,"orderId":"123213123","salesAmount":1000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-10-30 10:31:39","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":3,"userId":1,"orderId":"123213124","salesAmount":2000,"earningsAmount":1,"earningsType":1,"earningsTime":"2019-10-30 10:33:33","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":4,"userId":1,"orderId":"123213123","salesAmount":10000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-10-30 10:37:13","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":5,"userId":1,"orderId":"123213124","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-10-30 10:38:12","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":6,"userId":1,"orderId":"123213123","salesAmount":10000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-01 13:42:12","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":7,"userId":1,"orderId":"191031103536063","salesAmount":10,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:00:53","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":8,"userId":1,"orderId":"191031103523194","salesAmount":2000000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:32:20","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":9,"userId":1,"orderId":"191031103548723","salesAmount":10,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:48:09","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":10,"userId":1,"orderId":"191101155555923","salesAmount":123,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:49:48","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":11,"userId":1,"orderId":"191104104825434","salesAmount":200,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:50:52","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":12,"userId":1,"orderId":"191104104825434","salesAmount":200000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:52:05","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":13,"userId":1,"orderId":"191104104825434","salesAmount":200000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-04 14:53:53","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":14,"userId":1,"orderId":"191104104825434","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-04 14:56:54","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":15,"userId":1,"orderId":"191104104825434","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-04 14:58:26","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":16,"userId":1,"orderId":"191104104823123","salesAmount":0,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-05 14:45:29","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":17,"userId":1,"orderId":"191105150248403","salesAmount":100000,"earningsAmount":80,"earningsType":1,"earningsTime":"2019-11-05 15:03:26","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":18,"userId":1,"orderId":"191105144684486","salesAmount":100000,"earningsAmount":80,"earningsType":1,"earningsTime":"2019-11-05 15:04:16","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":19,"userId":1,"orderId":"191104155371064","salesAmount":0,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-05 15:11:38","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":20,"userId":1,"orderId":"123213123","salesAmount":1000,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-05 15:12:56","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":21,"userId":1,"orderId":"123213124","salesAmount":2000,"earningsAmount":1,"earningsType":1,"earningsTime":"2019-11-05 15:13:01","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":22,"userId":1,"orderId":"191104104823432","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 09:35:46","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":23,"userId":1,"orderId":"191104101381399","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 13:34:48","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":24,"userId":1,"orderId":"191104101381399","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 13:34:52","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":25,"userId":1,"orderId":"191104104823234","salesAmount":20000,"earningsAmount":16,"earningsType":1,"earningsTime":"2019-11-06 17:06:53","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":26,"userId":1,"orderId":"191107104156912","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 10:43:44","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":27,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:21:55","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":28,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:21:58","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":29,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:21:59","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":30,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:01","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":31,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:02","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":32,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:03","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":33,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:04","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":34,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:04","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":35,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:09","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":36,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:10","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":37,"userId":1,"orderId":"191107104529207","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 11:22:11","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":38,"userId":1,"orderId":"191107104538110","salesAmount":0,"earningsAmount":0,"earningsType":1,"earningsTime":"2019-11-07 11:22:24","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":39,"userId":1,"orderId":"213213","salesAmount":2000,"earningsAmount":1,"earningsType":1,"earningsTime":"2019-11-07 18:46:55","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":40,"userId":1,"orderId":"123213","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-07 18:56:01","userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"earningsId":41,"userId":1,"orderId":"191107193344087","salesAmount":200000,"earningsAmount":160,"earningsType":1,"earningsTime":"2019-11-08 17:55:33","userName":"钱浩龙"}]
         * commodityName : 游戏币1
         */

        private UserInfoBean userInfo;
        private String commodityName;
        private List<UserEarningsListBean> userEarningsList;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public List<UserEarningsListBean> getUserEarningsList() {
            return userEarningsList;
        }

        public void setUserEarningsList(List<UserEarningsListBean> userEarningsList) {
            this.userEarningsList = userEarningsList;
        }

        public static class UserInfoBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * userId : 1
             * userName : 钱浩龙
             * userNickName : qhl
             * userHeadImg : http://192.168.0.198:8080/profile/upload/2019/11/05/6988361266429a53278f92a2c44373ca.png
             * userPhone : 17631365666
             * userPwd : 1234
             * userProfit : 8.0E-4
             * userStatus : 1
             * userInvitationCode : 6666
             * userParentId : 0
             * userEarningsNow : 2659
             * userEarningsTotal : 2782
             * userContributeTotal : 0
             * zfbEd : 0
             * wxEd : 0
             * vxButtonStatus : 1
             * zfbButtonStatus : 2
             * parentUser : null
             * juniorUsers : null
             * junior : null
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private int userId;
            private String userName;
            private String userNickName;
            private String userHeadImg;
            private String userPhone;
            private String userPwd;
            private double userProfit;
            private int userStatus;
            private String userInvitationCode;
            private int userParentId;
            private int userEarningsNow;
            private int userEarningsTotal;
            private int userContributeTotal;
            private int zfbEd;
            private int wxEd;
            private int vxButtonStatus;
            private int zfbButtonStatus;
            private Object parentUser;
            private Object juniorUsers;
            private Object junior;

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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getUserHeadImg() {
                return userHeadImg;
            }

            public void setUserHeadImg(String userHeadImg) {
                this.userHeadImg = userHeadImg;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserPwd() {
                return userPwd;
            }

            public void setUserPwd(String userPwd) {
                this.userPwd = userPwd;
            }

            public double getUserProfit() {
                return userProfit;
            }

            public void setUserProfit(double userProfit) {
                this.userProfit = userProfit;
            }

            public int getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(int userStatus) {
                this.userStatus = userStatus;
            }

            public String getUserInvitationCode() {
                return userInvitationCode;
            }

            public void setUserInvitationCode(String userInvitationCode) {
                this.userInvitationCode = userInvitationCode;
            }

            public int getUserParentId() {
                return userParentId;
            }

            public void setUserParentId(int userParentId) {
                this.userParentId = userParentId;
            }

            public int getUserEarningsNow() {
                return userEarningsNow;
            }

            public void setUserEarningsNow(int userEarningsNow) {
                this.userEarningsNow = userEarningsNow;
            }

            public int getUserEarningsTotal() {
                return userEarningsTotal;
            }

            public void setUserEarningsTotal(int userEarningsTotal) {
                this.userEarningsTotal = userEarningsTotal;
            }

            public int getUserContributeTotal() {
                return userContributeTotal;
            }

            public void setUserContributeTotal(int userContributeTotal) {
                this.userContributeTotal = userContributeTotal;
            }

            public int getZfbEd() {
                return zfbEd;
            }

            public void setZfbEd(int zfbEd) {
                this.zfbEd = zfbEd;
            }

            public int getWxEd() {
                return wxEd;
            }

            public void setWxEd(int wxEd) {
                this.wxEd = wxEd;
            }

            public int getVxButtonStatus() {
                return vxButtonStatus;
            }

            public void setVxButtonStatus(int vxButtonStatus) {
                this.vxButtonStatus = vxButtonStatus;
            }

            public int getZfbButtonStatus() {
                return zfbButtonStatus;
            }

            public void setZfbButtonStatus(int zfbButtonStatus) {
                this.zfbButtonStatus = zfbButtonStatus;
            }

            public Object getParentUser() {
                return parentUser;
            }

            public void setParentUser(Object parentUser) {
                this.parentUser = parentUser;
            }

            public Object getJuniorUsers() {
                return juniorUsers;
            }

            public void setJuniorUsers(Object juniorUsers) {
                this.juniorUsers = juniorUsers;
            }

            public Object getJunior() {
                return junior;
            }

            public void setJunior(Object junior) {
                this.junior = junior;
            }

            public static class ParamsBean {
            }
        }

        public static class UserEarningsListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * earningsId : 1
             * userId : 1
             * orderId : 123213124
             * salesAmount : 2000
             * earningsAmount : 0
             * earningsType : 1
             * earningsTime : 2019-10-30 10:29:37
             * userName : 钱浩龙
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private int earningsId;
            private int userId;
            private String orderId;
            private double salesAmount;
            private int earningsAmount;
            private int earningsType;
            private String earningsTime;
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

            public ParamsBeanX getParams() {
                return params;
            }

            public void setParams(ParamsBeanX params) {
                this.params = params;
            }

            public int getEarningsId() {
                return earningsId;
            }

            public void setEarningsId(int earningsId) {
                this.earningsId = earningsId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public double getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(double salesAmount) {
                this.salesAmount = salesAmount;
            }

            public int getEarningsAmount() {
                return earningsAmount;
            }

            public void setEarningsAmount(int earningsAmount) {
                this.earningsAmount = earningsAmount;
            }

            public int getEarningsType() {
                return earningsType;
            }

            public void setEarningsType(int earningsType) {
                this.earningsType = earningsType;
            }

            public String getEarningsTime() {
                return earningsTime;
            }

            public void setEarningsTime(String earningsTime) {
                this.earningsTime = earningsTime;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public static class ParamsBeanX {
            }
        }
    }
}
