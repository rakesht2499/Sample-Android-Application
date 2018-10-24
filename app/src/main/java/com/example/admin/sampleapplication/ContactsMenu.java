package com.example.admin.sampleapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsMenu extends AppCompatActivity {

    ImageView imgCall,imNavigate,imBackButton,imLinkedIn;
    TextView tvNameContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_menu);

        String name = getIntent().getStringExtra("name");
        String number = getIntent().getStringExtra("number");
        String Address = getIntent().getStringExtra("address");
        String linkedIn = getIntent().getStringExtra("linkedIn");

        if(linkedIn.isEmpty()){
            findViewById(R.id.imLinkedIn).setVisibility(View.GONE);
            findViewById(R.id.textView10).setVisibility(View.GONE);
        }

        imBackButton = findViewById(R.id.imBackButton);
        imgCall = findViewById(R.id.imCall);
        imNavigate = findViewById(R.id.imNavigate);
        imLinkedIn = findViewById(R.id.imLinkedIn);
        tvNameContacts = findViewById(R.id.tvNameContacts);

        tvNameContacts.setText("Hey!! " + "Contact your Friend " + name);

        final String uriparse = "tel:"+number;
        final String uriAddress = "geo:0,0?q=" + Address;
        final String uriLinked = "https://www.linkedin.com/in/" + linkedIn;

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(uriparse));
                startActivity(intent);
            }
        });

        imNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriAddress));
                startActivity(intent);
            }
        });

        imLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriLinked));
                startActivity(intent);
            }
        });

        imBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactsMenu.this.finish();
            }
        });
    }
}
