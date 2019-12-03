package com.administrator.yaya.bean.invite;

import java.io.Serializable;

//库存（新）
public class TestInventory implements Serializable {

    /**
     * msg : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":435,"orderNumber":"191202115465239","userId":1103,"payeeName":"丫丫官方","payeeBankCard":"6217000110016543210","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"时尚芭莎","commodityAmount":999993,"commodityPriceDeduction":0.0,"commodityPrice":999993.0,"orderStatus":2,"orderRemark":"9WODQN","orderBuildTime":"2019-12-02 11:54:14","orderAuditTime":"2019-12-02 11:54:24","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"4","userPhone":"8"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"stockId":434,"orderNumber":"191202114640429","userId":1103,"payeeName":"丫丫官方","payeeBankCard":"6217000110016543210","payeeBankName":"中国银行","orderPayTpe":1,"payerName":"啊啊唉唉唉唉唉","commodityAmount":100000,"commodityPriceDeduction":0.0,"commodityPrice":100000.0,"orderStatus":2,"orderRemark":"G1AQ2S","orderBuildTime":"2019-12-02 11:46:12","orderAuditTime":"2019-12-02 11:46:38","orderBuildTimeEnd":null,"orderAuditTimeEnd":null,"userName":"3","userPhone":"7"}]
     * code : 0
     */

    private String msg;
    private int code;

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
}
