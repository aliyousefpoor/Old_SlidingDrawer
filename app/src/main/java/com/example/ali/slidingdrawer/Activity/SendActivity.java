package com.example.ali.slidingdrawer.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ali.slidingdrawer.R;

/**
 * Created by Ali on 7/28/2017.
 */

public class SendActivity extends AppCompatActivity {

    Button send;
    EditText ednumber;
    EditText edtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_layout);

        send = (Button)findViewById(R.id.send);
        ednumber = (EditText)findViewById(R.id.ednumber);
        edtext = (EditText)findViewById(R.id.edtext);

        send.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                String number = ednumber.getText().toString();
                String message = edtext.getText().toString();

                if (ednumber.getText().toString().isEmpty()){
                ednumber.setError("لطفا شماره را وارد کنید");}

                else{



                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(number,null,message,null,null);

                Toast.makeText(SendActivity.this,"پیام ارسال شد ",Toast.LENGTH_SHORT).show();}

            }
        });
}
    }