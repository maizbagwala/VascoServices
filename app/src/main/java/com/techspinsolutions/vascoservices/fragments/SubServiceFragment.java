package com.techspinsolutions.vascoservices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.adapter.SubServiceAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubServiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SubServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubServiceFragment newInstance(String param1, String param2) {
        SubServiceFragment fragment = new SubServiceFragment();
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
        View view = inflater.inflate(R.layout.fragment_sub_service, container, false);
        MainActivity.setBottomSelected("remove");
        MainActivity.setAppbarWithBack(true);
        MainActivity.setAppbarText("AC Service & Repair");
        MainActivity.back_btn.setOnClickListener(v -> MainActivity.loadFragment(new HomeFragment()));

        RecyclerView recyclerView = view.findViewById(R.id.rv_subservice);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SubServiceAdapter());

        view.findViewById(R.id.process_rl).setOnClickListener(v -> MainActivity.loadFragment(new CartFragment()));
        return view;
    }
}