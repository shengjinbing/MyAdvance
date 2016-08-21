package com.angong.myadvance.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.angong.myadvance.R;
import com.angong.myadvance.pagechilren.GovAffairsBaseTagPager;
import com.angong.myadvance.pagechilren.HomeBaseTagPager;
import com.angong.myadvance.pagechilren.NewCenterBaseTagPager;
import com.angong.myadvance.pagechilren.SettingCenterBaseTagPager;
import com.angong.myadvance.pagechilren.SmartServiceBaseTagPager;
import com.angong.myadvance.pagechilren.baseTagPage;
import com.angong.myadvance.utils.UIUtils;
import com.angong.myadvance.view.NoScrollViewPage;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
public class mainContentFragment extends BaseFragment {

    private RadioButton mHome;
    private RadioButton mNewcenter;
    private RadioButton mSmartservice;
    private RadioButton mGovaffairs;
    private RadioButton mSettingcenter;
    private List<baseTagPage> mPageList;
    private NoScrollViewPage mViewpage;
    private myAdapter mAdapter;
    private RadioGroup mRg_radios;

    private  int selectIndex = 0;

    @Override
    public void initEvent() {

        mViewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void initData() {
        mHome.setOnClickListener(new Listenr());
        mNewcenter.setOnClickListener(new Listenr());
        mSmartservice.setOnClickListener(new Listenr());
        mGovaffairs.setOnClickListener(new Listenr());
        mSettingcenter.setOnClickListener(new Listenr());


        mPageList = new ArrayList<>();
        mPageList.add(new HomeBaseTagPager(mActivity));
        mPageList.add(new NewCenterBaseTagPager(mActivity));
        mPageList.add(new SmartServiceBaseTagPager(mActivity));
        mPageList.add(new GovAffairsBaseTagPager(mActivity));
        mPageList.add(new SettingCenterBaseTagPager(mActivity));

        mAdapter = new myAdapter();
        mViewpage.setAdapter(mAdapter);


        //默认选择第一个
       mRg_radios.check(R.id.rb_main_content_home);

        mActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不处理

    }

    @Override
    protected View initView() {
        View view=View.inflate(UIUtils.getContext(), R.layout.fragment_content_view,null);

        mViewpage = (NoScrollViewPage) view.findViewById(R.id.vp_main_content_pages);
        mHome = (RadioButton) view.findViewById(R.id.rb_main_content_home);
        mNewcenter = (RadioButton) view.findViewById(R.id.rb_main_content_newscenter);
        mSmartservice = (RadioButton) view.findViewById(R.id.rb_main_content_smartservice);
        mGovaffairs = (RadioButton) view.findViewById(R.id.rb_main_content_govaffairs);
        mSettingcenter = (RadioButton) view.findViewById(R.id.rb_main_content_settingcenter);
        mRg_radios = (RadioGroup) view.findViewById(R.id.rg_content_radios);


        return view;
    }

    class  myAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            if (mPageList.size() != 0){
                return mPageList.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View root = mPageList.get(position).getRoot();
            container.addView(root);

            return root;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


    private void switchPage(int selectIndex) {
        mViewpage.setCurrentItem(selectIndex);
        if (selectIndex==0 || selectIndex == 4){
            mActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不处理
        }else {
            mActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏可以滑动

        }
    }

    class  Listenr implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rb_main_content_home:
                    selectIndex=0;
                    break;
                case R.id.rb_main_content_newscenter:
                    selectIndex=1;
                    break;
                case R.id.rb_main_content_smartservice:
                    selectIndex=2;
                    break;
                case R.id.rb_main_content_govaffairs:
                    selectIndex=3;
                    break;
                case R.id.rb_main_content_settingcenter:
                    selectIndex=4;
                    break;
            }
            switchPage(selectIndex);
        }

    }
}
