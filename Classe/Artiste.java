package Classe;

import java.io.Serializable;

public class Artiste extends Spectacle implements Serializable  {
    //attributs
    private String nom;

    //constructeur
    public Artiste(String nom){
        super(nom);
    }

    //methode
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString(){
        return "Artiste["+super.toString()+"]";
    }

    public boolean equal(Artiste a){
        return this.nom.equals(a.getNom());
    }
    
}
