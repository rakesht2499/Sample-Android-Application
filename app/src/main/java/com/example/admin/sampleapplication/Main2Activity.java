package com.example.admin.sampleapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Objects;

public class Main2Activity extends AppCompatActivity implements frag1.IndexList{

    ImageView imBackP;
    TextView tv;
    String [] res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        res = getResources().getStringArray(R.array.description);
        tv = findViewById(R.id.tvres);
        imBackP = findViewById(R.id.imBackP);

        imBackP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.this.finish();
            }
        });
//        Portrait Mode
        if(findViewById(R.id.layout_portrait) != null){
            tv.setText("You are in Portrait Mode");
        }

//        Landscape Mode
        if(findViewById(R.id.layout_land) != null){
            tv.setText("You are in Landscape Mode");
        }

    }

    @Override
    public void getIndex(int index) {
        if(findViewById(R.id.layout_portrait) != null){
            tv.setText("You are in Portrait Mode\n");
        }
        if(findViewById(R.id.layout_land) != null){
            tv.setText("You are in Landscape Mode\n");
        }
        tv.setText(res[index]);
    }
}
