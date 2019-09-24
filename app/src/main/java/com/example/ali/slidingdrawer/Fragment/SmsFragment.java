package com.example.ali.slidingdrawer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.ali.slidingdrawer.Activity.SendActivity;
import com.example.ali.slidingdrawer.R;

/**
 * Created by Ali on 7/28/2017.
 */

public class SmsFragment extends Fragment {

    Button send_btn;

    public static SmsFragment newInstance() {
        SmsFragment fragment = new SmsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_sms_layout, container, false);
        send_btn = (Button) view.findViewById(R.id.send_btn);


        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getActivity(), SendActivity.class));




            }
        });

        return view;
    }
}
