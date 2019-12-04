package com.administrator.yaya.bean.my.ranking;
import java.util.List;
//今日排行
public class TestTodayRanking {
    /**
     * msg : 操作成功
     * code : 0
     * data : {"userInfoTop":{"id":1,"uid":1103,"uname":"王优秀","ucount":4},"list":[{"id":1,"uid":1103,"uname":"王优秀","ucount":4},{"id":2,"uid":1000,"uname":"丫丫","ucount":2}]}
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
         * userInfoTop : {"id":1,"uid":1103,"uname":"王优秀","ucount":4}
         * list : [{"id":1,"uid":1103,"uname":"王优秀","ucount":4},{"id":2,"uid":1000,"uname":"丫丫","ucount":2}]
         */

        private UserInfoTopBean userInfoTop;
        private List<ListBean> list;

        public UserInfoTopBean getUserInfoTop() {
            return userInfoTop;
        }

        public void setUserInfoTop(UserInfoTopBean userInfoTop) {
            this.userInfoTop = userInfoTop;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class UserInfoTopBean {
            /**
             * id : 1
             * uid : 1103
             * uname : 王优秀
             * ucount : 4
             */

            private int id;
            private int uid;
            private String uname;
            private int ucount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public int getUcount() {
                return ucount;
            }

            public void setUcount(int ucount) {
                this.ucount = ucount;
            }
        }

        public static class ListBean {
            /**
             * id : 1
             * uid : 1103
             * uname : 王优秀
             * ucount : 4
             */

            private int id;
            private int uid;
            private String uname;
            private int ucount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public int getUcount() {
                return ucount;
            }

            public void setUcount(int ucount) {
                this.ucount = ucount;
            }
        }
    }
}
