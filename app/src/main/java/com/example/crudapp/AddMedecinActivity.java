package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudapp.adapters.RecyclerViewMedecinAdapter;
import com.example.crudapp.http.RetrofitGenerator;
import com.example.crudapp.http.UtilisateurService;
import com.example.crudapp.models.Medecin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMedecinActivity extends AppCompatActivity {

    EditText edtNom,edtPrenom,edtLogin,edtMdp;
    Button btnSave,btnGetMedecins;
    TextView texte;
    Medecin medecinPersist;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medecin);

        edtNom = findViewById(R.id.edt_nom);
        edtPrenom = findViewById(R.id.edt_prenom);
        edtLogin = findViewById(R.id.medecin_login);
        edtMdp = findViewById(R.id.medecin_mdp);
        btnSave = findViewById(R.id.btn_save);
        btnGetMedecins = findViewById(R.id.btn_getall);
        texte = findViewById(R.id.txtview_nom);
        medecinPersist = new Medecin();

        Intent intent = getIntent();
        if(intent.hasExtra("medecin")){
            Bundle extras= getIntent().getExtras();
            Medecin m = (Medecin) extras.getSerializable("medecin");
            edtNom.setText(m.getNom());
            edtPrenom.setText(m.getPrenom());
            edtLogin.setText(m.getUsername());
            edtMdp.setText(m.getPassword());
            medecinPersist.setId(m.getId());
            System.out.println(m);

        }

        /*if(m == null){
            System.out.println("Il s'agit d'un ajout");
        }else{
            System.out.println(m.toString());
        }*/


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nom = edtNom.getText().toString();
                String prenom = edtPrenom.getText().toString();
                String login = edtLogin.getText().toString();
                String mdp = edtMdp.getText().toString();
                System.out.println(edtNom.getText().toString()+ " "+edtPrenom.getText().toString()+ " "+login+" "+mdp+"  infos Medecinmedecin ");


                medecinPersist.setNom(nom);
                medecinPersist.setPrenom(prenom);
                medecinPersist.setUsername(login);
                medecinPersist.setPassword(mdp);

                //Medecin medecin = new Medecin(nom,prenom,"",login,mdp);
                addMedecin(medecinPersist);
            }
        });

        btnGetMedecins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddMedecinActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    public void addMedecin(Medecin medecin){
        UtilisateurService service = RetrofitGenerator.getRetrofit().create(UtilisateurService.class);
        System.out.println(medecin.toString()+"Nouveau medecin ajouté");
        Call<Medecin> call = service.addMedecin(medecin);
        call.enqueue(new Callback<Medecin>() {
            @Override
            public void onResponse(Call<Medecin> call, Response<Medecin> response) {
                Medecin m = response.body();
                Toast.makeText(getApplicationContext(), m.toString(), Toast.LENGTH_LONG).show();

                System.out.println(" medecin bien enregistré");

            }

            @Override
            public void onFailure(Call<Medecin> call, Throwable t) {
                System.out.println("Ici les medecins Failure");
                System.out.println(t.getMessage());
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });

    }
}