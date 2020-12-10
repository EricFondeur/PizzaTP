package com.example.pizzatp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashSet;


public class Menu extends Fragment {

    TextView zonePate, zoneIngre, zoneBoisson;
    public static final String PREFS_NAME = "Pizza";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String pate, taille, sauce, boisson;
    HashSet<String> ingreChoix=new HashSet<>();

    @Override
    public void onResume() {
        super.onResume();
        pate=preferences.getString("Pate", null);
        taille=preferences.getString("Taille", null);
        sauce=preferences.getString("Sauce", null);
        ingreChoix=(HashSet<String>)preferences.getStringSet("nomIngre", null);
        boisson=preferences.getString("Boisson", null);
        if (!preferences.contains("Pate")){

        }else{
            zonePate.setText(pate+"-"+taille+"-"+sauce);
            for (String uneChaine:ingreChoix){
                zoneIngre.append(String.valueOf(uneChaine));
            }
            Log.i("testBoisson", "boisson: "+boisson);
            zoneBoisson.setText(boisson);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ConstraintLayout monLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_menu, container, false);
        zonePate=monLayout.findViewById(R.id.ZonePate);
        zoneIngre=monLayout.findViewById(R.id.ZoneIngre);
        zoneBoisson=monLayout.findViewById(R.id.ZoneBoisson);
        preferences = this.getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return monLayout;
    }
}