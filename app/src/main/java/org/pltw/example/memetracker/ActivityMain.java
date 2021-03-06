package org.pltw.example.memetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

//https://developer.android.com/training/basics/fragments/fragment-ui

public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView mSpongeBobImage1;
    private ImageView mSpongeBobImage2;
    private ImageView mPhotoshopImage1;
    private ImageView mPhotoshopImage2;
    private ImageView mJoshImage1;
    private ImageView mOverwatchImage1;
    private ImageView mOverwatchImage2;
    private ImageView mFortniteImage1;
    private ImageView mFortniteImage2;
    private ImageView mDestinyImage1;
    private ImageView mDestinyImage2;
    private ImageView mPepeImage1;
    private ImageView mPepeImage2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.

        mSpongeBobImage1 = (ImageView) findViewById(R.id.spongebob_1);
        mSpongeBobImage2 = (ImageView) findViewById(R.id.spongebob_2);

        mPepeImage1 = (ImageView) findViewById(R.id.pepe_1);
        mPepeImage2 = (ImageView) findViewById(R.id.pepe_2);

        mPhotoshopImage1 = (ImageView) findViewById(R.id.photoshop_1);
        mPhotoshopImage2 = (ImageView) findViewById(R.id.photoshop_2);

        mJoshImage1 = (ImageView) findViewById(R.id.josh_1);

        mOverwatchImage1 = (ImageView) findViewById(R.id.overwatch_1);
        mOverwatchImage2 = (ImageView) findViewById(R.id.overwatch_2);

        mFortniteImage1 = (ImageView) findViewById(R.id.fortnite_1);
        mFortniteImage2 = (ImageView) findViewById(R.id.fortnite_2);

        mDestinyImage1 = (ImageView) findViewById(R.id.destiny_1);
        mDestinyImage2 = (ImageView) findViewById(R.id.destiny_2);


        int id = item.getItemId();
        Fragment contentFragment = null;

         if (id == R.id.nav_spongebob) {
            // Intent intent = new Intent(MemeActivity.this , Meme.class);
            // startActivity(intent);
             contentFragment = new Meme_Fragment();
            // mSpongeBobImage1.setVisibility(VISIBLE);
            // mSpongeBobImage2.setVisibility(VISIBLE);
         }
        if (contentFragment != null) {
             FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
           ft.replace(R.id.content_frame, contentFragment);
           ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

