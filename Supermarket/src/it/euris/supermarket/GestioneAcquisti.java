package it.euris.supermarket;

import it.euris.supermarket.eccezioni.ProdottoNonTrovatoExceprion;
import it.euris.supermarket.eccezioni.QuantitaProdottoNonPresenteException;
import it.euris.supermarket.eccezioni.SupermercatoNonTrovatoException;

import java.util.ArrayList;
import java.util.List;

public class GestioneAcquisti {

    //private List<Supermercato> supermercatoList; //non serve
    //private List<Prodotto> carrello = new ArrayList<>();
    private String nomeUtente; //idUtente

    private GestioneSupermercati gestioneSupermercati;
    private SingletonCarrello carrello;

    public GestioneAcquisti(SingletonCarrello carrello,GestioneSupermercati gestioneSupermercati, String nomeUtente) {
        //this.supermercatoList = supermercatoList;
        this.carrello = carrello;
        this.nomeUtente = nomeUtente;
        this.gestioneSupermercati = gestioneSupermercati;
    }

    public void addProdottoCarrello(String nomeSupermercato, String nomeProdotto, int quantita)
            throws SupermercatoNonTrovatoException, ProdottoNonTrovatoExceprion, QuantitaProdottoNonPresenteException {

        Prodotto p = gestioneSupermercati.cercaProdottoinUnSupermercato(nomeProdotto, nomeSupermercato);
        int quantitaDisp = p.getQuantita();
        if (quantitaDisp - quantita >= 0) {
            Prodotto p_toAdd = new Prodotto(p.getName(), p.getPrezzo(), quantita, p.getReparto());
            p_toAdd.setSupermercato(p.getSupermercato());
            //carrello.add(p_toAdd);
            carrello.addToArray(p_toAdd);
            p.setQuantita(quantitaDisp - quantita);
        } else {
            throw new QuantitaProdottoNonPresenteException("Quantità non presente");
        }
    }

    public void rimuoviProdottoCarrello(String nomeProdotto) throws SupermercatoNonTrovatoException, ProdottoNonTrovatoExceprion {
        if (carrello.getCarrello().stream().anyMatch(prodotto -> prodotto.getName().equals(nomeProdotto))) {
            Prodotto p_toRemove = carrello.getCarrello().stream().filter(prodotto -> prodotto.getName().equals(nomeProdotto))
                    .findFirst().get();
            System.out.println(p_toRemove.getSupermercato());
            Prodotto p_orig = gestioneSupermercati.cercaProdottoinUnSupermercato(nomeProdotto, p_toRemove.getSupermercato().getName());
            p_orig.setQuantita(p_toRemove.getQuantita() + p_toRemove.getQuantita());
            //carrello.remove(p_toRemove);
            carrello.removeFromArray(p_toRemove);

        } else {
            System.out.println("Prodotto non presente nel carrello");
        }
    }

   // public void stampaCarrello() {        carrello.stream().forEach(prodotto -> System.out.println(prodotto.toString()));}

    public void stampaCarrello(){carrello.getCarrello().stream().forEach(prodotto -> System.out.println(prodotto.toString()));}

    public void acquistaeStampaCarrello() {
        int totale = 0;
        double prezzo_finale = 0;
        for (Prodotto prodotto : carrello.getCarrello()) {
            totale = totale + prodotto.getQuantita();
            prezzo_finale = prezzo_finale + prodotto.getQuantita() * prodotto.getPrezzo();
        }
        stampaCarrello();
        System.out.println("Acquisto completato: \n" +
                "articoli totali: " + totale + ",\n" +
                "prezzo totale:" + prezzo_finale + "€"
        );
    }
}
