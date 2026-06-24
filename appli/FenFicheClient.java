package appli;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenFicheClient extends Stage {
	
	CtrlFicheClient ctrl;
	
	public FenFicheClient() throws IOException {
		this.setTitle("Fiche du Client");
		this.setResizable(true);
		this.setMinWidth(600);
		this.setMinHeight(400);
		this.setScene(new Scene(creerSceneGraph() ) );
		this.sizeToScene();
	}

	private Pane creerSceneGraph() throws IOException {
		File fichier = new File("/home/etuinfo/edange/Qualité de dev/TD DOO/Sujet 3/SaeDoo/FXML/FicheClient.fxml");
		
		FXMLLoader loader;
		loader = new FXMLLoader(fichier.toURI().toURL());
		Pane racine = loader.load();
		ctrl = loader.getController();
		return racine;
	}

	public void afficher(Client c) {
		ctrl.afficher(c);
		
	}

	public void init() {
		ctrl.init();
		
	}
	
	public void rafraichir() {
		ctrl.rafraichir();
	}

}