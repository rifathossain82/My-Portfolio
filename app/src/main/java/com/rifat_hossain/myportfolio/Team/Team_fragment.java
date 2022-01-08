package com.rifat_hossain.myportfolio.Team;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.rifat_hossain.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

public class Team_fragment extends Fragment {
    RecyclerView recyclerView;
    List<Integer> profile;
    List<String> name,des;
    Team_adapter team_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_team_fragment, container, false);
        recyclerView=view.findViewById(R.id.recycler_team);

        profile=new ArrayList<>();
        profile.add(R.drawable.myprofile);
        profile.add(R.drawable.user1);
        profile.add(R.drawable.user2);
        profile.add(R.drawable.user3);
        profile.add(R.drawable.user4);
        profile.add(R.drawable.user5);


        name=new ArrayList<>();
        name.add("Rifat Hossain");
        name.add("Kawchar Ahmed");
        name.add("Nayem Hossain");
        name.add("Jobayer Hossain");
        name.add("Mr. Jhon");
        name.add("Debit Smith");

        des=new ArrayList<>();
        des.add("In case of some issues, please check the problem and resolve it before proceeding to the next steps. Try to fix by cleaning and rebuilding the project hope it works.");
        des.add("In case of some issues, please check the problem and resolve it before proceeding to the next steps. Try to fix by cleaning and rebuilding the project hope it works.");
        des.add("In case of some issues, please check the problem and resolve it before proceeding to the next steps. Try to fix by cleaning and rebuilding the project hope it works.");
        des.add("In case of some issues, please check the problem and resolve it before proceeding to the next steps. Try to fix by cleaning and rebuilding the project hope it works.");
        des.add("In case of some issues, please check the problem and resolve it before proceeding to the next steps. Try to fix by cleaning and rebuilding the project hope it works.");
        des.add("In case of some issues, please check the problem and resolve it before proceeding to the next steps. Try to fix by cleaning and rebuilding the project hope it works.");


        team_adapter=new Team_adapter(profile,name,des,getContext());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(team_adapter);


        return view;
    }
}