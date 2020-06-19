package com.shalaka.facilitymonitoringsystem.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.shalaka.facilitymonitoringsystem.R;



public class DetailScreen1 extends Fragment {
Button btnNext;
View view;
EditText upr1,lwr1,upr2,lwr2;
Switch s1,s2;
    public void setTrackResource (int on){

    }


    public DetailScreen1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.screen1_detail, container, false);
        upr1=view.findViewById(R.id.t_upper_limit);
        lwr1=view.findViewById(R.id.t_lower_limit);
        upr2=view.findViewById(R.id.r_upper_limit);
        lwr2=view.findViewById(R.id.r_lower_limit);
        upr1.setEnabled(false);
        lwr1.setEnabled(false);
        upr2.setEnabled(false);
        lwr2.setEnabled(false);

        btnNext = view.findViewById(R.id.btnNext);

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

       s1=view.findViewById(R.id.switch1);
        s2=view.findViewById(R.id.switch2);


       s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s1.isChecked()) {
                    upr1.setEnabled(true);
                    upr1.setInputType(InputType.TYPE_CLASS_NUMBER);
                    upr1.setFocusable(true);
                    lwr1.setEnabled(true);
                    lwr1.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lwr1.setFocusable(true);


                } else {upr1.setEnabled(false);

                    lwr1.setEnabled(false);


                }

            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s2.isChecked()) {
                    upr2.setEnabled(true);
                    upr2.setInputType(InputType.TYPE_CLASS_NUMBER);
                    upr2.setFocusable(true);
                    lwr2.setEnabled(true);
                    lwr2.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lwr2.setFocusable(true);


                } else {upr2.setEnabled(false);

                    lwr2.setEnabled(false);


                }

            }
        });


        return view;
    }






}
