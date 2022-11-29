package com.example.crudapp.adapters;

import android.content.Intent;
import android.hardware.lights.LightState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapp.AddMedecinActivity;
import com.example.crudapp.MainActivity;
import com.example.crudapp.databinding.MedecinItemLayoutBinding;
import com.example.crudapp.models.Medecin;

import java.util.List;

public class RecyclerViewMedecinAdapter extends RecyclerView.Adapter<RecyclerViewMedecinAdapter.MyViewHolder> {

   List<Medecin> medecinList;
   MainActivity context;

    public RecyclerViewMedecinAdapter(List<Medecin> medecinList,MainActivity context) {
        this.medecinList = medecinList;
        this.context= context;
    }

    @NonNull
    @Override
    public RecyclerViewMedecinAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        MedecinItemLayoutBinding binding=MedecinItemLayoutBinding.inflate(layoutInflater,parent,false);
        return new RecyclerViewMedecinAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMedecinAdapter.MyViewHolder holder, int position) {
          Medecin medecin = medecinList.get(position);
          holder.binding.setMedecin(medecin);
        System.out.println("taille liste: "+medecinList.size());

        holder.binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AddMedecinActivity.class);

                i.putExtra("medecin",  medecin);
                context.startActivity(i);
                context.finish();

            }
        });

        holder.binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("voici lid :"+medecin.getId());
                context.delete(medecin.getId());

            }
        });

    }



    @Override
    public int getItemCount() {
        return medecinList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        MedecinItemLayoutBinding binding ;
        public MyViewHolder(@NonNull MedecinItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
