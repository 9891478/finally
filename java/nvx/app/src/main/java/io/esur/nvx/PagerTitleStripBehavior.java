package io.esur.nvx;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

class PagerTitleStripBehavior extends CoordinatorLayout.Behavior<ViewPager> {
    private MainActivity mainActivity;

    public PagerTitleStripBehavior(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public PagerTitleStripBehavior(MainActivity mainActivity, Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mainActivity = mainActivity;
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, ViewPager child, View target) {
        //super.onStopNestedScroll(coordinatorLayout, child, target);
//        Log.d("CURR ITEM:", String.valueOf(child.getCurrentItem()));

    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, ViewPager child, MotionEvent ev) {
        //return super.onInterceptTouchEvent(parent, child, ev);
//        mainActivity.pagerTitleStrip.setNonPrimaryAlpha(mainActivity.pagerTitleStrip.getX());
//        Log.d("SCROLL POS:", String.valueOf(mainActivity.pagerTitleStrip.getX()));

//        Log.d("SCROLL EVENT", String.valueOf(ev.getAction()));
//        Log.d("SCROLL XXX", String.valueOf(parent.getTag()));
        return false;
    }
}
