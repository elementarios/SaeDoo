package Classe;

import java.io.Serializable;
import java.util.Date;

public class Billet implements Serializable {
    //attributs
    private int numero;
    private Date date_debut;
    private Salle salle;
    private Spectacle spectacle;
    private Client client;
    private static int num = 1;
    private _Achat achat;

    //constructeur
    @SuppressWarnings("deprecation")
    public Billet(int year,int month,int day,int hrs,int min,Salle salle,Orchestre orc){
        this.numero=Billet.num;
        Billet.num++;

        month = month-1;
        if(month == -1){ //correction du mois
            month = 12;
        }

        this.date_debut = new Date(year, month, day, hrs, min);
        this.salle = salle;
        this.spectacle = orc;
        this.client = null;
        this.achat = null;
    }

    @SuppressWarnings("deprecation")
    public Billet(int year,int month,int day,int hrs,int min,Salle salle,Artiste art){
        this.numero=Billet.num;
        Billet.num++;

        month = month-1;
        if(month == -1){ //correction du mois
            month = 12;
        }

        this.date_debut = new Date(year, month, day, hrs, min);
        this.salle = salle;
        this.spectacle = art;
        this.client=null;
        this.achat=null;
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

    public _Achat getAchat() {
        return achat;
    }

    public void setAchat(_Achat achat) {
        this.achat = achat;
    }


    @Override 
    public String toString(){
        return "Billet[numero:"+this.numero+" ,Date:"+this.date_debut.toString()+" ,Salle:"+this.salle.toString()+" ,Spectacle:"+this.spectacle.toString()+"]";
    }

    public boolean equal(Billet b){
        return this.numero==b.getNumero() && this.date_debut.equals(b.getDate_debut()) && this.salle.equal(b.getSalle()) && this.spectacle.equal(b.getSpectacle());
    }
}
