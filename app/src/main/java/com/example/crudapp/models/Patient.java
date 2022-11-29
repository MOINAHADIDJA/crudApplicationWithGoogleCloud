package com.example.crudapp.models;




public class Patient {

    private long id;

    private String nom;
    private String prenom;
    private String profile;
    private String login;
    private String motDePasse;

    public Patient(String nom, String prenom, String profile, String login, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.profile = profile;
        this.login = login;
        this.motDePasse = motDePasse;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
