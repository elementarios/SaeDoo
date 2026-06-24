package appli;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Salle implements Serializable  {
    //attribut
    private String nom;

    //constructeur
    public Salle(String nom){
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
        return this.getNom();
    }

    public boolean equal(Salle s){
        return this.nom.equals(s.getNom());
    }
}