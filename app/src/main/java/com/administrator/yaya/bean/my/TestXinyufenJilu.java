package com.administrator.yaya.bean.my;

import java.util.List;

//信誉分记录
public class TestXinyufenJilu {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"userCredit":75,"list":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"userId":1103,"creditContent":"扣除","creditContentType":3,"creditType":2,"creditPart":2},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":2,"userId":1103,"creditContent":"测试","creditContentType":1,"creditType":1,"creditPart":1},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"userId":1103,"creditContent":"213","creditContentType":1,"creditType":1,"creditPart":1}],"creditName":"良好"}
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
         * userCredit : 75
         * list : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"userId":1103,"creditContent":"扣除","creditContentType":3,"creditType":2,"creditPart":2},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":2,"userId":1103,"creditContent":"测试","creditContentType":1,"creditType":1,"creditPart":1},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"userId":1103,"creditContent":"213","creditContentType":1,"creditType":1,"creditPart":1}]
         * creditName : 良好
         */

        private int userCredit;
        private String creditName;
        private List<ListBean> list;

        public int getUserCredit() {
            return userCredit;
        }

        public void setUserCredit(int userCredit) {
            this.userCredit = userCredit;
        }

        public String getCreditName() {
            return creditName;
        }

        public void setCreditName(String creditName) {
            this.creditName = creditName;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * id : 3
             * userId : 1103
             * creditContent : 扣除
             * creditContentType : 3
             * creditType : 2
             * creditPart : 2
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private int id;
            private int userId;
            private String creditContent;
            private int creditContentType;
            private int creditType;
            private int creditPart;

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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getCreditContent() {
                return creditContent;
            }

            public void setCreditContent(String creditContent) {
                this.creditContent = creditContent;
            }

            public int getCreditContentType() {
                return creditContentType;
            }

            public void setCreditContentType(int creditContentType) {
                this.creditContentType = creditContentType;
            }

            public int getCreditType() {
                return creditType;
            }

            public void setCreditType(int creditType) {
                this.creditType = creditType;
            }

            public int getCreditPart() {
                return creditPart;
            }

            public void setCreditPart(int creditPart) {
                this.creditPart = creditPart;
            }

            public static class ParamsBean {
            }
        }
    }
}
