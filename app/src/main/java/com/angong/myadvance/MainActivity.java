package com.angong.myadvance;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.angong.myadvance.fragment.leftMenuFragment;
import com.angong.myadvance.fragment.mainContentFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    private static final String LEFT_MUNE_TAG = "LEFT_MUNE_TAG";
    private static final String MAIN_MUNE_TAG = "MAIN_MUNE_TAG";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maincontent);

        initView();
        initData();
        initEvent();



    }

    private void initEvent() {
    }


    /**
     * 获取左侧菜单的fragment
     */
    public  leftMenuFragment getLeftMenuFragment(){
        FragmentManager manager = getSupportFragmentManager();
        leftMenuFragment fragmentByTag = (leftMenuFragment)manager.findFragmentByTag(LEFT_MUNE_TAG);
        return fragmentByTag;
    }
    /**
     * 获取主侧菜单的fragment
     */
    public  mainContentFragment getMainContentFragment(){
        FragmentManager manager = getSupportFragmentManager();
        mainContentFragment fragmentByTag = (mainContentFragment)manager.findFragmentByTag(LEFT_MUNE_TAG);
        return fragmentByTag;
    }


    private void initData() {

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        //获取事务
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        //完成替换
        transaction.replace(R.id.fl_leftframent,new leftMenuFragment(),LEFT_MUNE_TAG);
        transaction.replace(R.id.fl_mainframent,new mainContentFragment(),MAIN_MUNE_TAG);

        //提交
        transaction.commit();


    }

    private void initView() {

        // 设置左侧菜单界面
        setBehindContentView(R.layout.fragment_left);


        // 设置滑动模式
        SlidingMenu sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);// 只设置左侧可以滑动

        // 设置滑动位置为全屏
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        // 设置主界面左侧滑动后剩余的空间位置
        sm.setBehindOffset(350);// 设置主界面剩余的位置
    }
}
