package com.example.ali.slidingdrawer.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ali.slidingdrawer.R;

/**
 * Created by Ali on 7/28/2017.
 */

public class SettingFragment extends Fragment {

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=null;
        view = inflater.inflate(R.layout.fragment_setting_layout, container, false);

        return view;

    }
}
