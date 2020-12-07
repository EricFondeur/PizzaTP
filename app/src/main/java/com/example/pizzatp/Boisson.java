package com.example.pizzatp;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Boisson extends Fragment {

    ArrayList<BoissonPerso> colBoisson;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    BoissonPerso_Adapter boissonPerso_adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ConstraintLayout monLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_boisson, container, false);
        RemplrCollection();
        AssocierWidgets(monLayout);
        layoutManager=new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        boissonPerso_adapter=new BoissonPerso_Adapter(this.getContext(), colBoisson);
        recyclerView.setAdapter(boissonPerso_adapter);
        return monLayout;
    }

    private void RemplrCollection(){
        colBoisson=new ArrayList<BoissonPerso>();
        colBoisson.add(new BoissonPerso(3.30, "Monster Mango Loco", R.drawable.monster));
        colBoisson.add(new BoissonPerso(3.30, "Coca-Cola", R.drawable.coca));
        colBoisson.add(new BoissonPerso(3.30, "Coca-Cola Sans Sucres", R.drawable.coca_ss));
        colBoisson.add(new BoissonPerso(3.30, "Coca-Cola Cherry", R.drawable.coca_c));
        colBoisson.add(new BoissonPerso(1.25, "Sprite", R.drawable.sprite));
        colBoisson.add(new BoissonPerso(3.30, "Fanta", R.drawable.fanta));
        colBoisson.add(new BoissonPerso(3.30, "Fuze Tea", R.drawable.fuze_tea));
        colBoisson.add(new BoissonPerso(2.50, "Pulco Citronnarde", R.drawable.pulco));
        colBoisson.add(new BoissonPerso(3.50, "Oasis Tropical", R.drawable.oasis));
        colBoisson.add(new BoissonPerso(3.50, "Oasis Pomme Cassis Frambroise", R.drawable.oasis_pcf));
        colBoisson.add(new BoissonPerso(1.00, "Evian", R.drawable.evian));
    }
    private void AssocierWidgets(ConstraintLayout monLayout){
        recyclerView=monLayout.findViewById(R.id.Liste);
    }
}