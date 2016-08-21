package com.angong.myadvance.pagechilren;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.angong.myadvance.MainActivity;
import com.angong.myadvance.R;
import com.angong.myadvance.utils.UIUtils;

/**
 * Created by Administrator on 2016/8/5 0005.
 */
public  class baseTagPage {

    private View mRoot;
    protected ImageButton	ib_menu;//按钮ib
    protected TextView	tv_title;
    protected FrameLayout	fl_content;
    public   MainActivity mActivity;

    public baseTagPage(MainActivity context){
        this.mActivity = context;
        initView();
        initData();
        initEnvent();
    }

    private void initEnvent() {
        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过按钮控制左侧菜单
                mActivity.getSlidingMenu().toggle();
            }
        });

    }

    public void initData() {
    }

    public  void initView(){
        mRoot = View.inflate(UIUtils.getContext(), R.layout.fragment_content_base_content,null);

        ib_menu = (ImageButton) mRoot.findViewById(R.id.ib_base_content_menu);

        tv_title = (TextView) mRoot.findViewById(R.id.tv_base_content_title);

        fl_content = (FrameLayout) mRoot.findViewById(R.id.fl_base_content_tag);

    }

    public  View  getRoot(){
        return  mRoot;
    }
}


