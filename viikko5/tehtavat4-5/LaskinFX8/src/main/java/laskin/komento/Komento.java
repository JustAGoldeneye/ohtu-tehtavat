package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Komento {
    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    public void suorita() {
        System.out.println("suorita ei vielä käytössä");
    }
    
    public void peru() {
        System.out.println("peru ei vielä käytössä");
    }
    
    protected int haeSyotekentanArvo() { 
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return 0;
        }
    }
    
    protected void asetaSyotekentanArvo(int laskunTulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    protected void saadaPainikkeidenTilaa(int laskunTulos) {
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
}
