package appli;

import java.io.Serializable;

public abstract class Spectacle implements Serializable  {
    //attribut
    protected String nom;

    //constructeur
    public Spectacle(String nom){
        this.nom = nom;
    }

    //methode
    public abstract String getNom();

    public abstract void setNom(String nom);


    public boolean equal(Spectacle s){
        return this.nom.equals(s.getNom());
    }
    
    public abstract String Class();
    
}