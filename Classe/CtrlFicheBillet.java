package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;


public class CtrlFicheBillet {
	@FXML	private 	RadioButton 	bnOrchestre;
	@FXML	private 	DatePicker 		saiseJour;
    @FXML	private 	RadioButton 	bnCB;
    @FXML	private 	ToggleGroup 	payement;
    @FXML	private 	TextField 		saisieSalle;
    @FXML	private 	TextField 		saisieNumero;
    @FXML	private 	ToggleGroup 	Type;
    @FXML	private 	TextField 		saisieSpectacle;
    @FXML	private 	RadioButton 	bnArtiste;
    @FXML	private 	RadioButton 	bnEspece;
    @FXML	private 	Button 			bnRemboursement;
    @FXML	private 	Button 			bnValide;
    @FXML	private 	Label 			erreurNombre;
    		private 	String			mode;
    		private 	Billet   		billet;
    		private		Client 			client;
    
    public void init(Client c) {
    	mode = "init";
    	client = c;
    	billet = null;
    	saiseJour.setChronology(null);
    	saisieNumero.setText("");
    	saisieSalle.setText("");
    	saisieSpectacle.setText("");
    	bnArtiste.setSelected(true);
    	bnCB.setSelected(true);
    	bnRemboursement.setDisable(true);
    	erreurNombre.setVisible(false);
    }
    
    public void afficher(Client c,Billet b) {
    	mode = "modif";
    	billet = b;
    	client = c;
    	bnRemboursement.setDisable(false);
    	saiseJour.setChronology(b.getDate_debut());
    	saisieSalle.setText(b.getSalle().getNom());
		saisieNumero.setText(String.valueOf(b.getNumero()));
		saisieSpectacle.setText(b.getSpectacle().getNom());
		erreurNombre.setVisible(false);
		if(b.getSpectacleClass().equals("Artiste")) {
			bnArtiste.setSelected(true);
		}
		else {
			bnOrchestre.setSelected(true);
		}
		
		
		if(b.getAchat().equals("CB")) {
			bnCB.setSelected(true);
		}
		else {
			bnEspece.setSelected(true);
		}
    }
    
    private boolean estValide(String str) {
		return str.matches("\\d*");
	}
    
    
    
    /****************************************/
    /*		METHODES EVENEMENTIELLES        */
    /****************************************/

    @FXML
    void Remboursement(ActionEvent event) {
    	Alert confirm = new Alert(	AlertType.CONFIRMATION,
    			"Confirmez-vous le remboursement de ce billet ?",
    			ButtonType.YES, ButtonType.NO
    	);
    	confirm.showAndWait();
        if (confirm.getResult()==ButtonType.YES) {
        	Principale.SupprimerBillet(client, billet);
        	Principale.FermerBillet();
        }

    }

    @FXML
    void fermer(ActionEvent event) {
    	
    		Spectacle spectacle = null ;
    		if (bnArtiste.isSelected()) {
    			spectacle = new Artiste(saisieSpectacle.getText());
    		}
    		else {
    			spectacle = new Orchestre(saisieSpectacle.getText());
    		}
    		if(mode.equals("init")) {
    			billet = new Billet(Integer.parseInt(saisieNumero.getText()),saiseJour.getChronology() , new Salle(saisieSalle.getText()), spectacle,"");
    			Principale.AjouterBillet(client, billet);
    		}
    		else {
    			billet.setSpectacle(spectacle);
    			billet.setSalle(new Salle(saisieSalle.getText()));
    			billet.setNumero(Integer.parseInt(saisieNumero.getText()));
    			billet.setDate_debut(saiseJour.getChronology());
    		}
    		if (bnCB.isSelected()) {
    			billet.setAchat("CB");
    		}
    		else {
    			billet.setAchat("Espece");
    		}
    		Principale.FermerBillet();
    	
    	
    	
    }

    @FXML
    void verificationNumero(KeyEvent event) {
    	String num = saisieNumero.getText();
    	if(estValide(num)) {
    		erreurNombre.setVisible(false);
    		bnValide.setDisable(false);
    	}
    	else {
    		erreurNombre.setVisible(true);
    		bnValide.setDisable(true);
    	}
    }

}
