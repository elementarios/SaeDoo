package appli;

import java.io.Serializable;

public class Orchestre extends Spectacle implements Serializable {

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
        return this.nom;
    }

    public boolean equal(Orchestre a){
        return this.nom.equals(a.getNom());
    }
    
    public String Class(){
        return "Orchestre";
    }
    
}
