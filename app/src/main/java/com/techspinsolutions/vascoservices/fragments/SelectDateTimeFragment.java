package com.techspinsolutions.vascoservices.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver;
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager;
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendar;
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter;
import com.michalsvec.singlerowcalendar.utils.DateUtils;
import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.adapter.SlotAdapter;

import java.util.Calendar;
import java.util.Date;

//import java.util.Calendar;
//
//import devs.mulham.horizontalcalendar.HorizontalCalendar;
//import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectDateTimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectDateTimeFragment extends Fragment {

    Calendar calendar;
    Context context;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelectDateTimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectDateTimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectDateTimeFragment newInstance(String param1, String param2) {
        SelectDateTimeFragment fragment = new SelectDateTimeFragment();
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
        View view = inflater.inflate(R.layout.fragment_select_date_time, container, false);
        context = view.getContext();

        calendar = Calendar.getInstance();


        MainActivity.setBottomSelected("");
        MainActivity.setAppbarWithBack(true);
        MainActivity.setAppbarText("Select Date & Time");
        MainActivity.back_btn.setOnClickListener(v -> MainActivity.loadFragment(new HomeFragment()));

        RecyclerView recyclerView = view.findViewById(R.id.rv_slot);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.setAdapter(new SlotAdapter());


        CalendarViewManager calendarViewManager = new CalendarViewManager() {
            @Override
            public int setCalendarViewResourceId(int i, Date date, boolean b) {
                if (b) {
                    return R.layout.selected_calander_layout;
                } else
                    return R.layout.unselected_calander_layout;

            }

            @Override
            public void bindDataToCalendarView(SingleRowCalendarAdapter.CalendarViewHolder holder, Date date, int i, boolean b) {
                ((TextView) holder.itemView.findViewById(R.id.tv_date_calendar_item)).setText(DateUtils.INSTANCE.getDayNumber(date));
                ((TextView) holder.itemView.findViewById(R.id.tv_day_calendar_item)).setText(DateUtils.INSTANCE.getDay3LettersName(date));

            }
        };

        CalendarChangesObserver observer = new CalendarChangesObserver() {
            @Override
            public void whenWeekMonthYearChanged(String s, String s1, String s2, String s3, Date date) {

            }

            @Override
            public void whenSelectionChanged(boolean b, int i, Date date) {

            }

            @Override
            public void whenCalendarScrolled(int i, int i1) {

            }

            @Override
            public void whenSelectionRestored() {

            }

            @Override
            public void whenSelectionRefreshed() {

            }
        };

        SingleRowCalendar singleRowCalendar = view.findViewById(R.id.main_single_row_calendar);
        singleRowCalendar.calendarViewManager = calendarViewManager;
//        singleRowCalendar.setDates();
        return view;
    }
}