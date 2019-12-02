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
    int tuloskentanArvo;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.tuloskentanArvo = 0;
    }
    
    public void suorita() {
        System.out.println("suorita ei vielä käytössä");
    }
    
    public void peru() {
        this.tuloskentta.setText("" + this.tuloskentanArvo);
        asetaKenttienArvot(this.tuloskentanArvo);
        undo.disableProperty().set(true);
        nollaa.disableProperty().set(false);
    }
    
    protected int haeSyotekentanArvo() { 
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return 0;
        }
    }
    
    protected void tallennaTuloskentanArvo() { 
        int arvo = 0;
        try {
            arvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        this.tuloskentanArvo = arvo;
    }
    
    protected void asetaKenttienArvot(int laskunTulos) {
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
