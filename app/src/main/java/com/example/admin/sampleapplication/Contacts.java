package com.example.admin.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contacts extends AppCompatActivity {

    EditText etName,etPhone,etAddress,etLinkedIn;
    Button btnSubmitContacts,btnExitContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etLinkedIn = findViewById(R.id.etLinkedIn);
        btnSubmitContacts = findViewById(R.id.btnSubmitContacts);
        btnExitContacts = findViewById(R.id.btnExitContacts);


        btnExitContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacts.this.finish();
            }
        });

        btnSubmitContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String number = etPhone.getText().toString();
                String linkedIn = etLinkedIn.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(Contacts.this, "Kindly Enter The Name", Toast.LENGTH_SHORT).show();
                }else if(address.isEmpty()){
                    Toast.makeText(Contacts.this, "Kindly Enter the address", Toast.LENGTH_SHORT).show();
                }else if(number.length() < 10){
                    Toast.makeText(Contacts.this, "Kindly Enter a 10 digit Number", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intentContact = new Intent(Contacts.this, com.example.admin.sampleapplication.ContactsMenu.class);
                    intentContact.putExtra("name", name);
                    intentContact.putExtra("number", number);
                    intentContact.putExtra("address", address);
                    intentContact.putExtra("linkedIn", linkedIn);
                    startActivity(intentContact);
                }
            }
        });
    }
}
