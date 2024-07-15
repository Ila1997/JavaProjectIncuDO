package controller;

import model.Prenotazione;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneController {
    private List<Prenotazione> prenotazioni;

    public PrenotazioneController() {
        this.prenotazioni = new ArrayList<>();
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }

    public void rimuoviPrenotazione(int idCorso, int idUtente) {
        prenotazioni.removeIf(p -> p.getIdCorso() == idCorso && p.getIdUtente() == idUtente);
    }
}
