package Classe;

import java.io.Serializable;

public class Orchestre extends Spectacle implements Serializable {
    //attributs
    private String nom;

    //constructeur
    public Orchestre(String nom){
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
        return "Orchestre["+super.toString()+"]";
    }

    public boolean equal(Orchestre a){
        return this.nom.equals(a.getNom());
    }
    
}
