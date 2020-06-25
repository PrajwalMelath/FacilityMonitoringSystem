package com.shalaka.facilitymonitoringsystem.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;
import com.shalaka.facilitymonitoringsystem.R;
import com.shalaka.facilitymonitoringsystem.fragment.Aboutus;
import com.shalaka.facilitymonitoringsystem.fragment.DetailScreen2;
import com.shalaka.facilitymonitoringsystem.fragment.DeviceScreen;
import com.shalaka.facilitymonitoringsystem.fragment.Mainscreen;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Mainscreen assetListFragment;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);  //get reference to toolbar
        setSupportActionBar(toolbar);                               //set the toolbar as the actionbar

        // set up the navigation drawer and its icon
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // set the methods called when items in the navigation drawer are clicked
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // opens the about us dialog when that item is clicked
                if (id == R.id.aboutus){
                    openDialog();
                }

                // when logout item is clicked
                if (id == R.id.logout){
                    // create a dialog that asks user if sure to exit
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.app_name);
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setMessage("Do you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
               return true;
            }
            // function to display about us dialog
            private void openDialog() {
                Aboutus aboutus = new Aboutus();
                aboutus.show(getSupportFragmentManager(),"example Dialog");
            }
        });

        // configure the fragment manager
        assetListFragment = new Mainscreen();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // init a new fragment within container
        fragmentTransaction.add(R.id.container, assetListFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showFroyoOrder(View view) { Mainscreen assetListFragment2 = new Mainscreen();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,assetListFragment2,null);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();

    }
}