package controller;

import model.Utente;
import java.util.ArrayList;
import java.util.List;

public class UtenteController {
    private List<Utente> utenti;

    public UtenteController() {
        this.utenti = new ArrayList<>();
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }
}
