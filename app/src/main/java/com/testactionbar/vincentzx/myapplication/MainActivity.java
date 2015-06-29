package com.testactionbar.vincentzx.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    private Tabs mOrderTabs;
    private ViewPager mViewPager;
    private String[] TabNames;
    private MyAdapter mViewpagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().show();
        findViews();
        TabNames = getResources().getStringArray(R.array.tab_names);
        mViewpagerAdapter = new MyAdapter(
                getSupportFragmentManager());
        mOrderTabs.addTabItems(this, TabNames, mClickListener);
        mViewPager.setAdapter(mViewpagerAdapter);
        mViewPager.setOnPageChangeListener(mChangeListener);
    }

    public void findViews() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mOrderTabs = (Tabs) findViewById(R.id.tabbars);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            for (int i = 0; i < TabNames.length; i++) {
                if (TextUtils.equals((String) v.getTag(), TabNames[i])) {
                    mViewPager.setCurrentItem(i);
                    mOrderTabs.pageSelected(i);
                }
            }

        }
    };
    private ViewPager.OnPageChangeListener mChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            mOrderTabs.pageSelected(arg0);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
}
