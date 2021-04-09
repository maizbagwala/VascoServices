package com.techspinsolutions.vascoservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.techspinsolutions.vascoservices.utils.Functions;

public class mobile_o_Activity extends AppCompatActivity {

    EditText et_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_o_);

        et_mobile = findViewById(R.id.et_phone);


        findViewById(R.id.send_otp_btn).setOnClickListener(v -> {

            if (et_mobile.getText().toString().equals("")) {
                et_mobile.setError("Phone number is required");
            } else if (et_mobile.getText().toString().length() < 10) {
                et_mobile.setError("Phone number must be 10 digit long");
            } else {

                String otp = Functions.getRandomNumberString();
                Toast.makeText(this, "" + otp, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, otpActivity.class);
                intent.putExtra("otp", otp.trim());
                intent.putExtra("phone", et_mobile.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}