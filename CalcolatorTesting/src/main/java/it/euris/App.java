package it.euris;
import it.euris.exceptions.CalculatorException;
public class App {

    public static void main(String[] args) {


        Calcolatrice calcolatrice = new Calcolatrice();
        /*TEST RELATIVO ALLA SOMMA*/
        //TEST 1
        Integer somma = calcolatrice.add(1, 1);
        boolean testResult = somma == 2;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");
        //TEST 2
        somma = calcolatrice.add(4, 5);
        testResult = somma != 2;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");

        /*TEST RELATIVO ALLA SOTTRAZIONE*/
        //TEST 1
        Integer sottrazione = calcolatrice.sub(1, 1);
        testResult = sottrazione == 0;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");
        //TEST 2
        sottrazione = calcolatrice.sub(4, 5);
        testResult = sottrazione != 2;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");

        /*TEST RELATIVO ALLA MOLTIPLICAZIONE*/
        //TEST 1
        Integer moltiplicazione = calcolatrice.mul(1, 1);
        testResult = moltiplicazione == 1;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");
        //TEST 2
        moltiplicazione = calcolatrice.mul(4, 5);
        testResult = moltiplicazione != 2;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");

        /*TEST RELATIVO ALLA DIVISIONE */
        //TEST 1
        try{
        Integer divisione = calcolatrice.div(1, 1);
        testResult = divisione == 1;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");
        //TEST 2
        divisione = calcolatrice.div(4, 0);
        if (divisione!=null)
            testResult=divisione!=20;
        else testResult=true;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");
    }
        catch (CalculatorException ce) {
        System.out.println(ce.getDescription());
    }

    }
}
