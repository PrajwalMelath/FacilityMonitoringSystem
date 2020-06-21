package com.shalaka.facilitymonitoringsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.shalaka.facilitymonitoringsystem.R;
import com.shalaka.facilitymonitoringsystem.fragment.Mainscreen;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Mainscreen assetListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assetListFragment = new Mainscreen();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, assetListFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}