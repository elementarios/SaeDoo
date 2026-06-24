package appli;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CtrlListeClient {
	    @FXML 	private 	Button 							bnNouveau;
	    @FXML 	private 	Button 							bnDetail;
	    @FXML 	private 	Button 							bnsupprimer;
	    @FXML 	private 	TextField 						saisieNom;
	    @FXML 	private 	TableView<Client> 				tableClient;
	    @FXML 	private 	Button 							bnFermer;
	    @FXML 	private 	MenuItem 						itemDetail;
	    @FXML 	private 	MenuItem 						itemSupprimer;
	    @FXML	private 	MenuItem 						itemNouveau;
	    @FXML	private 	TableColumn<Client, String> 	colID;
	    @FXML	private 	TableColumn<Client, String> 	colPrenom;
	    @FXML	private 	TableColumn<Client, String> 	colEmail;
	    @FXML	private 	TableColumn<Client, String> 	colNom;
	    

	    public void initialize() {
	    	
	    	colID.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
	    	colPrenom.setCellValueFactory(new PropertyValueFactory<Client,String>("Prenom"));
	    	colNom.setCellValueFactory(new PropertyValueFactory<Client,String>("Nom"));
	    	colEmail.setCellValueFactory(new PropertyValueFactory<Client,String>("Email"));
	    	tableClient.setItems(Principale.getClient());
	    	
	    	bnDetail.setDisable(true);
	    	bnsupprimer.setDisable(true);
	    	itemDetail.setDisable(true);
	    	itemSupprimer.setDisable(true);
	    }
	    
	    public void rafraichir() {
	    	tableClient.refresh();
	    }
	  
	    
	    /****************************************/
	    /*		METHODES EVENEMENTIELLES        */
	    /****************************************/
	    @FXML
	    void selectionner(MouseEvent event) {
	    	if (tableClient.getSelectionModel().getSelectedIndex() == -1) {
	    		// rien n'est sélectionné, il faut griser les deux boutons
	    		// et les items du menus contextuel
	    		bnDetail.setDisable(true);
	    		bnsupprimer.setDisable(true);
	    		itemDetail.setDisable(true);
	        	itemSupprimer.setDisable(true);
	    	} else {
	    		// au contraire, il faut activer ces deux boutons et ces deux items
	    		bnDetail.setDisable(false);
	    		bnsupprimer.setDisable(false);
	    		itemDetail.setDisable(false);
	        	itemSupprimer.setDisable(false);
	    	}

	    }
	    
	    @FXML
	    void recherche(KeyEvent event) {
	    	String nom = saisieNom.getText();
	    	tableClient.setItems(Principale.filtrerSurNom(nom));
	    }

	    @FXML
	    void nouveau(ActionEvent event) {
	    	Principale.ouvrirNouveauClient();
	    }

	    @FXML
	    void details(ActionEvent event) {
	    	Client c = tableClient.getSelectionModel().getSelectedItem();
	    	Principale.ouvrirDetailClient(c);
	    }

	    @FXML
	    void Supprimer(ActionEvent event) {
	    	Alert confirm = new Alert(	AlertType.CONFIRMATION,
	    			"Confirmez-vous la suppression de ce client ?",
	    			ButtonType.YES, ButtonType.NO
	    	);
	    	confirm.showAndWait();
	        if (confirm.getResult()==ButtonType.YES) {
	        	Client c = tableClient.getSelectionModel().getSelectedItem();
	        	Principale.SupprimerClient(c);;
	        }
	    }

	    @FXML
	    void Fermer(ActionEvent event) throws FileNotFoundException, IOException {
	    	Sauvergarde.enregistrerTousLesClients(new ArrayList<Client>(Principale.lesClient), Principale.cheminArchives);
	    	Principale.fermerAppli();
	    }
}
