package Classe;

import java.util.Date;

public class Billet {
    //attributs
    private int numero;
    private Date date_debut;
    private Salle salle;
    private Spectacle spectacle;
    private Client client;
    private static int num = 1;

    //constructeur
    @SuppressWarnings("deprecation")
    public Billet(int year,int month,int day,int hrs,int min,Salle salle,Orchestre orc,Client c){
        this.numero=Billet.num;
        Billet.num++;
        this.date_debut = new Date(year, month, day, hrs, min);
        this.salle = salle;
        this.spectacle = orc;
        this.client = c;
    }

    @SuppressWarnings("deprecation")
    public Billet(int year,int month,int day,int hrs,int min,Salle salle,Artiste art,Client c){
        this.numero=Billet.num;
        Billet.num++;
        this.date_debut = new Date(year, month, day, hrs, min);
        this.salle = salle;
        this.spectacle = art;
        this.client=c;
    }

    //methode

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Billet.num = num;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override 
    public String toString(){
        return "Billet[numero:"+this.numero+" ,Date:"+this.date_debut.toString()+" ,Salle:"+this.salle.toString()+" ,Spectacle:"+this.spectacle.toString()+"]";
    }

    public boolean equal(Billet b){
        return this.numero==b.getNumero() && this.date_debut.equals(b.getDate_debut()) && this.salle.equal(b.getSalle()) && this.spectacle.equal(b.getSpectacle());
    }
}
