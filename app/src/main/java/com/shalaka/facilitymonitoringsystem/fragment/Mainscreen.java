package com.shalaka.facilitymonitoringsystem.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.shalaka.facilitymonitoringsystem.Activity.MainActivity;
import com.shalaka.facilitymonitoringsystem.Adapter.RoomAdapter;
import com.shalaka.facilitymonitoringsystem.R;

import org.w3c.dom.Text;

public class Mainscreen extends Fragment {
    View view;
    GridView gridViewAsset;

    public Mainscreen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.room_list, container, false);

        //change toolbar subtitle
        TextView toolbarSubtitle = (TextView) getActivity().findViewById(R.id.toolbar_subtitle);
        if (toolbarSubtitle != null){
            toolbarSubtitle.setText(R.string.room_toolbar_subtitle);
        } else {
            Log.d("TLBR", "Toolbar init failed");
        }

        gridViewAsset = view.findViewById(R.id.gridView);
        gridViewAsset.setAdapter(new RoomAdapter(getActivity()));
        gridViewAsset.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DeviceScreen assetListFragment2 = new DeviceScreen();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.container,assetListFragment2,null);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
