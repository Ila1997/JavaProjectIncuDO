package model;

public class Corso {
    private int id;
    private String nome;
    private String descrizione;
    private String data;
    private int durata;
    private String luogo;
    private boolean disponibile;

    public Corso(int id, String nome, String descrizione, String data, int durata, String luogo, boolean disponibile) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.durata = durata;
        this.luogo = luogo;
        this.disponibile = disponibile;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescrizione() { return descrizione; }
    public String getData() { return data; }
    public int getDurata() { return durata; }
    public String getLuogo() { return luogo; }
    public boolean isDisponibile() { return disponibile; }

    public void setDisponibile(boolean disponibile) { this.disponibile = disponibile; }
}
