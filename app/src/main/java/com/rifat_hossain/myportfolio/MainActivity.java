package com.rifat_hossain.myportfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.rifat_hossain.myportfolio.CV.CV_Fragment;
import com.rifat_hossain.myportfolio.Contact.Contact_Fragment;
import com.rifat_hossain.myportfolio.Dashboard.Portfolio;
import com.rifat_hossain.myportfolio.Team.Team_fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private String file="My_Portfolio";
    private String filecontents , ttt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView=findViewById(R.id.mynavID);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Home_Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

//to check dark mode, start file operation here
        try {
            try {
                FileInputStream fin =openFileInput(file);
                int c;
                String temp = "";
                while ((c = fin.read()) != -1) {
                    temp = temp + Character.toString((char) c);
                }
                ttt = temp;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(ttt.isEmpty()){

            }
            else{
                if (ttt.contains("1")){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }

        }catch (Exception exception){
            String ppp = ""+0;
            try {
                FileOutputStream fout = getApplicationContext().openFileOutput(file, MODE_PRIVATE);
                fout.write(ppp.getBytes());
                fout.close();
                File filederectory = new File(getApplicationContext().getFilesDir(), file);
                Intent it=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(it);
                finish();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//to check dark mode, enc file operation here


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Home_Fragment()).commit();
                break;
            case R.id.nav_watch:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new CV_Fragment()).commit();
                break;
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Portfolio()).commit();
                break;
            case R.id.nav_group:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Team_fragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Contact_Fragment()).commit();
                break;

        }
        item.setCheckable(true);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO){
            menu.getItem(0).setIcon(R.drawable.ic_dark);
        }
        else {
            menu.getItem(0).setIcon(R.drawable.ic_light);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new Home_Fragment()).commit();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_dark:
                change_mode();
                return true;
            case R.id.menu_share:
                Toast.makeText(this, "HI3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_Feedback:
                Toast.makeText(this, "HI4", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_language:
                Toast.makeText(this, "HI5", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void change_mode() {
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            create_file(1);
           /* Intent it=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(it);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();*/
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            create_file(0);
            /*Intent it=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(it);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();*/
        }
    }
    void create_file(int i){
        String ppp = ""+i;
        try {
            FileOutputStream fout = openFileOutput(file, MODE_PRIVATE);
            fout.write(ppp.getBytes());
            fout.close();
            File filederectory = new File(getFilesDir(), file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}