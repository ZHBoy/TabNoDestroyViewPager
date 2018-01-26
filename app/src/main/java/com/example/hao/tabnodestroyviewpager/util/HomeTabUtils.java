package com.example.hao.tabnodestroyviewpager.util;

import android.support.v4.view.ViewPager;

/**
* @作者 hao
* @创建日期 2018/1/26 14:02
* Description: 控制首页tab
*/

public class HomeTabUtils {

    public static String [] firstTabRecommend ,firstTabLive,firstTabSort;

    static {
        firstTabRecommend = new String[]{"首页","发现","我的"};
        firstTabLive = new String[]{"发现","我的","首页"};
        firstTabSort = new String[]{"我的","首页","发现"};
    }

    /**
     *  返回改变后的tabs
     * @param clickTab 点击的tab文字
     * @return
     */
    public static String[] getChangedTab(ViewPager viewPager, String clickTab){
        String [] defaultTabs = firstTabRecommend;
        if (clickTab.equals("首页")){
            defaultTabs = firstTabRecommend;
            viewPager.setCurrentItem(0);
        }else if (clickTab.equals("发现")){
            defaultTabs = firstTabLive;
            viewPager.setCurrentItem(1);
        }else if (clickTab.equals("我的")){
            defaultTabs = firstTabSort;
            viewPager.setCurrentItem(2);
        }
        return defaultTabs;
    }
}
