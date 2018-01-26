package com.example.hao.tabnodestroyviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
* @Auther: hao
* @Date 2017/10/27 15:32
* @Description  ViewPager适配器
 *  避免fragment切换反复DestroyView和CreateView
**/

public class NoDestroyViewPagerAdapter extends FragmentPagerAdapter {

    List<String> mTitles;
    List<Fragment> fragments;

    public NoDestroyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        mTitles = new ArrayList<String>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    public void setItems(List<Fragment> fragments, List<String> mTitles) {
        this.fragments = fragments;
        this.mTitles = mTitles;
        notifyDataSetChanged();
    }
    public void setItems(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }
}
