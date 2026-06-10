package Classe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sauvergade {
    
    //gestion client
    static public void enregistrerClients(Client c,String Fichier) throws FileNotFoundException, IOException{
        ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(Fichier));
        sortie.writeObject(c);
        sortie.close();
    }

    static public Client extraireClient(String Fichier) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream(Fichier));
        Client c = (Client) entree.readObject();
        entree.close();
        return c;
    }

    //gestion billet
    static public void enregistrerBillet(Billet b,String Fichier) throws FileNotFoundException, IOException{
        ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(Fichier));
        sortie.writeObject(b);
        sortie.close();
    }

    static public Billet extraireBillet(String Fichier) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream(Fichier));
        Billet b = (Billet) entree.readObject();
        entree.close();
        return b;
    }
}
