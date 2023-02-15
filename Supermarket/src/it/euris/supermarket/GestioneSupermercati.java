package it.euris.supermarket;

import it.euris.supermarket.eccezioni.ProdottoNonTrovatoExceprion;
import it.euris.supermarket.eccezioni.SupermercatoNonTrovatoException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestioneSupermercati {

    List<Supermercato> supermercatoList;

    public GestioneSupermercati(List<Supermercato> supermercatoList) {
        this.supermercatoList = supermercatoList;
    }

    // 1) RICERCARE UN PRODOTTO E VEDERE IN QUALI SUPERMERCATI è PRESENTE
    public List<Supermercato> cercaProdottoinSupermercati(String nomeProdotto) {
        return supermercatoList.stream().filter(supermercato -> supermercato.getProdottoList()
                .stream().anyMatch(prodotto -> prodotto.getName().equals(nomeProdotto))).collect(Collectors.toList());
    }

    // cerca se esiste un supermercato altrimenti lancia eccezione
    public Supermercato cercaSeEsisteUnSupermercatoPerNome(String nomeSupermercato) throws SupermercatoNonTrovatoException {
        return supermercatoList.stream()
                .filter(supermercato -> supermercato.getName().equals(nomeSupermercato)).findAny()
                .orElseThrow(() -> new SupermercatoNonTrovatoException("Non esiste il supermercato"));
    }

    // 1.1) RICERCARE UN PRODOTTO IN UN CERTO SUPERMERCATO
    public Prodotto cercaProdottoinUnSupermercato(String nomeProdotto, String nomeSupermercato)
            throws SupermercatoNonTrovatoException, ProdottoNonTrovatoExceprion {

        Supermercato supermercato = cercaSeEsisteUnSupermercatoPerNome(nomeSupermercato);
        return supermercato.getProdottoList().stream().filter(prodotto -> prodotto.getName().equals(nomeProdotto))
                .findAny().orElseThrow(() -> new ProdottoNonTrovatoExceprion("Non esiste il prodotto"));

    }

    //1.2) STAMPARE TUTTI I PRODOTTI PRESENTI IN UN CERTO SUPERMERCATO
    public void stampaListaProdottiDiUnSupermercato(String nomeSupermercato) throws SupermercatoNonTrovatoException {
        /*Stream<Object> objectStream = supermercatoList.stream()
                .filter(supermercato -> supermercato.getName().equals(nomeSupermercato))
                .flatMap(supermercato -> supermercato.getProdottoList().stream().forEach(Object::toString));*/
        Supermercato supermercato = cercaSeEsisteUnSupermercatoPerNome(nomeSupermercato);
        supermercato.getProdottoList().stream().forEach(prodotto -> System.out.println(prodotto.toString()));
        /*for (Prodotto prodotto : supermercato.getProdottoList()){
            System.out.println(prodotto);
        }*/
    }

    //1.3) RICERCARE SE UN REPARTO è PRESENTE IN UN CERTO SUPERMERCATO
    public boolean cercaSeUnRepartoePresenteInUnSupermercato(String tipoReparto, String nomeSupermercato)
            throws SupermercatoNonTrovatoException {
        Supermercato supermercato = cercaSeEsisteUnSupermercatoPerNome(nomeSupermercato);
        //.name() perché sono due tipi diversi
        return supermercato.getRepartoList().stream().anyMatch(reparto -> reparto.getTipoReparto().name().equals(tipoReparto));
    }


    //USARE TOSTRING() PER STAMPARE LE INFO DEI PRODOTTI


}
