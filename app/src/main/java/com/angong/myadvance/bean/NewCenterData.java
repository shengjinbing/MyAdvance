package com.angong.myadvance.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class NewCenterData {

    /**
     * extend : [10007,10006,10008,10014,10012,10091,10009,10010,10095]
     * data : [{"children":[{"id":10007,"title":"北京","type":1,"url":"/10007/list_1.json"},{"id":10006,"title":"中国","type":1,"url":"/10006/list_1.json"},{"id":10008,"title":"国际","type":1,"url":"/10008/list_1.json"},{"id":10010,"title":"体育","type":1,"url":"/10010/list_1.json"},{"id":10091,"title":"生活","type":1,"url":"/10091/list_1.json"},{"id":10012,"title":"旅游","type":1,"url":"/10012/list_1.json"},{"id":10095,"title":"科技","type":1,"url":"/10095/list_1.json"},{"id":10009,"title":"军事","type":1,"url":"/10009/list_1.json"},{"id":10093,"title":"时尚","type":1,"url":"/10093/list_1.json"},{"id":10011,"title":"财经","type":1,"url":"/10011/list_1.json"},{"id":10094,"title":"育儿","type":1,"url":"/10094/list_1.json"},{"id":10105,"title":"汽车","type":1,"url":"/10105/list_1.json"}],"id":10000,"title":"新闻","type":1},{"url1":"/10007/list1_1.json","id":10002,"title":"专题","type":10,"url":"/10006/list_1.json"},{"id":10003,"title":"组图","type":2,"url":"/10008/list_1.json"},{"dayurl":"","id":10004,"weekurl":"","title":"互动","type":3,"excurl":""}]
     * retcode : 200
     */
    private List<Integer> extend;
    private List<DataEntity> data;
    private int retcode;

    public void setExtend(List<Integer> extend) {
        this.extend = extend;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public List<Integer> getExtend() {
        return extend;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public int getRetcode() {
        return retcode;
    }

    public static class DataEntity {
        /**
         * children : [{"id":10007,"title":"北京","type":1,"url":"/10007/list_1.json"},{"id":10006,"title":"中国","type":1,"url":"/10006/list_1.json"},{"id":10008,"title":"国际","type":1,"url":"/10008/list_1.json"},{"id":10010,"title":"体育","type":1,"url":"/10010/list_1.json"},{"id":10091,"title":"生活","type":1,"url":"/10091/list_1.json"},{"id":10012,"title":"旅游","type":1,"url":"/10012/list_1.json"},{"id":10095,"title":"科技","type":1,"url":"/10095/list_1.json"},{"id":10009,"title":"军事","type":1,"url":"/10009/list_1.json"},{"id":10093,"title":"时尚","type":1,"url":"/10093/list_1.json"},{"id":10011,"title":"财经","type":1,"url":"/10011/list_1.json"},{"id":10094,"title":"育儿","type":1,"url":"/10094/list_1.json"},{"id":10105,"title":"汽车","type":1,"url":"/10105/list_1.json"}]
         * id : 10000
         * title : 新闻
         * type : 1
          */
       private List<ChildrenEntity> children;
        private int id;
        private String title;
        private int type;

        public void setChildren(List<ChildrenEntity> children) {
            this.children = children;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<ChildrenEntity> getChildren() {
            return children;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getType() {
            return type;
        }

        public static class ChildrenEntity {
            /**
             * id : 10007
             * title : 北京
             * type : 1
             * url : /10007/list_1.json
             */
            private int id;
            private String title;
            private int type;
            private String url;

            public void setId(int id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public int getType() {
                return type;
            }

            public String getUrl() {
                return url;
            }
        }
    }
}
