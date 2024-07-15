package controller;

import model.Corso;
import java.util.ArrayList;
import java.util.List;

public class CorsoController {
    private List<Corso> corsi;

    public CorsoController() {
        this.corsi = new ArrayList<>();
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void aggiungiCorso(Corso corso) {
        corsi.add(corso);
    }

    public void aggiornaDisponibilitaCorso(int id, boolean disponibile) {
        for (Corso corso : corsi) {
            if (corso.getId() == id) {
                corso.setDisponibile(disponibile);
                break;
            }
        }
    }
}
