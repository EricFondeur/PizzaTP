package com.example.pizzatp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;


public class Ingredients extends Fragment implements View.OnClickListener{

    ImageView lesIngredients[]=new ImageView[25];
    ImageView lesIngreChoisis[]=new ImageView[4];
    TextView textIngre[]=new TextView[25];
    Button valider;
    HashSet<String> ingreChoix=new HashSet<>();
    public static final String PREFS_NAME = "Pizza";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ConstraintLayout monLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_ingredients, container, false);
        Init(monLayout);
        preferences = this.getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
        if (preferences.contains("nomIngre"))
            valider.setEnabled(false);
        return monLayout;
    }
    private void Init(ConstraintLayout monLayout){
        for (int i=0; i<25; i++){
            String imageID="imageView"+i;
            int resID=getResources().getIdentifier(imageID,"id", getActivity().getPackageName());
            lesIngredients[i]=monLayout.findViewById(resID);
            lesIngredients[i].setOnClickListener(this);
        }
        for (int i=1; i<=4; i++){
            String imageID="Ingre"+i;
            int resID=getResources().getIdentifier(imageID,"id", getActivity().getPackageName());
            lesIngreChoisis[i-1]=monLayout.findViewById(resID);
            lesIngreChoisis[i-1].setVisibility(View.INVISIBLE);
        }
        for (int i=1; i<25; i++) {
            String imageID = "IngreText" + i;
            int resID = getResources().getIdentifier(imageID, "id", getActivity().getPackageName());
            textIngre[i] = monLayout.findViewById(resID);
        }
        valider=monLayout.findViewById(R.id.ValideIngre);
        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView0:
                Ajout(R.drawable.ananas, 0);
                break;
            case R.id.imageView1:
                Ajout(R.drawable.bacon,1);
                break;
            case R.id.imageView2:
                Ajout(R.drawable.boullettes_de_boeuf_assaisonnees,2);
                break;
            case R.id.imageView3:
                Ajout(R.drawable.champignons,3);
                break;
            case R.id.imageView4:
                Ajout(R.drawable.chevre,4);
                break;
            case R.id.imageView5:
                Ajout(R.drawable.creme_fraiche_legere,5);
                break;
            case R.id.imageView6:
                Ajout(R.drawable.emmental,6);
                break;
            case R.id.imageView7:
                Ajout(R.drawable.figue_sechees,7);
                break;
            case R.id.imageView8:
                Ajout(R.drawable.fourne_ambert,8);
                break;
            case R.id.imageView9:
                Ajout(R.drawable.jambon,9);
                break;
            case R.id.imageView10:
                Ajout(R.drawable.lardon,10);
                break;
            case R.id.imageView11:
                Ajout(R.drawable.fondue,11);
                break;
            case R.id.imageView12:
                Ajout(R.drawable.merguez,12);
                break;
            case R.id.imageView13:
                Ajout(R.drawable.miel,13);
                break;
            case R.id.imageView14:
                Ajout(R.drawable.mozzarella,14);
                break;
            case R.id.imageView15:
                Ajout(R.drawable.oignons,15);
                break;
            case R.id.imageView16:
                Ajout(R.drawable.olive_noires,16);
                break;
            case R.id.imageView17:
                Ajout(R.drawable.origan,17);
                break;
            case R.id.imageView18:
                Ajout(R.drawable.pepperoni,18);
                break;
            case R.id.imageView19:
                Ajout(R.drawable.piments,19);
                break;
            case R.id.imageView20:
                Ajout(R.drawable.poivrons,20);
                break;
            case R.id.imageView21:
                Ajout(R.drawable.pomme_de_terre,21);
                break;
            case R.id.imageView22:
                Ajout(R.drawable.poulet_roti,22);
                break;
            case R.id.imageView23:
                Ajout(R.drawable.reblochon,23);
                break;
            case R.id.imageView24:
                Ajout(R.drawable.sauce_bbq,24);
                break;
            case R.id.ValideIngre:
                EnvoiInfo();
                valider.setEnabled(false);
                break;
        }
    }

    private void EnvoiInfo(){
        editor.putStringSet("nomIngre", ingreChoix);
        editor.commit();
    }

    private void Ajout(int image, int num){
        int i=0;
        if(TestChoix()) {
            while (lesIngreChoisis[i].getVisibility() == View.VISIBLE) {i++;}
            lesIngreChoisis[i].setImageResource(image);
            lesIngreChoisis[i].setVisibility(View.VISIBLE);
            ingreChoix.add(textIngre[num].getText().toString());
        }
    }

    private boolean TestChoix(){
        boolean test = false;
        for (int i=0; i<4; i++){
            if (lesIngreChoisis[i].getVisibility()==View.INVISIBLE)
                test=true;
            else
                test=false;
        }
        return test;
    }

}