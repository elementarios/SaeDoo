package Classe;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Orchestre orc = new Orchestre("Orchestre symphonique Lannion");
        Artiste art = new Artiste("Coldplay");
        System.out.println(orc);
        System.out.println(art);
        Salle salle = new Salle("Le cube");
        System.out.println(salle);
        Billet b = new Billet(2026, 12, 25, 12, 30, salle, art);
        Billet b2 = new Billet(2026, 12, 25, 12, 30, salle, orc);
        System.out.println(b);
        System.out.println(b2);
        Client c = new Client("200X", "dange", "Ewan", "Ewan.dange@free.fr", 0, "lanjuinais", "Pleumeleuc", "35137");
        System.out.println(c);
        _Achat a = new _Achat(c, b2, "carte");
        System.out.println(a);
        System.out.println(c);
        Adresse ad = new Adresse(0, "hugo", "paris", "2546");
        Client c2 = new Client("null", "toto", "tutu", "tutu.toto@gmail.com", ad);
        System.out.println(c2);
        _Achat a1 = new _Achat(c2, b2, "espece");
        _Achat a2 = new _Achat(c2, b, "carte");
        System.out.println(c2);
        System.out.println(c);
        Sauvergade.enregistrerClients(c2, "sauv.txt");
        Client c3 = Sauvergade.extraireClient("sauv.txt");
        System.out.println(c3);
    }
    
}
