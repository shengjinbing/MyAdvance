package com.angong.myadvance.pagechilren;

import android.view.Gravity;
import android.widget.TextView;

import com.angong.myadvance.MainActivity;
import com.angong.myadvance.utils.UIUtils;

/**
 * Created by Administrator on 2016/8/5 0005.
 */
public class SettingCenterBaseTagPager extends baseTagPage {
    public SettingCenterBaseTagPager(MainActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        tv_title.setText("设置中心");

        TextView tv =new TextView(UIUtils.getContext());
        tv.setText(getClass()+"");
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);
        fl_content.addView(tv);
    }
}
