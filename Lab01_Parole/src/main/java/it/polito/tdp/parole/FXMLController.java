package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	txtTempo.clear();
    	double t1=System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	double t2=System.nanoTime();
    	double tempo=(t2-t1)/1e9;
    	
    	String risultato="";
    	for(String p : elenco.getElenco()) {
    		risultato+=p+"\n";
    	}
    	txtParola.clear();
    	txtResult.setText(risultato);
    	txtTempo.setText("Parola aggiunta in "+tempo+" secondi");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	txtTempo.clear();
    	String selezionato=txtResult.getSelectedText();
    	double t1=System.nanoTime();
    	elenco.cancella(selezionato);
    	double t2=System.nanoTime();
    	double tempo=(t1-t2)/1e9;
    	
    	String risultato="";
    	for(String p: elenco.getElenco()) {
    		risultato+=p+"\n";
    	}
    	txtResult.setText(risultato);
    	txtTempo.setText("Parola eliminata in "+tempo+" secondi");

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtParola.clear();
    	txtTempo.clear();
    	elenco.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
