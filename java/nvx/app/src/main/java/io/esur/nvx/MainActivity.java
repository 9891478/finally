package io.esur.nvx;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        EntityMainFragment.OnEntityMainFragmentInteractionListener,
        EntityImageFragment.OnEntityImageFragmentInteractionListener {

    ViewPager viewPager = null;
    PagerTitleStrip pagerTitleStrip = null;

    //    EntityMainFragment entityMainFragment = new EntityMainFragment();
    EntityImageFragment entityImageFragment = new EntityImageFragment();
    CommentFragment commentFragment = new CommentFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.activity_coordinator_layout, entityMainFragment, "EMF");
//        fragmentTransaction.commit();
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new PagerAdapter(this, fragmentManager));
        viewPager.addOnPageChangeListener(new ToolbarOnPageChangeListener(this));

        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pager_title_strip);
        pagerTitleStrip.setNonPrimaryAlpha(0);

//        PagerTitleStripBehavior pagerTitleStripBehavior = new PagerTitleStripBehavior(this);
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) viewPager.getLayoutParams();
//        params.setBehavior(pagerTitleStripBehavior);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_layout_main);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onButtonPressed(int position, String tag) {
        if (tag.equals("entity_main_description")) {
            Toast.makeText(this, "CLICKED :: " + tag, Toast.LENGTH_SHORT).show();
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.activity_coordinator_layout, commentFragment, "CF");
//            fragmentTransaction.addToBackStack("CF");
//            fragmentTransaction.commit();
        }

        if (tag.equals("entity_main_button")) {
            Toast.makeText(this, "INTENT :: " + tag, Toast.LENGTH_SHORT).show();
        }

        if (tag.equals("entity_image_cv_image")) {
            Toast.makeText(this, "CLICKED :: " + tag, Toast.LENGTH_SHORT).show();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.activity_coordinator_layout, entityImageFragment, "EIF");
            fragmentTransaction.addToBackStack("EIF");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onButtonLongPressed(int position, String tag) {
        Toast.makeText(this, "LONG CLICKED :: " + tag, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEntityImageFragmentInteraction(int mock) {
        Toast.makeText(this, "CLICKED!", Toast.LENGTH_SHORT).show();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            View decorView = this.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LOW_PROFILE;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}