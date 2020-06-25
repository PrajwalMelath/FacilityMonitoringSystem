package com.shalaka.facilitymonitoringsystem.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.shalaka.facilitymonitoringsystem.Activity.MainActivity;
import com.shalaka.facilitymonitoringsystem.R;

public class DetailScreen3 extends Fragment {
    Button btnPrev;
    View view;
    Switch alertSwitch;
    TextView recipientsText, recipientsList;

    public DetailScreen3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.screen3_detail, container, false);

        //change toolbar subtitle
        TextView toolbarSubtitle = (TextView) getActivity().findViewById(R.id.toolbar_subtitle);
        if (toolbarSubtitle != null){
            toolbarSubtitle.setText(R.string.alerts_toolbar_subtitle);
        } else {
            Log.d("TLBR", "Toolbar init failed");
        }

        btnPrev = view.findViewById(R.id.btnPrev);
        recipientsText = (TextView) view.findViewById(R.id.recipients_text);
        recipientsList = (TextView) view.findViewById(R.id.recipients_list);

        btnPrev.setOnClickListener(new View.OnClickListener() {
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

        alertSwitch = (Switch) view.findViewById(R.id.alerts_switch);
        alertSwitch.setChecked(true);
        alertSwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (alertSwitch.isChecked()){
                    recipientsText.setVisibility(TextView.VISIBLE);
                    recipientsList.setVisibility(TextView.VISIBLE);
                }
                else {
                    recipientsText.setVisibility(TextView.INVISIBLE);
                    recipientsList.setVisibility(TextView.INVISIBLE);
                }
            }
        });
        return view;
    }

}
