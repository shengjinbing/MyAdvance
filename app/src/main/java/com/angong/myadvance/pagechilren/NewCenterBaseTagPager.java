package com.angong.myadvance.pagechilren;

import android.widget.Toast;

import com.angong.myadvance.MainActivity;
import com.angong.myadvance.bean.NewCenterData;
import com.angong.myadvance.conf.Constants;
import com.angong.myadvance.fragment.leftMenuFragment;
import com.angong.myadvance.newcenterpager.BaseNewsCenterPage;
import com.angong.myadvance.newcenterpager.NewsBaseNewsCenterPage;
import com.angong.myadvance.utils.LogUtils;
import com.angong.myadvance.utils.UIUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/5 0005.
 */
public class NewCenterBaseTagPager extends baseTagPage {
    MainActivity mainActivity;
    List<BaseNewsCenterPage> mCenterPageList = new ArrayList<>();

    public NewCenterBaseTagPager(MainActivity context) {
        super(context);
        this.mainActivity= context;
    }

    @Override
    public void initData() {

      //获取数据
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpMethod.GET, Constants.NEWSCENTERURL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                String result = responseInfo.result;
                //1.解析数据
                parseData(result);

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(UIUtils.getContext(),"请求数据失败",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void parseData(String result) {
        Gson gson = new Gson();
        //2.获取数据
        NewCenterData newCenterData = gson.fromJson(result, NewCenterData.class);

        //3.设置数据
        LogUtils.i("MSG",newCenterData.getData().get(0).getTitle());
        mainActivity.getLeftMenuFragment().setLeftMenuData(newCenterData.getData());

        mActivity.getLeftMenuFragment().setOnSwitchPageListener(new leftMenuFragment.OnSwitchPageListener() {
            @Override
            public void switchpage(int index) {
               NewCenterBaseTagPager.this.switchpage(index);
            }
        });




        fl_content.addView(new NewsBaseNewsCenterPage().getRoot());

    }
    public  void switchpage(int index){

        switch (index){

        }

    }
}
