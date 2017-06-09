package com.minscapecomputing.infowindow.adapter;

import com.minscapecomputing.infowindow.fragments.Tab2Fragment;
import com.minscapecomputing.infowindow.fragments.TabFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;
    private int tabPosition;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, int tabPosition) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.tabPosition = tabPosition;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        if (tabPosition %2 == 0) {
            TabFragment tab1 = new TabFragment();
            tab1.setArguments(bundle);
            return tab1;
        } else {
            Tab2Fragment tab2 = new Tab2Fragment();
            tab2.setArguments(bundle);
            return tab2;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}