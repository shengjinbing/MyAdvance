package com.angong.myadvance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.angong.myadvance.MainActivity;
import com.angong.myadvance.R;
import com.angong.myadvance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class GuideActivity extends AppCompatActivity {

    private ViewPager pageguide;
    private LinearLayout llguide;
    private View viewguide;
    private Button btguide;
    private List<ImageView> mImageViewList;
    private int mDistance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
        initEvent();
    }

    private void initData() {
        int[] mImages = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
        mImageViewList = new ArrayList<>();
        for (int i = 0; i <mImages.length ; i++) {
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setBackgroundResource(mImages[i]);

            //添加到集合中
            mImageViewList.add(iv);


            View view_point = new View(UIUtils.getContext());
            view_point.setBackgroundResource(R.drawable.gray_point);

            int width = UIUtils.dip2px(UIUtils.getContext(),10);
            int height = UIUtils.dip2px(UIUtils.getContext(),10);;

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,height);
            if(i!=0){
                params.leftMargin=10;
            }
            llguide.addView(view_point,params);

        }


        MypagerAdapter adapter = new MypagerAdapter();
        pageguide.setAdapter(adapter);
    }

    private void initEvent() {
        //监听布局完成
        viewguide.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {



            @Override
            public void onGlobalLayout() {
                //移除监听
                llguide.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                //算得点和点直接的距离
                mDistance = llguide.getChildAt(1).getLeft() - llguide.getChildAt(0).getLeft();
            }
        });


        //导航最后一个Button
        btguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


			/* (non-Javadoc)
			 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
			 * 在页面滑动过程触发的事件
			 * @param position 当前ViewPage停留的位置
			 * @param positionOffset 偏移的比例值
			 * @param positionOffsetPixels 偏移的像素
			 */
        pageguide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                float leftMargin = mDistance * (position + positionOffset);

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewguide.getLayoutParams();
                layoutParams.leftMargin = Math.round(leftMargin);
                viewguide.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == mImageViewList.size()-1){
                    btguide.setVisibility(View.VISIBLE);
                }else{
                    btguide.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initView() {
        setContentView(R.layout.activity_guide);
        pageguide = (ViewPager) findViewById(R.id.page_guide);
        llguide = (LinearLayout) findViewById(R.id.ll_guide);
        viewguide = (View) findViewById(R.id.view_guide);
        btguide = (Button) findViewById(R.id.bt_guide);
    }


    class MypagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            if (mImageViewList.size()>0){
                return  mImageViewList.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = mImageViewList.get(position);

            container.addView(imageView);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object); // 从Viewpager中移除

        }
    }
}
