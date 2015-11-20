package com.app.homeassist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.homeassist.navigation.Orders;
import com.app.homeassist.services.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemClickListener {

        GridView gv;
        Context cv;
        String validCities[];
        String adapterservicenameList [];

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        adapterservicenameList = getResources().getStringArray(R.array.serviceitemnames);
        validCities = getResources().getStringArray(R.array.validCities);

        int adapterimageid[]= {  R.drawable.dummycontact,R.drawable.dummycontact,
                                 R.drawable.dummycontact,R.drawable.dummycontact,
                                 R.drawable.dummycontact,R.drawable.dummycontact,
                                 R.drawable.dummycontact,R.drawable.dummycontact,
                                 R.drawable.dummycontact
                            };

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MainCustomAdapter mv = new MainCustomAdapter(this,adapterservicenameList,adapterimageid);
        gv=(GridView)findViewById(R.id.maingridview);
        gv.setAdapter(mv);
        gv.setOnItemClickListener(this);


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
            Intent i = new Intent(MainActivity.this,MyPreferences.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent i;
        int id = item.getItemId();

        if (id == R.id.mycity) {
            AlertDialog.Builder ab=  new AlertDialog.Builder(this);
            ab.setTitle("City");
            ab.setSingleChoiceItems(validCities, 0, null);
            ab.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    int selectedpos= ((AlertDialog)dialog).getListView().getCheckedItemPosition();

                    NavigationView nv1 = (NavigationView)findViewById(R.id.nav_view);
                    nv1.getMenu().findItem(R.id.mycity).setTitle(validCities[selectedpos]);

                    dialog.dismiss();
                }
            });
            ab.setNegativeButton("Cancel", null);
            ab.show();

        } else if (id == R.id.myorders) {
            i = new Intent(MainActivity.this, Orders.class);
            startActivity(i);
        }
         else if (id == R.id.mywallet) {

        } else if (id == R.id.myoffers) {

        } else if (id == R.id.ratecard) {

        }
        else if (id == R.id.faq) {

        }
        else if (id == R.id.tnc) {

        }
        else if (id == R.id.policies) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            Intent i;
            switch (position){
                case 0:
                    i = new Intent(MainActivity.this, MobileRepair.class);
                    startActivity(i);
                    break;
                case 1:
                    i = new Intent(MainActivity.this, Refrigerator.class);
                    startActivity(i);
                    break;
                case 2:
                    i = new Intent(MainActivity.this, TV.class);
                    startActivity(i);
                    break;
                case 3:
                    i = new Intent(MainActivity.this, WashingMachine.class);
                    startActivity(i);
                    break;
                case 4:
                    i = new Intent(MainActivity.this, Laptops.class);
                    startActivity(i);
                    break;
                case 5:
                    i = new Intent(MainActivity.this, Desktops.class);
                    startActivity(i);
                    break;
                case 6:
                    i = new Intent(MainActivity.this, Iron.class);
                    startActivity(i);
                    break;
                case 7:
                    i = new Intent(MainActivity.this, HnC.class);
                    startActivity(i);
                    break;
                case 8:
                    i = new Intent(MainActivity.this, Others.class);
                    startActivity(i);
                    break;

            }

    }
}
