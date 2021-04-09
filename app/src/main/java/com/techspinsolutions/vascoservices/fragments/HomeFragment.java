package com.techspinsolutions.vascoservices.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jama.carouselview.CarouselView;
import com.jama.carouselview.enums.IndicatorAnimationType;
import com.jama.carouselview.enums.OffsetType;
import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.adapter.AppliancesAdapter;
import com.techspinsolutions.vascoservices.model.BannerModel;
import com.techspinsolutions.vascoservices.model.Category_list_model;
import com.techspinsolutions.vascoservices.network.ApiRequest;
import com.techspinsolutions.vascoservices.utils.Variables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    CarouselView carouselView;
    RecyclerView rv_appliances;
    Context context;


    ArrayList<BannerModel> bannerList = new ArrayList<>();
    ArrayList<Category_list_model> categoryList = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    int[] sampleImages = {R.drawable.o_01, R.drawable.o_02, R.drawable.o_03, R.drawable.o_04};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();
        MainActivity.setBottomSelected("home");
        MainActivity.setAppbarWithBack(false);
        rv_appliances = view.findViewById(R.id.rv_appliances);
        setCarouselView(view);


        MainActivity.HomeSearch.setOnClickListener(v -> MainActivity.loadFragment(new SearchFragment()));


        ApiRequest.Call_Api(context, Request.Method.GET, Variables.GET_CATEGORY_LIST_URL, null, response -> {

            categoryList.clear();
            try {
                JSONObject jsonObject = new JSONObject(response);
                boolean responsecode = jsonObject.optBoolean("responce");
                if (responsecode) {
                    JSONArray data = jsonObject.getJSONArray("data");

                    for (int i = 0; i < data.length(); i++) {
                        Gson gson = new Gson();
                        Category_list_model category = gson.fromJson(data.getString(i), Category_list_model.class);
                        categoryList.add(category);
                        rv_appliances.setLayoutManager(new GridLayoutManager(context, 2));
                        rv_appliances.setAdapter(new AppliancesAdapter(context, categoryList));
                    }

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, null);


        return view;
    }

    void setCarouselView(View view) {

        ApiRequest.Call_Api(context, Request.Method.GET, Variables.GET_BANNER_LIST_URL, null, response -> {
            Log.d(Variables.TAG, "setCarouselView: " + response);
            try {


                JSONObject jsonObject = new JSONObject(response);
                boolean responsecode = jsonObject.optBoolean("responce");
                if (responsecode) {
                    JSONArray data = jsonObject.getJSONArray("data");

                    for (int i = 0; i < data.length(); i++) {
                        Gson gson = new Gson();
                        BannerModel banner = gson.fromJson(data.getString(i), BannerModel.class);
                        bannerList.add(banner);
                    }

                    Log.d(Variables.TAG, "setCarouselView: banner" + bannerList.toString());

                    carouselView = view.findViewById(R.id.carouselView);
                    carouselView.setSize(bannerList.size());
                    carouselView.setResource(R.layout.image_carousel_item);
                    carouselView.setAutoPlay(true);
                    carouselView.hideIndicator(true);
                    carouselView.setIndicatorAnimationType(IndicatorAnimationType.THIN_WORM);
                    carouselView.setCarouselOffset(OffsetType.CENTER);
                    carouselView.setCarouselViewListener((view1, position) -> {
                        // Example here is setting up a full image carousel
                        ImageView imageView = view1.findViewById(R.id.imageview);
//                        imageView.setImageResource(sampleImages[position]);
                        Glide.with(context).load(Variables.IMG_BANNER_URL + bannerList.get(position).getImage()).placeholder(sampleImages[0]).into(imageView);

                    });
                    carouselView.show();

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }, null);

    }

}