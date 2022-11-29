package com.example.crudapp.models;


import java.io.Serializable;

public class Medecin implements Serializable {

    private long id;
    private String nom;
    private String prenom;
    private String profile;
    private String username;

    private String password;

    public Medecin() {
    }

    public Medecin(String nom, String prenom, String profile, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.profile = profile;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", profile='" + profile + '\'' +
                ", login='" + username + '\'' +
                ", motDePasse='" + password + '\'' +
                '}';
    }
}
