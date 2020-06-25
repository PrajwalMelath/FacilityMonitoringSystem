package com.shalaka.facilitymonitoringsystem.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.shalaka.facilitymonitoringsystem.Activity.MainActivity;
import com.shalaka.facilitymonitoringsystem.R;


public class DetailScreen1 extends Fragment {
    Button btnNext;
    View view;
    EditText t_upper, t_lower, h_upper, h_lower;
    Switch temp_switch, hum_switch;
    
    public void setTrackResource (int on){ }
    
    public DetailScreen1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.screen1_detail, container, false);

        //change toolbar subtitle
        TextView toolbarSubtitle = (TextView) getActivity().findViewById(R.id.toolbar_subtitle);
        if (toolbarSubtitle != null){
            toolbarSubtitle.setText(R.string.screen1_toolbar_subtitle);
        } else {
            Log.d("TLBR", "Toolbar init failed");
        }

        // initialise View objects
        btnNext = view.findViewById(R.id.btnNext);
        temp_switch = view.findViewById(R.id.temp_switch);
        hum_switch = view.findViewById(R.id.hum_switch);
        
        t_upper = view.findViewById(R.id.edit_temp_high_limit2);
        t_lower = view.findViewById(R.id.edit_temp_low_limit);
        h_upper = view.findViewById(R.id.edit_hum_high_limit);
        h_lower = view.findViewById(R.id.edit_hum_low_limit);

        // all alerts are off by default
        t_upper.setEnabled(false);
        t_lower.setEnabled(false);
        h_upper.setEnabled(false);
        h_lower.setEnabled(false);
        
        temp_switch.setChecked(false);
        hum_switch.setChecked(false);

        // when btnNext is clicked, open the DetailScreen2 fragment in container
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailScreen2 assetControllingFragment = new DetailScreen2();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container,assetControllingFragment,null);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        //if temp switch is checked, enable the edittext inputs
        temp_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp_switch.isChecked()) {
                    t_upper.setEnabled(true);
                    t_upper.setFocusable(true);
                    t_lower.setEnabled(true);
                    t_lower.setFocusable(true);
                } else {t_upper.setEnabled(false);
                    t_lower.setEnabled(false);
                }

            }
        });

        hum_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hum_switch.isChecked()) {
                    h_upper.setEnabled(true);
                    h_upper.setFocusable(true);
                    h_lower.setEnabled(true);
                    h_lower.setFocusable(true);
                } else {h_upper.setEnabled(false);
                    h_lower.setEnabled(false);
                }

            }
        });
        return view;
    }






}
