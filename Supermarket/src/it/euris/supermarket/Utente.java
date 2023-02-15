package it.euris.supermarket;

import java.util.Scanner;

public class Utente {

    String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    public Boolean opzioniUtente() {

        System.out.println("Ciao" + this.nome + "digita cosa vuoi fare tra queste azioni: \n" +
                "1 se vuoi cercare un prodotto o reparto, \n" +
                "2 se vuoi acquistare un prodotto, \n " +
                "3 se vuoi completare gli acquisti, \n" +
                "4 se vuoi uscire.");
        Scanner input = new Scanner(System.in);
        Integer choice = input.nextInt();
        switch (choice) {
            case 1:

                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return false;
            default:
                System.out.println("Comando non valido");
                return true;

        }
    }
}
