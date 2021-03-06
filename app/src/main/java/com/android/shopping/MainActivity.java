package com.android.shopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.shopping.Fragment.ElectronicsFragment;
import com.android.shopping.Fragment.FashionFragment;
import com.android.shopping.Fragment.HomeFragment;
import com.android.shopping.Fragment.MainScreenFragment;
import com.android.shopping.Fragment.SportsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.detail_fragment,new MainScreenFragment(),"mainfragment")
                .commit();









    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, AddToCartActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_fashion) {
            // Handle the camera action
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.leftt_enter, R.anim.right_out)
                    .add(R.id.detail_fragment, new FashionFragment(), "fashion")
                    .addToBackStack("fashion")
                    .commit();
        } else if (id == R.id.nav_electronics) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.leftt_enter, R.anim.right_out)
                    .add(R.id.detail_fragment, new ElectronicsFragment(),"electronics")
                    .addToBackStack("electronics")
                    .commit();

        } else if (id == R.id.nav_home) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.leftt_enter, R.anim.right_out)
                    .add(R.id.detail_fragment, new HomeFragment(), "home")
                    .addToBackStack("home")
                    .commit();

        } else if (id == R.id.nav_sports) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.leftt_enter, R.anim.right_out)
                    .add(R.id.detail_fragment,new SportsFragment(), "sports")
                    .addToBackStack("sports")
                    .commit();

        }else if (id == R.id.nav_category) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.leftt_enter, R.anim.right_out)
                    .add(R.id.detail_fragment,new MainScreenFragment(), "main")
                    .commit();

        } else if (id == R.id.nav_logout) {
            SharedPreferences preferences = getSharedPreferences("save",MODE_PRIVATE);
            preferences.edit().clear().apply();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
