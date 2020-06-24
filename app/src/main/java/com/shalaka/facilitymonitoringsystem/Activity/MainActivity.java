package com.shalaka.facilitymonitoringsystem.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;


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


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);  //get reference to toolbar
        setSupportActionBar(toolbar);                               //set the toolbar as the actionbar

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                {if (id == R.id.aboutus){
                 openDialog();
                }
                    if (id == R.id.home){
                        Mainscreen assetListFragment2 = new Mainscreen();

                      FragmentManager fragmentManager=getSupportFragmentManager();
                              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.container,assetListFragment2,null);
                        fragmentTransaction.addToBackStack("");
                        fragmentTransaction.commit();
                    }
                    if (id == R.id.settings){
                        finish();
                        System.exit(0);
                    }
            }
               return true;
            }

            private void openDialog() {
                Aboutus aboutus= new Aboutus();
                aboutus.show(getSupportFragmentManager(),"example Dialog");
            }
        });


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        assetListFragment = new Mainscreen();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
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

}