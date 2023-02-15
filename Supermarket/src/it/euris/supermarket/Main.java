package it.euris.supermarket;

import it.euris.supermarket.eccezioni.ProdottoNonTrovatoExceprion;
import it.euris.supermarket.eccezioni.QuantitaProdottoNonPresenteException;
import it.euris.supermarket.eccezioni.SupermercatoNonTrovatoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //michael.cauduro.dev@gmail.com
    public static void main(String[] args) {
        /*
            CREARE UN'APPLICAZIONE CHE POSSA GESTIRE UNA LISTA DI SUPERMARKET
            SUPERMERCATI DIVISI IN REPARTI -> OGNI REPARTO HA UNA LISTA DI PRODOTTI

            UTENTE
                1) RICERCARE UN PRODOTTO E VEDERE IN QUALI SUPERMERCATI è PRESENTE
                    1.1) RICERCARE UN PRODOTTO IN UN CERTO SUPERMERCATO
                    1.2) STAMPARE TUTTI I PRODOTTI PRESENTI IN UN CERTO SUPERMERCATO
                    1.3) RICERCARE SE UN REPARTO è PRESENTE IN UN CERTO SUPERMERCATO
                    USARE TOSTRING() PER STAMPARE LE INFO DEI PRODOTTI

                2) ACQUISTARE QUEL PRODOTTO DATA UNA CERTA QUANTITà (1 UNITà)
                3) CARRELLO --> L'UTENTE PUò STAMPARE E VEDERE IL SUO CARRELLO
                4) PUò RIMUOVERE UNO O PIù PRODOTTI
                5) CHECKOUT DEL CARRELLO -> STAMPA LISTA PRODOTTI + MOSTRO TOTALE DEI PRODOTTI

         */
        Supermercato s1 = new Supermercato("Despar");
        Supermercato s2 = new Supermercato("Coop");
        Reparto<Prodotto> r1 = new Reparto("Surgelati", TipoReparto.SURGELATI);
        Reparto<Prodotto> r2 = new Reparto("Frutta", TipoReparto.FRUTTAVERDURA);
        Reparto<Prodotto> r3 = new Reparto("Latticini", TipoReparto.FRIGO);
        Reparto<Prodotto> r4 = new Reparto("Latticini", TipoReparto.FRIGO);
        Prodotto p1 = new Prodotto("Latte", 1, 100, r3);
        Prodotto p2 = new Prodotto("Latte", 1.5, 75, r4);

        List<Supermercato> supermercatoList = new ArrayList<>();
        supermercatoList.add(s1);
        supermercatoList.add(s2);

        List<Reparto> repartoList1 = new ArrayList<>();
        List<Reparto> repartoList2 = new ArrayList<>();
        repartoList1.add(r1);
        repartoList1.add(r3);
        repartoList2.add(r2);
        repartoList2.add(r4);

        List<Prodotto> prodottoList1 = new ArrayList<>();
        prodottoList1.add(p1);
        List<Prodotto> prodottoList2 = new ArrayList<>();
        prodottoList2.add(p2);

        s1.setProdottoList(prodottoList1);
        s2.setProdottoList(prodottoList2);

        r3.setProdottoList(prodottoList1);
        r4.setProdottoList(prodottoList2);

        s1.setRepartoList(repartoList1);
        s2.setRepartoList(repartoList2);

        for (Prodotto p :prodottoList1){
            p.setSupermercato(s1);
        }
        for(Prodotto p:prodottoList2){
            p.setSupermercato(s2);
        }

        GestioneSupermercati gestioneSupermercati = new GestioneSupermercati(supermercatoList);

        Boolean login = true;
        Boolean acquisti;
        while (login) {
            System.out.println("Digita il nome utente");
            Scanner input = new Scanner(System.in);
            String name = "Giulia";// input.nextLine();
            //GestioneAcquisti gestioneAcquisti = new GestioneAcquisti(gestioneSupermercati, name);
            SingletonCarrello singletonCarrello = SingletonCarrello.getInstance();
            GestioneAcquisti gestioneAcquisti = new GestioneAcquisti(singletonCarrello,gestioneSupermercati, name);


            //GestioneAcquisti gestioneAcquisti.
            acquisti = true;
            while (acquisti) {
                System.out.println("Ciao " + name + " digita cosa vuoi fare tra queste azioni: \n" +
                        "1 RICERCARE UN PRODOTTO E VEDERE IN QUALI SUPERMERCATI è PRESENTE, \n" +
                        "1.1 RICERCARE UN PRODOTTO IN UN CERTO SUPERMERCATO, \n" +
                        "1.2 STAMPARE TUTTI I PRODOTTI PRESENTI IN UN CERTO SUPERMERCATO, \n" +
                        "1.3 RICERCARE SE UN REPARTO è PRESENTE IN UN CERTO SUPERMERCATO, \n" +
                        "1.4 ACCEDERE AL CARRELLO \n" +
                        "EXIT se vuoi uscire.");

                String choice = "1.4"; //input.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("Digita il prodotto che vuoi cercare:");
                        String prodotto = input.nextLine();
                        gestioneSupermercati.cercaProdottoinSupermercati(prodotto)
                                .forEach(supermercato -> System.out.println(supermercato.toString()));
                        break;
                    case "1.1":
                        System.out.println("Digita il prodotto e il supermercato che vuoi cercare separati da - :");
                        String[] tokens = input.nextLine().split("-");
                        try {
                            System.out.println(gestioneSupermercati.cercaProdottoinUnSupermercato(tokens[0], tokens[1]));
                        } catch (SupermercatoNonTrovatoException supermercatoNonTrovatoException) {
                            System.out.println(supermercatoNonTrovatoException.getMessage() +" "+ tokens[1]);
                        } catch (ProdottoNonTrovatoExceprion prodottoNonTrovatoExceprion) {
                            System.out.println(prodottoNonTrovatoExceprion.getMessage() +" "+ tokens[0]);
                        }
                        break;
                    case "1.2":
                        System.out.println("Digita il nome del supermercato");
                        String supermercato = input.nextLine();
                        try {
                            gestioneSupermercati.stampaListaProdottiDiUnSupermercato(supermercato);
                        } catch (SupermercatoNonTrovatoException supermercatoNonTrovatoException) {
                            System.out.println(supermercatoNonTrovatoException.getMessage()+" " + supermercato);
                        }
                        break;
                    case "1.3":
                        System.out.println("Digita il reparto e il supermercato che vuoi cercare separati da - :");
                        tokens = input.nextLine().split("-");
                        try {
                            if (gestioneSupermercati.cercaSeUnRepartoePresenteInUnSupermercato(tokens[0], tokens[1])) {
                                System.out.println("Il reparto " + tokens[0] + " è presente nel supermercato " + tokens[1]);
                            } else {
                                System.out.println("Il reparto " + tokens[0] + " non è presente nel supermercato " + tokens[1]);
                            }
                        } catch (SupermercatoNonTrovatoException supermercatoNonTrovatoException) {
                            System.out.println(supermercatoNonTrovatoException.getMessage()+" " + tokens[1]);
                        }
                        break;
                    case "1.4":
                        System.out.println("Digita: " +
                                "2 Se vuoi aggiungere un prodotto al carrello, \n" +
                                "3 STAMPARE IL CARRELLO, \n" +
                                "4 RIMUOVERE PRODOTTI DAL CARRELLO \n" +
                                "5 CHECKOUT DEL CARRELLO -> STAMPA LISTA PRODOTTI + MOSTRO TOTALE DEI PRODOTTI  \n");
                        String choice2 = input.nextLine();
                        switch (choice2) {
                            case "2":
                                System.out.println("Digita il supermercato, il prodotto e la quantità di esso che vuoi comprare" +
                                        "separati da - :");
                                tokens = input.nextLine().split("-");
                                try {
                                    gestioneAcquisti.addProdottoCarrello(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                                    //gestioneAcquisti.addProdottoCarrello("Despar","Latte",5);
                                } catch (SupermercatoNonTrovatoException supermercatoNonTrovatoException) {
                                    System.out.println(supermercatoNonTrovatoException.getMessage());
                                } catch (ProdottoNonTrovatoExceprion prodottoNonTrovatoExceprion) {
                                    System.out.println(prodottoNonTrovatoExceprion.getMessage());
                                } catch (QuantitaProdottoNonPresenteException quantitaProdottoNonPresenteException) {
                                    System.out.println(quantitaProdottoNonPresenteException.getMessage());
                                }
                                break;
                            case "3":
                                System.out.println("Carrello:");
                                gestioneAcquisti.stampaCarrello();
                                break;
                            case "4":
                                //nel caso in cui ci siano due prodotti con lo stesso nome toglie il primo
                                System.out.println("Digita il nome del prodotto che vuoi eliminare dal carrello");
                                prodotto = input.nextLine();
                                try {
                                    gestioneAcquisti.rimuoviProdottoCarrello(prodotto);
                                } catch (SupermercatoNonTrovatoException supermercatoNonTrovatoException) {
                                    System.out.println(supermercatoNonTrovatoException.getMessage());
                                } catch (ProdottoNonTrovatoExceprion prodottoNonTrovatoExceprion) {
                                    System.out.println(prodottoNonTrovatoExceprion.getMessage() + prodotto);
                                }
                                break;
                            case "5":
                                gestioneAcquisti.acquistaeStampaCarrello();
                                //Stampare il carrello finale ed uscire
                                acquisti = false;
                                break;
                            default:
                                System.out.println("Comando non valido");
                                break;
                        }
                        break;
                    case "EXIT":
                        //acquisti = false;
                        login = false;
                        break;
                    default:
                        System.out.println("Comando non valido");
                        break;
                }
            }
        }
    }
}
