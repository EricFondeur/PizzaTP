package com.example.pizzatp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout monTab;
    ViewPager viewPager;
    ImageView pateTest;
    public static final String PREFS_NAME = "Pizza";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        monTab=findViewById(R.id.MenuTab);
        viewPager=findViewById(R.id.ViewPager);
        PageAdapter madapt=new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(madapt);
        monTab.setupWithViewPager(viewPager);
        preferences = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    private void Init(){
        pateTest=findViewById(R.id.PateTest);
    }

}