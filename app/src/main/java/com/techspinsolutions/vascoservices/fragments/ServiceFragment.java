package com.techspinsolutions.vascoservices.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.adapter.ServiceAdapter;
import com.techspinsolutions.vascoservices.model.Service_list_model;
import com.techspinsolutions.vascoservices.network.ApiRequest;
import com.techspinsolutions.vascoservices.utils.Variables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceFragment extends Fragment {


    Context context;
    String cat_id;
    ArrayList<Service_list_model> serviceList = new ArrayList<>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        context = view.getContext();
        MainActivity.setBottomSelected("");
        MainActivity.setAppbarWithBack(true);
        MainActivity.setAppbarText("AC Services & Repair");
        MainActivity.back_btn.setOnClickListener(v -> MainActivity.loadFragment(new HomeFragment()));

        Bundle bundle = getArguments();
        if (bundle != null) {
            String code = getArguments().getString("cat_id");
            if (code != null) {
                cat_id = code;
            }
        }
        RecyclerView recyclerView = view.findViewById(R.id.rv_services);

        JSONObject params = new JSONObject();
        try {
            params.put("cat_id", cat_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ApiRequest.Call_Api(context, Request.Method.GET, Variables.GET_SERVICE_LIST_URL, params, response -> {
            serviceList.clear();
            try {
                JSONObject jsonObject = new JSONObject(response);
                boolean responsecode = jsonObject.optBoolean("responce");
                if (responsecode) {
                    JSONArray data = jsonObject.getJSONArray("data");

                    for (int i = 0; i < data.length(); i++) {
                        Gson gson = new Gson();
                        Service_list_model service = gson.fromJson(data.getString(i), Service_list_model.class);
                        serviceList.add(service);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new ServiceAdapter(context, serviceList));
                    }

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, null);


        return view;
    }
}