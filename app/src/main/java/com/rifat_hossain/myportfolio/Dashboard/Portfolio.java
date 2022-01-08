package com.rifat_hossain.myportfolio.Dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.rifat_hossain.myportfolio.Home_Fragment;
import com.rifat_hossain.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

public class Portfolio extends Fragment implements Call_back{
List<Integer> app_image;
RecyclerView recyclerView;
Portfolio_Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_portfolio, container, false);

        recyclerView=view.findViewById(R.id.recycler_portfolio);

        app_image=new ArrayList<>();
        app_image.add(R.drawable.adorsholopi_logo);
        app_image.add(R.drawable.beta_browser);
        app_image.add(R.drawable.calculaotr_logo);
        app_image.add(R.drawable.ecommerce_logo_app);
        app_image.add(R.drawable.prepro_logo);
        app_image.add(R.drawable.scanner_logo);
        app_image.add(R.drawable.scanner_por);
        app_image.add(R.drawable.unsplash_logo);
        app_image.add(R.drawable.calculator_pro);

        adapter=new Portfolio_Adapter(getContext(),app_image,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3, GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(int pos) {
        bottom_sheet_dialog bb=new bottom_sheet_dialog();
        Bundle bundle=new Bundle();
        bundle.putInt("data",pos);
        bb.setArguments(bundle);
        bb.show(getActivity().getSupportFragmentManager(),"you");
    }
}