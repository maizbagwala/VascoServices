package com.techspinsolutions.vascoservices.network;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.techspinsolutions.vascoservices.utils.Variables;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {
    public static void Call_Api(final Context context, int method, String url, @Nullable JSONObject jsonObject,
                                     final Callback callback, @Nullable HashMap<String, String> headers) {

        Log.d(Variables.TAG, "Call_Api: " + url);
        if (jsonObject != null) {
            Log.d(Variables.TAG, "Call_Api: " + jsonObject.toString());
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject, response -> {
            Log.d(Variables.TAG, "Call_Api: " + response.toString());
            if (callback != null) {
                callback.Response(response.toString());
            }

        }, error -> {
            Log.d(Variables.TAG, "Call_Api: " + error.toString());
            if (callback != null) {
                callback.Response(error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers != null) {
                    return headers;
                } else {
                    return super.getHeaders();
                }
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonObjectRequest);

    }
}
