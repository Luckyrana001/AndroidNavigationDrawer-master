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


public class HomeActivity extends AppCompatActivity   {
    public static FragmentManager fragmentManager;
    CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);


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





        initLayout();

    }



    private void initLayout() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.images);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Fragment fragment =  new PrepaidFragment();
        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.coordinatorLayout, fragment).commit();
        }

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.LEFT);*/
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




}
