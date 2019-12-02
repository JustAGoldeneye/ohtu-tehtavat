package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Summa extends Komento {
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        tallennaTuloskentanArvo();
        sovellus.plus(haeSyotekentanArvo());
        int laskunTulos = sovellus.tulos();
        asetaKenttienArvot(laskunTulos);
        saadaPainikkeidenTilaa(laskunTulos);
    }
    
}
