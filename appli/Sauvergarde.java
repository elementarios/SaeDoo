package appli;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javafx.collections.FXCollections;

public class Sauvergarde {
    
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
    
    static public void enregistrerTousLesClients(List<Client> clients, String Fichier) throws FileNotFoundException, IOException {
        ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(Fichier));
        sortie.writeObject(clients); // On écrit la liste entière
        sortie.close();
    }

    @SuppressWarnings("unchecked")
	static public List<Client> extraireTousLesClients(String Fichier) throws FileNotFoundException, IOException, ClassNotFoundException {
    	File f = new File(Fichier);
        
        // Vérifier existence ET taille non nulle
        if (!f.exists() || f.length() == 0) {
            
            return FXCollections.observableArrayList();
        }
        
        ObjectInputStream entree = null;
        try {
            entree = new ObjectInputStream(new FileInputStream(f));
            return (List<Client>) entree.readObject();
        } catch (EOFException e) {
           
            return FXCollections.observableArrayList();
        } catch (IOException | ClassNotFoundException e) {
            ;
            return FXCollections.observableArrayList();
        } finally {
            if (entree != null) {
                try { entree.close(); } catch (IOException ignored) {}
            }
        }
}
    }

