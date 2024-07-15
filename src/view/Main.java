package view;

import controller.*;
import model.*;
import util.Utils;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UtenteController utenteController = new UtenteController();
    private static CorsoController corsoController = new CorsoController();
    private static PrenotazioneController prenotazioneController = new PrenotazioneController();

    public static void main(String[] args) {
        try {
            List<Utente> utenti = Utils.caricaUtenti("data/utenti.csv");
            utenteController.getUtenti().addAll(utenti);

            List<Corso> corsi = Utils.caricaCorsi("data/corsi.csv");
            corsoController.getCorsi().addAll(corsi);

            List<Prenotazione> prenotazioni = Utils.caricaPrenotazioni("data/prenotazioni.csv");
            prenotazioneController.getPrenotazioni().addAll(prenotazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Visualizza corsi");
            System.out.println("2. Prenota corso");
            System.out.println("3. Disdici prenotazione");
            System.out.println("4. Aggiungi utente");
            System.out.println("5. Esporta prenotazioni disponibili");
            System.out.println("6. Visualizza utenti");
            System.out.println("7. Visualizza prenotazioni");
            System.out.println("0. Esci");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    visualizzaCorsi();
                    break;
                case 2:
                    prenotaCorso(scanner);
                    break;
                case 3:
                    disdiciPrenotazione(scanner);
                    break;
                case 4:
                    aggiungiUtente(scanner);
                    break;
                case 5:
                    esportaPrenotazioni();
                    break;
                case 6:
                    visualizzaUtenti();
                    break;
                case 7:
                    visualizzaPrenotazioni();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }
    }

    private static void visualizzaCorsi() {
        List<Corso> corsi = corsoController.getCorsi();
        for (Corso corso : corsi) {
            System.out.println(corso.getId() + " - " + corso.getNome() + " - " + corso.getDescrizione() + " - " + corso.getData() + " - " + corso.getDurata() + " ore - " + corso.getLuogo() + " - " + (corso.isDisponibile() ? "SI" : "NO"));
        }
    }

    private static void prenotaCorso(Scanner scanner) {
        System.out.println("Inserisci ID corso:");
        int idCorso = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci ID utente:");
        int idUtente = Integer.parseInt(scanner.nextLine());

        Corso corso = corsoController.getCorsi().stream().filter(c -> c.getId() == idCorso).findFirst().orElse(null);
        if (corso == null) {
            System.out.println("Corso non trovato.");
            return;
        }

        Utente utente = utenteController.getUtenti().stream().filter(u -> u.getId() == idUtente).findFirst().orElse(null);
        if (utente == null) {
            System.out.println("Utente non trovato.");
            return;
        }

        if (!corso.isDisponibile()) {
            System.out.println("Il corso non è disponibile.");
            return;
        }

        System.out.println("Inserisci data inizio (dd/MM/yyyy):");
        String dataInizio = scanner.nextLine();
        System.out.println("Inserisci data fine (dd/MM/yyyy):");
        String dataFine = scanner.nextLine();

        Prenotazione prenotazione = new Prenotazione(prenotazioneController.getPrenotazioni().size() + 1, idCorso, idUtente, dataInizio, dataFine);
        prenotazioneController.aggiungiPrenotazione(prenotazione);
        corsoController.aggiornaDisponibilitaCorso(idCorso, false);

        System.out.println("Prenotazione effettuata con successo.");
    }

    private static void disdiciPrenotazione(Scanner scanner) {
        System.out.println("Inserisci ID corso:");
        int idCorso = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci ID utente:");
        int idUtente = Integer.parseInt(scanner.nextLine());

        Prenotazione prenotazione = prenotazioneController.getPrenotazioni().stream().filter(p -> p.getIdCorso() == idCorso && p.getIdUtente() == idUtente).findFirst().orElse(null);
        if (prenotazione == null) {
            System.out.println("Prenotazione non trovata.");
            return;
        }

        prenotazioneController.rimuoviPrenotazione(idCorso, idUtente);
        corsoController.aggiornaDisponibilitaCorso(idCorso, true);

        System.out.println("Prenotazione disdetta con successo.");
    }

    private static void aggiungiUtente(Scanner scanner) {
        System.out.println("Inserisci ID:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci nome:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci cognome:");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci data di nascita (dd/MM/yyyy):");
        String dataNascita = scanner.nextLine();
        System.out.println("Inserisci indirizzo:");
        String indirizzo = scanner.nextLine();
        System.out.println("Inserisci documento ID:");
        String documentoId = scanner.nextLine();

        Utente utente = new Utente(id, nome, cognome, dataNascita, indirizzo, documentoId);
        utenteController.aggiungiUtente(utente);

        System.out.println("Utente aggiunto con successo.");
    }

    private static void esportaPrenotazioni() {
        List<Corso> corsi = corsoController.getCorsi();
        String fileName = "prenotazioni_" + java.time.LocalDate.now() + ".csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("ID;Nome;Descrizione;Data;Durata;Luogo");
            for (Corso corso : corsi) {
                if (corso.isDisponibile()) {
                    writer.println(corso.getId() + ";" + corso.getNome() + ";" + corso.getDescrizione() + ";" + corso.getData() + ";" + corso.getDurata() + ";" + corso.getLuogo());
                }
            }
            System.out.println("Prenotazioni disponibili esportate con successo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void visualizzaUtenti() {
        List<Utente> utenti = utenteController.getUtenti();
        for (Utente utente : utenti) {
            System.out.println(utente.getId() + " - " + utente.getNome() + " " + utente.getCognome() + ", Nato: " + utente.getDataNascita() + ", Indirizzo: " + utente.getIndirizzo() + ", Documento ID: " + utente.getDocumentoId());
        }
    }

    private static void visualizzaPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneController.getPrenotazioni();
        for (Prenotazione prenotazione : prenotazioni) {
            System.out.println(prenotazione.getId() + " - Corso ID: " + prenotazione.getIdCorso() + " - Utente ID: " + prenotazione.getIdUtente() + " - Data inizio: " + prenotazione.getDataInizio() + " - Data fine: " + prenotazione.getDataFine());
        }
    }
}