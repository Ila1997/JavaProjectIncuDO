package model;

public class Prenotazione {
    private int id;
    private int idCorso;
    private int idUtente;
    private String dataInizio;
    private String dataFine;

    public Prenotazione(int id, int idCorso, int idUtente, String dataInizio, String dataFine) {
        this.id = id;
        this.idCorso = idCorso;
        this.idUtente = idUtente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public int getId() { return id; }
    public int getIdCorso() { return idCorso; }
    public int getIdUtente() { return idUtente; }
    public String getDataInizio() { return dataInizio; }
    public String getDataFine() { return dataFine; }
}
