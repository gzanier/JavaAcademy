package it.euris.supermarket;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.List;

public class Reparto<P> {
    private String nome;
    private TipoReparto tipoReparto;
    private List<P> prodottoList;

    public Reparto(String nome, TipoReparto tipoReparto) {
        this.nome = nome;
        this.tipoReparto = tipoReparto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoReparto getTipoReparto() {
        return tipoReparto;
    }

    public void setTipoReparto(TipoReparto tipoReparto) {
        this.tipoReparto = tipoReparto;
    }

    public List<P> getProdottoList() {
        return prodottoList;
    }

    public void setProdottoList(List<P> prodottoList) {
        this.prodottoList = prodottoList;
    }
    public String toString() {
        return this.getNome();
    }

    /*public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Reparto)) return true; }*/
}
