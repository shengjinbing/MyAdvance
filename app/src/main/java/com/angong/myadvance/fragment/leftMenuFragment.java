package com.angong.myadvance.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.angong.myadvance.R;
import com.angong.myadvance.bean.NewCenterData;
import com.angong.myadvance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
public class leftMenuFragment extends BaseFragment {

    public interface OnSwitchPageListener{
        void switchpage(int index);
    }

    private OnSwitchPageListener mPageListener;
    public void setOnSwitchPageListener(OnSwitchPageListener switchPageListener){
        this.mPageListener = switchPageListener;
    }

    private List<NewCenterData.DataEntity> data = new ArrayList<>();
    private MyAdapter mAdapter;
    private ListView mLv_leftData;

    @Override
    public void initEvent() {
        mLv_leftData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPageListener.switchpage(position);
            }
        });

    }

    @Override
    public void initData() {
        mAdapter = new MyAdapter();
        mLv_leftData.setAdapter(mAdapter);


    }

    @Override
    protected View initView() {
        //listview显示左侧菜单
        mLv_leftData = new ListView(mActivity);

        //背景是黑色
        mLv_leftData.setBackgroundColor(Color.BLACK);

        //选中拖动的背景色 设置成透明
        mLv_leftData.setCacheColorHint(Color.TRANSPARENT);

        //设置选中时为透明背景
        mLv_leftData.setSelector(new ColorDrawable(Color.TRANSPARENT));

        //没有分割线
        mLv_leftData.setDividerHeight(0);

        //距顶部为45px
        mLv_leftData.setPadding(0, 45, 0, 0);


        return mLv_leftData;
    }

    public void setLeftMenuData(List<NewCenterData.DataEntity> data) {
        this.data = data;
        mAdapter.notifyDataSetChanged();

    }

    class MyAdapter extends BaseAdapter {



        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView mTextView;
            if (convertView==null) {
                mTextView =   (TextView) View.inflate(UIUtils.getContext(), R.layout.fragment_leftcontent_list_item, null);

            }else {
                mTextView = (TextView) convertView;
            }
            mTextView .setText(data.get(position).getTitle());
            return mTextView;
        }
    }

}
