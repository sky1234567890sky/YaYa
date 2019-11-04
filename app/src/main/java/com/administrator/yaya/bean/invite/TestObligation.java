package com.administrator.yaya.bean.invite;

import java.util.List;

/**
 * 待付款
 */
public class TestObligation {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"commodity":null,"amount":"3010","orderStockList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":4,"orderNumber":"191031103548723","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":1000,"orderStatus":1,"orderRemark":"191031103527832","orderBuildTime":"2019-10-31 10:35:43","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":5,"orderNumber":"191031103536063","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":1,"orderRemark":"191031103526146","orderBuildTime":"2019-10-31 10:35:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":6,"orderNumber":"191031131998091","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":1,"orderRemark":"191031131977774","orderBuildTime":"2019-10-31 13:19:04","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":7,"orderNumber":"191031161754226","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"反反复复","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":153873,"orderStatus":1,"orderRemark":"191031161736620","orderBuildTime":"2019-10-31 16:17:18","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":8,"orderNumber":"191031161996544","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":151782,"orderStatus":1,"orderRemark":"191031161939832","orderBuildTime":"2019-10-31 16:19:49","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":9,"orderNumber":"191031162033616","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":592614,"orderStatus":1,"orderRemark":"191031162042711","orderBuildTime":"2019-10-31 16:20:12","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":10,"orderNumber":"191031162183058","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031162143801","orderBuildTime":"2019-10-31 16:21:30","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":11,"orderNumber":"191031162185267","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031162155892","orderBuildTime":"2019-10-31 16:21:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":12,"orderNumber":"191031162599968","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031162571383","orderBuildTime":"2019-10-31 16:25:14","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":13,"orderNumber":"191031162790280","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":151782,"orderStatus":1,"orderRemark":"191031162765133","orderBuildTime":"2019-10-31 16:27:50","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":14,"orderNumber":"191031164597415","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":1,"orderRemark":"191031164539422","orderBuildTime":"2019-10-31 16:45:33","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":15,"orderNumber":"191031174534319","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":123000,"orderStatus":1,"orderRemark":"191031174563924","orderBuildTime":"2019-10-31 17:45:35","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":16,"orderNumber":"191031180587744","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":123000,"orderStatus":1,"orderRemark":"191031180512634","orderBuildTime":"2019-10-31 18:05:18","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":17,"orderNumber":"191031180645487","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":151413,"orderStatus":1,"orderRemark":"191031180662909","orderBuildTime":"2019-10-31 18:06:47","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":18,"orderNumber":"191031180861651","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031180872996","orderBuildTime":"2019-10-31 18:08:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":20,"orderNumber":"191031184637026","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"就咳咳咳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031184648366","orderBuildTime":"2019-10-31 18:46:19","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":22,"orderNumber":"191031185293139","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031185264680","orderBuildTime":"2019-10-31 18:52:15","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":23,"orderNumber":"191031185425012","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"好好好","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031185474715","orderBuildTime":"2019-10-31 18:54:54","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":24,"orderNumber":"191031185847976","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031185863021","orderBuildTime":"2019-10-31 18:58:34","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":25,"orderNumber":"191031190456117","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"山东的","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031190499739","orderBuildTime":"2019-10-31 19:04:34","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":26,"orderNumber":"191031190811076","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"函数","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031190884076","orderBuildTime":"2019-10-31 19:08:00","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":27,"orderNumber":"191031192216753","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"123","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031192260750","orderBuildTime":"2019-10-31 19:22:21","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":28,"orderNumber":"191031192759372","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"sky","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031192727948","orderBuildTime":"2019-10-31 19:27:50","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":29,"orderNumber":"191031193110106","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"sky","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031193157391","orderBuildTime":"2019-10-31 19:31:49","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"}]}
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
         * amount : 3010
         * orderStockList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":4,"orderNumber":"191031103548723","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":1000,"orderStatus":1,"orderRemark":"191031103527832","orderBuildTime":"2019-10-31 10:35:43","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":5,"orderNumber":"191031103536063","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":1,"orderRemark":"191031103526146","orderBuildTime":"2019-10-31 10:35:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":6,"orderNumber":"191031131998091","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":1,"orderRemark":"191031131977774","orderBuildTime":"2019-10-31 13:19:04","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":7,"orderNumber":"191031161754226","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"反反复复","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":153873,"orderStatus":1,"orderRemark":"191031161736620","orderBuildTime":"2019-10-31 16:17:18","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":8,"orderNumber":"191031161996544","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":151782,"orderStatus":1,"orderRemark":"191031161939832","orderBuildTime":"2019-10-31 16:19:49","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":9,"orderNumber":"191031162033616","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":592614,"orderStatus":1,"orderRemark":"191031162042711","orderBuildTime":"2019-10-31 16:20:12","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":10,"orderNumber":"191031162183058","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031162143801","orderBuildTime":"2019-10-31 16:21:30","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":11,"orderNumber":"191031162185267","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031162155892","orderBuildTime":"2019-10-31 16:21:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":12,"orderNumber":"191031162599968","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031162571383","orderBuildTime":"2019-10-31 16:25:14","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":13,"orderNumber":"191031162790280","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":151782,"orderStatus":1,"orderRemark":"191031162765133","orderBuildTime":"2019-10-31 16:27:50","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":14,"orderNumber":"191031164597415","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":10,"commoditySurplusAmount":null,"commodityPrice":10000,"orderStatus":1,"orderRemark":"191031164539422","orderBuildTime":"2019-10-31 16:45:33","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":15,"orderNumber":"191031174534319","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":123000,"orderStatus":1,"orderRemark":"191031174563924","orderBuildTime":"2019-10-31 17:45:35","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":16,"orderNumber":"191031180587744","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":123000,"orderStatus":1,"orderRemark":"191031180512634","orderBuildTime":"2019-10-31 18:05:18","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":17,"orderNumber":"191031180645487","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":151413,"orderStatus":1,"orderRemark":"191031180662909","orderBuildTime":"2019-10-31 18:06:47","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":18,"orderNumber":"191031180861651","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031180872996","orderBuildTime":"2019-10-31 18:08:48","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":20,"orderNumber":"191031184637026","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"就咳咳咳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":15129,"orderStatus":1,"orderRemark":"191031184648366","orderBuildTime":"2019-10-31 18:46:19","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":22,"orderNumber":"191031185293139","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031185264680","orderBuildTime":"2019-10-31 18:52:15","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":23,"orderNumber":"191031185425012","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"好好好","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031185474715","orderBuildTime":"2019-10-31 18:54:54","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":24,"orderNumber":"191031185847976","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"苏克阳","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031185863021","orderBuildTime":"2019-10-31 18:58:34","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":25,"orderNumber":"191031190456117","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"山东的","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031190499739","orderBuildTime":"2019-10-31 19:04:34","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":26,"orderNumber":"191031190811076","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"函数","commodityAmount":null,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031190884076","orderBuildTime":"2019-10-31 19:08:00","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":27,"orderNumber":"191031192216753","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"123","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031192260750","orderBuildTime":"2019-10-31 19:22:21","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":28,"orderNumber":"191031192759372","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"sky","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031192727948","orderBuildTime":"2019-10-31 19:27:50","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":29,"orderNumber":"191031193110106","userId":1,"payeeName":null,"payeeBankCard":null,"payeeBankName":null,"orderPayTpe":1,"payerName":"sky","commodityAmount":100,"commoditySurplusAmount":null,"commodityPrice":12300,"orderStatus":1,"orderRemark":"191031193157391","orderBuildTime":"2019-10-31 19:31:49","orderAuditTime":null,"orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"钱浩龙"}]
         */

        private Object commodity;
        private String amount;
        private List<OrderStockListBean> orderStockList;

        public Object getCommodity() {
            return commodity;
        }

        public void setCommodity(Object commodity) {
            this.commodity = commodity;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public List<OrderStockListBean> getOrderStockList() {
            return orderStockList;
        }

        public void setOrderStockList(List<OrderStockListBean> orderStockList) {
            this.orderStockList = orderStockList;
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
             * stockId : 4
             * orderNumber : 191031103548723
             * userId : 1
             * payeeName : null
             * payeeBankCard : null
             * payeeBankName : null
             * orderPayTpe : 1
             * payerName : 苏克阳
             * commodityAmount : 10
             * commoditySurplusAmount : null
             * commodityPrice : 1000
             * orderStatus : 1
             * orderRemark : 191031103527832
             * orderBuildTime : 2019-10-31 10:35:43
             * orderAuditTime : null
             * orderBuildTimeEnd : null
             * orderAuditTimeEnd : null
             * userName : 钱浩龙
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private int stockId;
            private String orderNumber;
            private int userId;
            private Object payeeName;
            private Object payeeBankCard;
            private Object payeeBankName;
            private int orderPayTpe;
            private String payerName;
            private int commodityAmount;
            private Object commoditySurplusAmount;
            private int commodityPrice;
            private int orderStatus;
            private String orderRemark;
            private String orderBuildTime;
            private Object orderAuditTime;
            private Object orderBuildTimeEnd;
            private Object orderAuditTimeEnd;
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

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
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

            public Object getPayeeName() {
                return payeeName;
            }

            public void setPayeeName(Object payeeName) {
                this.payeeName = payeeName;
            }

            public Object getPayeeBankCard() {
                return payeeBankCard;
            }

            public void setPayeeBankCard(Object payeeBankCard) {
                this.payeeBankCard = payeeBankCard;
            }

            public Object getPayeeBankName() {
                return payeeBankName;
            }

            public void setPayeeBankName(Object payeeBankName) {
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

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
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

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public static class ParamsBean {
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
                        ", payeeName=" + payeeName +
                        ", payeeBankCard=" + payeeBankCard +
                        ", payeeBankName=" + payeeBankName +
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
                        ", userName='" + userName + '\'' +
                        '}';
            }

        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "commodity=" + commodity +
                    ", amount='" + amount + '\'' +
                    ", orderStockList=" + orderStockList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestObligation{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}