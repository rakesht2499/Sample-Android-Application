package com.example.admin.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFood,btnGetInfo,btnContact,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnFood = findViewById(R.id.btnFood);
        btnGetInfo = findViewById(R.id.btnGetInfo);
        btnContact = findViewById(R.id.btnContacts);
        btnExit = findViewById(R.id.btnexit);

        //******************** FOOD DESCRIPTION(FRAGMENTS) *********************
        btnFood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.admin.sampleapplication.Main2Activity.class);
                startActivity(intent);
            }
        });

        //********************  ADD CONTACTS (INTENS) *********************
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContact = new Intent(MainActivity.this,com.example.admin.sampleapplication.Contacts.class);
                startActivity(intentContact);
            }
        });

        //******************** GET INFO BY ID(FIRST APP) *********************
        btnGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_info = new Intent(MainActivity.this,com.example.admin.sampleapplication.GetInfo.class);
                startActivity(intent_info);

            }
        });

        //******************** EXIT PROGRAM *********************
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }
}
