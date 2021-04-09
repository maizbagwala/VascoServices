package com.techspinsolutions.vascoservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class city_o_Activity extends AppCompatActivity {

    EditText et_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_o_);
        et_city = findViewById(R.id.et_city);


        findViewById(R.id.select_city_submit).setOnClickListener(v -> {
            if (et_city.getText().toString().equals("")) {
                et_city.setError("city is required");
            } else
                startActivity(new Intent(this, locatiom_o_Activity.class));
        });
    }
}