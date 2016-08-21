package com.angong.myadvance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.angong.myadvance.activity.GuideActivity;

/**
 * Created by Administrator on 2016/8/2 0002.
 */
public class SplashActivity extends AppCompatActivity {

    private ImageView mIv;
    private AnimationSet mSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initAnimation();
        initEvent();


    }

    private void initEvent() {

        mSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                startActivity(intent);
                finish();
                //动画结束

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initView() {

        setContentView(R.layout.activity_splash);

        mIv = (ImageView) findViewById(R.id.iv_splash_mainview);


    }
    private void initAnimation() {

        // false 代表动画集中每种动画都采用各自的动画插入器(数学函数)
        mSet = new AnimationSet(false);

        /**旋转动画*/
        RotateAnimation ra = new RotateAnimation(0,360,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        //设置播放时间
        ra.setDuration(1000);
        //播放完成停留当前页面
        ra.setFillAfter(true);
        mSet.addAnimation(ra);


        /**缩放动画*/
        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        //设置播放时间
        sa.setDuration(1000);
        //播放完成停留当前页面
        sa.setFillAfter(true);
        mSet.addAnimation(sa);


        /**渐变*/
        AlphaAnimation aa = new AlphaAnimation(0,1);
        //设置播放时间
        aa.setDuration(1000);
        //播放完成停留当前页面
        aa.setFillAfter(true);


        mSet.addAnimation(aa);

        mIv.startAnimation(mSet);
    }
}
