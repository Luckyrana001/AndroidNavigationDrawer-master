package com.example.ranalucky.androidnavigationdrawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class HomeWithTabBar extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    public static FragmentManager fragmentManager;
    CoordinatorLayout coordinatorLayout;
    private int[] tabIcons = {
            R.drawable.ic_tab_call,
            R.drawable.ic_tab_call,
    };
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // initialising the object of the FragmentManager. Here I'm passing getSupportFragmentManager().
        // You can pass getFragmentManager() if you are coding for Android 3.0 or above.
        fragmentManager = getSupportFragmentManager();
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

      /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView = navigationView.getHeaderView(0);
       /* tvLoggedInName = (TextView) hView.findViewById(R.id.loggedInUserName);

          ivAvatarImage = (NetworkImageView) hView.findViewById(R.id.avatarNetworkImageView);
      */


        initLayout();

    }



    private void initLayout() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.images);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(0);

        setupTabIcons();

    }

    private void setupTabIcons() {

        final TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Prepaid");
        tabOne.setTextColor(getResources().getColor(R.color.colorPrimary));

        tabOne.setCompoundDrawablesWithIntrinsicBounds( 0,0, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        final TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Postpaid");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0,0, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if(position==0)
                {
                    tabOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                    tabTwo.setTextColor(getResources().getColor(R.color.white));

                }
                else
                {
                    tabOne.setTextColor(getResources().getColor(R.color.white));
                    tabTwo.setTextColor(getResources().getColor(R.color.colorPrimary));

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.LEFT);
                break;
               /* finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                break;

            case R.id.miCompose:
                Intent openHome = new Intent(getApplicationContext(),EPosHomeActivity.class);
                openHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                openHome.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
                startActivity(openHome);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                break;*/
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        //inflater.inflate(R.menu.home_menu, menu);
        // Associate searchable configuration with the SearchView
        /*SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));*/

        return true;
    }


    private void setupViewPager(ViewPager viewPager) {
        HomeWithTabBar.ViewPagerAdapter adapter = new
                HomeWithTabBar.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PrepaidFragment(), "Prepaid");
        adapter.addFragment(new PostpaidFragment(), "Postpaid");

        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            Toast.makeText(getApplicationContext(),"Home Clicked",Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_logout) {
            Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_LONG).show();

          /*  final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(R.string.logout_str))
                    .setCancelable(false)
                    .setPositiveButton(getResources().getString(R.string.yes_alert), new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            if (ServiceTools.isServiceRunning(getApplicationContext(), HajjLocationService.class)) {
                                stopService(new Intent(getApplicationContext(), HajjLocationService.class));
                            }
                            if (ServiceTools.isServiceRunning(getApplicationContext(), HajjIntentService.class)) {
                                stopService(new Intent(getApplicationContext(), HajjIntentService.class));
                            }
                            if (ylwlmanager != null) {

                                if (ServiceTools.isServiceRunning(getApplicationContext(), UartService.class)) {
                                    stopService(new Intent(getApplicationContext(), UartService.class));
                                }


                            }
                            logOut();
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            dialog.cancel();
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();*/
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
