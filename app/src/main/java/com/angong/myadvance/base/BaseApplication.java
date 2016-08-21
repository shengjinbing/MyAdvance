package com.angong.myadvance.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;



/**
 * Created by Administrator on 2016/8/2 0002.
 */
public class BaseApplication extends Application{
    private static Context mContext;
    private static Thread	mMainThread;
    private static long		mMainTreadId;
    private static Looper mMainLooper;
    private static Handler	mHandler;

    public static Handler getHandler() {
        return mHandler;
    }

    public static Context getContext() {
        return mContext;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static long getMainTreadId() {
        return mMainTreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    @Override
    public void onCreate() {// 程序的入口
        // 初始化化一些.常用属性.然后放到盒子里面来
        // 上下文
        mContext = getApplicationContext();

        // 主线程
        mMainThread = Thread.currentThread();

        // 主线程Id
        mMainTreadId = android.os.Process.myTid();

        // tid thread
        // uid user
        // pid process
        // 主线程Looper对象
        mMainLooper = getMainLooper();

        // 定义一个handler

        mHandler = new Handler();
        super.onCreate();
    }
}