package com.angong.myadvance.conf;

import com.angong.myadvance.utils.LogUtils;

/**
 * Created by Administrator on 2016/8/2 0002.
 */
public interface Constants {
     int DEBUGLEVEL= LogUtils.LEVEL_ALL;//LEVEL_ALL,显示所有的日子,OFF:关闭日志的显示
    //apk发布修改该ip ip 或者 域名 www.henhao.com/zhbj/categories.json
    String SERVERURL = "http://10.0.179.126:8080/zhbj";
    String NEWSCENTERURL = SERVERURL + "/categories.json";
    String PHOTOSURL = SERVERURL + "/photos/photos_1.json";
    String CONFIGFILE = "cachevalue";//sp的文件名
    String ISSETUP = "issetup";//是否设置向导界面设置过数据
    String READNEWSIDS = "readnewsids";//保存读过的新闻id
}
