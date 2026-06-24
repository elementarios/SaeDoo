package appli;



import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Principale extends Application {
	//les fenetres
	static public FenListeClient fenetreListeClient;
	static public FenFicheClient fenetreFicheClient;
	static public FenFicheBillet fenetreBillet;
	public static String cheminArchives ;
	static public ObservableList<Client> 	lesClient 	= FXCollections.observableArrayList();
	
	public static void main(String[] args) {
		Application.launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		cheminArchives = "/home/etuinfo/edange/Qualité de dev/TD DOO/Sujet 3/SaeDoo/sauv.txt";
		lesClient = FXCollections.observableArrayList(Sauvergarde.extraireTousLesClients(cheminArchives));
		fenetreListeClient = new FenListeClient();
		fenetreFicheClient = new FenFicheClient();
		fenetreBillet = new FenFicheBillet();
		fenetreListeClient.show();
	}
	
	static public ObservableList<Client> getClient() {
		return Principale.lesClient;
	}
	
	
	static public ObservableList<Client> filtrerSurNom(String nom) {
		ObservableList<Client> liste = FXCollections.observableArrayList();
		if (nom.equals("")) {
			return Principale.getClient();
		} else {
			for(int i=0 ; i<Principale.getClient().size() ; i++) {
				if (Principale.getClient().get(i).getNom().contains(nom)) {
					liste.add(Principale.getClient().get(i));
				}
			}
			return liste;
		}
	}
	
	
	/***************************************/
	/*        GESTION DES FENETRES         */
	/***************************************/
	
	static public void fermerAppli() throws FileNotFoundException, IOException {
		
		System.exit(0);
	}
	
	static public void ouvrirDetailClient(Client c) {
		fenetreFicheClient.afficher(c);
		fenetreFicheClient.show();
		fenetreListeClient.hide();
		
	}
	
	static public void ouvrirNouveauClient() {
		fenetreFicheClient.init();
		fenetreFicheClient.show();
		fenetreListeClient.hide();
	}
	
	static public void FermerClient(){
		fenetreFicheClient.close();
		fenetreListeClient.rafraichir();
		fenetreListeClient.show();
	}
	
	static public void ouvrirDetailBillet(Client c,Billet b) {
		fenetreBillet.afficher(c,b);
		fenetreBillet.show();
		fenetreFicheClient.hide();
		
	}
	
	static public void ouvrirNouveauBillet(Client c) {
		fenetreBillet.init(c);
		fenetreBillet.show();
		fenetreFicheClient.hide();
	}
	
	static public void FermerBillet() {
		fenetreBillet.close();
		fenetreFicheClient.rafraichir();
		fenetreFicheClient.show();
	}
	
	/***************************************/
	/*        GESTION DES CLIENTS          */
	/***************************************/
	
	static public void SupprimerClient(Client c) {
		Principale.lesClient.remove(c);
	}
	
	static public void AjouterClient(Client c) {
		Principale.lesClient.add(c);
	}
	
	/***************************************/
	/*        GESTION DES BILLETS          */
	/***************************************/
	
	static public void AjouterBillet(Client c,Billet b) {
		c.add(b);
	}
	
	static public void SupprimerBillet(Client c,Billet b) {
		c.remove(b);
	}
	
	
	
	
	

}
