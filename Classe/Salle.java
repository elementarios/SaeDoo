package Classe;

public class Salle {
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
        return "Salle[nom:"+this.nom+"]";
    }

    public boolean equal(Salle s){
        return this.nom.equals(s.getNom());
    }
}