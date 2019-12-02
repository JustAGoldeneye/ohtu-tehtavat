package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Erotus extends Komento {
    
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        sovellus.miinus(haeSyotekentanArvo());
        int laskunTulos = sovellus.tulos();       
        asetaSyotekentanArvo(laskunTulos);
        saadaPainikkeidenTilaa(laskunTulos);
    }
}
