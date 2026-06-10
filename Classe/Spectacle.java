package Classe;

import java.io.Serializable;

public abstract class Spectacle implements Serializable  {
    //attribut
    protected String nom;

    //constructeur
    public Spectacle(String nom){
        this.nom = nom;
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
        return "Spectacle[nom:"+this.nom+"]";
    }

    public boolean equal(Spectacle s){
        return this.nom.equals(s.getNom());
    }
    
}