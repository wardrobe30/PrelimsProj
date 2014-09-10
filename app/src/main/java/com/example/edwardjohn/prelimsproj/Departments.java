package com.example.edwardjohn.prelimsproj;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar.TabListener;

public class Departments extends FragmentActivity implements TabListener {


    ViewPager viewPager;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_departments);
        actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int position, float position1, int position2) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {
                if(position==ViewPager.SCROLL_STATE_IDLE){

                }
                if(position==ViewPager.SCROLL_STATE_DRAGGING){

                }
                if(position==ViewPager.SCROLL_STATE_SETTLING){

                }


            }
        });

        ActionBar.Tab tab1 =actionBar.newTab();
        tab1.setText("IT");
        tab1.setTabListener(this);

        ActionBar.Tab tab2 =actionBar.newTab();
        tab2.setText("CS");
        tab2.setTabListener(this);

        ActionBar.Tab tab3 =actionBar.newTab();
        tab3.setText("IS");
        tab3.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}


    class MyAdapter extends FragmentPagerAdapter
{

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment =null;

        if(position==0)
            fragment = new IT();
        if(position==1)
            fragment = new CS();
        if(position==2)
            fragment = new IS();

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

