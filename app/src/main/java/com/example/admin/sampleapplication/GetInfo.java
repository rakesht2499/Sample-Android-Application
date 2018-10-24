package com.example.admin.sampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GetInfo extends AppCompatActivity {

    TextView tvResultInfo;
    EditText etNumber;
    Button btnSubmitInfo,btnExitInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        tvResultInfo = findViewById(R.id.tvResultInfo);
        etNumber = findViewById(R.id.etNumber);
        btnSubmitInfo = findViewById(R.id.btnSubmitInfo);
        btnExitInfo = findViewById(R.id.btnexitInfo);

        btnExitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetInfo.this.finish();
            }
        });

        btnSubmitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip, sgender, snationality, dob;
                int gender, nationality;

                ip = etNumber.getText().toString().trim();
                if(ip.isEmpty()){
                    Toast.makeText(GetInfo.this, "Field Cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(ip.length() <=10){
                    Toast.makeText(GetInfo.this, "Kindly Enter a 11 digit number", Toast.LENGTH_SHORT).show();
                }
                else{
                    dob = ip.substring(0, 6);
                    gender = Integer.parseInt(Character.toString(ip.charAt(6)));;
                    if (gender < 5) {
                        sgender = "Female";
                    } else {
                        sgender = "Male";
                    }

                    nationality = Integer.parseInt(Character.toString(ip.charAt(10)));
                    if (nationality == 0) snationality = "Indian citizen";
                    else snationality = "Permanent Resident";

                    String output = "Date of Birth: " + dob.substring(4, 6) + "/" + dob.substring(2, 4) + "/" + dob.substring(0, 2) + "\n"
                            + "Sex: " + sgender + "\n" + "Nationality: " + snationality;

                    tvResultInfo.setText(output);

                }

            }
        });

    }
}
