package appli;

import java.io.Serializable;

public class Artiste extends Spectacle implements Serializable  {
   

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
        return this.getNom();
    }

    public boolean equal(Artiste a){
        return this.nom.equals(a.getNom());
    }
    
    public String Class(){
        return "Artiste";
    }
}