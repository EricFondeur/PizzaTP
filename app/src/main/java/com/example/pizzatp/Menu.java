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

    TextView zonePate, zoneIngre;
    public static final String PREFS_NAME = "Pizza";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String pate, taille, sauce;
    HashSet<String> ingreChoix=new HashSet<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ConstraintLayout monLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_menu, container, false);
        zonePate=monLayout.findViewById(R.id.ZonePate);
        zoneIngre=monLayout.findViewById(R.id.ZoneIngre);
        preferences = this.getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        pate=preferences.getString("Pate", null);
        taille=preferences.getString("Taille", null);
        sauce=preferences.getString("Sauce", null);
        zonePate.setText(pate+"-"+taille+"-"+sauce);
        ingreChoix=(HashSet<String>)preferences.getStringSet("nomIngre", null);
        for (String uneChaine:ingreChoix){
            zoneIngre.setText(String.valueOf(uneChaine));
        }

        return monLayout;
    }
}