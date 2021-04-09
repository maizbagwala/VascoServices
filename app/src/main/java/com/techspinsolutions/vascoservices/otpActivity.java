package com.techspinsolutions.vascoservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.android.volley.Request;
import com.chaos.view.PinView;
import com.techspinsolutions.vascoservices.network.ApiRequest;
import com.techspinsolutions.vascoservices.network.Callback;
import com.techspinsolutions.vascoservices.utils.Variables;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class otpActivity extends AppCompatActivity {
    PinView pinView;
    String otp, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        pinView = findViewById(R.id.firstPinView);


        Intent intent = getIntent();
        if (!intent.getStringExtra("otp").equals("")) {
            otp = intent.getStringExtra("otp");
            phone = intent.getStringExtra("phone");
        }

        findViewById(R.id.submit_btn).setOnClickListener(v -> {

            if (Objects.requireNonNull(pinView.getText()).toString().length() < 6) {
                pinView.setLineWidth(3);
                pinView.setLineColor(
                        ResourcesCompat.getColorStateList(getResources(), R.color.red, getTheme()));
            } else {

                if (otp.contentEquals(pinView.getText())) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    register(phone);
                } else {
                    Toast.makeText(this, "OTP does not match", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void register(String phone) {
        JSONObject params = new JSONObject();
        try {
            params.put("user_phone", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ApiRequest.Call_Api(this, Request.Method.POST, Variables.REGISTER_URL, params, (Callback) response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                boolean resp = jsonObject.optBoolean("responce");
                if (resp) {
                    JSONObject data = jsonObject.optJSONObject("data");
                    int id = (int) data.get("user_id");
                    Log.d(Variables.TAG, "register: " + id);
                    startActivity(new Intent(this, city_o_Activity.class));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }, null);
    }
}