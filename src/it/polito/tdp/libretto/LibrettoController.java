/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	Model model;
	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void handelCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<5){
    		txtResult.appendText("codice non valido\n");
    		return;
    	}
    	
    	Esame e = model.trovaEsame(codice);
    	
    	if(e==null){
    		txtResult.appendText("esame non presente\n");
    	} else {
    		txtResult.appendText("esame "+ codice + " trovato\n");
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}
    }

    @FXML
    void handelInserisci(ActionEvent event) {
    	//recupera i dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	//validità dei dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtResult.appendText("Dati esame non sufficienti\n");
    		return;
    	}
    	
    	//chiedi al model di effettuare l'operazione
    	Esame e = new Esame(codice, titolo, docente);
    	boolean t = model.addEsame(e);
    	
    	//aggiorna vista con risultati
    	if(t){
    		txtResult.appendText("Esame aggiunto\n");
    	} else {
    		txtResult.appendText("Esame non aggiunto, codice duplicato\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
}
