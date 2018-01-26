package com.example.hao.tabnodestroyviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hao.tabnodestroyviewpager.adapter.NoDestroyViewPagerAdapter;
import com.example.hao.tabnodestroyviewpager.fragment.FirstPagerFragment;
import com.example.hao.tabnodestroyviewpager.fragment.SecondPagerFragment;
import com.example.hao.tabnodestroyviewpager.fragment.ThreePagerFragment;
import com.example.hao.tabnodestroyviewpager.util.AnimationUtils;
import com.example.hao.tabnodestroyviewpager.util.HomeTabUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tvFirst,tvSecond,tvThree;
    private LinearLayout layoutControl;

    private NoDestroyViewPagerAdapter mViewPagerAdapter;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        if (mFragments.size() == 0) {
            mFragments.add(FirstPagerFragment.newInstance());
            mFragments.add(SecondPagerFragment.newInstance());
            mFragments.add(ThreePagerFragment.newInstance());
        }
        if (titles.size() == 0) {
            titles.add(getResources().getString(R.string.tv_first));
            titles.add(getResources().getString(R.string.tv_discover));
            titles.add(getResources().getString(R.string.tv_mine));
        }

        viewPager = findViewById(R.id.viewPager);
        tvFirst = findViewById(R.id.tv_first);
        tvSecond = findViewById(R.id.tv_second);
        tvThree = findViewById(R.id.tv_three);
        layoutControl = findViewById(R.id.layout_control);

        initLister();
        initViewAdapter();
    }

    private void initViewAdapter() {
        mViewPagerAdapter = new NoDestroyViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.setItems(mFragments, titles);
        viewPager.setAdapter(mViewPagerAdapter);
    }

    private void initLister() {
        tvSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] changedTabs = HomeTabUtils.getChangedTab(viewPager, tvSecond.getText().toString());
                setCurrentTabs(changedTabs);

            }
        });
        tvThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] changedTabs = HomeTabUtils.getChangedTab(viewPager, tvThree.getText().toString());
                setCurrentTabs(changedTabs);

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setCurrentTabs(HomeTabUtils.firstTabRecommend);
                        break;
                    case 1:
                        setCurrentTabs(HomeTabUtils.firstTabLive);
                        break;
                    case 2:
                        setCurrentTabs(HomeTabUtils.firstTabSort);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    /**
     * 设置tabs
     * @param changedTabs
     */
    private void setCurrentTabs(String[] changedTabs) {
        AnimationUtils.showAndHiddenAnimation(layoutControl, AnimationUtils.AnimationState.STATE_SHOW, 1000);
        tvFirst.setText(changedTabs[0]);
        tvSecond.setText(changedTabs[1]);
        tvThree.setText(changedTabs[2]);
    }
}
