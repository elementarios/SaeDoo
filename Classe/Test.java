package Classe;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Orchestre orc = new Orchestre("Orchestre symphonique Lannion");
        Artiste art = new Artiste("Coldplay");
        /*System.out.println(orc);
        System.out.println(art);
        Salle salle = new Salle("Le cube");
        System.out.println(salle);
        Billet b = new Billet(2026, 12, 25, 12, 30, salle, art,"carte");
        Billet b2 = new Billet(2026, 12, 25, 12, 30, salle, orc,"nature");
        System.out.println(b);
        System.out.println(b2);
        Client c = new Client("200X", "dange", "Ewan", "Ewan.dange@free.fr", 0, "lanjuinais", "Pleumeleuc", "35137");
        System.out.println(c);
        System.out.println(c);
        Adresse ad = new Adresse(0, "hugo", "paris", "2546");
        Client c2 = new Client("null", "toto", "tutu", "tutu.toto@gmail.com", 0, "hugo", "paris", "2546");
        System.out.println(c2);
        System.out.println(c2);
        System.out.println(c);
        Sauvergade.enregistrerClients(c2, "sauv.txt");
        Client c3 = Sauvergade.extraireClient("sauv.txt");*/
        System.out.println(art.Class());

    }
    
}
