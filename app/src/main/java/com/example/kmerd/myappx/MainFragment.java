package com.example.kmerd.myappx;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button mButton;
    private String mButtonText;
    private ListView mListViewDates;
    private ArrayAdapter<String> mDatesAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment instance(String buttonText){
        MainFragment mainFragment=new MainFragment();
        mainFragment.mButtonText=buttonText;
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mButton = view.findViewById(R.id.btn_main);
        mButton.setText(mButtonText);
        mButton.setOnClickListener(this);

        mListViewDates = view.findViewById(R.id.lv_dates);

        mDatesAdapter=new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1);

        mDatesAdapter.add(new Date().toString());

        mListViewDates.setAdapter(mDatesAdapter);
        mListViewDates.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
       // Toast.makeText(getContext(), "Hello!", Toast.LENGTH_SHORT).show();
        mDatesAdapter.add(new Date().toString());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String clickedDate=mDatesAdapter.getItem(i);
        Toast.makeText(getContext(), clickedDate, Toast.LENGTH_SHORT).show();
    }
}
