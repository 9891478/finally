package io.esur.nvx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class PagerAdapter extends FragmentStatePagerAdapter {

    private String page0, page1, page2;

    // mainActivity as parameter ? seriously ?
    PagerAdapter(MainActivity mainActivity, FragmentManager fragmentManager) {
        super(fragmentManager);

        page0 = mainActivity.getResources().getString(R.string.page0);
        page1 = mainActivity.getResources().getString(R.string.page1);
        page2 = mainActivity.getResources().getString(R.string.page2);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0) {
            fragment = new EntityMainFragment();
        }
        if (position == 1) {
            fragment = new FragmentSecond();
        }
        if (position == 2) {
            fragment = new ThirdFragment();
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return page0;
        }
        if (position == 1) {
            return page1;
        }
        if (position == 2) {
            return page2;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}