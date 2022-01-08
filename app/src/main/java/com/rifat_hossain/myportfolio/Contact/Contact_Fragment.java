package com.rifat_hossain.myportfolio.Contact;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rifat_hossain.myportfolio.R;
public class Contact_Fragment extends Fragment {
    TextView address,tel,whatsapp,email;
    public static final int Request_call=1;
    Typeface typeface;
    ImageView facebook,instagram,twitter,linkdin,youtube;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact_, container, false);

        address=view.findViewById(R.id.text_contact);
        tel=view.findViewById(R.id.text_tel);
        whatsapp=view.findViewById(R.id.text_whatsapp);
        email=view.findViewById(R.id.text_email);

        facebook=view.findViewById(R.id.facebook_imgView_id);
        instagram=view.findViewById(R.id.instagram_imgView_id);
        twitter=view.findViewById(R.id.twitter_imgView_id);
        linkdin=view.findViewById(R.id.linkdin_imgView_id);
        youtube=view.findViewById(R.id.youtube_imgView_id);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://www.facebook.com/rh.rifat.33633";
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link)));
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://www.instagram.com/rh_rifat220";
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link)));
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://twitter.com/Rifatho25073502";
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link)));
            }
        });
        linkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://www.linkedin.com/in/rifat-hossain-66811b201";
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link)));
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://www.youtube.com/channel/UCHQjehNirRNYmWtYK0rh9jg";
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link)));
            }
        });


        String text_address="Foleshwor-30, Feni Sadar, Feni.";
        String text_tel="+880 1882508771";
        String text_whatsapp="+880 1882508771";
        String text_email="rhrifat940279@gmail.com";

        SpannableString sp1=new SpannableString(text_address);
        SpannableString sp2=new SpannableString(text_tel);
        SpannableString sp3=new SpannableString(text_whatsapp);
        SpannableString sp4=new SpannableString(text_email);

        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent it=new Intent(Intent.ACTION_VIEW);
                it.setData(Uri.parse("https://www.google.com/maps/place/Ali+Ajjom+Jame+Masjid/@23.034213,91.4093453,793m/data=!3m2!1e3!4b1!4m5!3m4!1s0x375369aefa60237d:0x76a12caad2eeff93!8m2!3d23.0342977!4d91.411514?hl=en"));
                startActivity(it);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                ds.setColor(Color.parseColor("#9B9B9B"));
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan2=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                phone_call();
            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                ds.setColor(Color.parseColor("#9B9B9B"));
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan3=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan clickableSpan4=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                try {
                    Intent it = new Intent(Intent.ACTION_SEND);
                    it.putExtra(Intent.EXTRA_EMAIL, new String[]{"rhrifat940279@gmail.com"});
                    it.putExtra(Intent.EXTRA_SUBJECT, "");
                    it.putExtra(Intent.EXTRA_TEXT, "");
                    it.setType("message/rfc822");

                    startActivity(it);
                }catch (Exception e){
                    Toast.makeText(getContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                ds.setColor(Color.parseColor("#9B9B9B"));
                ds.setUnderlineText(true);
            }
        };

        sp1.setSpan(clickableSpan1,0,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp2.setSpan(clickableSpan2,0,15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //sp3.setSpan(clickableSpan3,10,25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp4.setSpan(clickableSpan4,0,23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        address.setText(sp1);
        tel.setText(sp2);
        //whatsapp.setText(sp3);
        email.setText(sp4);

        address.setMovementMethod(LinkMovementMethod.getInstance());
        tel.setMovementMethod(LinkMovementMethod.getInstance());
       // whatsapp.setMovementMethod(LinkMovementMethod.getInstance());
        email.setMovementMethod(LinkMovementMethod.getInstance());



        return view;
    }

    void phone_call(){
        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},Request_call);
        }
        else{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+"01882508771"));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==Request_call){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                phone_call();
            }
            else {
                Toast.makeText(getContext(), "Permission Denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}