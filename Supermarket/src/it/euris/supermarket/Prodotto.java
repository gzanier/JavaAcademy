package it.euris.supermarket;

public class Prodotto {

    private String name;
    private double prezzo;

    private int quantita;

    private Reparto reparto;

    private Supermercato supermercato;

    public Prodotto(String name, double prezzo, int quantita,Reparto reparto) {
        this.name = name;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.reparto = reparto;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Supermercato getSupermercato() {
        return supermercato;
    }

    public void setSupermercato(Supermercato supermercato) {
        this.supermercato = supermercato;
    }

    @Override
    public String toString() {
        String print;
        print = "Prodotto: " + this.getName() + ",\n" +
                "quantità: " +this.getQuantita() +",\n" +
                "prezzo: "+ this.getPrezzo()+"€,\n" +
                "reparto: " + this.getReparto()+".\n"+
                "---------------------------------------\n";
        return print;
    }

}
