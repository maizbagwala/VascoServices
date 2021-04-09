package com.techspinsolutions.vascoservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class locatiom_o_Activity extends AppCompatActivity {
    EditText et_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locatiom_o_);
        et_location = findViewById(R.id.et_location);
        findViewById(R.id.location_submit).setOnClickListener(v -> {
            if (et_location.getText().toString().equals("")) {
                et_location.setError("location is required");
            } else
                startActivity(new Intent(this, MainActivity.class));
        });

    }
}