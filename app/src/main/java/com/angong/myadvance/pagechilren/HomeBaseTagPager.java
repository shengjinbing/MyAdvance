package com.angong.myadvance.pagechilren;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.angong.myadvance.MainActivity;
import com.angong.myadvance.utils.UIUtils;

/**
 * Created by Administrator on 2016/8/5 0005.
 */
public class HomeBaseTagPager extends baseTagPage {

    public HomeBaseTagPager(MainActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        //菜单按钮不显示
        ib_menu.setVisibility(View.GONE);

        tv_title.setText("首页");

        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("woaini");
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);

        fl_content.addView(tv);

    }
}
