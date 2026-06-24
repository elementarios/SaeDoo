package appli;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CtrlFicheClient {
	static public ObservableList<Billet> 	lesBillets 	= FXCollections.observableArrayList();
	 @FXML	private 	Button 				bnNouveau;
	 @FXML	private 	TextField 			saisiePrenom;
	 @FXML	private 	TextField 			saisieVille;
	 @FXML	private 	MenuItem 			itemNouveau;
	 @FXML	private 	MenuItem 			itemSupprimer;
	 @FXML	private 	MenuItem 			itemRembourser;
	 @FXML	private 	MenuItem 			itemDetail;
	 @FXML	private 	TextField 			saisieNom;
	 @FXML	private 	Button 				bnFermer;
	 @FXML	private 	Button 				bnSupprimer;
	 @FXML	private 	TextField 			saisieNumero;
	 @FXML	private 	TableView<Billet> 	tableBillet;
	 @FXML	private 	TextField 			SaisieEmail;
	 @FXML	private 	Button 				bnDetail;
	 @FXML	private 	TextField 			saisieSpectacle;
	 @FXML	private 	TextField 			saisieCodePostal;
	 @FXML	private 	Button 				bnRembourser;
	 @FXML	private 	TextField 			saisieID;
	 @FXML 	private 	TextField 			saisieRue;
	 @FXML	private 	Button 				bnSauvergarder;
	 @FXML	private 	Label 				erreurNombre;
	 @FXML	private 	TableColumn<Billet, String> 	colSpectacle;
	 @FXML	private 	TableColumn<Billet, Integer> 	colNum;
	 @FXML	private 	TableColumn<Billet, String> 	colSalle;
	 		private 	Client				client;
	 		private 	String 				mode;
	    
	    void init() {
	    	mode = "init";
	    	client = null;
	    	erreurNombre.setVisible(false);
	    	itemNouveau.setDisable(true);
	    	bnNouveau.setDisable(true);
	    	bnDetail.setDisable(true);
    		bnSupprimer.setDisable(true);
    		itemDetail.setDisable(true);
        	itemSupprimer.setDisable(true);
        	bnRembourser.setDisable(true);
        	itemRembourser.setDisable(true);
	    	saisiePrenom.setText("");
	    	saisieNom.setText("");
	    	saisieID.setText("");
	    	SaisieEmail.setText("");
	    	saisieSpectacle.setText("");
	    	saisieCodePostal.setText("");
	    	saisieVille.setText("");
	    	saisieRue.setText("");
	    	saisieNumero.setText("");
	    	colSpectacle.setCellValueFactory(new PropertyValueFactory<Billet,String>("SpectacleNom"));
	    	colNum.setCellValueFactory(new PropertyValueFactory<Billet,Integer>("Numero"));
	    	colSalle.setCellValueFactory(new PropertyValueFactory<Billet,String>("Salle"));
	    	lesBillets.clear();
	    }
	    
	    void afficher(Client c) {
	    	mode = "modif";
	    	client = c;
	    	lesBillets.clear();
	    	erreurNombre.setVisible(false);
	    	bnDetail.setDisable(true);
    		bnSupprimer.setDisable(true);
    		itemDetail.setDisable(true);
        	itemSupprimer.setDisable(true);
        	bnRembourser.setDisable(true);
        	itemRembourser.setDisable(true);
	    	saisiePrenom.setText(c.getPrenom());
	    	saisieNom.setText(c.getNom());
	    	saisieID.setText(c.getId());
	    	SaisieEmail.setText(c.getEmail());
	    	saisieSpectacle.setText("");
	    	saisieCodePostal.setText(c.getAdresse().getCode_postal());
	    	saisieVille.setText(c.getAdresse().getVille());
	    	saisieRue.setText(c.getAdresse().getRue());
	    	saisieNumero.setText(String.valueOf(c.getAdresse().getNumero()));
	    	colSpectacle.setCellValueFactory(new PropertyValueFactory<Billet,String>("Spectacle"));
	    	colNum.setCellValueFactory(new PropertyValueFactory<Billet,Integer>("Numero"));
	    	colSalle.setCellValueFactory(new PropertyValueFactory<Billet,String>("Salle"));
	    	for(Billet b:client.getBillets()) {
	    		lesBillets.add(b);
	    	}
	    	tableBillet.setItems(lesBillets);
	    }
	    
	    
	    public void rafraichir() {
	    	lesBillets.clear();
	    	for(Billet b:client.getBillets()) {
	    		lesBillets.add(b);
	    	}
	    	tableBillet.refresh();
	    }
	    
	    private boolean estValide(String str) {
			return str.matches("\\d*");
		}
	    private boolean estValideCodePostal(String str) {
			return str.matches("\\ddddd");
		}
	    
	    
	    
	    /****************************************/
	    /*		METHODES EVENEMENTIELLES        */
	    /****************************************/
	    

	    @FXML
	    void selectionner(MouseEvent event) {
	    	if (tableBillet.getSelectionModel().getSelectedIndex() == -1) {
	    		// rien n'est sélectionné, il faut griser les deux boutons
	    		// et les items du menus contextuel
	    		bnDetail.setDisable(true);
	    		bnSupprimer.setDisable(true);
	    		itemDetail.setDisable(true);
	        	itemSupprimer.setDisable(true);
	        	bnRembourser.setDisable(true);
	        	itemRembourser.setDisable(true);
	    	} else {
	    		// au contraire, il faut activer ces deux boutons et ces deux items
	    		bnDetail.setDisable(false);
	    		bnSupprimer.setDisable(false);
	    		itemDetail.setDisable(false);
	        	itemSupprimer.setDisable(false);
	        	bnRembourser.setDisable(false);
	        	itemRembourser.setDisable(false);
	    	}
	    }

	    @FXML
	    void nouveau(ActionEvent event) {
	    	Principale.ouvrirNouveauBillet(client);
	    }

	    @FXML
	    void detail(ActionEvent event) {
	    	Billet b = tableBillet.getSelectionModel().getSelectedItem();
        	Principale.ouvrirDetailBillet(client, b);

	    }

	    @FXML
	    void supprimer(ActionEvent event) {
	    	Alert confirm = new Alert(	AlertType.CONFIRMATION,
	    			"Confirmez-vous la suppression de ce billet ?",
	    			ButtonType.YES, ButtonType.NO
	    	);
	    	confirm.showAndWait();
	        if (confirm.getResult()==ButtonType.YES) {
	        	Billet b = tableBillet.getSelectionModel().getSelectedItem();
	        	Principale.SupprimerBillet(client, b);
	        }
	    }

	    @FXML
	    void rembourser(ActionEvent event) {
	    	Alert confirm = new Alert(	AlertType.CONFIRMATION,
	    			"Confirmez-vous le remboursement de ce billet ?",
	    			ButtonType.YES, ButtonType.NO
	    	);
	    	confirm.showAndWait();
	        if (confirm.getResult()==ButtonType.YES) {
	        	Billet b = tableBillet.getSelectionModel().getSelectedItem();
	        	Principale.SupprimerBillet(client, b);
	        }
	    }


	    @FXML
	    void fermer(ActionEvent event) {
	    	Principale.FermerClient();
	    }
	    
	    @FXML
	    void sauvergarder(ActionEvent event) {
	    	if(mode.equals("init")) {
	    		client = new Client("","","", "", 0, "", "", "");
	    		Principale.AjouterClient(client);
	    		itemNouveau.setDisable(false);
		    	bnNouveau.setDisable(false);
	    	}
	    	client.setId(saisieID.getText());
	    	client.setPrenom(saisiePrenom.getText());
	    	client.setNom(saisieNom.getText());
	    	client.setEmail(SaisieEmail.getText());
	    	client.setAdresse(new Adresse(Integer.parseInt(saisieNumero.getText()),saisieRue.getText(),saisieVille.getText(),saisieCodePostal.getText()));
	    		
	    }
	    
	    @FXML
	    void verificationNumero(KeyEvent event) {
	    	String num = saisieNumero.getText();
	    	TextField source = (TextField) event.getSource();
	    	if(estValide(num)) {
	    		if(source == saisieCodePostal) {
	    			if(estValideCodePostal(num)) {
	    				erreurNombre.setVisible(false);
	    	    		bnSauvergarder.setDisable(false);
	    			}
	    		}
	    		else {
	    			erreurNombre.setVisible(false);
	    			bnSauvergarder.setDisable(false);
	    		}
	    	}
	    	else {
	    		erreurNombre.setVisible(true);
	    		bnSauvergarder.setDisable(true);
	    	}
	    }
	    
	    @FXML
	    void rechercheNum(KeyEvent event) {
	    	String num = saisieSpectacle.getText();
	    	tableBillet.setItems(this.trier(num));
	    }
	    
	    public ObservableList<Billet> trier(String num){
	    	ObservableList<Billet> liste = FXCollections.observableArrayList();
			if (num.equals("")) {
				return lesBillets;
			} else {
				for(int i=0 ; i<lesBillets.size() ; i++) {
					if (lesBillets.get(i).getSpectacleNom().contains(num)) {
						liste.add(lesBillets.get(i));
					}
				}
				return liste;
			}
	    }
}
