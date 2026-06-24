package appli;

import java.io.Serializable;
import java.time.chrono.Chronology;

public class Billet implements Serializable {
    //attributs
    private int numero;
    private Chronology date_debut;
    private Salle salle;
    private Spectacle spectacle;
    private Client client;
    private static int num = 1;
    private String methodePayement;

    //constructeur
    public Billet(int num,Chronology chrono,Salle salle,Spectacle spectacle,String methodePayement){
        this.numero=num;
        Billet.num++;
        date_debut = chrono;
        this.salle = salle;
        this.spectacle = spectacle;
        this.client=null;
        this.methodePayement=methodePayement;
    }


    //methode

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Chronology getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Chronology date_debut) {
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
    
    public String getSpectacleClass() {
    	return spectacle.Class();
    }
    
    public String getSpectacleNom() {
        if (spectacle != null) {
            return spectacle.getNom();
        }
        return "";
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

    public String getAchat() {
        return this.methodePayement;
    }

    public void setAchat(String achat) {
        this.methodePayement = achat;
    }


    @Override 
    public String toString(){
        return "Billet[numero:"+this.numero+" ,Date:"+this.date_debut.toString()+" ,Salle:"+this.salle.toString()+" ,Spectacle:"+this.spectacle.toString()+"]";
    }

    
}
