package com.angong.myadvance.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angong.myadvance.MainActivity;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
public abstract class BaseFragment extends Fragment {

    public MainActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取fragment所在的Activity
        mActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=initView();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        initEvent();
        super.onActivityCreated(savedInstanceState);
    }

    public abstract  void initEvent();

    public abstract void initData();

    protected abstract View initView();
}
