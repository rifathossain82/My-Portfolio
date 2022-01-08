package com.rifat_hossain.myportfolio.Dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rifat_hossain.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class bottom_sheet_dialog extends BottomSheetDialogFragment {
CircleImageView imageView;
TextView title,des;
    List<Integer> app_image;
    List<String> title_;
    List<String> des_;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);

        imageView=view.findViewById(R.id.app_icon_bottom);
        title=view.findViewById(R.id.title_bottom);
        des=view.findViewById(R.id.des_bottom);

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

        title_=new ArrayList<>();
        title_.add("আদর্শলিপি");
        title_.add("Beta Browser");
        title_.add("Calculator");
        title_.add("eshop");
        title_.add("PrePro");
        title_.add("QR Code Scanner");
        title_.add("Scanner Pro");
        title_.add("Unsplash");
        title_.add("Calculator Pro");

        des_=new ArrayList<>();
        des_.add("'Adorshalipi'(আদর্শলিপি) is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("Beta is an amazing browser for modern life. Here you will find some important websites that are necessary for our daily life. It is very fast and clear. It will make your life easier.");
        des_.add("'Adorshalipi' book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("'Adorshalipi' is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("'Adorshalipi' is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("'Adorshalipi' is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("'Adorshalipi' is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("'Adorshalipi' is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");
        des_.add("'Adorshalipi' is a book application for children. It carries everything at once. All topics are covered here. It has some new features and a great design that inspires a child to learn.");

        Bundle bundle=getArguments();
        imageView.setImageResource(app_image.get(bundle.getInt("data")));
        title.setText(title_.get(bundle.getInt("data")));
        des.setText(des_.get(bundle.getInt("data")));
        return view;
    }
     void set_data(){
        imageView.setImageResource(R.drawable.beta_browser);
        title.setText("hello");
        des.setText("eee");
     }
}