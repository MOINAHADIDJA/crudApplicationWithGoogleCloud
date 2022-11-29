package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.crudapp.adapters.RecyclerViewMedecinAdapter;
import com.example.crudapp.http.RetrofitGenerator;
import com.example.crudapp.http.UtilisateurService;
import com.example.crudapp.models.Medecin;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Medecin> mMedecinList = new ArrayList<>();
    RecyclerView medecinRv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medecinRv = findViewById(R.id.rv_medecin);
        getAllMedecin();


        FloatingActionButton fab = findViewById(R.id.id_fab_addMedecin);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMedecinActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }

    public void getAllMedecin(){
        UtilisateurService service = RetrofitGenerator.getRetrofit().create(UtilisateurService.class);

        Call<List<Medecin>> call = service.getAll();
        call.enqueue(new Callback<List<Medecin>>() {
            @Override
            public void onResponse(Call<List<Medecin>> call, Response<List<Medecin>> response) {
                mMedecinList = response.body();


                medecinRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                medecinRv.setAdapter(new RecyclerViewMedecinAdapter(mMedecinList,MainActivity.this));

                System.out.println("Ici les medecins ");
                System.out.println(mMedecinList.toString());


            }

            @Override
            public void onFailure(Call<List<Medecin>> call, Throwable t) {
                System.out.println("Ici les medecins Failure");
                System.out.println(t.getMessage());
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });


    }

    public void delete(long id){
        UtilisateurService service = RetrofitGenerator.getRetrofit().create(UtilisateurService.class);

        Call<Void> call = service.deleteMedecin(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("medecin bien supprimé");
                mMedecinList.clear();
                getAllMedecin();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("Ici les medecins Failure");
                System.out.println(t.getMessage());
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });


    }
}