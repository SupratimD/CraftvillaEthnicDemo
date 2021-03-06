package com.supratim.craftsvilla.startup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.supratim.craftsvilla.R;
import com.supratim.craftsvilla.dashboardslider.SliderIndicator;
import com.supratim.craftsvilla.dashboardslider.SliderPagerAdapter;
import com.supratim.craftsvilla.dashboardslider.SliderView;
import com.supratim.craftsvilla.fragments.FragmentSlider;
import com.supratim.craftsvilla.fragments.ImageListFragment;
import com.supratim.craftsvilla.miscellaneous.EmptyActivity;
import com.supratim.craftsvilla.notification.NotificationCountSetClass;
import com.supratim.craftsvilla.options.CartListActivity;
import com.supratim.craftsvilla.options.SearchResultActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
         {

    public static int notificationCountCart = 0;
    static ViewPager viewPager;
    static TabLayout tabLayout;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);



         viewPager = (ViewPager) findViewById(R.id.viewpager);
//////////////////////Autoslider Viewpager///////////////////////////////////////////
        setupSlider();

         /////Load Images ////////////////////////////////////////////////////////////////

        Adapter adapter = new Adapter(getSupportFragmentManager());
        ImageListFragment fragment = new ImageListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, getString(R.string.item_1));
        viewPager.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        MenuItem item = menu.findItem(R.id.action_cart);
        NotificationCountSetClass.setAddToCart(MainActivity.this, item,notificationCountCart);
        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            startActivity(new Intent(MainActivity.this, SearchResultActivity.class));
            return true;
        }else if (id == R.id.action_cart) {

           /* NotificationCountSetClass.setAddToCart(MainActivity.this, item, notificationCount);
            invalidateOptionsMenu();*/
            startActivity(new Intent(MainActivity.this, CartListActivity.class));

           /* notificationCount=0;//clear notification count
            invalidateOptionsMenu();*/
            return true;
        }else {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }




    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }


             private void setupSlider() {
                 sliderView.setDurationScroll(800);
                 List<Fragment> fragments = new ArrayList<>();
                 fragments.add(FragmentSlider.newInstance("https://i.pinimg.com/originals/06/55/d7/0655d77fba7ebd48b38b069b819838d3.jpg"));
                 fragments.add(FragmentSlider.newInstance("https://i.pinimg.com/originals/32/be/d4/32bed4f8090db0669a3f407ebb28d628.jpg"));
                 fragments.add(FragmentSlider.newInstance("https://i.pinimg.com/originals/de/de/ce/dedece7f5702ea4599dff0f57bdb33ed.jpg"));
                 fragments.add(FragmentSlider.newInstance("https://i.pinimg.com/originals/8e/d3/db/8ed3db9f59dc2bc9ca72ac573b3acf38.jpg"));

                 mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
                 sliderView.setAdapter(mAdapter);
                 mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
                 mIndicator.setPageCount(fragments.size());
                 mIndicator.show();
             }
}
