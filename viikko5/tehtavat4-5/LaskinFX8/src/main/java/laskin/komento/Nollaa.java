package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Nollaa extends Komento {
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        tallennaTuloskentanArvo();
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();   
        asetaKenttienArvot(laskunTulos);
        saadaPainikkeidenTilaa(laskunTulos);
    }
}
