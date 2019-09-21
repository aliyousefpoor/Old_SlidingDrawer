package com.example.ali.slidingdrawer.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ali.slidingdrawer.Fragment.AboutFragment;
import com.example.ali.slidingdrawer.Fragment.ButtonFragment;
import com.example.ali.slidingdrawer.Fragment.ContactFragment;
import com.example.ali.slidingdrawer.Fragment.EditTextFragment;
import com.example.ali.slidingdrawer.Fragment.MainFragment;
import com.example.ali.slidingdrawer.Fragment.PictureFragment;
import com.example.ali.slidingdrawer.Fragment.SettingFragment;
import com.example.ali.slidingdrawer.Fragment.SmsFragment;
import com.example.ali.slidingdrawer.Fragment.TextFragment;
import com.example.ali.slidingdrawer.R;

/**
 * Created by Ali on 7/27/2017.
 */

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    NavigationView nv_view;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.DL);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nv_view = (NavigationView) findViewById(R.id.NA);
        navigation = (BottomNavigationView)findViewById(R.id.navigation);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {

                    case R.id.action1:
                        selectedFragment = PictureFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "See photos clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action2:
                        selectedFragment = ButtonFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "Click the Buttons ", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action3:
                        selectedFragment = TextFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "Text clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action4:
                        selectedFragment = EditTextFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "Fill the feild", Toast.LENGTH_SHORT).show();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, MainFragment.newInstance());
        transaction.commit();

        nv_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawer.closeDrawer(Gravity.RIGHT);
                Fragment selectedFragment = null;
                switch (item.getItemId()) {

                    case R.id.setting:
                        selectedFragment = SettingFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "تنظیمات کلیک شد", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.about:
                        selectedFragment = AboutFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "درباره ی ما کلیک شد", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.sms:
                        selectedFragment = SmsFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "دکمه ارسال را کلیک کنید", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.contact:
                        selectedFragment = ContactFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "ارتباط با ما کلیک شد", Toast.LENGTH_SHORT).show();
                        break;
                }

                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame_layout, selectedFragment);
                transaction1.commit();
                return true;
            }
        });


        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.frame_layout, MainFragment.newInstance());
        transaction1.commit();

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(Gravity.RIGHT)) {

            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }

    }
}

