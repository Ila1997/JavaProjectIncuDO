package util;

import model.Corso;
import model.Prenotazione;
import model.Utente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

public static List<Utente> caricaUtenti(String filePath) throws IOException {
List<Utente> utenti = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
String line;
boolean firstLine = true;
while ((line = br.readLine()) != null) {
if (firstLine) {
firstLine = false;
continue; // Salta la prima riga
}
String[] values = line.split(";");
if (values.length < 6) {
continue; // Salta la riga con colonne insufficienti
}
try {
int id = Integer.parseInt(values[0].trim());
String nome = values[1].trim();
String cognome = values[2].trim();
String dataNascita = values[3].trim();
String indirizzo = values[4].trim();
String documentoId = values[5].trim();
utenti.add(new Utente(id, nome, cognome, dataNascita, indirizzo, documentoId));
} catch (NumberFormatException e) {
// Salta le righe in cui all'ID non può essere fatto il parse come integer
System.err.println("Errore nel parsing della riga: " + line);
e.printStackTrace();
}
}
}

return utenti;
}

public static List<Prenotazione> caricaPrenotazioni(String filePath) throws IOException {
List<Prenotazione> prenotazioni = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
String line;
boolean firstLine = true;
while ((line = br.readLine()) != null) {
if (firstLine) {
firstLine = false;
continue; // Salta la prima riga
}
String[] values = line.split(";");
if (values.length < 5) {
continue; // Salta le righe con colonne insufficienti
}
try {
int id = Integer.parseInt(values[0].trim());
int idAttivita = Integer.parseInt(values[1].trim());
int idUtente = Integer.parseInt(values[2].trim());
String dataInizio = values[3].trim();
String dataFine = values[4].trim();
prenotazioni.add(new Prenotazione(id, idAttivita, idUtente, dataInizio, dataFine));
} catch (NumberFormatException e) {
// Salta le righe in cui all'ID o ai campi numerici non può essere fatto il parse come integer
System.err.println("Errore nel parsing della riga: " + line);
e.printStackTrace();
}
}
}
return prenotazioni;
}

public static List<Corso> caricaCorsi(String filePath) throws IOException {
List<Corso> corsi = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
String line;
boolean firstLine = true;
StringBuilder sb = new StringBuilder();
while ((line = br.readLine()) != null) {
if (firstLine) {
firstLine = false;
continue; // Salta la prima riga
}

sb.append(line);

// Unisce le righe se ci sono più ""
while (countOccurrences(line, '"') % 2 != 0) {
String nextLine = br.readLine();
if (nextLine == null) break;
line += "\n" + nextLine;
}

String completeLine = sb.toString();
sb.setLength(0); // Svuota StringBuilder

String[] values = splitCSVLine(line);
if (values.length >= 7) { // Assicura che ci siano almeno 7 elementi nell'array
try {
int id = parseInteger(values[0].trim());
String nome = values[1].trim();
String descrizione = values[2].trim();
String data = values[3].trim();
int durata = parseInteger(values[4].trim());
String luogo = values[5].trim();
boolean disponibile = values[6].trim().equalsIgnoreCase("SI");

//Controlla che i valori siano validi prima di aggiungerli alla lista
if (id != 0 || !nome.isEmpty() || !descrizione.isEmpty() || !data.isEmpty() || durata != 0 || !luogo.isEmpty() || disponibile) {
corsi.add(new Corso(id, nome, descrizione, data, durata, luogo, disponibile));
}
} catch (NumberFormatException e) {
System.err.println("Errore nel parsing della riga: " + completeLine);
e.printStackTrace();
}
} else {
System.err.println("Riga non valida: " + completeLine);
}
}
} catch (IOException e) {
e.printStackTrace();
}
return corsi;
}

// Metodo aiutante che conta quando ci sono character in una stringa
private static int countOccurrences(String str, char ch) {
int count = 0;
for (char c : str.toCharArray()) {
if (c == ch) {
count++;
}
}
return count;
}

// Metodo aiutante per splittare righe CSV considerate campi ""
private static String[] splitCSVLine(String line) {
List<String> values = new ArrayList<>();
StringBuilder sb = new StringBuilder();
boolean inQuotes = false;

for (char c : line.toCharArray()) {
if (c == '"') {
inQuotes = !inQuotes;
} else if (c == ';' && !inQuotes) {
values.add(sb.toString().trim());
sb.setLength(0); // Svuota StringBuilder
} else {
sb.append(c);
}
}
values.add(sb.toString().trim()); // Aggiunge ultimo valore

return values.toArray(new String[0]);
}

// Metodo aiutante per fare in sicurezza il parse integer
private static int parseInteger(String value) {
return value.isEmpty() ? 0 : Integer.parseInt(value);
}
}
