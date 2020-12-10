package com.example.pizzatp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.preference.Preference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Pate extends Fragment implements View.OnClickListener{

    Spinner spinPate;
    Spinner spinTaille;
    Spinner spinSauce;
    ArrayAdapter<String> adapterPate;
    ArrayAdapter<String> adapterTaille;
    ArrayAdapter<String> adapterSauce;
    String []Pate={"medium", "large", "XL"};
    String []Taille={"Classique", "Mozza Crust", "Pan", "Pâte Fine"};
    String []Sauce={"Base Sauce BBQ", "Base Crème Fraiche Française", "Base Sauce Tomate"};
    Button valider;
    public static final String PREFS_NAME = "Pizza";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ConstraintLayout monLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_pate, container, false);
        Init(monLayout);
        adapterPate = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, Pate);
        adapterTaille = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, Taille);
        adapterSauce = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, Sauce);
        spinPate.setAdapter(adapterPate);
        spinTaille.setAdapter(adapterTaille);
        spinSauce.setAdapter(adapterSauce);
        valider.setOnClickListener(this);
        preferences = this.getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
        return monLayout;
    }

    public void Init(ConstraintLayout monLayout){
        spinPate=monLayout.findViewById(R.id.SpinPate);
        spinTaille=monLayout.findViewById(R.id.SpinTaille);
        spinSauce=monLayout.findViewById(R.id.SpinSauce);
        valider=monLayout.findViewById(R.id.Valider);
    }


    @Override
    public void onClick(View v) {
        editor.putString("Pate", spinPate.getSelectedItem().toString());
        editor.putString("Taille", spinTaille.getSelectedItem().toString());
        editor.putString("Sauce", spinSauce.getSelectedItem().toString());
        editor.commit();
        MainActivity main =new MainActivity();
        main.setPateTest(R.drawable.check);
    }

}