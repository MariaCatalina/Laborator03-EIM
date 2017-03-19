package com.example.cata.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonStar, buttonDiez;

    private EditText edNumber;
    private StringBuilder number;

    private ImageButton backspace, startCall, endCall, contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNumber = (EditText) findViewById(R.id.phoneEditText);
        number = new StringBuilder();

        backspace = (ImageButton) findViewById(R.id.backspace);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number.length() > 0){
                    Log.i(TAG, "onClick: " + number + " -> " + (number.length() - 1)  + " ,  " + (number.length() - 2));
                    number.delete(number.length() -1 , number.length() );

                    edNumber.setText(number);
                }
            }
        });


        startCall = (ImageButton) findViewById(R.id.startCall);
        startCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Constants.PERMISSION_REQUEST_CALL_PHONE);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + edNumber.getText().toString()));
                    startActivity(intent);
                }
            }
        });


        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("0");
                edNumber.setText(number);
            }
        });

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("1");
                edNumber.setText(number);
            }
        });


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("2");
                edNumber.setText(number);
            }
        });



        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("3");
                edNumber.setText(number);
            }
        });


        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("4");
                edNumber.setText(number);
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("5");
                edNumber.setText(number);
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("6");
                edNumber.setText(number);
            }
        });

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("7");
                edNumber.setText(number);
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("8");
                edNumber.setText(number);
            }
        });

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("9");
                edNumber.setText(number);
            }
        });

        buttonStar = (Button) findViewById(R.id.buttonStar);
        buttonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("*");
                edNumber.setText(number);
            }
        });

        buttonDiez = (Button) findViewById(R.id.buttonDiez);
        buttonDiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.append("#");
                edNumber.setText(number);
            }
        });


        contacts = (ImageButton) findViewById(R.id.contacts);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("ro.pub.cs.systems.eim.lab04.ContactsManagerActivity");
                intent.putExtra("phone", edNumber.getText().toString());

                startActivity(intent);

            }
        });
    }


}
