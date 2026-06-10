package Classe;

import java.io.Serializable;
import java.util.HashSet;

public class Client implements Serializable {
    //attributs
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private Adresse adresse;
    private HashSet<Billet> billets;

    //constructeur
    public Client(String id,String nom,String prenom,String email,int num,String rue,String ville,String code){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = new Adresse(num, rue, ville, code);
        this.billets = new HashSet<>();
        this.billets.clear();
    }

    public Client(String id,String nom,String prenom,String email,Adresse adresse){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.adresse=adresse;
        this.billets = new HashSet<>();
        this.billets.clear();
    }
    //methode

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public HashSet<Billet> getBillets() {
        return billets;
    }

    public void setBillets(HashSet<Billet> billets) {
        this.billets = billets;
    }

    public int getNbBillets(){
        return this.billets.size();
    }

    @Override
    public String toString(){
        String bill = "";
        for (Billet billet : billets) {
            bill = bill+billet.toString();
        }
        return "Client[id:"+this.id+",  nom:"+this.nom+", prenom:"+this.prenom+", email:"+this.email+", "+this.adresse.toString()+", Billets["+bill+"]]";
    }

    public boolean equal(Client c){
        return this.id.equals(c.getId()) && this.nom.equals(c.getNom()) && this.prenom.equals(c.getPrenom()) && this.email.equals(c.getEmail()) && this.adresse.equal(c.getAdresse());
    }

    //gestion des billets

    public void add(Billet b){
        this.billets.add(b);
    }

    public boolean remove(Billet b){
        return this.billets.remove(b);
    }

    public boolean containt(Billet b){
        return this.billets.contains(b);
    }

    public int nbBillet(){
        return this.billets.size();
    }
}
