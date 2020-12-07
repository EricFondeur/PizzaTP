package com.example.pizzatp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BoissonPerso_Adapter extends RecyclerView.Adapter<BoissonPerso_Adapter.BoissonPerso_ViewHolder> {

    Context leContext;
    ArrayList<BoissonPerso> listBoisson;

    public BoissonPerso_Adapter(Context leContext, ArrayList<BoissonPerso> listBoisson) {
        this.leContext = leContext;
        this.listBoisson = listBoisson;
    }

    @NonNull
    @Override
    public BoissonPerso_Adapter.BoissonPerso_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ObjInflater;
        ObjInflater=LayoutInflater.from(leContext);

        View ItemView=ObjInflater.inflate(R.layout.itemviewperso,parent,false);
        BoissonPerso_ViewHolder boissonPersoViewHolder=new BoissonPerso_ViewHolder(ItemView);
        return boissonPersoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BoissonPerso_Adapter.BoissonPerso_ViewHolder holder, int position) {
        BoissonPerso boissonPerso=listBoisson.get(position);
        holder.getNom().setText(boissonPerso.getNom());
        holder.getPrix().setText(Double.toString(boissonPerso.getPrix())+"€");
        holder.getImageView().setImageResource(boissonPerso.getImage());
    }

    @Override
    public int getItemCount() {
        return listBoisson.size();
    }

    public class BoissonPerso_ViewHolder extends RecyclerView.ViewHolder{

        TextView nom, prix;
        Button valider;
        ImageView imageView;

        public BoissonPerso_ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.Nom);
            prix = itemView.findViewById(R.id.Prix);
            valider = itemView.findViewById(R.id.Valide);
            imageView = itemView.findViewById(R.id.ImageView);
        }

        public TextView getNom() {
            return nom;
        }

        public void setNom(TextView nom) {
            this.nom = nom;
        }

        public TextView getPrix() {
            return prix;
        }

        public void setPrix(TextView prix) {
            this.prix = prix;
        }

        public Button getValider() {
            return valider;
        }

        public void setValider(Button valider) {
            this.valider = valider;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }
    }
}
