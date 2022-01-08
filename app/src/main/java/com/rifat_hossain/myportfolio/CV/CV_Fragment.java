package com.rifat_hossain.myportfolio.CV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rifat_hossain.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

public class CV_Fragment extends Fragment {
    List<String> date,des;
    List<String> date_e,des_e;
    CV_Adapter cv_adapter;
    CV_Adapter cv_adapter_e;
    RecyclerView recyclerView1,recyclerView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_c_v_, container, false);

        //initial recyclerview
        recyclerView1=view.findViewById(R.id.experience_recycler1);
        recyclerView2=view.findViewById(R.id.experience_recycler2);

        //professional experience start
        date=new ArrayList<>();
        date.add("20 April 2019");
        date.add("05 March 2020");
        date.add("15 December 2020");

        des=new ArrayList<>();
        des.add("After successfully project loaded run the application and check your navigation drawer activity is working properly or not. In case of some issues, please check the problem and resolve it before proceeding to the next steps.");
        des.add("After successfully project loaded run the application and check your navigation drawer activity is working properly or not. In case of some issues, please check the problem and resolve it before proceeding to the next steps.");
        des.add("After successfully project loaded run the application and check your navigation drawer activity is working properly or not. In case of some issues, please check the problem and resolve it before proceeding to the next steps.");

        cv_adapter = new CV_Adapter(date,des,getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(gridLayoutManager);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(cv_adapter);
        //professional experience end here

        //education start here
        date_e=new ArrayList<>();
        date_e.add("23 June 2017");
        date_e.add("10 January 2022");

        des_e=new ArrayList<>();
        des_e.add("After successfully project loaded run the application and check your navigation drawer activity is working properly or not. In case of some issues, please check the problem and resolve it before proceeding to the next steps.");
        des_e.add("After successfully project loaded run the application and check your navigation drawer activity is working properly or not. In case of some issues, please check the problem and resolve it before proceeding to the next steps.");

        cv_adapter_e = new CV_Adapter(date_e,des_e,getContext());
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(gridLayoutManager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(cv_adapter_e);
        return view;
    }
}