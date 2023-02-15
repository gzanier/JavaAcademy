package it.euris.supermarket;

import java.util.List;

public class Supermercato {

    private String name;

    private List<Reparto> repartoList;
    private List<Prodotto> prodottoList;


    public Supermercato(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reparto> getRepartoList() {
        return repartoList;
    }

    public void setRepartoList(List<Reparto> repartoList) {
        this.repartoList = repartoList;
    }

    public List<Prodotto> getProdottoList() {
        return prodottoList;
    }

    public void setProdottoList(List<Prodotto> prodottoList) {
        this.prodottoList = prodottoList;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
