package com.example.crudapp.http;


import android.os.Message;

import com.example.crudapp.models.Medecin;
import com.example.crudapp.models.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UtilisateurService {



    @GET("utilisateur/medecin/all")
    Call<List<Medecin>> getAll();

    @POST("utilisateur/medecin/add")
    Call<Medecin> addMedecin(@Body Medecin medecin);

    @DELETE("utilisateur/delete/medecin/{id}")
    Call<Void> deleteMedecin(@Path("id")long id);

}
