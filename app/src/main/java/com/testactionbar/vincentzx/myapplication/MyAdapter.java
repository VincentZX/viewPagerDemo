package com.testactionbar.vincentzx.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class MyAdapter extends FragmentStatePagerAdapter {
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = new FragmentOne();
                }
                return mFragmentOne;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = new FragmentTwo();
                }
                return mFragmentTwo;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = new FragmentThree();
                }
                return mFragmentThree;
            default:
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
