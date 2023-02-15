package it.euris.supermarket;

import java.util.ArrayList;
import java.util.List;

public class SingletonCarrello {

    private static SingletonCarrello instance;

    private List<Prodotto> carrello = null;
    public static SingletonCarrello getInstance() {
        if (instance == null) {
            instance = new SingletonCarrello();
        }
        return instance;
    }
    private SingletonCarrello() {
        carrello = new ArrayList<>();
    }

    public List<Prodotto> getCarrello(){
        return this.carrello;
    }
    public void addToArray(Prodotto prodotto){
        carrello.add(prodotto);
    }
    public void removeFromArray(Prodotto prodotto){
        carrello.remove(prodotto);
    }


    public void log(String log) {
        System.out.println(log);
    }
}
