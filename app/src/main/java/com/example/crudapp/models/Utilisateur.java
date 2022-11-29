package com.example.crudapp.models;


public class Utilisateur {
    private long id;
    private String nom;
    private String prenom;
    private String profile;
    private String login;
    private String motDePasse;

    synchronized
    public static Utilisateur map(Medecin m){
        Utilisateur u = new Utilisateur();

        u.id = m.getId();
        u.login = m.getUsername();
        u.motDePasse = m.getPassword();
        u.nom = m.getNom();
        u.prenom = m.getPrenom();

        return u;
    }
    synchronized
    public static Utilisateur map(Patient m){
        Utilisateur u = new Utilisateur();

        u.id = m.getId();
        u.login = m.getLogin();
        u.motDePasse = m.getMotDePasse();
        u.nom = m.getNom();
        u.prenom = m.getPrenom();

        return u;
    }
}

