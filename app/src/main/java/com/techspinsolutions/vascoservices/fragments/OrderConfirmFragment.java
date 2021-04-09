package com.techspinsolutions.vascoservices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;

import static com.techspinsolutions.vascoservices.MainActivity.setAppbarText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderConfirmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderConfirmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderConfirmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderConfirmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderConfirmFragment newInstance(String param1, String param2) {
        OrderConfirmFragment fragment = new OrderConfirmFragment();
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
        View view = inflater.inflate(R.layout.fragment_order_confirm, container, false);
        MainActivity.setAppbarWithBack(true);
        MainActivity.setBottomSelected("");
        setAppbarText("Order Confirm");
        MainActivity.back_btn.setOnClickListener(v -> MainActivity.loadFragment(new HomeFragment()));

        return view;
    }
}